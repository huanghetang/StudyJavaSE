package javaABC;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 	键盘录入一个文件夹路径,统计该文件夹(包含子文件夹)中每种类型的文件及个数
	注意:用文件类型(后缀名,不包含.(点),如："java","txt")作为key,
	用个数作为value,放入到map集合中,并用两种方式遍历map集合
	例如：
	doc 的类型的文件有  3 个
	java 的类型的文件有  5 个
	txt 的类型的文件有  7 个
 *
 */
public class Text17 {
	public static void main(String[] args) {
//		Scanner sc=new Scanner(System.in);
//		System.out.println("请输入指定路径");
//		String src = sc.nextLine();
		//封装路径
		File file=new File("d:/bin/engines/");
		
		
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		map.put("exe", getFileNumber(file,"exe"));
//		map.put("dll", getFileNumber(file,"dll"));
//		map.put("txt", getFileNumber(file,"txt"));
		System.out.println(map);
	}

	private static int getFileNumber(File file,String s) {
		//使用增强for循环和过滤器选出需要的后缀名文件,方法一,通过File[]
		File[] files=getFileArray(file);
		
		int i=0;
		for(File f:files){
			System.out.println(f.getAbsolutePath());
			if(f.getName().endsWith(s)){
				i++;
			}
		}
		return i;
	}
	public static File[] getFileArray(File file) {
//		使用过滤器,取出所有的文件
		MyFileFilter filter = new MyFileFilter();
		File[] files=file.listFiles(filter);
		
		return files;
		
	}

}
class MyFileFilter implements FileFilter{
	@Override
	public boolean accept(File pathname) {
		if(pathname.isDirectory()){
			System.out.println("11111111111==="+pathname);
			Text17.getFileArray(pathname);
		}else{
			return true;
		}
		return false;
	}

	
}