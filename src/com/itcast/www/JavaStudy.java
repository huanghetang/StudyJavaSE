package com.itcast.www;

import java.util.Arrays;

public class JavaStudy {
	public static void main(String[] args) {
//		int a = 1;
//		System.out.println(a);
//		sum1(a);
//		System.out.println(a);
//		int[] arr = new int[]{1,2,3};
//		System.out.println(Arrays.toString(arr));
//		sum1(arr);
//		System.out.println(Arrays.toString(arr));
//		System.out.println("-------------");
//		printDec(123456);

		int[] arr = {1,2,3}; 
			//int[] arr2 = {1,2,3,4};
		for(int i = 0; i < arr.length; i++) { 
		if(i == 2) { 
		arr = new int[]{6,6,6}; 
		} 
		if(i == 2) { 
		arr[3] =  10; 
		} 
		}
	}
	/**
	 * �������ݴ�����ֵ,��������ֱ�Ӵ�ֵ,�������ʹ���ַ
	 * @param a
	 */
	static void sum1(int ...a){
		if(a instanceof int[]){
			for(int i=0;i<a.length;i++){
				a[i] +=1;
			}
		}else{
			for(int aa:a){
				aa+=1;
				System.out.println("sum1(),aa="+aa);
			}
		}
	}
	//����һ��С��8λ����int,����
	static void printDec(int number){
		int[] arr = new int[8];
		System.out.println(number);
		int index=0;
		while(number>0){
			arr[index] = number%10;
			number /=10;
			index++;
		}
		for(int i=0;i<index;i++){
			System.out.print(arr[i]);
		}
	}
	static double printDec(){//��������ͬ,�����б�ͬ
		return 1.0;
	}
}
