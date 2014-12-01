package com.goldenapple.marble.item;

import com.goldenapple.marble.creativetab.MarbleCreativeTab;
import com.goldenapple.marble.reference.Names;
import com.goldenapple.marble.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class MasterSword extends ItemSword{
    private IIcon chargeIcon;
    public MasterSword(){
        super(EnumHelper.addToolMaterial("MASTER", 3, 3000, 8.0F, 10.0F, 10));
        setCreativeTab(MarbleCreativeTab.MarbleTab);
        setUnlocalizedName(Names.masterSword);
    }
    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        if(player.isSneaking()){
            stack.setItemDamage(1);
        }else{
            stack.setItemDamage(0);
        }
        super.onItemRightClick(stack, world, player);
        return stack;
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int itemInUseCount) {
        stack.setItemDamage(0);
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return stack.getItemDamage() == 0 ? EnumAction.block : EnumAction.bow;
    }

    @Override //Because the super class method would damage the sword and I don't want that
    public boolean hitEntity(ItemStack stack, EntityLivingBase entity1, EntityLivingBase entity2)
    {
        return true;
    }

    @Override //Same reason
    public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase entity){
        return true;
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack){
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining){
        if(stack.getItemDamage() == 0){
            return itemIcon;
        }
        return chargeIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + Names.masterSword);
        chargeIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + Names.masterSword + "_charge");
    }

    //Stolen from Pahimar ;) https://github.com/pahimar/LetsModReboot
    @Override
    public String getUnlocalizedName() {
        return "item." + Reference.MOD_ID.toLowerCase() + ":" + getUnwrappedUnlocalizedName(super.getUnlocalizedName());
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack){
        return "item." + Reference.MOD_ID.toLowerCase() + ":" + getUnwrappedUnlocalizedName(super.getUnlocalizedName());
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
