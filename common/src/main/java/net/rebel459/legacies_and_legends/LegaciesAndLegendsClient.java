package net.rebel459.legacies_and_legends;

import net.frozenblock.trimpatcher.client.util.TrimPaths;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.rebel459.legacies_and_legends.client.LaLEntityRenderers;
import net.rebel459.legacies_and_legends.client.LaLModelLayers;
import net.rebel459.legacies_and_legends.config.LaLConfig;
import net.rebel459.legacies_and_legends.registry.LaLEquipmentAssets;
import net.rebel459.unified.platform.UnifiedHelpers;
import net.rebel459.unified.platform.UnifiedPlatform;
import net.rebel459.unified.platform.client.UnifiedClientHelpers;
import net.rebel459.unified.util.PackType;

public final class LegaciesAndLegendsClient {

    public static void initRegistries() {
        TrimPaths.addPath("travelling_strides", ItemModelGenerators.TRIM_PREFIX_LEGGINGS);
    }

    public static void init() {
        LaLEntityRenderers.init();
        LaLModelLayers.init();

        UnifiedClientHelpers.LEGACY_BABY_ARMOR.add(LaLEquipmentAssets.REINFORCED);
        UnifiedClientHelpers.LEGACY_BABY_ARMOR.add(LaLEquipmentAssets.TRAVELLING);
        UnifiedClientHelpers.LEGACY_BABY_ARMOR.add(LaLEquipmentAssets.WANDERER);

        if (LaLConfig.get().music.music_and_melody) {
            UnifiedHelpers.PACKS.add(LaLConstants.id("music_and_melody"), PackType.REQUIRED_RESOURCES);
        }
        if (!LaLConfig.get().music.end_portal_music) {
            UnifiedHelpers.PACKS.add(LaLConstants.id("no_end_portal_music"), PackType.REQUIRED_RESOURCES);
        }
        if (UnifiedPlatform.get().isModLoaded("farmersdelight") && LaLConfig.get().integrations.farmers_delight) {
            UnifiedHelpers.PACKS.add(LaLConstants.id("farmers_delight_integration"), PackType.REQUIRED_RESOURCES);
        }
    }
}
