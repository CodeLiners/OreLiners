package org.codeliners.mod.oreliners.ores;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.codeliners.mod.oreliners.OreLiners;
import org.codeliners.mod.oreliners.config.XMLFile;

public class OreArray {
	
	protected static int genAmount = 0;
	protected static int[] oreID;
	protected static String[] oreName;
	protected static int[] oreVeinSize;
	protected static int[] oreSpawnRate;
	protected static int[] oreMaxHeight;
	protected static int[] oreMinHeight;


	
	public static void setArray(){
	
		try {
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(OreLiners.oreXML);
		doc.getDocumentElement().normalize();
	 
		NodeList material = doc.getElementsByTagName("material");
		NodeList gen = doc.getElementsByTagName("Generator");
		NodeList veinsize = doc.getElementsByTagName("veinsize");
		NodeList spawnrate = doc.getElementsByTagName("spawnrate");
		NodeList oreheight = doc.getElementsByTagName("oreheight");
		
		oreID = new int[gen.getLength()];
		oreName = new String[gen.getLength()];
		oreVeinSize = new int[gen.getLength()];
		oreSpawnRate = new int[gen.getLength()];
		oreMaxHeight = new int[gen.getLength()];
		oreMinHeight = new int[gen.getLength()];
	 
		for (int a = 0; a < gen.getLength(); a++) {
			Node genNode = gen.item(a);
			
				Element genElement = (Element) genNode;
				
				Node parentNode = genElement.getParentNode();
				Element  parentElement = (Element) parentNode;
				
				Node veinNode = veinsize.item(a);
				Element  veinElement = (Element) veinNode;
				
				Node spawnrateNode = spawnrate.item(a);
				Element  spawnrateElement = (Element) spawnrateNode;
				
				Node oreheightNode = oreheight.item(a);
				Element  oreheightElement = (Element) oreheightNode;
					
				oreID[a] = Integer.parseInt(parentElement.getAttribute("id"));
				oreName[a] = parentElement.getAttribute("name");
				oreVeinSize[a] = Integer.parseInt(veinElement.getAttribute("max"));
				oreSpawnRate[a] = Integer.parseInt(spawnrateElement.getAttribute("value"));
				oreMaxHeight[a] = Integer.parseInt(oreheightElement.getAttribute("max"));
				oreMinHeight[a] = Integer.parseInt(oreheightElement.getAttribute("min"));
								
	    } 
		
		
		
		}catch (Exception e) {
	    	e.printStackTrace();
	    }
	}

	
	public static int getOreId(int i){
		return oreID[i];
	}
	
	public static int getOreVeinSize(int i){
		return oreVeinSize[i];
	}
	
	public static int getOreSpawnRate(int i){
		return oreSpawnRate[i];
	}
	
	public static int getOreMinHeight(int i){
		return oreMinHeight[i];
	}
	
	public static int getOreMaxHeight(int i){
		return oreMaxHeight[i];
	}
	
	public static int getOreArrayLength(){
		return oreID.length;
	}
	
	public static boolean isOre(int i){
		for (int a = 0; a < oreID.length; a++) {
			if (i == oreID[a]){
				return true;
			}
		}
		return false;
	}
}
