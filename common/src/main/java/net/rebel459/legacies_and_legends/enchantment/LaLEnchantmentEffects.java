package net.rebel459.legacies_and_legends.enchantment;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.rebel459.legacies_and_legends.LaLConstants;
import net.rebel459.unified.platform.UnifiedRegistries;

public class LaLEnchantmentEffects {

    public static UnifiedRegistries.EnchantmentCodecs ENCHANTMENTS = UnifiedRegistries.EnchantmentCodecs.create(LaLConstants.MOD_ID);

    private static void registerEntityAndLocationBasedEffect(final String path, final MapCodec<? extends EnchantmentEntityEffect> codec) {
        ENCHANTMENTS.registerEntityEffect(path, codec);
        ENCHANTMENTS.registerLocationBasedEffect(path, codec);
    }

    public static void init() {
        registerEntityAndLocationBasedEffect("freeze", LaLFreezeEffect.CODEC);
    }

    private LaLEnchantmentEffects() {}
}