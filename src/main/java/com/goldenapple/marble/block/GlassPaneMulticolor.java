package com.goldenapple.marble.block;

import com.goldenapple.marble.creativetab.MarbleCreativeTab;
import com.goldenapple.marble.init.ModBlocks;
import com.goldenapple.marble.reference.Names;
import com.goldenapple.marble.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockStainedGlassPane;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class GlassPaneMulticolor extends BlockStainedGlassPane {

    public GlassPaneMulticolor(){
        this.setCreativeTab(MarbleCreativeTab.MarbleTab);
        this.setBlockName(Names.glassPaneMulticolor);
    }

    @SideOnly(Side.CLIENT)
    private IIcon topIcon;

    @Override
    public Item getItemDropped(int meta, Random rand, int fortune){
        return Item.getItemFromBlock(ModBlocks.glassPaneMulticolor);
    }

    @Override
    public Item getItem(World world, int x, int y, int z){
        return Item.getItemFromBlock(ModBlocks.glassPaneMulticolor);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        list.add(new ItemStack(item, 1, 0));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta){
        return side == 1 ? topIcon : blockIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
        topIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())) + "_top");
    }

    //Stolen from Pahimar ;) https://github.com/pahimar/LetsModReboot
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
