package com.Persistence;

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

import com.procesarlogs.ParametrosLogsDAO;

public class StringAXml {
	
	public ParametrosLogsDAO  stringAXml(String xmlString,ParametrosLogsDAO paramLog) throws Exception {

		try {
			String[] primerlinea = xmlString.split("\n");
			Document xmlDocument;
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			xmlDocument = builder.parse(new InputSource(new StringReader(primerlinea[0])));
			NodeList lisl =xmlDocument.getElementsByTagName("Log");
			
			 for (int i = 0; i < lisl.getLength(); i++) {
				Node nnode = lisl.item(i);
				Element element = (Element)nnode;		
				paramLog.setCanal(element.getElementsByTagName("systemId").item(0).getTextContent());
				paramLog.setIdtransaccion(element.getElementsByTagName("messageId").item(0).getTextContent());
				paramLog.setAdaptador(element.getElementsByTagName("componentId").item(0).getTextContent());
				paramLog.setFechaInicio((element.getElementsByTagName("timeStamp").item(0).getTextContent()).substring(0,19));
				paramLog.setNombreServicio(element.getElementsByTagName("serviceId").item(0).getTextContent());
			}
			 			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.out.println("stringAXml"+e.getMessage());
			throw e;
		}
		
		return paramLog;
	}

}
