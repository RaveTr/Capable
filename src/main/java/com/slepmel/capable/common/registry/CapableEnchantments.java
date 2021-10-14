package com.slepmel.capable.common.registry;

import com.slepmel.capable.Capable;
import com.slepmel.capable.common.enchantments.CurseofRegretEnchantment;
import com.slepmel.capable.common.enchantments.PoisonEnchantment;
import com.slepmel.capable.common.enchantments.WitheringEnchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CapableEnchantments {

	public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Capable.MODID);

	public static final RegistryObject<WitheringEnchantment> WITHERING = ENCHANTMENTS.register("withering", () -> new WitheringEnchantment(Rarity.UNCOMMON, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND));
	public static final RegistryObject<PoisonEnchantment> POISON = ENCHANTMENTS.register("poison", () -> new PoisonEnchantment(Rarity.UNCOMMON, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND));
	public static final RegistryObject<CurseofRegretEnchantment> CURSE_OF_REGRET = ENCHANTMENTS.register("curse_of_regret", () -> new CurseofRegretEnchantment(Rarity.RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND));
	
}
