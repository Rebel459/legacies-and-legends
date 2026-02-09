package net.legacy.legacies_and_legends.util;

import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantable;

public class AccessoryHelper {

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
