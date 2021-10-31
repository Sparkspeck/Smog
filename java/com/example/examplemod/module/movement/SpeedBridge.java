package com.example.examplemod.module.movement;

import org.lwjgl.input.Keyboard;



import com.example.examplemod.ExampleMod;
import com.example.examplemod.module.Category;
import com.example.examplemod.module.Module;

public class SpeedBridge extends Module {
	
	public SpeedBridge() {
		super("Speed Bridge", "Helps to bridge faster", Category.MOVEMENT);
		this.setKey(Keyboard.KEY_B);	
	}
	
}



