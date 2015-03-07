package com.goldenapple.marble.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreHelper {
    public static boolean isItemThisOre(ItemStack item, String ore) {
        for (int o : OreDictionary.getOreIDs(item)) {
            if (OreDictionary.getOreName(o).equals(ore)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isItemThisOre(Item item, String ore){
        return isItemThisOre(new ItemStack(item), ore);
    }
}