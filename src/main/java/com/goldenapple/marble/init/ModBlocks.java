package com.goldenapple.marble.init;

import com.goldenapple.marble.block.BlockBrick;
import com.goldenapple.marble.block.TallTorch;
import com.goldenapple.marble.reference.BlockNames;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
    public static final Block brickIron = new BlockBrick(Material.rock, BlockNames.ironBrick, Block.soundTypeStone);
    public static final Block tallTorch = new TallTorch();
    public static void init(){
        GameRegistry.registerBlock(brickIron, BlockNames.ironBrick);
        GameRegistry.registerBlock(tallTorch, BlockNames.tallTorch);
    }
}
