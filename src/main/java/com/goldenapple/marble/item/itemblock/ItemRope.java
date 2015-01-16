package com.goldenapple.marble.item.itemblock;

import com.goldenapple.marble.reference.Names;
import com.goldenapple.marble.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

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
}
