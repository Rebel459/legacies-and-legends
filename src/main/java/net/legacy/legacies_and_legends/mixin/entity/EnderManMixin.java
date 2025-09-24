package net.legacy.legacies_and_legends.mixin.entity;

import dev.emi.trinkets.api.TrinketsApi;
import net.legacy.legacies_and_legends.entity.impl.LaLPlayerPlatformInterface;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.minecraft.world.entity.monster.ElderGuardian;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnderMan.class)
public abstract class EnderManMixin {

    @Inject(method = "isBeingStaredBy", at = @At(value = "TAIL"), cancellable = true)
    private void necklaceOfIsolation(Player player, CallbackInfoReturnable<Boolean> cir) {
        if (TrinketsApi.getTrinketComponent(player).isPresent()) {
            if (TrinketsApi.getTrinketComponent(player).get().isEquipped(LaLItems.NECKLACE_OF_ISOLATION)) {
                cir.setReturnValue(false);
            }
        }
    }
}
