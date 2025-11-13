package net.legacy.legacies_and_legends.mixin.entity;

import net.legacy.legacies_and_legends.config.LaLConfig;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

	@Inject(method = "dropFromLootTable(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/damagesource/DamageSource;Z)V", at = @At("TAIL"))
	public void elderGuardianLootInject(ServerLevel level, DamageSource damageSource, boolean playerKill, CallbackInfo ci) {
		LivingEntity entity = LivingEntity.class.cast(this);
		if (entity.getType() == EntityType.ELDER_GUARDIAN && LaLConfig.get.loot.trident_shard) entity.spawnAtLocation(level, LaLItems.TRIDENT_SHARD);
	}
}
