package vip.huanghetang.util;

import java.util.Arrays;

public class MyArrays {
	
	public static void main(String[] args) {
		Object[] arr = {"1","2","3","4","5",};
		int[] arr1 = {};
//		System.out.println(equals(arr,arr1));
		//RepeatedNumberInArray(arr1,2);
		int[] a1 = {1,2,3};
		int[] a2 = {1,2};
		System.out.println(equals(a1, a2));;
		
		
	}

	/**
	 * 获取int[]最大值
	 * @param arr
	 * @return
	 */
	public static int getArrMaxValue(int[] arr){
		int maxValue=arr[0];
		for(int i=0;i<arr.length;i++){
			if(maxValue<arr[i]){
				maxValue=arr[i];
			}
		}
		return maxValue;
	}
	/**
	 * 求int[]中最小值
	 * @param arr
	 * @return
	 */
	public static int getArrMinValue(int[] arr){
		int minValue=arr[0];
		for(int i=0;i<arr.length;i++){
			if(minValue>arr[i]){
				minValue=arr[i];
			}
		}
		return minValue;
	}
	/**
	 * 把数组逆序
	 * @param args
	 */
	public static void reverseArr(int[] arr){
		for(int i=0;i<arr.length/2;i++){
			int obj = arr[i];
			arr[i]=arr[arr.length-1-i];
			arr[arr.length-1-i]= obj;
		}
	}
	/**
	 * 把数组逆序
	 * @param arr
	 */
	public static void reverseArr2(int[] arr){
		for(int i=0,j=arr.length-1;i<=j;i++,j=j-i){
			int temp = arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
	}
	
/*	1.定义一个方法equals(int[] arr1,int[] arr2),功能:比较两个数组是否相等(长度和内容均相等则认为两个数组是相同的)
	3.定义一个方法fill(int[] arr,int fromIndex,int toIndex,int value),功能:将数组arr中的元素从索引fromIndex开始到toIndex(不包含toIndex)对应的值改为value
	4.定义一个方法copyOf(int[] arr, int newLength),功能:将数组arr中的newLength个元素拷贝到新数组中,并将新数组返回,从索引为0开始
	5.定义一个方法copyOfRange(int[] arr,int from, int to),功能:将数组arr中从索引from(包含from)开始到索引to结束(不包含to)的元素复制到新数组中,并将新数组返回*/
	
	/**
	 * 比较两个int[] 数组的值是否完全相等
	 * @param arrq
	 * @param arr2
	 * @return
	 */
	public static boolean equals(int[]a,int[]a1){
		if(a==a1)
			return true;
		if(a==null  || a1==null)
			return false;
		if(a.length !=a1.length)
			return false;
		int len = a.length;
		for(int i=0;i<len;i++)
			if(a[i]!=a1[i])
				return false;
		return true;
	}
	
	public static boolean equals(Object[] a,Object[] a2){
		System.out.println("equals Object[]");
		if(a==a2)
			return true;
		if(a==null || a2==null)
			return false;
		int length = a.length;
		if(a2.length!=length)
			return false;
		for(int i=0;i<length;i++){
			Object o1 = a[i];
			Object o2 = a2[i];
			if(!(o1==null?o2==null:o1.equals(o2)))//o1为null不会执行equals(),如果o2也为null则 if条件不成立 ;
				return false;					//如果o1不为null,则判断o1.equals(o2)判断两个对象地址引用是否相等
		}										//	如果相等则if语句不成立,不相等则返回false;
		return true;
	}
	/**
	 * 将数组arr中的元素从索引fromIndex开始到toIndex(不包含toIndex)对应的值改为value
	 * @param arr
	 * @param fromIndex
	 * @param toIndex
	 * @param value
	 * @throws Exception 
	 */
	public static void fill(int[] arr,int fromIndex,int toIndex,int value){
		rangeCheck(arr.length,fromIndex,toIndex);
		for(int i=fromIndex;i<toIndex;i++)
			arr[i]=value;
	}
	private static void rangeCheck(int length,int fromIndex,int toIndex){
		if(fromIndex>toIndex)
			throw new IllegalArgumentException("fromIndex("+fromIndex+")>toIndex("+toIndex+")");
		if(fromIndex<0)
			throw new ArrayIndexOutOfBoundsException(fromIndex);
		if(toIndex>length)
			throw new ArrayIndexOutOfBoundsException(toIndex);
	}
	/**
	 * 求指定的数字number在数组a中出现时的索引值
	 * @param a 指定数组
	 * @param number 指定数字
	 */
	public static void RepeatedNumberInArray(int[] a, int number) {
		if(a==null)
			throw new NullPointerException();
		if(a.length==0)
			throw new IllegalArgumentException("数组的长度为0,非法参数");
		int[] index = new int[a.length];//定义一个数组 保存索引值
		int j=0;//数组index有效位的长度
		for(int i=0;i<a.length;i++){
			if(a[i]==number){
				index[j++] = i;
			}
		}
		System.out.println("数组为:"+Arrays.toString(a)+",数字为:"+number);
		if(j==0){//索引数组 有效位为0
			System.out.println("数组中没有这个数字");
		}else{
			System.out.print("数字"+number+"在数组中的索引值分别为:");
			for(int i=0;i<j;i++){
				System.out.print(index[i]+" ");
			}
		}
	}
	
	//1. 定义方法，求出指定元素在数组中出现的次数. 
	/**
	 * 求指定数字number在数组int[] a中出现的次数
	 * @param a
	 * @param number
	 * @return
	 */
	public static int countRepeatedNumber(int[] a,int number){
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

	
}
