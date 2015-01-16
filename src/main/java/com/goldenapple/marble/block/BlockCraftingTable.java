package com.goldenapple.marble.block;

import com.goldenapple.marble.Marble;
import com.goldenapple.marble.client.render.TableRender;
import com.goldenapple.marble.reference.GuiIDs;
import com.goldenapple.marble.reference.Reference;
import com.goldenapple.marble.tileentity.TileEntityTable;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.ArrayList;

public class BlockCraftingTable extends BlockContainer {
    String name;

    @SideOnly(Side.CLIENT)
    public IIcon top;
    @SideOnly(Side.CLIENT)
    public IIcon side;
    @SideOnly(Side.CLIENT)
    public IIcon bottom;

    public BlockCraftingTable(String name, String textureName){
        super(Material.rock);
        this.textureName = textureName;
        this.name = name;
        this.setCreativeTab(Marble.MarbleCreativeTab);
        this.setBlockName(name);
        this.setHardness(1.0F);
        this.setStepSound(soundTypeStone);
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        ArrayList<ItemStack> list = super.getDrops(world, x, y, z, metadata, fortune);

        if(tileEntity != null && tileEntity instanceof TileEntityTable){
            for(int slot = 1; slot <= 9; slot++){
                if(((TileEntityTable) tileEntity).getStackInSlot(slot) != null) {
                    list.add(((TileEntityTable) tileEntity).getStackInSlot(slot));
                }
            }
        }
        return list;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if(!world.isRemote){
            FMLNetworkHandler.openGui(player, Marble.instance, GuiIDs.TABLE, world, x, y, z);
        }
        return true;
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        switch(side){
            case 0: return bottom;
            case 1: return top;
            default: return this.side;
        }
    }

    @Override
    public int getRenderType() {
        return TableRender.ID;
    }

    @Override
    public void registerBlockIcons(IIconRegister register) {
        top = register.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + name + "_top");
        side = register.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + name + "_side");
        bottom = register.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + name + "_bottom");
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityTable(name);
    }

    @Override
    public String getUnlocalizedName() {
        return "tile." + Reference.MOD_ID.toLowerCase() + ":" + name;
    }
}
