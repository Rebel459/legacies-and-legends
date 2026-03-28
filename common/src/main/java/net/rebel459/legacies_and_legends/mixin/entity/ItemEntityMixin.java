package net.rebel459.legacies_and_legends.mixin.entity;

import net.rebel459.legacies_and_legends.registry.LaLItems;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomModelData;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin extends Entity {

    @Shadow
    public abstract ItemStack getItem();

    protected ItemEntityMixin(EntityType<?> type, Level level) {
        super(type, level);
    }

    @Inject(at = @At("HEAD"), method = "tick()V")
    private void dropWand(CallbackInfo ci) {
        if (this.getItem().is(LaLItems.WAND)) {
            this.getItem().applyComponents(DataComponentPatch.builder()
                    .set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(List.of(), List.of(true), List.of(), List.of()))
                    .build()
            );
        }
    }
}