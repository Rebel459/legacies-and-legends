package net.rebel459.legacies_and_legends.registry;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.rebel459.legacies_and_legends.LaLConstants;
import net.rebel459.unified.api.data.helper.CreativeEntryGenerator;

public class LaLCreativeInventorySorting {

	public static void init() {

		CreativeEntryGenerator.Builder entries = LaLConstants.DATA.helpers().creativeEntries().create("lal_additions");

		CreativeEntryGenerator.Builder withEndReborn = LaLConstants.dataWithMod("end_reborn").helpers().creativeEntries().create("lal_with_end_reborn");
		CreativeEntryGenerator.Builder withoutEndReborn = LaLConstants.dataWithoutMod("end_reborn").helpers().creativeEntries().create("lal_without_end_reborn");

		entries.insertAfter(CreativeModeTabs.TOOLS_AND_UTILITIES, Items.MUSIC_DISC_CHIRP, LaLItems.MUSIC_DISC_GRAVEL);
		entries.insertAfter(CreativeModeTabs.TOOLS_AND_UTILITIES, Items.MUSIC_DISC_MALL, LaLItems.MUSIC_DISC_SVALL);
		entries.insertAfter(CreativeModeTabs.TOOLS_AND_UTILITIES, Items.MUSIC_DISC_STRAD, LaLItems.MUSIC_DISC_CASTLES);
		entries.insertAfter(CreativeModeTabs.TOOLS_AND_UTILITIES, Items.MUSIC_DISC_MELLOHI, LaLItems.MUSIC_DISC_TASWELL);
		entries.insertAfter(CreativeModeTabs.TOOLS_AND_UTILITIES, Items.MUSIC_DISC_PRECIPICE, LaLItems.MUSIC_DISC_SHULKER);
		entries.insertAfter(CreativeModeTabs.TOOLS_AND_UTILITIES, Items.MUSIC_DISC_FAR, LaLItems.MUSIC_DISC_TUNDRA);
		entries.insertAfter(CreativeModeTabs.TOOLS_AND_UTILITIES, Items.MUSIC_DISC_RELIC, LaLItems.MUSIC_DISC_FAR_LANDS);
		entries.insertAfter(CreativeModeTabs.TOOLS_AND_UTILITIES, Items.MUSIC_DISC_CREATOR_MUSIC_BOX, LaLItems.MUSIC_DISC_INFINITE_SPOOKY_AMETHYST);
		entries.insertAfter(CreativeModeTabs.TOOLS_AND_UTILITIES, Items.MUSIC_DISC_STAL, LaLItems.MUSIC_DISC_113);

		entries.insertAfter(CreativeModeTabs.TOOLS_AND_UTILITIES, Items.MILK_BUCKET, LaLItems.WOODEN_BUCKET, LaLItems.COAL_BUCKET, LaLItems.CHARCOAL_BUCKET);

        withEndReborn.insertAfter(CreativeModeTabs.TOOLS_AND_UTILITIES, Items.DIAMOND_HOE, LaLItems.PROSPECTOR_SHOVEL, LaLItems.MOLTEN_PICKAXE, LaLItems.CLEAVING_BATTLEAXE, LaLItems.WITHERED_HOE);
        withoutEndReborn.insertAfter(CreativeModeTabs.TOOLS_AND_UTILITIES, Items.NETHERITE_HOE, LaLItems.PROSPECTOR_SHOVEL, LaLItems.MOLTEN_PICKAXE, LaLItems.CLEAVING_BATTLEAXE, LaLItems.WITHERED_HOE);

		entries.insertBefore(
				CreativeModeTabs.TOOLS_AND_UTILITIES,
				Items.BUCKET,
				LaLItems.TABLET_OF_RECALL,
				LaLItems.TABLET_OF_HASTE,
				LaLItems.TABLET_OF_REVEALING,
				LaLItems.TABLET_OF_CHANNELING,
				LaLItems.TABLET_OF_DEAFENING,
				LaLItems.TABLET_OF_INSTABILITY,
				LaLItems.TABLET_OF_WARPING,
				LaLItems.AMULET_OF_ABSORPTION,
				LaLItems.AMULET_OF_DEFLECTION,
				LaLItems.AMULET_OF_OBSIDIAN,
				LaLItems.RING_OF_ARCHERY,
				LaLItems.RING_OF_EXCAVATION,
				LaLItems.RING_OF_CONSTRUCTION,
				LaLItems.RING_OF_RESTORATION,
				LaLItems.RING_OF_STRIKING,
				LaLItems.RING_OF_EVASION,
				LaLItems.RING_OF_HUNTING,
				LaLItems.NECKLACE_OF_RESILIENCE,
				LaLItems.NECKLACE_OF_LEAPING,
				LaLItems.NECKLACE_OF_PURITY,
				LaLItems.NECKLACE_OF_REGENERATION,
				LaLItems.NECKLACE_OF_ISOLATION,
				LaLItems.NECKLACE_OF_BARTERING,
				LaLItems.NECKLACE_OF_PROTECTION
		);

		entries.insertAfter(CreativeModeTabs.TOOLS_AND_UTILITIES, Items.FISHING_ROD, LaLItems.WAND);

		entries.insertBefore(CreativeModeTabs.INGREDIENTS, Items.HEART_OF_THE_SEA, LaLItems.TRIDENT_SHARD);
		entries.insertAfter(CreativeModeTabs.INGREDIENTS, Items.HEART_OF_THE_SEA, LaLItems.METAL_CHUNK, LaLItems.DISC_FRAGMENT_FAR_LANDS);

		entries.insertAfter(CreativeModeTabs.INGREDIENTS, Items.DANGER_POTTERY_SHERD, LaLItems.DUSK_POTTERY_SHERD);
		entries.insertAfter(CreativeModeTabs.INGREDIENTS, Items.FLOW_POTTERY_SHERD, LaLItems.FORAGER_POTTERY_SHERD);
		entries.insertAfter(CreativeModeTabs.INGREDIENTS, Items.HEARTBREAK_POTTERY_SHERD, LaLItems.HARVEST_POTTERY_SHERD);
		entries.insertAfter(CreativeModeTabs.INGREDIENTS, Items.SNORT_POTTERY_SHERD, LaLItems.VERDANT_POTTERY_SHERD);

		entries.insertAfter(CreativeModeTabs.INGREDIENTS, Items.LAPIS_LAZULI, LaLItems.SAPPHIRE);

		entries.insertAfter(CreativeModeTabs.FOOD_AND_DRINKS, Items.BEETROOT, LaLItems.ENCHANTED_BEETROOT);
		entries.insertAfter(CreativeModeTabs.FOOD_AND_DRINKS, Items.BEETROOT_SOUP, LaLItems.ENCHANTED_BEETROOT_SOUP);

        withEndReborn.insertAfter(CreativeModeTabs.COMBAT, Items.DIAMOND_SWORD, LaLItems.VERDANT_SWORD);
		withEndReborn.insertAfter(CreativeModeTabs.COMBAT, Items.DIAMOND_AXE, LaLItems.CLEAVING_BATTLEAXE);
		withEndReborn.insertAfter(CreativeModeTabs.COMBAT, Items.DIAMOND_SPEAR, LaLItems.FROSTED_SPEAR);
		withoutEndReborn.insertAfter(CreativeModeTabs.COMBAT, Items.NETHERITE_SWORD, LaLItems.VERDANT_SWORD);
		withoutEndReborn.insertAfter(CreativeModeTabs.COMBAT, Items.NETHERITE_AXE, LaLItems.CLEAVING_BATTLEAXE);
		withoutEndReborn.insertAfter(CreativeModeTabs.COMBAT, Items.NETHERITE_SPEAR, LaLItems.FROSTED_SPEAR);

		entries.insertBefore(CreativeModeTabs.COMBAT, Items.MACE, LaLItems.KNIFE);
		entries.insertBefore(CreativeModeTabs.COMBAT, Items.TRIDENT, LaLItems.HOOK);
		entries.insertAfter(CreativeModeTabs.COMBAT, Items.CROSSBOW, LaLItems.BOOMERANG);

		entries.insertAfter(CreativeModeTabs.COMBAT, Items.TURTLE_HELMET, LaLItems.REINFORCED_CHESTPLATE, LaLItems.TRAVELLING_STRIDES, LaLItems.WANDERER_BOOTS);

		entries.insertAfter(CreativeModeTabs.COMBAT, Items.TOTEM_OF_UNDYING, LaLItems.TOTEM_OF_RESURRECTION, LaLItems.TOTEM_OF_TELEPORTATION);

		entries.insertAfter(CreativeModeTabs.NATURAL_BLOCKS, Blocks.DEEPSLATE_LAPIS_ORE, LaLBlocks.SAPPHIRE_ORE, LaLBlocks.DEEPSLATE_SAPPHIRE_ORE);

		entries.insertAfter(CreativeModeTabs.BUILDING_BLOCKS, Blocks.LAPIS_BLOCK, LaLBlocks.SAPPHIRE_BLOCK);
		entries.insertAfter(CreativeModeTabs.FUNCTIONAL_BLOCKS, Blocks.LANTERN, LaLBlocks.SAPPHIRE_LANTERN);

		entries.insertBefore(CreativeModeTabs.FUNCTIONAL_BLOCKS, Blocks.SEA_LANTERN, LaLBlocks.GLOW_STICK);

		entries.insertAfter(CreativeModeTabs.FUNCTIONAL_BLOCKS, Blocks.SMITHING_TABLE, LaLBlocks.JEWELING_TABLE);

		entries.insertBefore(CreativeModeTabs.NATURAL_BLOCKS, Blocks.MAGMA_BLOCK, LaLBlocks.METEORITE, LaLBlocks.CONCENTRATED_METEORITE);

		entries.insertBefore(CreativeModeTabs.BUILDING_BLOCKS, Blocks.NETHERRACK, LaLBlocks.METEORITE, LaLBlocks.METEORITE_BRICKS, LaLBlocks.METEORITE_BRICK_STAIRS, LaLBlocks.METEORITE_BRICK_SLAB, LaLBlocks.METEORITE_BRICK_WALL, LaLBlocks.CHISELED_METEORITE_BRICKS);
		entries.insertBefore(CreativeModeTabs.INGREDIENTS, Items.NETHER_BRICK, LaLItems.METEORITE_BRICK);

		entries.insertBefore(
				CreativeModeTabs.INGREDIENTS,
				LaLItems.SAPPHIRE_GEM,
				LaLItems.SLIME_GEM,
				LaLItems.ICE_GEM,
				LaLItems.PRISMARINE_GEM,
				LaLItems.BREEZE_GEM,
				LaLItems.RUBY_GEM,
				LaLItems.METEORITE_GEM,
				LaLItems.OBSIDIAN_GEM,
				LaLItems.NEBULITE_GEM,
				LaLItems.TIMELOST_GEM
		);
	}
}
