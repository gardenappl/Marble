package com.goldenapple.marble.crafting;

import com.goldenapple.marble.util.MiscHelper;
import com.goldenapple.marble.util.OreHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class CraftingHandler {
    @SubscribeEvent
    public void onCraft(PlayerEvent.ItemCraftedEvent event){
        boolean pickFound = false;
        boolean diamondFound = false;
        boolean somethingElseFound = false;
        ItemStack pickaxe = null;
        int pickaxeSlot = -1;

        for(int i = 0; i < event.craftMatrix.getSizeInventory(); i++){
            if(event.craftMatrix.getStackInSlot(i) != null) {   //if there's an item
                ItemStack stack = event.craftMatrix.getStackInSlot(i);

                if (stack.getItem() instanceof ItemPickaxe && !somethingElseFound){ //check if it's a valid pickaxe
                    if(stack.getItem().getHarvestLevel(stack, "pickaxe") >= 2){
                        if(stack.getItemDamage() < stack.getMaxDamage() - 7){
                            pickFound = true;
                            pickaxe = stack;
                            pickaxeSlot = i;
                        }
                    }
                }else if(OreHelper.isItemThisOre(stack, "gemDiamond") && !somethingElseFound){ //check if it's a diamond
                    diamondFound = true;
                }else{
                    somethingElseFound = true;
                }
            }
        }

        if(pickFound && diamondFound && !somethingElseFound && pickaxe != null){
            pickaxe.setItemDamage(pickaxe.getItemDamage() + 5);
            if(!event.player.worldObj.isRemote) {
                MiscHelper.drop(event.player, pickaxe, 2);
            }
        }
    }
}
