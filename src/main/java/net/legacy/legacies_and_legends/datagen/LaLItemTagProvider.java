package net.legacy.legacies_and_legends.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.frozenblock.lib.tag.api.FrozenItemTags;
import net.legacy.item_tooltips.registry.ITItemTags;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class LaLItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public LaLItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    private TagKey<Item> getTag(String namespace, String path) {
        return TagKey.create(this.registryKey, Identifier.fromNamespaceAndPath(namespace, path));
    }

    private ResourceKey<Item> getKey(String namespace, String path) {
        return ResourceKey.create(this.registryKey, Identifier.fromNamespaceAndPath(namespace, path));
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider wrapperLookup) {
        this.valueLookupBuilder(ItemTags.BEACON_PAYMENT_ITEMS)
                .add(LaLItems.SAPPHIRE);

        this.valueLookupBuilder(ItemTags.DECORATED_POT_SHERDS)
                .add(LaLItems.VERDANT_POTTERY_SHERD)
                .add(LaLItems.FORAGER_POTTERY_SHERD)
                .add(LaLItems.HARVEST_POTTERY_SHERD)
                .add(LaLItems.DUSK_POTTERY_SHERD);

        this.valueLookupBuilder(LaLItemTags.TABLETS)
                .add(LaLItems.TABLET_OF_HASTE)
                .add(LaLItems.TABLET_OF_INSTABILITY)
                .add(LaLItems.TABLET_OF_WARPING)
                .add(LaLItems.TABLET_OF_RECALL)
                .add(LaLItems.TABLET_OF_DEAFENING)
                .add(LaLItems.TABLET_OF_CHANNELING)
                .add(LaLItems.TABLET_OF_REVEALING);

        this.valueLookupBuilder(LaLItemTags.RINGS)
                .add(LaLItems.RING_OF_EVASION)
                .add(LaLItems.RING_OF_HUNTING)
                .add(LaLItems.RING_OF_EXCAVATION)
                .add(LaLItems.RING_OF_CONSTRUCTION)
                .add(LaLItems.RING_OF_RESTORATION)
                .add(LaLItems.RING_OF_STRIKING)
                .add(LaLItems.RING_OF_ARCHERY);

        this.valueLookupBuilder(LaLItemTags.NECKLACES)
                .add(LaLItems.NECKLACE_OF_ISOLATION)
                .add(LaLItems.NECKLACE_OF_BARTERING)
                .add(LaLItems.NECKLACE_OF_LEAPING)
                .add(LaLItems.NECKLACE_OF_PROTECTION)
                .add(LaLItems.NECKLACE_OF_PURITY)
                .add(LaLItems.NECKLACE_OF_REGENERATION)
                .add(LaLItems.NECKLACE_OF_RESILIENCE);

        this.valueLookupBuilder(LaLItemTags.AMULETS)
                .add(LaLItems.AMULET_OF_ABSORPTION)
                .add(LaLItems.AMULET_OF_OBSIDIAN)
                .add(LaLItems.AMULET_OF_DEFLECTION);

        this.valueLookupBuilder(LaLItemTags.TOTEMS)
                .add(Items.TOTEM_OF_UNDYING)
                .add(LaLItems.TOTEM_OF_TELEPORTATION)
                .add(LaLItems.TOTEM_OF_RESURRECTION)
                .addOptionalTag(getTag("friendsandfoes","totems"));

        this.valueLookupBuilder(LaLItemTags.ARTIFACTS)
                .add(Items.TURTLE_HELMET)
                .add(LaLItems.REINFORCED_CHESTPLATE)
                .add(LaLItems.TRAVELLING_STRIDES)
                .add(LaLItems.WANDERER_BOOTS)
                .add(LaLItems.VERDANT_SWORD)
                .add(LaLItems.CLEAVING_BATTLEAXE)
                .add(LaLItems.MOLTEN_PICKAXE)
                .add(LaLItems.PROSPECTOR_SHOVEL)
                .add(LaLItems.WITHERED_HOE)
                .add(LaLItems.FROSTED_SPEAR)
                .addTag(LaLItemTags.TABLETS)
                .addTag(LaLItemTags.TOTEMS);

        this.valueLookupBuilder(LaLItemTags.ACCESSORIES)
                .addTag(LaLItemTags.RINGS)
                .addTag(LaLItemTags.NECKLACES)
                .addTag(LaLItemTags.AMULETS)
                .addTag(LaLItemTags.TOTEMS);

        this.valueLookupBuilder(ITItemTags.HAS_DESCRIPTION)
                .add(LaLItems.WAND)
                .addTag(LaLItemTags.ARTIFACTS)
                .addTag(LaLItemTags.ACCESSORIES);

        this.valueLookupBuilder(LaLItemTags.HAS_USE_EFFECT)
                .add(LaLItems.TABLET_OF_CHANNELING)
                .add(LaLItems.TABLET_OF_DEAFENING)
                .add(LaLItems.TABLET_OF_REVEALING);

        this.valueLookupBuilder(LaLItemTags.CHILLING)
                .add(LaLItems.FROSTED_SPEAR);
        this.valueLookupBuilder(LaLItemTags.PROSPECTING)
                .add(LaLItems.PROSPECTOR_SHOVEL);

        this.valueLookupBuilder(LaLItemTags.REPAIRS_REINFORCED_ARMOR)
                .add(Items.ECHO_SHARD);
        this.valueLookupBuilder(LaLItemTags.REPAIRS_TRAVELLING_ARMOR)
                .add(Items.RABBIT_HIDE);
        this.valueLookupBuilder(LaLItemTags.REPAIRS_WANDERER_ARMOR)
                .add(LaLItems.METAL_CHUNK);

        this.valueLookupBuilder(LaLItemTags.BOOMERANG_REPAIR_MATERIALS)
                .add(LaLItems.METAL_CHUNK);
        this.valueLookupBuilder(LaLItemTags.WAND_REPAIR_MATERIALS)
                .add(LaLItems.SAPPHIRE);
        this.valueLookupBuilder(LaLItemTags.HOOK_REPAIR_MATERIALS)
                .add(LaLItems.METAL_CHUNK);
        this.valueLookupBuilder(LaLItemTags.KNIFE_REPAIR_MATERIALS)
                .addTag(ItemTags.DECORATED_POT_SHERDS);

        this.valueLookupBuilder(LaLItemTags.TRIDENT_REPAIR_MATERIALS)
                .add(LaLItems.TRIDENT_SHARD);

        this.valueLookupBuilder(LaLItemTags.VERDANT_TOOL_MATERIALS)
                .add(Items.MOSSY_COBBLESTONE.asItem());
        this.valueLookupBuilder(LaLItemTags.CLEAVING_TOOL_MATERIALS)
                .add(LaLItems.METAL_CHUNK);
        this.valueLookupBuilder(LaLItemTags.MOLTEN_TOOL_MATERIALS)
                .add(Items.NETHER_BRICK);
        this.valueLookupBuilder(LaLItemTags.PROSPECTOR_TOOL_MATERIALS)
                .add(Items.EMERALD);
        this.valueLookupBuilder(LaLItemTags.WITHERED_TOOL_MATERIALS)
                .add(Blocks.BLACKSTONE.asItem());
        this.builder(LaLItemTags.FROSTED_TOOL_MATERIALS)
                .addOptional(getKey("enchants_and_expeditions", "ice_shard"));
        this.valueLookupBuilder(LaLItemTags.FROSTED_TOOL_MATERIALS_FALLBACK)
                .add(Blocks.PACKED_ICE.asItem());

        this.valueLookupBuilder(LaLItemTags.HUNTING_RING_MATERIALS)
                .add(Items.QUARTZ);
        this.valueLookupBuilder(LaLItemTags.EVASION_RING_MATERIALS)
                .add(LaLItems.SAPPHIRE);
        this.valueLookupBuilder(LaLItemTags.CONSTRUCTION_RING_MATERIALS)
                .add(Items.IRON_INGOT);
        this.valueLookupBuilder(LaLItemTags.STRIKING_RING_MATERIALS)
                .add(Items.COPPER_INGOT);
        this.valueLookupBuilder(LaLItemTags.ARCHERY_RING_MATERIALS)
                .add(Items.DIAMOND);
        this.valueLookupBuilder(LaLItemTags.EXCAVATION_RING_MATERIALS)
                .add(Items.EMERALD);
        this.valueLookupBuilder(LaLItemTags.RESTORATION_RING_MATERIALS)
                .add(Items.REDSTONE);

        this.valueLookupBuilder(LaLItemTags.ISOLATION_NECKLACE_MATERIALS)
                .add(Items.AMETHYST_SHARD);
        this.valueLookupBuilder(LaLItemTags.PURITY_NECKLACE_MATERIALS)
                .add(Items.COPPER_INGOT);
        this.valueLookupBuilder(LaLItemTags.LEAPING_NECKLACE_MATERIALS)
                .add(Items.IRON_INGOT);
        this.valueLookupBuilder(LaLItemTags.PROTECTION_NECKLACE_MATERIALS)
                .add(Items.IRON_INGOT);
        this.valueLookupBuilder(LaLItemTags.RESILIENCE_NECKLACE_MATERIALS)
                .add(Items.IRON_INGOT);
        this.builder(LaLItemTags.REGENERATION_NECKLACE_MATERIALS)
                .addOptional(getKey("progression_reborn", "rose_ingot"));
        this.valueLookupBuilder(LaLItemTags.REGENERATION_NECKLACE_MATERIALS_FALLBACK)
                .addTag(LaLItemTags.REGENERATION_NECKLACE_MATERIALS)
                .add(Items.COPPER_INGOT);
        this.valueLookupBuilder(LaLItemTags.BARTERING_NECKLACE_MATERIALS)
                .add(Items.GOLD_INGOT);

        this.valueLookupBuilder(ItemTags.CHEST_ARMOR)
                .add(LaLItems.REINFORCED_CHESTPLATE);
        this.valueLookupBuilder(ItemTags.LEG_ARMOR)
                .add(LaLItems.TRAVELLING_STRIDES);
        this.valueLookupBuilder(ItemTags.FOOT_ARMOR)
                .add(LaLItems.WANDERER_BOOTS);

        this.valueLookupBuilder(ItemTags.SWORDS)
                .add(LaLItems.VERDANT_SWORD);
        this.valueLookupBuilder(ItemTags.AXES)
                .add(LaLItems.CLEAVING_BATTLEAXE);
        this.valueLookupBuilder(ItemTags.PICKAXES)
                .add(LaLItems.MOLTEN_PICKAXE);
        this.valueLookupBuilder(ItemTags.SHOVELS)
                .add(LaLItems.PROSPECTOR_SHOVEL);
        this.valueLookupBuilder(ItemTags.HOES)
                .add(LaLItems.WITHERED_HOE);
        this.valueLookupBuilder(ItemTags.SPEARS)
                .add(LaLItems.FROSTED_SPEAR);

        this.valueLookupBuilder(ItemTags.WEAPON_ENCHANTABLE)
                .add(LaLItems.HOOK)
                .add(LaLItems.KNIFE);

        this.valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(LaLItems.BOOMERANG)
                .add(LaLItems.WAND)
                .add(LaLItems.HOOK)
                .add(LaLItems.KNIFE);

        this.valueLookupBuilder(ItemTags.TRIM_MATERIALS)
                .add(Items.ECHO_SHARD)
                .add(LaLItems.SAPPHIRE);

        this.valueLookupBuilder(FrozenItemTags.ALWAYS_SAVE_COOLDOWNS)
                .add(LaLItems.BOOMERANG)
                .add(LaLItems.WAND)
                .addTag(LaLItemTags.TABLETS);
    }
}
