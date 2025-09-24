package net.legacy.legacies_and_legends.item.accessory;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketsApi;
import net.legacy.legacies_and_legends.item.AccessoryItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class PurityNecklaceItem extends AccessoryItem {

    public PurityNecklaceItem(Properties settings) {
        super(settings);
    }

    @Override
    public void everyTick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof Player player && TrinketsApi.getTrinketComponent(player).isPresent()) {
            if (!player.getActiveEffects().isEmpty()) {
                player.removeAllEffects();
            }
        }
    }
}
