package com.example.examplemod.module.render;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.module.Category;
import com.example.examplemod.module.Module;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HUD extends Module{
	
	public HUD() {
		super("HUD","Display enabled modules",Category.RENDER);
	}
	
	@SubscribeEvent
	public void onRender(RenderGameOverlayEvent egoe) {
		if(!egoe.type.equals(egoe.type.CROSSHAIRS)) {
			return;
		}
		
		ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
		int y = 2;
		for (Module mod : ExampleMod.instance.moduleManager.getModuleList()) {
			if (!mod.getName().equalsIgnoreCase("HUD") && mod.isToggled() && mod.visible) {
				FontRenderer fr = Minecraft.getMinecraft().fontRendererObj;
				fr.drawString(mod.getName(), sr.getScaledWidth() - fr.getStringWidth(mod.getName())-1, y, 0xFFFFFF );
				y+=fr.FONT_HEIGHT;
			}
		}
		
	}

}
