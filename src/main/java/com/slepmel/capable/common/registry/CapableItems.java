package com.slepmel.capable.common.registry;

import com.slepmel.capable.Capable;
import com.slepmel.capable.common.enums.CapableTiers;
import com.slepmel.capable.config.CapableConfig;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CapableItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Capable.MODID);
	
	//Ingots
	public static final RegistryObject<Item> ZEEDRIUM_INGOT = ITEMS.register("zeedrium_ingot", () -> new Item(new Item.Properties().tab(CapableItemGroups.capableItemsGroup)));
	
	//Zeedrium Gear
	public static final RegistryObject<SwordItem> ZEEDRIUM_SWORD = ITEMS.register("zeedrium_sword", () -> new SwordItem(CapableTiers.TOOL_ZEEDRIUM, CapableConfig.COMMON.zeedriumSwordDamage.get() - 5, -2.4F, new Item.Properties().tab(CapableItemGroups.capableWeaponsGroup)));
	
}
