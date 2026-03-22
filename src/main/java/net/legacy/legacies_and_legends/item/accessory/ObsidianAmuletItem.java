package net.legacy.legacies_and_legends.item.accessory;

import net.legacy.legacies_and_legends.item.AmuletItem;

public class ObsidianAmuletItem extends AmuletItem {

/*    @Override
    public Item getItem() {
        return LaLItems.AMULET_OF_OBSIDIAN;
    }

    @Override
    public int repairTicksFrequency() {
        return 20;
    }

    @Override
    public int repairCooldownTicksFrequency() {
        return 100;
    }

    public int secondsElapsed = 3;

    public int damageTicks = 0;
    public int damageTicksFrequency = 10;

    public ObsidianAmuletItem(Properties settings) {
        super(settings);
    }

    @Override
    public void everyTick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof Player player && player.getTags().contains("damaged_amulet_of_obsidian")) {
            damageTicks = damageTicks + 1;
            if (damageTicks >= damageTicksFrequency) {
                damageTicks = 0;
                damageAccessory(stack, slot, player, 1);
                player.removeTag("damaged_amulet_of_obsidian");
            }
        }
    }

    @Override
    public void resetData(LivingEntity entity) {
        if (entity instanceof Player player) {
            player.removeTag("damaged_amulet_of_obsidian");
            player.removeTag("amulet_repair_cooldown");
            player.removeTag("repaired_amulet");
            repairTicks = 0;
            damageTicks = 0;
        }
    }

    @Override
    public void everySecond(ItemStack stack, SlotReference slot, LivingEntity entity) {
        secondsElapsed = secondsElapsed + 1;
        if (secondsElapsed >= 3) {
            if (entity instanceof Player player && player.getRemainingFireTicks() > 0) {
                if (player.isInLava() || player.getInBlockState().is(Blocks.LAVA)) player.playSound(SoundEvents.LAVA_EXTINGUISH);
                else player.playSound(SoundEvents.FIRE_EXTINGUISH);
                secondsElapsed = 0;
                return;
            }
            secondsElapsed = 3;
        }
    }*/
}