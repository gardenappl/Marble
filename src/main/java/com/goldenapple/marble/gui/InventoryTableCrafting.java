package com.goldenapple.marble.gui;

import com.goldenapple.marble.tileentity.TileEntityTable;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;

public class InventoryTableCrafting extends InventoryCrafting{
    TileEntityTable tileEntityTable;

    public InventoryTableCrafting(Container container, TileEntityTable table) {
        super(container, 3, 3);
        tileEntityTable = table;
    }

    @Override
    public int getSizeInventory() {
        return 9;
    }

    @Override
    public ItemStack getStackInRowAndColumn(int row, int column) {
        return tileEntityTable.getStackInSlot(column + row * 3);
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
        return null;
    }


}
