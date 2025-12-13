package net.legacy.legacies_and_legends.mixin.integration.enchants_and_expeditions;

import dev.emi.trinkets.api.SlotReference;
import net.legacy.legacies_and_legends.item.AccessoryItem;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(AccessoryItem.class)
public abstract class EaEAccessoryItemMixin {

    @Inject(at = @At("HEAD"), method = "tick")
    private void applyEnchantable(ItemStack stack, SlotReference slot, LivingEntity livingEntity, CallbackInfo ci) {
        if (!stack.getComponents().has(DataComponents.ENCHANTABLE) && stack.getComponents().has(DataComponents.RARITY)) {
            if (stack.get(DataComponents.RARITY).getSerializedName().equals("common")) {
                stack.applyComponents(DataComponentPatch.builder()
                        .set(DataComponents.ENCHANTABLE, new Enchantable(new Random().nextInt(16, 31)))
                        .build()
                );
            }
            else if (stack.get(DataComponents.RARITY).getSerializedName().equals("uncommon")) {
                stack.applyComponents(DataComponentPatch.builder()
                        .set(DataComponents.ENCHANTABLE, new Enchantable(new Random().nextInt(11, 26)))
                        .build()
                );
            }
            else if (stack.get(DataComponents.RARITY).getSerializedName().equals("rare")) {
                stack.applyComponents(DataComponentPatch.builder()
                        .set(DataComponents.ENCHANTABLE, new Enchantable(new Random().nextInt(6, 21)))
                        .build()
                );
            }
            else if (stack.get(DataComponents.RARITY).getSerializedName().equals("epic")) {
                stack.applyComponents(DataComponentPatch.builder()
                        .set(DataComponents.ENCHANTABLE, new Enchantable(new Random().nextInt(1, 16)))
                        .build()
                );
            }
        }
    }
}