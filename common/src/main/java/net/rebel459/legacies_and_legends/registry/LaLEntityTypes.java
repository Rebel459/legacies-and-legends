package net.rebel459.legacies_and_legends.registry;

import net.rebel459.legacies_and_legends.LaLConstants;
import net.rebel459.legacies_and_legends.entity.BoomerangProjectile;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.rebel459.unified.platform.UnifiedRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public final class LaLEntityTypes {

    public static UnifiedRegistries.EntityTypes ENTITIES = UnifiedRegistries.EntityTypes.create(LaLConstants.MOD_ID);

    public static final @NotNull Supplier<EntityType<BoomerangProjectile>> BOOMERANG = ENTITIES.register(
            "boomerang",
            EntityType.Builder.<BoomerangProjectile>of(BoomerangProjectile::new, MobCategory.MISC)
                    .sized(0.5F, 0.25F)
                    .clientTrackingRange(64)
                    .updateInterval(10)
    );

    public static void init() {
    }

    private static <T extends Entity> @NotNull EntityType<T> register(String string, EntityType.@NotNull Builder<T> builder) {
        ResourceKey<EntityType<?>> resourceKey = ResourceKey.create(Registries.ENTITY_TYPE, LaLConstants.id(string));
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, resourceKey, builder.build(resourceKey));
    }
}