package com.goldenapple.marble.item;

import com.goldenapple.marble.init.ModBlocks;
import com.goldenapple.marble.reference.Names;
import com.goldenapple.marble.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.List;

public class RopeItem extends ItemBlock{
    public RopeItem(Block block) {
        super(block);
        this.setHasSubtypes(true);
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tabs, List list){
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
    }

    @Override
    public int getMetadata(int meta){
        return meta;
    }

    @Override
    public String getUnlocalizedName(){
        return "tile." + Reference.MOD_ID + ":" + Names.rope;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack){
        return "tile." + Reference.MOD_ID + ":" + (stack.getItemDamage() == 1 ? Names.enchantedRope : Names.rope);
    }
}
