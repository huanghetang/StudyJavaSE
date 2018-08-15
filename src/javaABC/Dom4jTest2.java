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
 * Description dom4j解析和创建xml
 * @author zhoumo
 * @date 2017/04/26 下午
 * @version 1.0
 */
public class Dom4jTest2 {
	
	public static void createXML() throws IOException{
		//创建文档
		Document document = DocumentHelper.createDocument();
		//创建根节点
		Element root = DocumentHelper.createElement("persons");
		//设置根元素
		document.setRootElement(root);
		//根节点上追加元素节点
		Element e1= root.addElement("person");
		//设置属性
		e1.addAttribute("stuno", "001");
		//追加文本节点
		e1.addElement("name").setText("zhangsan");
		e1.addElement("gender").setText("female");
		e1.addElement("age").setText("20");
		//输出创建好的xml文档到控制台，没有进行格式化
		//XMLWriter xmlWriter = new XMLWriter();
		//xmlWriter.write(document);
		
		//定义输出格式 每行前面加四个字符，并且换行(原始字节流)
		OutputFormat format = new OutputFormat("    ", true);
		//XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("person.xml"), format);
		//xmlWriter.write(document);
		//定义输出格式 每行前面加四个字符，并且换行(字符流)
		XMLWriter xmlWriter = new XMLWriter(new FileWriter("person1.xml"),format);
		xmlWriter.write(document);
		xmlWriter.flush();
	}
	//使用SAXReader解析(使用SAXReader读取xml源文件得到document再得到根元素进行解析)
	public void parseXML() throws DocumentException{
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(new File("person1.xml"));
		Element root = document.getRootElement();
		parseXMLSaxReader(root);
		
	}
	//解析(根据根元素解析)
	public void parseXMLSaxReader(Element element){
		System.out.print("<"+element.getName());
		List<Element> elements = element.elements();
		List<Attribute> attributes = element.attributes();
		if(attributes != null && attributes.size()!=0){
			for(Attribute attr:attributes){//迭代属性
				String name = attr.getName();
				String value = attr.getValue();
				System.out.print(" "+name+"=\""+value+"\"");
			}
		}
		System.out.println(">");
		if(elements!=null && elements.size()!=0){//迭代子节点
			for(Iterator<Element> iterator = elements.iterator();iterator.hasNext();){
				Element e = iterator.next();
				parseXMLSaxReader(e);
			}
		}else{//没有子节点 输出文本
			System.out.print(element.getText());
		}
		System.out.print("</"+element.getName()+">");
	}
	//使用DOMReader解析(使用DOMReader转换org.w3c.dom.Document得到org.dom4j.Document然后得到根元素解析)
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
