package net.rebel459.legacies_and_legends.datagen;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.rebel459.item_tooltips.tag.ITItemTags;
import net.rebel459.legacies_and_legends.LaLConstants;
import net.rebel459.legacies_and_legends.registry.LaLBlocks;
import net.rebel459.legacies_and_legends.registry.LaLItems;
import net.rebel459.legacies_and_legends.tag.LaLItemTags;
import net.rebel459.unified.api.core.SuppliedItem;
import net.rebel459.unified.api.data.helper.TagGenerator;
import net.rebel459.unified.api.tag.UnifiedItemTags;

public class LaLItemTagProvider {

    public static void init() {

        TagGenerator generator = LaLConstants.DATA.helpers().tags();

        generator.create(ItemTags.BEACON_PAYMENT_ITEMS)
                .add(LaLItems.SAPPHIRE.key());

        generator.create(ItemTags.DECORATED_POT_SHERDS)
                .add(LaLItems.VERDANT_POTTERY_SHERD.key())
                .add(LaLItems.FORAGER_POTTERY_SHERD.key())
                .add(LaLItems.HARVEST_POTTERY_SHERD.key())
                .add(LaLItems.DUSK_POTTERY_SHERD.key());

        for (SuppliedItem item : LaLItems.GEMS) {
            generator.create(LaLItemTags.GEMS)
                    .add(item.key());
        }

        generator.create(LaLItemTags.TABLETS)
                .add(LaLItems.TABLET_OF_HASTE.key())
                .add(LaLItems.TABLET_OF_INSTABILITY.key())
                .add(LaLItems.TABLET_OF_WARPING.key())
                .add(LaLItems.TABLET_OF_RECALL.key())
                .add(LaLItems.TABLET_OF_DEAFENING.key())
                .add(LaLItems.TABLET_OF_CHANNELING.key())
                .add(LaLItems.TABLET_OF_REVEALING.key());

        generator.create(LaLItemTags.RINGS)
                .add(LaLItems.RING_OF_EVASION.key())
                .add(LaLItems.RING_OF_HUNTING.key())
                .add(LaLItems.RING_OF_EXCAVATION.key())
                .add(LaLItems.RING_OF_CONSTRUCTION.key())
                .add(LaLItems.RING_OF_RESTORATION.key())
                .add(LaLItems.RING_OF_STRIKING.key())
                .add(LaLItems.RING_OF_ARCHERY.key());

        generator.create(LaLItemTags.NECKLACES)
                .add(LaLItems.NECKLACE_OF_ISOLATION.key())
                .add(LaLItems.NECKLACE_OF_BARTERING.key())
                .add(LaLItems.NECKLACE_OF_LEAPING.key())
                .add(LaLItems.NECKLACE_OF_PROTECTION.key())
                .add(LaLItems.NECKLACE_OF_PURITY.key())
                .add(LaLItems.NECKLACE_OF_REGENERATION.key())
                .add(LaLItems.NECKLACE_OF_RESILIENCE.key());

        generator.create(LaLItemTags.AMULETS)
                .add(LaLItems.AMULET_OF_ABSORPTION.key())
                .add(LaLItems.AMULET_OF_OBSIDIAN.key())
                .add(LaLItems.AMULET_OF_DEFLECTION.key());

        generator.create(LaLItemTags.TOTEMS)
                .add(Items.TOTEM_OF_UNDYING.builtInRegistryHolder().key())
                .add(LaLItems.TOTEM_OF_TELEPORTATION.key())
                .add(LaLItems.TOTEM_OF_RESURRECTION.key())
                .addOptional(getTag("friendsandfoes","totems"));

        generator.create(LaLItemTags.ARTIFACTS)
                .add(Items.TURTLE_HELMET.builtInRegistryHolder().key())
                .add(LaLItems.REINFORCED_CHESTPLATE.key())
                .add(LaLItems.TRAVELLING_STRIDES.key())
                .add(LaLItems.WANDERER_BOOTS.key())
                .add(LaLItems.VERDANT_SWORD.key())
                .add(LaLItems.CLEAVING_BATTLEAXE.key())
                .add(LaLItems.MOLTEN_PICKAXE.key())
                .add(LaLItems.PROSPECTOR_SHOVEL.key())
                .add(LaLItems.WITHERED_HOE.key())
                .add(LaLItems.FROSTED_SPEAR.key())
                .add(LaLItemTags.TABLETS)
                .add(LaLItemTags.TOTEMS);

        generator.create(LaLItemTags.ACCESSORIES)
                .add(LaLItemTags.RINGS)
                .add(LaLItemTags.NECKLACES)
                .add(LaLItemTags.AMULETS)
                .add(LaLItemTags.TOTEMS);

        generator.create(ITItemTags.HAS_DESCRIPTION)
                .add(LaLItemTags.ARTIFACTS)
                .add(LaLItemTags.RINGS)
                .add(LaLItemTags.NECKLACES)
                .add(LaLItemTags.AMULETS)
                .add(LaLItemTags.TOTEMS)
                .add(LaLBlocks.JEWELING_TABLE.blockItemId().item());

        generator.create(LaLItemTags.HAS_USE_EFFECT)
                .add(LaLItems.TABLET_OF_CHANNELING.key())
                .add(LaLItems.TABLET_OF_DEAFENING.key())
                .add(LaLItems.TABLET_OF_REVEALING.key());

        generator.create(LaLItemTags.CHILLING)
                .add(LaLItems.FROSTED_SPEAR.key());
        generator.create(LaLItemTags.PROSPECTING)
                .add(LaLItems.PROSPECTOR_SHOVEL.key());

        generator.create(LaLItemTags.REPAIRS_REINFORCED_ARMOR)
                .add(Items.ECHO_SHARD.builtInRegistryHolder().key());
        generator.create(LaLItemTags.REPAIRS_TRAVELLING_ARMOR)
                .add(Items.RABBIT_HIDE.builtInRegistryHolder().key());
        generator.create(LaLItemTags.REPAIRS_WANDERER_ARMOR)
                .add(LaLItems.METAL_CHUNK.key());

        generator.create(LaLItemTags.BOOMERANG_REPAIR_MATERIALS)
                .add(LaLItems.METAL_CHUNK.key());
        generator.create(LaLItemTags.WAND_REPAIR_MATERIALS)
                .add(Items.GOLD_INGOT.builtInRegistryHolder().key());
        generator.create(LaLItemTags.HOOK_REPAIR_MATERIALS)
                .add(LaLItems.METAL_CHUNK.key());
        generator.create(LaLItemTags.KNIFE_REPAIR_MATERIALS)
                .add(ItemTags.DECORATED_POT_SHERDS);

        generator.create(LaLItemTags.TRIDENT_REPAIR_MATERIALS)
                .add(LaLItems.TRIDENT_SHARD.key());

        generator.create(LaLItemTags.VERDANT_TOOL_MATERIALS)
                .add(Items.MOSSY_COBBLESTONE.builtInRegistryHolder().key());
        generator.create(LaLItemTags.CLEAVING_TOOL_MATERIALS)
                .add(LaLItems.METAL_CHUNK.key());
        generator.create(LaLItemTags.MOLTEN_TOOL_MATERIALS)
                .add(Items.NETHER_BRICK.builtInRegistryHolder().key());
        generator.create(LaLItemTags.PROSPECTOR_TOOL_MATERIALS)
                .add(Items.EMERALD.builtInRegistryHolder().key());
        generator.create(LaLItemTags.WITHERED_TOOL_MATERIALS)
                .add(Items.BLACKSTONE.builtInRegistryHolder().key());
        generator.create(LaLItemTags.FROSTED_TOOL_MATERIALS)
                .addOptional(getKey("enchants_and_expeditions", "ice_shard"));
        generator.create(LaLItemTags.FROSTED_TOOL_MATERIALS_FALLBACK)
                .add(Items.PACKED_ICE.builtInRegistryHolder().key());

        generator.create(LaLItemTags.HUNTING_RING_MATERIALS)
                .add(Items.QUARTZ.builtInRegistryHolder().key());
        generator.create(LaLItemTags.EVASION_RING_MATERIALS)
                .add(LaLItems.SAPPHIRE.key());
        generator.create(LaLItemTags.CONSTRUCTION_RING_MATERIALS)
                .add(Items.IRON_INGOT.builtInRegistryHolder().key());
        generator.create(LaLItemTags.STRIKING_RING_MATERIALS)
                .add(Items.COPPER_INGOT.builtInRegistryHolder().key());
        generator.create(LaLItemTags.ARCHERY_RING_MATERIALS)
                .add(Items.DIAMOND.builtInRegistryHolder().key());
        generator.create(LaLItemTags.EXCAVATION_RING_MATERIALS)
                .add(Items.EMERALD.builtInRegistryHolder().key());
        generator.create(LaLItemTags.RESTORATION_RING_MATERIALS)
                .add(Items.REDSTONE.builtInRegistryHolder().key());

        generator.create(LaLItemTags.ISOLATION_NECKLACE_MATERIALS)
                .add(Items.AMETHYST_SHARD.builtInRegistryHolder().key());
        generator.create(LaLItemTags.PURITY_NECKLACE_MATERIALS)
                .add(Items.COPPER_INGOT.builtInRegistryHolder().key());
        generator.create(LaLItemTags.LEAPING_NECKLACE_MATERIALS)
                .add(Items.IRON_INGOT.builtInRegistryHolder().key());
        generator.create(LaLItemTags.PROTECTION_NECKLACE_MATERIALS)
                .add(Items.IRON_INGOT.builtInRegistryHolder().key());
        generator.create(LaLItemTags.RESILIENCE_NECKLACE_MATERIALS)
                .add(Items.IRON_INGOT.builtInRegistryHolder().key());
        generator.create(LaLItemTags.REGENERATION_NECKLACE_MATERIALS)
                .addOptional(getKey("progression_reborn", "rose_ingot"));
        generator.create(LaLItemTags.REGENERATION_NECKLACE_MATERIALS_FALLBACK)
                .add(LaLItemTags.REGENERATION_NECKLACE_MATERIALS)
                .add(Items.COPPER_INGOT.builtInRegistryHolder().key());
        generator.create(LaLItemTags.BARTERING_NECKLACE_MATERIALS)
                .add(Items.GOLD_INGOT.builtInRegistryHolder().key());

        generator.create(LaLItemTags.SAPPHIRE_ORES)
                .add(LaLBlocks.SAPPHIRE_ORE.blockItemId().item())
                .add(LaLBlocks.DEEPSLATE_SAPPHIRE_ORE.blockItemId().item());

        generator.create(ItemTags.CHEST_ARMOR)
                .add(LaLItems.REINFORCED_CHESTPLATE.key());
        generator.create(ItemTags.LEG_ARMOR)
                .add(LaLItems.TRAVELLING_STRIDES.key());
        generator.create(ItemTags.FOOT_ARMOR)
                .add(LaLItems.WANDERER_BOOTS.key());

        generator.create(ItemTags.SWORDS)
                .add(LaLItems.VERDANT_SWORD.key());
        generator.create(ItemTags.AXES)
                .add(LaLItems.CLEAVING_BATTLEAXE.key());
        generator.create(ItemTags.PICKAXES)
                .add(LaLItems.MOLTEN_PICKAXE.key());
        generator.create(ItemTags.SHOVELS)
                .add(LaLItems.PROSPECTOR_SHOVEL.key());
        generator.create(ItemTags.HOES)
                .add(LaLItems.WITHERED_HOE.key());
        generator.create(ItemTags.SPEARS)
                .add(LaLItems.FROSTED_SPEAR.key());

        generator.create(ItemTags.WEAPON_ENCHANTABLE)
                .add(LaLItems.HOOK.key());

        generator.create(ItemTags.MELEE_WEAPON_ENCHANTABLE)
                .add(LaLItems.KNIFE.key());

        generator.create(ItemTags.DURABILITY_ENCHANTABLE)
                .add(LaLItems.BOOMERANG.key())
                .add(LaLItems.HOOK.key())
                .add(LaLItems.KNIFE.key());

        generator.create(ItemTags.TRIM_MATERIALS)
                .add(Items.ECHO_SHARD.builtInRegistryHolder().key())
                .add(LaLItems.SAPPHIRE.key());

        generator.create(LaLItemTags.VOID_IMMUNE)
                .add(LaLItems.TIMELOST_GEM.key());

        generator.create(UnifiedItemTags.PERSISTENT_COOLDOWNS)
                .add(LaLItems.BOOMERANG.key())
                .add(LaLItems.WAND.key())
                .add(LaLItemTags.TABLETS);
    }

    private static TagKey<Item> getTag(String namespace, String path) {
        return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(namespace, path));
    }

    private static ResourceKey<Item> getKey(String namespace, String path) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(namespace, path));
    }
}
