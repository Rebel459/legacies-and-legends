package net.legacy.legacies_and_legends.item.accessory;

import net.legacy.legacies_and_legends.item.AmuletItem;

public class AbsorptionAmuletItem extends AmuletItem {

/*    @Override
    public Item getItem() {
        return LaLItems.AMULET_OF_ABSORPTION;
    }

    @Override
    public int repairTicksFrequency() {
        return 20;
    }

    @Override
    public int repairCooldownTicksFrequency() {
        return 100;
    }

    public AbsorptionAmuletItem(Properties settings) {
        super(settings);
    }

    public void everyTick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof Player player && player.getTags().contains("damaged_amulet_of_absorption")) {
            if (player instanceof LaLPlayerDamageInterface damageInterface) {
                int damageAmount = damageInterface.lal$getDamageTaken() * 2;
                if (damageAmount < 1) damageAmount = 1;
                player.playSound(SoundEvents.PLAYER_ATTACK_CRIT);
                damageAccessory(stack, slot, player, damageAmount);
                player.removeTag("damaged_amulet_of_absorption");
            }
        }
    }

    @Override
    public void resetData(LivingEntity entity) {
        if (entity instanceof Player player) {
            player.removeTag("damaged_amulet_of_absorption");
            player.removeTag("amulet_repair_cooldown");
            player.removeTag("repaired_amulet");
            repairTicks = 0;
        }
    }

    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, Identifier identifier) {
        var modifiers = super.getModifiers(stack, slot, entity, identifier);

        int armor = (int) (entity.getMaxHealth() - entity.getHealth()) / 2;
        int toughness = (int) (entity.getMaxHealth() - entity.getHealth()) / 4;
        int knockbackResistance = (int) (entity.getMaxHealth() - entity.getHealth()) / 6;

        modifiers.put(Attributes.ARMOR, new AttributeModifier(LaLConstants.id("armor"), armor, AttributeModifier.Operation.ADD_VALUE));
        modifiers.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(LaLConstants.id("armor_toughness"), toughness, AttributeModifier.Operation.ADD_VALUE));
        modifiers.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(LaLConstants.id("knockback_resistance"), knockbackResistance * 0.1, AttributeModifier.Operation.ADD_VALUE));
        return modifiers;
    }*/
}