package com.goldenapple.marble.util;

public class DirectionHelper {
    public static BlockPos getAdjacentBlock(int x, int y, int z, int side){
        switch (side){
            case 0: return new BlockPos(x, y - 1, z);
            case 1: return new BlockPos(x, y + 1, z);
            default: return null;
        }
    }
}
