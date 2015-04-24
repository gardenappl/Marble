package com.goldenapple.marble.handler;

import com.goldenapple.marble.init.ModItems;
import com.goldenapple.marble.reference.Metadata;
import com.goldenapple.marble.util.OreHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public class TooltipHandler {
    @SubscribeEvent
    public void onTooltip(ItemTooltipEvent event){
        if(event.itemStack.getItem().equals(ModItems.dust) && event.itemStack.getItemDamage() == Metadata.DIAMOND_DUST){
            event.toolTip.add(StatCollector.translateToLocal("tooltip.marble.dust"));
        }
        if(event.itemStack.getItem().equals(ModItems.modDust)){
            switch (event.itemStack.getItemDamage()){
                case 0: event.toolTip.add(StatCollector.translateToLocal("tooltip.marble.dust0")); break;
                case 1: event.toolTip.add(StatCollector.translateToLocal("tooltip.marble.dust1")); break;
                case 2: event.toolTip.add(StatCollector.translateToLocal("tooltip.marble.dust2")); break;
                case 3: event.toolTip.add(StatCollector.translateToLocal("tooltip.marble.dust3")); break;
            }
        }
    }
}
