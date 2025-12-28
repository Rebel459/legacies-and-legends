package net.legacy.legacies_and_legends.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.legacy.legacies_and_legends.registry.*;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import org.jetbrains.annotations.NotNull;

public final class LaLModelProvider extends FabricModelProvider {
	public LaLModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(@NotNull BlockModelGenerators generator) {
		generator.createLantern(LaLBlocks.SAPPHIRE_LANTERN);
		generator.createTrivialCube(LaLBlocks.SAPPHIRE_BLOCK);
		generator.createTrivialCube(LaLBlocks.SAPPHIRE_ORE);
		generator.createTrivialCube(LaLBlocks.DEEPSLATE_SAPPHIRE_ORE);
	}

	@Override
	public void generateItemModels(@NotNull ItemModelGenerators generator) {
        generator.generateFlatItem(LaLItems.REINFORCED_CHESTPLATE, ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(LaLItems.TRAVELLING_STRIDES, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.WANDERER_BOOTS, ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(LaLItems.BOOMERANG, ModelTemplates.FLAT_HANDHELD_ITEM);
		generator.generateFlatItem(LaLItems.KNIFE, ModelTemplates.FLAT_HANDHELD_ITEM);
		generator.generateFlatItem(LaLItems.HOOK, ModelTemplates.FLAT_HANDHELD_ITEM);

		generator.generateFlatItem(LaLItems.VERDANT_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
		generator.generateFlatItem(LaLItems.CLEAVING_BATTLEAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
		generator.generateFlatItem(LaLItems.MOLTEN_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
		generator.generateFlatItem(LaLItems.PROSPECTOR_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        generator.generateFlatItem(LaLItems.WITHERED_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        generator.generateSpear(LaLItems.FROSTED_SPEAR);

		generator.generateFlatItem(LaLItems.TOTEM_OF_TELEPORTATION, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.TOTEM_OF_RESURRECTION, ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(LaLItems.RING_OF_EVASION, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.RING_OF_CONSTRUCTION, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.RING_OF_STRIKING, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.RING_OF_EXCAVATION, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.RING_OF_RESTORATION, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.RING_OF_HUNTING, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.RING_OF_ARCHERY, ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(LaLItems.NECKLACE_OF_PROTECTION, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.NECKLACE_OF_BARTERING, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.NECKLACE_OF_ISOLATION, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.NECKLACE_OF_REGENERATION, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.NECKLACE_OF_LEAPING, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.NECKLACE_OF_PURITY, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.NECKLACE_OF_RESILIENCE, ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(LaLItems.AMULET_OF_ABSORPTION, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.AMULET_OF_OBSIDIAN, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.AMULET_OF_DEFLECTION, ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(LaLItems.SAPPHIRE, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.METAL_CHUNK, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.TABLET, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.TRIDENT_SHARD, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.DISC_FRAGMENT_FAR_LANDS, ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(LaLItems.WOODEN_BUCKET, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.CHARCOAL_BUCKET, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.COAL_BUCKET, ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(LaLItems.MUSIC_DISC_SVALL, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.MUSIC_DISC_CASTLES, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.MUSIC_DISC_TASWELL, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.MUSIC_DISC_TUNDRA, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.MUSIC_DISC_FAR_LANDS, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.MUSIC_DISC_SHULKER, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.MUSIC_DISC_INFINITE_SPOOKY_AMETHYST, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.MUSIC_DISC_113, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.MUSIC_DISC_GRAVEL, ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(LaLItems.DUSK_POTTERY_SHERD, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.HARVEST_POTTERY_SHERD, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.VERDANT_POTTERY_SHERD, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.FORAGER_POTTERY_SHERD, ModelTemplates.FLAT_ITEM);

	}
}
