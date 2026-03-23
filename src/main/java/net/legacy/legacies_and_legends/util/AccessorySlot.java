package net.legacy.legacies_and_legends.util;

import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;

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
        super.onTake(player, itemStack);
    }

    @Override
    public void set(ItemStack itemStack) {
        AccessoryInterface accessory = (AccessoryInterface) this.player;
        AccessoryHelper.Mutable mutable = accessory.getAccessoryData();
        if (itemStack != ItemStack.EMPTY && !AccessoryHelper.getActualAccessory(this.player).is(itemStack.getItem()) && mutable.doOnEquip) {
            AccessoryHelper.onEquip(this.player, itemStack);
        }
        if (!mutable.doOnEquip) {
            mutable.doOnEquip = true;
            accessory.setAccessoryData(mutable);
        }
        super.set(itemStack);
    }

    @Override
    public boolean isActive() {
        return !this.player.hasInfiniteMaterials();
    }
}