package com.goldenapple.marble.item;

import com.goldenapple.marble.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class ItemFoodVoid extends ItemFoodCommon {
    public ItemFoodVoid(){
        super(Names.FOOD_VOID, 0, 0);
        this.setAlwaysEdible();
    }

    @Override
    protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player) {
        if(!world.isRemote){
            player.getFoodStats().setFoodLevel(player.getFoodStats().getFoodLevel() - 2);
            player.getFoodStats().setFoodSaturationLevel(0);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean wat) {
        list.add(StatCollector.translateToLocal("tooltip.marble.creative"));
        list.add(StatCollector.translateToLocal("tooltip.marble.food_void"));
    }
}
