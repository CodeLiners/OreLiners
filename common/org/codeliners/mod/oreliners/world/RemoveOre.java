package org.codeliners.mod.oreliners.world;

import java.util.Random;

import org.codeliners.mod.oreliners.ores.OreArray;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class RemoveOre implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		chunkX = chunkX*16;
		chunkZ = chunkZ*16;
		int chunkY = 1;
		
		for (int a = chunkX; a <= chunkX + 16; a++) {
			for (int b = chunkZ; b <= chunkZ + 16; b++) {
				for (int c = chunkY; c <= 100; c++) {
					if (OreArray.isOre(world.getBlockId(a, c, b))){
					world.setBlock(a, c, b, Block.stone.blockID);
					//System.out.println("Found ore!");
					}
				}
			}
		}
	}

}
