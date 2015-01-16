package com.goldenapple.marble.init;

import com.goldenapple.marble.block.*;
import com.goldenapple.marble.item.itemblock.ItemRope;
import com.goldenapple.marble.reference.Names;
import com.goldenapple.marble.tileentity.TileEntityRoundRobinBuffer;
import com.goldenapple.marble.tileentity.TileEntityTable;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class ModBlocks {
    public static final Block multiStainedGlass = new BlockMultiStainedGlass();
    public static final Block multiStainedGlassPane = new BlockMultiStainedGlassPane();
    public static final Block tallTorch = new BlockTallTorch();
    public static final Block rope = new BlockRope();
    public static final Block craftingTableQuartz = new BlockCraftingTable(Names.TABLE_QUARTZ, "quartz");
    public static final Block craftingTableCobble = new BlockCraftingTable(Names.TABLE_COBBLE, "cobble");
    public static final Block roundRobinBuffer = new BlockRoundRobinBuffer();

    public static void init(){
        GameRegistry.registerBlock(multiStainedGlassPane, Names.MULTI_STAINED_GLASS_PANE);
        GameRegistry.registerBlock(multiStainedGlass, Names.MULTI_STAINED_GLASS);
        GameRegistry.registerBlock(tallTorch, Names.TALL_TORCH);
        GameRegistry.registerBlock(rope, ItemRope.class, Names.ROPE);
        GameRegistry.registerBlock(craftingTableQuartz, Names.TABLE_QUARTZ);
        GameRegistry.registerBlock(craftingTableCobble, Names.TABLE_COBBLE);
        GameRegistry.registerBlock(roundRobinBuffer, Names.ROUND_ROBIN_BUFFER);

        GameRegistry.registerTileEntity(TileEntityTable.class, Names.TABLE_QUARTZ);
        GameRegistry.registerTileEntity(TileEntityTable.class, Names.TABLE_COBBLE);
        GameRegistry.registerTileEntity(TileEntityRoundRobinBuffer.class, Names.ROUND_ROBIN_BUFFER);
    }
}
