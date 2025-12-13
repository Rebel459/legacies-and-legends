package net.legacy.legacies_and_legends.item;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketEnums;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class AmuletItem extends AccessoryItem implements Trinket {

    public int repairTicks = 0;
    public int inventoryRepairTicks = 0;
    public int repairTicksFrequency() {
        return 20;
    }
    public int repairCooldownTicks = 0;
    public int repairCooldownTicksFrequency() {
        return 100;
    }

    public AmuletItem(Item.Properties settings) {
        super(settings);
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        everyTick(stack, slot, entity);
        secondTicks = secondTicks + 1;
        if (secondTicks >= 20) {
            secondTicks = 0;
            everySecond(stack, slot, entity);
        }

        if (entity instanceof Player player) {
            if (getAccessory(stack, slot, player).getDamageValue() == 0) player.addTag("repaired_amulet");
            else player.removeTag("repaired_amulet");
            if (player.getTags().contains("amulet_repair_cooldown")) {
                repairCooldownTicks = repairCooldownTicks + 1;
                if (repairCooldownTicks >= repairCooldownTicksFrequency()) {
                    repairCooldownTicks = 0;
                    player.removeTag("amulet_repair_cooldown");
                }
            }
            else {
                repairTicks = repairTicks + 1;
                if (repairTicks >= repairTicksFrequency()) {
                    repairTicks = 0;
                    repairAccessory(stack, 1);
                }
            }
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, @Nullable EquipmentSlot slot) {
        amuletInventoryTick(stack, level, entity, slot);
        if (entity instanceof Player player && (!TrinketsApi.getTrinketComponent(player).get().isEquipped(getItem()) ||  player.getTags().contains("repaired_amulet"))) {
            inventoryRepairTicks = inventoryRepairTicks + 1;
            if (inventoryRepairTicks >= repairTicksFrequency()) {
                inventoryRepairTicks = 0;
                stack.setDamageValue(stack.getDamageValue() - 1);
                if (stack.getDamageValue() <= 0) stack.setDamageValue(0);
            }
        }
        else inventoryRepairTicks = 0;
    }

    public void amuletInventoryTick(ItemStack stack, ServerLevel level, Entity entity, @Nullable EquipmentSlot slot) {}

    @Override
    public TrinketEnums.DropRule getDropRule(ItemStack stack, SlotReference slot, LivingEntity entity) {
        return TrinketEnums.DropRule.DESTROY;
    }
}
