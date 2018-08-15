package vip.huanghetang.jybhomework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class Day12 {
	public static void main(String[] args) {
//		try {
//			question6();
//		} catch (ClassNotFoundException | IOException e) {
//			e.printStackTrace();
//		}
		try {
			question10();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 1.字符流输出流一次写一个字符到文件中
	 * 4:现有一字符串：”我爱Java”。将该字符串保存到当前项目根目录下的a.txt文件中。
			要求：使用utf8编码保存。

	 */
	static void question1(){
//		FileWriter fw = null;
		OutputStreamWriter osw = null;
		try {
//			fw = new FileWriter("day12.txt");
			osw = new OutputStreamWriter(new FileOutputStream("day12.txt"),"utf-8");
//			fw.write("I");
//			fw.write(" love 景甜");
			osw.write("我爱Java");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			closeIO(osw);
		}
	}

	/**
	 * 利用转换输入流将当前项目根目录下使用utf8编码的a.txt文件的内容读取出来，并打印在控制台上。 要求：不能出现乱码的情况。
	 * 
	 * @param ios
	 */
	static void question5(){
		InputStreamReader isr = null;
		BufferedReader bf = null;
		try {
			isr = new InputStreamReader(new FileInputStream("day12.txt"),"utf-8");
			bf = new BufferedReader(isr);
//			char[] chs = new char[1024];
//			int content = -1;
			String count = null;
//			while((content=isr.read(chs))!=-1){
			while((count=bf.readLine())!=null){
//				String str = new String(chs,0,content);
//				System.out.println(str);
				System.out.println(count);
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			closeIO(isr);
		}
		
		
	}
	
	/**
	 * 定义一个学生类，包含姓名，年龄，性别等成员变量，提供setters和getters方法以及构造方法。在测试类中创建一个学生对象，
	 * 给学生对象的三个成员变量赋值。然后将该对象保存到当前项目根目录下的stu.txt文件中。
	 * 
	 * @param ios
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	@SuppressWarnings("resource")
	static void question6() throws FileNotFoundException, IOException, ClassNotFoundException{
		Student2 s1 = new Student2("景甜",18,"女");
		Student2 s2 = new Student2("迪丽热巴",18,"女");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("day12.txt"));
		oos.writeObject(s1);
//		oos.write(System.lineSeparator().getBytes());
		oos.writeObject(s2);
		oos.flush();
		oos.close();
		System.out.println(s1+","+s2);
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("day12.txt"));
		Student2 s3 = (Student2)ois.readObject();
		Student2 s4 = (Student2)ois.readObject();
		Student2 s5 = (Student2)ois.readObject();
		System.out.println(s3);	System.out.println(s4);
		System.out.println(s5);
		ois.close();
	}
	
	/**
	 * 从键盘录入一行字符串，利用字节打印流将该行字符串保存到当前项目根目录下的d.txt文件中
	 * 
	 * 利用字符打印流将字符串”我爱Java” 保存到当前项目的根目录下的e.txt文件中。
	 * @throws IOException 
	 */
	@SuppressWarnings("resource")
	static void question7() throws IOException{
//		PrintStream printStream = new PrintStream(new FileOutputStream("day12.txt"),true,"utf-8");
//		printStream.print("this is my first printStrem 的使用");
//		printStream.flush();
//		printStream.close();
		PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("day12.txt"),"utf-8"), true);
		printWriter.println("22this is my first printStrem 的使用22");
		printWriter.close();
		System.out.println("over");
	}
	
	/**
	 * 在当前项目根目录下准备好一个test.txt 的文本文件，要求该文本文件是使用GBK编码，其内容如下： 窗前明月光 疑是地上霜 举头望明月
	 * 低头思故乡
	 * 
	 * 利用字节流+桥转换读入这个文本文件，以UTF8的编码方式将读取的内容写到test2.txt文件中
	 * 
	 * @param ios
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("resource")
	static void question8() throws UnsupportedEncodingException, IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("day12.txt"),"utf-8"));
		bw.write("窗前明月光");
		bw.newLine();
		bw.write("疑是地上霜 举头望明月",0,5);
		bw.newLine();
		bw.write("举头望明月");;
		bw.newLine();
		bw.write(" 低头思故乡");
		bw.flush();
		bw.close();
		InputStreamReader isr = new InputStreamReader(new FileInputStream("day12.txt"),"utf-8");
		BufferedReader br = new BufferedReader(isr);
		String content = null;
		while((content= br.readLine())!=null){
			System.out.println(content);
		}
		isr.close();
	}
	/**
	 * 定义一个学生类，成员变量有姓名，年龄，性别，提供setters和getters方法以及构造方法
定义一个测试类，在测试类创建多个学生对象保存到集合中，然后将集合存储到当前项目根目录下的stus.txt文件中。
	 * @throws IOException 
	 * @throws FileNotFoundException 

	 */
	static void question9() throws FileNotFoundException, IOException{
		Properties properties = new Properties();
//		properties.load(new FileInputStream("day12.properties"));
//		properties.setProperty("name", "景甜");
//		properties.setProperty("age", "18");
//		properties.setProperty("gender", "女");
//		properties.store(new FileOutputStream("day12.properties"), "this is first properties的使用");
		properties.load(new FileInputStream("day12.properties"));
		Set<String> names = properties.stringPropertyNames();
		for(String name:names){
			System.out.println(name+"="+properties.getProperty(name));
		}
		
	}
	/**
	 * 从键盘输入一个文件夹路径，利用打印流将该文件夹下的所有文件(包括子文件夹)复制到D盘下temp文件夹下。
	 * @param ios
	 * @throws IOException 
	 */
	static void question10() throws IOException{
		File srcFile  = getFile();
		System.out.println(srcFile);
		
		File destFile = new File("d:/temp/tp");
//		destFile.mkdir();
		copyDirectory2Directory(srcFile,destFile);
		System.out.println("over10");
		
		
	}
	private static File getFile() {
		System.out.println("请输入一个文件夹路径:");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		File file = new File(str);
		if(!file.exists()){
			throw new RuntimeException("请输入的路径不存在");
		}
		if(!file.isDirectory()){
			throw new RuntimeException("请输入的路径不是一个文件夹");
		}
		return file;
	}

	static void copyDirectory2Directory(File srcFile,File destFile) throws IOException{
		if(srcFile.isDirectory()){
			File[] files = srcFile.listFiles();
			for (File file : files) {
					File newFile = new File(destFile,file.getName());
					copyDirectory2Directory(file,newFile);
			}
			
		}else{
			if(!destFile.getParentFile().exists()){
				destFile.getParentFile().mkdirs();
			}
			FileInputStream fs = new FileInputStream(srcFile);
			PrintStream printStream = new PrintStream(new FileOutputStream(destFile));
			byte[] bys = new byte[1024];
			int content = -1;
			while((content=fs.read(bys))!=-1){
				printStream.write(bys, 0, content);
			}
			closeIO(fs,printStream);
		}
			

	}
	
	/**
	 * C盘下有两个文本文件，分别为a.txt和b.txt，其中a.txt编码方式是gbk,而b.txt的编码方式是utf8。要求将使用转换流实现如下功能：
* 将a.txt和b.txt文件的内容复制到c.txt文件中，保证内容不乱码。
	 * @throws IOException 

	 */
	static void question11() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("day12.txt"),"utf-8"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("b11.txt"),"gbk"));
		char[] chars = new char[1024];
		int len = -1;
		while((len=br.read(chars))!=-1){
			bw.write(chars, 0, len);
			bw.flush();
		}
		closeIO(bw,br);
		
	}
	
	
	static void closeIO(Closeable...ios){
		if(ios==null){
			return;
		}
		for(Closeable io:ios){
			if(io!=null){
				try {
					io.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
}
