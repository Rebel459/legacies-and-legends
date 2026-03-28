package net.rebel459.legacies_and_legends.registry;

import com.mojang.serialization.Codec;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.registries.VanillaRegistries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.enchantment.Repairable;
import net.rebel459.legacies_and_legends.LaLConstants;
import net.rebel459.legacies_and_legends.LegaciesAndLegends;
import net.rebel459.legacies_and_legends.config.LaLConfig;
import net.rebel459.legacies_and_legends.tag.LaLItemTags;
import net.rebel459.unified.platform.UnifiedEvents;
import net.rebel459.unified.platform.UnifiedRegistries;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class LaLDataComponents {

    public static void init(){
        UnifiedEvents.ItemComponents.modify((item, builder) -> {
            if (!LegaciesAndLegends.isCombatRebornLoaded) {
                if (item == Items.TRIDENT) {
                    builder.set(DataComponents.ATTRIBUTE_MODIFIERS, TridentItem.createAttributes());
                    HolderGetter<Item> holderGetter = BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.ITEM);
                    builder.set(DataComponents.REPAIRABLE, new Repairable(holderGetter.getOrThrow(LaLItemTags.TRIDENT_REPAIR_MATERIALS)));
                }
            }
            if (!LegaciesAndLegends.isProgressionRebornLoaded) {
                if (item == LaLItems.NECKLACE_OF_REGENERATION) {
                    HolderGetter<Item> holderGetter = BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.ITEM);
                    builder.set(DataComponents.REPAIRABLE, new Repairable(holderGetter.getOrThrow(LaLItemTags.REGENERATION_NECKLACE_MATERIALS_FALLBACK)));
                }
            }
            if (LaLConfig.get.misc.echo_shard_trim) {
                if (item == Items.ECHO_SHARD) {
                    builder.set(DataComponents.PROVIDES_TRIM_MATERIAL, VanillaRegistries.createLookup().lookup(Registries.TRIM_MATERIAL).get().getOrThrow(LaLTrimMaterials.ECHO));
                }
            }
            if (LaLConfig.get.misc.stackable_saddles) {
                if ((item == Items.SADDLE || item.getDefaultInstance().is(ItemTags.HARNESSES)) && item.getDefaultMaxStackSize() == 1) {
                    builder.set(DataComponents.MAX_STACK_SIZE, 16);
                }
            }
        });
    }

    public static UnifiedRegistries.DataComponentTypes COMPONENTS = UnifiedRegistries.DataComponentTypes.create(LaLConstants.MOD_ID);

    public static final Supplier<DataComponentType<String>> LORE_BOOK = COMPONENTS.register(
            "lore_book", builder -> builder.persistent(Codec.STRING).networkSynchronized(ByteBufCodecs.STRING_UTF8)
    );
}