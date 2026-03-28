package net.rebel459.legacies_and_legends.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.rebel459.legacies_and_legends.registry.LaLBlocks;
import net.minecraft.core.HolderLookup;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public final class LaLBlockLootProvider extends FabricBlockLootSubProvider {

	public LaLBlockLootProvider(@NotNull FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registries) {
		super(dataOutput, registries);
	}

	@Override
	public void generate() {
		this.dropSelf(LaLBlocks.SAPPHIRE_BLOCK.get());
		this.dropSelf(LaLBlocks.SAPPHIRE_LANTERN.get());
	}
}