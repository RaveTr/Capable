package com.slepmel.capable.common.registry;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CapableItemGroups {
	
	public static ItemGroup capableItemsGroup = new ItemGroup("capable_items_group") {
		
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CapableItems.ZEEDRIUM_INGOT.get());
        }
		
	};
	
	public static ItemGroup capableWeaponsGroup = new ItemGroup("capable_weapons_group") {
		
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CapableItems.ZEEDRIUM_SWORD.get());
        }
		
	};

}
