package org.codeliners.mod.oreliners.generators;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import org.codeliners.mod.oreliners.api.IGenerator;
import org.w3c.dom.Element;

import java.util.Map;
import java.util.Random;

public class Vanilla implements IGenerator{

	@Override
	public String getName() {
		return "Vanilla";
	}

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider, Map<String, Map<String, String>> options) {
    }

}
