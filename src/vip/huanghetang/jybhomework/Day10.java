package vip.huanghetang.jybhomework;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Day10 {

	public static void main(String[] args) {
		// deleteFile2("d:/doc4");
//		System.out.println(getFactorial(7));;
//		question13("d:/bin");
		File file = new File("d:/bin");
//		printFileByFileSuffix(file);
//		System.out.println(file.length());
//		question16(file,0);
		HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
		System.out.println(hashMap);
		question17(file,hashMap);
		System.out.println(hashMap);
		Set<Map.Entry<String,Integer>> entrySet = hashMap.entrySet();
		for (Map.Entry<String, Integer> entry : entrySet) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key+"类型的文件有"+value+"个");
		}
		System.out.println("===================");
	}

	/**
	 * 1.相对路径和绝对路径的使用 1.2． 训练描述 创建两个文件对象，分别使用相对路径和绝对路径创建。 1.3． 操作步骤描述 1.
	 * 绝对路径创建文件对象：使用File类一个参数的构造方法。 2. 相对路径创建文件对象：使用File类两个参数的构造方法。
	 * 
	 */
	static void question1() {
		// File f1 = new File("question1");
		// File f1 = new File("D:/doc4/sve.exe");
		File f1 = new File("D:/doc4/", "test");
		try {
			f1.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String absolutePath = f1.getAbsolutePath();
		System.out.println(absolutePath);
		String path = f1.getPath();
		System.out.println(path);
	}

	/**
	 * 1.检查文件是否存在 2.文件的创建 2.2． 训练描述 检查C盘下是否存在文件a.txt,如果不存在则创建该文件。 2.3． 操作步骤描述 1.
	 * 使用绝对路径创建对象关联到c盘的a.txt。 2. 通过文件对象方法判断文件是否存在。 3. 不存在则调用创建文件的方法创建文件。
	 * 
	 * @throws IOException
	 * 
	 */
	static void question2() throws IOException {
		File file = new File("D:/doc4");
		File f1 = new File(file, "test1");
		if (f1.exists()) {
			f1.delete();
		}
		System.out.println(f1.exists());
		boolean mkdir = f1.mkdir();
		boolean createNewFile = f1.createNewFile();
		System.out.println(createNewFile + "," + mkdir);
		// if(!f1.exists()){
		// f1.createNewFile();
		// f1.mkdir();
		// }
		System.out.println(f1.exists());

	}

	/**
	 * 1.单级文件夹的创建 3.2． 训练描述 在C盘下创建一个名为bbb的文件夹。 3.3． 操作步骤描述 1. 创建文件对象指定路径为c:/bbb
	 * 2. 调用文件对象创建文件夹的方法
	 * 
	 */
	static void question3() {
		File file = new File("c:\\bbb");
		if (file.exists()) {
			file.delete();
		}
		// System.out.println("file:"+file.exists());
		// if(!file.exists()){
		// file.mkdirs();
		// }
		// System.out.println("file:"+file.exists());
	}

	/**
	 * 1.多级文件夹的创建 4.2． 训练描述 在C盘下创建一个名为ccc的文件夹，要求如下： 1.ccc文件夹中要求包含bbb子文件夹
	 * 2.bbb子文件夹要求包含aaa文件夹 4.3． 操作步骤描述 1. 创建文件对象关联路径：c:/ccc/bbb/aaa 2.
	 * 调用文件对象创建多级文件夹的方法
	 * 
	 */
	static void question4() {
		File file = new File("d:/ccc/bbb/aaa");
		if (!file.exists()) {
			boolean mkdirs = file.mkdirs();
			System.out.println(mkdirs);
		}
		if (file.exists()) {

			boolean delete = file.delete();
			System.out.println(delete);
		}
		System.out.println(file.exists());
	}

	/**
	 * 5.2． 训练描述 将C盘下a.txt文件删除 将C盘下aaa文件夹删除,要求文件夹aaa是一个空文件夹。 5.3． 操作步骤描述 1.
	 * 创建文件对象关联路径：c:/a.txt 2. 调用文件对象删除文件的方法 3. 创建文件对象关联路径：c:/aaa 4.
	 * 调用文件对象删除文件的方法
	 * 
	 */
	static void question5() {
		File file = new File("d:/a.txt");

		if (!file.exists()) {
			System.out.println("文件" + file.getPath() + "不存在,正在创建");
		}
		boolean b = deleteFile2("d:a.txt");
		if (b)
			System.out.println(file.getAbsolutePath() + "删除成功");

	}

	/**
	 * 1. 获取文件信息：文件名，文件大小，文件的绝对路径，文件的父路径 6.2． 训练描述
	 * 获取C盘aaa文件夹中b.txt文件的文件名，文件大小，文件的绝对路径和父路径等信息，并将信息输出在控制台。 6.3． 操作步骤描述 1.
	 * 在c盘aaa文件夹中创建一个b.txt文件并输入数据 2. 创建文件对象关联路径：c:/aaa/b.txt 3.
	 * 调用文件对象的相关方法获得信息并输出。可以通过API帮助文档查询方法。
	 * 
	 */
	static void question6() {
		File file = new File("d:/bin/SlikSvn-libintl.dll");
		System.out.println(file.length());
		System.out.println(file.getParent());
	}
	
	/**
	 * 1.判断File对象是否文件,是文件则输出：xxx是一个文件，否则输出：xxx是不是一个文件。
	 * 2.判断File对象是否文件夹,是文件夹则输出：xxx是一个文件夹，否则输出：xxx是不是一个文件夹。(xxx是文件名或文件夹名) 7.3．
	 * 操作步骤描述 1. 创建两个文件对象分别关联到不同的文件，比如：c:/a.txt，c:/aaa 2.
	 * 调用文件对象的判断是否是文件或是否是文件夹的方法 3. 获得文件名，根据判断结果输出信息。
	 * 
	 */
	static void question7(){
		File file = new File("d:/bin/");
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());
		
	}
	
	/**
	 * 获取指定文件夹下所有的文件，并将所有文件的名字输出到控制台。 注意：不包含子文件夹下的文件 8.3． 操作步骤描述 1.
	 * 创建文件对象关联到指定文件夹，比如：c:/aaa 2. 调用文件对象的listFiles方法获得文件数组 3.
	 * 遍历文件数组将每一个文件的名字输出到控制台
	 * 
	 */
	static void question8(){
		File file = new File("d:/bin");
		System.out.println(file.getAbsolutePath());
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for (File file2 : files) {
				System.out.println(file2.getName());
			}
		}
		
	}
	
//	求1到n的和(n>=100 && n<=200)
	static void question9(){
		int count = 0;
		for(int i=1;i<=100;i++){
			count += i;
		}
		System.out.println(count);
		System.out.println(getSum(100));
		
		
	}
	static int getSum(int i){
		if(i==1){
			return 1;
		}else{
			return getSum(i-1)+i;
		}
		
	}
	/**
	 * 求整数n的阶乘(n <=10)
	 */
	static int getFactorial(int n){
		if(n==1){
			return 1;
		}else{
			return n*getFactorial(n-1);
		}
		
	}
	/**
	 * 键盘录入一个文件路径，根据文件路径创建File对象
如果输入的文件路径对应的文件不存在，则创建该文件。
如果输入的文件路径对应的文件已经存在了，则获得文件大小并输出。

	 */
		static void question10(){
			Scanner scanner = new Scanner(System.in);
			String string = scanner.nextLine();
			File file = new File(string);
			if(file.exists()){
				System.out.println(file.length());
				System.out.println(file);
			}else{
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		/**
		 * 键盘录入一个文件路径，根据文件路径创建文件对象，判断是文件还是文件夹
如果是文件，则输出文件的大小
如果是文件夹，则计算该文件夹下所有文件大小之和并输出(不包含子文件夹)。

		 */
		static void question11(){
			Scanner scanner = new Scanner(Day10.class.getResourceAsStream("Day10.properties"));
			String nextLine = scanner.nextLine();
			File file = new File(nextLine);
			long size = 0;
			if(file.isDirectory()){
				File[] listFiles = file.listFiles();
				for (File file2 : listFiles) {
					size +=file2.length();
				}
			}else{
				size = file.length();
			}
			System.out.println(nextLine+"的大小为:"+size/1024l/1024l+"M");
		}
		
		
		/**
		 * 递归遍历将指定文件夹的所有文件(包括所有子文件夹的文件)的全路径输出在控制台。
		 */
		static void question12(String fileName){
			File file = new File(fileName);
			if(file.isDirectory()){
				File[] files = file.listFiles();
				for (File file2 : files) {
					question12(file2.getAbsolutePath());
				}
			}else{
				System.out.println(file.getPath());
			}
			
		}
		
		/**
		 * 获得指定文件夹下所有的java文件(不考虑子文件夹的)并输出到控制台
		 */
		static void question13(String fileName){
			File file = new File(fileName);
			if(file.isDirectory()){
				String[] fileNames = file.list(new FilenameFilter() {
					@Override
					public boolean accept(File dir, String name) {//dir 表示当前file对象, name表示 file字目录下面的每一个文件名
						if(name.endsWith(".exe"))
							return true;
						else 
							return false;
					}
				});
				for (String string : fileNames) {
					System.out.println(string);
				}
			}else{
				 if(file.getName().endsWith(".exe")){
					 System.out.println(file.getName());
				 }
			}
			
		}
		
		/**
		 * 使用文件过滤器筛选将指定文件夹下的小于200K的小文件获取并打印(包括所有子文件夹的文件)。
		 */
		static void question14(File file){
			if(file.isDirectory()){
				File[] files = file.listFiles(new FileFilter() {
					
					@Override
					public boolean accept(File pathname) {
						if(pathname.length()>200*1024)
							return true;
						return false;
					}
				});
				for (File file2 : files) {
					System.out.println(file2.getName()+"大小为:"+(int)Math.ceil(file2.length()/1024d)+"K");
					
				}
			}
			
		}
		/**
		 * 键盘录入一个文件夹路径，删除该路径下的文件夹。
			要求：文件夹中包含有子文件夹

		 * @param file
		 */
		
		/**
	 * 从键盘接收一个文件夹路径,把文件夹中的所有文件以及文件夹的名字按层级打印 例如:
	 * aaa是文件夹,里面有bbb.txt,ccc.txt,ddd.txt这些文件,有eee这样的文件夹,eee中有fff.txt和ggg.txt,
	 * 打印出层级来 aaa bbb.txt ccc.txt ddd.txt eee fff.txt ggg.txt
	 * 
	 * @param file
	 */
		static void question16(File file,int leval){
			for(int i=0;i<leval;i++){
				System.out.print("\t");
			}
			System.out.println(file);
			if(file.isDirectory()){//是目录
				File[] files = file.listFiles();
				for (File file2 : files) {
					question16(file2,leval+1);
				}
			}
			
			
		}
		static String getT(int n){
			if(n==1){
				return "\t";
				
			}else if(n==0){
				return "";
			}else{
				return "\t"+getT(n-1);
			}
			
		}
		
		
		/**
	 * 键盘录入一个文件夹路径,统计该文件夹(包含子文件夹)中每种类型的文件及个数
	 * 注意:用文件类型(后缀名,不包含.(点),如："java","txt")作为key,
	 * 用个数作为value,放入到map集合中,并用两种方式遍历map集合 例如： doc 的类型的文件有 3 个 java 的类型的文件有 5 个
	 * txt 的类型的文件有 7 个
	 * 
	 */
		
		static void question17(File file,HashMap<String,Integer> hashMap){
			if(file.isDirectory()){
				System.out.println(1);
				File[] files = file.listFiles();
				for (File file2 : files) {
					question17(file2,hashMap);
				}
			}else{//是文件 
				System.out.println(2);
				String suffix  = file.getName().split("\\.")[1];//获取后缀名
				boolean flag = hashMap.containsKey(suffix);
				if(flag){
					hashMap.put(suffix, hashMap.get(suffix)+1);
				}else{
					hashMap.put(suffix, 1);
				}
			}
			
		}
		
		static void printFileByFileSuffix(File  file){
			if(file.isDirectory()){
//				File[] files = file.listFiles(new FilenameFilter() {
//					@Override
//					public boolean accept(File dir, String name) {
//							if(name.endsWith(".exe"))
//								return true;
//							else
//								return false;
//					}
//				});
//				for (File file2 : files) {
//					System.out.println(file2.getName());
//				}
				File[] files = file.listFiles(new FileFilter() {
					
					@Override
					public boolean accept(File pathname) {
						// TODO Auto-generated method stub
						if(pathname.getName().endsWith(".exe")){
							return true;
						}
						return false;
					}
				});
				for (int i = 0; i < files.length; i++) {
					System.out.println(files[i].getName());
				}
				
			}
			
		}
	/* static void deleteFile(String filePath){
	 File file = new File(filePath);
	 if(file.exists()){//文件存在
	 if(file.isDirectory()){//文件是目录
	 boolean delete = file.delete();
	 if(delete){//空文件夹
	 System.out.println(file.getAbsolutePath()+"删除成功");
	 }else{//目录下面有子文件时删除失败
	 File[] files =file.listFiles();//获取子目录
	 for (File file2 : files) { //遍历
	 deleteFile(file2.getAbsolutePath());//迭代
	 }
	 boolean d2 = file.delete();
	 if(d2){//空文件夹
	 System.out.println(file.getAbsolutePath()+"删除成功");
	 }else{
	 System.out.println(file.getAbsolutePath()+"删除失败");
	 }
	
	 }
	 }else{//文件对象对应的是文件
	 boolean delete = file.delete();
	 if(delete){
	 System.out.println(file.getAbsolutePath()+"删除成功");
	 }else{
	 System.out.println(file.getAbsolutePath()+"删除失败");
	 }
	
	 }
	 }
	
	 }*/
	

	/**
	 * 删除一个文件夹
	 * 
	 * @param filePath
	 */
	static boolean deleteFile2(String filePath) {
		File file = new File(filePath);
		if (file.exists()) {// 文件存在
			boolean delete = file.delete();
			if (delete) {
				System.out.println(file.getAbsolutePath() + "删除成功");
			} else {// 文件下面有子文件删不掉
				File[] files = file.listFiles();// 获取子目录
				for (File file2 : files) { // 遍历
					deleteFile2(file2.getAbsolutePath());// 迭代
				}
				boolean d2 = file.delete();// 子文件删除后再次删除文件夹
				if (d2) {// 空文件夹
					System.out.println(file.getAbsolutePath() + "删除成功");
				} else {
					System.out.println("删除出问题了-----------------------");
					return false;
				}
			}
		}
		return true;
	}

}
