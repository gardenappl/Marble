package com.goldenapple.marble.item;

import com.goldenapple.marble.Marble;
import com.goldenapple.marble.reference.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemFoodCommon extends ItemFood {
    private String name;

    public ItemFoodCommon(String name, int hunger, float saturation){
        super(hunger, saturation, false);
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
