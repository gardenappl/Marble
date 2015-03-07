package com.goldenapple.marble.handler;

import com.goldenapple.marble.init.ModItems;
import com.goldenapple.marble.util.OreHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public class TooltipHandler {
    @SubscribeEvent
    public void onTooltip(ItemTooltipEvent event){
        if(OreHelper.isItemThisOre(event.itemStack, "dustTinyGem")){
            event.toolTip.add(StatCollector.translateToLocal("tooltip.marble.dust"));
        }
    }
}
