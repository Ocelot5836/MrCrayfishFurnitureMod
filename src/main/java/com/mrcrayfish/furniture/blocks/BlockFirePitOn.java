package com.mrcrayfish.furniture.blocks;

import java.util.Random;

import com.mrcrayfish.furniture.MrCrayfishFurnitureMod;
import com.mrcrayfish.furniture.init.FurnitureBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Author: MrCrayfish
 */
public class BlockFirePitOn extends BlockFirePit
{
	public BlockFirePitOn(String name)
	{
		super(name);
		this.setLightLevel(1.0F);
		this.setCreativeTab(MrCrayfishFurnitureMod.tabFurniture);
	}

	@Override
	public boolean isBurning()
	{
		return true;
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		world.setBlockState(pos, FurnitureBlocks.FIRE_PIT_OFF.getDefaultState().withProperty(STAGE, 3));
		return true;
	}

	@Override
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
	{
		if (rand.nextInt(24) == 0)
		{
			worldIn.playSound(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.BLOCKS, 1.0F + rand.nextFloat(), rand.nextFloat() * 0.7F + 0.3F, false);
		}

		for (int i = 0; i < 2; ++i)
		{
			double posX = (double) pos.getX() + rand.nextDouble() * 0.8 + 0.2;
			double posY = (double) pos.getY() + rand.nextDouble() * 0.5D + 0.5D;
			double posZ = (double) pos.getZ() + rand.nextDouble() * 0.8 + 0.2;
			worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, posX, posY, posZ, 0.0D, 0.0D, 0.0D);
		}
	}
}
