package com.itcast.www;

import java.util.Scanner;

public class MainApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入员工编号:");
		String sno = scanner.nextLine();
		System.out.println("请输入员工姓名:");
		String name = scanner.nextLine();
		Student student = new Student();
		System.out.println(student.getSno());//null
		student.setSno(sno);
		student.setName(name);
		System.out.println(student.getSno());//sno
		Student stu = new Student(sno,name,"男",18);//
		System.out.println(stu.getName()+","+stu.getSno()+","+stu.getSex()+","+stu.getAge());
		
	}
	

}

class Student {
	private String sno;
	private String name;
	private String sex;
	private int age;
	public void setSno(String sno){
		this.sno = sno;
	}
	public String getSno(){
		return sno;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student(){}
	public Student(String sno,String name,String sex,int age){
		this.sno = sno;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

}