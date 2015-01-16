package com.goldenapple.marble.gui;

import com.goldenapple.marble.tileentity.TileEntityTable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiCraftingTable extends GuiContainer{
    private static final ResourceLocation texture = new ResourceLocation("textures/gui/container/crafting_table.png"); //Minecraft's workbench GUI
    private static final int TEXT_COLOR = 4210752;

    public GuiCraftingTable(InventoryPlayer inventoryPlayer, TileEntityTable table){
        super(new ContainerCraftingTable(inventoryPlayer, table));
        xSize = 176;
        ySize = 166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1, 1, 1, 1);
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
        FontRenderer fontRender = this.fontRendererObj;
        GL11.glColor4f(1, 1, 1, 1);
        fontRender.drawString("Crafting Table", centerTextXPos("Crafting Table", xSize), 6, TEXT_COLOR, false);
    }

    private int centerTextXPos(String string, int xSize){
        return xSize / 2 - this.fontRendererObj.getStringWidth(string) / 2;
    }
}
