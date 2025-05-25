package net.legacy.legacies_and_legends.registry;

import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.equipment.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item.Properties;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public final class LaLEquipmentItems {

    // Equipment
    public static final GenericWeaponItem HOOK = register("hook", settings -> new GenericWeaponItem(LaLToolMaterial.HOOK, 3f, -3.2f, settings
            .stacksTo(1)
            .durability(750)
            .rarity(Rarity.UNCOMMON)
    ));
    public static final GenericWeaponItem KNIFE = register("knife", settings -> new GenericWeaponItem(LaLToolMaterial.KNIFE, 2f, -1.4f, settings
            .stacksTo(1)
            .durability(3048)
            .rarity(Rarity.RARE)
    ));

    // Artifacts
    public static final VerdantSwordItem VERDANT_SWORD = register("verdant_sword", settings -> new VerdantSwordItem(LaLToolMaterial.VERDANT, 3f, -2.4f, settings
            .stacksTo(1)
            .rarity(Rarity.UNCOMMON)
    ));
    public static final AxeItem CLEAVING_BATTLEAXE = register("cleaving_battleaxe", settings -> new CleavingBattleAxeItem(LaLToolMaterial.CLEAVING, 5f, -3f, settings
            .stacksTo(1)
            .rarity(Rarity.UNCOMMON)
    ));
    public static final PickaxeItem MOLTEN_PICKAXE = register("molten_pickaxe", settings -> new PickaxeItem(LaLToolMaterial.MOLTEN, 1f, -2.8f, settings
            .stacksTo(1)
            .rarity(Rarity.RARE)
    ));
    public static final ShovelItem PROSPECTOR_SHOVEL = register("prospector_shovel", settings -> new ShovelItem(LaLToolMaterial.PROSPECTOR, 1.5f, -3f, settings
            .stacksTo(1)
            .rarity(Rarity.UNCOMMON)
    ));
    public static final WitheredHoeItem WITHERED_HOE = register("withered_hoe", settings -> new WitheredHoeItem(LaLToolMaterial.WITHERED, -1f, -1f, settings
            .stacksTo(1)
            .rarity(Rarity.UNCOMMON)
    ));

    public static void init() {
    }

    private static @NotNull <T extends Item> T register(String name, @NotNull Function<Properties, Item> function) {
        return (T) Items.registerItem(ResourceKey.create(Registries.ITEM, LaLConstants.id(name)), function);
    }

    private static Item register (String name) {
        return register(name, Item::new);
    }

    public static Function<Properties, Item> createBlockItemWithCustomItemName(Block block) {
        return properties -> new BlockItem(block, properties.useItemDescriptionPrefix());
    }

}
