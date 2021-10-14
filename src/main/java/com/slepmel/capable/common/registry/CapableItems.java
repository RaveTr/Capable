package com.slepmel.capable.common.registry;


import com.slepmel.capable.Capable;
import com.slepmel.capable.common.enums.CapableTiers;
import com.slepmel.capable.common.items.CrashCoursePickaxeItem;
import com.slepmel.capable.common.items.ZeedriumPickaxeItem;
import com.slepmel.capable.common.items.ZeedriumSwordItem;
import com.slepmel.capable.config.CapableConfig.Common;

import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CapableItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Capable.MODID);
	
	//Ingots
	public static final RegistryObject<Item> ZEEDRIUM_INGOT = ITEMS.register("zeedrium_ingot", () -> new Item(new Item.Properties().rarity(CapableRarities.ZEED).tab(CapableItemGroups.capableItemsGroup)));
	public static final RegistryObject<Item> KEMIUM_INGOT = ITEMS.register("kemium_ingot", () -> new Item(new Item.Properties().rarity(CapableRarities.CHADISTIC).tab(CapableItemGroups.capableItemsGroup)));
	
	//Nuggets
	public static final RegistryObject<Item> ZEEDRIUM_NUGGET = ITEMS.register("zeedrium_nugget", () -> new Item(new Item.Properties().rarity(CapableRarities.ZEED).tab(CapableItemGroups.capableItemsGroup)));
	
	//Literal Minecraft shitposts
	public static final RegistryObject<CrashCoursePickaxeItem> CRASH_COURSE_PICKAXE = ITEMS.register("crash_course_pickaxe", () -> new CrashCoursePickaxeItem(CapableTiers.TOOL_CRASH, 1, 1, new Item.Properties().rarity(CapableRarities.CRASH).tab(CapableItemGroups.capableWeaponsGroup)));
	
	//Zeedrium Gear
	public static final RegistryObject<ZeedriumSwordItem> ZEEDRIUM_SWORD = ITEMS.register("zeedrium_sword", () -> new ZeedriumSwordItem(CapableTiers.TOOL_ZEEDRIUM, Common.zeedriumSwordDamage.get() - 11, -2.4F, new Item.Properties().rarity(CapableRarities.ZEED).tab(CapableItemGroups.capableWeaponsGroup)));
	public static final RegistryObject<ZeedriumPickaxeItem> ZEEDRIUM_PICKAXE = ITEMS.register("zeedrium_pickaxe", () -> new ZeedriumPickaxeItem(CapableTiers.TOOL_ZEEDRIUM, Common.zeedriumPickaxeDamage.get() - 11, -2.8F, new Item.Properties().rarity(CapableRarities.ZEED).tab(CapableItemGroups.capableWeaponsGroup)));
	public static final RegistryObject<AxeItem> ZEEDRIUM_AXE = ITEMS.register("zeedrium_axe", () -> new AxeItem(CapableTiers.TOOL_ZEEDRIUM, Common.zeedriumAxeDamage.get() - 11, -2.8F, new Item.Properties().rarity(CapableRarities.ZEED).tab(CapableItemGroups.capableWeaponsGroup)));
	public static final RegistryObject<ShovelItem> ZEEDRIUM_SHOVEL = ITEMS.register("zeedrium_shovel", () -> new ShovelItem(CapableTiers.TOOL_ZEEDRIUM, Common.zeedriumShovelDamage.get() - 11, -3.0F, new Item.Properties().rarity(CapableRarities.ZEED).tab(CapableItemGroups.capableWeaponsGroup)));
    public static final RegistryObject<HoeItem> ZEEDRIUM_HOE = ITEMS.register("zeedrium_hoe", () -> new HoeItem(CapableTiers.TOOL_ZEEDRIUM, Common.zeedriumHoeDamage.get() - 11, -0.0F, new Item.Properties().rarity(CapableRarities.ZEED).tab(CapableItemGroups.capableWeaponsGroup)));
	
}
