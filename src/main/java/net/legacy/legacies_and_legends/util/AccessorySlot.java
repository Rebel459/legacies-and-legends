package net.legacy.legacies_and_legends.util;

import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class AccessorySlot extends Slot {

    Player player;

    public AccessorySlot(Container container, Player player, int index, int x, int y) {
        super(container, index, x, y);
        this.player = player;
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return stack.is(LaLItemTags.ACCESSORIES);
    }

    @Override
    public void onTake(Player player, ItemStack itemStack) {
        AccessoryHelper.onUnequip(player, itemStack);
    }

    @Override
    public void set(ItemStack itemStack) {
        if (itemStack != ItemStack.EMPTY && !AccessoryHelper.getAccessory(this.player).is(itemStack.getItem())) AccessoryHelper.onEquip(this.player, itemStack);
        super.set(itemStack);
    }
}