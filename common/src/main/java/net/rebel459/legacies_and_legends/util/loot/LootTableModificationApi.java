package net.rebel459.legacies_and_legends.util.loot;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

public final class LootTableModificationApi {

    private static final List<Edit> EDITS = new ArrayList<>();

    private LootTableModificationApi() {}

    public static void editTable(ResourceKey<LootTable> tableId, boolean replace, EditCallback callback) {
        EDITS.add(new Edit(tableId, replace, callback));
    }

    public static List<Edit> getEdits() {
        return List.copyOf(EDITS);
    }

    @FunctionalInterface
    public interface EditCallback {
        void edit(ResourceKey<LootTable> tableId, MutableLootTable mutableLootTable);
    }

    public record Edit(ResourceKey<LootTable> tableId, boolean replace, EditCallback callback) {}
}
