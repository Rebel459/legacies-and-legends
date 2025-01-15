package net.legacy.legacies_and_legends.datagen;

import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.legacy.legacies_and_legends.*;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public final class LaLModelProvider extends FabricModelProvider {
	public static final List<Pair<BooleanProperty, Function<ResourceLocation, Variant>>> MULTIFACE_GENERATOR_NO_UV_LOCK = List.of(
		Pair.of(BlockStateProperties.NORTH, model -> Variant.variant().with(VariantProperties.MODEL, model)),
		Pair.of(
			BlockStateProperties.EAST,
			model -> Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)
		),
		Pair.of(
			BlockStateProperties.SOUTH,
			model -> Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)
		),
		Pair.of(
			BlockStateProperties.WEST,
			model -> Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)
		),
		Pair.of(
			BlockStateProperties.UP,
			model -> Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.X_ROT, VariantProperties.Rotation.R270)
		),
		Pair.of(
			BlockStateProperties.DOWN,
			resourceLocation -> Variant.variant()
				.with(VariantProperties.MODEL, resourceLocation)
				.with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)
		)
	);

	public LaLModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(@NotNull BlockModelGenerators generator) {
		generator.createTrivialCube(LaLBlocks.CRACKED_END_STONE_BRICKS);
	}

	@Override
	public void generateItemModels(@NotNull ItemModelGenerators generator) {
		generator.generateTrimmableItem(LaLGearItems.DUNGEON_HELMET, LaLEquipmentAssets.DUNGEON, "helmet", false);
		generator.generateTrimmableItem(LaLGearItems.DUNGEON_CHESTPLATE, LaLEquipmentAssets.DUNGEON, "chestplate", false);
		generator.generateTrimmableItem(LaLGearItems.DUNGEON_LEGGINGS, LaLEquipmentAssets.DUNGEON, "leggings", false);
		generator.generateTrimmableItem(LaLGearItems.DUNGEON_BOOTS, LaLEquipmentAssets.DUNGEON, "boots", false);

		generator.generateTrimmableItem(LaLGearItems.FORTRESS_HELMET, LaLEquipmentAssets.FORTRESS, "helmet", false);
		generator.generateTrimmableItem(LaLGearItems.FORTRESS_CHESTPLATE, LaLEquipmentAssets.FORTRESS, "chestplate", false);
		generator.generateTrimmableItem(LaLGearItems.FORTRESS_LEGGINGS, LaLEquipmentAssets.FORTRESS, "leggings", false);
		generator.generateTrimmableItem(LaLGearItems.FORTRESS_BOOTS, LaLEquipmentAssets.FORTRESS, "boots", false);

		generator.generateTrimmableItem(LaLGearItems.WARD_HELMET, LaLEquipmentAssets.WARD, "helmet", false);
		generator.generateTrimmableItem(LaLGearItems.WARD_CHESTPLATE, LaLEquipmentAssets.WARD, "chestplate", false);
		generator.generateTrimmableItem(LaLGearItems.WARD_LEGGINGS, LaLEquipmentAssets.WARD, "leggings", false);
		generator.generateTrimmableItem(LaLGearItems.WARD_BOOTS, LaLEquipmentAssets.WARD, "boots", false);

		generator.generateFlatItem(LaLGearItems.KNIFE, ModelTemplates.FLAT_HANDHELD_ITEM);
		generator.generateFlatItem(LaLGearItems.HOOK, ModelTemplates.FLAT_HANDHELD_ITEM);

		generator.generateFlatItem(LaLItems.METAL_CHUNK, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.DISC_FRAGMENT_FAR_LANDS, ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(LaLItems.CREAK_POTTERY_SHERD, ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(LaLItems.WOODEN_BUCKET, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.CHARCOAL_BUCKET, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.COAL_BUCKET, ModelTemplates.FLAT_ITEM);

		generator.generateFlatItem(LaLItems.MUSIC_DISC_SVALL, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.MUSIC_DISC_TASWELL, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.MUSIC_DISC_TUNDRA, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.MUSIC_DISC_FAR_LANDS, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(LaLItems.MUSIC_DISC_SHULKER, ModelTemplates.FLAT_ITEM);
	}

	@Contract("_, _ -> new")
	private static @NotNull ModelTemplate createItem(String string, TextureSlot... textureSlots) {
		return new ModelTemplate(Optional.of(LaLConstants.id("item/" + string)), Optional.empty(), textureSlots);
	}
}
