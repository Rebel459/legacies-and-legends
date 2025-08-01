package net.legacy.legacies_and_legends.mixin.item;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketsApi;
import net.legacy.legacies_and_legends.config.LaLConfig;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.legacy.legacies_and_legends.sound.LaLSounds;
import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(Trinket.class)
public interface TrinketMixin {

    @Inject(at = @At("HEAD"), method = "tick")
    private void removeTotem(ItemStack stack, SlotReference slot, LivingEntity livingEntity, CallbackInfo ci) {
        if (LaLConfig.get.misc.accessory_of_undying && livingEntity instanceof Player player && TrinketsApi.getTrinketComponent(livingEntity).isPresent()) {
            if (player.getTags().contains("used_totem") && (TrinketsApi.getTrinketComponent(livingEntity).get().isEquipped(LaLItems.TOTEM_OF_TELEPORTATION) || TrinketsApi.getTrinketComponent(livingEntity).get().isEquipped(LaLItems.TOTEM_OF_RESURRECTION) || TrinketsApi.getTrinketComponent(livingEntity).get().isEquipped(Items.TOTEM_OF_UNDYING))) {
                player.removeTag("used_totem");
                slot.inventory().removeItem(slot.index(), 1);
            }
        }
    }

    @Inject(at = @At("HEAD"), method = "onEquip")
    private void equipSound(ItemStack stack, SlotReference slot, LivingEntity livingEntity, CallbackInfo ci) {
        if (livingEntity instanceof Player player) {
            if (stack.is(LaLItemTags.TOTEMS)) player.playSound(LaLSounds.TOTEM_EQUIP);
            else if (stack.is(LaLItemTags.AMULETS)) player.playSound(LaLSounds.AMULET_EQUIP);
            else if (stack.is(LaLItemTags.NECKLACES)) player.playSound(LaLSounds.NECKLACE_EQUIP);
            else if (stack.is(LaLItemTags.RINGS)) player.playSound(LaLSounds.RING_EQUIP);
        }
    }
}