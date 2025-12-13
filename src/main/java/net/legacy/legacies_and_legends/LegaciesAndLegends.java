package net.legacy.legacies_and_legends;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.legacy.legacies_and_legends.config.LaLConfig;
import net.legacy.legacies_and_legends.enchantment.LaLEnchantmentEffects;
import net.legacy.legacies_and_legends.registry.LaLEnchantments;
import net.legacy.legacies_and_legends.registry.LaLMobEffects;
import net.legacy.legacies_and_legends.registry.*;
import net.legacy.legacies_and_legends.sound.LaLJukeboxSongs;
import net.legacy.legacies_and_legends.sound.LaLBiomeMusic;
import net.legacy.legacies_and_legends.sound.LaLSounds;
import net.legacy.legacies_and_legends.worldgen.LaLFeatures;
import net.minecraft.network.chat.Component;

import java.util.Optional;

public class LegaciesAndLegends implements ModInitializer {

	public static boolean isVillagerConfigLoaded = false;
	public static boolean isProgressionRebornLoaded = false;
	public static boolean isFarmersDelightLoaded = false;
	public static boolean isWilderWildLoaded = false;
	public static boolean isVariantsAndVenturesLoaded = false;
	public static boolean isTrailierTalesLoaded = false;
	public static boolean isEnchantsAndExpeditionsLoaded = false;
	public static boolean isEnderscapeLoaded = false;

	@Override
	public void onInitialize() {
		Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer(LaLConstants.MOD_ID);

		LaLItems.init();
		LaLBlocks.init();
		LaLCreativeInventorySorting.init();
		LaLJukeboxSongs.init();
		LaLSounds.init();
		LaLFuelRegistry.registerFuels();
		LaLTrimItemModels.init();
		LaLEntityTypes.init();
		LaLConfig.init();
		LaLEnchantmentEffects.register();
		LaLMobEffects.init();
		LaLLootTables.init();
		LaLEnchantments.init();
		LaLBiomeMusic.init();
		LaLMapDecorationTypes.init();
		LaLDataComponents.init();
		LaLFeatures.init();

		if (LaLConfig.get.loot.lore_books) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("lore_books"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.lore_books"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (!LaLConfig.get.misc.save_vanilla_cooldowns) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("save_vanilla_cooldowns"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.save_vanilla_cooldowns"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (!LaLConfig.get.loot.improved_loot) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("no_improved_loot"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.no_improved_loot"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (LaLConfig.get.structures.dungeon_overhaul) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("dungeon_overhaul"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.dungeon_overhaul"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (LaLConfig.get.structures.swamp_hut_variants) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("swamp_hut_variants"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.swamp_hut_variants"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (LaLConfig.get.structures.buried_treasure_rework) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("buried_treasure_rework"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.reworked_buried_treasure"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (LaLConfig.get.misc.accessory_slot) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("accessory_slot"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.accessory_slot"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (!LaLConfig.get.structures.new_structures) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("no_new_structures"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.no_new_structures"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (!LaLConfig.get.artifacts.travelling_strides) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("no_travelling_strides"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.no_travelling_strides"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (!LaLConfig.get.artifacts.withered_hoe) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("no_withered_hoe"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.no_withered_hoe"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (!LaLConfig.get.worldgen.sapphire) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("no_sapphire"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.no_sapphire"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (LaLConfig.get.misc.no_creeper_discs) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("no_creeper_discs"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.no_creeper_discs"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (FabricLoader.getInstance().isModLoaded("enchants_and_expeditions")) {
			isEnchantsAndExpeditionsLoaded = true;
		}
		if (FabricLoader.getInstance().isModLoaded("progression_reborn")) {
			isProgressionRebornLoaded = true;
		}
		if (FabricLoader.getInstance().isModLoaded("farmersdelight") && LaLConfig.get.integrations.farmers_delight) {
			isFarmersDelightLoaded = true;
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("farmers_delight_integration"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.farmers_delight_integration"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (FabricLoader.getInstance().isModLoaded("villagerconfig") && LaLConfig.get.misc.wandering_trader_trades && LaLConfig.get.loot.wooden_buckets && LaLConfig.get.loot.metal_chunk && LaLConfig.get.artifacts.tablet_of_recall && LaLConfig.get.artifacts.tablet_of_haste && LaLConfig.get.artifacts.tablet_of_revealing && LaLConfig.get.structures.dungeon_overhaul) {
			isVillagerConfigLoaded = true;
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("wandering_trader_trades"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.wandering_trader_trades"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (FabricLoader.getInstance().isModLoaded("wilderwild") && LaLConfig.get.integrations.wilder_wild) {
			isWilderWildLoaded = true;
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("wilder_wild_integration"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.wilder_wild_integration"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (FabricLoader.getInstance().isModLoaded("trailiertales") && LaLConfig.get.integrations.trailier_tales) {
			isTrailierTalesLoaded = true;
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("trailier_tales_integration"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.trailier_tales_integration"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (FabricLoader.getInstance().isModLoaded("variantsandventures") && LaLConfig.get.integrations.variants_and_ventures) {
			isVariantsAndVenturesLoaded = true;
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("variants_and_ventures_integration"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.variants_and_ventures_integration"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (FabricLoader.getInstance().isModLoaded("enderscape") && LaLConfig.get.integrations.enderscape) {
			isEnderscapeLoaded = true;
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("enderscape_integration"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.enderscape_integration"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
	}
}