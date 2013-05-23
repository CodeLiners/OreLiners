package org.codeliners.mod.oreliners.world;

import cpw.mods.fml.common.registry.GameRegistry;

public class WorldGen {
	public static void init() {
		GameRegistry.registerWorldGenerator(new RemoveOre());
		GameRegistry.registerWorldGenerator(new GenerateOre());
	}
}
