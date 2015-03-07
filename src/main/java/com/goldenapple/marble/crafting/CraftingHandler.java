package com.goldenapple.marble.crafting;

import com.goldenapple.marble.init.ModItems;
import com.goldenapple.marble.util.MiscHelper;
import com.goldenapple.marble.util.OreHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class CraftingHandler {
    @SubscribeEvent
    public void onCraft(PlayerEvent.ItemCraftedEvent event){
        ItemStack pickaxe = null;

        if(OreHelper.isItemThisOre(event.crafting, "dustTinyGem")){
            for(int slot = 0; slot < event.craftMatrix.getSizeInventory(); slot++){
                if(event.craftMatrix.getStackInSlot(slot) != null){
                    ItemStack stack = event.craftMatrix.getStackInSlot(slot);
                    if(stack.getItem().getHarvestLevel(stack, "pickaxe") >= 2){
                        if(stack.getItemDamage() < stack.getMaxDamage() - 7){
                            pickaxe = stack.copy();
                        }
                    }
                }
            }
        }
        if(pickaxe != null){
            pickaxe.damageItem(5, event.player);
            if(!event.player.worldObj.isRemote) {
                MiscHelper.drop(event.player, pickaxe, 0);
            }
        }
    }
}
