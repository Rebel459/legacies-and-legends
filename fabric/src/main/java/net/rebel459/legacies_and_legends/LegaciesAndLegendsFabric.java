package net.rebel459.legacies_and_legends;

import net.fabricmc.api.ModInitializer;
import net.rebel459.legacies_and_legends.datagen.LaLBlockTagProvider;
import net.rebel459.legacies_and_legends.datagen.LaLEntityTagProvider;
import net.rebel459.legacies_and_legends.datagen.LaLItemTagProvider;
import net.rebel459.unified.fabric.FabricUnifiedInitializer;

public class LegaciesAndLegendsFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        LegaciesAndLegends.initRegistries();
        FabricUnifiedInitializer.register(this::onInitializeCommon);
    }

    public void onInitializeCommon() {
        LegaciesAndLegends.init();
        LaLBlockTagProvider.init();
        LaLEntityTagProvider.init();
        LaLItemTagProvider.init();
    }
}
