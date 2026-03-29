package net.rebel459.legacies_and_legends.sound;

import net.rebel459.legacies_and_legends.LaLConstants;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.rebel459.unified.platform.UnifiedRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class LaLSounds {
	
	public static UnifiedRegistries.SoundEvents SOUNDS = UnifiedRegistries.SoundEvents.create(LaLConstants.MOD_ID);
	
	public static final Holder<SoundEvent> MUSIC_DISC_SVALL = SOUNDS.registerHolder("music_disc.svall");
	public static final Holder<SoundEvent> MUSIC_DISC_TASWELL = SOUNDS.registerHolder("music_disc.taswell");
	public static final Holder<SoundEvent> MUSIC_DISC_SHULKER = SOUNDS.registerHolder("music_disc.shulker");
	public static final Holder<SoundEvent> MUSIC_DISC_TUNDRA = SOUNDS.registerHolder("music_disc.tundra");
	public static final Holder<SoundEvent> MUSIC_DISC_FAR_LANDS = SOUNDS.registerHolder("music_disc.far_lands");
	public static final Holder<SoundEvent> MUSIC_DISC_INFINITE_SPOOKY_AMETHYST = SOUNDS.registerHolder("music_disc.infinite_spooky_amethyst");
	public static final Holder<SoundEvent> MUSIC_DISC_113 = SOUNDS.registerHolder("music_disc.113");
	public static final Holder<SoundEvent> MUSIC_DISC_GRAVEL = SOUNDS.registerHolder("music_disc.gravel");

	public static final Holder<SoundEvent> TABLET_USE = SOUNDS.registerHolder("tablet.use");
	public static final Holder<SoundEvent> TABLET_BREAK = SOUNDS.registerHolder("tablet.break");
	public static final Supplier<SoundEvent> TABLET_TELEPORT = SOUNDS.register("tablet.teleport");

	public static final Supplier<SoundEvent> BOOMERANG_THROW = SOUNDS.register("boomerang.throw");
	public static final Supplier<SoundEvent> BOOMERANG_HIT = SOUNDS.register("boomerang.hit");
	public static final Supplier<SoundEvent> BOOMERANG_RETURN = SOUNDS.register("boomerang.return");
	public static final Supplier<SoundEvent> BOOMERANG_WHOOSH = SOUNDS.register("boomerang.whoosh");

	public static final Supplier<SoundEvent> WAND_SUMMON = SOUNDS.register("wand.summon");
	public static final Supplier<SoundEvent> WAND_RECALL = SOUNDS.register("wand.recall");

	public static final Supplier<SoundEvent> TOTEM_EQUIP = SOUNDS.register("accessory.totem_equip");
	public static final Supplier<SoundEvent> AMULET_EQUIP = SOUNDS.register("accessory.amulet_equip");
	public static final Supplier<SoundEvent> RING_EQUIP = SOUNDS.register("accessory.ring_equip");
	public static final Supplier<SoundEvent> NECKLACE_EQUIP = SOUNDS.register("accessory.necklace_equip");

	public static final Supplier<SoundEvent> ACCESSORY_BREAK = SOUNDS.register("accessory.break");

	public static final Supplier<SoundEvent> SAPPHIRE_BLOCK_BREAK = SOUNDS.register("block.sapphire_block.break");
	public static final Supplier<SoundEvent> SAPPHIRE_BLOCK_STEP = SOUNDS.register("block.sapphire_block.step");
	public static final Supplier<SoundEvent> SAPPHIRE_BLOCK_PLACE = SOUNDS.register("block.sapphire_block.place");
	public static final Supplier<SoundEvent> SAPPHIRE_BLOCK_HIT = SOUNDS.register("block.sapphire_block.hit");
	public static final Supplier<SoundEvent> SAPPHIRE_BLOCK_FALL = SOUNDS.register("block.sapphire_block.fall");

	public static final Supplier<SoundEvent> WAND_PLATFORM_BREAK = SOUNDS.register("block.wand_platform.break");
	public static final Supplier<SoundEvent> WAND_PLATFORM_STEP = SOUNDS.register("block.wand_platform.step");
	public static final Supplier<SoundEvent> WAND_PLATFORM_PLACE = SOUNDS.register("block.wand_platform.place");
	public static final Supplier<SoundEvent> WAND_PLATFORM_HIT = SOUNDS.register("block.wand_platform.hit");
	public static final Supplier<SoundEvent> WAND_PLATFORM_FALL = SOUNDS.register("block.wand_platform.fall");

	public static final Supplier<SoundEvent> SHATTER = SOUNDS.register("enchantment.shatter");

	public static final Holder<SoundEvent> SNOWY_MUSIC = SOUNDS.registerHolder("music.overworld.snowy");
	public static final Holder<SoundEvent> SAVANNA_MUSIC = SOUNDS.registerHolder("music.overworld.savanna");
	public static final Holder<SoundEvent> DARK_FOREST_MUSIC = SOUNDS.registerHolder("music.overworld.dark_forest");
	public static final Holder<SoundEvent> MAIN_END_ISLAND_MUSIC = SOUNDS.registerHolder("music.the_end.main_island");

	public static final Holder<SoundEvent> STRONGHOLD_MUSIC = SOUNDS.registerHolder("music.structure.stronghold");
	public static final Holder<SoundEvent> ANCIENT_CITY_MUSIC = SOUNDS.registerHolder("music.structure.ancient_city");

	public static void init() {}
}
