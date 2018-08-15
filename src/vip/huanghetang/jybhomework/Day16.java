package vip.huanghetang.jybhomework;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import cn.itcast.test.BeanUtils;

public class Day16 {
	
	
	public static void main(String[] args) {
		try {
			parseXmlUseDom4j();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void parseXmlUseDom4j() throws Exception{
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read("student.xml");
		Element rootElement = document.getRootElement();
		 List<Element> elements = rootElement.elements();
		 for (Element element : elements) {
			 Day16.Student student =  new Day16().new Student();
			String stuNo = element.attributeValue("stuNo");
			List<Element> elements2 = element.elements();
			for (Element element2 : elements2) {
				String name = element2.getName();
				String value = element2.getText();
				System.out.println(name+"---"+value);
				org.apache.commons.beanutils.BeanUtils.setProperty(student, name, value);
			}
			System.out.println(student);
	
		}
		
	}
	
	/**
	 * 	<student stuNo="it001">
		<name>ÕÂ×Óâù</name>
		<age>20</age>
		<gender>Å®</gender>
		<score>99</score>
	</student>
	 * @author zhoumo
	 *
	 */
	public class Student{
		private String stuNo;
		private String name;
		private int age;
		private String gender;
		private String score;
		public String getStuNo() {
			return stuNo;
		}
		public void setStuNo(String stuNo) {
			this.stuNo = stuNo;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getScore() {
			return score;
		}
		public void setScore(String score) {
			this.score = score;
		}
		public Student(String stuNo, String name, int age, String gender, String score) {
			super();
			this.stuNo = stuNo;
			this.name = name;
			this.age = age;
			this.gender = gender;
			this.score = score;
		}
		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Student [stuNo=" + stuNo + ", name=" + name + ", age=" + age + ", gender=" + gender + ", score="
					+ score + "]";
		}
		
		
	}

}
class Myexception extends Exception{
	private String msg;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Myexception(String msg){
		super(msg);
	}
	
}
