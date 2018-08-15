package javaABC;


import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.DOMReader;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.xml.sax.SAXException;
/**
 * Description dom4j�����ʹ���xml
 * @author zhoumo
 * @date 2017/04/26 ����
 * @version 1.0
 */
public class Dom4jTest2 {
	
	public static void createXML() throws IOException{
		//�����ĵ�
		Document document = DocumentHelper.createDocument();
		//�������ڵ�
		Element root = DocumentHelper.createElement("persons");
		//���ø�Ԫ��
		document.setRootElement(root);
		//���ڵ���׷��Ԫ�ؽڵ�
		Element e1= root.addElement("person");
		//��������
		e1.addAttribute("stuno", "001");
		//׷���ı��ڵ�
		e1.addElement("name").setText("zhangsan");
		e1.addElement("gender").setText("female");
		e1.addElement("age").setText("20");
		//��������õ�xml�ĵ�������̨��û�н��и�ʽ��
		//XMLWriter xmlWriter = new XMLWriter();
		//xmlWriter.write(document);
		
		//���������ʽ ÿ��ǰ����ĸ��ַ������һ���(ԭʼ�ֽ���)
		OutputFormat format = new OutputFormat("    ", true);
		//XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("person.xml"), format);
		//xmlWriter.write(document);
		//���������ʽ ÿ��ǰ����ĸ��ַ������һ���(�ַ���)
		XMLWriter xmlWriter = new XMLWriter(new FileWriter("person1.xml"),format);
		xmlWriter.write(document);
		xmlWriter.flush();
	}
	//ʹ��SAXReader����(ʹ��SAXReader��ȡxmlԴ�ļ��õ�document�ٵõ���Ԫ�ؽ��н���)
	public void parseXML() throws DocumentException{
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(new File("person1.xml"));
		Element root = document.getRootElement();
		parseXMLSaxReader(root);
		
	}
	//����(���ݸ�Ԫ�ؽ���)
	public void parseXMLSaxReader(Element element){
		System.out.print("<"+element.getName());
		List<Element> elements = element.elements();
		List<Attribute> attributes = element.attributes();
		if(attributes != null && attributes.size()!=0){
			for(Attribute attr:attributes){//��������
				String name = attr.getName();
				String value = attr.getValue();
				System.out.print(" "+name+"=\""+value+"\"");
			}
		}
		System.out.println(">");
		if(elements!=null && elements.size()!=0){//�����ӽڵ�
			for(Iterator<Element> iterator = elements.iterator();iterator.hasNext();){
				Element e = iterator.next();
				parseXMLSaxReader(e);
			}
		}else{//û���ӽڵ� ����ı�
			System.out.print(element.getText());
		}
		System.out.print("</"+element.getName()+">");
	}
	//ʹ��DOMReader����(ʹ��DOMReaderת��org.w3c.dom.Document�õ�org.dom4j.DocumentȻ��õ���Ԫ�ؽ���)
	public void parseXMLUseDomReader() throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		org.w3c.dom.Document document1 = documentBuilder.parse(new File("person1.xml"));
		DOMReader domReader = new DOMReader();
		Document document = domReader.read(document1);
		Element element = document.getRootElement();
		parseXMLSaxReader(element);
		
		
		
	}
	
	public static void main(String[] args) throws IOException, DocumentException, ParserConfigurationException, SAXException {
		new Dom4jTest2().parseXMLUseDomReader();
	}

}
