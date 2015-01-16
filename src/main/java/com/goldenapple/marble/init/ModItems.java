package com.goldenapple.marble.init;

import com.goldenapple.marble.item.ItemCommon;
import com.goldenapple.marble.item.ItemDiamondNuggetLump;
import com.goldenapple.marble.item.ItemMultiMetadata;
import com.goldenapple.marble.item.itemblock.ItemTallTorch;
import com.goldenapple.marble.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {
    public static final Item tallTorch = new ItemTallTorch();
    public static final Item dust = new ItemMultiMetadata(Names.DUSTS, Names.DUST);
    public static final Item diamondNugget = new ItemCommon(Names.DIAMOND_NUGGET);
    public static final Item diamondNuggetLump = new ItemDiamondNuggetLump();
    public static final Item arrow = new ItemMultiMetadata(Names.ARROWS, Names.ARROW);

    public static void init(){
        GameRegistry.registerItem(tallTorch, Names.TALL_TORCH + "_item");
        GameRegistry.registerItem(dust, Names.DUST);
        GameRegistry.registerItem(diamondNugget, Names.DIAMOND_NUGGET);
        GameRegistry.registerItem(diamondNuggetLump, Names.DIAMOND_NUGGET_LUMP);
        GameRegistry.registerItem(arrow, Names.ARROW);
    }
}
