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
	
	

//	项目需求：请用户从控制台输入信息，程序将信息存储到文件Info.txt中。可以输入多条信息，
//	每条信息存储一行。当用户输入：”886”时，程序结束。
	static void question1() throws IOException {
		System.out.println("请输入(输入886结束):");
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
	
//	需求说明：从控制台接收3名学员的信息，
//	每条进行存储到一个Student对象中，将多个Student对象存储到一个集合中。
//	输入完毕后，将所有学员信息存储到文件Student.txt中。
//	每名学员信息存储一行，多个属性值中间用逗号隔开。
	static void question2() throws IOException{
		ArrayList<Student> list  = new ArrayList<Student>();
		Scanner scanner = new Scanner(System.in);
		for(int i=0;i<3;i++){
			System.out.println("请输入name:");
			String name = scanner.nextLine();
			System.out.println("请输入age:");
			int age = scanner.nextInt();
			scanner.nextLine();//接收回车键
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
//	需求说明：将文件name.txt中的数据“卢俊义”修改为：“史文恭”。
	static void question3() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("name.txt"));
		String str = null;
		ArrayList<Student> list = new ArrayList<Student>();
		while((str=br.readLine())!=null){
			System.out.println(str);
			String[] split = str.split(",");
			String name = split[1];
			if("卢俊义".equals(name)){
				name = "史文恭";
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
	
	
//	定义一个工具类IOUtils，有以下方法，方法描述如下(以下操作只针对纯文本文件(.txt文件))：
//	1.copyFile2Dir(String srcFile,String destDir)
//	    参数String srcFile:要复制的源文件
//		参数String destDir:复制产生的新文件的存储路径(目标路径)
//		要求：将srcFile文件复制到destDir目标文件夹中(不能改变源文件的名称)
//	2.copyDir2Dir(String srcDir,String destDir)
//		参数File srcDir:要复制的源文件夹
//		参数File destDir:复制产生的新文件的存储路径(目标路径)
//		要求：将srcDir文件夹中的所有文件(不包含子文件夹)复制到destDir目标文件夹中(不能改变源文件的名称)
	
	
	
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

	
//	需求 : 键盘录入一个字符串， 获取录入的字符串中所有为数字的字符，严格按照以下格式输出到控制台上
	static void dz1(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入一个字符串:");
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
		System.out.println("请输入一个字符串:");
		String str = scanner.nextLine();
		
		char[] chars = str.toCharArray();
		System.out.println(chars);
		StringBuilder sb = new StringBuilder(str).reverse();
		sb.getChars(0, sb.length()-1, chars, 0);
		
		System.out.println(Arrays.toString(chars));
	}
	

	//分析以下需求，并用代码实现
	//1.项目根目录下建立文件： user.txt，文件中存放用户名和登录密码，格式：用户名，密码,如：aaa,123；
	//2. user.txt文件中初始存放的用户信息有如下：
//		jack,123
//		rose,123
//		tom,123
	//3.要求完成如下功能：
	//  程序运行时：控制台提示用户输入注册的用户名和密码；
	//   验证键盘录入的用户名跟user.txt中已注册的用户名是否重复：
	//   是：控制台提示：用户名已存在
	//   否：将键盘录入的用户名及密码写入user.txt文件，并在控制台提示：注册成功；

		static void questionTZ2() throws IOException{
			BufferedWriter bw = new BufferedWriter(new FileWriter("user.txt",true));//在文件中追加
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
				list.add(s[0]);//放入集合
			}
			br.close();
			Scanner scanner = new Scanner(System.in);
			boolean flag = true;
			String availableName="";
			while(flag){
				flag = false;
				System.out.println("输入用户名:");
				String name = scanner.nextLine();
				availableName = name;
				for(int i=0;i<list.size();i++){
					if(list.get(i).equals(name)){
						System.out.println("用户名已存在");
						flag = true;
						break;
					}
				}
			}
			
			System.out.println("请输入密码");
			String password = scanner.nextLine();
			bw.write(availableName+","+password);
			bw.flush();
			bw.close();
			
		}
		
		
//		项目根路径下有个questions.txt文件内容如下：
//		5+5
//		150-25
//		155*155
//		2555/5
//	要求：读取内容计算出结果，将结果写入到results.txt文件中
//		5+5=10
//		//....
//	思考:如果说读取questions.txt文件的内容,算出计算结果,再写入questions.txt文件,即读和写的操作时针对同一个文件,应该如何操作
		
		static void questionTZ3() throws IOException{
			BufferedReader br = new BufferedReader(new FileReader("question.txt"));//文件内容5+5
			BufferedWriter bw = new BufferedWriter(new FileWriter("question.txt"));
			StringBuilder result = new StringBuilder();
			System.out.println(br);//java.io.BufferedReader@2a97cec
			System.out.println(br.read());//-1,为什么读不到?
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

