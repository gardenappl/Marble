package com.goldenapple.marble;

import com.goldenapple.marble.compat.ThermalExpansionRecipes;
import com.goldenapple.marble.crafting.CraftingHandler;
import com.goldenapple.marble.enhcant.EnchantmentWithering;
import com.goldenapple.marble.enhcant.WitheringHandler;
import com.goldenapple.marble.handler.ConfigHandler;
import com.goldenapple.marble.handler.GuiHandler;
import com.goldenapple.marble.handler.TooltipHandler;
import com.goldenapple.marble.init.ModBlocks;
import com.goldenapple.marble.init.ModItems;
import com.goldenapple.marble.init.ModRecipes;
import com.goldenapple.marble.reference.Reference;
import com.goldenapple.marble.util.OreHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

import java.util.List;
import java.util.Random;

@Mod(modid = Reference.MOD_ID, version = Reference.VERSION, name = Reference.MOD_NAME)
public class Marble {

    public static final CreativeTabs MarbleCreativeTab = new CreativeTabs(Reference.MOD_ID.toLowerCase()) {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(ModBlocks.multiStainedGlass);
        }

        @Override
        @SuppressWarnings({"unchecked"})
        public void displayAllReleventItems(List list){
            super.displayAllReleventItems(list);
            for(int level = 1; level <= 3; level++){
                list.add(Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(ConfigHandler.witheringID, level)));
            }
        }
    };

    public static Random rand = new Random(); //a shared instance of Random for the whole mod. I don't know why I'm so paranoid about it

    @Mod.Instance
    public static Marble instance;

    @SidedProxy(serverSide = Reference.SERVER_PROXY, clientSide = Reference.CLIENT_PROXY)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ConfigHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigHandler());
        FMLCommonHandler.instance().bus().register(new CraftingHandler());
        MinecraftForge.EVENT_BUS.register(new TooltipHandler());

        if(ConfigHandler.loadWithering){
            Enchantment Withering = new EnchantmentWithering(ConfigHandler.witheringID);
            MinecraftForge.EVENT_BUS.register(new WitheringHandler());
        }

        ModBlocks.init();
        ModItems.init();
        ModRecipes.initOreDict();

        proxy.initRenderers();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        ModRecipes.init();
        ThermalExpansionRecipes.init();

        NetworkRegistry.INSTANCE.registerGuiHandler(Marble.instance, new GuiHandler());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
    }
}
