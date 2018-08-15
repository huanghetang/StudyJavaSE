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
		//去掉多余的属性 Standalone 表示被外部引用
		document.setXmlStandalone(true);
		Element bookstore = document.createElement("bookstore");
		Element book = document.createElement("book");
		Element name = document.createElement("name");
		name.setTextContent("小丸子");
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
		
		//TrancformerFactory dom树转换成文档
		TransformerFactory tff = TransformerFactory.newInstance();
		Transformer transformer = null;
		try {
			transformer = tff.newTransformer();
			//设置XML换行
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
		try {
			//参数参考JDK
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
