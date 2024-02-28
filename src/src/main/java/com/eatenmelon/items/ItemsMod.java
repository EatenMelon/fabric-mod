package com.eatenmelon.items;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ItemsMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("ItemsMod");

    public static final Item CROSS = new Item(new FabricItemSettings());
    public static final Item RING = new Item(new FabricItemSettings());
    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Items");

        RegisterItems();
    }

    private void RegisterItems(){
        Registry.register(Registries.ITEM, new Identifier("eatenmelon", "cross"), CROSS);
        Registry.register(Registries.ITEM, new Identifier("eatenmelon", "ring"), RING);
    }
}
