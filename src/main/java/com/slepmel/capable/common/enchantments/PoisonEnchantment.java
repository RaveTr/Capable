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

public class PoisonEnchantment extends Enchantment{

	public PoisonEnchantment(Rarity rarity, EnchantmentType type, EquipmentSlotType...slotType) {
		super(rarity, type, slotType);
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return super.canApplyAtEnchantingTable(stack);
	}
	
	@Override
	public int getMaxLevel() {
		return Common.maxPoisonEnchantmentLevel.get();
	}
	
	@Override
	public int getMaxCost(int p_223551_1_) {
		return Common.maxPoisonEnchantmentCost.get();
	}
	
	@Override
	public int getMinCost(int p_77321_1_) {
		return Common.minPoisonEnchantmentCost.get();
	}
	
	@Override
	public boolean isDiscoverable() {
		return true;
	}
	
	@Override
	public void doPostAttack(LivingEntity target, Entity entity, int damage) {
		if(entity instanceof LivingEntity) {	
		LivingEntity livingentity = (LivingEntity)entity;
        livingentity.addEffect(new EffectInstance(Effects.POISON, (EnchantmentHelper.getEnchantmentLevel(this, target)) * 100, EnchantmentHelper.getEnchantmentLevel(this, target) + 1));
		}
	}
}
