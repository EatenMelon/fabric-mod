package com.eatenmelon;

import com.eatenmelon.blocks.BlocksMod;
import com.eatenmelon.items.ItemsMod;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

	public class ItemGroupMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("ItemGroup");
	private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(ItemsMod.CROSS))
			.displayName(Text.literal("eatenmelon"))
			.entries((context, entries) -> {
				entries.add(ItemsMod.CROSS);
				entries.add(ItemsMod.RING);
				entries.add(BlocksMod.CROSS_BLOCK);
				entries.add(BlocksMod.STONE_STATUE);
			})
			.build();

	@Override
	public void onInitialize() {
		Registry.register(Registries.ITEM_GROUP, new Identifier("eatenmlon", "item_group"), ITEM_GROUP);
	}

}