package net.legacy.legacies_and_legends.mixin.item;

import net.legacy.legacies_and_legends.mixin.LaLMixinPlugin;
import net.legacy.legacies_and_legends.registry.LaLItems;
import net.legacy.legacies_and_legends.util.AccessoryHelper;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ProjectileWeaponItem.class)
public abstract class ProjectileWeaponItemMixin {

    @Inject(at = @At("HEAD"), method = "shoot", cancellable = true)
    private void ringOfArchery(ServerLevel level, LivingEntity shooter, InteractionHand hand, ItemStack weapon, List<ItemStack> projectileItems, float velocity, float inaccuracy, boolean isCrit, LivingEntity target, CallbackInfo ci) {
        if (LaLMixinPlugin.hasCombatReborn) return;
        if (shooter instanceof Player player && AccessoryHelper.getAccessory(player).is(LaLItems.RING_OF_ARCHERY)) {
            ProjectileWeaponItem item = BowItem.class.cast(this);

            float f = EnchantmentHelper.processProjectileSpread(level, weapon, shooter, 0.0F);
            float g = projectileItems.size() == 1 ? 0.0F : 2.0F * f / (float)(projectileItems.size() - 1);
            float h = (float)((projectileItems.size() - 1) % 2) * g / 2.0F;
            float i = 1.0F;

            for(int j = 0; j < projectileItems.size(); ++j) {
                ItemStack itemStack = projectileItems.get(j);
                if (!itemStack.isEmpty()) {
                    float k = h + i * (float)((j + 1) / 2) * g;
                    i = -i;
                    int l = j;
                    Projectile.spawnProjectile(item.createProjectile(level, shooter, weapon, itemStack, isCrit), level, itemStack, (projectile) -> {
                        if (item instanceof BowItem bowItem) bowItem.shootProjectile(shooter, projectile, l, velocity, inaccuracy / 4, k, target);
                        else if (item instanceof CrossbowItem crossbowItem) crossbowItem.shootProjectile(shooter, projectile, l, velocity, inaccuracy / 4, k, target);
                    });
                    weapon.hurtAndBreak(item.getDurabilityUse(itemStack), shooter, hand);
                    if (weapon.isEmpty()) {
                        break;
                    }
                    AccessoryHelper.damageAccessory(player, AccessoryHelper.getAccessory(player));
                    ci.cancel();
                }
            }
        }
    }
}