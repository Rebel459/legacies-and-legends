package net.legacy.legacies_and_legends.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.frozenblock.lib.feature_flag.api.FeatureFlagApi;
import net.minecraft.core.RegistrySetBuilder;
import org.jetbrains.annotations.NotNull;

public final class LaLDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(@NotNull FabricDataGenerator dataGenerator) {
		FeatureFlagApi.rebuild();
		final FabricDataGenerator.Pack pack = dataGenerator.createPack();

		pack.addProvider(LaLModelProvider::new);
		pack.addProvider(LaLRegistryProvider::new);
        pack.addProvider(LaLItemTagProvider::new);
        pack.addProvider(LaLEntityTagProvider::new);
		pack.addProvider(LaLBlockTagProvider::new);
		pack.addProvider(LaLBlockLootProvider::new);
	}

	public void buildRegistry(RegistrySetBuilder registrySetBuilder) {
		LaLRegistryProvider.buildRegistry(registrySetBuilder);
	}
}
