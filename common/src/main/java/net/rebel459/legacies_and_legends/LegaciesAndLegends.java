package net.rebel459.legacies_and_legends;

import net.minecraft.world.level.gamerules.GameRules;
import net.rebel459.legacies_and_legends.config.LaLConfig;
import net.rebel459.legacies_and_legends.enchantment.LaLEnchantmentEffects;
import net.rebel459.legacies_and_legends.registry.*;
import net.rebel459.legacies_and_legends.sound.LaLMusic;
import net.rebel459.legacies_and_legends.sound.LaLJukeboxSongs;
import net.rebel459.legacies_and_legends.sound.LaLSounds;
import net.rebel459.legacies_and_legends.util.AccessoryHelper;
import net.rebel459.legacies_and_legends.worldgen.LaLFeatures;
import net.rebel459.unified.platform.UnifiedEvents;
import net.rebel459.unified.platform.UnifiedHelpers;
import net.rebel459.unified.platform.UnifiedPlatform;
import net.rebel459.unified.util.PackType;

public class LegaciesAndLegends {

	public static boolean isProgressionRebornLoaded = false;
	public static boolean isFarmersDelightLoaded = false;
    public static boolean isBloomLoaded = false;
    public static boolean isWilderWildLoaded = false;
	public static boolean isVariantsAndVenturesLoaded = false;
	public static boolean isTrailierTalesLoaded = false;
    public static boolean isEnchantsAndExpeditionsLoaded = false;
    public static boolean isEndRebornLoaded = false;
	public static boolean isEnderscapeLoaded = false;
    public static boolean isCombatRebornLoaded = false;

	public static void initRegistries() {

        LaLConfig.init();

        loadResources();

		LaLItems.init();
		LaLBlocks.init();
		LaLJukeboxSongs.init();
		LaLSounds.init();
		LaLEntityTypes.init();
		LaLEnchantmentEffects.init();
		LaLMobEffects.init();
		LaLEnchantments.init();
		LaLMapDecorationTypes.init();
		LaLDataComponents.init();
        LaLFeatures.init();
	}

    public static void init() {
        LaLCreativeInventorySorting.init();
        LaLLootTables.init();
        LaLMusic.init();

        UnifiedEvents.Players.onRespawn((oldPlayer, newPlayer) -> {
            var level = newPlayer.level;
            var serverLevel = level.getServer().getLevel(level.dimension());
            if (serverLevel == null) return;
            if (serverLevel.getGameRules().get(GameRules.KEEP_INVENTORY)) AccessoryHelper.setAccessory(newPlayer, AccessoryHelper.getActualAccessory(oldPlayer));
        });
    }

    public static void loadResources() {

        isCombatRebornLoaded = UnifiedPlatform.get().isModLoaded("combat_reborn");

        if (LaLConfig.get().loot.lore_books) {
            UnifiedHelpers.PACKS.add(LaLConstants.id("lore_books"), PackType.REQUIRED_DATA);
        }
        if (!LaLConfig.get().misc.save_vanilla_cooldowns) {
            UnifiedHelpers.PACKS.add(LaLConstants.id("save_vanilla_cooldowns"), PackType.REQUIRED_DATA);
        }
        if (!LaLConfig.get().loot.improved_loot) {
            UnifiedHelpers.PACKS.add(LaLConstants.id("no_improved_loot"), PackType.REQUIRED_DATA);
        }
        if (LaLConfig.get().structures.dungeon_overhaul) {
            UnifiedHelpers.PACKS.add(LaLConstants.id("dungeon_overhaul"), PackType.REQUIRED_DATA);
        }
        if (LaLConfig.get().structures.swamp_hut_variants) {
            UnifiedHelpers.PACKS.add(LaLConstants.id("swamp_hut_variants"), PackType.REQUIRED_DATA);
        }
        if (LaLConfig.get().structures.buried_treasure_rework) {
            UnifiedHelpers.PACKS.add(LaLConstants.id("buried_treasure_rework"), PackType.REQUIRED_DATA);
        }
        if (!LaLConfig.get().structures.new_structures) {
            UnifiedHelpers.PACKS.add(LaLConstants.id("no_new_structures"), PackType.REQUIRED_DATA);
        }
        if (!LaLConfig.get().artifacts.travelling_strides) {
            UnifiedHelpers.PACKS.add(LaLConstants.id("no_travelling_strides"), PackType.REQUIRED_DATA);
        }
        if (!LaLConfig.get().artifacts.withered_hoe) {
            UnifiedHelpers.PACKS.add(LaLConstants.id("no_withered_hoe"), PackType.REQUIRED_DATA);
        }
        if (!LaLConfig.get().worldgen.sapphire) {
            UnifiedHelpers.PACKS.add(LaLConstants.id("no_sapphire"), PackType.REQUIRED_DATA);
        }
        if (LaLConfig.get().misc.no_creeper_discs) {
            UnifiedHelpers.PACKS.add(LaLConstants.id("no_creeper_discs"), PackType.REQUIRED_DATA);
        }
        if (LaLConfig.get().misc.improved_turtle_shell) {
            UnifiedHelpers.PACKS.add(LaLConstants.id("improved_turtle_shell"), PackType.REQUIRED_DATA);
        }
        if (UnifiedPlatform.get().isModLoaded("enchants_and_expeditions")) {
            isEnchantsAndExpeditionsLoaded = true;
        }
        if (UnifiedPlatform.get().isModLoaded("end_reborn")) {
            isEndRebornLoaded = true;
        }
        if (UnifiedPlatform.get().isModLoaded("progression_reborn")) {
            isProgressionRebornLoaded = true;
        }
        if (UnifiedPlatform.get().isModLoaded("farmersdelight") && LaLConfig.get().integrations.farmers_delight) {
            isFarmersDelightLoaded = true;
            UnifiedHelpers.PACKS.add(LaLConstants.id("farmers_delight_integration"), PackType.REQUIRED_DATA);
        }
        if (LaLConfig.get().misc.wandering_trader_trades && LaLConfig.get().loot.wooden_buckets && LaLConfig.get().loot.metal_chunk && LaLConfig.get().artifacts.tablet_of_recall && LaLConfig.get().artifacts.tablet_of_haste && LaLConfig.get().artifacts.tablet_of_revealing && LaLConfig.get().structures.dungeon_overhaul) {
            UnifiedHelpers.PACKS.add(LaLConstants.id("wandering_trader_trades"), PackType.REQUIRED_DATA);
        }
        if (UnifiedPlatform.get().isModLoaded("bloom") && LaLConfig.get().integrations.bloom) {
            isBloomLoaded = true;
            UnifiedHelpers.PACKS.add(LaLConstants.id("bloom_integration"), PackType.REQUIRED_DATA);
        }
        if (UnifiedPlatform.get().isModLoaded("wilderwild") && LaLConfig.get().integrations.wilder_wild) {
            isWilderWildLoaded = true;
            UnifiedHelpers.PACKS.add(LaLConstants.id("wilder_wild_integration"), PackType.REQUIRED_DATA);
        }
        if (UnifiedPlatform.get().isModLoaded("trailiertales") && LaLConfig.get().integrations.trailier_tales) {
            isTrailierTalesLoaded = true;
            UnifiedHelpers.PACKS.add(LaLConstants.id("trailier_tales_integration"), PackType.REQUIRED_DATA);
        }
        if (UnifiedPlatform.get().isModLoaded("variantsandventures") && LaLConfig.get().integrations.variants_and_ventures) {
            isVariantsAndVenturesLoaded = true;
            if (LaLConfig.get().structures.dungeon_overhaul) {
                UnifiedHelpers.PACKS.add(LaLConstants.id("variants_and_ventures_integration"), PackType.REQUIRED_DATA);
            }
        }
        if (UnifiedPlatform.get().isModLoaded("enderscape") && LaLConfig.get().integrations.enderscape) {
            isEnderscapeLoaded = true;
            UnifiedHelpers.PACKS.add(LaLConstants.id("enderscape_integration"), PackType.REQUIRED_DATA);
        }
    }
}