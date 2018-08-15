package com.itcast.www;

import java.util.Arrays;
import java.util.Random;

public class Test01 {
//	 现在main方法中有一个数组int arr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5}; 
//	 要求如下： 
//	 1. 定义方法将数组中的0使用1-10之间的随机数替换掉(每一个0都要用一个新的随机数替换)，并统计替换了多少个。 
//	 2. 调用上面定义的方法，替换掉0并统计结果 
//	 3. 对操作后的数组使用任意格式进行遍历，查看结果
	public static void main(String[] args) {
		int arr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5};
		System.out.println("替换前数组为:"+Arrays.toString(arr));
		int count = replaceAndCount0(arr);
		System.out.println("共替换掉"+count+"个0");
		System.out.println("替换后数组为:"+Arrays.toString(arr));
	
	}
	 static int replaceAndCount0(int[] a){
		int count=0;//计数0的个数
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
