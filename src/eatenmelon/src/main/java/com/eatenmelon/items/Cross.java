package com.eatenmelon.items;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public class Cross extends Item {
    public static final FoodComponent foodComponent = new FoodComponent.Builder()
            .hunger(6)
            .saturationModifier(1)
            .meat()
            .alwaysEdible()
            .snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 10*60*20, 48), 1.0f)
            .build();

    public Cross(Settings settings) {
        super(settings.food(foodComponent));
    }

}
