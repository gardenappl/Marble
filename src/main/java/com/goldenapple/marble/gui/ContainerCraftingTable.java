package com.goldenapple.marble.gui;

import com.goldenapple.marble.tileentity.TileEntityTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;

public class ContainerCraftingTable extends Container {
    private TileEntityTable table;
    private InventoryCrafting craftMatrix;
    private InventoryCraftResult craftResult;

    public ContainerCraftingTable(InventoryPlayer inventoryPlayer, TileEntityTable tileEntity){
        table = tileEntity;

        for (int x = 0; x < 9; x++){ //Player's hotbar
            addSlotToContainer(new Slot(inventoryPlayer, x, 8 + 18 * x, 142));
        }

        for (int x = 0; x < 9; x++) { //Player's inventory
            for(int y = 0; y < 3; y++){
                addSlotToContainer(new Slot(inventoryPlayer, 9 + x + y * 9, 8 + 18 * x, 84 + 18 * y));
            }
        }

        for (int x = 0; x < 3; x++) { //Actual table's inventory
            for (int y = 0; y < 3; y++) {
                addSlotToContainer(new Slot(table, x + y * 3, 30 + 18 * x, 17 + 18 * y));
            }
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return table.isUseableByPlayer(player);
    }
}
