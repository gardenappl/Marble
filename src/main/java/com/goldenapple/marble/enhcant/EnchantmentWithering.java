package com.goldenapple.marble.enhcant;

import com.goldenapple.marble.reference.Names;
import com.goldenapple.marble.reference.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemStack;

public class EnchantmentWithering extends Enchantment {
    public EnchantmentWithering(int id){
        super(id, 0, EnumEnchantmentType.weapon);
        this.setName(Reference.MOD_ID.toLowerCase() + "." + Names.WITHERING);
    }

    @Override
    public int getMaxLevel(){
        return 3;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack)
    {
        return false;
    }
}
