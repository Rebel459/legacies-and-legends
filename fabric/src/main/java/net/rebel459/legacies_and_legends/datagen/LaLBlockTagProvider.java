package net.rebel459.legacies_and_legends.datagen;

import net.minecraft.tags.BlockTags;
import net.rebel459.legacies_and_legends.LaLConstants;
import net.rebel459.legacies_and_legends.registry.LaLBlocks;
import net.rebel459.legacies_and_legends.tag.LaLBlockTags;
import net.rebel459.unified.api.data.helper.TagGenerator;

public final class LaLBlockTagProvider {

    public static void init() {

        TagGenerator generator = LaLConstants.DATA.helpers().tags();

        generator.create(LaLBlockTags.SAPPHIRE_ORES)
                .add(LaLBlocks.SAPPHIRE_ORE.key())
                .add(LaLBlocks.DEEPSLATE_SAPPHIRE_ORE.key());

        generator.create(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(LaLBlocks.SAPPHIRE_BLOCK.key())
                .add(LaLBlocks.SAPPHIRE_LANTERN.key())
                .add(LaLBlocks.SAPPHIRE_ORE.key())
                .add(LaLBlocks.DEEPSLATE_SAPPHIRE_ORE.key())
                .add(LaLBlocks.METEORITE.key())
                .add(LaLBlocks.CONCENTRATED_METEORITE.key())
                .add(LaLBlocks.METEORITE_BRICKS.key())
                .add(LaLBlocks.METEORITE_BRICK_STAIRS.key())
                .add(LaLBlocks.METEORITE_BRICK_SLAB.key())
                .add(LaLBlocks.METEORITE_BRICK_WALL.key())
                .add(LaLBlocks.CHISELED_METEORITE_BRICKS.key());

        generator.create(BlockTags.NEEDS_IRON_TOOL)
                .add(LaLBlocks.SAPPHIRE_BLOCK.key())
                .add(LaLBlocks.SAPPHIRE_ORE.key())
                .add(LaLBlocks.DEEPSLATE_SAPPHIRE_ORE.key())
                .add(LaLBlocks.METEORITE.key())
                .add(LaLBlocks.CONCENTRATED_METEORITE.key())
                .add(LaLBlocks.METEORITE_BRICKS.key())
                .add(LaLBlocks.METEORITE_BRICK_STAIRS.key())
                .add(LaLBlocks.METEORITE_BRICK_SLAB.key())
                .add(LaLBlocks.METEORITE_BRICK_WALL.key())
                .add(LaLBlocks.CHISELED_METEORITE_BRICKS.key());

        generator.create(BlockTags.SLABS)
                .add(LaLBlocks.WAND_PLATFORM.key())
                .add(LaLBlocks.METEORITE_BRICK_SLAB.key());

        generator.create(BlockTags.STAIRS)
                .add(LaLBlocks.METEORITE_BRICK_STAIRS.key());

        generator.create(BlockTags.WALLS)
                .add(LaLBlocks.METEORITE_BRICK_WALL.key());

        generator.create(BlockTags.MINEABLE_WITH_AXE)
                .add(LaLBlocks.JEWELING_TABLE.key());

        generator.create(BlockTags.BEACON_BASE_BLOCKS)
                .add(LaLBlocks.SAPPHIRE_BLOCK.key());
    }
}
