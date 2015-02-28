package com.goldenapple.marble.block;

import com.goldenapple.marble.reference.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class BlockMultiMetadata extends BlockCommon {
    private IIcon[] icons;
    public String[] names;

    public BlockMultiMetadata(String[] names, String defaultName, Material material){
        super(defaultName, material);
        this.icons = new IIcon[names.length];
        this.names = names;
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return meta < icons.length ? icons[meta] : icons[0];
    }

    @Override
    @SuppressWarnings("unchecked")
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list) {
        for(int i = 0; i < names.length; i++)
        list.add(new ItemStack(item, 1, i));
    }

    @Override
    public void registerBlockIcons(IIconRegister register) {
        for(int i = 0; i < names.length; i++)
        icons[i] = register.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + names[i]);
    }
}
