package net.legacy.legacies_and_legends;

import net.frozenblock.lib.item.api.FrozenCreativeTabs;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

public class LaLCreativeInventorySorting {

    public static void init() {
        addAfterInToolsAndUtilities(Items.MUSIC_DISC_FAR, LaLItems.MUSIC_DISC_SVALL);
        addAfterInToolsAndUtilities(Items.MUSIC_DISC_11, LaLItems.MUSIC_DISC_TASWELL);
        addAfterInToolsAndUtilities(Items.MUSIC_DISC_OTHERSIDE, LaLItems.MUSIC_DISC_SHULKER);
        addAfterInToolsAndUtilities(Items.MUSIC_DISC_CREATOR_MUSIC_BOX, LaLItems.MUSIC_DISC_TUNDRA);
        addAfterInToolsAndUtilities(Items.MUSIC_DISC_RELIC, LaLItems.MUSIC_DISC_FAR_LANDS);

        addAfterInToolsAndUtilities(Items.MILK_BUCKET, LaLItems.WOODEN_BUCKET);
        addAfterInToolsAndUtilities(LaLItems.WOODEN_BUCKET, LaLItems.COAL_BUCKET);
        addAfterInToolsAndUtilities(LaLItems.COAL_BUCKET, LaLItems.CHARCOAL_BUCKET);

        addBeforeInIngredients(Items.DANGER_POTTERY_SHERD, LaLItems.CREAK_POTTERY_SHERD);
        addAfterInIngredients(Items.HEART_OF_THE_SEA, LaLItems.METAL_CHUNK);
        addAfterInIngredients(LaLItems.METAL_CHUNK, LaLItems.DISC_FRAGMENT_FAR_LANDS);

        addAfterInFoodAndDrinks(Items.BEETROOT, LaLItems.ENCHANTED_BEETROOT);
        addAfterInFoodAndDrinks(Items.BEETROOT_SOUP, LaLItems.ENCHANTED_BEETROOT_SOUP);

        addAfterInCombat(Items.NETHERITE_AXE, LaLGearItems.KNIFE);
        addAfterInCombat(LaLGearItems.KNIFE, LaLGearItems.HOOK);

        addAfterInCombat(Items.NETHERITE_BOOTS, LaLGearItems.DUNGEON_HELMET);
        addAfterInCombat(LaLGearItems.DUNGEON_HELMET, LaLGearItems.DUNGEON_CHESTPLATE);
        addAfterInCombat(LaLGearItems.DUNGEON_CHESTPLATE, LaLGearItems.DUNGEON_LEGGINGS);
        addAfterInCombat(LaLGearItems.DUNGEON_LEGGINGS, LaLGearItems.DUNGEON_BOOTS);

        addAfterInCombat(LaLGearItems.DUNGEON_BOOTS, LaLGearItems.FORTRESS_HELMET);
        addAfterInCombat(LaLGearItems.FORTRESS_HELMET, LaLGearItems.FORTRESS_CHESTPLATE);
        addAfterInCombat(LaLGearItems.FORTRESS_CHESTPLATE, LaLGearItems.FORTRESS_LEGGINGS);
        addAfterInCombat(LaLGearItems.FORTRESS_LEGGINGS, LaLGearItems.FORTRESS_BOOTS);

        addAfterInCombat(LaLGearItems.FORTRESS_BOOTS, LaLGearItems.WARD_HELMET);
        addAfterInCombat(LaLGearItems.WARD_HELMET, LaLGearItems.WARD_CHESTPLATE);
        addAfterInCombat(LaLGearItems.WARD_CHESTPLATE, LaLGearItems.WARD_LEGGINGS);
        addAfterInCombat(LaLGearItems.WARD_LEGGINGS, LaLGearItems.WARD_BOOTS);

        addAfterInBuildingBlocks(Blocks.END_STONE_BRICKS, LaLBlocks.CRACKED_END_STONE_BRICKS);
    }

    private static void addAfterInNaturalBlocks(ItemLike comparedItem, ItemLike item) {
        FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.NATURAL_BLOCKS);
    }

    private static void addBeforeInBuildingBlocks(ItemLike comparedItem, ItemLike item) {
        FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.BUILDING_BLOCKS);
    }

    private static void addAfterInBuildingBlocks(ItemLike comparedItem, ItemLike item) {
        FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.BUILDING_BLOCKS);
    }

    private static void addAfterInRedstone(ItemLike comparedItem, ItemLike item) {
        FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.REDSTONE_BLOCKS);
    }

    private static void addAfterInFunctionalBlocks(ItemLike comparedItem, ItemLike item) {
        FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.FUNCTIONAL_BLOCKS);
    }

    private static void addBeforeInRedstoneBlocks(ItemLike comparedItem, ItemLike item) {
        FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.REDSTONE_BLOCKS);
    }

    private static void addInToolsAndUtilities(ItemLike item) {
        FrozenCreativeTabs.add(item, CreativeModeTabs.TOOLS_AND_UTILITIES);
    }

    private static void addAfterInToolsAndUtilities(ItemLike comparedItem, ItemLike item) {
        FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.TOOLS_AND_UTILITIES);
    }

    private static void addBeforeInIngredients(ItemLike comparedItem, ItemLike item) {
        FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.INGREDIENTS);
    }

    private static void addAfterInIngredients(ItemLike comparedItem, ItemLike item) {
        FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.INGREDIENTS);
    }

    private static void addBeforeInFoodAndDrinks(ItemLike comparedItem, ItemLike item) {
        FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.FOOD_AND_DRINKS);
    }

    private static void addAfterInFoodAndDrinks(ItemLike comparedItem, ItemLike item) {
        FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.FOOD_AND_DRINKS);
    }

    private static void addAfterInCombat(ItemLike comparedItem, ItemLike item) {
        FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.COMBAT);
    }

    private static void addBeforeInSpawnEggs(ItemLike comparedItem, ItemLike item) {
        FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.SPAWN_EGGS);
    }

    private static void addAfterInSpawnEggs(ItemLike comparedItem, ItemLike item) {
        FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.SPAWN_EGGS);
    }
}
