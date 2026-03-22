package net.legacy.legacies_and_legends.mixin.integration.friendsandfoes;

import net.legacy.legacies_and_legends.LaLConstants;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LaLConstants.class)
public abstract class FriendsAndFoesLaLConstantsMixin {

/*    @Inject(method = "hasAccessory", at = @At(value = "TAIL"), cancellable = true)
    private static void activateTotem(Player player, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(
                cir.getReturnValue() ||
                        TrinketsApi.getTrinketComponent(player).get().isEquipped(FriendsAndFoesItems.TOTEM_OF_FREEZING.get()) ||
                        TrinketsApi.getTrinketComponent(player).get().isEquipped(FriendsAndFoesItems.TOTEM_OF_ILLUSION.get()));
    }*/
}
