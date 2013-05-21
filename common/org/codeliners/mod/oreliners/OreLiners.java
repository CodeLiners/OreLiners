package org.codeliners.mod.oreliners;

import org.codeliners.mod.oreliners.config.OreConfiguration;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod(modid = "OreLiners", name = "OreLiners", version = "0.0.1")
public class OreLiners {
	
	@Instance("OreLiners")
	public static OreLiners instance;
		
	@PreInit
	public void preLoad(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		OreConfiguration.init(config);
	}

	@Init
	public void load(FMLInitializationEvent event) {
		
	}
	
	@PostInit
	public void postLoad(FMLPostInitializationEvent event){

	}

}
