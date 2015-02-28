package com.goldenapple.marble.enhcant;

import com.goldenapple.marble.Marble;
import com.goldenapple.marble.handler.ConfigHandler;
import com.goldenapple.marble.util.MiscHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.init.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class WitheringHandler {

    @SubscribeEvent
    public void onEntityHurt(LivingAttackEvent event){
        if(event.source.getEntity() == null || !(event.source.getEntity() instanceof EntityLivingBase)){
            return;
        }

        EntityLivingBase attacker = (EntityLivingBase)event.source.getEntity();
        int witheringLevel = EnchantmentHelper.getEnchantmentLevel(ConfigHandler.witheringID, attacker.getHeldItem());

        if(witheringLevel != 0 && Marble.rand.nextInt(10) > 4) {
            event.entityLiving.addPotionEffect(new PotionEffect(Potion.wither.getId(), 60, witheringLevel));
        }
    }

    @SubscribeEvent
    public void onEntityKill(LivingDropsEvent event){
        if(event.entityLiving instanceof EntitySkeleton){
            if(((EntitySkeleton) event.entityLiving).getSkeletonType() == 1){
                if(Math.round(Marble.rand.nextFloat() * 100) < ConfigHandler.witherOneDropChance){
                    MiscHelper.drop(event, Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(ConfigHandler.witheringID, 1)));
                }
            }
        }

        if(event.entityLiving instanceof EntityWither){
            if(Math.round(Marble.rand.nextInt()) < ConfigHandler.witherTwoDropChance){
                MiscHelper.drop(event, Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(ConfigHandler.witheringID, 2)));
            }
        }
    }
}
