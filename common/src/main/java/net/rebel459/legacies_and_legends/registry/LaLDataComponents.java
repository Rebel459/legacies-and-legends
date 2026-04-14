package net.rebel459.legacies_and_legends.registry;

import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.registries.VanillaRegistries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.enchantment.Repairable;
import net.minecraft.world.item.equipment.trim.TrimMaterials;
import net.rebel459.legacies_and_legends.LaLConstants;
import net.rebel459.legacies_and_legends.LegaciesAndLegends;
import net.rebel459.legacies_and_legends.config.LaLConfig;
import net.rebel459.legacies_and_legends.tag.LaLItemTags;
import net.rebel459.legacies_and_legends.util.Gem;
import net.rebel459.unified.platform.UnifiedEvents;
import net.rebel459.unified.platform.UnifiedRegistries;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class LaLDataComponents {

    public static void init(){
        UnifiedEvents.DefaultDataComponents.modify((item, builder, provider) -> {
            if (!LegaciesAndLegends.isCombatRebornLoaded) {
                if (item == Items.TRIDENT) {
                    builder.set(DataComponents.ATTRIBUTE_MODIFIERS, TridentItem.createAttributes());
                    builder.set(DataComponents.REPAIRABLE, new Repairable(VanillaRegistries.createLookup().lookup(Registries.ITEM).get().getOrThrow(LaLItemTags.TRIDENT_REPAIR_MATERIALS)));
                }
            }
            if (!LegaciesAndLegends.isProgressionRebornLoaded) {
                if (item == LaLItems.NECKLACE_OF_REGENERATION.get()) {
                    builder.set(DataComponents.REPAIRABLE, new Repairable(VanillaRegistries.createLookup().lookup(Registries.ITEM).get().getOrThrow(LaLItemTags.REGENERATION_NECKLACE_MATERIALS_FALLBACK)));
                }
            }
            if (LaLConfig.get().misc.stackable_saddles) {
                if ((item == Items.SADDLE || item.builtInRegistryHolder().is(ItemTags.HARNESSES))) {
                    builder.set(DataComponents.MAX_STACK_SIZE, 16);
                }
            }
            if (LaLConfig.get().misc.echo_shard_trim) {
                if (item == Items.ECHO_SHARD) {
                    builder.set(DataComponents.PROVIDES_TRIM_MATERIAL, provider.lookup(Registries.TRIM_MATERIAL).get().getOrThrow(LaLTrimMaterials.ECHO));
                }
            }
        });
    }

    public static UnifiedRegistries.DataComponentTypes COMPONENTS = UnifiedRegistries.DataComponentTypes.create(LaLConstants.MOD_ID);

    public static final Supplier<DataComponentType<String>> LORE_BOOK = COMPONENTS.register(
            "lore_book", builder -> builder.persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8)
    );

    public static final Supplier<DataComponentType<Integer>> VARIABLE_DURABILITY = COMPONENTS.register(
            "variable_durability", builder -> builder.persistent(ExtraCodecs.POSITIVE_INT).networkSynchronized(ByteBufCodecs.VAR_INT)
    );

    public static final Supplier<DataComponentType<Gem>> GEM = COMPONENTS.register(
            "gem", builder -> builder.persistent(Gem.CODEC).networkSynchronized(Gem.STREAM_CODEC)
    );
    public static final Supplier<DataComponentType<Gem.Slots>> WAND_SLOTS = COMPONENTS.register(
            "wand_slots", builder -> builder.persistent(Gem.Slots.CODEC).networkSynchronized(Gem.Slots.STREAM_CODEC)
    );
}