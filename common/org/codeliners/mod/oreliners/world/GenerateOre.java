package org.codeliners.mod.oreliners.world;

import java.util.Random;

import org.codeliners.mod.oreliners.ores.OreArray;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class GenerateOre implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if(world.provider.dimensionId != 1 && world.provider.dimensionId != -1){
			generateOre(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		}
		
	}
	
	private void generateOre(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
		for (int a = 0; a < OreArray.getOreArrayLength(); a++){
			
			int oreSpawnRate = (((OreArray.getOreMaxHeight(a)-OreArray.getOreMinHeight(a))*16)*16);
			
			for(int b = 0; b < OreArray.getOreSpawnRate(a); b++){
        	int XCoord = chunkX*16 + rand.nextInt(16);
        	int YCoord = rand.nextInt(OreArray.getOreMaxHeight(a)-OreArray.getOreMinHeight(a))  +OreArray.getOreMinHeight(a);
        	int ZCoord = chunkZ*16 + rand.nextInt(16);
        	
        	if(world.getBlockId(XCoord, YCoord, ZCoord) == Block.stone.blockID){
        		(new WorldGenMinable(OreArray.getOreId(a), OreArray.getOreVeinSize(a))).generate(world, rand, XCoord, YCoord, ZCoord);
        	}
        	
			}
 
		}
	}
}