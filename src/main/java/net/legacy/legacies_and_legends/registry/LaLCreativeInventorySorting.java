package net.legacy.legacies_and_legends.registry;

import net.frozenblock.lib.item.api.FrozenCreativeTabs;
import net.legacy.legacies_and_legends.LegaciesAndLegends;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

public class LaLCreativeInventorySorting {

	public static void init() {
		addAfterInToolsAndUtilities(Items.MUSIC_DISC_CHIRP, LaLItems.MUSIC_DISC_GRAVEL);
		addAfterInToolsAndUtilities(Items.MUSIC_DISC_MALL, LaLItems.MUSIC_DISC_SVALL);
		addAfterInToolsAndUtilities(Items.MUSIC_DISC_STRAD, LaLItems.MUSIC_DISC_CASTLES);
		addAfterInToolsAndUtilities(Items.MUSIC_DISC_MELLOHI, LaLItems.MUSIC_DISC_TASWELL);
		addAfterInToolsAndUtilities(Items.MUSIC_DISC_PRECIPICE, LaLItems.MUSIC_DISC_SHULKER);
		addAfterInToolsAndUtilities(Items.MUSIC_DISC_FAR, LaLItems.MUSIC_DISC_TUNDRA);
		addAfterInToolsAndUtilities(Items.MUSIC_DISC_RELIC, LaLItems.MUSIC_DISC_FAR_LANDS);
        addAfterInToolsAndUtilities(Items.MUSIC_DISC_CREATOR_MUSIC_BOX, LaLItems.MUSIC_DISC_INFINITE_SPOOKY_AMETHYST);
        addAfterInToolsAndUtilities(Items.MUSIC_DISC_STAL, LaLItems.MUSIC_DISC_113);

		addAfterInToolsAndUtilities(Items.MILK_BUCKET, LaLItems.WOODEN_BUCKET);
		addAfterInToolsAndUtilities(LaLItems.WOODEN_BUCKET, LaLItems.COAL_BUCKET);
		addAfterInToolsAndUtilities(LaLItems.COAL_BUCKET, LaLItems.CHARCOAL_BUCKET);

        if (LegaciesAndLegends.isEndRebornLoaded) addAfterInToolsAndUtilities(Items.DIAMOND_HOE, LaLItems.PROSPECTOR_SHOVEL);
        else addAfterInToolsAndUtilities(Items.NETHERITE_HOE, LaLItems.PROSPECTOR_SHOVEL);
		addAfterInToolsAndUtilities(LaLItems.PROSPECTOR_SHOVEL, LaLItems.MOLTEN_PICKAXE);
		addAfterInToolsAndUtilities(LaLItems.MOLTEN_PICKAXE, LaLItems.CLEAVING_BATTLEAXE);
        addAfterInToolsAndUtilities(LaLItems.CLEAVING_BATTLEAXE, LaLItems.WITHERED_HOE);

		addBeforeInToolsAndUtilities(Items.BUCKET, LaLItems.TABLET_OF_RECALL);
		addAfterInToolsAndUtilities(LaLItems.TABLET_OF_RECALL, LaLItems.TABLET_OF_HASTE);
		addAfterInToolsAndUtilities(LaLItems.TABLET_OF_HASTE, LaLItems.TABLET_OF_REVEALING);
		addAfterInToolsAndUtilities(LaLItems.TABLET_OF_REVEALING, LaLItems.TABLET_OF_CHANNELING);
		addAfterInToolsAndUtilities(LaLItems.TABLET_OF_CHANNELING, LaLItems.TABLET_OF_DEAFENING);
		addAfterInToolsAndUtilities(LaLItems.TABLET_OF_DEAFENING, LaLItems.TABLET_OF_INSTABILITY);
		addAfterInToolsAndUtilities(LaLItems.TABLET_OF_INSTABILITY, LaLItems.TABLET_OF_WARPING);

		addAfterInToolsAndUtilities(LaLItems.TABLET_OF_WARPING, LaLItems.AMULET_OF_ABSORPTION);
		addAfterInToolsAndUtilities(LaLItems.AMULET_OF_ABSORPTION, LaLItems.AMULET_OF_DEFLECTION);
		addAfterInToolsAndUtilities(LaLItems.AMULET_OF_DEFLECTION, LaLItems.AMULET_OF_OBSIDIAN);

		addAfterInToolsAndUtilities(LaLItems.AMULET_OF_OBSIDIAN, LaLItems.RING_OF_ARCHERY);
		addAfterInToolsAndUtilities(LaLItems.RING_OF_ARCHERY, LaLItems.RING_OF_EXCAVATION);
		addAfterInToolsAndUtilities(LaLItems.RING_OF_EXCAVATION, LaLItems.RING_OF_CONSTRUCTION);
		addAfterInToolsAndUtilities(LaLItems.RING_OF_CONSTRUCTION, LaLItems.RING_OF_RESTORATION);
		addAfterInToolsAndUtilities(LaLItems.RING_OF_RESTORATION, LaLItems.RING_OF_STRIKING);
		addAfterInToolsAndUtilities(LaLItems.RING_OF_STRIKING, LaLItems.RING_OF_EVASION);
		addAfterInToolsAndUtilities(LaLItems.RING_OF_EVASION, LaLItems.RING_OF_HUNTING);

		addAfterInToolsAndUtilities(LaLItems.RING_OF_HUNTING, LaLItems.NECKLACE_OF_RESILIENCE);
		addAfterInToolsAndUtilities(LaLItems.NECKLACE_OF_RESILIENCE, LaLItems.NECKLACE_OF_LEAPING);
		addAfterInToolsAndUtilities(LaLItems.NECKLACE_OF_LEAPING, LaLItems.NECKLACE_OF_PURITY);
		addAfterInToolsAndUtilities(LaLItems.NECKLACE_OF_PURITY, LaLItems.NECKLACE_OF_REGENERATION);
		addAfterInToolsAndUtilities(LaLItems.NECKLACE_OF_REGENERATION, LaLItems.NECKLACE_OF_ISOLATION);
		addAfterInToolsAndUtilities(LaLItems.NECKLACE_OF_ISOLATION, LaLItems.NECKLACE_OF_BARTERING);
		addAfterInToolsAndUtilities(LaLItems.NECKLACE_OF_BARTERING, LaLItems.NECKLACE_OF_PROTECTION);

		addAfterInToolsAndUtilities(Items.FISHING_ROD, LaLItems.WAND);

		addBeforeInIngredients(Items.HEART_OF_THE_SEA, LaLItems.TRIDENT_SHARD);
		addAfterInIngredients(Items.HEART_OF_THE_SEA, LaLItems.METAL_CHUNK);
		addAfterInIngredients(LaLItems.METAL_CHUNK, LaLItems.DISC_FRAGMENT_FAR_LANDS);

		addAfterInIngredients(Items.DANGER_POTTERY_SHERD, LaLItems.DUSK_POTTERY_SHERD);
		addAfterInIngredients(Items.FLOW_POTTERY_SHERD, LaLItems.FORAGER_POTTERY_SHERD);
		addAfterInIngredients(Items.HEARTBREAK_POTTERY_SHERD, LaLItems.HARVEST_POTTERY_SHERD);
		addAfterInIngredients(Items.SNORT_POTTERY_SHERD, LaLItems.VERDANT_POTTERY_SHERD);

		addAfterInIngredients(Items.LAPIS_LAZULI, LaLItems.SAPPHIRE);

		addAfterInFoodAndDrinks(Items.BEETROOT, LaLItems.ENCHANTED_BEETROOT);
		addAfterInFoodAndDrinks(Items.BEETROOT_SOUP, LaLItems.ENCHANTED_BEETROOT_SOUP);

        if (LegaciesAndLegends.isEndRebornLoaded) {
            addAfterInCombat(Items.DIAMOND_SWORD, LaLItems.VERDANT_SWORD);
            addAfterInCombat(Items.DIAMOND_AXE, LaLItems.CLEAVING_BATTLEAXE);
            addAfterInCombat(Items.DIAMOND_SPEAR, LaLItems.FROSTED_SPEAR);
        }
        else {
            addAfterInCombat(Items.NETHERITE_SWORD, LaLItems.VERDANT_SWORD);
            addAfterInCombat(Items.NETHERITE_AXE, LaLItems.CLEAVING_BATTLEAXE);
            addAfterInCombat(Items.NETHERITE_SPEAR, LaLItems.FROSTED_SPEAR);
        }

		addBeforeInCombat(Items.MACE, LaLItems.KNIFE);
		addBeforeInCombat(Items.TRIDENT, LaLItems.HOOK);
		addAfterInCombat(Items.CROSSBOW, LaLItems.BOOMERANG);

		addAfterInCombat(Items.TURTLE_HELMET, LaLItems.REINFORCED_CHESTPLATE);
		addAfterInCombat(LaLItems.REINFORCED_CHESTPLATE, LaLItems.TRAVELLING_STRIDES);
		addAfterInCombat(LaLItems.TRAVELLING_STRIDES, LaLItems.WANDERER_BOOTS);

		addAfterInCombat(Items.TOTEM_OF_UNDYING, LaLItems.TOTEM_OF_RESURRECTION);
		addAfterInCombat(LaLItems.TOTEM_OF_RESURRECTION, LaLItems.TOTEM_OF_TELEPORTATION);

		addAfterInNaturalBlocks(Blocks.DEEPSLATE_LAPIS_ORE, LaLBlocks.SAPPHIRE_ORE);
		addAfterInNaturalBlocks(LaLBlocks.SAPPHIRE_ORE, LaLBlocks.DEEPSLATE_SAPPHIRE_ORE);

		addAfterInBuildingBlocks(Blocks.LAPIS_BLOCK, LaLBlocks.SAPPHIRE_BLOCK);
		addAfterInFunctionalBlocks(Blocks.LANTERN, LaLBlocks.SAPPHIRE_LANTERN);
	}

	private static void addAfterInNaturalBlocks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.NATURAL_BLOCKS);
	}

	private static void addBeforeInBuildingBlocks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.BUILDING_BLOCKS);
	}

	private static void addAfterInBuildingBlocks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.BUILDING_BLOCKS);
	}

	private static void addAfterInRedstone(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.REDSTONE_BLOCKS);
	}

	private static void addAfterInFunctionalBlocks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.FUNCTIONAL_BLOCKS);
	}

	private static void addBeforeInRedstoneBlocks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.REDSTONE_BLOCKS);
	}

	private static void addInToolsAndUtilities(ItemLike item) {
		FrozenCreativeTabs.add(item, CreativeModeTabs.TOOLS_AND_UTILITIES);
	}

	private static void addAfterInToolsAndUtilities(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.TOOLS_AND_UTILITIES);
	}

    private static void addBeforeInToolsAndUtilities(ItemLike comparedItem, ItemLike item) {
        FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.TOOLS_AND_UTILITIES);
    }

	private static void addBeforeInIngredients(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.INGREDIENTS);
	}

	private static void addAfterInIngredients(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.INGREDIENTS);
	}

	private static void addBeforeInFoodAndDrinks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.FOOD_AND_DRINKS);
	}

	private static void addAfterInFoodAndDrinks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.FOOD_AND_DRINKS);
	}

	private static void addAfterInCombat(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.COMBAT);
	}

	private static void addBeforeInCombat(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.COMBAT);
	}

	private static void addBeforeInSpawnEggs(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.SPAWN_EGGS);
	}

	private static void addAfterInSpawnEggs(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.SPAWN_EGGS);
	}
}
