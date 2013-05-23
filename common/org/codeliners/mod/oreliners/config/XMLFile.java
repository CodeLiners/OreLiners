package org.codeliners.mod.oreliners.config;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.codeliners.mod.oreliners.OreLiners;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XMLFile {
	public static NodeList getNodeList(String elementName){
		
		NodeList nList = null;
		
		try {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(OreLiners.oreXML);
		doc.getDocumentElement().normalize();
		
		nList = doc.getElementsByTagName(elementName);
		
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		return nList;
	}
}
