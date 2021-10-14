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
		public static ConfigValue<Boolean> enableZeedriumSwordProperties;
		public static ConfigValue<Double> zeedriumPickaxeChancesOfSpecialProperties;
		public static ConfigValue<Double> zeedriumSwordChancesOfSpecialProperties;
		public static ConfigValue<Float> zeedriumEfficiency;
		public static ConfigValue<Integer> zeedriumDurability;
		public static ConfigValue<Integer> zeedriumHarvestLevel;
		public static ConfigValue<Integer> maxWitheringEnchantmentLevel;
		public static ConfigValue<Integer> maxPoisonEnchantmentLevel;
		public static ConfigValue<Integer> maxPoisonEnchantmentCost;
		public static ConfigValue<Integer> minPoisonEnchantmentCost;
		public static ConfigValue<Integer> minWitheringEnchantmentCost;
		public static ConfigValue<Integer> maxWitheringEnchantmentCost;
		//public static ConfigValue<Boolean> enableCustomEnchantments;
		
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
	         zeedriumShovelDamage = builder.define("Zeedrium Shovel damage", 5);
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
	         enableZeedriumSwordProperties = builder.define("Enable/Disable Zeedrium Sword's special properties", true);
	         enableZeedriumPickaxeProperties = builder.define("Enable/Disable Zeedrium Pickaxe's special properties", true);
	         builder.pop();
	         
	         builder.push("Chances for special tool properties to have effect");
	         builder.comment("0.1 = 10%, this value is the default chance. Second value (0.0) is the minimum chance. Third value (1.0) is the maximum chance");
	         zeedriumPickaxeChancesOfSpecialProperties = builder.defineInRange("Chance for Zeedrium Pickaxe to duplicate ore drops", 0.3, 0, 1);
	         zeedriumSwordChancesOfSpecialProperties = builder.defineInRange("Chance for Zeedrium Sword to to add to the drops of a mob", 0.5, 0, 1);
	         builder.pop();
	         
	         builder.push("Enchantments");
	         //enableCustomEnchantments = builder.define("Enable/Disable custom enchantments added by Capable", true);
	         builder.push("Wither");
	         maxWitheringEnchantmentLevel = builder.define("Maximum enchantment level for the Wither enchantment", 3);
	         minWitheringEnchantmentCost = builder.define("Minimum cost for the Withering enchantment in levels", 1);
	         maxWitheringEnchantmentCost = builder.define("Maximum cost for the Withering enchantment in levels", 40);
	         builder.pop();
	         builder.push("Poison");
	         maxPoisonEnchantmentLevel = builder.define("Maximum enchantment level for the Poison enchantment", 3);
	         minPoisonEnchantmentCost = builder.define("Minimum cost for the Poison enchantment in levels", 1);
	         maxPoisonEnchantmentCost = builder.define("Maximum cost for the Poison enchantment in levels", 30);
	         builder.pop();
	         builder.pop();
		 }
	}

}
