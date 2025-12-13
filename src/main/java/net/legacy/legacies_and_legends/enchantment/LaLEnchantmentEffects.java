package net.legacy.legacies_and_legends.enchantment;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.item.enchantment.effects.EnchantmentLocationBasedEffect;

public class LaLEnchantmentEffects {

    private static void registerEntityEffect(final Identifier identifier, final MapCodec<? extends EnchantmentEntityEffect> codec) {
        registerLocationBasedEffect(identifier, codec);
        Registry.register(BuiltInRegistries.ENCHANTMENT_ENTITY_EFFECT_TYPE, identifier, codec);
    }

    private static void registerLocationBasedEffect(final Identifier identifier, final MapCodec<? extends EnchantmentLocationBasedEffect> codec) {
        Registry.register(BuiltInRegistries.ENCHANTMENT_LOCATION_BASED_EFFECT_TYPE, identifier, codec);
    }

    public static void register() {
        registerEntityEffect(LaLFreezeEffect.IDENTIFIER, LaLFreezeEffect.CODEC);
    }

    private LaLEnchantmentEffects() {}
}