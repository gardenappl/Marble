package com.goldenapple.marble.init;

import com.goldenapple.marble.crafting.DiamondBreakingRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ModRecipes {
    public static void init(){
        //Tall Torch
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.tallTorch, 4),
                "O",
                "I",
                "I", 'O', "coal", 'I', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.tallTorch, 4),
                "O",
                "I",
                "I", 'O', "charcoal", 'I', "stickWood"));

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
                "W", 'W', "blockCloth"));

        //Enchanted Rope
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.rope, 8, 1),
                "III",
                "IdI",
                "III", 'I', new ItemStack(ModBlocks.rope), 'd', new ItemStack(ModItems.dust, 1, 1)));

        //Diamond -> Small Dust
        RecipeSorter.register("marble:breaking", DiamondBreakingRecipe.class, RecipeSorter.Category.SHAPELESS, "after:minecraft:shapeless");
        GameRegistry.addRecipe(new DiamondBreakingRecipe());

        //Diamond Dust -> Small Dust
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.dust, 4, 2),
                "dustDiamond"));

        //Small Dust -> Diamond Dust
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.dust),
                "dustTinyDiamond", "dustTinyDiamond", "dustTinyDiamond", "dustTinyDiamond"));

        //Aetheric dust
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.dust, 4, 1),
                "dustTinyDiamond", "dustRedstone", "dustGlowstone", new ItemStack(Items.feather)));

        //Null Block
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.nullBlock, 4),
                "PB",
                "BP", 'P', new ItemStack(Blocks.wool, 1, 2), 'B', new ItemStack(Blocks.wool, 1, 15)));

        //Clay Bricks
        for(int meta = 0; meta < 16; meta++){
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.stainedClayBrick, 4, meta),
                "BB",
                "BB", 'B', new ItemStack(Blocks.stained_hardened_clay, 1, meta)));
        }

        //Apple Pie
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.applePie),
                new ItemStack(Items.apple), new ItemStack(Items.apple), new ItemStack(Items.apple), new ItemStack(Items.apple), new ItemStack(Items.apple), new ItemStack(Items.apple), new ItemStack(Items.apple), new ItemStack(Items.sugar), new ItemStack(Items.egg)));

        //Golden Apple Pie
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.goldenApplePie),
                new ItemStack(Items.golden_apple), new ItemStack(Items.golden_apple), new ItemStack(Items.golden_apple), new ItemStack(Items.golden_apple), new ItemStack(Items.golden_apple), new ItemStack(Items.golden_apple), new ItemStack(Items.golden_apple), new ItemStack(Items.sugar), new ItemStack(Items.egg)));
    }

    public static void initOreDict(){
        OreDictionary.registerOre("blockGlassMulticolor", ModBlocks.multiStainedGlass);
        OreDictionary.registerOre("paneGlassMulticolor", ModBlocks.multiStainedGlassPane);
        OreDictionary.registerOre("dustDiamond", new ItemStack(ModItems.dust, 1, 0));
        OreDictionary.registerOre("dustTinyDiamond", new ItemStack(ModItems.dust, 1, 2));
    }
}
