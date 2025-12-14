package net.legacy.legacies_and_legends.mixin.entity;

import net.legacy.legacies_and_legends.config.LaLConfig;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.legacy.legacies_and_legends.registry.LaLMobEffects;
import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject(method = "dropFromLootTable(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/damagesource/DamageSource;Z)V", at = @At("TAIL"))
    public void elderGuardianLootInject(ServerLevel level, DamageSource damageSource, boolean playerKill, CallbackInfo ci) {
        LivingEntity entity = LivingEntity.class.cast(this);
        if (entity.getType() == EntityType.ELDER_GUARDIAN && LaLConfig.get.loot.trident_shard) entity.spawnAtLocation(level, LaLItems.TRIDENT_SHARD);
    }
    @Inject(method = "hurtServer", at = @At("HEAD"))
    public void frostedSpearFreeze(ServerLevel serverLevel, DamageSource damageSource, float f, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity attacked = LivingEntity.class.cast(this);
        Entity entity = damageSource.getEntity();
        if (!(entity instanceof LivingEntity attacker)) return;
        ItemStack stack = attacker.getWeaponItem();
        if (stack.is(LaLItemTags.CHILLING)) {
            float ignoredDamage = 0;
            if (stack.isEnchanted()) {
                ignoredDamage = EnchantmentHelper.modifyDamage(serverLevel, stack, attacked, damageSource, 0F);
            }
            int duration = (int) Math.min(f - ignoredDamage, 0);
            duration = Math.min(duration, 15) * 20;
            LaLMobEffects.applyFreezing(serverLevel, attacked, attacker, duration);
        }
    }
}
