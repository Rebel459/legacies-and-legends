package net.legacy.legacies_and_legends.registry;

import net.legacy.legacies_and_legends.LaLConstants;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class LaLMobEffects {
    public static final Holder<MobEffect> FREEZING = register(
            "freezing",
            new MobEffect(MobEffectCategory.HARMFUL, 7720931)
    );
    public static final Holder<MobEffect> INSTABILITY = register(
            "instability", (
                    new MobEffect(MobEffectCategory.NEUTRAL, 7901340)
                            .addAttributeModifier(Attributes.MAX_ABSORPTION, Identifier.withDefaultNamespace("effect.absorption"), 2.0, AttributeModifier.Operation.ADD_VALUE)
                            .addAttributeModifier(Attributes.ATTACK_DAMAGE, Identifier.withDefaultNamespace("effect.weakness"), -2.0, AttributeModifier.Operation.ADD_VALUE)
                            .addAttributeModifier(Attributes.GRAVITY, LaLConstants.id("effect.gravity"), -0.04, AttributeModifier.Operation.ADD_VALUE)
                            .addAttributeModifier(Attributes.SAFE_FALL_DISTANCE, LaLConstants.id("effect.safe_fall_distance"), 2, AttributeModifier.Operation.ADD_VALUE)
            )
    );
    public static final Holder<MobEffect> WARPING = register(
            "warping",
                    new MobEffect(MobEffectCategory.NEUTRAL, 9337599)
    );

    public static void applyFreezing(LivingEntity entity, int duration) {
        entity.addEffect(new MobEffectInstance(LaLMobEffects.FREEZING, duration));
        if (entity.getTicksFrozen() < duration) entity.setTicksFrozen(duration);
    }

    public static void init() {
    }

    private static Holder<MobEffect> register(String path, MobEffect effect) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, Identifier.fromNamespaceAndPath(LaLConstants.MOD_ID, path), effect);
    }
}
