package net.rebel459.legacies_and_legends.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MaceItem;
import net.minecraft.world.item.component.CustomModelData;
import net.minecraft.world.item.component.UseCooldown;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BubbleColumnBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.rebel459.legacies_and_legends.block.WandPlatformBlock;
import net.rebel459.legacies_and_legends.event.ServerEvents;
import net.rebel459.legacies_and_legends.registry.LaLBlocks;
import net.rebel459.legacies_and_legends.registry.LaLDataComponents;
import net.rebel459.legacies_and_legends.registry.LaLMobEffects;
import net.rebel459.legacies_and_legends.sound.LaLSounds;
import net.rebel459.legacies_and_legends.util.Gem;
import net.rebel459.legacies_and_legends.util.PlatformInterface;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Unique;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class WandItem extends Item {

    public WandItem(Properties properties) {
        super(properties);
    }

    public static boolean hasGems(ItemStack stack) {
        checkComponents(stack);
        return stack.has(LaLDataComponents.WAND_SLOTS.get()) && (stack.get(LaLDataComponents.WAND_SLOTS.get()).primary() != Gem.EMPTY || stack.get(LaLDataComponents.WAND_SLOTS.get()).secondary() != Gem.EMPTY);
    }

    public static Gem.Slots getGems(ItemStack stack) {
        checkComponents(stack);
        return stack.get(LaLDataComponents.WAND_SLOTS.get());
    }

    public static boolean hasGem(Gem.Slots gems, Gem gem) {
        return gems.primary() == gem || gems.secondary() == gem;
    }

    public static void setGems(ItemStack stack, Gem primary, Gem secondary) {
        checkComponents(stack);
        var currentGems = stack.get(LaLDataComponents.WAND_SLOTS.get());
        if (primary == null) primary = currentGems.primary();
        if (secondary == null) secondary = currentGems.secondary();
        boolean currentState = Boolean.TRUE.equals(stack.get(DataComponents.CUSTOM_MODEL_DATA).getBoolean(0));
        String name = primary.getSerializedName();
        if (primary == Gem.EMPTY) name = secondary.getSerializedName();
        stack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(List.of(), List.of(currentState), List.of(name), List.of()));
        stack.set(LaLDataComponents.WAND_SLOTS.get(), new Gem.Slots(primary, secondary));
    }

    private static void checkComponents(ItemStack stack) {
        if (!stack.has(LaLDataComponents.WAND_SLOTS.get())) {
            boolean currentState = Boolean.TRUE.equals(stack.get(DataComponents.CUSTOM_MODEL_DATA).getBoolean(0));
            stack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(List.of(), List.of(currentState), List.of(Gem.SAPPHIRE.getSerializedName()), List.of()));
            stack.set(LaLDataComponents.WAND_SLOTS.get(), new Gem.Slots(Gem.SAPPHIRE, Gem.EMPTY));
        }
    }

    public static float getCooldown(Gem.Slots gems) {
        float cooldown = 2F;
        if (hasGem(gems, Gem.METEORITE)) cooldown += 2F;
        if (hasGem(gems, Gem.BREEZE)) cooldown += 8F;
        if (hasGem(gems, Gem.NEBULITE)) cooldown += 10F;
        if (hasGem(gems, Gem.TIMELOST)) cooldown += 6F;
        if (hasGem(gems, Gem.SAPPHIRE)) cooldown -= 2F;
        cooldown = Math.max(cooldown, 1F);
        return cooldown;
    }

    public static boolean canUseWandWithoutPlatform(Gem.Slots gems) {
        return hasGem(gems, Gem.BREEZE);
    }

    private static HashMap<BlockPos, BlockState> getSurroundingBlocks(Level level, BlockPos pos, int radius, boolean grounded) {
        HashMap<BlockPos, BlockState> surroundingBlocks = new HashMap<>();

        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                if (x == 0 && z == 0) continue;

                BlockPos basePos = pos.offset(x, 0, z);

                if (!grounded && level.getBlockState(basePos).canBeReplaced()) {
                    BlockState oldState = level.getBlockState(basePos);
                    if (oldState.getFluidState().isEmpty()) oldState = Blocks.AIR.defaultBlockState();
                    surroundingBlocks.put(basePos, oldState);
                    continue;
                }

                for (int drop = -1; drop <= 2; drop++) {
                    BlockPos candidate = basePos.offset(0, -drop, 0);
                    BlockState state = level.getBlockState(candidate);
                    BlockState ground = level.getBlockState(candidate.below());

                    if (!state.blocksMotion() && ground.blocksMotion() && state.canBeReplaced()) {
                        if (state.getFluidState().isEmpty()) state = Blocks.AIR.defaultBlockState();
                        surroundingBlocks.put(candidate, state);
                        break;
                    }
                }
            }
        }

        return surroundingBlocks;
    }

    private static HashMap<BlockPos, BlockState> getTargetPositions(Level level, BlockPos pos, Gem.Slots gems) {
        if (gems.secondary() == Gem.METEORITE) return getSurroundingBlocks(level, pos, 2, true);
        if (gems.primary() == Gem.METEORITE) return getSurroundingBlocks(level, pos, 4, true);
        if (gems.primary() == Gem.ICE) return getSurroundingBlocks(level, pos, 2, false);
        if (gems.secondary() == Gem.ICE) return getSurroundingBlocks(level, pos, 1, false);
        if (gems.primary() == Gem.RUBY) return getSurroundingBlocks(level, pos, 1, false);
        return new HashMap<>();
    }

    private static BlockState getPlacedBlock(ItemStack stack, boolean useBottomSlab, boolean useWaterloggedDoubleSlab) {
        if (hasGem(getGems(stack), Gem.METEORITE)) return Blocks.FIRE.defaultBlockState().setValue(WandPlatformBlock.CANCEL_TICK, true);
        return WandPlatformBlock.getSummonedState(stack, useBottomSlab, useWaterloggedDoubleSlab);
    }

    private static boolean isUnderwaterPlacement(Level level, BlockPos pos) {
        return level.getFluidState(pos).is(FluidTags.WATER) || level.getFluidState(pos.above()).is(FluidTags.WATER);
    }

    private void handlePrismarineMaterial(Level level, BlockPos pos, PlatformInterface platform, boolean useBottomSlab, boolean underwaterPlacement, boolean createBubbleColumns) {
        BlockState targetState = level.getBlockState(pos);
        if (!targetState.hasProperty(BlockStateProperties.WATERLOGGED)) return;

        HashMap<BlockPos, BlockState> states = platform.getOldStates();

        if (useBottomSlab && underwaterPlacement) {
            if (targetState.getFluidState().isEmpty()) {
                states.putIfAbsent(pos, Blocks.AIR.defaultBlockState());
            }

            targetState = targetState.setValue(BlockStateProperties.WATERLOGGED, true);
            level.setBlock(pos, targetState, Block.UPDATE_ALL);
        }

        BlockPos abovePos = pos.above();
        BlockState aboveState = level.getBlockState(abovePos);
        if (underwaterPlacement && aboveState.canBeReplaced()) {
            states.putIfAbsent(abovePos, aboveState);
            level.setBlock(abovePos, Blocks.WATER.defaultBlockState(), Block.UPDATE_ALL);
        }

        if (!createBubbleColumns) return;

        for (int height = 1; height <= 3; height++) {
            BlockPos columnPos = pos.above(height);
            BlockState columnState = level.getBlockState(columnPos);
            if (!columnState.getFluidState().is(FluidTags.WATER)) {
                break;
            }

            states.putIfAbsent(columnPos, columnState);
            level.setBlock(
                    columnPos,
                    Blocks.BUBBLE_COLUMN.defaultBlockState().setValue(BubbleColumnBlock.DRAG_DOWN, true),
                    Block.UPDATE_ALL
            );
        }
    }

    private static boolean tryTeleport(Player player, double distance) {
        Vec3 start = player.position();
        Vec3 look = player.getLookAngle().normalize();
        Vec3 end = start.add(look.scale(distance));

        return tryTeleport(player, distance, end);
    }

    private static boolean tryTeleport(Player player, double distance, Vec3 end) {
        Vec3 start = player.position();
        Vec3 delta = end.subtract(start);

        if (delta.lengthSqr() > distance * distance) {
            end = start.add(delta.normalize().scale(distance));
        }

        BlockHitResult hitResult = player.level().clip(new ClipContext(
                start,
                end,
                ClipContext.Block.COLLIDER,
                ClipContext.Fluid.NONE,
                player
        ));

        if (hitResult.getType() != HitResult.Type.MISS) {
            return false;
        }

        BlockPos targetPos = BlockPos.containing(end);
        BlockState feetState = player.level().getBlockState(targetPos);
        BlockState headState = player.level().getBlockState(targetPos.above());

        if (feetState.blocksMotion() || headState.blocksMotion()) {
            return false;
        }

        player.teleportTo(end.x, end.y, end.z);
        return true;
    }

    @Override
    public @NotNull InteractionResult use(@NotNull Level level, @NotNull Player player, InteractionHand hand) {
        if (!(player instanceof PlatformInterface platformInterface)) return InteractionResult.PASS;

        ItemStack stack = player.getItemInHand(hand);
        Gem.Slots gems = getGems(stack);
        if (gems.primary() == Gem.EMPTY && gems.secondary() == Gem.EMPTY) return InteractionResult.FAIL;

        Vec3 playerPos = player.position();
        BlockPos newPlatformPos = player.blockPosition();
        if (hasGem(gems, Gem.RUBY)) {
            Vec3 eyePos = player.getEyePosition();
            Vec3 reachPos = eyePos.add(player.getViewVector(1.0F).scale(player.blockInteractionRange()));
            BlockHitResult hitResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.NONE);

            newPlatformPos = hitResult.getType() == HitResult.Type.BLOCK ? hitResult.getBlockPos().relative(hitResult.getDirection()) : BlockPos.containing(reachPos);
        }

        boolean teleported = false;
        if (!platformInterface.getPlatformSummoned() && hasGem(gems, Gem.NEBULITE)) {
            double distance = 3D;
            if (gems.primary() == Gem.NEBULITE) distance += 3D;
            if (hasGem(gems, Gem.RUBY)) {
                BlockPos rubyPlatformPos = level.getBlockState(newPlatformPos).isAir() ? newPlatformPos : newPlatformPos.below();
                Vec3 targetPos = Vec3.atBottomCenterOf(rubyPlatformPos.above());
                teleported = tryTeleport(player, distance, targetPos);
            } else {
                teleported = tryTeleport(player, distance);
                if (teleported) {
                    playerPos = player.position();
                    newPlatformPos = player.blockPosition();
                }
            }

            if (teleported) {
                if (gems.secondary() == Gem.NEBULITE && level instanceof ServerLevel serverLevel) player.hurtServer(serverLevel, player.damageSources().enderPearl(), 1F);
            }
        }

        boolean useBottomSlab = false;
        if (playerPos.y() - newPlatformPos.getY() >= 0.5D && level.getBlockState(newPlatformPos).isAir()) {
            useBottomSlab = true;
        } else {
            newPlatformPos = newPlatformPos.below();
        }

        boolean useWaterloggedDoubleSlab = hasGem(gems, Gem.PRISMARINE) && level.getBlockState(newPlatformPos).getFluidState().is(FluidTags.WATER);
        boolean canPlacePlatform = (useBottomSlab || level.getBlockState(newPlatformPos).isAir() || useWaterloggedDoubleSlab) && !platformInterface.getPlatformSummoned() && !player.onGround();
        HashMap<BlockPos, BlockState> targetPositions = getTargetPositions(level, newPlatformPos, gems);
        boolean hasStandaloneAbility = canUseWandWithoutPlatform(gems) || teleported || (hasGem(gems, Gem.METEORITE) && !targetPositions.isEmpty());
        boolean canSummonWithoutMainPlatform = !canPlacePlatform
                && !platformInterface.getPlatformSummoned()
                && player.onGround()
                && hasStandaloneAbility;
        boolean shouldSummon = canPlacePlatform || canSummonWithoutMainPlatform;

        if (shouldSummon && !platformInterface.getPlatformSummoned()) {
            platformInterface.lal$setLastPlatformPos(level, newPlatformPos);

            prePlatformSummoned(level, player, stack, gems);
            platformInterface.setOldStates(targetPositions);
            List<BlockPos> validBlocks = platformInterface.getOldStates().keySet().stream().toList();
            List<BlockPos> placedBlocks = new ArrayList<>();
            if (canPlacePlatform) {
                placedBlocks.add(newPlatformPos);
            }
            placedBlocks.addAll(validBlocks);
            Set<BlockPos> underwaterBlocks = new HashSet<>();
            if (hasGem(gems, Gem.PRISMARINE)) {
                for (BlockPos placedBlock : placedBlocks) {
                    if (isUnderwaterPlacement(level, placedBlock)) {
                        underwaterBlocks.add(placedBlock);
                    }
                }
            }

            if (canPlacePlatform) {
                level.setBlock(
                        newPlatformPos,
                        WandPlatformBlock.getSummonedState(stack, useBottomSlab, useWaterloggedDoubleSlab),
                        Block.UPDATE_ALL
                );
            }

            for (BlockPos targetPos : validBlocks) {
                level.setBlock(
                        targetPos,
                        getPlacedBlock(stack, useBottomSlab, useWaterloggedDoubleSlab),
                        Block.UPDATE_ALL
                );
            }

            if (hasGem(gems, Gem.PRISMARINE)) {
                boolean createBubbleColumns = gems.primary() == Gem.PRISMARINE;
                for (BlockPos targetPos : placedBlocks) {
                    boolean underwaterPlacement = underwaterBlocks.contains(targetPos);
                    handlePrismarineMaterial(level, targetPos, platformInterface, useBottomSlab, underwaterPlacement, createBubbleColumns && underwaterPlacement);
                }
            }

            platformInterface.setPlatformSummoned(true);

            player.playSound(LaLSounds.WAND_SUMMON.get());

            hurtAndBreak(stack, gems, player, hand);

            stack.applyComponents(DataComponentPatch.builder()
                    .set(DataComponents.USE_COOLDOWN, new UseCooldown(getCooldown(gems)))
                    .build()
            );

            return InteractionResult.SUCCESS;
        } else {
            InteractionResult result = removePlatforms(level, player);
            if (result == InteractionResult.SUCCESS) {
                postPlatformRecalled(level, player, stack, gems);

                stack.applyComponents(DataComponentPatch.builder()
                        .set(DataComponents.USE_COOLDOWN, new UseCooldown(0.5F))
                        .build()
                );

                return result;
            }

        }

        return InteractionResult.FAIL;
    }

    public static void hurtAndBreak(ItemStack stack, Gem.Slots gems, Player player, InteractionHand hand) {
        if (gems.primary() == Gem.OBSIDIAN && player.getRandom().nextBoolean()) return;
        stack.hurtAndBreak(1, player, hand);
    }

    public static InteractionResult removePlatforms(Level level, Player player) {
        if (!(player instanceof PlatformInterface platform)) return InteractionResult.PASS;
        Optional<GlobalPos> optionalLastPlatformPos = platform.lal$getLastPlatformPos();
        if (optionalLastPlatformPos.isPresent() && platform.getPlatformSummoned()) {
            GlobalPos lastPlatformPos = optionalLastPlatformPos.get();
            if (lastPlatformPos.dimension().equals(level.dimension())) {
                BlockPos lastPlatformBlockPos = lastPlatformPos.pos();
                player.playSound(LaLSounds.WAND_RECALL.get());
                removePlatforms(level, platform, lastPlatformBlockPos);

                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    public static void removePlatforms(Level level, PlatformInterface platform, BlockPos lastPos) {
        platform.setPlatformSummoned(false);

        List<BlockPos> validBlocks = platform.getOldStates().keySet().stream().toList();

        if (level instanceof ServerLevel serverLevel) {
            for (BlockPos targetPos : validBlocks) {
                ServerEvents.queueBlockChange(serverLevel, targetPos, platform.getOldStates().get(targetPos), 5);
            }
        }

        level.scheduleTick(lastPos, LaLBlocks.WAND_PLATFORM.get(), 5);
    }

    public static int applyBreezeKnockback(Level level, LivingEntity source, double strength) {
        level.levelEvent(2013, source.getOnPos(), 750);
        List<LivingEntity> entityList = level.getEntitiesOfClass(LivingEntity.class, source.getBoundingBox().inflate(3.5F), MaceItem.knockbackPredicate(source, source));

        int entityCount = 0;

        for (LivingEntity livingEntity : entityList) {
            Vec3 vec3 = livingEntity.position().subtract(source.position());
            double d = strength * (1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
            Vec3 vec32 = vec3.normalize().scale(d);
            if (d > (double)0.0F) {
                livingEntity.push(vec32.x, 0.7F, vec32.z);
                if (livingEntity instanceof ServerPlayer serverPlayer) {
                    serverPlayer.connection.send(new ClientboundSetEntityMotionPacket(serverPlayer));
                }
            }
            entityCount += 1;
        }

        return entityCount;
    }

    private void prePlatformSummoned(Level level, Player player, ItemStack stack, Gem.Slots gems) {
        if (hasGem(gems, Gem.BREEZE)) {
            applyBreezeKnockback(level, player, 2F);
        }
        if (player.hasEffect(LaLMobEffects.PROJECTILE_PASSTHROUGH)) {
            player.removeEffect(LaLMobEffects.PROJECTILE_PASSTHROUGH);
        }
    }
    private void postPlatformRecalled(Level level, Player player, ItemStack stack, Gem.Slots gems) {
        if (gems.primary() == Gem.BREEZE) applyBreezeKnockback(level, player, 2F);
        if (hasGem(gems, Gem.TIMELOST)) {
            ServerEvents.queuePlayerChange(player, gems, 5);
        }
    }
}
