package com.goldenapple.marble.item;

import com.goldenapple.marble.creativetab.MarbleCreativeTab;
import com.goldenapple.marble.init.ModBlocks;
import com.goldenapple.marble.reference.Names;
import com.goldenapple.marble.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TallTorchItem extends Item {
    public TallTorchItem(){
        setCreativeTab(MarbleCreativeTab.MarbleTab);
        setUnlocalizedName(Names.tallTorch);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_){
        if(side != 1 || !player.canPlayerEdit(x, y + 1, z, side, itemStack) || !player.canPlayerEdit(x, y + 2, z, side, itemStack)) {
            return false;
        }
        Block torch = ModBlocks.tallTorch;
        if(!torch.canPlaceBlockAt(world, x, y + 1, z) || !world.getBlock(x, y + 2, z).isReplaceable(world, x, y + 2, z)){
            return false;
        }

        world.setBlock(x, y + 1, z, torch);
        world.notifyBlocksOfNeighborChange(x, y + 1, z, torch);
        world.setBlock(x, y + 2, z, torch, 1, 2);
        world.notifyBlocksOfNeighborChange(x, y + 2, z, torch);
        return true;
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
