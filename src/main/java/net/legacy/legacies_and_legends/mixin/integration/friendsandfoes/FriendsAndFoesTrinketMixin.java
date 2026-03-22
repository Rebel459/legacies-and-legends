package net.legacy.legacies_and_legends.mixin.integration.friendsandfoes;

/*import com.faboslav.friendsandfoes.common.init.FriendsAndFoesItems;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Trinket.class)*/
public interface FriendsAndFoesTrinketMixin {

/*    @Inject(at = @At("HEAD"), method = "tick")
    private void tick(ItemStack stack, SlotReference slot, LivingEntity livingEntity, CallbackInfo ci) {
        if (livingEntity instanceof Player player && TrinketsApi.getTrinketComponent(livingEntity).isPresent()) {
            if (player.getTags().contains("used_totem") && (TrinketsApi.getTrinketComponent(livingEntity).get().isEquipped(FriendsAndFoesItems.TOTEM_OF_FREEZING.get()) || TrinketsApi.getTrinketComponent(livingEntity).get().isEquipped(FriendsAndFoesItems.TOTEM_OF_ILLUSION.get()))) {
                player.removeTag("used_totem");
                slot.inventory().removeItem(slot.index(), 1);
            }
        }
    }*/
}
