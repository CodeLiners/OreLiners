package org.codeliners.mod.oreliners;

import java.io.File;

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
import cpw.mods.fml.common.registry.GameRegistry;

@NetworkMod(clientSideRequired = true, serverSideRequired = false)
@Mod(modid = "OreLiners", name = "OreLiners", version = "0.0.1")
public class OreLiners {
	
	@Instance("OreLiners")
	public static OreLiners instance;
	public static File oreXML;

		
	@PreInit
	public void preLoad(FMLPreInitializationEvent event) {

	}

	@Init
	public void load(FMLInitializationEvent event) {

	}
	
	@PostInit
	public void postLoad(FMLPostInitializationEvent event){
		
	}

}
