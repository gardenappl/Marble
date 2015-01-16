package com.goldenapple.marble.enhcant;

import com.goldenapple.marble.Marble;
import com.goldenapple.marble.handler.ConfigHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

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
}
