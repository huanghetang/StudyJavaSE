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
	 * 1.�ֽ������д���ֽ����� 
	 *  2�����ֽ������һ��дһ���ֽڵķ�ʽ��C�̵�a.txt�ļ�������ݡ�
	 *  3.�ļ�����д�ͻ������
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
	 * �ӿ���̨ѭ�������û�¼���ѧ����Ϣ�������ʽΪ��ѧ��-ѧ������
��ѧ����Ϣ���浽C�������stu.txt�ļ��У�һ��ѧ����Ϣռ��һ�����ݡ�
���û�����endʱֹͣ���롣
* Ҫ��ʹ���ֽ������д������
	 * @throws IOException 

	 */
	@SuppressWarnings("resource")
	static void question2() throws IOException{
		System.out.println("������ѧ��-ѧ������.'end'ֹͣ.");
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
	 * ��C������һ���ı��ļ�test.txt(��������������ֺ���ĸ���)
����һ������ͳ��test.txt�ļ���ָ���ַ����ֵĴ�����
����a�ַ����ļ��г�����10������÷�������a�󣬷����ڲ������a����10��
	 * @throws IOException 

	 */
	static void question4(Character c) throws IOException{
		int count = 0;
		FileInputStream fos = new FileInputStream("a.txt");
		byte[] bys = new byte[1024*1024*1];
		int content = -1;
		while((content=fos.read(bys))!=-1){
			for(int i=0;i<content;i++){//ע����Ч�ַ���
				if(c==bys[i]){
					count++;
				}
			}
		}
		fos.close();
		System.out.println(c+"����"+count+"��");
		
	}
	/**
	 * ʹ�ü��ϴ洢10��1-50(��50)�����ż��Ԫ��,Ҫ�����ֲ����ظ�,��ָ����ʽ�����C�̵�num.txt��,����: 48,44,40,38,34,30,26...... 
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
	 * ��d��Ŀ¼����һ�������ļ�a.txt���ļ���ֻ��Ӣ�ĺ����֣��������ǡ�heima��
������������ȷʱ���ܶ�ȡ�ļ�������ݡ���Ҫ���ô�����ģ���ȡ�ļ��Ĺ��̣���ͳ���ļ��������ĸ���ֵĴ���������ͳ�ƽ���������¸�ʽ�����d�̵�count.txt�С�
a��2��
b��3��
c��4��

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
					Character key = (char)bys[i];//ֻ��Ӣ�ĺ�����
					Integer value = map.get(key);
					if(value==null){
						map.put(key, 1);
					}else{
						map.put(key,value+1);
					}
				}
			}
			//����map��ÿһ��д��ȥ
			Set<Character> keyset = map.keySet();
			for(Character c:keyset){
				Integer value = map.get(c);
				String writeStr = c+"������"+value+"��"+System.lineSeparator();
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
	 * �ӿ���̨��ȡ������ļ�Ŀ¼Ȼ�󽫸�Ŀ¼(������Ŀ¼)�µ�.java�ļ����Ƶ�D:/java�ļ�����,��ͳ��java�ļ��ĸ���.
	 * ��ʾ:�������ͬ�����Ƶ��ļ�,�������Test01.java,�򿽱���Ŀ���ļ���ʱֻ����һ��Test01.java,��һ��Test01.
	 * javaҪ�޸�Ϊ��һ������:�����ƿ��������,ֻҪ���ظ�����.
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
			String fileName  = srcFile.getName();//file2���ܻ����ͬ��
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
		System.out.println(".java����"+count+"��");
		
		
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
					//���ļ�
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
		System.out.println("������һ���ļ�Ŀ¼:");
		Scanner scanner = new Scanner(System.in);
		String path = scanner.nextLine();
		File file = new File(path);
		if(!file.exists()){
			throw new RuntimeException("�������Ŀ¼������");
		}
		if(!file.isDirectory()){
			throw new RuntimeException("�������·������һ���ļ���");
		}
		return file;
	}

	/**
	 * ����һ���ļ���
	 * @throws IOException 
	 *
	 */
	static void copyDirectory(File srcFile,File destFile) throws IOException{
		if(srcFile.isDirectory()){//��Ŀ¼
			File[] files = srcFile.listFiles();
			for (File file : files) {
				File newDestFile = new File(destFile,file.getName());//���ļ���·��
				copyDirectory(file,newDestFile);
			}
		}else{//���ļ�
			FileInputStream fis = new FileInputStream(srcFile);
			if(!destFile.getParentFile().exists()){//�жϵ�ǰҪ�������ļ���û�и�·��
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
		if(!delete){//������Ŀ¼
			File[] fiels = file.listFiles();
			for (File file2 : fiels) {
				deleteDirectory(file2);
			}
			file.delete();
		}
		
	}
}
