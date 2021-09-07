package com.slepmel.capable.common.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class ZeedriumSwordItem extends SwordItem{

	public ZeedriumSwordItem(IItemTier tier, int p_i48460_2_, float p_i48460_3_, Properties properties) {
		super(tier, p_i48460_2_, p_i48460_3_, properties);
	}
	
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity player) {
		if(target != null) {
            target.addEffect(new EffectInstance(Effects.WEAKNESS, (10 + target.getRandom().nextInt(10)) * 20, 1));
            target.addEffect(new EffectInstance(Effects.WITHER, (10 + target.getRandom().nextInt(10)) * 20, 1));
            target.isOnFire();
		}
		return super.hurtEnemy(stack, target, player);
	}
	
	

}
