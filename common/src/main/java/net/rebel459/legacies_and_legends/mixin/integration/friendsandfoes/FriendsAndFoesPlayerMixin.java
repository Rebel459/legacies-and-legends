package net.rebel459.legacies_and_legends.mixin.integration.friendsandfoes;

import com.faboslav.friendsandfoes.common.init.FriendsAndFoesItems;
import com.faboslav.friendsandfoes.common.init.FriendsAndFoesParticleTypes;
import com.faboslav.friendsandfoes.common.tag.FriendsAndFoesTags;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import net.rebel459.legacies_and_legends.friendsandfoes.FriendsAndFoesTotemUtil;
import net.rebel459.legacies_and_legends.util.AccessoryHelper;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public abstract class FriendsAndFoesPlayerMixin {

    @Inject(method = "actuallyHurt", at = @At(value = "TAIL"))
    private void activateTotem(ServerLevel level, DamageSource damageSource, float amount, CallbackInfo info) {
        Player player = Player.class.cast(this);
        if (AccessoryHelper.hasAccessory(player)) {
            ItemStack stack = AccessoryHelper.getAccessory(player);
            if (stack.is(FriendsAndFoesItems.TOTEM_OF_FREEZING.get()) && player.getHealth() <= player.getMaxHealth() / 2) {
                com.faboslav.friendsandfoes.common.util.TotemUtil.freezeEntities(player, level);
                handleTotem(player, stack, FriendsAndFoesParticleTypes.TOTEM_OF_FREEZING);
                return;
            }
            if (stack.is(FriendsAndFoesItems.TOTEM_OF_ILLUSION.get()) && player.getHealth() <= player.getMaxHealth() / 2) {
                com.faboslav.friendsandfoes.common.util.TotemUtil.createIllusions(player, level);
                handleTotem(player, stack, FriendsAndFoesParticleTypes.TOTEM_OF_ILLUSION);
                return;
            }
        }
        if ((player.getMainHandItem().is(FriendsAndFoesTags.TOTEMS) || player.getOffhandItem().is(FriendsAndFoesTags.TOTEMS)) && player.getHealth() <= player.getMaxHealth() / 2) {
            if (player.getMainHandItem().is(FriendsAndFoesItems.TOTEM_OF_FREEZING.get())) {
                ItemStack stack = player.getItemBySlot(EquipmentSlot.MAINHAND);
                com.faboslav.friendsandfoes.common.util.TotemUtil.freezeEntities(player, level);
                handleTotem(player, stack, FriendsAndFoesParticleTypes.TOTEM_OF_FREEZING);
            }
            else if (player.getMainHandItem().is(FriendsAndFoesItems.TOTEM_OF_ILLUSION.get())) {
                ItemStack stack = player.getItemBySlot(EquipmentSlot.MAINHAND);
                com.faboslav.friendsandfoes.common.util.TotemUtil.createIllusions(player, level);
                handleTotem(player, stack, FriendsAndFoesParticleTypes.TOTEM_OF_ILLUSION);
            }
            else if (player.getOffhandItem().is(FriendsAndFoesItems.TOTEM_OF_FREEZING.get())) {
                ItemStack stack = player.getItemBySlot(EquipmentSlot.OFFHAND);
                com.faboslav.friendsandfoes.common.util.TotemUtil.freezeEntities(player, level);
                handleTotem(player, stack, FriendsAndFoesParticleTypes.TOTEM_OF_FREEZING);
            }
            else if (player.getOffhandItem().is(FriendsAndFoesItems.TOTEM_OF_ILLUSION.get())) {
                ItemStack stack = player.getItemBySlot(EquipmentSlot.OFFHAND);
                com.faboslav.friendsandfoes.common.util.TotemUtil.createIllusions(player, level);
                handleTotem(player, stack, FriendsAndFoesParticleTypes.TOTEM_OF_ILLUSION);
            }
        }
    }

    @Unique
    private static void handleTotem(Player player, ItemStack stack, RegistryEntry<SimpleParticleType> particle) {
        FriendsAndFoesTotemUtil.playActivateAnimation(player, particle.get());
        FriendsAndFoesTotemUtil.playActivateAnimationOnly(stack);
        player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
        if (player instanceof ServerPlayer serverPlayer) CriteriaTriggers.USED_TOTEM.trigger(serverPlayer, stack);
        AccessoryHelper.clearAccessory(player);
    }
}
