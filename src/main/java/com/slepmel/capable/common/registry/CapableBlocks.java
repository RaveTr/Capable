package com.slepmel.capable.common.registry;

import java.util.function.Supplier;


import com.slepmel.capable.Capable;
import com.slepmel.capable.common.blocks.CapableOreBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;import net.minecraft.block.SoundType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CapableBlocks {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Capable.MODID);
	public static final DeferredRegister<Item> ITEM_BLOCKS = DeferredRegister.create(ForgeRegistries.ITEMS, Capable.MODID);
	
	//Ores
	public static final RegistryObject<CapableOreBlock> ZEEDRIUM_ORE = registerBlock("zeedrium_ore", () -> new CapableOreBlock(Block.Properties.copy(Blocks.IRON_ORE).harvestLevel(2).sound(SoundType.STONE).strength(10F).requiresCorrectToolForDrops().harvestTool(ToolType.PICKAXE)).withExp().withExpDrop(5, 10), CapableItemGroups.capableBlocksGroup);
	
    public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> supplier, ItemGroup itemGroup) {
        return registerBlock(name, supplier, itemGroup, true);
    }

    public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> supplier, ItemGroup itemGroup, boolean generateItem) {
        return registerBlock(name, supplier, itemGroup, 64, generateItem);
    }

    public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> supplier, ItemGroup itemGroup, int stackSize) {
        return registerBlock(name, supplier, itemGroup, stackSize, true);
    }

    public static <B extends Block> RegistryObject<B> registerBlock(String name, Supplier<? extends B> supplier, ItemGroup itemGroup, int stackSize, boolean generateItem) {
        RegistryObject<B> block = CapableBlocks.BLOCKS.register(name, supplier);
        if (generateItem)
            ITEM_BLOCKS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(itemGroup).stacksTo(stackSize)));
        return block;
    }

}
