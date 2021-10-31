package com.example.examplemod.module.combat;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.module.Category;
import com.example.examplemod.module.Module;
import com.example.examplemod.settings.Setting;

import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Velocity extends Module {
	public Velocity() {
		super("Velocity", "Reduces knockback", Category.COMBAT);
		ExampleMod.instance.settingsManager.rSetting(new Setting("Horizontal", this, 90, 0, 100, true));
		ExampleMod.instance.settingsManager.rSetting(new Setting("Vertical", this, 100, 0, 100, true));
	}
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent e) {
		
		if(mc.thePlayer != null && mc.theWorld!=null && mc.thePlayer.hurtTime == mc.thePlayer.maxHurtTime && mc.thePlayer.hurtTime>0) {
			float horizontal = (float) ExampleMod.instance.settingsManager.getSettingByName(this, "Horizontal").getValDouble();
			float vertical = (float) ExampleMod.instance.settingsManager.getSettingByName(this, "Vertical").getValDouble();
			
			mc.thePlayer.motionX *= horizontal/100.0D;
			mc.thePlayer.motionZ *= horizontal/100.0D;
			mc.thePlayer.motionY *= vertical/100.0D;			
		}
	}
}
							
			
			
		
		
		

	
	


