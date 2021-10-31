import com.example.examplemod.ExampleMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "Smog", version = "v1")
public class Main {

    @EventHandler
    public void init(FMLInitializationEvent event) {
    	ExampleMod.instance = new ExampleMod();
    	ExampleMod.instance.init();
    }
}
