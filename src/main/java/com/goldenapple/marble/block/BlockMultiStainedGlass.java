package com.goldenapple.marble.block;

import com.goldenapple.marble.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

import java.util.Random;

public class BlockMultiStainedGlass extends BlockCommon {
    public BlockMultiStainedGlass(){
        super(Names.MULTI_STAINED_GLASS, Material.glass);
        this.setStepSound(Block.soundTypeGlass);
        this.setHardness(0.3F);
    }

    @Override
    public int quantityDropped(Random rand) {
        return 0;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public int getRenderBlockPass() {
        return 1;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
        return world.getBlock(x, y, z) == this ? false : super.shouldSideBeRendered(world, x, y, z, side);
    }
}
