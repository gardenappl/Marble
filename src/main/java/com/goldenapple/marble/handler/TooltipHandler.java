package com.goldenapple.marble.handler;

import com.goldenapple.marble.init.ModItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public class TooltipHandler {
    @SubscribeEvent
    public void onTooltip(ItemTooltipEvent event){
        if(event.itemStack.getItem() == ModItems.dust && event.itemStack.getItemDamage() == 2){
            event.toolTip.add(StatCollector.translateToLocal("tooltip.marble.dust"));
        }
    }
}
