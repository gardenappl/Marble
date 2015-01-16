package com.goldenapple.marble.block;

import com.goldenapple.marble.Marble;
import com.goldenapple.marble.reference.Names;
import com.goldenapple.marble.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;

import static com.goldenapple.marble.reference.Names.MULTI_STAINED_GLASS_PANE;

public class BlockMultiStainedGlassPane extends BlockPane {

    public BlockMultiStainedGlassPane(){
        super(Reference.MOD_ID.toLowerCase() + ":" + Names.MULTI_STAINED_GLASS,
              Reference.MOD_ID.toLowerCase() + ":" + Names.MULTI_STAINED_GLASS_PANE + "_top", Material.glass, false);
        this.setCreativeTab(Marble.MarbleCreativeTab);
        this.setBlockName(MULTI_STAINED_GLASS_PANE);
        this.setStepSound(Block.soundTypeGlass);
        this.setHardness(0.3F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }

    @Override
    public String getUnlocalizedName()
    {
        return "tile." + Reference.MOD_ID.toLowerCase() + ":" + MULTI_STAINED_GLASS_PANE;
    }
}
