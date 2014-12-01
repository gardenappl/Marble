package com.goldenapple.marble.block;

import com.goldenapple.marble.creativetab.MarbleCreativeTab;
import com.goldenapple.marble.reference.Names;
import com.goldenapple.marble.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

public class Rope extends Block {
    @SideOnly(Side.CLIENT)
    private IIcon enchantIcon;
    public Rope(){
        super(Material.cloth);
        this.setBlockBounds(0.375F, 0.0F, 0.375F, 0.625F, 1.0F, 0.625F);
        this.setHardness(1.0F);
        this.setBlockName(Names.rope);
        this.setStepSound(soundTypeCloth);
        this.setCreativeTab(MarbleCreativeTab.MarbleTab);
        this.setLightOpacity(1);
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
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity){
        int meta = world.getBlockMetadata(x, y, z);
        if(meta == 1 && !entity.isSneaking()) {
            if(!entity.onGround) {
                if (entity.motionY < 0.5F) {
                    entity.motionY += (0.5F - entity.motionY) / 4;
                    entity.fallDistance = 0F;
                }
            }
        }else{
            if (!entity.onGround) {
                if (entity.isSneaking()) {
                    if (entity.motionY < -0.05F) {
                        entity.motionY += (-0.05F - entity.motionY) / 16;
                    }
                    if(entity.fallDistance > 0.3F) {
                        entity.fallDistance -= 0.3F;
                    }
                } else {
                    if (entity.motionY > -0.75F) {
                        entity.motionY -= (entity.motionY - -0.75F) / 32;
                    }
                }
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta){
        return meta == 1 ? enchantIcon : blockIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
    }

    @Override
    public int damageDropped(int meta){
        return meta;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register)
    {
        blockIcon = register.registerIcon(Reference.MOD_ID + ":" + Names.rope);
        enchantIcon = register.registerIcon(Reference.MOD_ID + ":" + Names.enchantedRope);
    }

    @Override
    public String getUnlocalizedName(){
        return "tile." + Reference.MOD_ID.toLowerCase() + ":" + Names.rope;
    }
}
