package vip.huanghetang.jybhomework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;

public class Day11 {
	public static void main(String[] args) throws IOException {
//		question1();
		File file = new File("d:/FileDoc/");
		File file2 = new File("d:/fd");
//		copyDirectory(file,file2);
//		deleteDirectory(file2);
//		question6();
		
//		File file = new File("d:/dd/fd");
//		if(!file.getParentFile().exists()){
//			file.getParentFile().mkdirs();
//		}
//		boolean mk = file.createNewFile();
//		System.out.println(mk);
//		question9(file,file2);
		lastQuestion();
//		System.out.println("123.java".indexOf("\\."));
	}
	
	/**
	 * 1.字节输出流写出字节数据 
	 *  2利用字节输出流一次写一个字节的方式向C盘的a.txt文件输出内容。
	 *  3.文件的续写和换行输出
	 * @throws IOException 
	 */
	@SuppressWarnings("resource")
	static void question1() throws IOException{
		FileOutputStream fos = new FileOutputStream("d:/day11homework.txt",true);
//		fos.write("this is my first question...".getBytes());
//		byte[] bys = "this is my first question".getBytes();
//		for(int i=0;i<bys.length;i++){
//			fos.write(bys[i]);
//		}
//		fos.close();
		
		fos.write("\r\ni love java".getBytes());
		fos.write((System.lineSeparator()+"i love java").getBytes());
		fos.close();
		
	}
	
	/**
	 * 从控制台循环接收用户录入的学生信息，输入格式为：学号-学生名字
将学生信息保存到C盘下面的stu.txt文件中，一个学生信息占据一行数据。
当用户输入end时停止输入。
* 要求使用字节输出流写出数据
	 * @throws IOException 

	 */
	@SuppressWarnings("resource")
	static void question2() throws IOException{
		System.out.println("请输入学号-学生名字.'end'停止.");
		Scanner scanner = new Scanner(System.in);
		FileOutputStream fos = new FileOutputStream("question2.txt");
		String str = "";
//		do{
//		  str = scanner.nextLine();
//		  fos.write(str.getBytes());
//		  fos.write(System.lineSeparator().getBytes());
//		}while(!"end".equals(str));
//		fos.close();
		
		while(true){
			str = scanner.nextLine();
			if("end".equals(str)){
				break;
			}
			  fos.write(str.getBytes());
			  fos.write(System.lineSeparator().getBytes());
		}
		fos.close();
	}
	
	/**
	 * 在C盘下有一个文本文件test.txt(里面的内容由数字和字母组成)
定义一个方法统计test.txt文件中指定字符出现的次数。
比如a字符在文件中出现了10次则调用方法传入a后，方法内部输出：a出现10次
	 * @throws IOException 

	 */
	static void question4(Character c) throws IOException{
		int count = 0;
		FileInputStream fos = new FileInputStream("a.txt");
		byte[] bys = new byte[1024*1024*1];
		int content = -1;
		while((content=fos.read(bys))!=-1){
			for(int i=0;i<content;i++){//注意有效字符数
				if(c==bys[i]){
					count++;
				}
			}
		}
		fos.close();
		System.out.println(c+"出现"+count+"次");
		
	}
	/**
	 * 使用集合存储10个1-50(含50)的随机偶数元素,要求数字不能重复,按指定格式输出到C盘的num.txt中,例如: 48,44,40,38,34,30,26...... 
	 * @throws IOException 
	 */
	static void question5() throws IOException{
		int count=0;
		Random random = new Random();
		HashSet<Integer> hashSet = new HashSet<Integer>();
		while(count<10){
			int temp = random.nextInt(50)+1;
			if(temp%2==0){
				boolean add = hashSet.add(temp);
				if(add){
					count++;
				}
			}
		}
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("a.txt"));
		StringBuilder sb = new StringBuilder();
		for(Integer i : hashSet){
			System.out.println(i);
			sb.append(i).append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		bos.write(sb.toString().getBytes());
		bos.close();
	}
	
	/**
	 * 在d盘目录下有一个加密文件a.txt（文件里只有英文和数字），密码是“heima”
当密码输入正确时才能读取文件里的数据。现要求用代码来模拟读取文件的过程，并统计文件里各个字母出现的次数，并把统计结果按照如下格式输出到d盘的count.txt中。
a：2个
b：3个
c：4个

	 */
	static void question6(){
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try{
			fis = new FileInputStream("a.txt");
			fos = new FileOutputStream("count.txt");
			HashMap<Character, Integer> map = new HashMap<Character,Integer>();
			byte[] bys = new byte[1024];
			int count = -1;
			while((count=fis.read(bys))!=-1){
				for(int i=0;i<count;i++){
					if((char)bys[i]=='\r' || (char)bys[i]=='\n' ){
						continue;
					}
					Character key = (char)bys[i];//只有英文和数字
					Integer value = map.get(key);
					if(value==null){
						map.put(key, 1);
					}else{
						map.put(key,value+1);
					}
				}
			}
			//遍历map把每一行写出去
			Set<Character> keyset = map.keySet();
			for(Character c:keyset){
				Integer value = map.get(c);
				String writeStr = c+"出现了"+value+"次"+System.lineSeparator();
				fos.write(writeStr.getBytes());
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			closeIO(fis,fos);
		}
		
		
	}
	static void closeIO(Closeable...ios){
		for (Closeable io : ios) {
			if(io!=null){
				try {
					io.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	/**
	 * 从控制台获取输入的文件目录然后将该目录(包含子目录)下的.java文件复制到D:/java文件夹中,并统计java文件的个数.
	 * 提示:如果有相同的名称的文件,如果两个Test01.java,则拷贝到目标文件夹时只能有一个Test01.java,另一个Test01.
	 * java要修改为另一个名称:该名称可随机生成,只要不重复即可.
	 * @throws IOException 
	 * 
	 */
	static HashSet<String> set  = new HashSet<String>();
	static void question9(File srcFile,File destFile) throws IOException{
		if(srcFile.isDirectory()){
			File[] files = srcFile.listFiles();
			for (File file2 : files) {
				question9(file2,destFile);
				System.out.println(file2.getName());
				
			}
		}else{
			String fileName  = srcFile.getName();//file2可能会出现同名
			if(fileName.endsWith(".java")){
				if(!set.contains(fileName)){
					set.add(fileName);
				}else{
					fileName = fileName.substring(0,fileName.indexOf("."))+UUID.randomUUID()+".java";
				}
				FileInputStream fis = new FileInputStream(srcFile);
				FileOutputStream fos = new FileOutputStream(destFile+"/"+fileName);
				byte[] bys = new byte[1024*1024*1];
				int count=-1;
				while((count=fis.read(bys))!=-1){
					fos.write(bys, 0, count);
				}
				fos.close();
				fis.close();
			}
	
		}
		
	}
	
	static void lastQuestion(){
		File srcFile = getFile();
		File  destFile = new File("d:/test");
		destFile.mkdir();
		System.out.println(srcFile);
		System.out.println(destFile);
		copySrc2dest(srcFile,destFile);
		System.out.println(".java共有"+count+"个");
		
		
	}
	

	private static void copySrc2dest(File srcFile, File destFile) {
			File[] files = srcFile.listFiles(new FileFilter(){
				@Override
				public boolean accept(File pathname) {
					if(pathname.isDirectory() || pathname.getName().endsWith(".java"))
						return true;
					return false;
				}
				
			});
			for (File file : files) {
				if(file.isDirectory()){
					copySrc2dest(file,destFile);
				}else{
					//是文件
					String fileName = file.getName();
					File copyFile = new File(destFile,fileName);
					while(copyFile.exists()){
						 copyFile = new File(destFile,new Random().nextInt(10000)+fileName);
					}
					try {
						copy(file,copyFile);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
				
			}
			
		
	}
	static int count=0;
	@SuppressWarnings("resource")
	private static void copy(File file, File copyFile) throws IOException {
		count++;
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(copyFile));
		byte[] bys = new byte[1024*1024*1];
		int count=-1;
		while((count=bis.read(bys))!=-1){
			bos.write(bys, 0, count);
		}
		bis.close();
		bos.close();
		System.out.println("==========================");
	}

	private static File getFile() {
		System.out.println("请输入一个文件目录:");
		Scanner scanner = new Scanner(System.in);
		String path = scanner.nextLine();
		File file = new File(path);
		if(!file.exists()){
			throw new RuntimeException("您输入的目录不存在");
		}
		if(!file.isDirectory()){
			throw new RuntimeException("您输入的路径不是一个文件夹");
		}
		return file;
	}

	/**
	 * 复制一个文件夹
	 * @throws IOException 
	 *
	 */
	static void copyDirectory(File srcFile,File destFile) throws IOException{
		if(srcFile.isDirectory()){//是目录
			File[] files = srcFile.listFiles();
			for (File file : files) {
				File newDestFile = new File(destFile,file.getName());//新文件的路径
				copyDirectory(file,newDestFile);
			}
		}else{//是文件
			FileInputStream fis = new FileInputStream(srcFile);
			if(!destFile.getParentFile().exists()){//判断当前要创建的文件有没有父路径
				destFile.getParentFile().mkdirs();
			}
			FileOutputStream fos = new FileOutputStream(destFile);
			byte[] bys = new byte[1024*1024*1];
			int content = -1;
			while((content = fis.read(bys))!=-1){
				fos.write(bys,0,content);
			}
			fos.close();
			fis.close();
		}
		
	}
	
	
	static void deleteDirectory(File file){
		boolean delete = file.delete();
		if(!delete){//存在字目录
			File[] fiels = file.listFiles();
			for (File file2 : fiels) {
				deleteDirectory(file2);
			}
			file.delete();
		}
		
	}
}
