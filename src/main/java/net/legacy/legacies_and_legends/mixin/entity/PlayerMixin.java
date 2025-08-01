package net.legacy.legacies_and_legends.mixin.entity;

import dev.emi.trinkets.api.TrinketsApi;
import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.config.LaLConfig;
import net.legacy.legacies_and_legends.entity.impl.LaLPlayerDamageInterface;
import net.legacy.legacies_and_legends.entity.impl.LaLPlayerPlatformInterface;
import net.legacy.legacies_and_legends.item.util.TotemUtil;
import net.legacy.legacies_and_legends.registry.LaLBlocks;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.legacy.legacies_and_legends.registry.LaLMobEffects;
import net.legacy.legacies_and_legends.sound.LaLSounds;
import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.portal.TeleportTransition;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(Player.class)
public abstract class PlayerMixin implements LaLPlayerPlatformInterface, LaLPlayerDamageInterface {

    @Shadow public abstract Inventory getInventory();

    @Shadow public abstract boolean isInvulnerableTo(ServerLevel level, DamageSource damageSource);

    @Unique
    private Optional<GlobalPos> lastPlatformPos = Optional.empty();

    @Unique
    private int damageTaken = 0;

    @Inject(method = "tick", at = @At(value = "TAIL"))
    private void hasAccessory(CallbackInfo ci) {
        Player player = Player.class.cast(this);
        if (LaLConstants.hasAccessory(player) && player.getTags().contains("played_equip_sound")) player.addTag("has_accessory");
        else if (player.getTags().contains("has_accessory") || player.getTags().contains("played_equip_sound")) {
            player.removeTag("has_accessory");
            player.removeTag("played_equip_sound");
        }
    }

    @Inject(method = "actuallyHurt", at = @At(value = "TAIL"))
    private void cancelTabletUse(ServerLevel level, DamageSource damageSource, float amount, CallbackInfo info) {
        Player player = Player.class.cast(this);
        if (player.getUseItem().is(LaLItemTags.TABLETS)) player.stopUsingItem();
    }

    @Inject(method = "actuallyHurt", at = @At(value = "HEAD"))
    private void damageNecklace(ServerLevel level, DamageSource damageSource, float amount, CallbackInfo info) {
        Player player = Player.class.cast(this);
        if (TrinketsApi.getTrinketComponent(player).isPresent() && LaLConstants.hasNecklace(player) && !damageSource.is(DamageTypeTags.BYPASSES_ARMOR)) player.addTag("damaged_accessory");
    }

    @Inject(method = "actuallyHurt", at = @At(value = "HEAD"))
    private void necklaceOfRegeneration(ServerLevel level, DamageSource damageSource, float amount, CallbackInfo info) {
        Player player = Player.class.cast(this);
        if (TrinketsApi.getTrinketComponent(player).isPresent() && TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.NECKLACE_OF_REGENERATION) && !player.hasEffect(MobEffects.REGENERATION)) player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100));
    }

    @Inject(method = "attack", at = @At(value = "TAIL"))
    private void ringOfStriking(Entity target, CallbackInfo ci) {
        Player player = Player.class.cast(this);
        if (TrinketsApi.getTrinketComponent(player).isPresent() && TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.RING_OF_STRIKING)) player.addTag("damaged_accessory");
    }

    @Inject(method = "hurtServer", at = @At(value = "HEAD"), cancellable = true)
    private void amuletOfObsidian(ServerLevel level, DamageSource damageSource, float amount, CallbackInfoReturnable<Boolean> cir) {
        Player player = Player.class.cast(this);
        if (TrinketsApi.getTrinketComponent(player).isPresent() && TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.AMULET_OF_OBSIDIAN) && damageSource.is(DamageTypeTags.IS_FIRE) && !this.isInvulnerableTo(level, damageSource) && !player.hasEffect(MobEffects.FIRE_RESISTANCE) && !player.fireImmune()) {
            if (player.getRemainingFireTicks() > 1) player.setRemainingFireTicks(1);
            player.addTag("amulet_repair_cooldown");
            player.addTag("damaged_amulet_of_obsidian");
            cir.setReturnValue(false);
        }
    }

    @Inject(method = "actuallyHurt", at = @At(value = "HEAD"))
    private void amuletOfAbsorption(ServerLevel level, DamageSource damageSource, float amount, CallbackInfo ci) {
        Player player = Player.class.cast(this);
        if (TrinketsApi.getTrinketComponent(player).isPresent() && TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.AMULET_OF_ABSORPTION)) {
            this.damageTaken = (int) amount;
            player.addTag("amulet_repair_cooldown");
            player.addTag("damaged_amulet_of_absorption");
        }
    }

    @Inject(
            method = "actuallyHurt",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/player/Player;setHealth(F)V"
            ),
            cancellable = true)
    private void necklaceOfResilience(ServerLevel level, DamageSource damageSource, float amount, CallbackInfo ci) {
        Player player = Player.class.cast(this);
        if (TrinketsApi.getTrinketComponent(player).isPresent() && TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.NECKLACE_OF_RESILIENCE)) {
            if (player.getHealth() > 6 && amount > player.getHealth() - 1) amount = player.getHealth() - 1;
            player.setHealth(player.getHealth() - amount);
            if (amount < 3.4028235E37F) {
                player.awardStat(Stats.DAMAGE_TAKEN, Math.round(amount * 10.0F));
            }
            player.gameEvent(GameEvent.ENTITY_DAMAGE);

            ci.cancel();
        }
    }

    @Inject(method = "hurtServer", at = @At(value = "HEAD"), cancellable = true)
    private void warpBeforeProjectile(ServerLevel level, DamageSource damageSource, float amount, CallbackInfoReturnable<Boolean> cir) {
        Player player = Player.class.cast(this);
        if (player.hasEffect(LaLMobEffects.WARPING) && damageSource.is(DamageTypeTags.IS_PROJECTILE)) {
            double d = player.getX() + (player.getRandom().nextDouble() - 0.5) * (double) 16F;
            double e = Mth.clamp(player.getY() + (player.getRandom().nextDouble() - 0.5) * (double) 16F, player.level.getMinY(), (player.level.getMinY() + player.level.getHeight() - 1));
            double f = player.getZ() + (player.getRandom().nextDouble() - 0.5) * (double) 16F;
            if (player.isPassenger()) {
                player.stopRiding();
            }


            Vec3 vec3 = player.position();
            if (player.randomTeleport(d, e, f, true)) {
                player.level.gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(player));
            }
            level.playSound(null, player.blockPosition(), LaLSounds.TABLET_TELEPORT, SoundSource.PLAYERS, 0.6F, 1F);
            player.randomTeleport(d, e, f, true);

            cir.setReturnValue(false);
        }
    }

    @Inject(method = "actuallyHurt", at = @At(value = "HEAD"))
    private void warpWhenHurt(ServerLevel level, DamageSource damageSource, float amount, CallbackInfo ci) {
        Player player = Player.class.cast(this);
        if (player.hasEffect(LaLMobEffects.WARPING) && damageSource.isDirect()) {
            double d = player.getX() + (player.getRandom().nextDouble() - 0.5) * (double) 16F;
            double e = Mth.clamp(player.getY() + (player.getRandom().nextDouble() - 0.5) * (double) 16F, player.level.getMinY(), (player.level.getMinY() + player.level.getHeight() - 1));
            double f = player.getZ() + (player.getRandom().nextDouble() - 0.5) * (double) 16F;
            if (player.isPassenger()) {
                player.stopRiding();
            }


            Vec3 vec3 = player.position();
            if (player.randomTeleport(d, e, f, true)) {
                player.level.gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(player));
            }
            level.playSound(null, player.blockPosition(), LaLSounds.TABLET_TELEPORT, SoundSource.PLAYERS, 0.6F, 1F);
            player.randomTeleport(d, e, f, true);
        }
    }

    @Inject(method = "killedEntity", at = @At(value = "TAIL"))
    private void ringOfHunting(ServerLevel level, LivingEntity entity, CallbackInfoReturnable<Boolean> cir) {
        Player player = Player.class.cast(this);
        if (TrinketsApi.getTrinketComponent(player).isPresent() && TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.RING_OF_HUNTING)) {
            player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() + 2);
            level.playSound(player, player.blockPosition(), SoundEvents.PLAYER_BURP, SoundSource.PLAYERS, 1F, 1F);
            player.addTag("damaged_accessory");
        }
    }

    @Inject(method = "actuallyHurt", at = @At(value = "TAIL"))
    private void activateTotem(ServerLevel level, DamageSource damageSource, float amount, CallbackInfo info) {
        int resurrectionRegenDuration = 600;

        Player player = Player.class.cast(this);
        if (TrinketsApi.getTrinketComponent(player).isPresent()) {
            if (TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.TOTEM_OF_TELEPORTATION) && amount >= player.getHealth()) {
                player.setHealth(1.0F);
                LaLItems.TOTEM_OF_TELEPORTATION.getDefaultInstance().get(DataComponents.DEATH_PROTECTION).applyEffects(LaLItems.TOTEM_OF_TELEPORTATION.getDefaultInstance(), player);
                TotemUtil.playTotemAnimation(LaLItems.TOTEM_OF_TELEPORTATION.getDefaultInstance(), player);
                player.awardStat(Stats.ITEM_USED.get(LaLItems.TOTEM_OF_TELEPORTATION));
                CriteriaTriggers.USED_TOTEM.trigger((ServerPlayer) player, LaLItems.TOTEM_OF_TELEPORTATION.getDefaultInstance());
                player.addTag("used_totem");
            }
            if (TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.TOTEM_OF_RESURRECTION) && amount >= player.getHealth()) {
                player.setHealth(1.0F);
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, resurrectionRegenDuration));
                TotemUtil.playTotemAnimation(LaLItems.TOTEM_OF_RESURRECTION.getDefaultInstance(), player);
                player.awardStat(Stats.ITEM_USED.get(LaLItems.TOTEM_OF_RESURRECTION));
                CriteriaTriggers.USED_TOTEM.trigger((ServerPlayer) player, LaLItems.TOTEM_OF_RESURRECTION.getDefaultInstance());
                if (player instanceof ServerPlayer serverPlayer) {
                    player.teleport(serverPlayer.findRespawnPositionAndUseSpawnBlock(false, TeleportTransition.DO_NOTHING));
                    level.playSound(null, player.blockPosition(), LaLSounds.TABLET_TELEPORT, SoundSource.PLAYERS, 0.6F, 1F);
                }
                player.addTag("used_totem");
            }
            if (LaLConfig.get.misc.accessory_of_undying && TrinketsApi.getTrinketComponent(player).get().isEquipped(Items.TOTEM_OF_UNDYING) && amount >= player.getHealth()) {
                player.setHealth(1.0F);
                Items.TOTEM_OF_UNDYING.getDefaultInstance().get(DataComponents.DEATH_PROTECTION).applyEffects(Items.TOTEM_OF_UNDYING.getDefaultInstance(), player);
                TotemUtil.playTotemAnimation(Items.TOTEM_OF_UNDYING.getDefaultInstance(), player);
                player.awardStat(Stats.ITEM_USED.get(Items.TOTEM_OF_UNDYING));
                CriteriaTriggers.USED_TOTEM.trigger((ServerPlayer) player, Items.TOTEM_OF_UNDYING.getDefaultInstance());
                player.addTag("used_totem");
            }
        }
        if ((player.getMainHandItem().is(LaLItems.TOTEM_OF_RESURRECTION) || player.getOffhandItem().is(LaLItems.TOTEM_OF_RESURRECTION)) && amount >= player.getHealth()) {
            if (player.getMainHandItem().is(LaLItems.TOTEM_OF_RESURRECTION)) {
                player.setHealth(1.0F);
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, resurrectionRegenDuration));
                TotemUtil.playTotemAnimation(LaLItems.TOTEM_OF_RESURRECTION.getDefaultInstance(), player);
                player.awardStat(Stats.ITEM_USED.get(LaLItems.TOTEM_OF_RESURRECTION));
                CriteriaTriggers.USED_TOTEM.trigger((ServerPlayer) player, LaLItems.TOTEM_OF_RESURRECTION.getDefaultInstance());
                if (player instanceof ServerPlayer serverPlayer) {
                    player.teleport(serverPlayer.findRespawnPositionAndUseSpawnBlock(false, TeleportTransition.DO_NOTHING));
                    level.playSound(null, player.blockPosition(), LaLSounds.TABLET_TELEPORT, SoundSource.PLAYERS, 0.6F, 1F);
                }
                player.getItemBySlot(EquipmentSlot.MAINHAND).copyAndClear();
            }
            else if (player.getOffhandItem().is(LaLItems.TOTEM_OF_RESURRECTION)) {
                player.setHealth(1.0F);
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, resurrectionRegenDuration));
                TotemUtil.playTotemAnimation(LaLItems.TOTEM_OF_RESURRECTION.getDefaultInstance(), player);
                player.awardStat(Stats.ITEM_USED.get(LaLItems.TOTEM_OF_RESURRECTION));
                CriteriaTriggers.USED_TOTEM.trigger((ServerPlayer) player, LaLItems.TOTEM_OF_RESURRECTION.getDefaultInstance());
                if (player instanceof ServerPlayer serverPlayer) {
                    player.teleport(serverPlayer.findRespawnPositionAndUseSpawnBlock(false, TeleportTransition.DO_NOTHING));
                    level.playSound(null, player.blockPosition(), LaLSounds.TABLET_TELEPORT, SoundSource.PLAYERS, 0.6F, 1F);
                }
                player.getItemBySlot(EquipmentSlot.OFFHAND).copyAndClear();
            }
        }
    }

    @Inject(method = "die", at = @At("HEAD"))
    public void destroyPlatformOnDeath(DamageSource damageSource, CallbackInfo info) {
        if (this.lastPlatformPos.isEmpty()) return;

        Player player = Player.class.cast(this);
        GlobalPos globalPos = this.lastPlatformPos.get();
        if (!globalPos.dimension().equals(player.level().dimension())) return;

        BlockPos pos = globalPos.pos();
        player.level().scheduleTick(pos, LaLBlocks.WAND_PLATFORM, 5);

        player.removeTag("wand_platform_summoned");
    }

    @Inject(method = "drop", at = @At("HEAD"))
    public void destroyPlatformOnDrop(ItemStack itemStack, boolean includeThrowerName, CallbackInfoReturnable<ItemEntity> cir) {
        if (this.lastPlatformPos.isEmpty() || this.getInventory().contains(LaLItems.WAND.getDefaultInstance())) return;

        Player player = Player.class.cast(this);
        GlobalPos globalPos = this.lastPlatformPos.get();
        if (!globalPos.dimension().equals(player.level().dimension())) return;

        BlockPos pos = globalPos.pos();
        player.level().scheduleTick(pos, LaLBlocks.WAND_PLATFORM, 5);

        player.removeTag("wand_platform_summoned");
    }

    @Override
    public void lal$setLastPlatformPos(@NotNull Level level, BlockPos pos) {
        this.lastPlatformPos = Optional.of(GlobalPos.of(level.dimension(), pos));
    }

    @Override
    public void lal$eraseLastPlatformPos() {
        this.lastPlatformPos = Optional.empty();
    }

    @Override
    public Optional<GlobalPos> lal$getLastPlatformPos() {
        return this.lastPlatformPos;
    }

    @Override
    public int lal$getDamageTaken() {
        return this.damageTaken;
    }

    @Inject(method = "readAdditionalSaveData", at = @At("TAIL"))
    public void readPlatformSaveData(CompoundTag tag, CallbackInfo info) {
        this.lastPlatformPos = tag.read("LalLastPlatformPos", GlobalPos.CODEC);
    }

    @Inject(method = "addAdditionalSaveData", at = @At("TAIL"))
    public void addAdditionalSaveData(CompoundTag tag, CallbackInfo info) {
        this.lastPlatformPos.ifPresent(pos -> tag.store("LalLastPlatformPos", GlobalPos.CODEC, pos));
    }
}
