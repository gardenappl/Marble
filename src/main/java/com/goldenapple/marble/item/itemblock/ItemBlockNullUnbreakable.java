package com.goldenapple.marble.item.itemblock;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.util.List;

public class ItemBlockNullUnbreakable extends ItemBlock{
    public ItemBlockNullUnbreakable(Block block){
        super(block);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean wtf) {
        list.add(StatCollector.translateToLocal("tooltip.marble.unbreakable"));
    }
}
