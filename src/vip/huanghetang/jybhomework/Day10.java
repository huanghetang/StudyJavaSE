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
			System.out.println(key+"���͵��ļ���"+value+"��");
		}
		System.out.println("===================");
	}

	/**
	 * 1.���·���;���·����ʹ�� 1.2�� ѵ������ ���������ļ����󣬷ֱ�ʹ�����·���;���·�������� 1.3�� ������������ 1.
	 * ����·�������ļ�����ʹ��File��һ�������Ĺ��췽���� 2. ���·�������ļ�����ʹ��File�����������Ĺ��췽����
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
	 * 1.����ļ��Ƿ���� 2.�ļ��Ĵ��� 2.2�� ѵ������ ���C�����Ƿ�����ļ�a.txt,����������򴴽����ļ��� 2.3�� ������������ 1.
	 * ʹ�þ���·���������������c�̵�a.txt�� 2. ͨ���ļ����󷽷��ж��ļ��Ƿ���ڡ� 3. ����������ô����ļ��ķ��������ļ���
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
	 * 1.�����ļ��еĴ��� 3.2�� ѵ������ ��C���´���һ����Ϊbbb���ļ��С� 3.3�� ������������ 1. �����ļ�����ָ��·��Ϊc:/bbb
	 * 2. �����ļ����󴴽��ļ��еķ���
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
	 * 1.�༶�ļ��еĴ��� 4.2�� ѵ������ ��C���´���һ����Ϊccc���ļ��У�Ҫ�����£� 1.ccc�ļ�����Ҫ�����bbb���ļ���
	 * 2.bbb���ļ���Ҫ�����aaa�ļ��� 4.3�� ������������ 1. �����ļ��������·����c:/ccc/bbb/aaa 2.
	 * �����ļ����󴴽��༶�ļ��еķ���
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
	 * 5.2�� ѵ������ ��C����a.txt�ļ�ɾ�� ��C����aaa�ļ���ɾ��,Ҫ���ļ���aaa��һ�����ļ��С� 5.3�� ������������ 1.
	 * �����ļ��������·����c:/a.txt 2. �����ļ�����ɾ���ļ��ķ��� 3. �����ļ��������·����c:/aaa 4.
	 * �����ļ�����ɾ���ļ��ķ���
	 * 
	 */
	static void question5() {
		File file = new File("d:/a.txt");

		if (!file.exists()) {
			System.out.println("�ļ�" + file.getPath() + "������,���ڴ���");
		}
		boolean b = deleteFile2("d:a.txt");
		if (b)
			System.out.println(file.getAbsolutePath() + "ɾ���ɹ�");

	}

	/**
	 * 1. ��ȡ�ļ���Ϣ���ļ������ļ���С���ļ��ľ���·�����ļ��ĸ�·�� 6.2�� ѵ������
	 * ��ȡC��aaa�ļ�����b.txt�ļ����ļ������ļ���С���ļ��ľ���·���͸�·������Ϣ��������Ϣ����ڿ���̨�� 6.3�� ������������ 1.
	 * ��c��aaa�ļ����д���һ��b.txt�ļ����������� 2. �����ļ��������·����c:/aaa/b.txt 3.
	 * �����ļ��������ط��������Ϣ�����������ͨ��API�����ĵ���ѯ������
	 * 
	 */
	static void question6() {
		File file = new File("d:/bin/SlikSvn-libintl.dll");
		System.out.println(file.length());
		System.out.println(file.getParent());
	}
	
	/**
	 * 1.�ж�File�����Ƿ��ļ�,���ļ��������xxx��һ���ļ������������xxx�ǲ���һ���ļ���
	 * 2.�ж�File�����Ƿ��ļ���,���ļ����������xxx��һ���ļ��У����������xxx�ǲ���һ���ļ��С�(xxx���ļ������ļ�����) 7.3��
	 * ������������ 1. ���������ļ�����ֱ��������ͬ���ļ������磺c:/a.txt��c:/aaa 2.
	 * �����ļ�������ж��Ƿ����ļ����Ƿ����ļ��еķ��� 3. ����ļ����������жϽ�������Ϣ��
	 * 
	 */
	static void question7(){
		File file = new File("d:/bin/");
		System.out.println(file.isFile());
		System.out.println(file.isDirectory());
		
	}
	
	/**
	 * ��ȡָ���ļ��������е��ļ������������ļ����������������̨�� ע�⣺���������ļ����µ��ļ� 8.3�� ������������ 1.
	 * �����ļ����������ָ���ļ��У����磺c:/aaa 2. �����ļ������listFiles��������ļ����� 3.
	 * �����ļ����齫ÿһ���ļ����������������̨
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
	
//	��1��n�ĺ�(n>=100 && n<=200)
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
	 * ������n�Ľ׳�(n <=10)
	 */
	static int getFactorial(int n){
		if(n==1){
			return 1;
		}else{
			return n*getFactorial(n-1);
		}
		
	}
	/**
	 * ����¼��һ���ļ�·���������ļ�·������File����
���������ļ�·����Ӧ���ļ������ڣ��򴴽����ļ���
���������ļ�·����Ӧ���ļ��Ѿ������ˣ������ļ���С�������

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
		 * ����¼��һ���ļ�·���������ļ�·�������ļ������ж����ļ������ļ���
������ļ���������ļ��Ĵ�С
������ļ��У��������ļ����������ļ���С֮�Ͳ����(���������ļ���)��

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
			System.out.println(nextLine+"�Ĵ�СΪ:"+size/1024l/1024l+"M");
		}
		
		
		/**
		 * �ݹ������ָ���ļ��е������ļ�(�����������ļ��е��ļ�)��ȫ·������ڿ���̨��
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
		 * ���ָ���ļ��������е�java�ļ�(���������ļ��е�)�����������̨
		 */
		static void question13(String fileName){
			File file = new File(fileName);
			if(file.isDirectory()){
				String[] fileNames = file.list(new FilenameFilter() {
					@Override
					public boolean accept(File dir, String name) {//dir ��ʾ��ǰfile����, name��ʾ file��Ŀ¼�����ÿһ���ļ���
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
		 * ʹ���ļ�������ɸѡ��ָ���ļ����µ�С��200K��С�ļ���ȡ����ӡ(�����������ļ��е��ļ�)��
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
					System.out.println(file2.getName()+"��СΪ:"+(int)Math.ceil(file2.length()/1024d)+"K");
					
				}
			}
			
		}
		/**
		 * ����¼��һ���ļ���·����ɾ����·���µ��ļ��С�
			Ҫ���ļ����а��������ļ���

		 * @param file
		 */
		
		/**
	 * �Ӽ��̽���һ���ļ���·��,���ļ����е������ļ��Լ��ļ��е����ְ��㼶��ӡ ����:
	 * aaa���ļ���,������bbb.txt,ccc.txt,ddd.txt��Щ�ļ�,��eee�������ļ���,eee����fff.txt��ggg.txt,
	 * ��ӡ���㼶�� aaa bbb.txt ccc.txt ddd.txt eee fff.txt ggg.txt
	 * 
	 * @param file
	 */
		static void question16(File file,int leval){
			for(int i=0;i<leval;i++){
				System.out.print("\t");
			}
			System.out.println(file);
			if(file.isDirectory()){//��Ŀ¼
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
	 * ����¼��һ���ļ���·��,ͳ�Ƹ��ļ���(�������ļ���)��ÿ�����͵��ļ�������
	 * ע��:���ļ�����(��׺��,������.(��),�磺"java","txt")��Ϊkey,
	 * �ø�����Ϊvalue,���뵽map������,�������ַ�ʽ����map���� ���磺 doc �����͵��ļ��� 3 �� java �����͵��ļ��� 5 ��
	 * txt �����͵��ļ��� 7 ��
	 * 
	 */
		
		static void question17(File file,HashMap<String,Integer> hashMap){
			if(file.isDirectory()){
				System.out.println(1);
				File[] files = file.listFiles();
				for (File file2 : files) {
					question17(file2,hashMap);
				}
			}else{//���ļ� 
				System.out.println(2);
				String suffix  = file.getName().split("\\.")[1];//��ȡ��׺��
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
	 if(file.exists()){//�ļ�����
	 if(file.isDirectory()){//�ļ���Ŀ¼
	 boolean delete = file.delete();
	 if(delete){//���ļ���
	 System.out.println(file.getAbsolutePath()+"ɾ���ɹ�");
	 }else{//Ŀ¼���������ļ�ʱɾ��ʧ��
	 File[] files =file.listFiles();//��ȡ��Ŀ¼
	 for (File file2 : files) { //����
	 deleteFile(file2.getAbsolutePath());//����
	 }
	 boolean d2 = file.delete();
	 if(d2){//���ļ���
	 System.out.println(file.getAbsolutePath()+"ɾ���ɹ�");
	 }else{
	 System.out.println(file.getAbsolutePath()+"ɾ��ʧ��");
	 }
	
	 }
	 }else{//�ļ������Ӧ�����ļ�
	 boolean delete = file.delete();
	 if(delete){
	 System.out.println(file.getAbsolutePath()+"ɾ���ɹ�");
	 }else{
	 System.out.println(file.getAbsolutePath()+"ɾ��ʧ��");
	 }
	
	 }
	 }
	
	 }*/
	

	/**
	 * ɾ��һ���ļ���
	 * 
	 * @param filePath
	 */
	static boolean deleteFile2(String filePath) {
		File file = new File(filePath);
		if (file.exists()) {// �ļ�����
			boolean delete = file.delete();
			if (delete) {
				System.out.println(file.getAbsolutePath() + "ɾ���ɹ�");
			} else {// �ļ����������ļ�ɾ����
				File[] files = file.listFiles();// ��ȡ��Ŀ¼
				for (File file2 : files) { // ����
					deleteFile2(file2.getAbsolutePath());// ����
				}
				boolean d2 = file.delete();// ���ļ�ɾ�����ٴ�ɾ���ļ���
				if (d2) {// ���ļ���
					System.out.println(file.getAbsolutePath() + "ɾ���ɹ�");
				} else {
					System.out.println("ɾ����������-----------------------");
					return false;
				}
			}
		}
		return true;
	}

}
