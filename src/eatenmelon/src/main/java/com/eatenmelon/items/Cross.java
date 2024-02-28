package com.eatenmelon.items;

import com.mojang.datafixers.util.Pair;
import net.minecraft.entity.effect.InstantStatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

import java.util.ArrayList;

public class Cross extends Item {

    public Cross(Settings settings) {
        ArrayList<Pair<StatusEffectInstance, Float>> statusEffects = new ArrayList<Pair<StatusEffectInstance, Float>>();
        statusEffects.add(new Pair<StatusEffectInstance,Float>(new StatusEffectInstance(new InstantStatusEffect(StatusEffectCategory.HARMFUL,1),100)));
        settings.food(new FoodComponent(6, 1,1,1,1,statusEffects))
        .super(settings);
    }

}
