package com.goldenapple.marble.block;

import com.goldenapple.marble.Marble;
import com.goldenapple.marble.reference.Names;
import com.goldenapple.marble.reference.Reference;
import com.goldenapple.marble.tileentity.TileEntityRoundRobinBuffer;
import com.goldenapple.marble.util.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockRoundRobinBuffer extends BlockContainer{
    @SideOnly(Side.CLIENT)
    private IIcon inputIcon;
    @SideOnly(Side.CLIENT)
    private IIcon outputIcon;

    public BlockRoundRobinBuffer(){
        super(Material.iron);
        this.setHardness(3.0F);
        this.setResistance(8.0F);
        this.setStepSound(soundTypeWood);
        this.setCreativeTab(Marble.MarbleCreativeTab);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if(player.isSneaking()) {
            int currentMeta = world.getBlockMetadata(x, y, z);
            int meta = currentMeta == 5 ? 0 : currentMeta + 1;
            world.setBlockMetadataWithNotify(x, y, z, meta, 2);
            return true;
        }
        return false;
    }

    @Override
    public ForgeDirection[] getValidRotations(World world, int x, int y, int z) {
        return ForgeDirection.VALID_DIRECTIONS;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityRoundRobinBuffer();
    }

    @Override
    public String getUnlocalizedName() {
        return "tile." + Reference.MOD_ID.toLowerCase() + ":" + Names.ROUND_ROBIN_BUFFER;
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return side == meta ? inputIcon : blockIcon;
    }

    @Override
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
        if(world.getTileEntity(x, y, z) instanceof TileEntityRoundRobinBuffer) {
            int outputSide = ((TileEntityRoundRobinBuffer) world.getTileEntity(x, y, z)).outputSide;
            int inputSide = ((TileEntityRoundRobinBuffer) world.getTileEntity(x, y, z)).inputSide;
            return side == outputSide ? outputIcon : getIcon(side, world.getBlockMetadata(x, y, z));
        }else{
            LogHelper.info("Invalid TileEntityRoundRobinBuffer! Prepare for all kinds of weirdness!");
            return blockIcon;
        }
    }

    @Override
    public void registerBlockIcons(IIconRegister register) {
        blockIcon = register.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Names.ROUND_ROBIN_BUFFER);
        inputIcon = register.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Names.ROUND_ROBIN_BUFFER + "_input");
        outputIcon = register.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + Names.ROUND_ROBIN_BUFFER + "_output");
    }
}
