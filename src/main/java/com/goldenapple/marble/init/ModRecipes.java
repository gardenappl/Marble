package com.goldenapple.marble.init;

import com.goldenapple.marble.crafting.DustCrushingRecipe;
import com.goldenapple.marble.crafting.UnsignedBookRecipe;
import com.goldenapple.marble.reference.Metadata;
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
        RecipeSorter.register("marble:crushing", DustCrushingRecipe.class, RecipeSorter.Category.SHAPELESS, "after:minecraft:shapeless");
        RecipeSorter.register("marble:unsignedbook", UnsignedBookRecipe.class, RecipeSorter.Category.SHAPELESS, "after:minecraft:shapeless");

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
                "GGG", 'G', "blockGlassColorless", 'd', "dustTinyGem"));

        //Multicolored Glass Pane
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.multiStainedGlassPane, 16),
                "GGG",
                "GGG", 'G', "blockGlassMulticolor"));

        //Rope
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.rope, 16, 0),
                "W",
                "W",
                "W", 'W', "blockCloth"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.rope, 16, 0),
                "W",
                "W",
                "W", 'W', Blocks.wool));

        //Enchanted Rope
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.rope, 8, 1),
                "III",
                "IdI",
                "III", 'I', new ItemStack(ModBlocks.rope), 'd', new ItemStack(ModItems.dust, 1, Metadata.AETHERIC_DUST)));

        //Gem -> Small Gem Dust
        GameRegistry.addRecipe(new DustCrushingRecipe(new ItemStack(ModItems.dust, 3, Metadata.DIAMOND_DUST_SMALL),
                "gemDiamond"));
        GameRegistry.addRecipe(new DustCrushingRecipe(new ItemStack(ModItems.modDust, 3, Metadata.RUBY_DUST_SMALL),
                "gemRuby"));
        GameRegistry.addRecipe(new DustCrushingRecipe(new ItemStack(ModItems.modDust, 3, Metadata.SAPPHIRE_DUST_SMALL),
                "gemSapphire"));
        GameRegistry.addRecipe(new DustCrushingRecipe(new ItemStack(ModItems.modDust, 3, Metadata.PERIDOT_DUST_SMALL),
                "gemPeridot"));
        GameRegistry.addRecipe(new DustCrushingRecipe(new ItemStack(ModItems.modDust, 3, Metadata.AMETHYST_DUST_SMALL),
                "gemAmethyst"));

        //Gem Dust -> Small Gem Dust
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.dust, 4, Metadata.DIAMOND_DUST_SMALL),
                "dustDiamond"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.modDust, 4, Metadata.RUBY_DUST_SMALL),
                "dustRuby"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.modDust, 4, Metadata.SAPPHIRE_DUST_SMALL),
                "dustSapphire"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.modDust, 4, Metadata.PERIDOT_DUST_SMALL),
                "dustPeridot"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.modDust, 4, Metadata.AMETHYST_DUST_SMALL),
                "dustAmethyst"));

        //Small Gem Dust -> Gem Dust
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.dust, 1, Metadata.DIAMOND_DUST),
                "dustTinyDiamond", "dustTinyDiamond", "dustTinyDiamond", "dustTinyDiamond"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.modDust, 1, Metadata.RUBY_DUST),
                "dustTinyRuby", "dustTinyRuby", "dustTinyRuby", "dustTinyRuby"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.modDust, 1, Metadata.SAPPHIRE_DUST),
                "dustTinySapphire", "dustTinySapphire", "dustTinySapphire", "dustTinySapphire"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.modDust, 1, Metadata.PERIDOT_DUST),
                "dustTinyPeridot", "dustTinyPeridot", "dustTinyPeridot", "dustTinyPeridot"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.modDust, 1, Metadata.AMETHYST_DUST),
                "dustTinyAmethyst", "dustTinyAmethyst", "dustTinyAmethyst", "dustTinyAmethyst"));

        //Aetheric dust
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.dust, 4, 1),
                "dustTinyGem", "dustRedstone", "dustGlowstone", new ItemStack(Items.ghast_tear)));

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

        //Signed Book -> Unsigned Book
        GameRegistry.addRecipe(new UnsignedBookRecipe());
    }

    public static void initOreDict(){
        OreDictionary.registerOre("blockGlassMulticolor", ModBlocks.multiStainedGlass);
        OreDictionary.registerOre("paneGlassMulticolor", ModBlocks.multiStainedGlassPane);

        OreDictionary.registerOre("dustDiamond", new ItemStack(ModItems.dust, 1, Metadata.DIAMOND_DUST));
        OreDictionary.registerOre("dustTinyDiamond", new ItemStack(ModItems.dust, 1, Metadata.DIAMOND_DUST_SMALL));
        OreDictionary.registerOre("dustRuby", new ItemStack(ModItems.modDust, 1, Metadata.RUBY_DUST));
        OreDictionary.registerOre("dustTinyRuby", new ItemStack(ModItems.modDust, 1, Metadata.RUBY_DUST_SMALL));
        OreDictionary.registerOre("dustSapphire", new ItemStack(ModItems.modDust, 1, Metadata.SAPPHIRE_DUST));
        OreDictionary.registerOre("dustTinySapphire", new ItemStack(ModItems.modDust, 1, Metadata.SAPPHIRE_DUST_SMALL));
        OreDictionary.registerOre("dustPeridot", new ItemStack(ModItems.modDust, 1, Metadata.PERIDOT_DUST));
        OreDictionary.registerOre("dustTinyPeridot", new ItemStack(ModItems.modDust, 1, Metadata.PERIDOT_DUST_SMALL));
        OreDictionary.registerOre("dustAmethyst", new ItemStack(ModItems.modDust, 1, Metadata.AMETHYST_DUST));
        OreDictionary.registerOre("dustTinyAmethyst", new ItemStack(ModItems.modDust, 1, Metadata.AMETHYST_DUST_SMALL));

        OreDictionary.registerOre("dustGem", new ItemStack(ModItems.dust, 1, Metadata.DIAMOND_DUST));
        OreDictionary.registerOre("dustGem", new ItemStack(ModItems.modDust, 1, Metadata.RUBY_DUST));
        OreDictionary.registerOre("dustGem", new ItemStack(ModItems.modDust, 1, Metadata.SAPPHIRE_DUST));
        OreDictionary.registerOre("dustGem", new ItemStack(ModItems.modDust, 1, Metadata.PERIDOT_DUST));
        OreDictionary.registerOre("dustGem", new ItemStack(ModItems.modDust, 1, Metadata.AMETHYST_DUST));
        OreDictionary.registerOre("dustTinyGem", new ItemStack(ModItems.dust, 1, Metadata.DIAMOND_DUST_SMALL));
        OreDictionary.registerOre("dustTinyGem", new ItemStack(ModItems.modDust, 1, Metadata.RUBY_DUST_SMALL));
        OreDictionary.registerOre("dustTinyGem", new ItemStack(ModItems.modDust, 1, Metadata.SAPPHIRE_DUST_SMALL));
        OreDictionary.registerOre("dustTinyGem", new ItemStack(ModItems.modDust, 1, Metadata.PERIDOT_DUST_SMALL));
        OreDictionary.registerOre("dustTinyGem", new ItemStack(ModItems.modDust, 1, Metadata.AMETHYST_DUST_SMALL));
    }
}
