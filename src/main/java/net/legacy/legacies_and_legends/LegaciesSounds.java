package net.legacy.legacies_and_legends;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

public class LegaciesSounds {
	public static final Holder.Reference<SoundEvent> MUSIC_DISC_SVALL = registerForHolder("music_disc.svall");
	public static final Holder.Reference<SoundEvent> MUSIC_DISC_TASWELL = registerForHolder("music_disc.taswell");
	public static final Holder.Reference<SoundEvent> MUSIC_DISC_SHULKER = registerForHolder("music_disc.shulker");
	public static final Holder.Reference<SoundEvent> MUSIC_DISC_TUNDRA = registerForHolder("music_disc.tundra");
	public static final Holder.Reference<SoundEvent> MUSIC_DISC_FAR_LANDS = registerForHolder("music_disc.far_lands");

	@NotNull
	private static SoundEvent register(@NotNull String string) {
		ResourceLocation resourceLocation = LegaciesConstants.id(string);
		return Registry.register(BuiltInRegistries.SOUND_EVENT, resourceLocation, SoundEvent.createVariableRangeEvent(resourceLocation));
	}

	private static Holder.@NotNull Reference<SoundEvent> registerForHolder(String id) {
		return registerForHolder(LegaciesConstants.id(id));
	}

	private static Holder.@NotNull Reference<SoundEvent> registerForHolder(ResourceLocation id) {
		return registerForHolder(id, id);
	}

	private static Holder.@NotNull Reference<SoundEvent> registerForHolder(ResourceLocation id, ResourceLocation soundId) {
		return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(soundId));
	}

	public static void init() {}
}
