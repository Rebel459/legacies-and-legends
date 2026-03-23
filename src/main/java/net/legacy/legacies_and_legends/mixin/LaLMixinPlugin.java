package net.legacy.legacies_and_legends.mixin;

import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.loader.api.FabricLoader;
import net.legacy.legacies_and_legends.config.LaLConfig;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public final class LaLMixinPlugin implements IMixinConfigPlugin {

    private static boolean hasEnchantsAndExpeditions;
    public static boolean hasCombatReborn;
    private static boolean hasFriendsAndFoes;

    @Override
    public void onLoad(String mixinPackage) {
        LaLConfig.get = AutoConfig.getConfigHolder(LaLConfig.class).getConfig();
        hasEnchantsAndExpeditions = FabricLoader.getInstance().isModLoaded("enchants_and_expeditions");
        hasCombatReborn = FabricLoader.getInstance().isModLoaded("combat_reborn");
        hasFriendsAndFoes = FabricLoader.getInstance().isModLoaded("friendsandfoes");
    }

    @Override
    @Nullable
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, @NotNull String mixinClassName) {

        if (mixinClassName.contains("integration.enchants_and_expeditions.")) return hasEnchantsAndExpeditions;
        if (mixinClassName.contains("integration.combat_reborn.")) return hasCombatReborn;
        if (mixinClassName.contains("integration.friendsandfoes.")) return hasFriendsAndFoes;

        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}

    @Override
    @Nullable
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
}