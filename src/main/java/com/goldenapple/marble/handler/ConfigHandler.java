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
    public static int witherOneDropChance;
    public static int witherTwoDropChance;
    public static boolean loadWIP;

    private static final String CATEGORY_ITEMS = "items";
    public static boolean loadPies;
    public static boolean loadFoodVoid;

    private static final String CATEGORY_BLOCKS = "blocks";
    public static boolean loadTallTorch;
    public static boolean loadMulticolorGlass;
    public static boolean loadRope;
    public static boolean loadNull;
    public static boolean loadClayBricks;

    public static void init(File file){
        if(config == null){
            config = new Configuration(file);
            loadConfig();
        }
    }

    public static void loadConfig() {
        witheringID = config.getInt("witheringID", Configuration.CATEGORY_GENERAL, 156, 63, 256, "ID of the Withering enchantment");
        loadWithering = config.getBoolean("loadWithering", Configuration.CATEGORY_GENERAL, true, "Set this to false to disable the Withering enchantment");
        witherOneDropChance = config.getInt("wither1DropChance", Configuration.CATEGORY_GENERAL, 30, 0, 9001, "1 in X chance to get a Withering I book from a Wither Skeleton (set to 0 to disable)");
        witherTwoDropChance = config.getInt("wither2DropChance", Configuration.CATEGORY_GENERAL, 1, 0, 9001, "1 in X chance to get a Withering II book from the Wither (set to 0 to disable)");
        loadWIP = config.getBoolean("loadWIP", Configuration.CATEGORY_GENERAL, false, "Set this to true to enable new stuff that DOESN'T WORK - sorry dor caps");

        loadPies = config.getBoolean("loadPies", CATEGORY_ITEMS, true, "Set this to false to disable the Apple Pie and the Golden Apple Pie");
        loadFoodVoid = config.getBoolean("loadFoodVoid", CATEGORY_ITEMS, true, "Set this to false to disable the Belly Emptinizator Pills 3000");

        loadTallTorch = config.getBoolean("loadTallTorch", CATEGORY_BLOCKS, true, "Set this to false to disable the Tall Torch");
        loadMulticolorGlass = config.getBoolean("loadMulticolorGlass", CATEGORY_BLOCKS, true, "Set this to false to disable Multicolored Stained Glass");
        loadRope = config.getBoolean("loadRope", CATEGORY_BLOCKS, true, "Set this to false to disable Rope and Enchanted Rope");
        loadNull = config.getBoolean("loadNull", CATEGORY_BLOCKS, true, "Set this to false to disable the Null blocks");
        loadClayBricks = config.getBoolean("loadClayBricks", CATEGORY_BLOCKS, true, "Set this to false to disable the Clay Bricks");

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
