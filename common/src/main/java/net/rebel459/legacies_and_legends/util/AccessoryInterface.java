package net.rebel459.legacies_and_legends.util;

import net.minecraft.world.item.ItemStack;

public interface AccessoryInterface {
    AccessoryHelper.Mutable getAccessoryData();
    void setAccessoryData(AccessoryHelper.Mutable mutable);
    ItemStack getAccessoryStack();
    void setAccessoryStack(ItemStack stack);
}
