package vip.huanghetang.jybhomework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Test03_03 {
// 定义统计变量记录Java文件的总数
	static int count = 0;
	public static void main(String[] args) throws IOException{
		// 获得源文件夹
		File srcDir = inputFile();
		// 创建目标文件夹对象
		File destDir = new File("d:/java");
		destDir.mkdirs();
		// 拷贝Java文件
		copyJavaFile(srcDir, destDir);
		System.out.println("count = " + count);
	}
	
	/*
	 * 将srcDir文件夹下的所有.Java文件拷贝到destDir文件夹下
	 */
	public static void copyJavaFile(File srcDir,File destDir) throws IOException{
		// 获得源文件夹下所有的.java文件和子文件夹
		File[] files = srcDir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				if(pathname.isDirectory() || pathname.getName().endsWith(".java"))return true;
				return false;
			}
		});
		// 遍历文件数组
		for (File file : files) {
			// 判断file是否是文件夹
			if(file.isDirectory()) {
				// 递归调用当前方法
				copyJavaFile(file, destDir);
			} else { // 如果是文件,拷贝到目标文件夹destDir下
				// 获得要拷贝的文件名
				String fileName = file.getName(); 
				// 在目标文件夹destDir下创建一个同名文件名
				File destFile = new File(destDir,fileName); 
				// 判断目标文件是否存在
				while(destFile.exists()) {
					// 重命名目标文件名 
					destFile = new File(destDir,new Random().nextInt(100000) + fileName);
				}
				System.out.println(destFile);
				copyFile(file, destFile);
			}
		}
	}
	
	/*
	 * 字节流缓冲区流读写字节数组 
	 */
	private static void copyFile(File srcFile, File destFile) throws IOException {
		// 计数器加一
		count ++;
		// 创建字节缓冲输入流
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
		// 创建字节缓冲输出流
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
		
		int len = 0;
		byte[] buffer = new byte[1024];
		// 循环读取数据
		while((len = bis.read(buffer)) !=-1) {
			// 利用输出流往输出目的写数据
			bos.write(buffer,0,len);
		}
		
		// 关闭资源
		bis.close();
		bos.close();
	}
	
	/*
	 * 根据用户输入的路径字符串创建文件对象 
	 */
	private static File inputFile() {
		// 创建键盘输入对象
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个文件夹路径：");
		// 接收用户输入的路径
		String filePath = sc.nextLine();
		// 根据路径字符串创建文件对象
		File dir = new File(filePath);
		if(!dir.exists()) throw new RuntimeException("你输入的文件路径不存在！！！");
		// 判断是否是文件夹
		if(!dir.isDirectory()){
			throw new RuntimeException("输入的路径不是文件夹路径！！！");
		}
		return dir;
	}
}
