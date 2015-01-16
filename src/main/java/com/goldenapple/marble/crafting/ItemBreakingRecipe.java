package com.goldenapple.marble.crafting;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class ItemBreakingRecipe implements IRecipe {
    private ItemStack pick;
    private Item input;
    private int harvestLevel;
    private String toolClass;

    public ItemBreakingRecipe(String toolClass, int harvestLevel, ItemStack input){
        this.input = input.getItem();
        this.harvestLevel = harvestLevel;
        this.toolClass = toolClass;
    }

    @Override
    public boolean matches(InventoryCrafting inventory, World world) {
        boolean foundPick = false;
        boolean foundInputItem = false; //doing it the Botania way

        for(int i = 0; i < inventory.getSizeInventory(); i++){
            ItemStack itemStack = inventory.getStackInSlot(i);
            if(itemStack != null){
                if(itemStack.getItem().equals(input)){ //if that's the item we need
                    if(!foundInputItem) {
                        foundInputItem = true;
                    }else{ //if we found more than one of the input item
                        return false;
                    }
                }else if(itemStack.getItem().getHarvestLevel(itemStack, toolClass) >= harvestLevel &&
                         itemStack.getItemDamage() <= itemStack.getMaxDamage() - 7){ //if that's a valid tool with enough durability
                    if(!foundPick){
                        foundPick = true;
                        pick = itemStack;
                    }else{ //if we found more than one pick
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }

        return foundInputItem && foundPick;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventory) {
        ItemStack result = pick.copy();
        result.setItemDamage(result.getItemDamage() + 5);
        return result;
    }

    @Override
    public int getRecipeSize() {
        return 10;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return null;
    }
}
