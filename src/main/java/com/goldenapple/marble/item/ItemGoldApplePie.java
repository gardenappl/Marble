package com.goldenapple.marble.item;

import com.goldenapple.marble.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemGoldApplePie extends ItemFoodCommon {
    public ItemGoldApplePie(){
        super(Names.GOLDEN_APPLE_PIE, 6, 2.4F);
        this.setHasSubtypes(true);
    }

    @Override
    public boolean hasEffect(ItemStack itemStack, int pass) {
        return true;
    }

    @Override
    public EnumRarity getRarity(ItemStack itemStack) {
        return EnumRarity.epic;
    }

    @Override
    protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            player.addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 2400, 0)); //Absorption
            player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 600, 4));
            player.addPotionEffect(new PotionEffect(Potion.resistance.id, 6000, 0));
            player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 6000, 0));
        }
    }
}
