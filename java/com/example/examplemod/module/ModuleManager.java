package com.example.examplemod.module;

import java.util.ArrayList;

import com.example.examplemod.module.combat.Autoclicker;
import com.example.examplemod.module.combat.Velocity;
import com.example.examplemod.module.misc.AntiBot;
import com.example.examplemod.module.movement.SpeedBridge;
import com.example.examplemod.module.movement.Sprint;
import com.example.examplemod.module.render.ClickGUI;
import com.example.examplemod.module.render.HUD;

public class ModuleManager {

	public ArrayList<Module> modules;
	
	public ModuleManager() {
		(modules = new ArrayList<Module>()).clear();
		this.modules.add(new ClickGUI());
		this.modules.add(new SpeedBridge());
		this.modules.add(new HUD());
		this.modules.add(new Sprint());
		this.modules.add(new Autoclicker());
		this.modules.add(new Velocity());
		this.modules.add(new AntiBot());
	}
	
	public Module getModule(String name) {
		for (Module m : this.modules) {
			if (m.getName().equalsIgnoreCase(name)) {
				return m;
			}
		}
		return null;
	}
	
	public ArrayList<Module> getModuleList() {
		return this.modules;
	}
	
	public ArrayList<Module> getModulesInCategory(Category c) {
		ArrayList<Module> mods = new ArrayList<Module>();
		for (Module m : this.modules) {
			if (m.getCategory() == c) {
				mods.add(m);
			}
		}
		return mods;
	}
}
