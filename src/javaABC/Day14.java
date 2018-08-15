package javaABC;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Day14 {

	public static void main(String[] args) {
//		File file = new File("D:\\xmlÎÄ¼þ");
//		MyListFiles(file,new FilenameFilter() {
//			@Override
//			public boolean accept(File dir, String name) {
//				if(dir.getPath().endsWith(name)){
//					return true;
//				}
//				return false;
//			}
//		});
//		
//		System.out.println(fun(5));;
//		File file = new File("d:/bin");
//		testWJ(file);
		File f = new File("a");
		System.out.println(f);
		File[] listFiles = f.listFiles();
		System.out.println(Arrays.toString(listFiles));
//		File[] files = null;
//		for(File f : files){
//			System.out.println(f);
//			
//		}
		
		
		
			
	}
	
	static void testWJ(File file){
		File[] listFiles = file.listFiles();
		for (File file2 : listFiles) {
			if(file2.isFile()){
				System.out.println(file2.getAbsolutePath());
			}else{
				testWJ(file2);
			}
			
		}
		
		
	}
	static void MyListFiles(File files,FilenameFilter filter){
		File[] fs = files.listFiles();
		for (File file : fs) {
			if(filter.accept(file, ".java")){
				System.out.println(file.getAbsolutePath());
			}
		}
	}
	
	static int fun(int n){
		if(n==1){
			return 1;
		}else {
			return n*fun(n-1); 
		}
	}

	static void testComparator(){
		ArrayList<Student> list = new ArrayList<Student>();
//		Student s1 = new Student("¾°Ìð",18);
//		Student s2 = new Student("´óbaby",28);
//		Student s3 = new Student("µÏÀöÈÈ°Í",21);
//		Student s4 = new Student("¹ÅÁ¦ÄÈÔú",19);
//		Student s5 = new Student("¾°Ìð",18);
//		list.add(s1);
//		list.add(s2);
//		list.add(s3);
//		list.add(s4);
//		list.add(s5);
		System.out.println(list);
//		Collections.sort(list);
//		Collections.sort(list, new Comparator<Student>() {
//			@Override
//			public int compare(Student o1, Student o2) {
//				int num1 = o2.getAge()-o1.getAge();
//				int num2 = num1==0?o2.getName().compareTo(o1.getName()):num1;
//				return num2;
//			}
//			
//			
//			
//		});
		System.out.println(list);
		
	}
	
	private static void testRuntimeException() {
		int a = 10;
		int b = 0;
		int c = 0;
		try{
			 c = a/b;
			
		}catch(ArithmeticException e){
			e.printStackTrace();
			
		}
		System.out.println(c);
		System.out.println("over");
	}
}	
