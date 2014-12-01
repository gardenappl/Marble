package com.goldenapple.marble.init;

import com.goldenapple.marble.block.MultiStainedGlass;
import com.goldenapple.marble.block.MultiStainedGlassPane;
import com.goldenapple.marble.block.Rope;
import com.goldenapple.marble.block.TallTorch;
import com.goldenapple.marble.item.RopeItem;
import com.goldenapple.marble.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ModBlocks {
    public static final Block multiStainedGlass = new MultiStainedGlass();
    public static final Block multiStainedGlassPane = new MultiStainedGlassPane();
    public static final Block tallTorch = new TallTorch();
    public static final Block rope = new Rope();

    public static final ItemBlock ropeItem = new RopeItem(ModBlocks.rope);

    public static void init(){
        GameRegistry.registerBlock(multiStainedGlassPane, Names.multiStainedGlassPane);
        GameRegistry.registerBlock(multiStainedGlass, Names.multiStainedGlass);
        GameRegistry.registerBlock(tallTorch, Names.tallTorch);
        GameRegistry.registerBlock(rope, ropeItem.getClass(), Names.rope);
    }
}
