package com.goldenapple.marble.item;

import com.goldenapple.marble.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemMultiMetadata extends ItemCommon {
    IIcon[] icons;
    String[] names;

    public ItemMultiMetadata(String[] names, String defaultName){
        super(defaultName);
        this.names = names;
        this.setHasSubtypes(true);
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for(int i = 0; i < names.length; i++)
        list.add(new ItemStack(item, 1, i));
    }

    @Override
    public int getMetadata(int meta) {
        return meta < names.length ? meta : 0;
    }

    @Override
    public IIcon getIconFromDamage(int meta) {
        return meta < names.length ? icons[meta] : icons[0];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        icons = new IIcon[names.length];
        for(int i = 0; i < names.length; i++) {
            icons[i] = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + names[i]);
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        if(stack.getItemDamage() < names.length) {
            return "item." + Reference.MOD_ID.toLowerCase() + ":" + names[stack.getItemDamage()];
        }else{
            return "item." + Reference.MOD_ID.toLowerCase() + ":" + names[0];
        }
    }
}
