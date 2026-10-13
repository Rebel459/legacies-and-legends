package net.rebel459.legacies_and_legends;

import net.rebel459.legacies_and_legends.config.LaLConfig;
import net.rebel459.legacies_and_legends.enchantment.LaLEnchantmentEffects;
import net.rebel459.legacies_and_legends.event.PlayerEvents;
import net.rebel459.legacies_and_legends.event.ServerEvents;
import net.rebel459.legacies_and_legends.registry.*;
import net.rebel459.legacies_and_legends.sound.LaLJukeboxSongs;
import net.rebel459.legacies_and_legends.sound.LaLSounds;
import net.rebel459.legacies_and_legends.worldgen.LaLFeatures;
import net.rebel459.unified.api.core.UnifiedHelpers;
import net.rebel459.unified.api.core.UnifiedPlatform;

public class LegaciesAndLegends {

	public static boolean isProgressionRebornLoaded = false;
	public static boolean isFarmersDelightLoaded = false;
    public static boolean isBloomLoaded = false;
    public static boolean isWilderWildLoaded = false;
	public static boolean isVariantsAndVenturesLoaded = false;
	public static boolean isTrailierTalesLoaded = false;
    public static boolean isEnchantsAndExpeditionsLoaded() {
        return UnifiedPlatform.isModLoaded("enchants_and_expeditions");
    }
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
        LaLMenus.init();
        LaLFeatures.init();
	}

    public static void init() {
        LaLCreativeInventorySorting.init();
        LaLLootTables.init();
        ServerEvents.init();
        PlayerEvents.init();
    }

    public static void loadResources() {

        isCombatRebornLoaded = UnifiedPlatform.isModLoaded("combat_reborn");

        if (LaLConfig.get().structures.dungeon_overhaul) {
            UnifiedHelpers.DATA_PACKS.addRequired(LaLConstants.id("dungeon_overhaul"));
        }
        if (LaLConfig.get().structures.swamp_hut_variants) {
            UnifiedHelpers.DATA_PACKS.addRequired(LaLConstants.id("swamp_hut_variants"));
        }
        if (LaLConfig.get().structures.buried_treasure_rework) {
            UnifiedHelpers.DATA_PACKS.addRequired(LaLConstants.id("buried_treasure_rework"));
        }
        if (!LaLConfig.get().structures.new_structures) {
            UnifiedHelpers.DATA_PACKS.addRequired(LaLConstants.id("no_new_structures"));
        }
        if (!LaLConfig.get().artifacts.travelling_strides) {
            UnifiedHelpers.DATA_PACKS.addRequired(LaLConstants.id("no_travelling_strides"));
        }
        if (!LaLConfig.get().magic.sapphire) {
            UnifiedHelpers.DATA_PACKS.addRequired(LaLConstants.id("no_sapphire"));
        }
        if (!LaLConfig.get().magic.wands) {
            UnifiedHelpers.DATA_PACKS.addRequired(LaLConstants.id("no_wands"));
        }
        if (!LaLConfig.get().magic.jeweling) {
            UnifiedHelpers.DATA_PACKS.addRequired(LaLConstants.id("no_jeweling"));
        }
        if (!LaLConfig.get().magic.meteors) {
            UnifiedHelpers.DATA_PACKS.addRequired(LaLConstants.id("no_meteors"));
        }
        if (!LaLConfig.get().loot.glow_stick) {
            UnifiedHelpers.DATA_PACKS.addRequired(LaLConstants.id("no_glow_sticks"));
        }
        if (LaLConfig.get().misc.no_creeper_discs) {
            UnifiedHelpers.DATA_PACKS.addRequired(LaLConstants.id("no_creeper_discs"));
        }
        if (UnifiedPlatform.isModLoaded("end_reborn")) {
            isEndRebornLoaded = true;
        }
        if (UnifiedPlatform.isModLoaded("progression_reborn")) {
            isProgressionRebornLoaded = true;
        }
        if (UnifiedPlatform.isModLoaded("farmersdelight") && LaLConfig.get().integrations.farmers_delight) {
            isFarmersDelightLoaded = true;
            UnifiedHelpers.DATA_PACKS.addRequired(LaLConstants.id("farmers_delight_integration"));
        }
        if (LaLConfig.get().misc.wandering_trader_trades) {
            UnifiedHelpers.DATA_PACKS.addRequired(LaLConstants.id("wandering_trader_trades"));
        }
        if (UnifiedPlatform.isModLoaded("bloom") && LaLConfig.get().integrations.bloom) {
            isBloomLoaded = true;
            UnifiedHelpers.DATA_PACKS.addRequired(LaLConstants.id("bloom_integration"));
        }
        if (UnifiedPlatform.isModLoaded("wilderwild") && LaLConfig.get().integrations.wilder_wild) {
            isWilderWildLoaded = true;
            UnifiedHelpers.DATA_PACKS.addRequired(LaLConstants.id("wilder_wild_integration"));
        }
        if (UnifiedPlatform.isModLoaded("trailiertales") && LaLConfig.get().integrations.trailier_tales) {
            isTrailierTalesLoaded = true;
            UnifiedHelpers.DATA_PACKS.addRequired(LaLConstants.id("trailier_tales_integration"));
        }
        if (UnifiedPlatform.isModLoaded("variantsandventures") && LaLConfig.get().integrations.variants_and_ventures) {
            isVariantsAndVenturesLoaded = true;
            if (LaLConfig.get().structures.dungeon_overhaul) {
                UnifiedHelpers.DATA_PACKS.addRequired(LaLConstants.id("variants_and_ventures_integration"));
            }
        }
        if (UnifiedPlatform.isModLoaded("enderscape") && LaLConfig.get().integrations.enderscape) {
            isEnderscapeLoaded = true;
            UnifiedHelpers.DATA_PACKS.addRequired(LaLConstants.id("enderscape_integration"));
            if (LaLConfig.get().magic.jeweling) {
                UnifiedHelpers.DATA_PACKS.addRequired(LaLConstants.id("enderscape_jeweling"));
            }
        }
    }
}
