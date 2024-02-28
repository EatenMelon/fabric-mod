package com.eatenmelon.items;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemsMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("ItemsMod");

    public static final Item CROSS = new Cross(new FabricItemSettings());
    public static final Item RING = new Ring(new FabricItemSettings());
    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Items");

        RegisterItems();
        addToItemGroup();
    }

    private void RegisterItems(){
        Registry.register(Registries.ITEM, new Identifier("eatenmelon", "cross"), CROSS);
        Registry.register(Registries.ITEM, new Identifier("eatenmelon", "ring"), RING);
    }

    private void addToItemGroup(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> content.add(CROSS));
    }
}
