package net.legacy.legacies_and_legends.util;

import net.minecraft.world.item.ItemStack;

public interface AccessorySlotInterface {
    ItemStack getAccessory();
    void setAccessory(ItemStack stack);
}