package com.goldenapple.marble.block;

import com.goldenapple.marble.Marble;
import com.goldenapple.marble.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockCommon extends Block{
    String name;

    public BlockCommon(String name, Material material){
        super(material);
        this.name = name;
        this.setCreativeTab(Marble.MarbleCreativeTab);
        this.setBlockName(name);
    }

    @Override
    public String getUnlocalizedName(){
        return "tile." + Reference.MOD_ID.toLowerCase() + ":" + name;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register){
        blockIcon = register.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + name);
    }
}
