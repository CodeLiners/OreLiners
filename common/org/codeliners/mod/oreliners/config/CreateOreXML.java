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

import org.codeliners.mod.oreliners.OreLiners;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CreateOreXML {
	
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
			Element rootElement = doc.createElement("Ores");
			doc.appendChild(rootElement);
	 
			// Ore elements
			Element ore = doc.createElement("Ore");
			rootElement.appendChild(ore);
	 
			// OreName elements
			Element OreName = doc.createElement("OreName");
			OreName.appendChild(doc.createTextNode("Iron"));
			ore.appendChild(OreName);
	 
			// OreID elements
			Element OreID = doc.createElement("OreID");
			OreID.appendChild(doc.createTextNode("15"));
			ore.appendChild(OreID);
	 
			// SpawnRatePerChunk elements
			Element SpawnRatePerChunk = doc.createElement("SpawnRatePerChunk");
			SpawnRatePerChunk.appendChild(doc.createTextNode("20"));
			ore.appendChild(SpawnRatePerChunk);
	 
			// MaxSpawnHeight elements
			Element MaxSpawnHeight = doc.createElement("MaxSpawnHeight");
			MaxSpawnHeight.appendChild(doc.createTextNode("40"));
			ore.appendChild(MaxSpawnHeight);
	 
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
