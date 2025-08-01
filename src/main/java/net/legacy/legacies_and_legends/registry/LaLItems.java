package net.legacy.legacies_and_legends.registry;

import dev.emi.trinkets.api.SlotReference;
import net.frozenblock.lib.item.api.sherd.SherdRegistry;
import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.item.*;
import net.legacy.legacies_and_legends.item.accessory.*;
import net.legacy.legacies_and_legends.sound.LaLJukeboxSongs;
import net.legacy.legacies_and_legends.tag.LaLBlockTags;
import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.component.*;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.ClearAllStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.TeleportRandomlyConsumeEffect;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Function;

public final class LaLItems {

    public static final ResourceLocation ARMOR_CHESTPLATE_ID = LaLConstants.id("armor_chestplate");
    public static final ResourceLocation ARMOR_LEGGINGS_ID = LaLConstants.id("armor_leggings");
    public static final ResourceLocation ARMOR_BOOTS_ID = LaLConstants.id("armor_boots");

    public static final ResourceLocation KNOCKBACK_RESISTANCE_CHESTPLATE_ID = LaLConstants.id("knockback_resistance_chestplate");
    public static final ResourceLocation MOVEMENT_SPEED_LEGGINGS_ID = LaLConstants.id("movement_speed_leggings");
    public static final ResourceLocation STEP_HEIGHT_BOOTS_ID = LaLConstants.id("step_height_boots");

    private static final ItemAttributeModifiers createReinforcedChestplateAttributes = ItemAttributeModifiers.builder()
            .add(Attributes.ARMOR, new AttributeModifier(ARMOR_CHESTPLATE_ID, 7, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.CHEST)
            .add(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(KNOCKBACK_RESISTANCE_CHESTPLATE_ID, 0.5, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.CHEST)
            .build();

    private static final ItemAttributeModifiers createTravellingStridesAttributes = ItemAttributeModifiers.builder()
            .add(Attributes.ARMOR, new AttributeModifier(ARMOR_LEGGINGS_ID, 3, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.LEGS)
            .add(Attributes.MOVEMENT_SPEED, new AttributeModifier(MOVEMENT_SPEED_LEGGINGS_ID, 0.2, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), EquipmentSlotGroup.LEGS)
            .build();

    private static final ItemAttributeModifiers createWandererBootsAttributes = ItemAttributeModifiers.builder()
            .add(Attributes.ARMOR, new AttributeModifier(ARMOR_BOOTS_ID, 2, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.FEET)
            .add(Attributes.STEP_HEIGHT, new AttributeModifier(STEP_HEIGHT_BOOTS_ID, 1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), EquipmentSlotGroup.FEET)
            .build();

    // Boomerang
    public static final BoomerangItem BOOMERANG = register("boomerang",
            BoomerangItem::new,
            new Properties()
                    .component(DataComponents.TOOL, BoomerangItem.createToolProperties())
                    .component(DataComponents.ATTRIBUTE_MODIFIERS, BoomerangItem.createAttributes())
                    .repairable(LaLItemTags.BOOMERANG_REPAIR_MATERIALS)
                    .durability(386)
                    .enchantable(15)
                    .rarity(Rarity.RARE)
                    .component(DataComponents.WEAPON, new Weapon(1))
    );

    // Wand
    public static final WandItem WAND = register("wand",
            WandItem::new,
            new Properties()
                    .repairable(LaLItemTags.WAND_REPAIR_MATERIALS)
                    .durability(256)
                    .enchantable(20)
                    .rarity(Rarity.RARE)
                    .component(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(List.of(), List.of(true), List.of(), List.of()))
                    .useCooldown(1)
    );

    // Misc Items
    public static final Item DISC_FRAGMENT_FAR_LANDS = register("disc_fragment_far_lands",
            DiscFragmentItem::new,
            new Properties()
                    .stacksTo(64)
                    .rarity(Rarity.UNCOMMON)
    );
    public static final Item METAL_CHUNK = register("metal_chunk",
            Item::new,
            new Properties()
                    .stacksTo(64)
    );
    public static final Item WOODEN_BUCKET = register("wooden_bucket",
            Item::new,
            new Properties()
                    .stacksTo(16)
    );
    public static final Item COAL_BUCKET = register("coal_bucket",
            Item::new,
            new Properties()
                    .stacksTo(16)
    );
    public static final Item CHARCOAL_BUCKET = register("charcoal_bucket",
            Item::new,
            new Properties()
                    .stacksTo(16)
    );
    public static final Item TRIDENT_SHARD = register("trident_shard",
            Item::new,
            new Properties()
                    .stacksTo(64)
    );
    public static final Item SAPPHIRE = register("sapphire",
            Item::new,
            new Properties()
                    .stacksTo(64)
                    .trimMaterial(LaLTrimMaterials.SAPPHIRE)
    );

    // Discs
    public static final Item MUSIC_DISC_SVALL = register("music_disc_svall",
            Item::new,
            new Properties()
                    .rarity(Rarity.UNCOMMON)
                    .jukeboxPlayable(LaLJukeboxSongs.SVALL)
    );
    public static final Item MUSIC_DISC_CASTLES = register("music_disc_castles",
            Item::new,
            new Properties()
                    .rarity(Rarity.UNCOMMON)
                    .jukeboxPlayable(LaLJukeboxSongs.CASTLES)
    );
    public static final Item MUSIC_DISC_TASWELL = register("music_disc_taswell",
            Item::new,
            new Properties()
                    .rarity(Rarity.UNCOMMON)
                    .jukeboxPlayable(LaLJukeboxSongs.TASWELL)
    );
    public static final Item MUSIC_DISC_SHULKER = register("music_disc_shulker",
            Item::new,
            new Properties()
                    .rarity(Rarity.UNCOMMON)
                    .jukeboxPlayable(LaLJukeboxSongs.SHULKER)
    );
    public static final Item MUSIC_DISC_TUNDRA = register("music_disc_tundra",
            Item::new,
            new Properties()
                    .rarity(Rarity.UNCOMMON)
                    .jukeboxPlayable(LaLJukeboxSongs.TUNDRA)
    );
    public static final Item MUSIC_DISC_FAR_LANDS = register("music_disc_far_lands",
            Item::new,
            new Properties()
                    .rarity(Rarity.RARE)
                    .jukeboxPlayable(LaLJukeboxSongs.FAR_LANDS)
    );
    public static final Item MUSIC_DISC_INFINITE_SPOOKY_AMETHYST = register("music_disc_infinite_spooky_amethyst",
            Item::new,
            new Properties()
                    .rarity(Rarity.RARE)
                    .jukeboxPlayable(LaLJukeboxSongs.INFINITE_SPOOKY_AMETHYST)
    );
    public static final Item MUSIC_DISC_113 = register("music_disc_113",
            Item::new,
            new Properties()
                    .rarity(Rarity.UNCOMMON)
                    .jukeboxPlayable(LaLJukeboxSongs.INFINITE_SPOOKY_AMETHYST)
    );

    // Sherds
    public static final Item DUSK_POTTERY_SHERD = registerSherd("dusk_pottery_sherd",
            Item::new,
            new Properties()
                    .rarity(Rarity.UNCOMMON)
    );
    public static final Item HARVEST_POTTERY_SHERD = registerSherd("harvest_pottery_sherd",
            Item::new,
            new Properties()
                    .rarity(Rarity.UNCOMMON)
    );
    public static final Item VERDANT_POTTERY_SHERD = registerSherd("verdant_pottery_sherd",
            Item::new,
            new Properties()
                    .rarity(Rarity.UNCOMMON)
    );
    public static final Item FORAGER_POTTERY_SHERD = registerSherd("forager_pottery_sherd",
            Item::new,
            new Properties()
                    .rarity(Rarity.UNCOMMON)
    );

    // Food
    public static final Item ENCHANTED_BEETROOT = register("enchanted_beetroot",
            Item::new,
            new Properties()
                    .stacksTo(64)
                    .rarity(Rarity.UNCOMMON)
                    .food(LaLFoods.ENCHANTED_BEETROOT, LaLConsumables.ENCHANTED_BEETROOT)
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)
    );
    public static final Item ENCHANTED_BEETROOT_SOUP = register("enchanted_beetroot_soup",
            Item::new,
            new Properties()
                    .rarity(Rarity.RARE)
                    .food(LaLFoods.ENCHANTED_BEETROOT_SOUP, LaLConsumables.ENCHANTED_BEETROOT_SOUP)
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)
                    .usingConvertsTo(Items.BOWL)
    );

    // Equipment
    public static final HookItem HOOK = register("hook",
            (properties) -> new HookItem(LaLToolMaterial.HOOK, 3F, -3.2F, properties), (
                    new Properties()
                            .durability(750)
                            .enchantable(15)
                            .rarity(Rarity.UNCOMMON)
            ));
    public static final KnifeItem KNIFE = register("knife",
            KnifeItem::new,
            new Properties()
                    .durability(3048)
                    .attributes(KnifeItem.createAttributes())
                    .component(
                            DataComponents.TOOL,
                            new Tool(
                                    List.of(
                                            Tool.Rule.deniesDrops(BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.BLOCK).getOrThrow(LaLToolMaterial.KNIFE.incorrectBlocksForDrops())),
                                            Tool.Rule.minesAndDrops(BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.BLOCK).getOrThrow(LaLBlockTags.MINEABLE_WITH_KNIFE), LaLToolMaterial.KNIFE.speed())
                                    ),
                                    1.0F,
                                    2,
                                    false
                            )
                    )
                    .enchantable(15)
                    .rarity(Rarity.RARE)
    );

    // Artifacts
    public static final Item TOTEM_OF_RESURRECTION = register("totem_of_resurrection",
            Item::new,
            new Properties()
                    .rarity(Rarity.EPIC)
    );
    public static final Item TOTEM_OF_TELEPORTATION = register("totem_of_teleportation",
            Item::new,
            new Properties()
                    .rarity(Rarity.RARE)
                    .component(DataComponents.DEATH_PROTECTION, new DeathProtection(
                            List.of(
                                    new TeleportRandomlyConsumeEffect(),
                                    new ClearAllStatusEffectsConsumeEffect(),
                                    new ApplyStatusEffectsConsumeEffect(
                                            List.of(
                                                    new MobEffectInstance(MobEffects.REGENERATION, 300, 1),
                                                    new MobEffectInstance(MobEffects.SPEED, 300, 0),
                                                    new MobEffectInstance(MobEffects.INVISIBILITY, 600, 0)
                                            )
                                    )
                            )
                    ))
    );

    public static final Item TABLET = register("tablet",
            Item::new,
            new Properties()
                    .stacksTo(64)
    );
    public static final RecallTabletItem TABLET_OF_RECALL = register("tablet_of_recall",
            RecallTabletItem::new,
            new Properties()
                    .stacksTo(16)
                    .component(DataComponents.CONSUMABLE, LaLConsumables.TABLET_OF_RECALL)
                    .useCooldown(300F)
                    .rarity(Rarity.RARE)
    );
    public static final Item TABLET_OF_HASTE = register("tablet_of_haste",
            Item::new,
            new Properties()
                    .stacksTo(16)
                    .component(DataComponents.CONSUMABLE, LaLConsumables.TABLET_OF_HASTE)
                    .useCooldown(180F)
                    .rarity(Rarity.UNCOMMON)
    );
    public static final Item TABLET_OF_INSTABILITY = register("tablet_of_instability",
            Item::new,
            new Properties()
                    .stacksTo(16)
                    .component(DataComponents.CONSUMABLE, LaLConsumables.TABLET_OF_INSTABILITY)
                    .useCooldown(180F)
                    .rarity(Rarity.UNCOMMON)
    );
    public static final Item TABLET_OF_WARPING = register("tablet_of_warping",
            Item::new,
            new Properties()
                    .stacksTo(16)
                    .component(DataComponents.CONSUMABLE, LaLConsumables.TABLET_OF_WARPING)
                    .useCooldown(180F)
                    .rarity(Rarity.RARE)
    );
    public static final Item TABLET_OF_CHANNELING = register("tablet_of_channeling",
            Item::new,
            new Properties()
                    .stacksTo(16)
                    .component(DataComponents.CONSUMABLE, LaLConsumables.TABLET_OF_CHANNELING)
                    .useCooldown(300F)
                    .rarity(Rarity.RARE)
    );
    public static final Item TABLET_OF_DEAFENING = register("tablet_of_deafening",
            Item::new,
            new Properties()
                    .stacksTo(16)
                    .component(DataComponents.CONSUMABLE, LaLConsumables.TABLET_OF_DEAFENING)
                    .useCooldown(60F)
                    .rarity(Rarity.RARE)
    );
    public static final Item TABLET_OF_REVEALING = register("tablet_of_revealing",
            Item::new,
            new Properties()
                    .stacksTo(16)
                    .component(DataComponents.CONSUMABLE, LaLConsumables.TABLET_OF_REVEALING)
                    .useCooldown(60F)
                    .rarity(Rarity.UNCOMMON)
    );

    public static final Item REINFORCED_CHESTPLATE = register("reinforced_chestplate",
            Item::new,
            new Properties()
                    .durability(731)
                    .repairable(LaLItemTags.REPAIRS_REINFORCED_ARMOR)
                    .component(DataComponents.EQUIPPABLE, Equippable.builder(ArmorType.CHESTPLATE.getSlot()).setEquipSound(SoundEvents.ARMOR_EQUIP_DIAMOND).setAsset(LaLEquipmentAssets.REINFORCED).build())
                    .enchantable(9)
                    .attributes(createReinforcedChestplateAttributes)
                    .rarity(Rarity.RARE)
    );
    public static final Item TRAVELLING_STRIDES = register("travelling_strides",
            Item::new,
            new Properties()
                    .durability(165)
                    .repairable(LaLItemTags.REPAIRS_TRAVELLING_ARMOR)
                    .component(DataComponents.EQUIPPABLE, Equippable.builder(ArmorType.LEGGINGS.getSlot()).setEquipSound(SoundEvents.ARMOR_EQUIP_LEATHER).setAsset(LaLEquipmentAssets.TRAVELLING).build())
                    .enchantable(15)
                    .attributes(createTravellingStridesAttributes)
    );
    public static final Item WANDERER_BOOTS = register("wanderer_boots",
            Item::new,
            new Properties()
                    .durability(386)
                    .repairable(LaLItemTags.REPAIRS_WANDERER_ARMOR)
                    .component(DataComponents.EQUIPPABLE, Equippable.builder(ArmorType.BOOTS.getSlot()).setEquipSound(SoundEvents.ARMOR_EQUIP_IRON).setAsset(LaLEquipmentAssets.WANDERER).build())
                    .enchantable(12)
                    .attributes(createWandererBootsAttributes)
                    .rarity(Rarity.UNCOMMON)
                    .useItemDescriptionPrefix()
    );
    public static final VerdantSwordItem VERDANT_SWORD = register("verdant_sword",
            VerdantSwordItem::new,
            new Properties()
                    .rarity(Rarity.UNCOMMON)
                    .sword(LaLToolMaterial.VERDANT, 3F, -2.4F)
    );
    public static final Item MOLTEN_PICKAXE = register("molten_pickaxe",
            Item::new,
            new Properties()
                    .rarity(Rarity.RARE)
                    .pickaxe(LaLToolMaterial.MOLTEN, 1F, -2.8F)
    );
    public static final CleavingBattleAxeItem CLEAVING_BATTLEAXE = register("cleaving_battleaxe",
            CleavingBattleAxeItem::new,
            new Properties()
                    .rarity(Rarity.UNCOMMON)
    );
    public static final ShovelItem PROSPECTOR_SHOVEL = register("prospector_shovel",
            (properties) -> new ShovelItem(LaLToolMaterial.PROSPECTOR, 1.5F, -3F, properties), (
                    new Properties()
                            .rarity(Rarity.UNCOMMON)
            ));
    public static final WitheredHoeItem WITHERED_HOE = register("withered_hoe",
            (properties) -> new WitheredHoeItem(LaLToolMaterial.WITHERED, -2F, -1F, properties), (
                    new Properties()
                            .rarity(Rarity.UNCOMMON)
            ));

    // Accessories
    public static final AccessoryItem RING_OF_HUNTING = register("ring_of_hunting",
            AccessoryItem::new,
            new Properties()
                    .durability(145)
                    .repairable(LaLItemTags.HUNTING_RING_MATERIALS)
                    .rarity(Rarity.RARE)
    );
    public static final EvasionRingItem RING_OF_EVASION = register("ring_of_evasion",
            EvasionRingItem::new,
            new Properties()
                    .durability(326)
                    .repairable(LaLItemTags.EVASION_RING_MATERIALS)
                    .rarity(Rarity.RARE)
    );
    public static final ConstructionRingItem RING_OF_CONSTRUCTION = register("ring_of_construction",
            ConstructionRingItem::new,
            new Properties()
                    .durability(1024)
                    .repairable(LaLItemTags.CONSTRUCTION_RING_MATERIALS)
                    .rarity(Rarity.UNCOMMON)
    );
    public static final StrikingRingItem RING_OF_STRIKING = register("ring_of_striking",
            StrikingRingItem::new,
            new Properties()
                    .durability(152)
                    .repairable(LaLItemTags.STRIKING_RING_MATERIALS)
                    .rarity(Rarity.UNCOMMON)
    );
    public static final AccessoryItem RING_OF_ARCHERY = register("ring_of_archery",
            AccessoryItem::new,
            new Properties()
                    .durability(249)
                    .repairable(LaLItemTags.ARCHERY_RING_MATERIALS)
                    .rarity(Rarity.UNCOMMON)
    );
    public static final AccessoryItem RING_OF_EXCAVATION = register("ring_of_excavation",
            AccessoryItem::new,
            new Properties()
                    .durability(512)
                    .repairable(LaLItemTags.EXCAVATION_RING_MATERIALS)
                    .rarity(Rarity.RARE)
    );
    public static final AccessoryItem RING_OF_RESTORATION = register("ring_of_restoration",
            AccessoryItem::new,
            new Properties()
                    .durability(330)
                    .repairable(LaLItemTags.RESTORATION_RING_MATERIALS)
                    .rarity(Rarity.EPIC)
    );

    public static final AccessoryItem NECKLACE_OF_ISOLATION = register("necklace_of_isolation",
            AccessoryItem::new,
            new Properties()
                    .durability(408)
                    .repairable(LaLItemTags.ISOLATION_NECKLACE_MATERIALS)
                    .rarity(Rarity.RARE)
    );
    public static final PurityNecklaceItem NECKLACE_OF_PURITY = register("necklace_of_purity",
            PurityNecklaceItem::new,
            new Properties()
                    .durability(173)
                    .repairable(LaLItemTags.PURITY_NECKLACE_MATERIALS)
                    .rarity(Rarity.RARE)
    );
    public static final LeapingNecklaceItem NECKLACE_OF_LEAPING = register("necklace_of_leaping",
            LeapingNecklaceItem::new,
            new Properties()
                    .durability(212)
                    .repairable(LaLItemTags.LEAPING_NECKLACE_MATERIALS)
                    .rarity(Rarity.UNCOMMON)
    );
    public static final ProtectionNecklaceItem NECKLACE_OF_PROTECTION = register("necklace_of_protection",
            ProtectionNecklaceItem::new,
            new Properties()
                    .durability(237)
                    .repairable(LaLItemTags.PROTECTION_NECKLACE_MATERIALS)
                    .rarity(Rarity.UNCOMMON)
    );
    public static final AccessoryItem NECKLACE_OF_RESILIENCE = register("necklace_of_resilience",
            AccessoryItem::new,
            new Properties()
                    .durability(255)
                    .repairable(LaLItemTags.RESILIENCE_NECKLACE_MATERIALS)
                    .rarity(Rarity.EPIC)
    );
    public static final AccessoryItem NECKLACE_OF_REGENERATION = register("necklace_of_regeneration",
            AccessoryItem::new,
            new Properties()
                    .durability(284)
                    .repairable(LaLItemTags.REGENERATION_NECKLACE_MATERIALS)
                    .rarity(Rarity.RARE)
    );
    public static final AccessoryItem NECKLACE_OF_BARTERING = register("necklace_of_bartering",
            AccessoryItem::new,
            new Properties()
                    .durability(351)
                    .repairable(LaLItemTags.BARTERING_NECKLACE_MATERIALS)
                    .rarity(Rarity.UNCOMMON)
    );

    public static final ObsidianAmuletItem AMULET_OF_OBSIDIAN = register("amulet_of_obsidian",
            ObsidianAmuletItem::new,
            new Properties()
                    .durability(100)
                    .rarity(Rarity.EPIC)
    );
    public static final AbsorptionAmuletItem AMULET_OF_ABSORPTION = register("amulet_of_absorption",
            AbsorptionAmuletItem::new,
            new Properties()
                    .durability(100)
                    .rarity(Rarity.RARE)
    );
    public static final DeflectionAmuletItem AMULET_OF_DEFLECTION = register("amulet_of_deflection",
            DeflectionAmuletItem::new,
            new Properties()
                    .durability(100)
                    .rarity(Rarity.RARE)
    );

    public static void init() {
    }

    private static @NotNull <T extends Item> T register(String name, @NotNull Function<Properties, Item> function, Item.@NotNull Properties properties) {
        return (T) Items.registerItem(ResourceKey.create(Registries.ITEM, LaLConstants.id(name)), function, properties);
    }

    public static Function<Properties, Item> createBlockItemWithCustomItemName(Block block) {
        return properties -> new BlockItem(block, properties.useItemDescriptionPrefix());
    }


    private static @NotNull <T extends Item> T registerSherd(String name, @NotNull Function<Properties, Item> function, Item.@NotNull Properties properties) {
        T item = (T) Items.registerItem(ResourceKey.create(Registries.ITEM, LaLConstants.id(name)), function, properties);
        SherdRegistry.register(item, LaLConstants.id(name.replace("sherd", "pattern")));
        return item;
    }
}
