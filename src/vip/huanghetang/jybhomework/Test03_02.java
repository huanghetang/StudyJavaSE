package vip.huanghetang.jybhomework;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Test03_02 {
public static void main(String[] args) throws IOException {
		// 获得文件夹对象
		File dir = inputFile();
		// 创建目标文件夹对象
		File destDir = new File("d:/temp");
		copyDir(dir,destDir);
	}
	/*
	 * 利用打印流将该文件夹下的所有文件(包括子文件夹)复制到D盘下temp文件夹下。
	 */
	public static void copyDir(File srcDir,File destDir) throws IOException{
		// 创建文件夹
		destDir.mkdirs();
		// 获得源文件夹下所有的文件和子文件夹
		File[] files = srcDir.listFiles();
		// 遍历文件数组
		for (File file : files) {
			File destFile = new File(destDir,file.getName()); 
			// 判断file是否是文件夹
			if(file.isDirectory()) {
				// 递归调用当前方法
				copyDir(file, destFile);
			} else { // 如果是文件,拷贝到目标文件夹destDir下
				copyFile(file, destFile);
			}
		}
	}
	
	/*
	 * 字节流缓冲区流读写字节数组 
	 */
	private static void copyFile(File srcFile, File destFile) throws IOException {
	
		// 创建字节缓冲输入流
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
		// 创建打印流对象
		PrintStream ps = new PrintStream(destFile);
		
		int len = 0;
		byte[] buffer = new byte[1024];
		// 循环读取数据
		while((len = bis.read(buffer)) !=-1) {
			// 利用输出流往输出目的写数据
			ps.write(buffer,0,len);
		}
		// 关闭资源
		bis.close();
		ps.close();
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
