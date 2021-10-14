package com.slepmel.capable.common.items;

import com.slepmel.capable.common.registry.CapableItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CrashCoursePickaxeItem extends PickaxeItem{

	public CrashCoursePickaxeItem(IItemTier tier, int p_i48478_2_, float p_i48478_3_, Properties prop) {
		super(tier, p_i48478_2_, p_i48478_3_, prop);
	}
	
	@Override
	public boolean mineBlock(ItemStack stack, World p_179218_2_, BlockState state, BlockPos p_179218_4_, LivingEntity player) throws IllegalStateException {
		Block block = state.getBlock();
		stack = new ItemStack(CapableItems.CRASH_COURSE_PICKAXE.get());
		if(player != null && player.getMainHandItem() == stack && block != null) {
			throw new IllegalStateException("I mean, you probably read the tooltips AND still mined stuff with it anyway. Don't know what you expected");
		}
		return super.mineBlock(stack, p_179218_2_, state, p_179218_4_, player);
	}

}
