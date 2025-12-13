package net.legacy.legacies_and_legends.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.legacy.legacies_and_legends.tag.LaLEntityTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.entity.EntityType;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class LaLEntityTagProvider extends FabricTagProvider.EntityTypeTagProvider {

    public LaLEntityTagProvider(@NotNull FabricDataOutput output, @NotNull CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider arg) {
        this.valueLookupBuilder(LaLEntityTags.DAMAGELESS_PROJECTILES)
                .add(EntityType.WIND_CHARGE)
                .add(EntityType.BREEZE_WIND_CHARGE)
                .add(EntityType.SNOWBALL)
                .add(EntityType.EGG);
    }
}
