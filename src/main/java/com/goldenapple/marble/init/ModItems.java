package com.goldenapple.marble.init;

import com.goldenapple.marble.item.MasterSword;
import com.goldenapple.marble.item.TallTorchItem;
import com.goldenapple.marble.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {
    public static final Item tallTorch = new TallTorchItem();
    public static final Item masterSword = new MasterSword();

    public static void init(){
        GameRegistry.registerItem(tallTorch, Names.tallTorch + "_item");
        GameRegistry.registerItem(masterSword, Names.masterSword);
    }
}
