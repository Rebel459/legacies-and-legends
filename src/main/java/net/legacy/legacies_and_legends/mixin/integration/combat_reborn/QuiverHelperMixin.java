package net.legacy.legacies_and_legends.mixin.integration.combat_reborn;

import net.legacy.combat_reborn.mixin.item.ProjectileWeaponItemMixin;
import net.legacy.combat_reborn.util.QuiverHelper;
import net.legacy.legacies_and_legends.mixin.LaLMixinPlugin;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.legacy.legacies_and_legends.util.AccessoryHelper;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(QuiverHelper.class)
public abstract class QuiverHelperMixin {

    @Inject(at = @At("TAIL"), method = "getStack", cancellable = true)
    private static void ringOfArchery(Player player, CallbackInfoReturnable<ItemStack> cir) {
        if (cir.getReturnValue() != null || !AccessoryHelper.hasAccessory(player)) return;
        ItemStack stack = AccessoryHelper.getAccessory(player);
        if (stack.is(LaLItems.RING_OF_ARCHERY)) cir.setReturnValue(stack);
    }

    @Inject(at = @At("TAIL"), method = "getAccuracy(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/player/Player;)F", cancellable = true)
    private static void ringOfArcheryAccuracy(ItemStack stack, Player player, CallbackInfoReturnable<Float> cir) {
        if (player == null || !AccessoryHelper.hasAccessory(player)) return;
        if (AccessoryHelper.getAccessory(player).is(LaLItems.RING_OF_ARCHERY)) cir.setReturnValue(cir.getReturnValue() + 4);
    }

    @Inject(at = @At("TAIL"), method = "postProjectileEvent")
    private static void ringOfArcheryDamage(Player player, CallbackInfo ci) {
        if (!AccessoryHelper.hasAccessory(player)) return;
        ItemStack stack = AccessoryHelper.getAccessory(player);
        if (stack.is(LaLItems.RING_OF_ARCHERY)) AccessoryHelper.damageAccessory(player, stack);
    }
}