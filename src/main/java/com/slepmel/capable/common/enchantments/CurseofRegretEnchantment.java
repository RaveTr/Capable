package com.slepmel.capable.common.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.DamageSource;

public class CurseofRegretEnchantment extends Enchantment{

	public CurseofRegretEnchantment(Rarity rarity, EnchantmentType type, EquipmentSlotType...slotType) {
		super(rarity, type, slotType);
	}
	
	@Override
	public boolean isCurse() {
		return true;
	}
	
	@Override
	public boolean isDiscoverable() {
		return true;
	}
	
	@Override
	public void doPostAttack(LivingEntity player, Entity entity, int damage) {
		if(entity instanceof LivingEntity) {
			LivingEntity livingentity = (LivingEntity)entity;
			if(livingentity.getHealth() <= 0) {
				damage = 10;
				player.hurt(DamageSource.GENERIC, 5);
			}
		}
	}

}
