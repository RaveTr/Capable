package com.slepmel.capable.common.items;

import javax.annotation.Nonnull;


import com.slepmel.capable.common.blocks.CapableOreBlock;
import com.slepmel.capable.config.CapableConfig.Common;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RedstoneOreBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ZeedriumPickaxeItem extends PickaxeItem{
	
	public ZeedriumPickaxeItem(IItemTier tier, int integer, float floatValue, Properties properties) {
		super(tier, integer, floatValue, properties);
	}
	
	
	@Override
	public boolean mineBlock(@Nonnull ItemStack stack, @Nonnull World world, @Nonnull BlockState state, @Nonnull BlockPos pos, @Nonnull LivingEntity entity) {
		if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, stack) < 1) {
			Block block = state.getBlock();
			if (block instanceof CapableOreBlock) {
				ItemStack drop = new ItemStack(block);
				double chance = Common.zeedriumChancesOfSpecialProperties.get();
				if (world.random.nextDouble() < chance && Common.enableZeedriumPickaxeProperties.get()) {
					world.addFreshEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), drop));
				}
			}
			else if (block instanceof RedstoneOreBlock) {
				ItemStack drop = new ItemStack(Items.REDSTONE);
				double chance = Common.zeedriumChancesOfSpecialProperties.get();
				if (world.random.nextDouble() < chance && Common.enableZeedriumPickaxeProperties.get()) {
                    int i = world.random.nextInt(10);
                    for (int x = 0; x <= i; x++)
					world.addFreshEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), drop));
				}
			}
			else if (block == Blocks.LAPIS_ORE) {
				ItemStack drop = new ItemStack(Items.LAPIS_LAZULI);
				double chance = Common.zeedriumChancesOfSpecialProperties.get();
				if (world.random.nextDouble() < chance && Common.enableZeedriumPickaxeProperties.get()) {
                    int i = world.random.nextInt(10);
                    for (int x = 0; x <= i; x++)
					world.addFreshEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), drop));
				}
			}
			else if (block == Blocks.EMERALD_ORE) {
				ItemStack drop = new ItemStack(Items.EMERALD);
				double chance = Common.zeedriumChancesOfSpecialProperties.get();
				if (world.random.nextDouble() < chance && Common.enableZeedriumPickaxeProperties.get()) {
					world.addFreshEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), drop));
				}
			}
			else if (block == Blocks.COAL_ORE) {
				ItemStack drop = new ItemStack(Items.COAL);
				double chance = Common.zeedriumChancesOfSpecialProperties.get();
				if (world.random.nextDouble() < chance && Common.enableZeedriumPickaxeProperties.get()) {
                    int i = world.random.nextInt(6);
                    for (int x = 0; x <= i; x++)
					world.addFreshEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), drop));
				}
			}
			else if (block == Blocks.DIAMOND_ORE) {
				ItemStack drop = new ItemStack(Items.DIAMOND);
				double chance = Common.zeedriumChancesOfSpecialProperties.get();
				if (world.random.nextDouble() < chance && Common.enableZeedriumPickaxeProperties.get()) {
                    int i = world.random.nextInt(2);
                    for (int x = 0; x <= i; x++)
					world.addFreshEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), drop));
				}
			}
			else if (block == Blocks.NETHER_QUARTZ_ORE) {
				ItemStack drop = new ItemStack(Items.QUARTZ);
				double chance = Common.zeedriumChancesOfSpecialProperties.get();
				if (world.random.nextDouble() < chance && Common.enableZeedriumPickaxeProperties.get()) {
                    int i = world.random.nextInt(4);
                    for (int x = 0; x <= i; x++)
					world.addFreshEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), drop));
				}
			}
			else if (block == Blocks.NETHER_GOLD_ORE) {
				ItemStack drop = new ItemStack(Items.GOLD_NUGGET);
				double chance = Common.zeedriumChancesOfSpecialProperties.get();
				if (world.random.nextDouble() < chance && Common.enableZeedriumPickaxeProperties.get()) {
                    int i = world.random.nextInt(20);
                    for (int x = 0; x <= i; x++)
					world.addFreshEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), drop));
				}
			}
			else if (block == Blocks.GOLD_ORE) {
				ItemStack drop = new ItemStack(block);
				double chance = Common.zeedriumChancesOfSpecialProperties.get();
				if (world.random.nextDouble() < chance && Common.enableZeedriumPickaxeProperties.get()) {
					world.addFreshEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), drop));
				}
			}
			else if (block == Blocks.IRON_ORE) {
				ItemStack drop = new ItemStack(block);
				double chance = Common.zeedriumChancesOfSpecialProperties.get();
				if (world.random.nextDouble() < chance && Common.enableZeedriumPickaxeProperties.get()) {
					world.addFreshEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), drop));
				}
			}
		}
		return super.mineBlock(stack, world, state, pos, entity);
	}
}
