package com.goldenapple.marble.item.itemblock;

import com.goldenapple.marble.block.BlockMultiMetadata;
import com.goldenapple.marble.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemBlockMultiMetadata extends ItemBlock {
    private BlockMultiMetadata block;

    public ItemBlockMultiMetadata(Block block){
        super(block);
        this.block = (BlockMultiMetadata) block;
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "tile." + Reference.MOD_ID.toLowerCase() + ":" + block.names[stack.getItemDamage()];
    }

    @Override
    public IIcon getIconFromDamage(int meta) {
        return field_150939_a.getIcon(0, meta);
    }
}
