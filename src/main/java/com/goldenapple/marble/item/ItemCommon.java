package com.goldenapple.marble.item;

import com.goldenapple.marble.Marble;
import com.goldenapple.marble.reference.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemCommon extends Item {
    String name;

    public ItemCommon(String name){
        this.name = name;
        this.setCreativeTab(Marble.MarbleCreativeTab);
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + name);
    }

    @Override
    public String getUnlocalizedName() {
        return "item." + Reference.MOD_ID.toLowerCase() + ":" + name;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack){
        return "item." + Reference.MOD_ID.toLowerCase() + ":" + name;
    }
}
