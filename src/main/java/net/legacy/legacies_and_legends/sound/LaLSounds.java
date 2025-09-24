package net.legacy.legacies_and_legends.sound;

import net.legacy.legacies_and_legends.LaLConstants;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

public class LaLSounds {
	public static final Holder.Reference<SoundEvent> MUSIC_DISC_SVALL = registerForHolder("music_disc.svall");
	public static final Holder.Reference<SoundEvent> MUSIC_DISC_TASWELL = registerForHolder("music_disc.taswell");
	public static final Holder.Reference<SoundEvent> MUSIC_DISC_SHULKER = registerForHolder("music_disc.shulker");
	public static final Holder.Reference<SoundEvent> MUSIC_DISC_TUNDRA = registerForHolder("music_disc.tundra");
	public static final Holder.Reference<SoundEvent> MUSIC_DISC_FAR_LANDS = registerForHolder("music_disc.far_lands");
	public static final Holder.Reference<SoundEvent> MUSIC_DISC_INFINITE_SPOOKY_AMETHYST = registerForHolder("music_disc.infinite_spooky_amethyst");
	public static final Holder.Reference<SoundEvent> MUSIC_DISC_113 = registerForHolder("music_disc.113");
	public static final Holder.Reference<SoundEvent> MUSIC_DISC_GRAVEL = registerForHolder("music_disc.gravel");

	public static final Holder.Reference<SoundEvent> TABLET_USE = registerForHolder("tablet.use");
	public static final Holder.Reference<SoundEvent> TABLET_BREAK = registerForHolder("tablet.break");
	public static final SoundEvent TABLET_TELEPORT = register("tablet.teleport");

	public static final SoundEvent BOOMERANG_THROW = register("boomerang.throw");
	public static final SoundEvent BOOMERANG_HIT = register("boomerang.hit");
	public static final SoundEvent BOOMERANG_RETURN = register("boomerang.return");
	public static final SoundEvent BOOMERANG_WHOOSH = register("boomerang.whoosh");

	public static final SoundEvent WAND_SUMMON = register("wand.summon");
	public static final SoundEvent WAND_RECALL = register("wand.recall");

	public static final SoundEvent TOTEM_EQUIP = register("accessory.totem_equip");
	public static final SoundEvent AMULET_EQUIP = register("accessory.amulet_equip");
	public static final SoundEvent RING_EQUIP = register("accessory.ring_equip");
	public static final SoundEvent NECKLACE_EQUIP = register("accessory.necklace_equip");

	public static final SoundEvent ACCESSORY_BREAK = register("accessory.break");

	public static final SoundEvent SAPPHIRE_BLOCK_BREAK = register("block.sapphire_block.break");
	public static final SoundEvent SAPPHIRE_BLOCK_STEP = register("block.sapphire_block.step");
	public static final SoundEvent SAPPHIRE_BLOCK_PLACE = register("block.sapphire_block.place");
	public static final SoundEvent SAPPHIRE_BLOCK_HIT = register("block.sapphire_block.hit");
	public static final SoundEvent SAPPHIRE_BLOCK_FALL = register("block.sapphire_block.fall");

	public static final SoundEvent WAND_PLATFORM_BREAK = register("block.wand_platform.break");
	public static final SoundEvent WAND_PLATFORM_STEP = register("block.wand_platform.step");
	public static final SoundEvent WAND_PLATFORM_PLACE = register("block.wand_platform.place");
	public static final SoundEvent WAND_PLATFORM_HIT = register("block.wand_platform.hit");
	public static final SoundEvent WAND_PLATFORM_FALL = register("block.wand_platform.fall");

	public static final SoundEvent SHATTER = register("enchantment.shatter");

	public static final Holder.Reference<SoundEvent> SNOWY_MUSIC = registerForHolder("music.overworld.snowy");
	public static final Holder.Reference<SoundEvent> SAVANNA_MUSIC = registerForHolder("music.overworld.savanna");
	public static final Holder.Reference<SoundEvent> DARK_FOREST_MUSIC = registerForHolder("music.overworld.dark_forest");
	public static final Holder.Reference<SoundEvent> MAIN_END_ISLAND_MUSIC = registerForHolder("music.the_end.main_island");

	@NotNull
	private static SoundEvent register(@NotNull String string) {
		ResourceLocation resourceLocation = LaLConstants.id(string);
		return Registry.register(BuiltInRegistries.SOUND_EVENT, resourceLocation, SoundEvent.createVariableRangeEvent(resourceLocation));
	}

	private static Holder.@NotNull Reference<SoundEvent> registerForHolder(String id) {
		return registerForHolder(LaLConstants.id(id));
	}

	private static Holder.@NotNull Reference<SoundEvent> registerForHolder(ResourceLocation id) {
		return registerForHolder(id, id);
	}

	private static Holder.@NotNull Reference<SoundEvent> registerForHolder(ResourceLocation id, ResourceLocation soundId) {
		return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(soundId));
	}

	public static void init() {}
}
