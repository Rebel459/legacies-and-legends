package net.legacy.legacies_and_legends.mixin.integration.friendsandfoes;

import com.faboslav.friendsandfoes.common.init.FriendsAndFoesItems;
import com.faboslav.friendsandfoes.common.init.FriendsAndFoesParticleTypes;
import com.faboslav.friendsandfoes.common.tag.FriendsAndFoesTags;
import net.legacy.legacies_and_legends.integration.friendsandfoes.FriendsAndFoesTotemUtil;
import net.legacy.legacies_and_legends.util.AccessoryHelper;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public abstract class FriendsAndFoesPlayerMixin {

    @Inject(method = "actuallyHurt", at = @At(value = "TAIL"))
    private void activateTotem(ServerLevel level, DamageSource damageSource, float amount, CallbackInfo info) {
        Player player = Player.class.cast(this);
        if (AccessoryHelper.hasAccessory(player)) {
            if (AccessoryHelper.getAccessory(player).is(FriendsAndFoesItems.TOTEM_OF_FREEZING.get()) && player.getHealth() <= player.getMaxHealth() / 2) {
                com.faboslav.friendsandfoes.common.util.TotemUtil.freezeEntities(player, level);
                FriendsAndFoesTotemUtil.playActivateAnimation(player, FriendsAndFoesParticleTypes.TOTEM_OF_FREEZING.get());
                FriendsAndFoesTotemUtil.playActivateAnimationOnly(FriendsAndFoesItems.TOTEM_OF_FREEZING.get().getDefaultInstance());
                player.awardStat(Stats.ITEM_USED.get(FriendsAndFoesItems.TOTEM_OF_FREEZING.get()));
                CriteriaTriggers.USED_TOTEM.trigger((ServerPlayer) player, FriendsAndFoesItems.TOTEM_OF_FREEZING.get().getDefaultInstance());
                player.addTag("used_totem");
                return;
            }
            if (AccessoryHelper.getAccessory(player).is(FriendsAndFoesItems.TOTEM_OF_ILLUSION.get()) && player.getHealth() <= player.getMaxHealth() / 2) {
                com.faboslav.friendsandfoes.common.util.TotemUtil.createIllusions(player, level);
                FriendsAndFoesTotemUtil.playActivateAnimation(player, FriendsAndFoesParticleTypes.TOTEM_OF_ILLUSION.get());
                FriendsAndFoesTotemUtil.playActivateAnimationOnly(FriendsAndFoesItems.TOTEM_OF_ILLUSION.get().getDefaultInstance());
                player.awardStat(Stats.ITEM_USED.get(FriendsAndFoesItems.TOTEM_OF_ILLUSION.get()));
                CriteriaTriggers.USED_TOTEM.trigger((ServerPlayer) player, FriendsAndFoesItems.TOTEM_OF_ILLUSION.get().getDefaultInstance());
                player.addTag("used_totem");
                return;
            }
        }
        if ((player.getMainHandItem().is(FriendsAndFoesTags.TOTEMS) || player.getOffhandItem().is(FriendsAndFoesTags.TOTEMS)) && player.getHealth() <= player.getMaxHealth() / 2) {
            if (player.getMainHandItem().is(FriendsAndFoesItems.TOTEM_OF_FREEZING.get())) {
                com.faboslav.friendsandfoes.common.util.TotemUtil.freezeEntities(player, level);
                FriendsAndFoesTotemUtil.playActivateAnimation(player, FriendsAndFoesParticleTypes.TOTEM_OF_FREEZING.get());
                FriendsAndFoesTotemUtil.playActivateAnimationOnly(FriendsAndFoesItems.TOTEM_OF_FREEZING.get().getDefaultInstance());
                player.awardStat(Stats.ITEM_USED.get(FriendsAndFoesItems.TOTEM_OF_FREEZING.get()));
                CriteriaTriggers.USED_TOTEM.trigger((ServerPlayer) player, FriendsAndFoesItems.TOTEM_OF_FREEZING.get().getDefaultInstance());
                player.getItemBySlot(EquipmentSlot.MAINHAND).copyAndClear();
            }
            else if (player.getMainHandItem().is(FriendsAndFoesItems.TOTEM_OF_ILLUSION.get())) {
                com.faboslav.friendsandfoes.common.util.TotemUtil.createIllusions(player, level);
                FriendsAndFoesTotemUtil.playActivateAnimation(player, FriendsAndFoesParticleTypes.TOTEM_OF_ILLUSION.get());
                FriendsAndFoesTotemUtil.playActivateAnimationOnly(FriendsAndFoesItems.TOTEM_OF_ILLUSION.get().getDefaultInstance());
                player.awardStat(Stats.ITEM_USED.get(FriendsAndFoesItems.TOTEM_OF_ILLUSION.get()));
                CriteriaTriggers.USED_TOTEM.trigger((ServerPlayer) player, FriendsAndFoesItems.TOTEM_OF_ILLUSION.get().getDefaultInstance());
                player.getItemBySlot(EquipmentSlot.MAINHAND).copyAndClear();
            }
            else if (player.getOffhandItem().is(FriendsAndFoesItems.TOTEM_OF_FREEZING.get())) {
                com.faboslav.friendsandfoes.common.util.TotemUtil.freezeEntities(player, level);
                FriendsAndFoesTotemUtil.playActivateAnimation(player, FriendsAndFoesParticleTypes.TOTEM_OF_FREEZING.get());
                FriendsAndFoesTotemUtil.playActivateAnimationOnly(FriendsAndFoesItems.TOTEM_OF_FREEZING.get().getDefaultInstance());
                player.awardStat(Stats.ITEM_USED.get(FriendsAndFoesItems.TOTEM_OF_FREEZING.get()));
                CriteriaTriggers.USED_TOTEM.trigger((ServerPlayer) player, FriendsAndFoesItems.TOTEM_OF_FREEZING.get().getDefaultInstance());
                player.getItemBySlot(EquipmentSlot.OFFHAND).copyAndClear();
            }
            else if (player.getOffhandItem().is(FriendsAndFoesItems.TOTEM_OF_ILLUSION.get())) {
                com.faboslav.friendsandfoes.common.util.TotemUtil.createIllusions(player, level);
                FriendsAndFoesTotemUtil.playActivateAnimation(player, FriendsAndFoesParticleTypes.TOTEM_OF_ILLUSION.get());
                FriendsAndFoesTotemUtil.playActivateAnimationOnly(FriendsAndFoesItems.TOTEM_OF_ILLUSION.get().getDefaultInstance());
                player.awardStat(Stats.ITEM_USED.get(FriendsAndFoesItems.TOTEM_OF_ILLUSION.get()));
                CriteriaTriggers.USED_TOTEM.trigger((ServerPlayer) player, FriendsAndFoesItems.TOTEM_OF_ILLUSION.get().getDefaultInstance());
                player.getItemBySlot(EquipmentSlot.OFFHAND).copyAndClear();
            }
        }
    }
}
