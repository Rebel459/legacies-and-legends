package net.legacy.legacies_and_legends.registry;

import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.LegaciesAndLegends;
import net.legacy.legacies_and_legends.config.LaLConfig;
import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.component.ProvidesTrimMaterial;
import net.minecraft.world.item.enchantment.Repairable;
import org.jetbrains.annotations.NotNull;

import java.util.function.UnaryOperator;

public class LaLDataComponents {

    public static void init(){
        DefaultItemComponentEvents.MODIFY.register(context -> {
            context.modify(Items.TRIDENT, builder -> {
                builder.set(DataComponents.ATTRIBUTE_MODIFIERS, TridentItem.createAttributes());
                HolderGetter<Item> holderGetter = BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.ITEM);
                builder.set(DataComponents.REPAIRABLE, new Repairable(holderGetter.getOrThrow(LaLItemTags.TRIDENT_REPAIR_MATERIALS)));
            });
            if (!LegaciesAndLegends.isProgressionRebornLoaded) {
                context.modify(LaLItems.NECKLACE_OF_REGENERATION, builder -> {
                    HolderGetter<Item> holderGetter = BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.ITEM);
                    builder.set(DataComponents.REPAIRABLE, new Repairable(holderGetter.getOrThrow(LaLItemTags.REGENERATION_NECKLACE_MATERIALS_FALLBACK)));
                });
            }
            if (LaLConfig.get.misc.echo_shard_trim) {
                context.modify(Items.ECHO_SHARD, builder -> {
                    builder.set(DataComponents.PROVIDES_TRIM_MATERIAL, new ProvidesTrimMaterial(LaLTrimMaterials.ECHO));
                });
            }
            if (LaLConfig.get.misc.stackable_saddles) {
                context.modify(Items.SADDLE, builder -> {
                    builder.set(DataComponents.MAX_STACK_SIZE, 16);
                });
            }
        });
    }

    private static <T> @NotNull DataComponentType<T> register(String id, @NotNull UnaryOperator<DataComponentType.Builder<T>> unaryOperator) {
        return Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, LaLConstants.id(id), unaryOperator.apply(DataComponentType.builder()).build());
    }
}