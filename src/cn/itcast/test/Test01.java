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
//		System.out.println("������һ���ַ���");
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
//	1.[ͼƬ]ʹ��ѭ����䣬���0-100������0��100�����ڶ�5ȡ�����1��Ԫ�صĸ�����
//	�������ӡ�ڿ���̨�ϡ�PS:����̨��ӡʾ����
	static void question(){
		int count=0;
		for(int i=0;i<=100;i++){
			if(i%5==1){
				count++;
			}
		}
		System.out.println("����Ϊ:"+count);
	}
	
//	2����һ���������飬����Ԫ��{2,6,9,12,8}��
//	��ȡ���������������Ǳ�Ͷ�Ӧ��Ԫ�ض�Ϊż����Ԫ�������PS:0��ż��
	static void question2(){
		int[] a  = {2,6,9,12,8};
		int count=0;
		for(int i=0;i<a.length;i++){
			if(i%2==0 && a[i]%2==0){
				count++;
				System.out.println("�Ǳ�Ϊ:"+i+",��Ӧ��a["+i+"]="+a[i]);
			}
		}
		System.out.println("����Ϊ:"+count);
	}
	
//	3.[ͼƬ]��дһ���޷���ֵ������ΪString�ķ�����ʵ�����¹��ܣ�
//	a.��������ַ����еĵ�һ���ַ����������ַ���ȡ����ӡ������
//	b.����ȡ�������ַ�����ת������ӡ����main�����У�����¼��һ���ַ��������ø÷����������ԡ�
	static void qusetion3(String str){
	
		if(str!=null && str.length()>=6){
			String s = str.substring(0,6);
			System.out.println("��ȡ���ַ���Ϊ:"+s);
			StringBuilder sb = new StringBuilder(s);
			String ss = sb.reverse().toString();
			System.out.println("��ת����ַ���Ϊ"+ss);
		}
	}
	
	
//	4.�ٶ��塰ѧ������Student����Ա���Էֱ�Ϊ��
//	����name��String���ͣ�������score(int����)��������˽�����Ρ�
//	�����вι��졢get/set������
//	�ڶ�������࣬��main�����д�������ѧ������,���Էֱ�ֵΪС����85��С�죬65��С����90��
//	�ڲ������ж���һ���޷���ֵ�ķ���compare��Students1,Students2,Students3����
//	�ֱ𽫴���������ѧ����Ϊ�������뵽�����У�������ʵ�ֽ�����ѧ���������ArrayList�����У�
//	�������гɼ�����80��ѧ�����Դ�ӡ������̨�ϡ������÷������в��ԡ�
	static void question4(){
		Test01 test01 = new Test01();
		Student s1 = test01.new Student("С��",85);
		Student s2 = test01.new Student("С��",65);
		Student s3 = test01.new Student("С��",90);
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
//	�������гɼ�����80��ѧ�����Դ�ӡ������̨�ϡ������÷������в���
	static void compare(Student s1,Student s2,Student s3){
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		for(Student stu:list){
			if(stu.getScore()>80){
				System.out.println("��ѧ��������Ϊ:"+stu.getName()+",�ɼ�Ϊ"+stu.getScore());
				
			}
		}
	}
	
//	5.[ͼƬ]��Ŀ��Ŀ¼�´���һ��data.txt�ļ���
//	�ļ����������£�Ҫͨ�����������ʽд���������ݣ�ͨ����������ȡ�ļ����������ݣ�
//	ͳ���ļ��й��м��г����ˡ�java���ַ��������������ӡ������̨�ϡ���ʾ���£�
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
		System.out.println("������"+count+"��java");
		
	}
	
	
//	1.    ������һ����׼��ѧ����Student,��Ա�����ֱ�ΪString name, int age ,double salary 
//	2.    ͨ���ַ�����ȡTest.txt�е�����,����ѧ������,��ȡ�������ݸ�����ֵ 
//	3.    ��ÿһ��������뼯��(ArrayList)����,����������,н����10000����,��ԭ�����ϼ���2000 
//	4.    �ڰѼ����е��µ����ݴ���Test.txt�ļ�����(���֮ǰ������)
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
