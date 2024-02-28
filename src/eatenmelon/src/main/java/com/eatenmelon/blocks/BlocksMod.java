package com.eatenmelon.blocks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlocksMod implements ModInitializer  {
    public static final Logger LOGGER = LoggerFactory.getLogger("BlocksMod");
    //adding blocks: public static final Block (blockName) = new Block(FabricBlockSettings.create().strength(4.0f).requiresTool());
    public static final Block CROSS_BLOCK = new CrossBlock(FabricBlockSettings.create().strength(1.0f).requiresTool()) {
    };

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Blocks");

        registerBlocks();
        addToItemGroup();
    }
    private void registerBlocks(){
        //cross_block
        Registry.register(Registries.BLOCK, new Identifier("eatenmelon", "cross_block"), CROSS_BLOCK);
        Registry.register(Registries.ITEM, new Identifier("eatenmelon", "cross_block"), new BlockItem(CROSS_BLOCK, new FabricItemSettings()));
    }

    private void addToItemGroup(){
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> content.add(CROSS_BLOCK));
    }

}