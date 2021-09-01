package com.slepmel.capable.common.registry;

import com.slepmel.capable.Capable;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ITag.INamedTag;
import net.minecraft.tags.ItemTags;

public class CapableTags {
	
	public static final ITag<Item> CUSTOM_TOOLTIPS = ItemTags.bind(Capable.MODID + ":custom_tooltips");
//	public static final INamedTag<Item> ZEEDRIUM = ItemTags.bind(Capable.MODID + ":zeedrium");

//	public static final INamedTag<Block> ZEEDRIUM_BLOCK = BlockTags.bind(Capable.MODID + ":zeedrium_block");
}
