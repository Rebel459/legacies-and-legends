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
import net.legacy.legacies_and_legends.sound.LaLMusic;
import net.legacy.legacies_and_legends.sound.LaLSounds;
import net.minecraft.network.chat.Component;

import java.util.Optional;

public class LegaciesAndLegends implements ModInitializer {

	public static boolean isVillagerConfigLoaded = false;
	public static boolean isWilderWildLoaded = false;
	public static boolean isVariantsAndVenturesLoaded = false;
	public static boolean isTrailierTalesLoaded = false;
	public static boolean isEnchantsAndExpeditionsLoaded = false;
	public static boolean isEnderscapeLoaded = false;

	@Override
	public void onInitialize() {
		Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer("legacies_and_legends");

		LaLItems.init();
		LaLEquipmentItems.init();
		LaLCreativeInventorySorting.init();
		LaLJukeboxSongs.init();
		LaLSounds.init();
		LaLFuelRegistry.registerFuels();
		LaLTrimItemModels.init();
		LaLEntityTypes.init();
		LaLConfig.initClient();
		LaLEnchantmentEffects.register();
		LaLMobEffects.init();
		LaLLootTables.init();
		LaLEnchantments.init();
		LaLMusic.insertMusic();
		LaLMapDecorationTypes.init();
		LaLItemComponents.init();

		ResourceManagerHelper.registerBuiltinResourcePack(
				LaLConstants.id("asset_overrides"), modContainer.get(),
				Component.translatable("pack.legacies_and_legends.asset_overrides"),
				ResourcePackActivationType.ALWAYS_ENABLED
		);
		if (LaLConfig.get.music.music_and_melody) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("music_and_melody"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.music_and_melody"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (!LaLConfig.get.music.end_portal_music) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("no_end_portal_music"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.no_end_portal_music"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (LaLConfig.get.loot.lore_books) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("lore_books"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.lore_books"),
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
		if (LaLConfig.get.misc.new_trim_materials) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("new_trim_materials"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.new_trim_materials"),
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
		if (!LaLConfig.get.loot.trident_shard) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("no_trident_shard"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.no_trident_shard"),
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
		if (isEnchantsAndExpeditionsLoaded || !LaLConfig.get.enchantments.extraction) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					LaLConstants.id("no_extraction_enchant"), modContainer.get(),
					Component.translatable("pack.legacies_and_legends.no_extraction_enchant"),
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