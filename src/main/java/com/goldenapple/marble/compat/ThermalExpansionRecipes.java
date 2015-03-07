package com.goldenapple.marble.compat;

import com.goldenapple.marble.init.ModItems;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;

public class ThermalExpansionRecipes {


    public static void init(){
                                                           addPulverizerRecipe(2400, OreDictionary.getOres("gemDiamond").get(0), new ItemStack(ModItems.dust), null, 0);
        if(!OreDictionary.getOres("gemRuby").isEmpty())    addPulverizerRecipe(2400, OreDictionary.getOres("gemRuby").get(0), new ItemStack(ModItems.modDust, 1, 0), null, 0);
        if(!OreDictionary.getOres("gemSapphire").isEmpty())addPulverizerRecipe(2400, OreDictionary.getOres("gemSapphire").get(0), new ItemStack(ModItems.modDust, 1, 1), null, 0);
        if(!OreDictionary.getOres("gemPeridot").isEmpty()) addPulverizerRecipe(2400, OreDictionary.getOres("gemPeridot").get(0), new ItemStack(ModItems.modDust, 1, 2), null, 0);
        if(!OreDictionary.getOres("gemAmethyst").isEmpty())addPulverizerRecipe(2400, OreDictionary.getOres("gemAmethyst").get(0), new ItemStack(ModItems.modDust, 1, 3), null, 0);
    }

    //@author CoFH
    private static void addPulverizerRecipe(int energy, ItemStack input, ItemStack primaryOutput, ItemStack secondaryOutput, int secondaryChance) {

        if (input == null || primaryOutput == null) {
            return;
        }
        NBTTagCompound toSend = new NBTTagCompound();

        toSend.setInteger("energy", energy);
        toSend.setTag("input", new NBTTagCompound());
        toSend.setTag("primaryOutput", new NBTTagCompound());

        if (secondaryOutput != null) {
            toSend.setTag("secondaryOutput", new NBTTagCompound());
        }

        input.writeToNBT(toSend.getCompoundTag("input"));
        primaryOutput.writeToNBT(toSend.getCompoundTag("primaryOutput"));

        if (secondaryOutput != null) {
            secondaryOutput.writeToNBT(toSend.getCompoundTag("secondaryOutput"));
            toSend.setInteger("secondaryChance", secondaryChance);
        }

        FMLInterModComms.sendMessage("ThermalExpansion", "PulverizerRecipe", toSend);
    }
}
