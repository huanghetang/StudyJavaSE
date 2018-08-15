package vip.huanghetang.homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day10 {
	public static void main(String[] args) throws IOException {
//		FileReader fr = new FileReader("a.txt");
//		int count=0;
//		int length=0;
//		char[] chars = new char[5];
//		while((length=fr.read(chars))!=-1){
//			count++;
//		}
//		System.out.println(count);
//		question2();
//		String s=null;
//		s.length();
//		question3();
//		 String lineSeparator = java.security.AccessController.doPrivileged(new sun.security.action.GetPropertyAction("line.separator"));
//		dz2();
//		questionTZ3();
//		String str=null;
//		String s = str+"123";
//		System.out.println(s);
//		System.out.println((int)'0');;
		parseInt1("10678");
	}
	
	

//	��Ŀ�������û��ӿ���̨������Ϣ��������Ϣ�洢���ļ�Info.txt�С��������������Ϣ��
//	ÿ����Ϣ�洢һ�С����û����룺��886��ʱ�����������
	static void question1() throws IOException {
		System.out.println("������(����886����):");
		Scanner scanner = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new FileWriter("Info.txt"));
		for (;;) {
			String str = scanner.nextLine();
			if ("886".equals(str)) {
				break;
			}
			bw.write(str);
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}
	
//	����˵�����ӿ���̨����3��ѧԱ����Ϣ��
//	ÿ�����д洢��һ��Student�����У������Student����洢��һ�������С�
//	������Ϻ󣬽�����ѧԱ��Ϣ�洢���ļ�Student.txt�С�
//	ÿ��ѧԱ��Ϣ�洢һ�У��������ֵ�м��ö��Ÿ�����
	static void question2() throws IOException{
		ArrayList<Student> list  = new ArrayList<Student>();
		Scanner scanner = new Scanner(System.in);
		for(int i=0;i<3;i++){
			System.out.println("������name:");
			String name = scanner.nextLine();
			System.out.println("������age:");
			int age = scanner.nextInt();
			scanner.nextLine();//���ջس���
//			int age = Integer.parseInt(scanner.nextLine());
			Student s = new Day10().new Student(name,age);
			list.add(s);
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter("Student.txt"));
		for(Student stu : list){
			bw.write(stu.toString());
			bw.newLine();
		}
		bw.close();
		
	}
	static void test() throws IOException{
		BufferedReader br  = new BufferedReader(new FileReader("Student.txt"));
		String str = null;
		while((str=br.readLine())!=null){
			System.out.println(str);
			
		}
		br.close();
		
	}
//	����˵�������ļ�name.txt�е����ݡ�¬���塱�޸�Ϊ����ʷ�Ĺ�����
	static void question3() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("name.txt"));
		String str = null;
		ArrayList<Student> list = new ArrayList<Student>();
		while((str=br.readLine())!=null){
			System.out.println(str);
			String[] split = str.split(",");
			String name = split[1];
			if("¬����".equals(name)){
				name = "ʷ�Ĺ�";
			}
			int age = Integer.parseInt(split[3]);
			Student student = new Day10().new Student(name,age);
			list.add(student);
			
		}
		br.close();
		BufferedWriter bw = new BufferedWriter(new FileWriter("name.txt"));
		for(Student stu:list){
			bw.write(stu.getName()+","+stu.getAge());
			bw.newLine();
			bw.flush();
		}
		bw.close();
		
	}
	
	
//	����һ��������IOUtils�������·�����������������(���²���ֻ��Դ��ı��ļ�(.txt�ļ�))��
//	1.copyFile2Dir(String srcFile,String destDir)
//	    ����String srcFile:Ҫ���Ƶ�Դ�ļ�
//		����String destDir:���Ʋ��������ļ��Ĵ洢·��(Ŀ��·��)
//		Ҫ�󣺽�srcFile�ļ����Ƶ�destDirĿ���ļ�����(���ܸı�Դ�ļ�������)
//	2.copyDir2Dir(String srcDir,String destDir)
//		����File srcDir:Ҫ���Ƶ�Դ�ļ���
//		����File destDir:���Ʋ��������ļ��Ĵ洢·��(Ŀ��·��)
//		Ҫ�󣺽�srcDir�ļ����е������ļ�(���������ļ���)���Ƶ�destDirĿ���ļ�����(���ܸı�Դ�ļ�������)
	
	
	
	private class Student{
		private String name;
		private int age;
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
		public Student(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}
		
		@Override
		public String toString(){
			return "Student [name="+name+",age="+age+"]";
			
		}
		
		
	}

	
//	���� : ����¼��һ���ַ����� ��ȡ¼����ַ���������Ϊ���ֵ��ַ����ϸ������¸�ʽ���������̨��
	static void dz1(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("������һ���ַ���:");
		String str = scanner.nextLine();
		char[] chars = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(char c:chars){
			if(c>='0' && c<='9'){
				sb.append(c);
			}
		}
		System.out.println(sb.toString());
	}
	static void dz2(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("������һ���ַ���:");
		String str = scanner.nextLine();
		
		char[] chars = str.toCharArray();
		System.out.println(chars);
		StringBuilder sb = new StringBuilder(str).reverse();
		sb.getChars(0, sb.length()-1, chars, 0);
		
		System.out.println(Arrays.toString(chars));
	}
	

	//�����������󣬲��ô���ʵ��
	//1.��Ŀ��Ŀ¼�½����ļ��� user.txt���ļ��д���û����͵�¼���룬��ʽ���û���������,�磺aaa,123��
	//2. user.txt�ļ��г�ʼ��ŵ��û���Ϣ�����£�
//		jack,123
//		rose,123
//		tom,123
	//3.Ҫ��������¹��ܣ�
	//  ��������ʱ������̨��ʾ�û�����ע����û��������룻
	//   ��֤����¼����û�����user.txt����ע����û����Ƿ��ظ���
	//   �ǣ�����̨��ʾ���û����Ѵ���
	//   �񣺽�����¼����û���������д��user.txt�ļ������ڿ���̨��ʾ��ע��ɹ���

		static void questionTZ2() throws IOException{
			BufferedWriter bw = new BufferedWriter(new FileWriter("user.txt",true));//���ļ���׷��
			bw.write("jack,123");
			bw.write(System.lineSeparator());
			bw.write("rose,123");
			bw.newLine();
			bw.write("tom,123");
			bw.newLine();
			bw.flush();
//			bw.close();
			BufferedReader br = new BufferedReader(new FileReader("user.txt"));
			String str = null;
			ArrayList<String > list = new ArrayList<String>();
			while((str=br.readLine())!=null){
				String[] s = str.split(",");
				System.out.println(Arrays.toString(s));
				list.add(s[0]);//���뼯��
			}
			br.close();
			Scanner scanner = new Scanner(System.in);
			boolean flag = true;
			String availableName="";
			while(flag){
				flag = false;
				System.out.println("�����û���:");
				String name = scanner.nextLine();
				availableName = name;
				for(int i=0;i<list.size();i++){
					if(list.get(i).equals(name)){
						System.out.println("�û����Ѵ���");
						flag = true;
						break;
					}
				}
			}
			
			System.out.println("����������");
			String password = scanner.nextLine();
			bw.write(availableName+","+password);
			bw.flush();
			bw.close();
			
		}
		
		
//		��Ŀ��·�����и�questions.txt�ļ��������£�
//		5+5
//		150-25
//		155*155
//		2555/5
//	Ҫ�󣺶�ȡ���ݼ��������������д�뵽results.txt�ļ���
//		5+5=10
//		//....
//	˼��:���˵��ȡquestions.txt�ļ�������,���������,��д��questions.txt�ļ�,������д�Ĳ���ʱ���ͬһ���ļ�,Ӧ����β���
		
		static void questionTZ3() throws IOException{
			BufferedReader br = new BufferedReader(new FileReader("question.txt"));//�ļ�����5+5
			BufferedWriter bw = new BufferedWriter(new FileWriter("question.txt"));
			StringBuilder result = new StringBuilder();
			System.out.println(br);//java.io.BufferedReader@2a97cec
			System.out.println(br.read());//-1,Ϊʲô������?
			String str = null;
			while((str=br.readLine())!=null){
				System.out.println("111111111111111");
				System.out.println(str);
				if(str.contains("+")){
					System.out.println("2222222222222222222");
					int index = str.indexOf("+");
					String a = str.substring(0, index);
					String b = str.substring(index+1);
//					String[] ss = str.split("\\+");
					 result.append(a).append("+").append(b).append(Integer.parseInt(a)+Integer.parseInt(b))
					 .append(System.lineSeparator());
				}
				if(str.contains("-")){
					System.out.println("33333333333333333333");
					int index = str.indexOf("-");
					String a = str.substring(0, index);
					String b = str.substring(index+1);
					result.append(a).append("-").append(b).append("=").append(Integer.parseInt(a)-Integer.parseInt(b))
					.append(System.lineSeparator());
				}
//					else
//				if(str.contains("*")){
//					String[] ss = str.split("*");
//					 result = ss[0]+"*"+ss[1]+"="+(Integer.parseInt(ss[0])*Integer.parseInt(ss[1]));
//				}else
//				if(str.contains("/")){
//					String[] ss = str.split("/");
//					 result = ss[0]+"/"+ss[1]+"="+(Integer.parseInt(ss[0])/Integer.parseInt(ss[1]));
//				}
			}
			System.out.println("444444444444444444");
			br.close();
			System.out.println(result);
			bw.write(result.toString());
			bw.flush();
			bw.close();
		}
		
		static void parseInt1(String str){
			int length = str.length();
			int sum =0;
			for(int i=0;i<length;i++){
				int num = str.charAt(i)-48;
				sum += Math.pow(10, length-i-1)*num;
			}
			System.out.println(sum);
		}
		
		public static int parseInt(String str) {//123
			int sum = 0;
			for(int i = 0; i < str.length(); i++) { 
				int num = str.charAt(i) - 48;//1,2,3
				sum = sum * 10 + num;//0*10+1=1,1*10+2=12,12*10+3=123
			}
			return sum;
		}
}

