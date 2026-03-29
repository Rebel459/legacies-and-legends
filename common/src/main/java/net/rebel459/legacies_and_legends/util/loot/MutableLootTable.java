package net.rebel459.legacies_and_legends.util.loot;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public final class MutableLootTable {

    private final List<LootPool.Builder> pools;

    public MutableLootTable(List<LootPool.Builder> pools) {
        this.pools = pools;
    }

    public void modifyPools(Predicate<LootPool.Builder> filter, Consumer<LaLMutableLootPool> modifier) {
        for (LootPool.Builder pool : this.pools) {
            if (filter.test(pool)) {
                modifier.accept(new LaLMutableLootPool(pool));
            }
        }
    }

    public void modifyPools(Consumer<LaLMutableLootPool> modifier) {
        for (LootPool.Builder pool : this.pools) {
            modifier.accept(new LaLMutableLootPool(pool));
        }
    }

    public static Predicate<LootPool.Builder> has(Item item) {
        return pool -> new LaLMutableLootPool(pool).contains(item);
    }

    public static final class LaLMutableLootPool {
        private final LootPool.Builder pool;

        public LaLMutableLootPool(LootPool.Builder pool) {
            this.pool = pool;
        }

        public boolean contains(Item item) {
            return LootTableReflection.getEntries(this.pool).stream().anyMatch(entry -> containsItem(entry, item));
        }

        public LaLMutableLootPool add(Object suppliedItem, int weight, LootItemFunction.Builder function) {
            Item item = resolveItem(suppliedItem);
            this.pool.add(LootItem.lootTableItem(item).setWeight(weight).apply(function));
            return this;
        }

        public LaLMutableLootPool replace(Item from, Object suppliedItem) {
            Item to = resolveItem(suppliedItem);
            List<LootPoolEntryContainer> updated = new ArrayList<>();
            boolean replaced = false;

            for (LootPoolEntryContainer entry : LootTableReflection.getEntries(this.pool)) {
                if (!replaced && isDirectItemEntry(entry, from)) {
                    updated.add(LootItem.lootTableItem(to).build());
                    replaced = true;
                } else {
                    updated.add(entry);
                }
            }

            if (replaced) {
                LootTableReflection.setEntries(this.pool, updated);
            }

            return this;
        }

        private static boolean containsItem(LootPoolEntryContainer entry, Item item) {
            return isDirectItemEntry(entry, item);
        }

        private static boolean isDirectItemEntry(LootPoolEntryContainer entry, Item item) {
            Object directItem = LootTableReflection.getItem(entry);
            return directItem == item;
        }

        private static Item resolveItem(Object suppliedItem) {
            try {
                return (Item) suppliedItem.getClass().getMethod("get").invoke(suppliedItem);
            } catch (ReflectiveOperationException ignored) {
                return (Item) suppliedItem;
            }
        }
    }
}
