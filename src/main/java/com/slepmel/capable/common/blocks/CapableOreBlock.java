package com.slepmel.capable.common.blocks;

import java.util.Random;

import com.google.common.base.Function;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorldReader;

public class CapableOreBlock extends Block {
	
    private Function<Random, Integer> expFormula = (rand) -> 0;

    public CapableOreBlock(AbstractBlock.Properties properties) {
        super(properties);
    }

    public CapableOreBlock withExpDrop(int min, int max) {
        this.expFormula = (rand) -> MathHelper.nextInt(rand, min, max);
        return this;
    }

    public CapableOreBlock withExp() {
        this.expFormula = (rand) -> MathHelper.nextInt(rand, 0, 2);
        return this;
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
        return silktouch == 0 ? this.expFormula.apply(RANDOM) : 0;
    }

	public BlockState getDefaultState() {
		return this.defaultBlockState();
	}

}
