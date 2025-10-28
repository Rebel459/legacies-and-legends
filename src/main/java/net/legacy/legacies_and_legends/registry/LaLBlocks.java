package net.legacy.legacies_and_legends.registry;
import java.util.function.Function;

import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.block.WandPlatformBlock;
import net.legacy.legacies_and_legends.sound.LaLBlockSounds;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.NotNull;

public class LaLBlocks {
    public static final Block SAPPHIRE_LANTERN = register("sapphire_lantern",
            LanternBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLUE)
                    .forceSolidOn()
                    .strength(3.5F)
                    .lightLevel(blockStatex -> 14)
                    .sound(SoundType.LANTERN)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)
    );
    public static final Block SAPPHIRE_BLOCK = register("sapphire_block",
            Block::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLUE)
                    .forceSolidOn()
                    .strength(5F, 6F)
                    .sound(LaLBlockSounds.SAPPHIRE_BLOCK)
                    .requiresCorrectToolForDrops()
    );
    public static final DropExperienceBlock SAPPHIRE_ORE = register("sapphire_ore", (properties) -> new DropExperienceBlock(UniformInt.of(2, 5), properties),
            Properties.of()
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(3.0F, 3.0F)
                    .sound(SoundType.STONE)
    );
    public static final DropExperienceBlock DEEPSLATE_SAPPHIRE_ORE = register("deepslate_sapphire_ore", (properties) -> new DropExperienceBlock(UniformInt.of(2, 5), properties),
            Properties.of()
                    .mapColor(MapColor.DEEPSLATE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(4.5F, 3.0F)
                    .sound(SoundType.DEEPSLATE)
    );

    public static final WandPlatformBlock WAND_PLATFORM = register("wand_platform",
            WandPlatformBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLUE)
                    .noOcclusion()
                    .isViewBlocking(Blocks::never)
                    .noLootTable()
                    .isValidSpawn(Blocks::never)
                    .strength(3F, 6F)
                    .sound(LaLBlockSounds.WAND_PLATFORM)
                    .pushReaction(PushReaction.DESTROY)
    );

    public static void init() {
    }

    private static <T extends Block> @NotNull T registerWithoutItem(String path, Function<Properties, T> block, Properties properties) {
        ResourceLocation id = LaLConstants.id(path);
        return doRegister(id, makeBlock(block, properties, id));
    }

    private static <T extends Block> @NotNull T register(String path, Function<Properties, T> block, Properties properties) {
        T registered = registerWithoutItem(path, block, properties);
        Items.registerBlock(registered);
        return registered;
    }

    private static <T extends Block> @NotNull T doRegister(ResourceLocation id, T block) {
        if (BuiltInRegistries.BLOCK.getOptional(id).isEmpty()) {
            return Registry.register(BuiltInRegistries.BLOCK, id, block);
        }
        throw new IllegalArgumentException("Block with id " + id + " is already in the block registry.");
    }

    private static <T extends Block> T makeBlock(@NotNull Function<Properties, T> function, @NotNull Properties properties, ResourceLocation id) {
        return function.apply(properties.setId(ResourceKey.create(Registries.BLOCK, id)));
    }
}