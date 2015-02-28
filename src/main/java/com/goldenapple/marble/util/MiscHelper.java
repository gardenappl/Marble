package com.goldenapple.marble.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class MiscHelper {
    //@author SpitefulFox
    public static void drop(LivingDropsEvent event, ItemStack drop) {
        EntityItem entityitem = new EntityItem(event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, drop);
        entityitem.delayBeforeCanPickup = 10;
        event.drops.add(entityitem);
    }

    public static void drop(Entity entity, ItemStack drop){
        drop(entity, drop, 10);
    }

    public static void drop(Entity entity, ItemStack drop, int delay){
        EntityItem entityItem = new EntityItem(entity.worldObj, entity.posX, entity.posY, entity.posZ, drop);
        entityItem.delayBeforeCanPickup = delay;
        entity.worldObj.spawnEntityInWorld(entityItem);
    }
}
