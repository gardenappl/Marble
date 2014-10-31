package com.goldenapple.marble.creativetab;

import com.goldenapple.marble.init.ModBlocks;
import com.goldenapple.marble.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MarbleCreativeTab {
    public static final CreativeTabs MarbleTab = new CreativeTabs(Reference.MOD_ID) {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(ModBlocks.brickIron);
        }
    };
}
