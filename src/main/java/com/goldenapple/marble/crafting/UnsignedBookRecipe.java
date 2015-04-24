package com.goldenapple.marble.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class UnsignedBookRecipe extends ShapelessOreRecipe {
    public UnsignedBookRecipe(){
        super(new ItemStack(Items.writable_book), new ItemStack(Items.written_book));
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting crafting) {
        for(int slot = 0; slot < crafting.getSizeInventory(); slot++) {
            if(crafting.getStackInSlot(slot) != null){
                if (crafting.getStackInSlot(slot).getItem().equals(Items.written_book)) {
                    ItemStack stack = crafting.getStackInSlot(slot);
                    ItemStack output = getRecipeOutput().copy();
                    if (ItemEditableBook.validBookTagContents(stack.getTagCompound())) {
                        NBTTagList text = stack.getTagCompound().getTagList("pages", 8);
                        output.setTagInfo("pages", text);
                        return output;
                    }
                }
            }
        }
        return getRecipeOutput();
    }
}
