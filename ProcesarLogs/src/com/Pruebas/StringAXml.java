package com.Pruebas;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class StringAXml {

	static Document xmlDocument;

	public static void main(String[] args) {

		String dato = "<Log><system"; 

		stringAXml(dato);

	}

	public static void stringAXml(String xmlString) {
		try {
			
			String[] parts = xmlString.split("\n");
			System.out.println("sdasd: "+parts[0]);
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			xmlDocument = builder.parse(new InputSource(new StringReader(xmlString)));
			NodeList lisl =xmlDocument.getElementsByTagName("Log");
			String systemId="";
			String messageId="";
			String componentId="";
			String timeStamp="";
			String serviceId="";
			
			 for (int i = 0; i < lisl.getLength(); i++) {
				Node nnode = lisl.item(i);
				Element element = (Element)nnode;
				systemId= element.getElementsByTagName("systemId").item(0).getTextContent();
				messageId= element.getElementsByTagName("messageId").item(0).getTextContent();
				componentId= element.getElementsByTagName("componentId").item(0).getTextContent();
				timeStamp= element.getElementsByTagName("timeStamp").item(0).getTextContent();
				serviceId= element.getElementsByTagName("serviceId").item(0).getTextContent();
				System.out.println("systemId "+systemId);
				System.out.println("messageId "+messageId);
				System.out.println("componentId "+componentId);
				System.out.println("timeStamp "+timeStamp);
				System.out.println("serviceId "+serviceId);
			}
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public Document getXML() {
		return xmlDocument;
	}

}
