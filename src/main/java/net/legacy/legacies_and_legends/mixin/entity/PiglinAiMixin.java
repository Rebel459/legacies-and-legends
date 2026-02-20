package net.legacy.legacies_and_legends.mixin.entity;

import dev.emi.trinkets.api.TrinketsApi;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PiglinAi.class)
public abstract class PiglinAiMixin {

    @Inject(method = "isWearingSafeArmor", at = @At(value = "HEAD"), cancellable = true)
    private static void necklaceOfBartering(LivingEntity entity, CallbackInfoReturnable<Boolean> cir) {
        if (entity instanceof Player player) {
            var slots = player.inventoryMenu.slots;
        }
        if (TrinketsApi.getTrinketComponent(entity).isPresent()) {
            if (TrinketsApi.getTrinketComponent(entity).get().isEquipped(LaLItems.NECKLACE_OF_BARTERING)) {
                cir.setReturnValue(true);
            }
        }
    }
}