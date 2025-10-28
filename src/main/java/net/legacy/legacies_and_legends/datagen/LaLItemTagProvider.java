package net.legacy.legacies_and_legends.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.frozenblock.lib.tag.api.FrozenItemTags;
import net.legacy.item_tooltips.registry.ITItemTags;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
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

    @NotNull
    private TagKey<Item> getTag(String id) {
        return TagKey.create(this.registryKey, ResourceLocation.parse(id));
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        this.getOrCreateTagBuilder(ItemTags.BEACON_PAYMENT_ITEMS)
                .add(LaLItems.SAPPHIRE);

        this.getOrCreateTagBuilder(ItemTags.DECORATED_POT_SHERDS)
                .add(LaLItems.VERDANT_POTTERY_SHERD)
                .add(LaLItems.FORAGER_POTTERY_SHERD)
                .add(LaLItems.HARVEST_POTTERY_SHERD)
                .add(LaLItems.DUSK_POTTERY_SHERD);

        this.getOrCreateTagBuilder(LaLItemTags.TABLETS)
                .add(LaLItems.TABLET_OF_HASTE)
                .add(LaLItems.TABLET_OF_INSTABILITY)
                .add(LaLItems.TABLET_OF_WARPING)
                .add(LaLItems.TABLET_OF_RECALL)
                .add(LaLItems.TABLET_OF_DEAFENING)
                .add(LaLItems.TABLET_OF_CHANNELING)
                .add(LaLItems.TABLET_OF_REVEALING);

        this.getOrCreateTagBuilder(LaLItemTags.RINGS)
                .add(LaLItems.RING_OF_EVASION)
                .add(LaLItems.RING_OF_HUNTING)
                .add(LaLItems.RING_OF_EXCAVATION)
                .add(LaLItems.RING_OF_CONSTRUCTION)
                .add(LaLItems.RING_OF_RESTORATION)
                .add(LaLItems.RING_OF_STRIKING)
                .add(LaLItems.RING_OF_ARCHERY);

        this.getOrCreateTagBuilder(LaLItemTags.NECKLACES)
                .add(LaLItems.NECKLACE_OF_ISOLATION)
                .add(LaLItems.NECKLACE_OF_BARTERING)
                .add(LaLItems.NECKLACE_OF_LEAPING)
                .add(LaLItems.NECKLACE_OF_PROTECTION)
                .add(LaLItems.NECKLACE_OF_PURITY)
                .add(LaLItems.NECKLACE_OF_REGENERATION)
                .add(LaLItems.NECKLACE_OF_RESILIENCE);

        this.getOrCreateTagBuilder(LaLItemTags.AMULETS)
                .add(LaLItems.AMULET_OF_ABSORPTION)
                .add(LaLItems.AMULET_OF_OBSIDIAN)
                .add(LaLItems.AMULET_OF_DEFLECTION);

        this.getOrCreateTagBuilder(LaLItemTags.TOTEMS)
                .add(Items.TOTEM_OF_UNDYING)
                .add(LaLItems.TOTEM_OF_TELEPORTATION)
                .add(LaLItems.TOTEM_OF_RESURRECTION)
                .addOptionalTag(ResourceLocation.fromNamespaceAndPath("friendsandfoes","totems"));

        this.getOrCreateTagBuilder(LaLItemTags.ARTIFACTS)
                .add(Items.TURTLE_HELMET)
                .add(LaLItems.REINFORCED_CHESTPLATE)
                .add(LaLItems.TRAVELLING_STRIDES)
                .add(LaLItems.WANDERER_BOOTS)
                .add(LaLItems.VERDANT_SWORD)
                .add(LaLItems.CLEAVING_BATTLEAXE)
                .add(LaLItems.MOLTEN_PICKAXE)
                .add(LaLItems.PROSPECTOR_SHOVEL)
                .add(LaLItems.WITHERED_HOE)
                .addTag(LaLItemTags.TABLETS)
                .addTag(LaLItemTags.TOTEMS);

        this.getOrCreateTagBuilder(LaLItemTags.ACCESSORIES)
                .addTag(LaLItemTags.RINGS)
                .addTag(LaLItemTags.NECKLACES)
                .addTag(LaLItemTags.AMULETS)
                .addTag(LaLItemTags.TOTEMS);

        this.getOrCreateTagBuilder(ITItemTags.HAS_DESCRIPTION)
                .add(LaLItems.WAND)
                .addTag(LaLItemTags.ARTIFACTS)
                .addTag(LaLItemTags.ACCESSORIES);

        this.getOrCreateTagBuilder(LaLItemTags.HAS_USE_EFFECT)
                .add(LaLItems.TABLET_OF_CHANNELING)
                .add(LaLItems.TABLET_OF_DEAFENING)
                .add(LaLItems.TABLET_OF_REVEALING);

        this.getOrCreateTagBuilder(LaLItemTags.PROSPECTING)
                .add(LaLItems.PROSPECTOR_SHOVEL);

        this.getOrCreateTagBuilder(LaLItemTags.REPAIRS_REINFORCED_ARMOR)
                .add(Items.ECHO_SHARD);
        this.getOrCreateTagBuilder(LaLItemTags.REPAIRS_TRAVELLING_ARMOR)
                .add(Items.RABBIT_HIDE);
        this.getOrCreateTagBuilder(LaLItemTags.REPAIRS_WANDERER_ARMOR)
                .add(LaLItems.METAL_CHUNK);

        this.getOrCreateTagBuilder(LaLItemTags.BOOMERANG_REPAIR_MATERIALS)
                .add(LaLItems.METAL_CHUNK);
        this.getOrCreateTagBuilder(LaLItemTags.WAND_REPAIR_MATERIALS)
                .add(LaLItems.SAPPHIRE);
        this.getOrCreateTagBuilder(LaLItemTags.HOOK_REPAIR_MATERIALS)
                .add(LaLItems.METAL_CHUNK);
        this.getOrCreateTagBuilder(LaLItemTags.KNIFE_REPAIR_MATERIALS)
                .addTag(ItemTags.DECORATED_POT_SHERDS);

        this.getOrCreateTagBuilder(LaLItemTags.TRIDENT_REPAIR_MATERIALS)
                .add(LaLItems.TRIDENT_SHARD);

        this.getOrCreateTagBuilder(LaLItemTags.VERDANT_TOOL_MATERIALS)
                .add(Items.MOSSY_COBBLESTONE.asItem());
        this.getOrCreateTagBuilder(LaLItemTags.CLEAVING_TOOL_MATERIALS)
                .add(LaLItems.METAL_CHUNK);
        this.getOrCreateTagBuilder(LaLItemTags.MOLTEN_TOOL_MATERIALS)
                .add(Items.NETHER_BRICK);
        this.getOrCreateTagBuilder(LaLItemTags.PROSPECTOR_TOOL_MATERIALS)
                .add(Items.EMERALD);
        this.getOrCreateTagBuilder(LaLItemTags.WITHERED_TOOL_MATERIALS)
                .add(Blocks.BLACKSTONE.asItem());

        this.getOrCreateTagBuilder(LaLItemTags.HUNTING_RING_MATERIALS)
                .add(Items.QUARTZ);
        this.getOrCreateTagBuilder(LaLItemTags.EVASION_RING_MATERIALS)
                .add(LaLItems.SAPPHIRE);
        this.getOrCreateTagBuilder(LaLItemTags.CONSTRUCTION_RING_MATERIALS)
                .add(Items.IRON_INGOT);
        this.getOrCreateTagBuilder(LaLItemTags.STRIKING_RING_MATERIALS)
                .add(Items.COPPER_INGOT);
        this.getOrCreateTagBuilder(LaLItemTags.ARCHERY_RING_MATERIALS)
                .add(Items.DIAMOND);
        this.getOrCreateTagBuilder(LaLItemTags.EXCAVATION_RING_MATERIALS)
                .add(Items.EMERALD);
        this.getOrCreateTagBuilder(LaLItemTags.RESTORATION_RING_MATERIALS)
                .add(Items.REDSTONE);

        this.getOrCreateTagBuilder(LaLItemTags.ISOLATION_NECKLACE_MATERIALS)
                .add(Items.AMETHYST_SHARD);
        this.getOrCreateTagBuilder(LaLItemTags.PURITY_NECKLACE_MATERIALS)
                .add(Items.COPPER_INGOT);
        this.getOrCreateTagBuilder(LaLItemTags.LEAPING_NECKLACE_MATERIALS)
                .add(Items.IRON_INGOT);
        this.getOrCreateTagBuilder(LaLItemTags.PROTECTION_NECKLACE_MATERIALS)
                .add(Items.IRON_INGOT);
        this.getOrCreateTagBuilder(LaLItemTags.RESILIENCE_NECKLACE_MATERIALS)
                .add(Items.IRON_INGOT);
        this.getOrCreateTagBuilder(LaLItemTags.REGENERATION_NECKLACE_MATERIALS)
                .addOptional(ResourceLocation.fromNamespaceAndPath("progression_reborn", "rose_ingot"));
        this.getOrCreateTagBuilder(LaLItemTags.REGENERATION_NECKLACE_MATERIALS_FALLBACK)
                .addTag(LaLItemTags.REGENERATION_NECKLACE_MATERIALS)
                .add(Items.COPPER_INGOT);
        this.getOrCreateTagBuilder(LaLItemTags.BARTERING_NECKLACE_MATERIALS)
                .add(Items.GOLD_INGOT);

        this.getOrCreateTagBuilder(ItemTags.CHEST_ARMOR)
                .add(LaLItems.REINFORCED_CHESTPLATE);
        this.getOrCreateTagBuilder(ItemTags.LEG_ARMOR)
                .add(LaLItems.TRAVELLING_STRIDES);
        this.getOrCreateTagBuilder(ItemTags.FOOT_ARMOR)
                .add(LaLItems.WANDERER_BOOTS);

        this.getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(LaLItems.VERDANT_SWORD);
        this.getOrCreateTagBuilder(ItemTags.AXES)
                .add(LaLItems.CLEAVING_BATTLEAXE);
        this.getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(LaLItems.MOLTEN_PICKAXE);
        this.getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(LaLItems.PROSPECTOR_SHOVEL);
        this.getOrCreateTagBuilder(ItemTags.HOES)
                .add(LaLItems.WITHERED_HOE);

        this.getOrCreateTagBuilder(ItemTags.WEAPON_ENCHANTABLE)
                .add(LaLItems.HOOK)
                .add(LaLItems.KNIFE);

        this.getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(LaLItems.BOOMERANG)
                .add(LaLItems.WAND)
                .add(LaLItems.HOOK)
                .add(LaLItems.KNIFE);

        this.getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS)
                .add(Items.ECHO_SHARD)
                .add(LaLItems.SAPPHIRE);

        this.getOrCreateTagBuilder(FrozenItemTags.ALWAYS_SAVE_COOLDOWNS)
                .add(LaLItems.BOOMERANG)
                .add(LaLItems.WAND)
                .addTag(LaLItemTags.TABLETS);
    }
}
