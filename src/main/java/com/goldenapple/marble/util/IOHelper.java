package com.goldenapple.marble.util;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;

public class IOHelper {
    public static boolean insertOneItem(IInventory inventory, ItemStack insertStack, int side){
        insertStack = insertStack.splitStack(1);

        if(inventory instanceof ISidedInventory){ //Sided inventories
            boolean flag = false;

            if(side < 6){
                int[] validSlots = ((ISidedInventory)inventory).getAccessibleSlotsFromSide(side);
                for(int i : validSlots) {
                    if (i == side) {
                        flag = true;
                    }
                }

                if(flag){
                    for(int slot : validSlots){
                        ItemStack stack = inventory.getStackInSlot(slot);
                        if(((ISidedInventory) inventory).canInsertItem(slot, insertStack, side) && inventory.isItemValidForSlot(slot, insertStack)){
                            if(stack.stackSize < stack.getMaxStackSize() && ItemStack.areItemStackTagsEqual(stack, insertStack) && stack.isItemEqual(insertStack)){
                                stack.stackSize++;
                                return true;
                            }
                        }
                    }
                }
            }
        }else{
            for(int slot = 0; slot < inventory.getSizeInventory(); slot++){
                ItemStack stack = inventory.getStackInSlot(slot);
                if(inventory.isItemValidForSlot(slot, insertStack)){
                    if(stack != null && stack.stackSize < stack.getMaxStackSize() && ItemStack.areItemStackTagsEqual(stack, insertStack) && stack.isItemEqual(insertStack)) {
                        stack.stackSize++;
                        return true;
                    }else if(stack == null){
                        inventory.setInventorySlotContents(slot, insertStack);
                    }
                }
            }
        }
    return false;
    }
}
