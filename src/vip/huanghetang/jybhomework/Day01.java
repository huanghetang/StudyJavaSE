package vip.huanghetang.jybhomework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.apache.commons.beanutils.BeanUtils;

/**
 *   ��ʹ�ô�������:  18��ľ�����ʹ��iPhone�ֻ�����Ϸ
 * @author zhoumo
 *
 */
public class Day01 {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
//		Person p = new Person("����","18");
//		p.userPhone(new Phone("iphone"));
		ArrayList<Integer> list = new ArrayList<Integer>();
		Class c = list.getClass();
		Method m = c.getMethod("add",Object.class);
		m.invoke(list, "����");
		System.out.println(list);
	}
	
	

	
}
class Person{
	private String name;
	private String age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Person(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
	}
	
	void userPhone(Phone phone){
		System.out.print(age+"���"+name+"��ʹ��"+phone.getBrand());
		phone.playGame();
	}
}

class Phone{
	private String brand;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Phone(String brand) {
		super();
		this.brand = brand;
	}

	public Phone() {
		super();
	}
	void playGame(){
		System.out.println("������ʦ");
	}
	
	
}

