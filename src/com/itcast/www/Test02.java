package com.itcast.www;

public class Test02 {
//	1. ���巽�������ָ��Ԫ���������г��ֵĴ���. 
//	2. ���巽����ͳ�������г��ִ���Ϊ1��Ԫ��һ���ж��ٸ���(�Ƽ�-�������飬Ȼ����õ�һ�����������������ÿ��Ԫ���������г��ֵĴ��������ֻ������һ�Σ���ͳ��) 
//	3. ��main�����ж������飬��int arr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5};��Ȼ����÷�����ͳ��ֻ����һ�ε�Ԫ���ж��ٸ��� 
//	  ��ӡ�����������ֻ����һ�ε�Ԫ����2��
	public static void main(String[] args) {
		int arr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5};
		System.out.println(countNoRepeatedNumber(arr));;
		
	}
	//1. ���巽�������ָ��Ԫ���������г��ֵĴ���. 
	static int countRepeatedNumber(int[] a,int number){
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
