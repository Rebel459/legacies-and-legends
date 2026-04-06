package net.rebel459.legacies_and_legends.registry;
import java.util.function.Function;
import java.util.function.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SnowballItem;
import net.rebel459.legacies_and_legends.LaLConstants;
import net.rebel459.legacies_and_legends.block.GlowStickBlock;
import net.rebel459.legacies_and_legends.block.WandPlatformBlock;
import net.rebel459.legacies_and_legends.item.GlowStickItem;
import net.rebel459.legacies_and_legends.sound.LaLBlockSounds;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.rebel459.unified.platform.UnifiedRegistries;
import net.rebel459.unified.util.SuppliedBlock;
import net.rebel459.unified.util.SuppliedItem;
import org.jetbrains.annotations.NotNull;

public class LaLBlocks {
    
    public static UnifiedRegistries.Blocks BLOCKS = UnifiedRegistries.Blocks.create(LaLConstants.MOD_ID);

    public static final SuppliedBlock SAPPHIRE_LANTERN = BLOCKS.register("sapphire_lantern",
            LanternBlock::new,
            () -> Properties.of()
                    .mapColor(MapColor.COLOR_BLUE)
                    .forceSolidOn()
                    .strength(3.5F)
                    .lightLevel(_ -> 14)
                    .sound(SoundType.LANTERN)
                    .noOcclusion()
                    .pushReaction(PushReaction.DESTROY)
    );
    public static final SuppliedBlock SAPPHIRE_BLOCK = BLOCKS.register("sapphire_block",
            Block::new,
            () -> Properties.of()
                    .mapColor(MapColor.COLOR_BLUE)
                    .forceSolidOn()
                    .strength(5F, 6F)
                    .sound(LaLBlockSounds.SAPPHIRE_BLOCK)
                    .requiresCorrectToolForDrops()
    );
    public static final SuppliedBlock SAPPHIRE_ORE = BLOCKS.register("sapphire_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(2, 5), properties),
            () -> Properties.of()
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(3.0F, 3.0F)
                    .sound(SoundType.STONE)
    );
    public static final SuppliedBlock DEEPSLATE_SAPPHIRE_ORE = BLOCKS.register("deepslate_sapphire_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(2, 5), properties),
            () -> Properties.of()
                    .mapColor(MapColor.DEEPSLATE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(4.5F, 3.0F)
                    .sound(SoundType.DEEPSLATE)
    );

    public static final SuppliedBlock WAND_PLATFORM = BLOCKS.register("wand_platform",
            WandPlatformBlock::new,
            () -> Properties.of()
                    .mapColor(MapColor.COLOR_BLUE)
                    .noOcclusion()
                    .isViewBlocking(Blocks::never)
                    .noLootTable()
                    .isValidSpawn((_, _, _, _) -> false)
                    .strength(3F, 6F)
                    .sound(LaLBlockSounds.WAND_PLATFORM)
                    .pushReaction(PushReaction.DESTROY)
    );

    public static final SuppliedBlock GLOW_STICK = BLOCKS.registerWithoutItem("glow_stick",
            GlowStickBlock::new,
            () -> Properties.of()
                    .mapColor(MapColor.COLOR_LIGHT_GREEN)
                    .lightLevel(_ -> 15)
                    .sound(SoundType.STONE)
                    .noOcclusion()
                    .instabreak()
                    .pushReaction(PushReaction.DESTROY)
    );

    public static void init() {}
}