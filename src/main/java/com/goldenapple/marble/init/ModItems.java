package com.goldenapple.marble.init;

import com.goldenapple.marble.handler.ConfigHandler;
import com.goldenapple.marble.item.ItemFoodCommon;
import com.goldenapple.marble.item.ItemFoodVoid;
import com.goldenapple.marble.item.ItemGoldApplePie;
import com.goldenapple.marble.item.ItemMultiMetadata;
import com.goldenapple.marble.item.itemblock.ItemTallTorch;
import com.goldenapple.marble.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {
    public static final Item tallTorch = new ItemTallTorch();
    public static final Item dust = new ItemMultiMetadata(Names.DUSTS, Names.DUST);
    public static final Item applePie = new ItemFoodCommon(Names.APPLE_PIE, 6, 0.6F);
    public static final Item goldenApplePie = new ItemGoldApplePie();
    public static final Item bellyEmptinizator = new ItemFoodVoid();

    public static void init(){
        if(ConfigHandler.loadTallTorch){
            GameRegistry.registerItem(tallTorch, Names.TALL_TORCH + "_item");
        }
        if(ConfigHandler.loadRope || ConfigHandler.loadMulticolorGlass) {
            GameRegistry.registerItem(dust, Names.DUST);
        }
        if(ConfigHandler.loadPies) {
            GameRegistry.registerItem(applePie, Names.APPLE_PIE);
            GameRegistry.registerItem(goldenApplePie, Names.GOLDEN_APPLE_PIE);
        }
        if(ConfigHandler.loadFoodVoid) {
            GameRegistry.registerItem(bellyEmptinizator, Names.FOOD_VOID);
        }
    }
}
