package org.codeliners.mod.oreliners.config;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class OreXML {

	public static void init(File oreXML, FMLPreInitializationEvent event){
		
		try {
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(oreXML);
			doc.getDocumentElement().normalize();
			
		} catch (Exception e) {
			System.out.println("OreConfig not found, creating it!");
			CreateOreXML.CreateOreXML(event);
		}
		
	}
	
}
