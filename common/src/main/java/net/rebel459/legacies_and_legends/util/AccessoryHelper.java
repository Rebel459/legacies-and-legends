package net.rebel459.legacies_and_legends.util;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.mojang.logging.LogUtils;
import net.rebel459.legacies_and_legends.LaLConstants;
import net.rebel459.legacies_and_legends.LegaciesAndLegends;
import net.rebel459.legacies_and_legends.config.LaLConfig;
import net.rebel459.legacies_and_legends.registry.LaLItems;
import net.rebel459.legacies_and_legends.sound.LaLSounds;
import net.rebel459.legacies_and_legends.tag.LaLItemTags;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantable;
import net.minecraft.world.level.block.Blocks;

public class AccessoryHelper {

    public static class Mutable {

        public int secondTicks = 20;
        public int secondsElapsed = 3;
        public int amuletRepairTicks = 0;
        public int amuletCooldownTicks = 0;
        public boolean hasInfiniteInvisibility = false;
        public boolean doOnEquip = false;
        public Multimap<Holder<Attribute>, AttributeModifier> temporaryModifiers = HashMultimap.create();

        public void onTick(Player player, ItemStack stack) {
            if (this.secondTicks >= 20) {
                this.secondTicks = 0;
                this.onSecond(player, stack);
            } else {
                this.secondTicks += 1;
            }
            if (stack.is(LaLItems.AMULET_OF_ABSORPTION.get())) {
                getAndApplyModifiers(player, stack);
            }
            else if (stack.is(LaLItems.RING_OF_EVASION.get())) {
                getAndApplyModifiers(player, stack);
                if (player.isShiftKeyDown() && !player.hasEffect(MobEffects.INVISIBILITY)) {
                    player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, MobEffectInstance.INFINITE_DURATION));
                    this.hasInfiniteInvisibility = true;
                }
                else if (!player.isShiftKeyDown() && this.hasInfiniteInvisibility) {
                    player.removeEffect(MobEffects.INVISIBILITY);
                    this.hasInfiniteInvisibility = false;
                }
            }
            else if (stack.is(LaLItems.NECKLACE_OF_PURITY.get())) {
                if (!player.getActiveEffects().isEmpty()) {
                    player.removeAllEffects();
                }
            }
        }

        public void onSecond(Player player, ItemStack stack) {
            setupRandomComponents(stack, RandomSource.create());
            if (stack.is(LaLItems.AMULET_OF_OBSIDIAN.get())) {
                secondsElapsed += 1;
                boolean onFire = player.getRemainingFireTicks() > 0;
                if (onFire) damageAccessory(player, stack, 2);
                if (secondsElapsed >= 3) {
                    if (onFire) {
                        if (player.isInLava() || player.getInBlockState().is(Blocks.LAVA)) player.playSound(SoundEvents.LAVA_EXTINGUISH);
                        else player.playSound(SoundEvents.FIRE_EXTINGUISH);
                        secondsElapsed = 0;
                        return;
                    }
                    secondsElapsed = 3;
                }
            }
        }

        public void onTickAmulet(Player player, ItemStack stack) {
            if (this.amuletCooldownTicks <= 0) {
                this.amuletCooldownTicks = 0;
                this.secondsElapsed = 3;
                this.onTickAmuletRepair(player, stack);
            } else {
                this.amuletCooldownTicks -= 1;
            }
        }

        public void onTickAmuletRepair(Player player, ItemStack stack) {
            if (stack.is(LaLItemTags.AMULETS) && !player.getCooldowns().isOnCooldown(stack)) {
                if (this.amuletRepairTicks >= getAmuletRepairFrequency(stack)) {
                    this.amuletRepairTicks = 0;
                    repairAccessory(stack, 1);
                } else {
                    this.amuletRepairTicks += 1;
                }
            }
        }

        public void getAndApplyModifiers(Player player, ItemStack stack) {
            var modifiers = this.getModifiers(player, stack);
            var attributes = player.getAttributes();
            if (!this.temporaryModifiers.isEmpty() && (modifiers.isEmpty() || modifiers != this.temporaryModifiers))
                attributes.removeAttributeModifiers(this.temporaryModifiers);
            if (!modifiers.isEmpty()) {
                this.temporaryModifiers = modifiers;
                attributes.addTransientAttributeModifiers(this.temporaryModifiers);
            }
        }

        public Multimap<Holder<Attribute>, AttributeModifier> getModifiers(Player player, ItemStack stack) {
            Multimap<Holder<Attribute>, AttributeModifier> attributes = HashMultimap.create();
            if (stack.is(LaLItems.AMULET_OF_ABSORPTION.get())) {
                int armor = (int) (player.getMaxHealth() - player.getHealth()) / 2;
                int toughness = (int) (player.getMaxHealth() - player.getHealth()) / 4;
                int knockbackResistance = (int) (player.getMaxHealth() - player.getHealth()) / 6;

                attributes.put(Attributes.ARMOR, new AttributeModifier(LaLConstants.id("armor"), armor, AttributeModifier.Operation.ADD_VALUE));
                attributes.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(LaLConstants.id("armor_toughness"), toughness, AttributeModifier.Operation.ADD_VALUE));
                attributes.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(LaLConstants.id("knockback_resistance"), knockbackResistance * 0.1, AttributeModifier.Operation.ADD_VALUE));
            }
            else if (stack.is(LaLItems.RING_OF_CONSTRUCTION.get())) {
                attributes.put(Attributes.BLOCK_INTERACTION_RANGE, new AttributeModifier(LaLConstants.id("block_interaction_range"), 1, AttributeModifier.Operation.ADD_VALUE));
            }
            else if (stack.is(LaLItems.RING_OF_EVASION.get()) && player.isShiftKeyDown()) {
                attributes.put(Attributes.SNEAKING_SPEED, new AttributeModifier(LaLConstants.id("sneaking_speed"), 0.3, AttributeModifier.Operation.ADD_VALUE));
            }
            else if (stack.is(LaLItems.NECKLACE_OF_LEAPING.get())) {
                attributes.put(Attributes.JUMP_STRENGTH, new AttributeModifier(LaLConstants.id("jump_strength"), 0.15, AttributeModifier.Operation.ADD_VALUE));
                attributes.put(Attributes.SAFE_FALL_DISTANCE, new AttributeModifier(LaLConstants.id("safe_fall_distance"), 1, AttributeModifier.Operation.ADD_VALUE));
            }
            else if (stack.is(LaLItems.NECKLACE_OF_PROTECTION.get())) {
                attributes.put(Attributes.ARMOR, new AttributeModifier(LaLConstants.id("armor"), 2, AttributeModifier.Operation.ADD_VALUE));
            }
            else if (stack.is(LaLItems.RING_OF_STRIKING.get())) {
                attributes.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(LaLConstants.id("attack_damage"), 1, AttributeModifier.Operation.ADD_VALUE));
            }
            return attributes;
        }
    }

    public static ItemStack getAccessory(Player player) {
        ItemStack stack = getActualAccessory(player);
        if (isBroken(stack) || !LaLConfig.get().accessories.slot.enabled) return ItemStack.EMPTY;
        else return stack;
    }

    public static boolean isBroken(ItemStack stack) {
        return stack.has(DataComponents.MAX_DAMAGE) && stack.getDamageValue() >= stack.getMaxDamage() - 1;
    }

    public static ItemStack getActualAccessory(Player player) {
        AccessorySlotInterface accessorySlot = (AccessorySlotInterface) player.inventoryMenu;
        return accessorySlot.getAccessory();
    }

    public static void setAccessory(Player player, ItemStack stack) {
        AccessorySlotInterface accessorySlot = (AccessorySlotInterface) player.inventoryMenu;
        accessorySlot.setAccessory(stack);
    }

    public static void clearAccessory(Player player) {
        setAccessory(player, ItemStack.EMPTY);
    }

    public static boolean hasAccessory(Player player) {
        return getActualAccessory(player) != ItemStack.EMPTY;
    }

    public static int getAmuletRepairFrequency(ItemStack stack) {
        return 20;
    }
    public static int getAmuletRepairCooldown(ItemStack stack) {
        if (stack.is(LaLItems.AMULET_OF_DEFLECTION.get())) return 200;
        return 100;
    }

    public static void damageAccessory(Player player, ItemStack stack) {
        damageAccessory(player, stack, 1);
    }
    public static void damageAccessory(Player player, ItemStack stack, int amount) {
        if (player.isCreative()) return;
        if (stack.is(LaLItemTags.AMULETS) && player instanceof AccessoryInterface accessory) {
            Mutable mutable = accessory.getAccessoryData();
            mutable.amuletCooldownTicks = getAmuletRepairCooldown(stack);
            mutable.amuletRepairTicks = 0;
            accessory.setAccessoryData(mutable);
        }
        stack.setDamageValue(stack.getDamageValue() + amount);
        if (player instanceof ServerPlayer serverPlayer) CriteriaTriggers.ITEM_DURABILITY_CHANGED.trigger(serverPlayer, stack, amount);
        if (isBroken(stack)) {
            if (stack.is(LaLItemTags.AMULETS)) {
                player.getCooldowns().addCooldown(stack, 6000);
            }
            stack.setDamageValue(stack.getMaxDamage() - 1);
            onBreak(player, stack);
            player.playSound(LaLSounds.ACCESSORY_BREAK.get());
        }
    }

    public static void repairAccessory(ItemStack stack) {
        repairAccessory(stack, 1);
    }
    public static void repairAccessory(ItemStack stack, int amount) {
        stack.setDamageValue(stack.getDamageValue() - amount);
        if (stack.getDamageValue() <= 0) stack.setDamageValue(0);
    }

    public static void onBreak(Player player, ItemStack stack) {
        player.playSound(LaLSounds.ACCESSORY_BREAK.get());
    }

    public static void onEquip(Player player, ItemStack stack) {
        if (stack.is(LaLItemTags.RINGS)) player.playSound(LaLSounds.RING_EQUIP.get());
        else if (stack.is(LaLItemTags.NECKLACES)) player.playSound(LaLSounds.NECKLACE_EQUIP.get());
        else if (stack.is(LaLItemTags.AMULETS)) player.playSound(LaLSounds.AMULET_EQUIP.get());
        else if (stack.is(LaLItemTags.TOTEMS)) player.playSound(LaLSounds.TOTEM_EQUIP.get());
        else player.playSound(SoundEvents.ARMOR_EQUIP_GENERIC.value());
    }

    public static void onUnequip(Player player, ItemStack stack) {
        if (stack.is(LaLItems.RING_OF_EVASION.get())) {
            player.removeEffect(MobEffects.INVISIBILITY);
            AccessoryInterface accessory = (AccessoryInterface) player;
            Mutable mutable = accessory.getAccessoryData();
            mutable.hasInfiniteInvisibility = false;
            accessory.setAccessoryData(mutable);
        }
    }

    public static void setupRandomComponents(ItemStack stack, RandomSource random) {
        if (LegaciesAndLegends.isEnchantsAndExpeditionsLoaded) {
            randomEnchantability(stack, random);
        }
    }

    public static void randomEnchantability(ItemStack stack, RandomSource random) {
        if (stack.getComponents().has(DataComponents.ENCHANTABLE) || !stack.getComponents().has(DataComponents.RARITY) || !stack.is(LaLItemTags.VARIABLE_REPAIR_COST)) return;
        if (stack.getItem().getDefaultInstance().get(DataComponents.RARITY).getSerializedName().equals("common")) {
            stack.applyComponents(DataComponentMap.builder()
                    .set(DataComponents.ENCHANTABLE, new Enchantable(random.nextInt(16, 31)))
                    .build()
            );
        }
        else if (stack.getItem().getDefaultInstance().get(DataComponents.RARITY).getSerializedName().equals("uncommon")) {
            stack.applyComponents(DataComponentMap.builder()
                    .set(DataComponents.ENCHANTABLE, new Enchantable(random.nextInt(11, 26)))
                    .build()
            );
        }
        else if (stack.getItem().getDefaultInstance().get(DataComponents.RARITY).getSerializedName().equals("rare")) {
            stack.applyComponents(DataComponentMap.builder()
                    .set(DataComponents.ENCHANTABLE, new Enchantable(random.nextInt(6, 21)))
                    .build()
            );
        }
        else if (stack.getItem().getDefaultInstance().get(DataComponents.RARITY).getSerializedName().equals("epic")) {
            stack.applyComponents(DataComponentMap.builder()
                    .set(DataComponents.ENCHANTABLE, new Enchantable(random.nextInt(1, 16)))
                    .build()
            );
        }
    }
}
