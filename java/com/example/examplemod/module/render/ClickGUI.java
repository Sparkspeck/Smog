package com.example.examplemod.module.render;

import org.lwjgl.input.Keyboard;


import com.example.examplemod.ExampleMod;
import com.example.examplemod.module.Category;
import com.example.examplemod.module.Module;

public class ClickGUI extends Module {

	public ClickGUI() {
		super("ClickGUI", "Allows you to enable and disable modules", Category.RENDER);
		this.setKey(Keyboard.KEY_RSHIFT);
	}
	
	@Override
	public void onEnable() {
		super.onEnable();
		mc.displayGuiScreen(ExampleMod.instance.clickGui);
		this.setToggled(false);
	}
}
