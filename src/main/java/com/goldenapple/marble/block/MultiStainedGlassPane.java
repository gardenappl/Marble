package com.goldenapple.marble.block;

import com.goldenapple.marble.creativetab.MarbleCreativeTab;
import com.goldenapple.marble.init.ModBlocks;
import com.goldenapple.marble.reference.Names;
import com.goldenapple.marble.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStainedGlassPane;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

import static com.goldenapple.marble.reference.Names.multiStainedGlassPane;

public class MultiStainedGlassPane extends BlockStainedGlassPane {

    @SideOnly(Side.CLIENT)
    private IIcon topIcon;

    public MultiStainedGlassPane(){
        this.setCreativeTab(MarbleCreativeTab.MarbleTab);
        this.setBlockName(multiStainedGlassPane);
        this.setStepSound(Block.soundTypeGlass);
        this.setHardness(0.3F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon func_150097_e()
    {
        return this.topIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon func_149735_b(int p_149735_1_, int p_149735_2_){ //Apparently this is used for rendering the block in your inventory as a flat icon
        return this.blockIcon;
    }

    @Override
    public Item getItemDropped(int meta, Random rand, int fortune){
        return Item.getItemFromBlock(ModBlocks.multiStainedGlassPane);
    }

    @Override
    public Item getItem(World world, int x, int y, int z){
        return Item.getItemFromBlock(ModBlocks.multiStainedGlassPane);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        list.add(new ItemStack(item, 1, 0));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + Names.multiStainedGlass);
        topIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + Names.multiStainedGlassPane + "_top");
    }

    //Stolen from Pahimar ;) https://github.com/pahimar/LetsModReboot
    @Override
    public String getUnlocalizedName()
    {
        return "tile." + Reference.MOD_ID + ":" + multiStainedGlassPane;
    }
}
