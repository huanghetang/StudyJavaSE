package cn.itcast.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import sun.net.spi.nameservice.dns.DNSNameService;

public class TestReflect {
	private String name;
	private Integer age;
	
	private TestReflect(Integer age){
		this.age = age;
	}
	TestReflect(){}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	

	@Override
	public String toString() {
		return "TestReflect [name=" + name + ", age=" + age + "]";
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
//		System.out.println(String.class.getClassLoader().getClass().getName());
//		System.out.println(DNSNameService.class.getClassLoader().getParent());
//		System.out.println(TestReflect.class.getClassLoader());
//		System.out.println(TestReflect.class.getClassLoader().getParent());
//		Class c = Class.forName("cn.itcast.test.TestReflect");
//		Constructor con = c.getDeclaredConstructor(Integer.class);
//		con.setAccessible(true);
//		TestReflect ob = (TestReflect)con.newInstance(12);
//		System.out.println(ob);
	}
	

	

}
class SingletonDemo{
//	private SingletonDemo singleton;
	private static SingletonDemo singleton = new SingletonDemo();
	private  SingletonDemo(){
	}
	//±¥ººÄ£Ê½
//	public static  SingletonDemo getInstance(){
//		if(singleton==null){
//			singleton = new SingletonDemo();
//			return singleton;
//		}else{
//			return singleton;
//		}
//		
//	}
	public static  SingletonDemo getInstance(){
		return singleton;
	}
	
}
