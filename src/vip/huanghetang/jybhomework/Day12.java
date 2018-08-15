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
	 * 1.�ַ��������һ��дһ���ַ����ļ���
	 * 4:����һ�ַ��������Ұ�Java���������ַ������浽��ǰ��Ŀ��Ŀ¼�µ�a.txt�ļ��С�
			Ҫ��ʹ��utf8���뱣�档

	 */
	static void question1(){
//		FileWriter fw = null;
		OutputStreamWriter osw = null;
		try {
//			fw = new FileWriter("day12.txt");
			osw = new OutputStreamWriter(new FileOutputStream("day12.txt"),"utf-8");
//			fw.write("I");
//			fw.write(" love ����");
			osw.write("�Ұ�Java");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			closeIO(osw);
		}
	}

	/**
	 * ����ת������������ǰ��Ŀ��Ŀ¼��ʹ��utf8�����a.txt�ļ������ݶ�ȡ����������ӡ�ڿ���̨�ϡ� Ҫ�󣺲��ܳ�������������
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
	 * ����һ��ѧ���࣬�������������䣬�Ա�ȳ�Ա�������ṩsetters��getters�����Լ����췽�����ڲ������д���һ��ѧ������
	 * ��ѧ�������������Ա������ֵ��Ȼ�󽫸ö��󱣴浽��ǰ��Ŀ��Ŀ¼�µ�stu.txt�ļ��С�
	 * 
	 * @param ios
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	@SuppressWarnings("resource")
	static void question6() throws FileNotFoundException, IOException, ClassNotFoundException{
		Student2 s1 = new Student2("����",18,"Ů");
		Student2 s2 = new Student2("�����Ȱ�",18,"Ů");
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
	 * �Ӽ���¼��һ���ַ����������ֽڴ�ӡ���������ַ������浽��ǰ��Ŀ��Ŀ¼�µ�d.txt�ļ���
	 * 
	 * �����ַ���ӡ�����ַ������Ұ�Java�� ���浽��ǰ��Ŀ�ĸ�Ŀ¼�µ�e.txt�ļ��С�
	 * @throws IOException 
	 */
	@SuppressWarnings("resource")
	static void question7() throws IOException{
//		PrintStream printStream = new PrintStream(new FileOutputStream("day12.txt"),true,"utf-8");
//		printStream.print("this is my first printStrem ��ʹ��");
//		printStream.flush();
//		printStream.close();
		PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("day12.txt"),"utf-8"), true);
		printWriter.println("22this is my first printStrem ��ʹ��22");
		printWriter.close();
		System.out.println("over");
	}
	
	/**
	 * �ڵ�ǰ��Ŀ��Ŀ¼��׼����һ��test.txt ���ı��ļ���Ҫ����ı��ļ���ʹ��GBK���룬���������£� ��ǰ���¹� ���ǵ���˪ ��ͷ������
	 * ��ͷ˼����
	 * 
	 * �����ֽ���+��ת����������ı��ļ�����UTF8�ı��뷽ʽ����ȡ������д��test2.txt�ļ���
	 * 
	 * @param ios
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("resource")
	static void question8() throws UnsupportedEncodingException, IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("day12.txt"),"utf-8"));
		bw.write("��ǰ���¹�");
		bw.newLine();
		bw.write("���ǵ���˪ ��ͷ������",0,5);
		bw.newLine();
		bw.write("��ͷ������");;
		bw.newLine();
		bw.write(" ��ͷ˼����");
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
	 * ����һ��ѧ���࣬��Ա���������������䣬�Ա��ṩsetters��getters�����Լ����췽��
����һ�������࣬�ڲ����ഴ�����ѧ�����󱣴浽�����У�Ȼ�󽫼��ϴ洢����ǰ��Ŀ��Ŀ¼�µ�stus.txt�ļ��С�
	 * @throws IOException 
	 * @throws FileNotFoundException 

	 */
	static void question9() throws FileNotFoundException, IOException{
		Properties properties = new Properties();
//		properties.load(new FileInputStream("day12.properties"));
//		properties.setProperty("name", "����");
//		properties.setProperty("age", "18");
//		properties.setProperty("gender", "Ů");
//		properties.store(new FileOutputStream("day12.properties"), "this is first properties��ʹ��");
		properties.load(new FileInputStream("day12.properties"));
		Set<String> names = properties.stringPropertyNames();
		for(String name:names){
			System.out.println(name+"="+properties.getProperty(name));
		}
		
	}
	/**
	 * �Ӽ�������һ���ļ���·�������ô�ӡ�������ļ����µ������ļ�(�������ļ���)���Ƶ�D����temp�ļ����¡�
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
		System.out.println("������һ���ļ���·��:");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		File file = new File(str);
		if(!file.exists()){
			throw new RuntimeException("�������·��������");
		}
		if(!file.isDirectory()){
			throw new RuntimeException("�������·������һ���ļ���");
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
	 * C�����������ı��ļ����ֱ�Ϊa.txt��b.txt������a.txt���뷽ʽ��gbk,��b.txt�ı��뷽ʽ��utf8��Ҫ��ʹ��ת����ʵ�����¹��ܣ�
* ��a.txt��b.txt�ļ������ݸ��Ƶ�c.txt�ļ��У���֤���ݲ����롣
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
