package com.example.examplemod.module.combat;

import org.lwjgl.input.Mouse;



import com.example.examplemod.ExampleMod;
import com.example.examplemod.module.Category;
import com.example.examplemod.module.Module;
import com.example.examplemod.settings.Setting;

import io.netty.util.internal.ThreadLocalRandom;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraft.item.*;

public class Autoclicker extends Module{
	
	private long lastClick;
	private long hold;
	
	private double speed;
	private double holdLength;
	private double min;
	private double max;
		
	public Autoclicker() {
		super("Autoclicker", "Auto clicks", Category.COMBAT);
		ExampleMod.instance.settingsManager.rSetting(new Setting("MinCPS",this, 11, 1, 20,false));
		ExampleMod.instance.settingsManager.rSetting(new Setting("MaxCPS",this, 14, 1, 20,false));
	}
	
	
	
	@SubscribeEvent
	
	public void onTick(TickEvent.RenderTickEvent e) {
		if (Mouse.isButtonDown(0)) {
			if(System.currentTimeMillis() - lastClick > speed*1000) {
				lastClick = System.currentTimeMillis();
				if (hold < lastClick) {
					hold = lastClick;
				}
				int key = mc.gameSettings.keyBindAttack.getKeyCode();
				KeyBinding.setKeyBindState(key, true);
				KeyBinding.onTick(key);
				this.updateVals();
			}else if(System.currentTimeMillis() - hold > holdLength * 1000) {
				KeyBinding.setKeyBindState(mc.gameSettings.keyBindAttack.getKeyCode(),false);
				this.updateVals();
			}
		}
	}
	
	
	@Override
	public void onEnable() {
		super.onEnable();
		this.updateVals();
	}
	
	private void updateVals() {
		min = ExampleMod.instance.settingsManager.getSettingByName(this,"MinCPS").getValDouble();
		max = ExampleMod.instance.settingsManager.getSettingByName(this,"MaxCPS").getValDouble();
		
		if (min >= max) {
			max = min + 1;
		}
		
		speed = 1.0/ThreadLocalRandom.current().nextDouble(min - 0.2,max);
		holdLength = speed/ThreadLocalRandom.current().nextDouble(min,max);
		
	}
	
}
	