package com.goldenapple.marble.block;

import com.goldenapple.marble.init.ModItems;
import com.goldenapple.marble.reference.Names;
import com.goldenapple.marble.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class TallTorchTop extends Block {
    @SideOnly(Side.CLIENT)
    private IIcon topIcon;
    @SideOnly(Side.CLIENT)
    private IIcon elseIcon;

    public TallTorchTop(){
        super(Material.circuits);
        this.setBlockName(Names.tallTorchTop);
        this.setHardness(0.0F);
        this.setLightLevel(0.9375F);
        this.setStepSound(soundTypeWood);
        this.setBlockBounds(0.4375F, 0.0F, 0.4375F, 0.5625F, 0.5F, 0.5625F);
        this.setTickRandomly(true);
    }

    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random rand){
        {
            world.spawnParticle("smoke", x + 0.5, y + 0.6, z + 0.5, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("flame", x + 0.5, y + 0.6, z + 0.5, 0.0D, 0.0D, 0.0D);
        }
    }

    //So that entities can walk through it
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return null;
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
    public boolean canPlaceBlockAt(World world, int x, int y, int z){
        return false;
    }

    @Override
     public Item getItemDropped(int metadata, Random rand, int fortune){
        return ModItems.tallTorch;
    }

    @Override
    public Item getItem(World world, int x, int y, int z){
        return ModItems.tallTorch;
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block){
        if (!(world.getBlock(x, y - 1, z) instanceof TallTorchBottom)){ //If the block below isn't the bottom
            world.setBlockToAir(x, y, z); //Don't drop anything; the top block should drop the item
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta){
        return side == 1 ? topIcon : elseIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        elseIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "tall_torch_top");
        topIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "tall_torch_top_top_(WAT)");
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