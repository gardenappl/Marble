package com.goldenapple.marble;

import com.goldenapple.marble.init.ModBlocks;
import com.goldenapple.marble.init.ModItems;
import com.goldenapple.marble.init.ModRecipes;
import com.goldenapple.marble.reference.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.item.crafting.RecipesArmorDyes;

@Mod(modid = Reference.MOD_ID, version = Reference.VERSION, name = Reference.MOD_NAME)
public class Marble {
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModBlocks.init();
        ModItems.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        ModRecipes.init();
    }
}
