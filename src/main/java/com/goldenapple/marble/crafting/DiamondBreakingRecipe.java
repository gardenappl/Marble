package com.goldenapple.marble.crafting;

import com.goldenapple.marble.init.ModItems;
import com.goldenapple.marble.util.OreHelper;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class DiamondBreakingRecipe implements IRecipe {

    @Override
    public boolean matches(InventoryCrafting crafting, World world) {
        boolean pickFound = false;
        boolean diamondFound = false;
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
                }else if(OreHelper.isItemThisOre(stack, "gemDiamond") && !somethingElseFound){ //check if it's a diamond
                    diamondFound = true;
                }else{
                    somethingElseFound = true;
                }
            }
        }

        return pickFound && diamondFound && !somethingElseFound;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting p_77572_1_) {
        return new ItemStack(ModItems.dust, 3, 2);
    }

    @Override
    public int getRecipeSize() {
        return 2;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return new ItemStack(ModItems.dust, 3, 2);
    }
}
