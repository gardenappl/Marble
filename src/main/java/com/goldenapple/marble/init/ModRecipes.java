package com.goldenapple.marble.init;

import com.goldenapple.marble.crafting.ItemBreakingRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ModRecipes {
    public static void init(){
        //Tall Torch
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.tallTorch, 4),
                "O",
                "I",
                "I", 'O', new ItemStack(Items.coal, 1, 0), 'I', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.tallTorch, 4),
                "O",
                "I",
                "I", 'O', new ItemStack(Items.coal, 1, 1), 'I', "stickWood"));

        //Multicolored Glass
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.multiStainedGlass, 8),
                "GGG",
                "GdG",
                "GGG", 'G', "blockGlassColorless", 'd', "dustTinyDiamond"));

        //Multicolored Glass Pane
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.multiStainedGlassPane, 16),
                "GGG",
                "GGG", 'G', "blockGlassMulticolor"));

        //Rope
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.rope, 16, 0),
                "W",
                "W",
                "W", 'W', new ItemStack(Blocks.wool)));

        //Enchanted Rope
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.rope, 8, 1),
                "III",
                "IdI",
                "III", 'I', new ItemStack(ModBlocks.rope), 'd', new ItemStack(ModItems.dust, 1, 1)));

        //Diamond Arrow
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.arrow, 8, 0),
                "AAA",
                "AdA",
                "AAA", 'I', new ItemStack(Items.arrow), 'd', new ItemStack(ModItems.dust, 1, 2)));

        //Aetheric Arrow
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.arrow, 8, 1),
                "AAA",
                "AdA",
                "AAA", 'I', new ItemStack(ModItems.arrow, 1, 0), 'd', new ItemStack(ModItems.dust, 1, 1)));



        //Diamond Lump breaking
        GameRegistry.addRecipe(new ItemBreakingRecipe("pickaxe", 3,
                new ItemStack(ModItems.diamondNuggetLump)));

        //Diamond => Diamond Nuggets
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.diamondNugget, 9),
                "gemDiamond"));

        //Diamond Nuggets => Diamond
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.diamond),
                "nuggetDiamond", "nuggetDiamond", "nuggetDiamond", "nuggetDiamond", "nuggetDiamond", "nuggetDiamond", "nuggetDiamond", "nuggetDiamond", "nuggetDiamond"));

        //Diamond Nuggets => Diamond Lump
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.diamondNuggetLump),
                "nuggetDiamond", "nuggetDiamond", "nuggetDiamond", "nuggetDiamond"));

        //Diamond Dust => Tiny Diamond Dust
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.dust, 4, 2),
                "dustDiamond"));

        //Tiny Diamond Dust => Diamond Dust
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.dust, 1, 0),
                "dustTinyDiamond", "dustTinyDiamond", "dustTinyDiamond", "dustTinyDiamond"));

        //Aetheric dust
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.dust, 4, 1),
                "dustTinyDiamond", "dustRedstone", "dustGlowstone", new ItemStack(Items.ghast_tear)));
    }

    public static void initOreDict(){
        OreDictionary.registerOre("blockGlassMulticolor", ModBlocks.multiStainedGlass);
        OreDictionary.registerOre("paneGlassMulticolor", ModBlocks.multiStainedGlassPane);
        OreDictionary.registerOre("nuggetDiamond", ModItems.diamondNugget);
        OreDictionary.registerOre("dustDiamond", new ItemStack(ModItems.dust, 1, 0));
        OreDictionary.registerOre("dustTinyDiamond", new ItemStack(ModItems.dust, 1, 2));
    }
}
