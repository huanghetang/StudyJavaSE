package com.itcast.www;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 自定义Person类想要被Collections.sort(list)进行排序,必须要实现java.lang.Comparable接口并重写compareTo(Person p)方法
 * 而java.util.Comparator是比较器,想要使用比较器,对象必须先要实现Comprable接口,然后在此基础上实现比较器重写compare(Person p1,Person p2)方法
 * @author zhoumo
 *
 */
public class Person implements Comparable<Person> {
	public Person(){}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private int age;
	private String name;

	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int compareTo(Person o) {
		if(this.getAge()>=o.getAge()){
			return 1;
		}else{
			return -1;
		}
	}
	
	
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	public static void main(String[] args) {
		Person p1 = new Person(22, "zhoumo");
		Person p2 = new Person(19, "chengqi");
		Person p3 = new Person(13, "chengqi");
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		System.out.println(Arrays.toString(list.toArray()));
//		Collections.sort(list);
		Collections.sort(list,new Person().new PersonComparator());
		System.out.println(Arrays.toString(list.toArray()));
		
	}
	

class PersonComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		return o1.compareTo(o2);
	}
	
}


}
