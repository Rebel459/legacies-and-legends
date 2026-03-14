package net.legacy.legacies_and_legends.item.accessory;

import java.util.Random;

public class EvasionRingItem {

/*    public EvasionRingItem(Properties settings) {
        super(settings);
    }

    @Override
    public void everyTick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        getModifiers(stack, slot, entity, Identifier.parse(LaLConstants.MOD_ID));
        if (entity instanceof Player player && TrinketsApi.getTrinketComponent(player).isPresent()) {
            if (player.isShiftKeyDown() && !player.hasEffect(MobEffects.INVISIBILITY)) {
                player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, MobEffectInstance.INFINITE_DURATION));
                player.addTag("infinite_invisibility");
            }
            else if (!player.isShiftKeyDown() && player.getTags().contains("infinite_invisibility")) {
                player.removeEffect(MobEffects.INVISIBILITY);
                player.removeTag("infinite_invisibility");
            }
        }
    }

    @Override
    public void resetData(LivingEntity entity) {
        if (entity instanceof Player player) {
            player.removeEffect(MobEffects.INVISIBILITY);
            player.removeTag("infinite_invisibility");
        }
    }

    @Override
    public void everySecond(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (entity instanceof Player player) {
            if (player.isShiftKeyDown() && entity.getRandom().nextInt(10) >= 9 && (player.getTags().contains("infinite_invisibility"))) {
                if (getAccessory(stack, slot, player).is(LaLItems.RING_OF_EVASION)) {
                    damageAccessory(stack, slot, player, 1);
                }
            }
        }
    }

    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, Identifier identifier) {
        var modifiers = super.getModifiers(stack, slot, entity, identifier);
        modifiers.put(Attributes.SNEAKING_SPEED, new AttributeModifier(LaLConstants.id("sneaking_speed"), 0.3, AttributeModifier.Operation.ADD_VALUE));
        return modifiers;
    }*/
}
