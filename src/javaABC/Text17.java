package javaABC;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 	����¼��һ���ļ���·��,ͳ�Ƹ��ļ���(�������ļ���)��ÿ�����͵��ļ�������
	ע��:���ļ�����(��׺��,������.(��),�磺"java","txt")��Ϊkey,
	�ø�����Ϊvalue,���뵽map������,�������ַ�ʽ����map����
	���磺
	doc �����͵��ļ���  3 ��
	java �����͵��ļ���  5 ��
	txt �����͵��ļ���  7 ��
 *
 */
public class Text17 {
	public static void main(String[] args) {
//		Scanner sc=new Scanner(System.in);
//		System.out.println("������ָ��·��");
//		String src = sc.nextLine();
		//��װ·��
		File file=new File("d:/bin/engines/");
		
		
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		map.put("exe", getFileNumber(file,"exe"));
//		map.put("dll", getFileNumber(file,"dll"));
//		map.put("txt", getFileNumber(file,"txt"));
		System.out.println(map);
	}

	private static int getFileNumber(File file,String s) {
		//ʹ����ǿforѭ���͹�����ѡ����Ҫ�ĺ�׺���ļ�,����һ,ͨ��File[]
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
//		ʹ�ù�����,ȡ�����е��ļ�
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