package cn.itcast.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Test02 {
	public static void main(String[] args) {
//		int[] a = {1,2};
//		try{
//			
//			int i = a[2];
//			System.out.println("i="+i);
//		}catch(ArrayIndexOutOfBoundsException e){
//			e.printStackTrace();
//			System.out.println("catch exception");
//			return;
//		}finally{
//			System.out.println("finally");
//		}
//		System.out.println("end");
//		int b = 1/0;//ArithmeticException
//	}
		
		System.out.println(method());;
		
	}
	
	
	/**
	 * return �ȼ�¼��ǰ״̬��ֵ3�����ǵ�ַ,Ȼ��ִ��finally arr[1]=4;Ȼ���ٴλص�return ���.����3.���Խ����3
	 * 
	 */
	static int method(){
		int[] arr={1,2,3};
		try{
			arr[1] = 3;
			return arr[1];//return �ȼ�¼��ǰ״̬��ֵ3�����ǵ�ַ,Ȼ��ִ��finally arr[1]=4;Ȼ���ٴλص�return ���.����3.���Խ����3
			}catch(Exception e ){
				
			}finally{
				arr[1]=4;
			}
			return arr[1];
		}
	
}
class Singleton{
//	private Singleton s = new Singleton();
	private Singleton s ;
	private Singleton(){
		
	}
//	public Singleton getSingleton(){
//		return s;
//	}
	public Singleton getSingleton() throws FileNotFoundException{
		new BufferedReader(new InputStreamReader(new FileInputStream("")));
		if(s==null){
			s = new Singleton();
			return s;
		}else{
			return s;
		}
	}
	
}


