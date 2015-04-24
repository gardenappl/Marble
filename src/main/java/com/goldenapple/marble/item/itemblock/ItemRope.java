package com.goldenapple.marble.item.itemblock;

import com.goldenapple.marble.init.ModBlocks;
import com.goldenapple.marble.reference.Names;
import com.goldenapple.marble.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemRope extends ItemBlock{
    public ItemRope(Block block) {
        super(block);
        this.setHasSubtypes(true);
    }

    @SuppressWarnings({"unchecked"})
    @Override
    public void getSubItems(Item item, CreativeTabs tabs, List list){
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
    }

    @Override
    public int getMetadata(int meta){
        return meta == 1 ? meta : 0;
    }

    @Override
    public String getUnlocalizedName(){
        return "tile." + Reference.MOD_ID.toLowerCase() + ":" + Names.ROPE;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack){
        return "tile." + Reference.MOD_ID.toLowerCase() + ":" + (stack.getItemDamage() == 1 ? Names.ENCHANTED_ROPE : Names.ROPE);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean wtf) {
        list.add(StatCollector.translateToLocal("tooltip.marble.rope1"));
        list.add(StatCollector.translateToLocal("tooltip.marble.rope2"));
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if(world.getBlock(x, y, z).equals(ModBlocks.rope) && side != 1 && !player.isSneaking()){
            for(;y>0;y--) {
                if(!world.getBlock(x, y, z).equals(ModBlocks.rope)){
                    return super.onItemUse(itemStack, player, world, x, y, z, 0, hitX, hitY, hitZ);
                }
            }
        }else{
            return super.onItemUse(itemStack, player, world, x, y, z, side, hitX, hitY, hitZ);
        }
        return false;
    }
}
