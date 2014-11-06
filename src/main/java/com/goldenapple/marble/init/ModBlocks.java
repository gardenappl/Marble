package com.goldenapple.marble.init;

import com.goldenapple.marble.block.GlassPaneMulticolor;
import com.goldenapple.marble.block.TallTorchBottom;
import com.goldenapple.marble.block.TallTorchTop;
import com.goldenapple.marble.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class ModBlocks {
    public static final Block glassPaneMulticolor = new GlassPaneMulticolor();
    public static final Block tallTorchTop = new TallTorchTop();
    public static final Block tallTorchBottom = new TallTorchBottom();

    public static void init(){
        GameRegistry.registerBlock(glassPaneMulticolor, Names.glassPaneMulticolor);
        GameRegistry.registerBlock(tallTorchTop, Names.tallTorchTop);
        GameRegistry.registerBlock(tallTorchBottom, Names.tallTorchBottom);
    }
}
