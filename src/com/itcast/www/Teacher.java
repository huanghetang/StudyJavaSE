package com.itcast.www;

public class Teacher {
	private String tno;
	private String name;
	private int sex;
	private int age;
	private String course;
	public void setTno(String tno){
		this.tno = tno;
	}
	public String getTno(){
		return tno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Teacher(){}
	public Teacher(String tno,String name,int sex,int age,String course){
		this.tno = tno;
		this.name =name;
		this.sex = sex;
		this.age =age;
		this.course = course;
	}
	public static void main(String[] args) {
		Teacher t =  new Teacher("001","chengqi",1,18,"java");
		String name = t.getName();
		System.out.println(name);
	}

}
