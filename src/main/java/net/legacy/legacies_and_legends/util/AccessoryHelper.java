package net.legacy.legacies_and_legends.util;

import com.google.common.collect.Multimap;
import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantable;

public class AccessoryHelper {

    public static ItemStack getAccessory(Player player) {
        if (player.inventoryMenu instanceof AccessoryInterface accessoryInterface) {
            return accessoryInterface.getAccessory();
        }
        return ItemStack.EMPTY;
    }

    public static void setAccessory(Player player, ItemStack stack) {
        if (player.inventoryMenu instanceof AccessoryInterface accessoryInterface) {
            accessoryInterface.setAccessory(stack);
        }
    }

    public static boolean hasAccessory(Player player, ItemStack stack) {
        return getAccessory(player) == stack;
    }

    public static boolean registerAttributeModifier(Player player, ItemStack stack) {
        return getAccessory(player) == stack;
    }

    private int secondTicks;

    public void onTick(Player player, ItemStack stack) {
        this.secondTicks = this.secondTicks + 1;
        if (this.secondTicks >= 20) {
            this.secondTicks = 0;
            this.onSecond(player, stack);
        }
    }

    public void onSecond(Player player, ItemStack stack) {}

    public Multimap<Holder<Attribute>, AttributeModifier> getModifiers(ItemStack stack) {
        return null;
    }

    public static void randomEnchantability(ItemStack stack, RandomSource random) {
        if (stack.getComponents().has(DataComponents.ENCHANTABLE) || !stack.getComponents().has(DataComponents.RARITY) || !stack.is(LaLItemTags.VARIABLE_REPAIR_COST)) return;
        if (stack.getItem().getDefaultInstance().get(DataComponents.RARITY).getSerializedName().equals("common")) {
            stack.applyComponents(DataComponentMap.builder()
                    .set(DataComponents.ENCHANTABLE, new Enchantable(random.nextInt(16, 31)))
                    .build()
            );
        }
        else if (stack.getItem().getDefaultInstance().get(DataComponents.RARITY).getSerializedName().equals("uncommon")) {
            stack.applyComponents(DataComponentMap.builder()
                    .set(DataComponents.ENCHANTABLE, new Enchantable(random.nextInt(11, 26)))
                    .build()
            );
        }
        else if (stack.getItem().getDefaultInstance().get(DataComponents.RARITY).getSerializedName().equals("rare")) {
            stack.applyComponents(DataComponentMap.builder()
                    .set(DataComponents.ENCHANTABLE, new Enchantable(random.nextInt(6, 21)))
                    .build()
            );
        }
        else if (stack.getItem().getDefaultInstance().get(DataComponents.RARITY).getSerializedName().equals("epic")) {
            stack.applyComponents(DataComponentMap.builder()
                    .set(DataComponents.ENCHANTABLE, new Enchantable(random.nextInt(1, 16)))
                    .build()
            );
        }
    }
}
