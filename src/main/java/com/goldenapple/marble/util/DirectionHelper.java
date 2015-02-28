package com.goldenapple.marble.util;

import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;

public class DirectionHelper {
    public static BlockPos getAdjacentBlockPos(int x, int y, int z, int side){
        switch (side){
            case 0: return new BlockPos(x, y - 1, z);
            case 1: return new BlockPos(x, y + 1, z);
            case 2: return new BlockPos(x, y, z - 1);
            case 3: return new BlockPos(x, y, z + 1);
            case 4: return new BlockPos(x - 1, y, z);
            case 5: return new BlockPos(x + 1, y, z);
            default: return null; //TODO
        }
    }

    public static Block getAdjacentBlock(IBlockAccess world, int x, int y, int z, int side){
        return world.getBlock(getAdjacentBlockPos(x, y, z, side).x, getAdjacentBlockPos(x, y, z, side).y, getAdjacentBlockPos(x, y, z, side).z);
    }
}
