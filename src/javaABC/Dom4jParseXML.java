package javaABC;


import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jParseXML {
	public static void dom4jParseXML(){
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(new File("books.xml"));
			 Element bookstore = document.getRootElement();
			 Iterator it = bookstore.elementIterator();
			 while(it.hasNext()){
				 System.out.println("+++++++++++++++++==");
				 Element book = (Element)it.next();
				 List<Attribute> att = book.attributes();
				 for(Attribute a:att){
					 System.out.print("属性名："+a.getName());
					 System.out.println("属性值："+a.getValue());
				 }
				 Iterator b = book.elementIterator();
				 while(b.hasNext()){
					 Element e = (Element)b.next();
						 System.out.println("节点名："+e.getName());
						 System.out.println("节点值："+e.getStringValue());
				 }
			
			 }
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		dom4jParseXML();
	}
	

}
