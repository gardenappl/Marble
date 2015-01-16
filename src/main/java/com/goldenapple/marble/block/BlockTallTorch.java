package com.goldenapple.marble.block;

import com.goldenapple.marble.init.ModItems;
import com.goldenapple.marble.reference.Names;
import com.goldenapple.marble.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class BlockTallTorch extends BlockCommon {
    @SideOnly(Side.CLIENT)
    private IIcon topIcon;
    @SideOnly(Side.CLIENT)
    private IIcon elseIcon;

    public BlockTallTorch(){
        super(Names.TALL_TORCH, Material.circuits);
        this.setHardness(0.0F);
        this.setLightLevel(0.9375F);
        this.setStepSound(soundTypeWood);
        this.setTickRandomly(true);
    }

    @Override
    public Item getItem(World world, int x, int y, int z) {
        return ModItems.tallTorch;
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) { //dunno what those parametres mean.
        return ModItems.tallTorch;
    }

    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random rand){
        int meta = world.getBlockMetadata(x, y, z);
        if(meta == 1) {
            world.spawnParticle("smoke", x + 0.5, y + 0.6, z + 0.5, 0.0D, 0.0D, 0.0D);
            world.spawnParticle("flame", x + 0.5, y + 0.6, z + 0.5, 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z){
        int meta = world.getBlockMetadata(x, y, z);
        if(meta == 1){
            setBlockBounds(0.4375F, 0.0F, 0.4375F, 0.5625F, 0.5F, 0.5625F);
        }else{
            setBlockBounds(0.4375F, 0.0F, 0.4375F, 0.5625F, 1.0F, 0.5625F);
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
        return world.getBlock(x, y - 1, z).canPlaceTorchOnTop(world, x, y - 1, z) && super.canPlaceBlockAt(world, x, y, z);
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block){
        int meta = world.getBlockMetadata(x, y, z);

        if(meta == 1) {//Top
            if (!(world.getBlock(x, y - 1, z) instanceof BlockTallTorch)) { //If the block below isn't the bottom
                world.setBlockToAir(x, y, z);
            }
        }else{ //Bottom
            if (!world.getBlock(x, y - 1, z).canPlaceTorchOnTop(world, x, y - 1, z)) { //If the side of the block below isn't solid a.k.a If the block below is broken
                if (world.getGameRules().getGameRuleBooleanValue("doTileDrops")) {
                    dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
                }
                world.setBlockToAir(x, y, z);
            }
            if(!(world.getBlock(x, y + 1, z) instanceof BlockTallTorch)){ //If the block above isn't the top
                world.setBlockToAir(x, y, z);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta){
        if(meta == 1) {
            return side == 1 ? topIcon : elseIcon;
        }else{
            return blockIcon;
        }
    }

    @Override
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
        //NO-OP    I don't want the block to be displayed. Look at ItemTallTorch instead.
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        elseIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Names.TALL_TORCH + "_top");
        topIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Names.TALL_TORCH + "_top_top_(WAT)");
        blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Names.TALL_TORCH + "_bottom");
    }
}