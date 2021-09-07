package com.slepmel.capable.config;

import org.apache.commons.lang3.tuple.Pair;


import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class CapableConfig {
	public static final ForgeConfigSpec COMMON_CONFIG_SPEC;
	public static final Common COMMON;
	
	static {
        final Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_CONFIG_SPEC = commonSpecPair.getRight();
        COMMON = commonSpecPair.getLeft();
	}
	
	public static class Common {
		public static ConfigValue<Integer> zeedriumSwordDamage;
		public static ConfigValue<Integer> zeedriumPickaxeDamage;
		public static ConfigValue<Integer> zeedriumAxeDamage;
		public static ConfigValue<Integer> zeedriumHoeDamage;
		public static ConfigValue<Integer> zeedriumShovelDamage;
		public static ConfigValue<Boolean> enableOreGen;
		public static ConfigValue<Boolean> enableZeedriumOreGen;
		public static ConfigValue<Boolean> enableToolTips;
		public static ConfigValue<Boolean> enableZeedriumPickaxeProperties;
		public static ConfigValue<Double> zeedriumChancesOfSpecialProperties;
		public static ConfigValue<Float> zeedriumEfficiency;
		public static ConfigValue<Integer> zeedriumDurability;
		public static ConfigValue<Integer> zeedriumHarvestLevel;
		
		 Common(ForgeConfigSpec.Builder builder) {
			 builder.push("ToolTips");
			 enableToolTips = builder.define("Enable/Disable custom tooltips for items and blocks", true);
			 builder.pop();
			 
			 builder.push("World Gen");
	         enableOreGen = builder.define("Enable/Disable ore generation", true);
	         builder.pop();
	         
	         builder.push("Ore Spawning");
	         enableZeedriumOreGen = builder.define("Enable/Disable Zeedrium ore generation", true);
	         builder.pop();
	         
	         builder.push("Attack Damage");
	         builder.push("Zeedrium");
	         zeedriumSwordDamage = builder.define("Zeedrium Sword damage", 20);
	         zeedriumPickaxeDamage = builder.define("Zeedrium Pickaxe damage", 11);
	         zeedriumAxeDamage = builder.define("Zeedrium Axe damage", 18);
	         zeedriumHoeDamage = builder.define("Zeedrium Hoe damage", 1);
	         zeedriumShovelDamage = builder.define("Zeedrium Shovel damage", 3);
	         builder.pop();
	         builder.pop();
	         
	         builder.push("Efficiency");
	         builder.push("Zeedrium");
	         zeedriumEfficiency = builder.define("Zeedrium Tools' average efficiency", 10F);
	         builder.pop();
	         builder.pop();
	         
	         builder.push("Durability");
	         builder.push("Zeedrium");
	         zeedriumDurability = builder.define("Durability for Zeedrium Tools", 2500);
	         builder.pop();
	         builder.pop();
	         
	         builder.push("Harvest Level");
	         builder.push("Zeedrium");
	         zeedriumHarvestLevel = builder.define("Zeedrium Tools' harvest levels", 4);
	         builder.pop();
	         builder.pop();
	         
	         builder.push("Special Tool Properties");
	         enableZeedriumPickaxeProperties = builder.define("Enable/Disable Zeedrium Pickaxe's special properties", true);
	         builder.pop();
	         
	         builder.push("Chances for special tool properties to have effect");
	         builder.comment("0.1 = 10%, this value is the default chance. Second value (0.0) is the minimum chance. Third value (1.0) is the maximum chance");
	         zeedriumChancesOfSpecialProperties = builder.defineInRange("Chance for Zeedrium Pickaxe to duplicate ore drops", 0.3, 0, 1);
	         builder.pop();
		 }
	}

}
