package org.codeliners.mod.oreliners.config;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import net.minecraft.block.Block;

import org.codeliners.mod.oreliners.OreLiners;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CreateOreXML {
	
	protected static String[] ores = {"Iron", "Diamond", "Gold", "Coal", "Redstone", "Emerald"};
	protected static int[] oresId = {Block.oreIron.blockID, Block.oreDiamond.blockID, Block.oreGold.blockID, Block.oreCoal.blockID, Block.oreRedstone.blockID, Block.oreEmerald.blockID};
	protected static int[] oreSpawnRate = {40, 4, 7, 50, 10, 30};
	protected static int[] oreMaxHeight = {63, 15, 30, 63, 25, 50};
	protected static int[] oreMinHeight = {1, 1, 1, 1, 1, 1};
	protected static int[] oreMaxVeinSize = {6,6,6,6,6,2};
	
	public static void CreateOreXML(FMLPreInitializationEvent event) {
		
		boolean success = (new File(event.getModConfigurationDirectory(), "OreLiners/").mkdirs());
		if (!success) {
		    System.out.println("OreLiners directory failed to be created.");
		}
		
		try {
			 
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	 
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("OreLiners");
			doc.appendChild(rootElement);
			
			for (int a = 0; a < ores.length; a++){
				
			Element material = doc.createElement("material");
			rootElement.appendChild(material);
			material.setAttribute("name", ores[a]);
			material.setAttribute("id", String.valueOf(oresId[a]));
				
			// Generator elements
			Element gen = doc.createElement("Generator");
			material.appendChild(gen);
			gen.setAttribute("type", "vanilla");
	 
			// veinsize elements
			Element veinsize = doc.createElement("veinsize");
			gen.appendChild(veinsize);
			veinsize.setAttribute("max", String.valueOf(oreMaxVeinSize[a]));
			
			// spawnrate elements
			Element spawnrate = doc.createElement("spawnrate");
			gen.appendChild(spawnrate);
			spawnrate.setAttribute("value", String.valueOf(oreSpawnRate[a]));	
			
			// oreheight elements
			Element oreheight = doc.createElement("oreheight");
			gen.appendChild(oreheight);
			oreheight.setAttribute("min", String.valueOf(oreMinHeight[a]));
			oreheight.setAttribute("max", String.valueOf(oreMaxHeight[a]));

			
			}
			
			
	 
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(OreLiners.oreXML);
	 
			// Output to console for testing
			//StreamResult result = new StreamResult(System.out);
	 
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			transformer.transform(source, result);
	 
			System.out.println("File saved!");
	 
		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
	}

}
