package net.rebel459.legacies_and_legends;

import net.frozenblock.trimpatcher.client.util.TrimPaths;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.rebel459.legacies_and_legends.client.LaLEntityRenderers;
import net.rebel459.legacies_and_legends.client.LaLMenuScreens;
import net.rebel459.legacies_and_legends.client.LaLModelLayers;
import net.rebel459.legacies_and_legends.config.LaLConfig;
import net.rebel459.legacies_and_legends.registry.LaLEquipmentAssets;
import net.rebel459.unified.api.client.core.UnifiedClientHelpers;
import net.rebel459.unified.api.core.UnifiedPlatform;

public final class LegaciesAndLegendsClient {

    public static void initRegistries() {
        TrimPaths.addPath("travelling_strides", ItemModelGenerators.TRIM_PREFIX_LEGGINGS);
        LaLModelLayers.init();
        LaLEntityRenderers.init();
    }

    public static void init() {
        LaLMenuScreens.init();

        UnifiedClientHelpers.SIMPLE_BABY_ARMOR.add(LaLEquipmentAssets.REINFORCED);
        UnifiedClientHelpers.SIMPLE_BABY_ARMOR.add(LaLEquipmentAssets.TRAVELLING);
        UnifiedClientHelpers.SIMPLE_BABY_ARMOR.add(LaLEquipmentAssets.WANDERER);

        if (UnifiedPlatform.isModLoaded("farmersdelight") && LaLConfig.get().integrations.farmers_delight) {
            UnifiedClientHelpers.RESOURCE_PACKS.addRequired(LaLConstants.id("farmers_delight_integration"));
        }
        if (LaLConfig.get().misc.improved_turtle_shell) {
            UnifiedClientHelpers.RESOURCE_PACKS.addRequired(LaLConstants.id("improved_turtle_shell"));
        }
    }
}
