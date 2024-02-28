package com.eatenmelon.items;

import com.mojang.datafixers.util.Pair;
import net.minecraft.entity.effect.InstantStatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;

import java.util.ArrayList;

public class Cross extends Item {
    public static final FoodComponent foodComponent = new FoodComponent.Builder()
            .hunger(6)
            .saturationModifier(1)
            .meat()
            .alwaysEdible()
            .snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 6*20, 1), 1.0f)
            .build();

    public Cross(Settings settings) {
        super(settings.food(foodComponent));
    }

}
