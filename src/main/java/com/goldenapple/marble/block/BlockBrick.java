package com.goldenapple.marble.block;

import com.goldenapple.marble.creativetab.MarbleCreativeTab;
import com.goldenapple.marble.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBrick extends Block {
    public BlockBrick(Material material, String name, SoundType sound){
        super(material);
        this.setCreativeTab(MarbleCreativeTab.MarbleTab);
        this.setBlockName(name);
        this.setHardness(2.0F);
        this.setStepSound(sound);
        this.setBlockTextureName(name);
        this.setResistance(10.0F);
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
