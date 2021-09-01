package com.slepmel.capable.common.registry;

import com.slepmel.capable.Capable;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CapableItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Capable.MODID);
	
	public static final RegistryObject<Item> ZEEDRIUM_INGOT = ITEMS.register("zeedrium_ingot", () -> new Item(new Item.Properties().tab(CapableItemGroups.capableItemsGroup)));
	
}
