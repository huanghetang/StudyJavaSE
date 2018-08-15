package com.bsoft.www.parseXML;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParseXML {
	
	public static void domParseXML(){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = dbf.newDocumentBuilder();
		    Document document = builder.parse("books.xml");
		   NodeList books =  document.getElementsByTagName("book");
		   System.out.println("����"+books.getLength()+"����");
		   for(int i=0;i<books.getLength();i++){
			  Node node = books.item(i);
			  Element element = (Element)node;
			  String str = element.getAttribute("id");
			  NodeList nodesList = node.getChildNodes();
			  System.out.println("=======��ʼ��"+(i+1)+"����"+
					  "----����ֵid��"+str+"=====");
			  System.out.println("��"+i+1+"���飬����"+nodesList.getLength()+"���ӽڵ�");
			  for(int j=0;j<nodesList.getLength();j++){
				  Node nodes = nodesList.item(j);
				  if(nodes.getNodeType() == Node.ELEMENT_NODE){
				  System.out.print("��������"+nodes.getNodeName());
				  System.out.println("---����ֵ:"+nodes.getTextContent());
				  
			  }
			  }
		   }
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		domParseXML();
	}

}
