package vip.huanghetang.jybhomework;

import java.io.Serializable;

public class Student2 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private transient Integer age;
	private String gender;
	
	public Student2(String name,Integer age,String gender){
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student2 [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

}
