package net.rebel459.legacies_and_legends.mixin.integration.enchants_and_expeditions;

import net.rebel459.legacies_and_legends.util.AccessoryHelper;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.stream.Stream;

@Mixin(ItemStack.class)
public abstract class EaEItemStackMixin {

    @Shadow public abstract DataComponentMap getComponents();

    @Shadow public abstract Item getItem();

    @Unique
    private int secondTicks = 20;

    @Inject(at = @At("HEAD"), method = "inventoryTick")
    private void applyEnchantable(Level level, Entity entity, EquipmentSlot slot, CallbackInfo ci) {
        ItemStack stack = ItemStack.class.cast(this);

        if (secondTicks >= 20) {
            AccessoryHelper.setupRandomComponents(stack, RandomSource.create());
            secondTicks = 0;
        } else {
            secondTicks += 1;
        }
    }
}