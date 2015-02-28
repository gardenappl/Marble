package com.goldenapple.marble.tileentity;

import com.goldenapple.marble.block.BlockRoundRobinBuffer;
import com.goldenapple.marble.util.BlockPos;
import com.goldenapple.marble.util.DirectionHelper;
import com.goldenapple.marble.util.IOHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityRoundRobinBuffer extends TileEntity implements ISidedInventory {
    private ItemStack[] inventory = new ItemStack[6];
    public int outputSide = 0;
    public int inputSide = 1;
    private final int cooldown = 50;
    private int timer = 0;

    @Override
    public void updateEntity() {
        timer++;
        inputSide = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);

        if(!(blockType instanceof BlockRoundRobinBuffer)){ //should never happen
            this.invalidate();
        }
        if(inputSide >= 6){
            inputSide = 0; //should never happen though
            worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 0, 2);
        }
        if(timer == cooldown){ //switch output sides and insert
            /*int[] validOutputs = getValidOutputSides();
            for(int side : validOutputs){
                if(side == outputSide){
                    if(outputSide != validOutputs[5]){
                        outputSide = validOutputs[]
                    }
                }
            }*/
            BlockPos adjacentBlock = DirectionHelper.getAdjacentBlockPos(xCoord, yCoord, zCoord, outputSide);
            TileEntity adjacentTE = worldObj.getTileEntity(adjacentBlock.x, adjacentBlock.y, adjacentBlock.z);
            if(adjacentTE != null && adjacentTE instanceof IInventory) {
                for(ItemStack itemStack : inventory) {
                    if(itemStack != null) {
                        IOHelper.insertOneItem((IInventory) adjacentTE, inventory[0], outputSide);
                        break;
                    }
                }
            }
        }
    }

    private int[] getValidOutputSides(){
        switch (inputSide){
            case 0: return new int[]{1, 2, 3, 4, 5};
            case 1: return new int[]{0, 2, 3, 4, 5};
            case 2: return new int[]{0, 1, 3, 4, 5};
            case 3: return new int[]{0, 1, 2, 4, 5};
            case 4: return new int[]{0, 1, 2, 3, 5};
            case 5: return new int[]{0, 1, 2, 3, 4};
            default: return null;
        }
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        return side == inputSide ? new int[]{0, 1, 2, 3, 4, 5} : new int[]{};
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack itemStack, int side) {
        return side == inputSide;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack itemStack, int side) {
        return side == outputSide;
    }

    @Override
    public int getSizeInventory() {
        return 6;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return slot < inventory.length ? inventory[slot] : null;
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        ItemStack itemStack = this.getStackInSlot(slot);

        if(itemStack.stackSize <= amount){
            this.setInventorySlotContents(slot, null);
        }else{
            itemStack = itemStack.splitStack(amount);
        }

        return itemStack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        ItemStack itemStack = this.getStackInSlot(slot);
        this.setInventorySlotContents(slot, null);
        return itemStack;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack) {
        if(slot <= inventory.length) inventory[slot] = itemStack;
    }

    @Override
    public String getInventoryName() {
        return blockType.getUnlocalizedName();
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return player.getDistanceSq(xCoord, yCoord, zCoord) <= Math.sqrt(8);
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
        return true;
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);

    }
}
