package com.goldenapple.marble;

import com.goldenapple.marble.init.ModBlocks;
import com.goldenapple.marble.init.ModItems;
import com.goldenapple.marble.reference.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = Reference.MOD_ID, version = Reference.VERSION, name = Reference.MOD_NAME)
public class Marble
{
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        ModBlocks.init();
        ModItems.init();
    }
}
