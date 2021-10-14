package com.slepmel.capable.common.enchantments;

import com.slepmel.capable.config.CapableConfig.Common;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class WitheringEnchantment extends Enchantment{

	public WitheringEnchantment(Rarity rarity, EnchantmentType type, EquipmentSlotType...slotType) {
		super(rarity, type, slotType);
	}
	
	@Override
	public int getMaxLevel() {
		return Common.maxWitheringEnchantmentLevel.get();
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return true;
	}
	
	@Override
	public int getMaxCost(int p_223551_1_) {
		return Common.maxWitheringEnchantmentCost.get();
	}
	
	@Override
	public int getMinCost(int p_77321_1_) {
		return Common.minWitheringEnchantmentCost.get();
	}
	
	@Override
	public boolean isAllowedOnBooks() {
		return true;
	}
	
	@Override
	public boolean isDiscoverable() {
		return true;
	}
	
	@Override
	public void doPostAttack(LivingEntity target, Entity entity, int damage) {
		if(entity instanceof LivingEntity) {	
		LivingEntity livingentity = (LivingEntity)entity;
        livingentity.addEffect(new EffectInstance(Effects.WITHER, (EnchantmentHelper.getEnchantmentLevel(this, target)) * 100, EnchantmentHelper.getEnchantmentLevel(this, target) + 1));
		}
	}
}
