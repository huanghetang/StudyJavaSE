 package cn.itcast.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("请输入一个字符串");
//		String str = scanner.nextLine();
//		qusetion3(str);
//		dzlast();
//		StringBuilder sb = new StringBuilder("av");
//		System.out.println(sb.capacity());
//		System.out.println(sb.length());
//		System.out.println(null==null);
		Class.forName("Test02");
	}
//
//	1.[图片]使用循环语句，求出0-100（包含0和100）以内对5取余等于1的元素的个数，
//	将结果打印在控制台上。PS:控制台打印示例：
	static void question(){
		int count=0;
		for(int i=0;i<=100;i++){
			if(i%5==1){
				count++;
			}
		}
		System.out.println("个数为:"+count);
	}
	
//	2定义一个整数数组，包含元素{2,6,9,12,8}，
//	获取并输出数组中数组角标和对应的元素都为偶数的元素与个数PS:0是偶数
	static void question2(){
		int[] a  = {2,6,9,12,8};
		int count=0;
		for(int i=0;i<a.length;i++){
			if(i%2==0 && a[i]%2==0){
				count++;
				System.out.println("角标为:"+i+",对应的a["+i+"]="+a[i]);
			}
		}
		System.out.println("个数为:"+count);
	}
	
//	3.[图片]编写一个无返回值，参数为String的方法，实现以下功能：
//	a.将传入的字符串中的第一个字符到第六个字符截取并打印出来。
//	b.将截取出来的字符串反转，并打印。在main方法中，键盘录入一个字符串，调用该方法，并测试。
	static void qusetion3(String str){
	
		if(str!=null && str.length()>=6){
			String s = str.substring(0,6);
			System.out.println("截取的字符串为:"+s);
			StringBuilder sb = new StringBuilder(s);
			String ss = sb.reverse().toString();
			System.out.println("反转后的字符串为"+ss);
		}
	}
	
	
//	4.①定义“学生”类Student，成员属性分别为：
//	姓名name（String类型）、分数score(int类型)，属性用私有修饰。
//	生成有参构造、get/set方法。
//	②定义测试类，在main方法中创建三个学生对象,属性分别赋值为小明，85、小红，65、小丽，90。
//	在测试类中定义一个无返回值的方法compare（Students1,Students2,Students3），
//	分别将创建的三个学生作为参数传入到方法中，方法中实现将所有学生对象放入ArrayList集合中，
//	并将所有成绩大于80的学生属性打印到控制台上。并调用方法进行测试。
	static void question4(){
		Test01 test01 = new Test01();
		Student s1 = test01.new Student("小明",85);
		Student s2 = test01.new Student("小红",65);
		Student s3 = test01.new Student("小丽",90);
		compare(s1,s2,s3);
	}
	private class Student{
		private String name;
		private int score;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getScore() {
			return score;
		}
		public void setScore(int score) {
			this.score = score;
		}
		public Student(String name, int score) {
			super();
			this.name = name;
			this.score = score;
		}
		
	}
//	并将所有成绩大于80的学生属性打印到控制台上。并调用方法进行测试
	static void compare(Student s1,Student s2,Student s3){
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		for(Student stu:list){
			if(stu.getScore()>80){
				System.out.println("该学生的姓名为:"+stu.getName()+",成绩为"+stu.getScore());
				
			}
		}
	}
	
//	5.[图片]项目根目录下创建一个data.txt文件，
//	文件中内容如下（要通过输出流按格式写入如下内容）通过输入流读取文件中所有内容，
//	统计文件中共有几行出现了“java”字符串，并将结果打印到控制台上。演示如下：
	static void qusetion5() throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt"));
		bw.write("123java");
		bw.newLine();
		bw.write("hey456");
		bw.newLine();
		bw.write("java78");
		bw.newLine();
		bw.write("jaza9");
		bw.newLine();
		bw.flush();
		bw.close();
		BufferedReader br = new BufferedReader(new FileReader("data.txt"));
		String str =null;
		int count=0;
		while((str=br.readLine())!=null){
			System.out.println(str);
			if(str.indexOf("java")!=-1){
				count++;
			}
		}
		br.close();
		System.out.println("出现了"+count+"次java");
		
	}
	
	
//	1.    创建出一个标准的学生类Student,成员变量分别为String name, int age ,double salary 
//	2.    通过字符流读取Test.txt中的数据,创建学生对象,读取出来数据给对象赋值 
//	3.    把每一个对象存入集合(ArrayList)当中,并遍历集合,薪资少10000的人,在原基础上加上2000 
//	4.    在把集合中的新的数据存入Test.txt文件当中(清除之前的数据)
	static void  dzlast() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("test"));
		String str = null;
		ArrayList<Student1> list = new ArrayList<Student1>();
		while((str=br.readLine())!=null){
			String[] ss = str.split(",");
			Student1 stu1 = new Test01().new Student1(ss[0],Integer.parseInt(ss[1]),Double.parseDouble(ss[2]));
			list.add(stu1);
		}
		br.close();
		BufferedWriter bw1 = new BufferedWriter(new FileWriter("test"));
		for(Student1 stu :list){
			double salary = stu.getSalary();
			if(salary<10000){
				salary +=2000;
				stu.setSalary(salary);
			}
			bw1.write(stu.getName()+","+stu.getAge()+","+stu.getSalary());
			bw1.newLine();
			bw1.flush();
		}
		bw1.close();
		
	}
  private class Student1{
	  private String name;
	  private int age;
	  private double salary;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Student1(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	  
	public Student1(){}
	 
  }

}
