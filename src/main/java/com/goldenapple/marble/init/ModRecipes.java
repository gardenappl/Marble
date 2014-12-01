package com.goldenapple.marble.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ModRecipes {
    public static void init(){
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.tallTorch, 4),
                " O ",
                " | ",
                " | ", 'O', "coal", '|', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.tallTorch, 4),
                " O ",
                " | ",
                " | ", 'O', "charcoal", '|', "stickWood"));
    }
}
