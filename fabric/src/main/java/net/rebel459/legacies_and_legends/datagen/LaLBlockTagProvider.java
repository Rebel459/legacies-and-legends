package net.rebel459.legacies_and_legends.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.rebel459.legacies_and_legends.registry.LaLBlocks;
import net.rebel459.legacies_and_legends.tag.LaLBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public final class LaLBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public LaLBlockTagProvider(@NotNull FabricPackOutput output, @NotNull CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider arg) {
        this.valueLookupBuilder(LaLBlockTags.SAPPHIRE_ORES)
                .add(LaLBlocks.SAPPHIRE_ORE.get())
                .add(LaLBlocks.DEEPSLATE_SAPPHIRE_ORE.get());

        this.valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(LaLBlocks.SAPPHIRE_BLOCK.get())
                .add(LaLBlocks.SAPPHIRE_LANTERN.get())
                .add(LaLBlocks.SAPPHIRE_ORE.get())
                .add(LaLBlocks.DEEPSLATE_SAPPHIRE_ORE.get());

        this.valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(LaLBlocks.SAPPHIRE_BLOCK.get())
                .add(LaLBlocks.SAPPHIRE_ORE.get())
                .add(LaLBlocks.DEEPSLATE_SAPPHIRE_ORE.get());

        this.valueLookupBuilder(BlockTags.SLABS)
                .add(LaLBlocks.WAND_PLATFORM.get());

        this.valueLookupBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(LaLBlocks.SAPPHIRE_BLOCK.get());
    }
}
