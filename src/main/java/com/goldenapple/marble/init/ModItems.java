package com.goldenapple.marble.init;

import com.goldenapple.marble.item.TallTorchItem;
import com.goldenapple.marble.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {
    public static final Item tallTorch = new TallTorchItem();

    public static void init(){
        GameRegistry.registerItem(tallTorch, Names.tallTorch);
    }
}
