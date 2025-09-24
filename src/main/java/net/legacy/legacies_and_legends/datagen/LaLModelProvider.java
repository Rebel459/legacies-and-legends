package net.legacy.legacies_and_legends.datagen;

import java.util.List;
import java.util.Optional;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.legacy.legacies_and_legends.*;
import net.legacy.legacies_and_legends.registry.*;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class LaLModelProvider extends FabricModelProvider {
	public static final MaterialAssetGroup ECHO_SHARD = MaterialAssetGroup.create("echo_shard");
	public static final MaterialAssetGroup SAPPHIRE = MaterialAssetGroup.create("sapphire");

	private static final List<ItemModelGenerators.TrimMaterialData> TRIM_MATERIALS = List.of(
			new ItemModelGenerators.TrimMaterialData(ECHO_SHARD, LaLTrimMaterials.ECHO),
			new ItemModelGenerators.TrimMaterialData(SAPPHIRE, LaLTrimMaterials.SAPPHIRE)
	);

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
		generator.generateTrimmableItem(LaLItems.REINFORCED_CHESTPLATE, LaLEquipmentAssets.REINFORCED, ResourceLocation.withDefaultNamespace("trims/items/chestplate_trim"), false);
		generator.generateTrimmableItem(LaLItems.TRAVELLING_STRIDES, LaLEquipmentAssets.TRAVELLING, ResourceLocation.withDefaultNamespace("trims/items/leggings_trim"), false);
		generator.generateTrimmableItem(LaLItems.WANDERER_BOOTS, LaLEquipmentAssets.WANDERER, ResourceLocation.withDefaultNamespace("trims/items/boots_trim"), false);

		generator.generateFlatItem(LaLItems.BOOMERANG, ModelTemplates.FLAT_HANDHELD_ITEM);
		generator.generateFlatItem(LaLItems.KNIFE, ModelTemplates.FLAT_HANDHELD_ITEM);
		generator.generateFlatItem(LaLItems.HOOK, ModelTemplates.FLAT_HANDHELD_ITEM);

		generator.generateFlatItem(LaLItems.VERDANT_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
		generator.generateFlatItem(LaLItems.CLEAVING_BATTLEAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
		generator.generateFlatItem(LaLItems.MOLTEN_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
		generator.generateFlatItem(LaLItems.PROSPECTOR_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
		generator.generateFlatItem(LaLItems.WITHERED_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

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

		this.registerArmorTrims(generator, Items.TURTLE_HELMET, EquipmentAssets.TURTLE_SCUTE, "helmet", false);
		this.registerArmorTrims(generator, Items.LEATHER_HELMET, EquipmentAssets.LEATHER, "helmet", true);
		this.registerArmorTrims(generator, Items.LEATHER_CHESTPLATE, EquipmentAssets.LEATHER, "chestplate", true);
		this.registerArmorTrims(generator, Items.LEATHER_LEGGINGS, EquipmentAssets.LEATHER, "leggings", true);
		this.registerArmorTrims(generator, Items.LEATHER_BOOTS, EquipmentAssets.LEATHER, "boots", true);
		this.registerArmorTrims(generator, Items.CHAINMAIL_HELMET, EquipmentAssets.CHAINMAIL, "helmet", false);
		this.registerArmorTrims(generator, Items.CHAINMAIL_CHESTPLATE, EquipmentAssets.CHAINMAIL, "chestplate", false);
		this.registerArmorTrims(generator, Items.CHAINMAIL_LEGGINGS, EquipmentAssets.CHAINMAIL, "leggings", false);
		this.registerArmorTrims(generator, Items.CHAINMAIL_BOOTS, EquipmentAssets.CHAINMAIL, "boots", false);
		this.registerArmorTrims(generator, Items.IRON_HELMET, EquipmentAssets.IRON, "helmet", false);
		this.registerArmorTrims(generator, Items.IRON_CHESTPLATE, EquipmentAssets.IRON, "chestplate", false);
		this.registerArmorTrims(generator, Items.IRON_LEGGINGS, EquipmentAssets.IRON, "leggings", false);
		this.registerArmorTrims(generator, Items.IRON_BOOTS, EquipmentAssets.IRON, "boots", false);
		this.registerArmorTrims(generator, Items.DIAMOND_HELMET, EquipmentAssets.DIAMOND, "helmet", false);
		this.registerArmorTrims(generator, Items.DIAMOND_CHESTPLATE, EquipmentAssets.DIAMOND, "chestplate", false);
		this.registerArmorTrims(generator, Items.DIAMOND_LEGGINGS, EquipmentAssets.DIAMOND, "leggings", false);
		this.registerArmorTrims(generator, Items.DIAMOND_BOOTS, EquipmentAssets.DIAMOND, "boots", false);
		this.registerArmorTrims(generator, Items.GOLDEN_HELMET, EquipmentAssets.GOLD, "helmet", false);
		this.registerArmorTrims(generator, Items.GOLDEN_CHESTPLATE, EquipmentAssets.GOLD, "chestplate", false);
		this.registerArmorTrims(generator, Items.GOLDEN_LEGGINGS, EquipmentAssets.GOLD, "leggings", false);
		this.registerArmorTrims(generator, Items.GOLDEN_BOOTS, EquipmentAssets.GOLD, "boots", false);
		this.registerArmorTrims(generator, Items.NETHERITE_HELMET, EquipmentAssets.NETHERITE, "helmet", false);
		this.registerArmorTrims(generator, Items.NETHERITE_CHESTPLATE, EquipmentAssets.NETHERITE, "chestplate", false);
		this.registerArmorTrims(generator, Items.NETHERITE_LEGGINGS, EquipmentAssets.NETHERITE, "leggings", false);
		this.registerArmorTrims(generator, Items.NETHERITE_BOOTS, EquipmentAssets.NETHERITE, "boots", false);

		this.registerArmorTrims(generator, LaLItems.REINFORCED_CHESTPLATE, LaLEquipmentAssets.REINFORCED, "chestplate", false);
		this.registerArmorTrims(generator, LaLItems.TRAVELLING_STRIDES, LaLEquipmentAssets.TRAVELLING, "leggings", false);
		this.registerArmorTrims(generator, LaLItems.WANDERER_BOOTS, LaLEquipmentAssets.WANDERER, "boots", false);

	}

	private void uploadArmor2(ItemModelGenerators generator, ResourceLocation id, ResourceLocation layer0, ResourceLocation layer1) {
		ModelTemplates.TWO_LAYERED_ITEM.create(id, TextureMapping.layered(layer0, layer1), generator.modelOutput);
	}

	private void uploadArmor3(ItemModelGenerators generator, ResourceLocation id, ResourceLocation layer0, ResourceLocation layer1, ResourceLocation layer2) {
		ModelTemplates.THREE_LAYERED_ITEM.create(id, TextureMapping.layered(layer0, layer1, layer2), generator.modelOutput);
	}

	private void registerArmorTrims(ItemModelGenerators generator, Item armor, ResourceKey<EquipmentAsset> equipmentKey, String armorType, boolean dyeable) {
		ResourceLocation armorModelId = TextureMapping.getItemTexture(armor);
		ResourceLocation armorTextures = TextureMapping.getItemTexture(armor);
		ResourceLocation armorOverlayTextures = TextureMapping.getItemTexture(armor, "_overlay");
		for (ItemModelGenerators.TrimMaterialData trimMaterial : TRIM_MATERIALS) {
			ResourceLocation trimmedModelId = ResourceLocation.fromNamespaceAndPath(LaLConstants.MOD_ID,
					armorModelId.getPath()).withSuffix("_" + trimMaterial.assets().base().suffix() + "_trim");
			ResourceLocation trimTextureId = ResourceLocation.withDefaultNamespace(
					"trims/items/" + armorType + "_trim_" + trimMaterial.assets().assetId(equipmentKey).suffix());
			if (dyeable) {
				this.uploadArmor3(generator, trimmedModelId, armorTextures, armorOverlayTextures, trimTextureId);
			} else {
				this.uploadArmor2(generator, trimmedModelId, armorTextures, trimTextureId);
			}
		}
	}
}
