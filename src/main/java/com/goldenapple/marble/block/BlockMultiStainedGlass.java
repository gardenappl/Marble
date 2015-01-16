package com.goldenapple.marble.block;

import com.goldenapple.marble.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMultiStainedGlass extends BlockCommon {
    public BlockMultiStainedGlass(){
        super(Names.MULTI_STAINED_GLASS, Material.glass);
        this.setStepSound(Block.soundTypeGlass);
        this.setHardness(0.3F);
    }

    @Override
    public int getRenderBlockPass() {
        return 1;
    }
}
