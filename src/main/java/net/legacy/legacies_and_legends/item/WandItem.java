package net.legacy.legacies_and_legends.item;

import net.legacy.legacies_and_legends.block.WandPlatformBlock;
import net.legacy.legacies_and_legends.entity.impl.LaLPlayerPlatformInterface;
import net.legacy.legacies_and_legends.registry.LaLBlocks;
import net.legacy.legacies_and_legends.registry.LaLEnchantments;
import net.legacy.legacies_and_legends.sound.LaLSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomModelData;
import net.minecraft.world.item.component.UseCooldown;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class WandItem extends Item {

    public WandItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull Level level, @NotNull Player player, InteractionHand hand) {
        if (!(player instanceof LaLPlayerPlatformInterface platformInterface)) return InteractionResult.PASS;

        ItemStack stack = player.getItemInHand(hand);

        Vec3 playerPos = player.position();
        BlockPos newPlatformPos = player.blockPosition();
        boolean useBottomSlab = false;
        if (playerPos.y() - newPlatformPos.getY() >= 0.5D && level.getBlockState(newPlatformPos).isAir()) {
            useBottomSlab = true;
        } else {
            newPlatformPos = newPlatformPos.below();
        }

        if ((useBottomSlab || level.getBlockState(newPlatformPos).isAir()) && !player.getTags().contains("wand_platform_summoned") && !player.onGround()) {
            platformInterface.lal$setLastPlatformPos(level, newPlatformPos);
            level.setBlock(
                    newPlatformPos,
                    LaLBlocks.WAND_PLATFORM.defaultBlockState().setValue(WandPlatformBlock.TYPE, useBottomSlab ? SlabType.BOTTOM : SlabType.TOP),
                    Block.UPDATE_ALL
            );

            player.addTag("wand_platform_summoned");
            player.playSound(LaLSounds.WAND_SUMMON);

            stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));

            stack.applyComponents(DataComponentPatch.builder()
                    .set(DataComponents.USE_COOLDOWN, new UseCooldown(1F))
                    .build()
            );

            return InteractionResult.SUCCESS;
        } else {
            Optional<GlobalPos> optionalLastPlatformPos = platformInterface.lal$getLastPlatformPos();
            if (optionalLastPlatformPos.isPresent() && player.getTags().contains("wand_platform_summoned")) {
                GlobalPos lastPlatformPos = optionalLastPlatformPos.get();
                if (lastPlatformPos.dimension().equals(level.dimension())) {
                    BlockPos lastPlatformBlockPos = lastPlatformPos.pos();
                    if (!player.onGround() || player.getOnPos() != lastPlatformBlockPos) {
                        player.removeTag("wand_platform_summoned");
                        player.playSound(LaLSounds.WAND_RECALL);

                        level.scheduleTick(lastPlatformBlockPos, LaLBlocks.WAND_PLATFORM, 5);

                        stack.applyComponents(DataComponentPatch.builder()
                                .set(DataComponents.USE_COOLDOWN, new UseCooldown(0.5F))
                                .build()
                        );

                        return InteractionResult.SUCCESS;
                    }
                }
            }
        }

        return InteractionResult.FAIL;
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, @Nullable EquipmentSlot slot) {
        if (entity instanceof Player player && !player.getTags().contains("wand_platform_summoned")) {
            stack.applyComponents(DataComponentPatch.builder()
                    .set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(List.of(), List.of(true), List.of(), List.of()))
                    .build()
            );
        } else {
            stack.applyComponents(DataComponentPatch.builder()
                    .set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(List.of(), List.of(false), List.of(), List.of()))
                    .build()
            );
        }
    }
}
