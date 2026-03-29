package net.rebel459.legacies_and_legends.util.loot;

import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.LootTableLoadEvent;
import net.rebel459.legacies_and_legends.LaLConstants;

import java.util.ArrayList;
import java.util.List;

@EventBusSubscriber(modid = LaLConstants.MOD_ID)
public final class LootTableNeoForgeEvent {

    private LootTableNeoForgeEvent() {}

    @SubscribeEvent
    public static void onLootTableLoad(LootTableLoadEvent event) {
        LootTable table = event.getTable();
        for (LootTableModificationApi.Edit edit : LootTableModificationApi.getEdits()) {
            if (!edit.tableId().equals(event.getKey())) {
                continue;
            }

            List<LootPool.Builder> poolBuilders = new ArrayList<>();
            for (LootPool pool : LootTableReflection.getPools(table)) {
                poolBuilders.add(copyPool(pool));
            }

            edit.callback().edit(event.getKey(), new MutableLootTable(poolBuilders));

            LootTable.Builder builder = LootTable.lootTable().setParamSet(table.getParamSet());
            LootTableReflection.getRandomSequence(table).ifPresent(builder::setRandomSequence);

            for (LootPool.Builder poolBuilder : poolBuilders) {
                builder.withPool(poolBuilder);
            }
            LootTableReflection.setFunctions(builder, LootTableReflection.getFunctions(table));

            table = builder.build();
        }

        event.setTable(table);
    }

    private static LootPool.Builder copyPool(LootPool pool) {
        LootPool.Builder builder = LootPool.lootPool();

        LootTableReflection.setEntries(builder, LootTableReflection.getEntries(pool));
        LootTableReflection.setConditions(builder, LootTableReflection.getConditions(pool));
        LootTableReflection.setFunctions(builder, LootTableReflection.getFunctions(pool));
        LootTableReflection.setRolls(builder, LootTableReflection.getRolls(pool));
        LootTableReflection.setBonusRolls(builder, LootTableReflection.getBonusRolls(pool));
        return builder;
    }
}
