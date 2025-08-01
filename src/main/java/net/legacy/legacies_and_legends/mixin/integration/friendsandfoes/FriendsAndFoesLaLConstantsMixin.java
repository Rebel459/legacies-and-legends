package net.legacy.legacies_and_legends.mixin.integration.friendsandfoes;

import com.faboslav.friendsandfoes.common.init.FriendsAndFoesItems;
import dev.emi.trinkets.api.TrinketsApi;
import net.legacy.legacies_and_legends.LaLConstants;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LaLConstants.class)
public abstract class FriendsAndFoesLaLConstantsMixin {

    @Inject(method = "hasAccessory", at = @At(value = "TAIL"), cancellable = true)
    private static void activateTotem(Player player, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(
                cir.getReturnValue() ||
                        TrinketsApi.getTrinketComponent(player).get().isEquipped(FriendsAndFoesItems.TOTEM_OF_FREEZING.get()) ||
                        TrinketsApi.getTrinketComponent(player).get().isEquipped(FriendsAndFoesItems.TOTEM_OF_ILLUSION.get()));
    }
}
