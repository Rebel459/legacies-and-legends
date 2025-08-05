package net.legacy.legacies_and_legends.item;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.TrinketsApi;
import net.legacy.legacies_and_legends.sound.LaLSounds;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class AccessoryItem extends TrinketItem implements Trinket {

    public Item getItem() {
        return Items.AIR;
    }

    public int secondTicks = 0;

    public AccessoryItem(Properties settings) {
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

        if (entity instanceof Player player && player.getTags().contains("damaged_accessory")) {
            damageAccessory(stack, slot, player, 1);
            player.removeTag("damaged_accessory");
        }
    }

    public void everyTick(ItemStack stack, SlotReference slot, LivingEntity entity) {}

    public void everySecond(ItemStack stack, SlotReference slot, LivingEntity entity) {}

    public void damageAccessory(ItemStack stack, SlotReference slot, Player player, int amount) {
        if (player.isCreative()) return;
        stack.setDamageValue(stack.getDamageValue() + amount);
        if (stack.getDamageValue() >= stack.getMaxDamage()) {
            resetData(player);
            CriteriaTriggers.ITEM_DURABILITY_CHANGED.trigger((ServerPlayer) player, stack, amount);
            slot.inventory().removeItem(slot.index(), amount);
            player.playSound(LaLSounds.ACCESSORY_BREAK);
        }
    }

    public void repairAccessory(ItemStack stack, int amount) {
        resetOnRepair();
        stack.setDamageValue(stack.getDamageValue() - amount);
        if (stack.getDamageValue() <= 0) stack.setDamageValue(0);
    }

    @Override
    public void onBreak(ItemStack stack, SlotReference slot, LivingEntity entity) {
        entity.playSound(LaLSounds.ACCESSORY_BREAK);
        resetData(entity);
    }

    @Override
    public void onUnequip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        resetData(entity);
    }

    public void resetData(LivingEntity entity) {}

    public void resetOnRepair() {}

    public static ItemStack getAccessory(ItemStack stack, SlotReference slot, Player player) {
        return TrinketsApi.getTrinketComponent(player).get().getEquipped(stack.getItem()).get(slot.index()).getB();
    }
}
