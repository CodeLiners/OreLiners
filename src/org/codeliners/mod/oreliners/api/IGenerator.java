package org.codeliners.mod.oreliners.api;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import org.codeliners.mod.oreliners.api.config.IParserAccess;

import java.util.Map;
import java.util.Random;

public interface IGenerator {
	String getName();
	void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
                  IChunkProvider chunkProvider, Map<String, Map<String, String>> options, IParserAccess parser,
                  ItemStack block);
}
