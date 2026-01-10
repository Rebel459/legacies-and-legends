package net.legacy.legacies_and_legends.mixin.effect;

import net.legacy.legacies_and_legends.config.LaLConfig;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.UseRemainder;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(MobEffectUtil.class)
public abstract class MobEffectUtilMixin {

    @Inject(at = @At("TAIL"), method = "hasDigSpeed", cancellable = true)
    private static void hasTurtleHelmet(LivingEntity livingEntity, CallbackInfoReturnable<Boolean> cir) {
        if (!LaLConfig.get.misc.improved_turtle_shell) return;
        cir.setReturnValue(cir.getReturnValue() || (livingEntity instanceof Player player && player.isUnderWater() && player.isEquipped(Items.TURTLE_HELMET)));
    }

    @Inject(at = @At("TAIL"), method = "getDigSpeedAmplification", cancellable = true)
    private static void turtleHelmetDigSpeed(LivingEntity livingEntity, CallbackInfoReturnable<Integer> cir) {
        if (!LaLConfig.get.misc.improved_turtle_shell) return;
        int speed = 0;
        if (livingEntity instanceof Player player && player.isUnderWater() && player.isEquipped(Items.TURTLE_HELMET)) speed = 1;
        cir.setReturnValue(Math.max(cir.getReturnValue(), speed));
    }
}