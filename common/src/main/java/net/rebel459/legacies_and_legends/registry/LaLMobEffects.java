package net.rebel459.legacies_and_legends.registry;

import net.rebel459.legacies_and_legends.LaLConstants;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.rebel459.unified.platform.UnifiedRegistries;

public class LaLMobEffects {

    public static UnifiedRegistries.DeferredRegistry EFFECTS = UnifiedRegistries.DeferredRegistry.create(LaLConstants.MOD_ID, BuiltInRegistries.MOB_EFFECT);

    public static final Holder<MobEffect> FREEZING = EFFECTS.registerHolder(
            "freezing",
            () -> new MobEffect(MobEffectCategory.HARMFUL, 7720931) {}
    );
    public static final Holder<MobEffect> INSTABILITY = EFFECTS.registerHolder(
            "instability", () -> (
                    new MobEffect(MobEffectCategory.NEUTRAL, 7901340) {}
                            .addAttributeModifier(Attributes.MAX_ABSORPTION, Identifier.withDefaultNamespace("effect.absorption"), 2.0, AttributeModifier.Operation.ADD_VALUE)
                            .addAttributeModifier(Attributes.ATTACK_DAMAGE, Identifier.withDefaultNamespace("effect.weakness"), -2.0, AttributeModifier.Operation.ADD_VALUE)
                            .addAttributeModifier(Attributes.GRAVITY, LaLConstants.id("effect.gravity"), -0.04, AttributeModifier.Operation.ADD_VALUE)
                            .addAttributeModifier(Attributes.SAFE_FALL_DISTANCE, LaLConstants.id("effect.safe_fall_distance"), 2, AttributeModifier.Operation.ADD_VALUE)
            )
    );
    public static final Holder<MobEffect> WARPING = EFFECTS.registerHolder(
            "warping",
            () -> new MobEffect(MobEffectCategory.NEUTRAL, 9337599) {}
    );

    public static void applyFreezing(ServerLevel level, LivingEntity attacked, LivingEntity attacker, int duration) {
        attacked.addEffect(new MobEffectInstance(LaLMobEffects.FREEZING, duration));
        level.sendParticles(ParticleTypes.SNOWFLAKE, attacked.getX(), attacked.getRandomY(), attacked.getZ(), 10, 0, -1, 0, 0.5);
        level.playSound(attacked, attacked.blockPosition(), SoundEvents.SNOW_HIT, attacker.getSoundSource());
        if (attacked.getTicksFrozen() < duration) attacked.setTicksFrozen(duration);
    }

    public static void init() {}
}
