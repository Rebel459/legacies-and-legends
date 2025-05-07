package net.legacy.legacies_and_legends.registry;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.frozenblock.lib.loot.api.LootTableModificationApi;
import net.frozenblock.lib.loot.impl.MutableLootTable;
import net.legacy.legacies_and_legends.LaLConstants;
import net.legacy.legacies_and_legends.LegaciesAndLegends;
import net.legacy.legacies_and_legends.config.LaLConfig;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;
import net.minecraft.world.level.storage.loot.functions.SetEnchantmentsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemDamageFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;

public class LaLLootTables {
	public static final ResourceKey<LootTable> BIRCH_RUINS = register("chests/forest_ruins/birch");
	public static final ResourceKey<LootTable> CHERRY_RUINS = register("chests/forest_ruins/cherry");
	public static final ResourceKey<LootTable> MAPLE_RUINS = register("chests/forest_ruins/maple");

	public static final ResourceKey<LootTable> DEEP_RUINS = register("chests/deep_ruins/deep");
	public static final ResourceKey<LootTable> SCULK_RUINS = register("chests/deep_ruins/sculk");

	public static final ResourceKey<LootTable> PALE_CABIN = register("chests/pale_cabin/chest");
	public static final ResourceKey<LootTable> PALE_CABIN_SECRET = register("chests/pale_cabin/secret");

	public static final ResourceKey<LootTable> RUINED_AETHER_PORTAL = register("chests/ruined_aether_portal");

	public static final ResourceKey<LootTable> RUINED_LIBRARY = register("chests/ruined_library");

	public static final ResourceKey<LootTable> END_RUINS = register("chests/end_ruins");

	public static final ResourceKey<LootTable> SWAMP_HUT = register("chests/swamp_hut");

	public static final ResourceKey<LootTable> RUINS = register("chests/ruins");
	public static final ResourceKey<LootTable> RUINS_ARCHAEOLOGY = register("archaeology/ruins");

	public static final ResourceKey<LootTable> OBELISK_ARCHAEOLOGY = register("archaeology/obelisk");

	public static final ResourceKey<LootTable> DUNGEON_CHEST = register("chests/dungeon/chest");
	public static final ResourceKey<LootTable> DUNGEON_BARREL = register("chests/dungeon/barrel");
	public static final ResourceKey<LootTable> DUNGEON_LIBRARY = register("chests/dungeon/library");
	public static final ResourceKey<LootTable> DUNGEON_CHEST_SIMPLE = register("chests/dungeon/simple/chest");
	public static final ResourceKey<LootTable> DUNGEON_BARREL_SIMPLE = register("chests/dungeon/simple/barrel");
	public static final ResourceKey<LootTable> DUNGEON_LIBRARY_SIMPLE = register("chests/dungeon/simple/library");
	public static final ResourceKey<LootTable> DUNGEON_CHEST_DEEP = register("chests/dungeon/deep/chest");
	public static final ResourceKey<LootTable> DUNGEON_BARREL_DEEP = register("chests/dungeon/deep/barrel");
	public static final ResourceKey<LootTable> DUNGEON_LIBRARY_DEEP = register("chests/dungeon/deep/library");
	public static final ResourceKey<LootTable> DUNGEON_CHEST_ARID = register("chests/dungeon/arid/chest");
	public static final ResourceKey<LootTable> DUNGEON_BARREL_ARID = register("chests/dungeon/arid/barrel");
	public static final ResourceKey<LootTable> DUNGEON_LIBRARY_ARID = register("chests/dungeon/arid/library");
	public static final ResourceKey<LootTable> DUNGEON_CHEST_FROZEN = register("chests/dungeon/frozen/chest");
	public static final ResourceKey<LootTable> DUNGEON_BARREL_FROZEN = register("chests/dungeon/frozen/barrel");
	public static final ResourceKey<LootTable> DUNGEON_LIBRARY_FROZEN = register("chests/dungeon/frozen/library");
	public static final ResourceKey<LootTable> DUNGEON_CHEST_VERDANT = register("chests/dungeon/verdant/chest");
	public static final ResourceKey<LootTable> DUNGEON_BARREL_VERDANT = register("chests/dungeon/verdant/barrel");
	public static final ResourceKey<LootTable> DUNGEON_LIBRARY_VERDANT = register("chests/dungeon/verdant/library");
	public static final ResourceKey<LootTable> DUNGEON_CHEST_INFERNAL = register("chests/dungeon/infernal/chest");
	public static final ResourceKey<LootTable> DUNGEON_BARREL_INFERNAL = register("chests/dungeon/infernal/barrel");
	public static final ResourceKey<LootTable> DUNGEON_LIBRARY_INFERNAL = register("chests/dungeon/infernal/library");

	public static final ResourceKey<LootTable> END_REMAINS = registerEndReborn("chests/end_remains");

	public static final ResourceKey<LootTable> END_CITY_CHEST = registerEnderscape("end_city/chest");
	public static final ResourceKey<LootTable> END_CITY_VAULT = registerEnderscape("end_city/vault");
	public static final ResourceKey<LootTable> END_CITY_ELYTRA_VAULT = registerEnderscape("end_city/elytra_vault");

	public static void init() {
		LootTableEvents.MODIFY.register((id, tableBuilder, source, registries) -> {
			LootPool.Builder pool;

			// ARTIFACTS - Armor

			if (LaLLootTables.DEEP_RUINS.equals(id) && LaLConfig.get.artifacts.reinforced_chestplate) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(8))
						.add(LootItem.lootTableItem(LaLItems.REINFORCED_CHESTPLATE).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (LaLLootTables.SCULK_RUINS.equals(id) && LaLConfig.get.artifacts.reinforced_chestplate) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(5))
						.add(LootItem.lootTableItem(LaLItems.REINFORCED_CHESTPLATE).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (LaLLootTables.DUNGEON_CHEST_DEEP.equals(id) && LaLConfig.get.artifacts.reinforced_chestplate) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(20))
						.add(LootItem.lootTableItem(LaLItems.REINFORCED_CHESTPLATE).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (BuiltInLootTables.ANCIENT_CITY.equals(id) && LaLConfig.get.artifacts.reinforced_chestplate) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(20))
						.add(LootItem.lootTableItem(LaLItems.REINFORCED_CHESTPLATE).setWeight(1));
				tableBuilder.withPool(pool);
			}

			if (LaLLootTables.DUNGEON_CHEST_ARID.equals(id) && LaLConfig.get.artifacts.travelling_strides) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(11))
						.add(LootItem.lootTableItem(LaLItems.TRAVELLING_STRIDES).setWeight(1));
				tableBuilder.withPool(pool);
			}
			// Travelling Strides Crafting Recipe

			if (LaLLootTables.DUNGEON_CHEST_SIMPLE.equals(id) && LaLConfig.get.artifacts.wanderer_boots) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(14))
						.add(LootItem.lootTableItem(LaLItems.WANDERER_BOOTS).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (BuiltInLootTables.SIMPLE_DUNGEON.equals(id) && LaLConfig.get.artifacts.wanderer_boots) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(8))
						.add(LootItem.lootTableItem(LaLItems.WANDERER_BOOTS).setWeight(1));
				tableBuilder.withPool(pool);
			}

			// ARTIFACTS - Tools

			if (LaLLootTables.DUNGEON_CHEST_VERDANT.equals(id) && LaLConfig.get.artifacts.verdant_sword) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(11))
						.add(LootItem.lootTableItem(LaLEquipmentItems.VERDANT_SWORD).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (BuiltInLootTables.JUNGLE_TEMPLE.equals(id) && LaLConfig.get.artifacts.verdant_sword) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(5))
						.add(LootItem.lootTableItem(LaLEquipmentItems.VERDANT_SWORD).setWeight(1));
				tableBuilder.withPool(pool);
			}

			if (LaLLootTables.DUNGEON_CHEST.equals(id) && LaLConfig.get.artifacts.cleaving_battleaxe) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(17))
						.add(LootItem.lootTableItem(LaLEquipmentItems.CLEAVING_BATTLEAXE).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (BuiltInLootTables.SIMPLE_DUNGEON.equals(id) && LaLConfig.get.artifacts.cleaving_battleaxe) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(8))
						.add(LootItem.lootTableItem(LaLEquipmentItems.CLEAVING_BATTLEAXE).setWeight(1));
				tableBuilder.withPool(pool);
			}

			if (BuiltInLootTables.NETHER_BRIDGE.equals(id) && LaLConfig.get.artifacts.molten_pickaxe) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(8))
						.add(LootItem.lootTableItem(LaLEquipmentItems.MOLTEN_PICKAXE).setWeight(1));
				tableBuilder.withPool(pool);
			}

			if (BuiltInLootTables.BURIED_TREASURE.equals(id) && LaLConfig.get.artifacts.prospector_shovel) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(2))
						.add(LootItem.lootTableItem(LaLEquipmentItems.PROSPECTOR_SHOVEL).setWeight(1));
				tableBuilder.withPool(pool);
			}

			// Withered Hoe Loot Table

			// ARTIFACTS - Totems

			if (LaLLootTables.DUNGEON_CHEST_DEEP.equals(id) && LaLConfig.get.artifacts.totem_of_vengeance) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(14))
						.add(LootItem.lootTableItem(LaLItems.TOTEM_OF_VENGEANCE).setWeight(1));
				tableBuilder.withPool(pool);
			}

			if (BuiltInLootTables.END_CITY_TREASURE.equals(id) && LaLConfig.get.artifacts.totem_of_teleportation) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(20))
						.add(LootItem.lootTableItem(LaLItems.TOTEM_OF_TELEPORTATION).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (LaLConfig.get.integrations.enderscape) {
				if (LaLLootTables.END_CITY_VAULT.equals(id) && LaLConfig.get.artifacts.totem_of_teleportation) {
					pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(EmptyLootItem.emptyItem().setWeight(20))
							.add(LootItem.lootTableItem(LaLItems.TOTEM_OF_TELEPORTATION).setWeight(1));
					tableBuilder.withPool(pool);
				}
				if (LaLLootTables.END_CITY_ELYTRA_VAULT.equals(id) && LaLConfig.get.artifacts.totem_of_teleportation) {
					pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(EmptyLootItem.emptyItem().setWeight(20))
							.add(LootItem.lootTableItem(LaLItems.TOTEM_OF_TELEPORTATION).setWeight(1));
					tableBuilder.withPool(pool);
				}
			}

			// ARTIFACTS - Amulets

			if (LaLLootTables.RUINED_AETHER_PORTAL.equals(id) && LaLConfig.get.artifacts.amulet_of_allure) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(2))
						.add(LootItem.lootTableItem(LaLItems.AMULET_OF_ALLURE).setWeight(1));
				tableBuilder.withPool(pool);
			}

			if (LaLLootTables.SWAMP_HUT.equals(id) && LaLConfig.get.artifacts.amulet_of_evasion) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(5))
						.add(LootItem.lootTableItem(LaLItems.AMULET_OF_EVASION).setWeight(1));
				tableBuilder.withPool(pool);
			}

			if (LaLLootTables.DUNGEON_CHEST_DEEP.equals(id) && LaLConfig.get.artifacts.amulet_of_synthesis) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(29))
						.add(LootItem.lootTableItem(LaLItems.AMULET_OF_SYNTHESIS).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (BuiltInLootTables.SIMPLE_DUNGEON.equals(id) && LaLConfig.get.artifacts.amulet_of_synthesis) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(29))
						.add(LootItem.lootTableItem(LaLItems.AMULET_OF_SYNTHESIS).setWeight(1));
				tableBuilder.withPool(pool);
			}

			// ARTIFACTS - Tablets

			if (BuiltInLootTables.WOODLAND_MANSION.equals(id) && LaLConfig.get.artifacts.tablet_of_channeling) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(5))
						.add(LootItem.lootTableItem(LaLItems.TABLET_OF_CHANNELING).setWeight(1));
				tableBuilder.withPool(pool);
			}

			if (BuiltInLootTables.ANCIENT_CITY.equals(id) && LaLConfig.get.artifacts.tablet_of_deafening) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(11))
						.add(LootItem.lootTableItem(LaLItems.TABLET_OF_DEAFENING).setWeight(1));
				tableBuilder.withPool(pool);
			}

			if (BuiltInLootTables.ABANDONED_MINESHAFT.equals(id) && LaLConfig.get.artifacts.tablet_of_haste) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(5))
						.add(LootItem.lootTableItem(LaLItems.TABLET_OF_HASTE).setWeight(1));
				tableBuilder.withPool(pool);
			}

			if (BuiltInLootTables.ABANDONED_MINESHAFT.equals(id) && LaLConfig.get.artifacts.tablet_of_revealing) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(5))
						.add(LootItem.lootTableItem(LaLItems.TABLET_OF_REVEALING).setWeight(1));
				tableBuilder.withPool(pool);
			}

			if (LaLLootTables.RUINED_AETHER_PORTAL.equals(id) && LaLConfig.get.artifacts.tablet_of_recall) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(5))
						.add(LootItem.lootTableItem(LaLItems.TABLET_OF_RECALL).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (LaLLootTables.DEEP_RUINS.equals(id) && LaLConfig.get.artifacts.tablet_of_recall) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(11))
						.add(LootItem.lootTableItem(LaLItems.TABLET_OF_RECALL).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (LaLLootTables.SCULK_RUINS.equals(id) && LaLConfig.get.artifacts.tablet_of_recall) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(11))
						.add(LootItem.lootTableItem(LaLItems.TABLET_OF_RECALL).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (LaLLootTables.BIRCH_RUINS.equals(id) && LaLConfig.get.artifacts.tablet_of_recall) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(5))
						.add(LootItem.lootTableItem(LaLItems.TABLET_OF_RECALL).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (LaLLootTables.CHERRY_RUINS.equals(id) && LaLConfig.get.artifacts.tablet_of_recall) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(5))
						.add(LootItem.lootTableItem(LaLItems.TABLET_OF_RECALL).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (LaLLootTables.MAPLE_RUINS.equals(id) && LaLConfig.get.artifacts.tablet_of_recall) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(5))
						.add(LootItem.lootTableItem(LaLItems.TABLET_OF_RECALL).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (LaLLootTables.DUNGEON_CHEST_ARID.equals(id) && LaLConfig.get.artifacts.tablet_of_recall) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(5))
						.add(LootItem.lootTableItem(LaLItems.TABLET_OF_RECALL).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (LaLLootTables.DUNGEON_CHEST_FROZEN.equals(id) && LaLConfig.get.artifacts.tablet_of_recall) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(5))
						.add(LootItem.lootTableItem(LaLItems.TABLET_OF_RECALL).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (LaLLootTables.DUNGEON_CHEST_SIMPLE.equals(id) && LaLConfig.get.artifacts.tablet_of_recall) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(5))
						.add(LootItem.lootTableItem(LaLItems.TABLET_OF_RECALL).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (LaLLootTables.DUNGEON_CHEST_VERDANT.equals(id) && LaLConfig.get.artifacts.tablet_of_recall) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(5))
						.add(LootItem.lootTableItem(LaLItems.TABLET_OF_RECALL).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (LaLLootTables.DUNGEON_CHEST_INFERNAL.equals(id) && LaLConfig.get.artifacts.tablet_of_recall) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(11))
						.add(LootItem.lootTableItem(LaLItems.TABLET_OF_RECALL).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (LaLLootTables.DUNGEON_CHEST_DEEP.equals(id) && LaLConfig.get.artifacts.tablet_of_recall) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(11))
						.add(LootItem.lootTableItem(LaLItems.TABLET_OF_RECALL).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (BuiltInLootTables.ABANDONED_MINESHAFT.equals(id) && LaLConfig.get.artifacts.tablet_of_recall) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(8))
						.add(LootItem.lootTableItem(LaLItems.TABLET_OF_RECALL).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (BuiltInLootTables.STRONGHOLD_CORRIDOR.equals(id) && LaLConfig.get.artifacts.tablet_of_recall) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(5))
						.add(LootItem.lootTableItem(LaLItems.TABLET_OF_RECALL).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (BuiltInLootTables.RUINED_PORTAL.equals(id) && LaLConfig.get.artifacts.tablet_of_recall) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(11))
						.add(LootItem.lootTableItem(LaLItems.TABLET_OF_RECALL).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (BuiltInLootTables.END_CITY_TREASURE.equals(id) && LaLConfig.get.artifacts.tablet_of_recall) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(29))
						.add(LootItem.lootTableItem(LaLItems.TABLET_OF_RECALL).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (LaLConfig.get.integrations.enderscape) {
				if (LaLLootTables.END_CITY_VAULT.equals(id) && LaLConfig.get.artifacts.tablet_of_recall) {
					pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(EmptyLootItem.emptyItem().setWeight(29))
							.add(LootItem.lootTableItem(LaLItems.TABLET_OF_RECALL).setWeight(1));
					tableBuilder.withPool(pool);
				}
				if (LaLLootTables.END_CITY_ELYTRA_VAULT.equals(id) && LaLConfig.get.artifacts.tablet_of_recall) {
					pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(EmptyLootItem.emptyItem().setWeight(29))
							.add(LootItem.lootTableItem(LaLItems.TABLET_OF_RECALL).setWeight(1));
					tableBuilder.withPool(pool);
				}
			}
			if (BuiltInLootTables.SIMPLE_DUNGEON.equals(id) && LaLConfig.get.artifacts.tablet_of_recall) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(5))
						.add(LootItem.lootTableItem(LaLItems.TABLET_OF_RECALL).setWeight(1));
				tableBuilder.withPool(pool);
			}

			if (BuiltInLootTables.END_CITY_TREASURE.equals(id) && LaLConfig.get.artifacts.tablet_of_levitation) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(14))
						.add(LootItem.lootTableItem(LaLItems.TABLET_OF_LEVITATION).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (LaLConfig.get.integrations.enderscape) {
				if (LaLLootTables.END_CITY_VAULT.equals(id) && LaLConfig.get.artifacts.tablet_of_levitation) {
					pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(EmptyLootItem.emptyItem().setWeight(14))
							.add(LootItem.lootTableItem(LaLItems.TABLET_OF_LEVITATION).setWeight(1));
					tableBuilder.withPool(pool);
				}
				if (LaLLootTables.END_CITY_ELYTRA_VAULT.equals(id) && LaLConfig.get.artifacts.tablet_of_levitation) {
					pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(EmptyLootItem.emptyItem().setWeight(14))
							.add(LootItem.lootTableItem(LaLItems.TABLET_OF_LEVITATION).setWeight(1));
					tableBuilder.withPool(pool);
				}
			}

			// LOOT - General

			if (LaLConfig.get.loot.enchanted_beetroot) {
				LootTableModificationApi.editTable(
						LaLLootTables.END_RUINS, false,
						(itemId, mutableLootTable) -> mutableLootTable.modifyPools(
								MutableLootTable.has(Items.FISHING_ROD),
								(lootPool) -> lootPool.replace(Items.BEETROOT, LaLItems.ENCHANTED_BEETROOT)
						)
				);
				LootTableModificationApi.editTable(
						BuiltInLootTables.END_CITY_TREASURE, false,
						(itemId, mutableLootTable) -> mutableLootTable.modifyPools(
								MutableLootTable.has(Items.BEETROOT_SEEDS),
								(lootPool) -> lootPool.add(LaLItems.ENCHANTED_BEETROOT, 1, SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
						)
				);
				if (LaLConfig.get.integrations.enderscape) {
					if (LaLLootTables.END_CITY_CHEST.equals(id) && LaLConfig.get.loot.enchanted_beetroot) {
						pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
								.add(EmptyLootItem.emptyItem().setWeight(20))
								.add(LootItem.lootTableItem(LaLItems.ENCHANTED_BEETROOT).setWeight(1));
						tableBuilder.withPool(pool);
					}
				}
				LootTableModificationApi.editTable(
						BuiltInLootTables.STRONGHOLD_CORRIDOR, false,
						(itemId, mutableLootTable) -> mutableLootTable.modifyPools(
								MutableLootTable.has(Items.GOLDEN_APPLE),
								(lootPool) -> lootPool.add(LaLItems.ENCHANTED_BEETROOT, 3, SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
						)
				);
				LootTableModificationApi.editTable(
						BuiltInLootTables.STRONGHOLD_CROSSING, false,
						(itemId, mutableLootTable) -> mutableLootTable.modifyPools(
								MutableLootTable.has(Items.APPLE),
								(lootPool) -> lootPool.add(LaLItems.ENCHANTED_BEETROOT, 3, SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
						)
				);
				LootTableModificationApi.editTable(
						LaLLootTables.END_REMAINS, false,
						(itemId, mutableLootTable) -> mutableLootTable.modifyPools(
								(lootPool) -> lootPool.add(LaLItems.ENCHANTED_BEETROOT, 3, SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
						)
				);
			}

			if (LaLLootTables.DUNGEON_CHEST.equals(id) && LaLConfig.get.loot.metal_chunk) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(5))
						.add(LootItem.lootTableItem(LaLItems.METAL_CHUNK).setWeight(1).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))));
				tableBuilder.withPool(pool);
			}

			if (LaLConfig.get.loot.wooden_buckets) {
				LootTableModificationApi.editTable(
						BuiltInLootTables.SHIPWRECK_SUPPLY, false,
						(itemId, mutableLootTable) -> mutableLootTable.modifyPools(
								MutableLootTable.has(Items.PAPER),
								(lootPool) -> lootPool.add(LaLItems.WOODEN_BUCKET, 3, SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
						)
				);
			}

			// LOOT - Weapons

			if (BuiltInLootTables.SIMPLE_DUNGEON.equals(id) && LaLConfig.get.loot.boomerang) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(8))
						.add(LootItem.lootTableItem(LaLItems.BOOMERANG).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (LaLLootTables.DUNGEON_CHEST.equals(id) && LaLConfig.get.loot.boomerang) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(11))
						.add(LootItem.lootTableItem(LaLItems.BOOMERANG).setWeight(1));
				tableBuilder.withPool(pool);
			}

			if (LaLConfig.get.loot.hook) {
				LootTableModificationApi.editTable(
						BuiltInLootTables.FISHING_TREASURE, false,
						(itemId, mutableLootTable) -> mutableLootTable.modifyPools(
								MutableLootTable.has(Items.FISHING_ROD),
								(lootPool) -> lootPool
										.add(LaLEquipmentItems.HOOK, 1, EnchantRandomlyFunction.randomApplicableEnchantment(registries))
						)
				);
			}
			LootTableModificationApi.editTable(
					BuiltInLootTables.UNDERWATER_RUIN_BIG, false,
					(itemId, mutableLootTable) -> mutableLootTable.modifyPools(
							MutableLootTable.has(Items.FISHING_ROD),
							(lootPool) -> lootPool.add(LaLEquipmentItems.HOOK, 3, EnchantRandomlyFunction.randomApplicableEnchantment(registries))
					)
			);
			LootTableModificationApi.editTable(
					BuiltInLootTables.UNDERWATER_RUIN_SMALL, false,
					(itemId, mutableLootTable) -> mutableLootTable.modifyPools(
							MutableLootTable.has(Items.FISHING_ROD),
							(lootPool) -> lootPool.add(LaLEquipmentItems.HOOK, 3, SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
					)
			);

			if (LaLConfig.get.loot.knife) {
				LootTableModificationApi.editTable(
						BuiltInLootTables.TRAIL_RUINS_ARCHAEOLOGY_RARE, false,
						(itemId, mutableLootTable) -> mutableLootTable.modifyPools(
								(lootPool) -> lootPool.add(LaLEquipmentItems.KNIFE, 1, SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
						)
				);
			}

			// LOOT - Music Discs

			if (BuiltInLootTables.ABANDONED_MINESHAFT.equals(id) && LaLConfig.get.loot.new_music_discs) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(5))
						.add(LootItem.lootTableItem(LaLItems.MUSIC_DISC_SVALL).setWeight(1));
				tableBuilder.withPool(pool);
			}

			if (LaLLootTables.DEEP_RUINS.equals(id) && LaLConfig.get.loot.new_music_discs) {
				pool = LootPool.lootPool().setRolls(UniformGenerator.between(0.0F, 1.0F))
						.add(LootItem.lootTableItem(LaLItems.MUSIC_DISC_TASWELL).setWeight(1));
				tableBuilder.withPool(pool);
			}

			if (BuiltInLootTables.END_CITY_TREASURE.equals(id) && LaLConfig.get.loot.new_music_discs) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(20))
						.add(LootItem.lootTableItem(LaLItems.MUSIC_DISC_SHULKER).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (LaLConfig.get.integrations.enderscape) {
				if (LaLLootTables.END_CITY_CHEST.equals(id) && LaLConfig.get.loot.new_music_discs) {
					pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
							.add(EmptyLootItem.emptyItem().setWeight(20))
							.add(LootItem.lootTableItem(LaLItems.MUSIC_DISC_SHULKER).setWeight(1));
					tableBuilder.withPool(pool);
				}
			}

			if (LaLLootTables.PALE_CABIN_SECRET.equals(id) && LaLConfig.get.loot.new_music_discs) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(LootItem.lootTableItem(LaLItems.MUSIC_DISC_INFINITE_SPOOKY_AMETHYST).setWeight(1));
				tableBuilder.withPool(pool);
			}
			else if (LaLLootTables.PALE_CABIN_SECRET.equals(id) && !LaLConfig.get.loot.new_music_discs) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(LootItem.lootTableItem(Items.DIAMOND).setWeight(1));
				tableBuilder.withPool(pool);
			}

			if (BuiltInLootTables.IGLOO_CHEST.equals(id) && LaLConfig.get.loot.new_music_discs && !LaLConfig.get.structures.dungeon_overhaul) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(2))
						.add(LootItem.lootTableItem(LaLItems.MUSIC_DISC_TUNDRA).setWeight(1));
				tableBuilder.withPool(pool);
			}
			else if (BuiltInLootTables.IGLOO_CHEST.equals(id) && LaLConfig.get.loot.new_music_discs && LaLConfig.get.structures.dungeon_overhaul) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(5))
						.add(LootItem.lootTableItem(LaLItems.MUSIC_DISC_TUNDRA).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (LaLLootTables.DUNGEON_CHEST_FROZEN.equals(id) && LaLConfig.get.loot.new_music_discs) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(8))
						.add(LootItem.lootTableItem(LaLItems.MUSIC_DISC_TUNDRA).setWeight(1));
				tableBuilder.withPool(pool);
			}

			if (BuiltInLootTables.WOODLAND_MANSION.equals(id) && LaLConfig.get.loot.new_music_discs) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(20))
						.add(LootItem.lootTableItem(LaLItems.DISC_FRAGMENT_FAR_LANDS).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (BuiltInLootTables.STRONGHOLD_CROSSING.equals(id) && LaLConfig.get.loot.new_music_discs) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(8))
						.add(LootItem.lootTableItem(LaLItems.DISC_FRAGMENT_FAR_LANDS).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (BuiltInLootTables.JUNGLE_TEMPLE.equals(id) && LaLConfig.get.loot.new_music_discs) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(5))
						.add(LootItem.lootTableItem(LaLItems.DISC_FRAGMENT_FAR_LANDS).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (BuiltInLootTables.ABANDONED_MINESHAFT.equals(id) && LaLConfig.get.loot.new_music_discs) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(20))
						.add(LootItem.lootTableItem(LaLItems.DISC_FRAGMENT_FAR_LANDS).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (LaLLootTables.RUINS.equals(id) && LaLConfig.get.loot.new_music_discs) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(2))
						.add(LootItem.lootTableItem(LaLItems.DISC_FRAGMENT_FAR_LANDS).setWeight(1));
				tableBuilder.withPool(pool);
			}
			if (LaLConfig.get.loot.new_music_discs) {
				LootTableModificationApi.editTable(
						BuiltInLootTables.SIMPLE_DUNGEON, false,
						(itemId, mutableLootTable) -> mutableLootTable.modifyPools(
								MutableLootTable.has(Items.GOLDEN_APPLE),
								(lootPool) -> lootPool.add(LaLItems.DISC_FRAGMENT_FAR_LANDS, 10, SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
						)
				);
				LootTableModificationApi.editTable(
						LaLLootTables.DUNGEON_CHEST_ARID, false,
						(itemId, mutableLootTable) -> mutableLootTable.modifyPools(
								MutableLootTable.has(Items.GOLDEN_APPLE),
								(lootPool) -> lootPool.add(LaLItems.DISC_FRAGMENT_FAR_LANDS, 10, SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
						)
				);
				LootTableModificationApi.editTable(
						LaLLootTables.DUNGEON_CHEST_FROZEN, false,
						(itemId, mutableLootTable) -> mutableLootTable.modifyPools(
								MutableLootTable.has(Items.GOLDEN_APPLE),
								(lootPool) -> lootPool.add(LaLItems.DISC_FRAGMENT_FAR_LANDS, 10, SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
						)
				);
				LootTableModificationApi.editTable(
						LaLLootTables.DUNGEON_CHEST_VERDANT, false,
						(itemId, mutableLootTable) -> mutableLootTable.modifyPools(
								MutableLootTable.has(Items.GOLDEN_APPLE),
								(lootPool) -> lootPool
										.add(LaLItems.DISC_FRAGMENT_FAR_LANDS, 10, SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
										.replace(Items.MUSIC_DISC_13, LaLItems.MUSIC_DISC_CASTLES)
						)
				);

				LootTableModificationApi.editTable(
						LaLLootTables.DUNGEON_CHEST_SIMPLE, false,
						(itemId, mutableLootTable) -> mutableLootTable.modifyPools(
								MutableLootTable.has(Items.MUSIC_DISC_13),
								(lootPool) -> lootPool
										.add(LaLItems.DISC_FRAGMENT_FAR_LANDS, 10, SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
										.replace(Items.MUSIC_DISC_13, LaLItems.MUSIC_DISC_CASTLES)

						)
				);
			}

			// ENCHANTMENTS

			if (BuiltInLootTables.JUNGLE_TEMPLE.equals(id) && LaLConfig.get.enchantments.tangled) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(5))
						.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).setWeight(1)).apply((new SetEnchantmentsFunction.Builder()).withEnchantment(registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(LaLEnchantments.TANGLED), UniformGenerator.between(1.0F, 1.0F)));
				tableBuilder.withPool(pool);
			}

			if (BuiltInLootTables.SIMPLE_DUNGEON.equals(id) && LaLConfig.get.enchantments.rejuvenate) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(11))
						.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).setWeight(1)).apply((new SetEnchantmentsFunction.Builder()).withEnchantment(registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(LaLEnchantments.REJUVENATE), UniformGenerator.between(1.0F, 1.0F)));
				tableBuilder.withPool(pool);
			}
			if (LaLLootTables.DUNGEON_CHEST_SIMPLE.equals(id) && LaLConfig.get.enchantments.rejuvenate) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(11))
						.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).setWeight(1)).apply((new SetEnchantmentsFunction.Builder()).withEnchantment(registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(LaLEnchantments.REJUVENATE), UniformGenerator.between(1.0F, 1.0F)));
				tableBuilder.withPool(pool);
			}
			if (LaLLootTables.DUNGEON_LIBRARY_SIMPLE.equals(id) && LaLConfig.get.enchantments.rejuvenate) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(5))
						.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).setWeight(1)).apply((new SetEnchantmentsFunction.Builder()).withEnchantment(registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(LaLEnchantments.REJUVENATE), UniformGenerator.between(1.0F, 1.0F)));
				tableBuilder.withPool(pool);
			}

			if (BuiltInLootTables.SIMPLE_DUNGEON.equals(id) && LaLConfig.get.enchantments.featherweight) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(11))
						.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).setWeight(1)).apply((new SetEnchantmentsFunction.Builder()).withEnchantment(registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(LaLEnchantments.FEATHERWEIGHT), UniformGenerator.between(1.0F, 3.0F)));
				tableBuilder.withPool(pool);
			}
			if (LaLLootTables.DUNGEON_CHEST_ARID.equals(id) && LaLConfig.get.enchantments.featherweight) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(5))
						.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).setWeight(1)).apply((new SetEnchantmentsFunction.Builder()).withEnchantment(registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(LaLEnchantments.FEATHERWEIGHT), UniformGenerator.between(1.0F, 3.0F)));
				tableBuilder.withPool(pool);
			}
			if (LaLLootTables.DUNGEON_LIBRARY_ARID.equals(id) && LaLConfig.get.enchantments.featherweight) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(2))
						.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).setWeight(1)).apply((new SetEnchantmentsFunction.Builder()).withEnchantment(registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(LaLEnchantments.FEATHERWEIGHT), UniformGenerator.between(1.0F, 3.0F)));
				tableBuilder.withPool(pool);
			}

			if (BuiltInLootTables.SIMPLE_DUNGEON.equals(id) && LaLConfig.get.enchantments.freeze) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(11))
						.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).setWeight(1)).apply((new SetEnchantmentsFunction.Builder()).withEnchantment(registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(LaLEnchantments.FREEZE), UniformGenerator.between(1.0F, 1.0F)));
				tableBuilder.withPool(pool);
			}
			if (LaLLootTables.DUNGEON_CHEST_FROZEN.equals(id) && LaLConfig.get.enchantments.freeze) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(5))
						.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).setWeight(1)).apply((new SetEnchantmentsFunction.Builder()).withEnchantment(registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(LaLEnchantments.FREEZE), UniformGenerator.between(1.0F, 1.0F)));
				tableBuilder.withPool(pool);
			}
			if (LaLLootTables.DUNGEON_LIBRARY_FROZEN.equals(id) && LaLConfig.get.enchantments.freeze) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(2))
						.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).setWeight(1)).apply((new SetEnchantmentsFunction.Builder()).withEnchantment(registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(LaLEnchantments.FREEZE), UniformGenerator.between(1.0F, 1.0F)));
				tableBuilder.withPool(pool);
			}

			if (BuiltInLootTables.SIMPLE_DUNGEON.equals(id) && LaLConfig.get.enchantments.decay) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(11))
						.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).setWeight(1)).apply((new SetEnchantmentsFunction.Builder()).withEnchantment(registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(LaLEnchantments.DECAY), UniformGenerator.between(1.0F, 1.0F)));
				tableBuilder.withPool(pool);
			}
			if (LaLLootTables.DUNGEON_CHEST_VERDANT.equals(id) && LaLConfig.get.enchantments.decay) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(5))
						.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).setWeight(1)).apply((new SetEnchantmentsFunction.Builder()).withEnchantment(registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(LaLEnchantments.DECAY), UniformGenerator.between(1.0F, 1.0F)));
				tableBuilder.withPool(pool);
			}
			if (LaLLootTables.DUNGEON_LIBRARY_VERDANT.equals(id) && LaLConfig.get.enchantments.decay) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(2))
						.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).setWeight(1)).apply((new SetEnchantmentsFunction.Builder()).withEnchantment(registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(LaLEnchantments.DECAY), UniformGenerator.between(1.0F, 1.0F)));
				tableBuilder.withPool(pool);
			}
			if (LaLLootTables.DUNGEON_CHEST_DEEP.equals(id) && LaLConfig.get.enchantments.decay && !LegaciesAndLegends.isVariantsAndVenturesLoaded) {
				pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
						.add(EmptyLootItem.emptyItem().setWeight(5))
						.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).setWeight(1)).apply((new SetEnchantmentsFunction.Builder()).withEnchantment(registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(LaLEnchantments.DECAY), UniformGenerator.between(1.0F, 1.0F)));
				tableBuilder.withPool(pool);
			}

			// LootTableModificationApi Multi-Choice

			if (LaLConfig.get.loot.hook && LaLConfig.get.loot.metal_chunk && LaLConfig.get.loot.wooden_buckets) {
				LootTableModificationApi.editTable(
						BuiltInLootTables.FISHING_JUNK, false,
						(itemId, mutableLootTable) -> mutableLootTable.modifyPools(
								MutableLootTable.has(Items.LILY_PAD),
								(lootPool) -> lootPool
										.add(LaLEquipmentItems.HOOK, 2, SetItemDamageFunction.setDamage(UniformGenerator.between(0.0F, 0.9F)))
										.add(LaLItems.METAL_CHUNK, 10, SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
										.add(LaLItems.WOODEN_BUCKET, 10, SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
						)
				);
			}
			else if (LaLConfig.get.loot.hook && LaLConfig.get.loot.metal_chunk && !LaLConfig.get.loot.wooden_buckets) {
				LootTableModificationApi.editTable(
						BuiltInLootTables.FISHING_JUNK, false,
						(itemId, mutableLootTable) -> mutableLootTable.modifyPools(
								MutableLootTable.has(Items.LILY_PAD),
								(lootPool) -> lootPool
										.add(LaLEquipmentItems.HOOK, 2, SetItemDamageFunction.setDamage(UniformGenerator.between(0.0F, 0.9F)))
										.add(LaLItems.METAL_CHUNK, 10, SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
						)
				);
			}
			else if (LaLConfig.get.loot.hook && !LaLConfig.get.loot.metal_chunk && LaLConfig.get.loot.wooden_buckets) {
				LootTableModificationApi.editTable(
						BuiltInLootTables.FISHING_JUNK, false,
						(itemId, mutableLootTable) -> mutableLootTable.modifyPools(
								MutableLootTable.has(Items.LILY_PAD),
								(lootPool) -> lootPool
										.add(LaLEquipmentItems.HOOK, 2, SetItemDamageFunction.setDamage(UniformGenerator.between(0.0F, 0.9F)))
										.add(LaLItems.WOODEN_BUCKET, 10, SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
						)
				);
			}
			else if (!LaLConfig.get.loot.hook && LaLConfig.get.loot.metal_chunk && LaLConfig.get.loot.wooden_buckets) {
				LootTableModificationApi.editTable(
						BuiltInLootTables.FISHING_JUNK, false,
						(itemId, mutableLootTable) -> mutableLootTable.modifyPools(
								MutableLootTable.has(Items.LILY_PAD),
								(lootPool) -> lootPool
										.add(LaLItems.METAL_CHUNK, 10, SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
										.add(LaLItems.WOODEN_BUCKET, 10, SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
						)
				);
			}
			else if (LaLConfig.get.loot.hook && !LaLConfig.get.loot.metal_chunk && !LaLConfig.get.loot.wooden_buckets) {
				LootTableModificationApi.editTable(
						BuiltInLootTables.FISHING_JUNK, false,
						(itemId, mutableLootTable) -> mutableLootTable.modifyPools(
								MutableLootTable.has(Items.LILY_PAD),
								(lootPool) -> lootPool
										.add(LaLEquipmentItems.HOOK, 2, SetItemDamageFunction.setDamage(UniformGenerator.between(0.0F, 0.9F)))
						)
				);
			}
			else if (!LaLConfig.get.loot.hook && LaLConfig.get.loot.metal_chunk && !LaLConfig.get.loot.wooden_buckets) {
				LootTableModificationApi.editTable(
						BuiltInLootTables.FISHING_JUNK, false,
						(itemId, mutableLootTable) -> mutableLootTable.modifyPools(
								MutableLootTable.has(Items.LILY_PAD),
								(lootPool) -> lootPool
										.add(LaLItems.METAL_CHUNK, 10, SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
						)
				);
			}
			else if (!LaLConfig.get.loot.hook && !LaLConfig.get.loot.metal_chunk && LaLConfig.get.loot.wooden_buckets) {
				LootTableModificationApi.editTable(
						BuiltInLootTables.FISHING_JUNK, false,
						(itemId, mutableLootTable) -> mutableLootTable.modifyPools(
								MutableLootTable.has(Items.LILY_PAD),
								(lootPool) -> lootPool
										.add(LaLItems.WOODEN_BUCKET, 10, SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 1.0F)))
						)
				);
			}

		});
	}

	private static @NotNull ResourceKey<LootTable> register(String path) {
		return ResourceKey.create(Registries.LOOT_TABLE, LaLConstants.id(path));
	}

	private static @NotNull ResourceKey<LootTable> registerEndReborn(String path) {
		return ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath("end_reborn", path));
	}

	private static @NotNull ResourceKey<LootTable> registerEnderscape(String path) {
		return ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath("enderscape", path));
	}
}
