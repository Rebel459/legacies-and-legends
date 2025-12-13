package net.legacy.legacies_and_legends.item.accessory;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.item.AccessoryItem;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;

public class LeapingNecklaceItem extends AccessoryItem {

    public LeapingNecklaceItem(Properties settings) {
        super(settings);
    }

    public Multimap<Holder<Attribute>, AttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, Identifier identifier) {
        var modifiers = super.getModifiers(stack, slot, entity, identifier);
        modifiers.put(Attributes.JUMP_STRENGTH, new AttributeModifier(LaLConstants.id("jump_strength"), 0.15, AttributeModifier.Operation.ADD_VALUE));
        modifiers.put(Attributes.SAFE_FALL_DISTANCE, new AttributeModifier(LaLConstants.id("safe_fall_distance"), 1, AttributeModifier.Operation.ADD_VALUE));
        return modifiers;
    }
}
