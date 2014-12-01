package com.goldenapple.marble.block;

import com.goldenapple.marble.creativetab.MarbleCreativeTab;
import com.goldenapple.marble.reference.Names;
import com.goldenapple.marble.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class MultiStainedGlass extends BlockStainedGlass {
    public MultiStainedGlass(){
        super(Material.glass);
        this.setStepSound(Block.soundTypeGlass);
        this.setCreativeTab(MarbleCreativeTab.MarbleTab);
        this.setHardness(0.3F);
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs tabs, List list){
        list.add(new ItemStack(item, 1, 0));
    }

    @Override
    public int damageDropped(int meta){
        return 0;
    }

    @Override
    public String getUnlocalizedName(){
        return "tile." + Reference.MOD_ID + ":" + Names.multiStainedGlass;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta){
        return blockIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register)
    {
        blockIcon = register.registerIcon(Reference.MOD_ID + ":" + Names.multiStainedGlass);
    }
}
