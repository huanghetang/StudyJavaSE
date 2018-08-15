package javaABC;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class Day13 {
	  private transient Object[] elementData;
	public static void main(String[] args) {
//		int[] arr = {12,2,34,5,99,36};
//		int[] arr = {2,3,4,16,99,136};
//		System.out.println("排序前:");
//		printArr(arr);
//		bubbleSort(arr);
//		System.out.println("排序后:");
//		printArr(arr);
//		System.out.println("排序前:");
//		printArr(arr);
//		selectSort(arr);
//		System.out.println("排序后:");
//		printArr(arr);
//		int value = binarySearch(arr,9);
//		System.out.println("value:"+value);
//		System.out.println(toString(arr));
//		seleceSort1(arr);
//		bubbleSort1(arr);
//		int value = binarySearch1(arr,44);
//		System.out.println("value="+value);
//		System.out.println(toString(arr));
//		Arrays.sort(arr);
//		System.out.println(Integer.toString(100, 2));//把一个整数转换成指定进制的数并用字符串返回 (进制2-36 0-9+a-z)
//		System.out.println(Integer.toString(100, 8));
//		System.out.println(Integer.toString(100, 10));
//		System.out.println(Integer.toString(100, 16));
//		System.out.println(Integer.parseInt("100", 2));//把一个字符串转换成指定进制的整数
//		System.out.println(Integer.parseInt("100", 8));
//		System.out.println(Integer.parseInt("100", 10));
//		System.out.println(Integer.parseInt("100", 16));
//		Integer i = null;
		
//		System.out.println(i.getClass().getName());
//		Object s = "123";
//		System.out.println(s);
//		System.out.println(1);
//		System.out.println("123s");
//		Integer i1 = 127;//-128 ---- 127
//		Integer i2 = 127;
//		System.out.println(i1==i2);
//		StringBuilder s;
//		ArrayList al = null;
//		Collection clo;
//		System.out.println(al);
//		System.err.println();
//		for(int a=0, i=0;i<10;System.out.println(i)){
//			i++;
//		}
		Integer[] a = {1,2};
		method(a);
		ArrayList<String> a1 = new ArrayList<String>();
		method(a1);
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		method(a2);
		
	}
	
	static void method(ArrayList<? extends Object> t){
		
	}
	static <T> T method(T[] t){
		return t[0];
	}
	private class my{
		
		void method(){
			 Object[] elementData = Day13.this.elementData;
		}
		
	}
	/**
	 * 数组排序之冒泡排序
	 */
	public static void bubbleSort(int[] arr){
		for(int x=0;x<arr.length-1;x++){//控制里层循环次数
			for(int y=0;y<arr.length-1-x;y++){//每次遍历数组并把最大的值依此放在后面
				if(arr[y]>arr[y+1]){
					int temp = arr[y];
					arr[y] = arr[y+1];
					arr[y+1] = temp;
				}
			}
		}
		
	}
	
	/**
	 * 数组排序之选择排序
	 * @param arr
	 */
	public static void selectSort(int[] arr){
		for(int x=0;x<arr.length-1;x++){//外层循环每遍历一次就把当前最小值依此放在最左边
			for(int y=x+1;y<arr.length;y++){
				if(arr[y]<arr[x]){//若当前索引处元素小于后面的元素就互换值
					int temp = arr[x];
					arr[x] = arr[y];
					arr[y] = temp;
				}
			}
			
		}
	}  
	
	
	/**
	 * 数组二分查找(前提是数组是有序的),返回key所在数组中的下标,没有则返回-1
	 * @param arr
	 * @param key
	 * @return
	 */
	public static  int  binarySearch(int[] arr,int key){
		int min = 0;
		int max = arr.length-1;     
		int mid = (min+max)/2;
		while(arr[mid]!=key){
			if(arr[mid]>key){
				max=mid-1;
			}else if(arr[mid]<key){
				min = mid+1;
			}
			if(min>max){
				return -1;
			}
			mid = (min+max)/2;
		}
		return mid;
			
	}
	/**
	 * 打印数组
	 * @param arr
	 */
	public static void printArr(int[] arr){
		System.out.print("[");
		for(int i=0;i<arr.length;i++){
			if(i==arr.length-1){
				System.out.println(arr[i]+"]");
			}else{
				System.out.print(arr[i]+" ,");
			}
			
		}
	}
	
	
	
	
	//数组排序之选择排序
	public static void seleceSort1(int[] arr){
		for(int x=0;x<arr.length-1;x++){
			for(int y=x+1;y<arr.length;y++){
				if(arr[y]<arr[x]){
					int temp = arr[x];
					arr[x] = arr[y];
					arr[y] = temp;
				}
			}
		}
	}
	
	
	
	//冒泡排序
	public static void bubbleSort1(int[] arr){
		for(int x=0;x<arr.length-1;x++){
			for(int y=0;y<arr.length-1-x;y++){
				if(arr[y]>arr[y+1]){
					int temp = arr[y];
					arr[y] = arr[y+1];
					arr[y+1] = temp;
				}
			}
		}
	}
	
	
	//数组查询之二分法查询 针对有序数组
	public static int binarySearch1(int[] arr,int key){
		int min = 0;
		int max = arr.length-1;
		int mid = (min+max)/2;
		while(key !=arr[mid]){
			if(key>arr[mid]){
				min = mid+1;
			}else if(key<arr[mid]){
				max = mid-1;
			}
			mid = (min+max)/2;
			if(min>max){
				return -1;
			}
		}
		return mid;
		
	}
	
	//打印数组
	public static String toString(int[] arr){
		if(arr==null)
			return "null";
		if(arr.length-1==-1)
			return "[]";
		StringBuilder sb = new StringBuilder("[");
		for(int i=0;;i++){
			if(i==arr.length-1){
				sb.append(arr[i]).append("]");
				return sb.toString();
			}else{
				sb.append(arr[i]).append(" ,");
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
