package net.rebel459.legacies_and_legends.mixin.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.rebel459.item_tooltips.config.ITConfig;
import net.rebel459.legacies_and_legends.config.LaLConfig;
import net.rebel459.legacies_and_legends.item.WandItem;
import net.rebel459.legacies_and_legends.registry.LaLDataComponents;
import net.rebel459.legacies_and_legends.registry.LaLItems;
import net.rebel459.legacies_and_legends.tag.LaLItemTags;
import net.rebel459.legacies_and_legends.util.AccessoryHelper;
import net.rebel459.legacies_and_legends.util.AccessoryInterface;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.component.UseRemainder;
import net.minecraft.world.level.Level;
import net.rebel459.legacies_and_legends.util.Gem;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    @Shadow public abstract void applyComponents(DataComponentMap components);

    @Shadow
    public abstract boolean is(Predicate<Holder<Item>> item);

    @Inject(at = @At("HEAD"), method = "finishUsingItem")
    private void useTablet(Level level, LivingEntity livingEntity, CallbackInfoReturnable<ItemStack> cir) {
        if (this.is(item -> item.is(LaLItemTags.TABLETS))) {
            if (new Random().nextInt(5) >= 1) {
                this.applyComponents(DataComponentMap.builder()
                        .set(DataComponents.USE_REMAINDER, new UseRemainder(LaLItems.TABLET.getTemplate()))
                        .build()
                );
            }
        }
    }

    @Inject(at = @At("HEAD"), method = "addDetailsToTooltip")
    private void gemTooltips(Item.TooltipContext context, TooltipDisplay display, @Nullable Player player, TooltipFlag tooltipFlag, Consumer<Component> consumer, CallbackInfo ci) {
        ItemStack stack = ItemStack.class.cast(this);
        if (stack.has(LaLDataComponents.WAND_SLOTS.get())) {
            Gem.Slots gems = stack.get(LaLDataComponents.WAND_SLOTS.get());
            gems.primary().createTooltip(consumer, true);
            gems.secondary().createTooltip(consumer, false);
        }
        if (stack.has(LaLDataComponents.GEM.get())) {
            stack.get(LaLDataComponents.GEM.get()).createTooltip(consumer, true);
        }
    }

    @Inject(at = @At("TAIL"), method = "inventoryTick")
    private void inventoryTick(Level level, Entity entity, EquipmentSlot equipmentSlot, CallbackInfo ci) {
        ItemStack stack = ItemStack.class.cast(this);
        if (entity instanceof Player player && stack.is(LaLItemTags.ACCESSORIES) && player instanceof AccessoryInterface accessory) {
            //if (AccessoryHelper.getAccessory(player) != stack) {
            AccessoryHelper.Mutable mutable = accessory.getAccessoryData();
            if (stack.is(LaLItemTags.AMULETS)) {
                mutable.onTickAmulet(player, stack);
            }
            accessory.setAccessoryData(mutable);
            //}
        }
    }
}
