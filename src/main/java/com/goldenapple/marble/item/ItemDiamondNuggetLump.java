package com.goldenapple.marble.item;

import com.goldenapple.marble.init.ModItems;
import com.goldenapple.marble.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.util.List;

public class ItemDiamondNuggetLump extends ItemCommon {
    public ItemDiamondNuggetLump(){
        super(Names.DIAMOND_NUGGET_LUMP);
        this.setContainerItem(ModItems.dust);
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        return new ItemStack(this.getContainerItem(), 1, 2);
    }

    @Override
    public int getRenderPasses(int metadata) {
        return super.getRenderPasses(metadata);
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public void addInformation(ItemStack itemStack, EntityPlayer player, List text, boolean p_77624_4_) {
        text.add(StatCollector.translateToLocal("tooltip.marble.diamond_nugget_lump1"));
        text.add(StatCollector.translateToLocal("tooltip.marble.diamond_nugget_lump2"));
    }
}
