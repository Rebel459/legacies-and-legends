package net.legacy.legacies_and_legends.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.legacy.legacies_and_legends.registry.LaLBlocks;
import net.legacy.legacies_and_legends.tag.LaLBlockTags;
import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public final class LaLBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public LaLBlockTagProvider(@NotNull FabricDataOutput output, @NotNull CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider arg) {
        this.valueLookupBuilder(LaLBlockTags.SAPPHIRE_ORES)
                .add(LaLBlocks.SAPPHIRE_ORE)
                .add(LaLBlocks.DEEPSLATE_SAPPHIRE_ORE);

        this.valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(LaLBlocks.SAPPHIRE_BLOCK)
                .add(LaLBlocks.SAPPHIRE_LANTERN)
                .add(LaLBlocks.SAPPHIRE_ORE)
                .add(LaLBlocks.DEEPSLATE_SAPPHIRE_ORE);

        this.valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(LaLBlocks.SAPPHIRE_BLOCK)
                .add(LaLBlocks.SAPPHIRE_ORE)
                .add(LaLBlocks.DEEPSLATE_SAPPHIRE_ORE);

        this.valueLookupBuilder(BlockTags.SLABS)
                .add(LaLBlocks.WAND_PLATFORM);

        this.valueLookupBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(LaLBlocks.SAPPHIRE_BLOCK);
    }
}
