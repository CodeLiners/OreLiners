package org.codeliners.mod.oreliners.generators;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import org.codeliners.mod.oreliners.api.IGenerator;
import org.codeliners.mod.oreliners.api.config.IParserAccess;
import org.w3c.dom.Element;

import java.util.Map;
import java.util.Random;

public class Vanilla implements IGenerator{

	@Override
	public String getName() {
		return "Vanilla";
	}

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider, Map<String, Map<String, String>> options,
    		IParserAccess parser, ItemStack block) {
    
    	int minheight = Integer.parseInt(options.get("oreheight").get("min"));
    	int maxheight = Integer.parseInt(options.get("oreheight").get("max"));
    	int veinsize = Integer.parseInt(options.get("veinsize").get("max"));
    	int spawnratepercent = Integer.parseInt(options.get("spawnrate").get("value"));
    	int blockID = block.itemID;
    	int blockMeta = block.getItemDamage();
    	
    		int spawnrate = ((((((maxheight-minheight)*16)*16)/100)*spawnratepercent)/veinsize);
    		
    		for(int a = 0; a < spawnrate; a++){
    			int XCoord = chunkX*16 + random.nextInt(16);
            	int YCoord = random.nextInt(maxheight-minheight)+minheight;
            	int ZCoord = chunkZ*16 + random.nextInt(16);
            	
            	if(world.getBlockId(XCoord, YCoord, ZCoord) == Block.stone.blockID){
            		(new WorldGenMinable(blockID, blockMeta, veinsize)).generate(world, random, XCoord, YCoord, ZCoord);
            	}

    		}
    		
    }
}
