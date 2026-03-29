package net.rebel459.legacies_and_legends.util.loot;

import net.fabricmc.fabric.api.loot.v3.FabricLootTableBuilder;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;

public final class LootTableFabricEvent {

    private LootTableFabricEvent() {}

    public static void init() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, holder) -> {
            var fabricBuilder = (FabricLootTableBuilder) tableBuilder;

            for (LootTableModificationApi.Edit edit : LootTableModificationApi.getEdits()) {
                if (!edit.tableId().equals(key)) {
                    continue;
                }

                fabricBuilder.modifyPools(pool -> edit.callback().edit(key, new MutableLootTable(java.util.List.of(pool))));
            }
        });
    }
}
