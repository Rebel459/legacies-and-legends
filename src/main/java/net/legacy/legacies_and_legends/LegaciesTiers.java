package net.legacy.legacies_and_legends;

import com.google.common.base.Suppliers;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public enum LegaciesTiers implements Tier {
    HOOK(BlockTags.INCORRECT_FOR_IRON_TOOL, 250, 6.0F, 5.0F, 10, () -> Ingredient.of(LegaciesItems.METAL_CHUNK)),
    ANCIENT(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1561, 8.0F, 3.0F, 25, () -> Ingredient.of(Items.BRICK)),;

    private final TagKey<Block> incorrectBlocksForDrops;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final Supplier<Ingredient> repairIngredient;

    private LegaciesTiers(
            final TagKey<Block> incorrectBlockForDrops,
            final int uses,
            final float speed,
            final float damage,
            final int enchantmentValue,
            final Supplier<Ingredient> repairIngredient
    ) {
        this.incorrectBlocksForDrops = incorrectBlockForDrops;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.damage;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return this.incorrectBlocksForDrops;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}
