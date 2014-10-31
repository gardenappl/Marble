package com.goldenapple.marble.block;

import com.goldenapple.marble.creativetab.MarbleCreativeTab;
import com.goldenapple.marble.reference.BlockNames;
import com.goldenapple.marble.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TallTorch extends Block {
    public TallTorch(){
        super(Material.circuits);
        this.setCreativeTab(MarbleCreativeTab.MarbleTab);
        this.setBlockName(BlockNames.tallTorch);
        this.setHardness(0.0F);
        this.setLightLevel(0.9375F);
        this.setStepSound(soundTypeWood);
        this.setBlockTextureName("torch_on");
        this.setBlockBounds(0.4375F,0.0F,0.4375F,0.5625F,2.0F,0.5625F);
    }

    @Override
    public boolean isOpaqueCube(){
        return false;
    }

    @Override
    public boolean renderAsNormalBlock(){
        return false;
    }

    @Override
    public String getUnlocalizedName()
    {
        return "tile." + Reference.MOD_ID.toLowerCase() + ":" + getUnwrappedUnlocalizedName(super.getUnlocalizedName());
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}