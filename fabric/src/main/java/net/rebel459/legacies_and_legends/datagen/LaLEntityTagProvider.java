package net.rebel459.legacies_and_legends.datagen;

import net.minecraft.world.entity.EntityType;
import net.rebel459.legacies_and_legends.LaLConstants;
import net.rebel459.legacies_and_legends.registry.LaLEntityTypes;
import net.rebel459.legacies_and_legends.tag.LaLEntityTags;
import net.rebel459.unified.api.data.helper.TagGenerator;

public class LaLEntityTagProvider {

    public static void init() {

        TagGenerator generator = LaLConstants.DATA.helpers().tags();

        generator.create(LaLEntityTags.DAMAGELESS_PROJECTILES)
                .add(EntityType.WIND_CHARGE.builtInRegistryHolder().key())
                .add(EntityType.BREEZE_WIND_CHARGE.builtInRegistryHolder().key())
                .add(EntityType.SNOWBALL.builtInRegistryHolder().key())
                .add(EntityType.EGG.builtInRegistryHolder().key())
                .add(LaLEntityTypes.GLOW_STICK.key());
    }
}
