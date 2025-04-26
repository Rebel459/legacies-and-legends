package net.legacy.legacies_and_legends.registry;

import net.frozenblock.lib.item.api.sherd.SherdRegistry;
import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.equipment.BoomerangItem;
import net.legacy.legacies_and_legends.equipment.RecallTabletItem;
import net.legacy.legacies_and_legends.sound.LaLJukeboxSongs;
import net.legacy.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.DeathProtection;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.ClearAllStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.TeleportRandomlyConsumeEffect;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item.Properties;
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

    public static final ResourceLocation TEMPT_RANGE_ID = LaLConstants.id("tempt_range");

    private static final ItemAttributeModifiers createAmuletOfAllureAttributes = ItemAttributeModifiers.builder()
            .add(Attributes.TEMPT_RANGE, new AttributeModifier(TEMPT_RANGE_ID, 10, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
            .add(Attributes.TEMPT_RANGE, new AttributeModifier(TEMPT_RANGE_ID, 10, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.OFFHAND)
            .build();

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
                    .stacksTo(1)
                    .component(DataComponents.TOOL, BoomerangItem.createToolProperties())
                    .component(DataComponents.ATTRIBUTE_MODIFIERS, BoomerangItem.createAttributes())
                    .repairable(LaLItemTags.BOOMERANG_REPAIR_MATERIALS)
                    .durability(386)
                    .rarity(Rarity.RARE)
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

    // Discs
    public static final Item MUSIC_DISC_SVALL = register("music_disc_svall",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.UNCOMMON)
                    .jukeboxPlayable(LaLJukeboxSongs.SVALL)
    );
    public static final Item MUSIC_DISC_CASTLES = register("music_disc_castles",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.UNCOMMON)
                    .jukeboxPlayable(LaLJukeboxSongs.CASTLES)
    );
    public static final Item MUSIC_DISC_TASWELL = register("music_disc_taswell",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.UNCOMMON)
                    .jukeboxPlayable(LaLJukeboxSongs.TASWELL)
    );
    public static final Item MUSIC_DISC_SHULKER = register("music_disc_shulker",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.UNCOMMON)
                    .jukeboxPlayable(LaLJukeboxSongs.SHULKER)
    );
    public static final Item MUSIC_DISC_TUNDRA = register("music_disc_tundra",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.UNCOMMON)
                    .jukeboxPlayable(LaLJukeboxSongs.TUNDRA)
    );
    public static final Item MUSIC_DISC_FAR_LANDS = register("music_disc_far_lands",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.RARE)
                    .jukeboxPlayable(LaLJukeboxSongs.FAR_LANDS)
    );
    public static final Item MUSIC_DISC_INFINITE_SPOOKY_AMETHYST = register("music_disc_infinite_spooky_amethyst",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.RARE)
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
                    .stacksTo(1)
                    .rarity(Rarity.RARE)
                    .food(LaLFoods.ENCHANTED_BEETROOT_SOUP, LaLConsumables.ENCHANTED_BEETROOT_SOUP)
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)
                    .usingConvertsTo(Items.BOWL)
    );

    // Artifacts
    public static final Item TOTEM_OF_VENGEANCE = register("totem_of_vengeance",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.UNCOMMON)
                    .component(DataComponents.DEATH_PROTECTION, new DeathProtection(
                            List.of(
                                    new ClearAllStatusEffectsConsumeEffect(),
                                    new ApplyStatusEffectsConsumeEffect(
                                            List.of(
                                                    new MobEffectInstance(MobEffects.REGENERATION, 300, 4),
                                                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 1),
                                                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 1),
                                                    new MobEffectInstance(MobEffects.WITHER, 6000, 2)
                                            )
                                    )
                            )
                    ))
    );
    public static final Item TOTEM_OF_TELEPORTATION = register("totem_of_teleportation",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.RARE)
                    .component(DataComponents.DEATH_PROTECTION, new DeathProtection(
                            List.of(
                                    new TeleportRandomlyConsumeEffect(),
                                    new ClearAllStatusEffectsConsumeEffect(),
                                    new ApplyStatusEffectsConsumeEffect(
                                            List.of(
                                                    new MobEffectInstance(MobEffects.REGENERATION, 300, 1),
                                                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 0),
                                                    new MobEffectInstance(MobEffects.INVISIBILITY, 600, 0)
                                            )
                                    )
                            )
                    ))
    );

    public static final RecallTabletItem TABLET_OF_RECALL = register("tablet_of_recall",
            RecallTabletItem::new,
            new Properties()
                    .stacksTo(16)
                    .component(DataComponents.CONSUMABLE, LaLConsumables.TABLET_OF_RECALL)
                    .useCooldown(300f)
                    .rarity(Rarity.UNCOMMON)
    );
    public static final Item TABLET_OF_HASTE = register("tablet_of_haste",
            Item::new,
            new Properties()
                    .stacksTo(16)
                    .component(DataComponents.CONSUMABLE, LaLConsumables.TABLET_OF_HASTE)
                    .useCooldown(60f)
                    .rarity(Rarity.UNCOMMON)
    );
    public static final Item TABLET_OF_LEVITATION = register("tablet_of_levitation",
            Item::new,
            new Properties()
                    .stacksTo(16)
                    .component(DataComponents.CONSUMABLE, LaLConsumables.TABLET_OF_LEVITATION)
                    .useCooldown(30f)
                    .rarity(Rarity.RARE)
    );
    public static final Item TABLET_OF_CHANNELING = register("tablet_of_channeling",
            Item::new,
            new Properties()
                    .stacksTo(16)
                    .component(DataComponents.CONSUMABLE, LaLConsumables.TABLET_OF_CHANNELING)
                    .useCooldown(300f)
                    .rarity(Rarity.RARE)
    );
    public static final Item TABLET_OF_DEAFENING = register("tablet_of_deafening",
            Item::new,
            new Properties()
                    .stacksTo(16)
                    .component(DataComponents.CONSUMABLE, LaLConsumables.TABLET_OF_DEAFENING)
                    .useCooldown(60f)
                    .rarity(Rarity.RARE)
    );
    public static final Item TABLET_OF_REVEALING = register("tablet_of_revealing",
            Item::new,
            new Properties()
                    .stacksTo(16)
                    .component(DataComponents.CONSUMABLE, LaLConsumables.TABLET_OF_REVEALING)
                    .useCooldown(60f)
                    .rarity(Rarity.UNCOMMON)
    );

    public static final Item AMULET_OF_ALLURE = register("amulet_of_allure",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .attributes(createAmuletOfAllureAttributes)
                    .rarity(Rarity.UNCOMMON)
    );
    public static final Item AMULET_OF_SYNTHESIS = register("amulet_of_synthesis",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.UNCOMMON)
    );
    public static final Item AMULET_OF_EVASION = register("amulet_of_evasion",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .rarity(Rarity.RARE)
    );

    public static final Item REINFORCED_CHESTPLATE = register("reinforced_chestplate",
            Item::new,
            new Properties()
                    .stacksTo(1)
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
                    .stacksTo(1)
                    .durability(165)
                    .repairable(LaLItemTags.REPAIRS_TRAVELLING_ARMOR)
                    .component(DataComponents.EQUIPPABLE, Equippable.builder(ArmorType.LEGGINGS.getSlot()).setEquipSound(SoundEvents.ARMOR_EQUIP_LEATHER).setAsset(LaLEquipmentAssets.TRAVELLING).build())
                    .enchantable(15)
                    .attributes(createTravellingStridesAttributes)
    );
    public static final Item WANDERER_BOOTS = register("wanderer_boots",
            Item::new,
            new Properties()
                    .stacksTo(1)
                    .durability(386)
                    .repairable(LaLItemTags.REPAIRS_WANDERER_ARMOR)
                    .component(DataComponents.EQUIPPABLE, Equippable.builder(ArmorType.BOOTS.getSlot()).setEquipSound(SoundEvents.ARMOR_EQUIP_IRON).setAsset(LaLEquipmentAssets.WANDERER).build())
                    .enchantable(12)
                    .attributes(createWandererBootsAttributes)
                    .rarity(Rarity.UNCOMMON)
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
