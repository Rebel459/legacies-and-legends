package net.legacy.legacies_and_legends.util;

import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class AccessorySlot extends Slot {
    public AccessorySlot(Container container, int index, int x, int y) {
        super(container, index, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return stack.is(LaLItemTags.ACCESSORIES);
    }
}