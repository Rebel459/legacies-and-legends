package net.legacy.legacies_and_legends.item.accessory;

import net.legacy.legacies_and_legends.item.AmuletItem;

public class DeflectionAmuletItem extends AmuletItem {

/*    @Override
    public Item getItem() {
        return LaLItems.AMULET_OF_DEFLECTION;
    }

    @Override
    public int repairTicksFrequency() {
        return 20;
    }

    @Override
    public int repairCooldownTicksFrequency() {
        return 200;
    }

    public DeflectionAmuletItem(Properties settings) {
        super(settings);
    }

    public void everyTick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof Player player && player.getTags().contains("damaged_amulet_of_deflection")) {
                damageAccessory(stack, slot, player, 10);
                player.removeTag("damaged_amulet_of_deflection");
            }
        }

    @Override
    public void resetData(LivingEntity entity) {
        if (entity instanceof Player player) {
            player.removeTag("damaged_amulet_of_deflection");
            player.removeTag("amulet_repair_cooldown");
            player.removeTag("repaired_amulet");
            repairTicks = 0;
        }
    }*/
}