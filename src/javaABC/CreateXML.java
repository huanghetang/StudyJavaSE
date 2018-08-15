package javaABC;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXML {
	public DocumentBuilder getDocumentBuild(){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder Builder =null;
		try {
			Builder = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return Builder;
	}
	
	public void createXML(){
		DocumentBuilder builder = getDocumentBuild();
		Document document = builder.newDocument();
		//ȥ����������� Standalone ��ʾ���ⲿ����
		document.setXmlStandalone(true);
		Element bookstore = document.createElement("bookstore");
		Element book = document.createElement("book");
		Element name = document.createElement("name");
		name.setTextContent("С����");
		Element auther = document.createElement("auther");
		auther.setTextContent("zhoumo");
		Element price = document.createElement("price");
		price.setTextContent("18");
		book.appendChild(name);
		book.appendChild(auther);
		book.appendChild(price);
		book.setAttribute("id", "1");
		bookstore.appendChild(book);
		document.appendChild(bookstore);
		
		//TrancformerFactory dom��ת�����ĵ�
		TransformerFactory tff = TransformerFactory.newInstance();
		Transformer transformer = null;
		try {
			transformer = tff.newTransformer();
			//����XML����
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
		try {
			//�����ο�JDK
			transformer.transform(new DOMSource(document), new StreamResult(new File("books1.xml")));
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	public static void main(String args[]){
		CreateXML cx = new CreateXML();
		cx.createXML();
		
	}

}
