package com.itcast.www;

import java.util.Arrays;
import java.util.Random;

public class Test01 {
//	 ����main��������һ������int arr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5}; 
//	 Ҫ�����£� 
//	 1. ���巽���������е�0ʹ��1-10֮���������滻��(ÿһ��0��Ҫ��һ���µ�������滻)����ͳ���滻�˶��ٸ��� 
//	 2. �������涨��ķ������滻��0��ͳ�ƽ�� 
//	 3. �Բ����������ʹ�������ʽ���б������鿴���
	public static void main(String[] args) {
		int arr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5};
		System.out.println("�滻ǰ����Ϊ:"+Arrays.toString(arr));
		int count = replaceAndCount0(arr);
		System.out.println("���滻��"+count+"��0");
		System.out.println("�滻������Ϊ:"+Arrays.toString(arr));
	
	}
	 static int replaceAndCount0(int[] a){
		int count=0;//����0�ĸ���
		Random random = new Random();
		for(int i=0;i<a.length;i++){
			if(a[i]==0){
				a[i] = random.nextInt(10)+1;
				count++;
			}
		}
		return count;
	}

}
