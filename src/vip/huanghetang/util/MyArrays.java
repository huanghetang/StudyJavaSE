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
	 * ��ȡint[]���ֵ
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
	 * ��int[]����Сֵ
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
	 * ����������
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
	 * ����������
	 * @param arr
	 */
	public static void reverseArr2(int[] arr){
		for(int i=0,j=arr.length-1;i<=j;i++,j=j-i){
			int temp = arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
	}
	
/*	1.����һ������equals(int[] arr1,int[] arr2),����:�Ƚ����������Ƿ����(���Ⱥ����ݾ��������Ϊ������������ͬ��)
	3.����һ������fill(int[] arr,int fromIndex,int toIndex,int value),����:������arr�е�Ԫ�ش�����fromIndex��ʼ��toIndex(������toIndex)��Ӧ��ֵ��Ϊvalue
	4.����һ������copyOf(int[] arr, int newLength),����:������arr�е�newLength��Ԫ�ؿ�������������,���������鷵��,������Ϊ0��ʼ
	5.����һ������copyOfRange(int[] arr,int from, int to),����:������arr�д�����from(����from)��ʼ������to����(������to)��Ԫ�ظ��Ƶ���������,���������鷵��*/
	
	/**
	 * �Ƚ�����int[] �����ֵ�Ƿ���ȫ���
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
			if(!(o1==null?o2==null:o1.equals(o2)))//o1Ϊnull����ִ��equals(),���o2ҲΪnull�� if���������� ;
				return false;					//���o1��Ϊnull,���ж�o1.equals(o2)�ж����������ַ�����Ƿ����
		}										//	��������if��䲻����,������򷵻�false;
		return true;
	}
	/**
	 * ������arr�е�Ԫ�ش�����fromIndex��ʼ��toIndex(������toIndex)��Ӧ��ֵ��Ϊvalue
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
	 * ��ָ��������number������a�г���ʱ������ֵ
	 * @param a ָ������
	 * @param number ָ������
	 */
	public static void RepeatedNumberInArray(int[] a, int number) {
		if(a==null)
			throw new NullPointerException();
		if(a.length==0)
			throw new IllegalArgumentException("����ĳ���Ϊ0,�Ƿ�����");
		int[] index = new int[a.length];//����һ������ ��������ֵ
		int j=0;//����index��Чλ�ĳ���
		for(int i=0;i<a.length;i++){
			if(a[i]==number){
				index[j++] = i;
			}
		}
		System.out.println("����Ϊ:"+Arrays.toString(a)+",����Ϊ:"+number);
		if(j==0){//�������� ��ЧλΪ0
			System.out.println("������û���������");
		}else{
			System.out.print("����"+number+"�������е�����ֵ�ֱ�Ϊ:");
			for(int i=0;i<j;i++){
				System.out.print(index[i]+" ");
			}
		}
	}
	
	//1. ���巽�������ָ��Ԫ���������г��ֵĴ���. 
	/**
	 * ��ָ������number������int[] a�г��ֵĴ���
	 * @param a
	 * @param number
	 * @return
	 */
	public static int countRepeatedNumber(int[] a,int number){
		if(a==null)
			throw new NullPointerException();
		if(a.length==0)
			throw new IllegalArgumentException("���鳤��Ϊ0,�Ƿ�����");
		int count=0;
		for(int aa:a){
			if(aa==number){
				count++;
			}
		}
		return count;
	}

	
}
