package com.eatenmelon.materials;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class MagicMaterial implements ToolMaterial {
    public static final MagicMaterial INSTANCE = new MagicMaterial();
    @Override
    public int getDurability() {
        return 1000000;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 2;
    }

    @Override
    public float getAttackDamage() {
        return 20;
    }

    @Override
    public int getMiningLevel() {
        return 1;
    }

    @Override
    public int getEnchantability() {
        return 1000;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
