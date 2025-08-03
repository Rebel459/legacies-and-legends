package net.legacy.legacies_and_legends.mixin.integration.enchants_and_expeditions;

import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantable;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;
import java.util.stream.Stream;

@Mixin(ItemStack.class)
public abstract class EaEItemStackMixin {

    @Shadow public abstract DataComponentMap getComponents();

    @Shadow public abstract void applyComponents(DataComponentMap components);

    @Shadow public abstract Item getItem();

    @Shadow public abstract Stream<TagKey<Item>> getTags();

    @Shadow public abstract boolean is(TagKey<Item> tag);

    @Inject(at = @At("HEAD"), method = "inventoryTick")
    private void applyEnchantable(Level level, Entity entity, EquipmentSlot slot, CallbackInfo ci) {
        if (this.getComponents().has(DataComponents.ENCHANTABLE) || !this.getComponents().has(DataComponents.RARITY) || !this.is(LaLItemTags.VARIABLE_REPAIR_COST)) return;
        if (this.getItem().getDefaultInstance().get(DataComponents.RARITY).getSerializedName().equals("common")) {
            this.applyComponents(DataComponentMap.builder()
                    .set(DataComponents.ENCHANTABLE, new Enchantable(new Random().nextInt(16, 31)))
                    .build()
            );
        }
        else if (this.getItem().getDefaultInstance().get(DataComponents.RARITY).getSerializedName().equals("uncommon")) {
            this.applyComponents(DataComponentMap.builder()
                    .set(DataComponents.ENCHANTABLE, new Enchantable(new Random().nextInt(11, 26)))
                    .build()
            );
        }
        else if (this.getItem().getDefaultInstance().get(DataComponents.RARITY).getSerializedName().equals("rare")) {
            this.applyComponents(DataComponentMap.builder()
                    .set(DataComponents.ENCHANTABLE, new Enchantable(new Random().nextInt(6, 21)))
                    .build()
            );
        }
        else if (this.getItem().getDefaultInstance().get(DataComponents.RARITY).getSerializedName().equals("epic")) {
            this.applyComponents(DataComponentMap.builder()
                    .set(DataComponents.ENCHANTABLE, new Enchantable(new Random().nextInt(1, 16)))
                    .build()
            );
        }
    }
}