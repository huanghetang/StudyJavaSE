package com.itcast.www;

public class Test02 {
//	1. 定义方法，求出指定元素在数组中出现的次数. 
//	2. 定义方法，统计数组中出现次数为1的元素一共有多少个。(推荐-遍历数组，然后调用第一个方法，求出数组中每个元素在数组中出现的次数，如果只出现了一次，就统计) 
//	3. 在main方法中定义数组，如int arr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5};。然后调用方法，统计只出现一次的元素有多少个。 
//	  打印结果：数组中只出现一次的元素有2个
	public static void main(String[] args) {
		int arr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5};
		System.out.println(countNoRepeatedNumber(arr));;
		
	}
	//1. 定义方法，求出指定元素在数组中出现的次数. 
	static int countRepeatedNumber(int[] a,int number){
		if(a==null)
			throw new NullPointerException();
		if(a.length==0)
			throw new IllegalArgumentException("数组长度为0,非法数组");
		int count=0;
		for(int aa:a){
			if(aa==number){
				count++;
			}
		}
		return count;
	}

	static int countNoRepeatedNumber(int[] a){
		int count=0;
		for(int aa:a){
			int n = countRepeatedNumber(a,aa);
			if(n==1){
				count++;
			}
		}
		return count;
	}
}
