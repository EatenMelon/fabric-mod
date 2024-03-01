package com.eatenmelon.items;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class MagicSword extends SwordItem {
    public MagicSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
}
