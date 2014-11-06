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
import net.minecraft.world.World;

import java.util.Random;

public class TallTorchBottom extends Block {
    public TallTorchBottom() {
        super(Material.circuits);
        this.setBlockName(Names.tallTorchBottom);
        this.setHardness(0.0F);
        this.setStepSound(soundTypeWood);
        this.setBlockBounds(0.4375F, 0.0F, 0.4375F, 0.5625F, 1.0F, 0.5625F);
    }

    //So that entities can walk through it
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
        return null;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        return world.getBlock(x, y - 1, z).canPlaceTorchOnTop(world, x, y - 1, z);
    }

    @Override
    public Item getItemDropped(int metadata, Random rand, int fortune){
        return ModItems.tallTorch;
    }

    @Override
    public Item getItem(World world, int x, int y, int z) {
        return ModItems.tallTorch;
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        if (world.getBlockMetadata(x, y, z) == 0) {//If it's the bottom
            if (!world.getBlock(x, y - 1, z).canPlaceTorchOnTop(world, x, y - 1, z)) { //If the side of the block below isn't solid a.k.a If the block below is broken
                if(world.getGameRules().getGameRuleBooleanValue("doTileDrops")) {
                    dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
                }
                world.setBlockToAir(x, y, z);
            }
            if (!(world.getBlock(x, y + 1, z) instanceof TallTorchTop)) {
                world.setBlockToAir(x, y, z);//Don't drop anything; the bottom block should drop the item
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(getUnwrappedUnlocalizedName(this.getUnlocalizedName()));
    }

    //Stolen from Pahimar ;) https://github.com/pahimar/LetsModReboot
    @Override
    public String getUnlocalizedName() {
        return "tile." + Reference.MOD_ID.toLowerCase() + ":" + getUnwrappedUnlocalizedName(super.getUnlocalizedName());
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}

