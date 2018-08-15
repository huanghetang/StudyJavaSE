package vip.huanghetang.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Tools {
	public static void main(String[] args) throws IOException {
		int a = 1; double b =1.0 ; System.out.println( a == b );
//		copy2Dir("D:/bin","D:/doc4");
		copyDirectory(new File("d:/FileDoc"),new File("d:/temp"));
	}

	/**
	 * 判断一个整数是不是回文数  12321是回文数 1232不是回文数
	 * @param number
	 * @return boolean
	 */
	public static boolean isHWS(int number){
		int index=0;
//		int [] a = new int[index];
		int a[] = new int[10];//int型整数最大21亿 不超过10位数
		while(number>0){//循环这个数,依此由低位到高位,把每个位的数字放进数组
			a[index] = number%10;
			number = number/10;
			index++;
		}
//		for(int i=index-1;i>=0;i--){//打印这个数组  控制台出问题
//			System.out.print(a[i]+"");
//		}
		for(int i=0;i<index/2;i++){
			if(a[i]!=a[index-1-i]){
				return false;
			}
		}
		return true;
	}
	//打印一副扑克牌 大小王+52张牌(13张*4种花色)
	public static void printPoker(){
		String[] huase = {"♠","♥","♣","♦"};
		String[] paimian = {"A","2","3","4","5","6","7","8","9","10","J","Q","K",};
		for(int i=0;i<huase.length;i++){
			for(int j=0;j<paimian.length;j++){
				//3,4,5,6,7,8,9,10,J,Q,K,A,2
				System.out.print(huase[i]+paimian[j]+" ");
				
			}
			System.out.println();
		}
		System.out.println("大😎");
		System.out.println("小😎");
	}
	
	
//	定义一个工具类IOUtils，有以下方法，方法描述如下(以下操作只针对纯文本文件(.txt文件))：
//	1.copyFile2Dir(String srcFile,String destDir)
//	    参数String srcFile:要复制的源文件
//		参数String destDir:复制产生的新文件的存储路径(目标路径)
//		要求：将srcFile文件复制到destDir目标文件夹中(不能改变源文件的名称)

	
	public static void copyFile2Dir(String srcFile,String destDir) throws IOException{
//		File file1 = new File(srcFile);
//		File file2 = new File(destDir);
		BufferedReader br = new BufferedReader(new FileReader(srcFile));
		BufferedWriter bw = new BufferedWriter(new FileWriter(destDir)); 
//		char[] buffer = new char[1024*10];
//		int length=-1;
//		while((length=br.read(buffer))!=-1){
//			String str = new String(buffer,0,length);
//			byte[] bytes = str.getBytes("utf8");//乱码,乱码是因为本地的文件有的是ANSI编码,改成UTF8就可以了
//			bw.write(new String(bytes, "utf8"));
//			bw.flush();
//		}
		String str = null;
		while((str=br.readLine())!=null){
//			bw.write(System.lineSeparator());
			bw.write(str);
			bw.newLine();
			bw.flush();
		}
		br.close();
		bw.close();
	}

//	2.copyDir2Dir(String srcDir,String destDir)
//	参数File srcDir:要复制的源文件夹
//	参数File destDir:复制产生的新文件的存储路径(目标路径)
//	要求：将srcDir文件夹中的所有文件(不包含子文件夹)复制到destDir目标文件夹中(不能改变源文件的名称)
	/**
	 *  复制文件(只能复制字符文件) 递归调用
	 * @param srcDir 源文件夹
	 * @param destDir 目标文件夹,如果没有会自动创建 
	 * @throws IOException
	 */
	public static void copy2Dir(String srcDir,String destDir) throws IOException{
		File f1 = new File(srcDir);
		File f2 = new File(destDir);
		if(f1.isFile()){
			System.out.println("当前的srcDir为一个文件不是一个文件夹");
		}
		if( !f2.isDirectory()){
			System.out.println("当前的destDir不是一个文件夹,将为你创建一个");
			f2.mkdir();
		}
		if(f1.isDirectory()){
			File[] files = f1.listFiles();
			char[] buffer = new char[1024*10];
			copyFiles(destDir, files, buffer);
		
		}
		
	}

	/**
	 * 复制文件夹(只能复制字符文件) 递归调用
	 * @param destDir 
	 * @param files
	 * @param buffer
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
private static void copyFiles(String destDir, File[] files, char[] buffer) throws FileNotFoundException, IOException {
	BufferedReader br = null;
	BufferedWriter bw = null;
	for(File file:files){//当前文件是目录
		if(file.isFile()){//当前文件是文件
			
			br = new BufferedReader(new FileReader(file));
			File tempFile = new File(destDir,file.getName());
			System.out.println("创建的文件为:"+tempFile.getPath());
			tempFile.createNewFile();
			bw = new BufferedWriter(new FileWriter(tempFile));
			int length = -1;
			while((length=br.read(buffer))!=-1){
				bw.write(buffer, 0, length);//写到目录
				bw.flush();
			}
			br.close();//这个文件对应的流使用完毕,关闭
			bw.close();
		}
		else{//当前文件还是目录
			File tempFile2 = new File(destDir,file.getName());
			System.out.println("创建的文件夹为:"+tempFile2.getPath());
			tempFile2.mkdir();//创建文件夹
			File[] files2 = file.listFiles();
			copyFiles(tempFile2.getPath(), files2, buffer);
		}
	}
}


/**
 * 删除一个文件夹
 * @param filePath
 */
static void deleteFile2(String filePath){
	File file = new File(filePath);
	if(file.exists()){//文件存在
		boolean delete = file.delete();
		if(delete){
			System.out.println(file.getAbsolutePath()+"删除成功");
		}else{//文件下面有子文件删不掉
			File[] files =file.listFiles();//获取子目录
			for (File file2 : files) { 
				deleteFile2(file2.getAbsolutePath());//迭代
			}
			boolean d2 = file.delete();//子文件删除后再次删除文件夹
			if(d2){//空文件夹
				System.out.println(file.getAbsolutePath()+"删除成功");
			}else{
				System.out.println("删除出问题了-----------------------");
			}
		}
	}
}



//TODO : 使用字节流copy一个文件夹
private static void copyFiles2(String destDir, File[] files, char[] buffer) throws FileNotFoundException, IOException {
	BufferedReader br = null;
	BufferedWriter bw = null;
	FileInputStream is = null;
	FileOutputStream os = null;
//	InputStreamReader is = null;
//	OutputStreamWriter ow =null;
	for(File file:files){//当前文件是目录
		if(file.isFile()){//当前文件是文件
			
			br = new BufferedReader(new FileReader(file));
//			is = new FileInputStream( new File(pathname));
			File tempFile = new File(destDir,file.getName());
			System.out.println("创建的文件为:"+tempFile.getPath());
			tempFile.createNewFile();
			bw = new BufferedWriter(new FileWriter(tempFile));
			int length = -1;
			while((length=br.read(buffer))!=-1){
				bw.write(buffer, 0, length);//写到目录
				bw.flush();
			}
			br.close();//这个文件对应的流使用完毕,关闭
			bw.close();
		}
		else{//当前文件还是目录
			File tempFile2 = new File(destDir,file.getName());
			System.out.println("创建的文件夹为:"+tempFile2.getPath());
			tempFile2.mkdir();//创建文件夹
			File[] files2 = file.listFiles();
			copyFiles(tempFile2.getPath(), files2, buffer);
		}
	}
}

/**
 * 复制一个文件夹(所有类型文件)
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


}


