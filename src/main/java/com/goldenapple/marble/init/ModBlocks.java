package com.goldenapple.marble.init;

import com.goldenapple.marble.block.*;
import com.goldenapple.marble.handler.ConfigHandler;
import com.goldenapple.marble.item.itemblock.ItemBlockMultiMetadata;
import com.goldenapple.marble.item.itemblock.ItemBlockNullUnbreakable;
import com.goldenapple.marble.item.itemblock.ItemRope;
import com.goldenapple.marble.reference.Names;
import com.goldenapple.marble.tileentity.TileEntityRoundRobinBuffer;
import com.goldenapple.marble.tileentity.TileEntityTable;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
    public static final Block multiStainedGlass = new BlockMultiStainedGlass();
    public static final Block multiStainedGlassPane = new BlockMultiStainedGlassPane();
    public static final Block tallTorch = new BlockTallTorch();
    public static final Block rope = new BlockRope();
    public static final Block craftingTableQuartz = new BlockCraftingTable(Names.TABLE_QUARTZ, "quartz");
    public static final Block craftingTableCobble = new BlockCraftingTable(Names.TABLE_COBBLE, "cobble");
    public static final Block roundRobinBuffer = new BlockRoundRobinBuffer();
    public static final Block nullBlock = new BlockCommon(Names.NULL, Material.rock).setHardness(1.5F);
    public static final Block nullBlockUnbreakable = new BlockCommon(Names.NULL, Material.rock).setBlockUnbreakable();
    public static final Block hardenedClayBrick = new BlockCommon(Names.CLAY_BRICK, Material.rock).setStepSound(Block.soundTypePiston).setHardness(1.0F);
    public static final Block stainedClayBrick = new BlockMultiMetadata(Names.STAINED_CLAY_BRICKS, Names.STAINED_CLAY_BRICK, Material.rock).setStepSound(Block.soundTypePiston).setHardness(1.0F);

    public static void init(){
        if(ConfigHandler.loadMulticolorGlass) {
            GameRegistry.registerBlock(multiStainedGlassPane, Names.MULTI_STAINED_GLASS_PANE);
            GameRegistry.registerBlock(multiStainedGlass, Names.MULTI_STAINED_GLASS);
        }
        if(ConfigHandler.loadTallTorch) {
            GameRegistry.registerBlock(tallTorch, Names.TALL_TORCH);
        }
        if(ConfigHandler.loadRope) {
            GameRegistry.registerBlock(rope, ItemRope.class, Names.ROPE);
        }
        if(ConfigHandler.loadWIP) {
            GameRegistry.registerBlock(craftingTableQuartz, Names.TABLE_QUARTZ);
            GameRegistry.registerBlock(craftingTableCobble, Names.TABLE_COBBLE);
            GameRegistry.registerBlock(roundRobinBuffer, Names.ROUND_ROBIN_BUFFER);
        }
        if(ConfigHandler.loadNull) {
            GameRegistry.registerBlock(nullBlock, Names.NULL);
            GameRegistry.registerBlock(nullBlockUnbreakable, ItemBlockNullUnbreakable.class, Names.NULL_UNBREAKABLE);
        }
        if(ConfigHandler.loadClayBricks) {
            GameRegistry.registerBlock(hardenedClayBrick, Names.CLAY_BRICK);
            GameRegistry.registerBlock(stainedClayBrick, ItemBlockMultiMetadata.class, Names.STAINED_CLAY_BRICK);
        }

        GameRegistry.registerTileEntity(TileEntityTable.class, Names.TABLE_QUARTZ);
        GameRegistry.registerTileEntity(TileEntityTable.class, Names.TABLE_COBBLE);
        GameRegistry.registerTileEntity(TileEntityRoundRobinBuffer.class, Names.ROUND_ROBIN_BUFFER);
    }
}
