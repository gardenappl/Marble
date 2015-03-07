package com.goldenapple.marble.crafting;

import com.goldenapple.marble.init.ModItems;
import com.goldenapple.marble.util.OreHelper;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class ItemBreakingRecipe implements IRecipe {
    private ItemStack output;
    private String ore;

    public ItemBreakingRecipe(ItemStack ouptut, String recipe){
        this.output = ouptut;
        this.ore = recipe;
    }

    @Override
    public boolean matches(InventoryCrafting crafting, World world) {
        boolean pickFound = false;
        boolean gemFound = false;
        boolean somethingElseFound = false;

        for(int i = 0; i < crafting.getSizeInventory(); i++){
            if(crafting.getStackInSlot(i) != null) {   //if there's an item
                ItemStack stack = crafting.getStackInSlot(i);

                if (stack.getItem() instanceof ItemPickaxe && !somethingElseFound){ //check if it's a valid pickaxe
                    if(stack.getItem().getHarvestLevel(stack, "pickaxe") >= 2){
                        if(stack.getItemDamage() < stack.getMaxDamage() - 7){
                            pickFound = true;
                        }
                    }
                }else if(OreHelper.isItemThisOre(stack, ore) && !somethingElseFound){ //check if it's a gem
                    gemFound = true;
                }else{
                    somethingElseFound = true;
                }
            }
        }

        return pickFound && gemFound && !somethingElseFound;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting p_77572_1_) {
        return output.copy();
    }

    @Override
    public int getRecipeSize() {
        return 2;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return output.copy();
    }
}
