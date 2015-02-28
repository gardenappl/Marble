package com.goldenapple.marble.handler;

import com.goldenapple.marble.Marble;
import com.goldenapple.marble.gui.ContainerCraftingTable;
import com.goldenapple.marble.gui.GuiCraftingTable;
import com.goldenapple.marble.reference.GuiIDs;
import com.goldenapple.marble.tileentity.TileEntityTable;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case GuiIDs.TABLE:
                TileEntity tileEntity = world.getTileEntity(x, y, z);
                if(tileEntity != null  && tileEntity instanceof TileEntityTable){
                    return new ContainerCraftingTable(player.inventory, (TileEntityTable)tileEntity);
                }
                break;
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID){
            case GuiIDs.TABLE:
                TileEntity tileEntity = world.getTileEntity(x, y, z);
                if(tileEntity != null  && tileEntity instanceof TileEntityTable){
                    return new GuiCraftingTable(player.inventory, (TileEntityTable) tileEntity);
                }
                break;
        }
        return null;
    }
}
