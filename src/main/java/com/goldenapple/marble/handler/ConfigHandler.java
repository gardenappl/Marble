package com.goldenapple.marble.handler;

import com.goldenapple.marble.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {
    private static Configuration config;

    public static int witheringID;
    public static boolean loadWithering;
    public static boolean dumpAllOres;

    public static void init(File file){
        if(config == null){
            config = new Configuration(file);
            loadConfig();
        }
    }

    public static void loadConfig() {
        witheringID = config.getInt("witheringID", Configuration.CATEGORY_GENERAL, 156, 63, 256, "ID of the Withering enchantment");
        loadWithering = config.getBoolean("loadWithering", Configuration.CATEGORY_GENERAL, true, "Set this to false to disable the Withering enchantment");
        dumpAllOres = config.getBoolean("dumpAllOres", Configuration.CATEGORY_GENERAL, false, "Set this to true to log every OreDictionary ore");

        if (config.hasChanged()) {
            config.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID)){
            loadConfig();
        }
    }
}
