package com.goldenapple.marble.block;

import com.goldenapple.marble.creativetab.MarbleCreativeTab;
import com.goldenapple.marble.reference.BlockNames;
import com.goldenapple.marble.reference.Reference;
import com.goldenapple.marble.util.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class TallTorch extends Block {
    public TallTorch(){
        super(Material.circuits);
        this.setCreativeTab(MarbleCreativeTab.MarbleTab);
        this.setBlockName(BlockNames.tallTorch);
        this.setHardness(0.0F);
        this.setLightLevel(0.9375F);
        this.setStepSound(soundTypeWood);
        this.setBlockTextureName("torch_on");
        this.setBlockBounds(0.4375F,0.0F,0.4375F,0.5625F,1.5F,0.5625F);
    }

    //So that entities can walk through it
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
        return world.getBlock(x, y -1, z).canPlaceTorchOnTop(world, x, y - 1, z);
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block){
        if (!world.getBlock(x, y -1, z).canPlaceTorchOnTop(world, x, y - 1, z)){ //If the side of the block below isn't solid a.k.a If the block below is broken
            this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0); //Drop the torch on the ground
            world.setBlockToAir(x, y, z); //And delete the torch block
        }
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