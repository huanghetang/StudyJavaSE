package vip.huanghetang.homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class day06 {

	public static void main(String[] args) {
			
//		question02();
		questionTZ6();
		
	}
	
//	�������5����Χ��[1,100]������,����Щ���������и�λ��ʮλΪ3�����ִ�ӡ����
	static void printgs(){
		Random random = new Random();
		int[] a = new int[5];
		int[] b = new int[5];
		int index=0;
		for(int i=0;i<5;i++){
			a[i]=random.nextInt(100)+1;
			int g = a[i]%10;
			if(g==3){
				b[index++]=a[i];
				continue;
			}
			if(a[i]>10){
				int s = a[i]/10%10;
				if(s==3){
					b[index++]=a[i];
				}
			}
		}
		System.out.println("����Ϊ:"+Arrays.toString(a));
		if(index>0)
			System.out.println("���и�λ������ʮλ����3��Ϊ:"+print3(b,index));
		else
			System.out.println("���и�λ������ʮλ����3��ΪNULL,��");
		
	}
	
	
	private static String print3(int[] b,int length){
		StringBuilder str = new StringBuilder();
		for(int i=0;i<length;i++){
			str.append(b[i]).append("\t");
		}
		return str.toString();
	}
//	�����5λ���Ļ�������7λ���Ļ���������˶��ٸ�?
//	��������һ�������磺98789����ҲΪ98789����������һ���������־ͽл�����
	static void question02(){
		int five = getFiveHW();
		int seven = getSevenHW();
		if(five>seven)
			System.out.println("5λ���Ļ�������:"+five+"��,7λ���Ļ�������"+seven+"��,���"+(five-seven)+"��");
		else
			System.out.println("5λ���Ļ�������:"+five+"��,7λ���Ļ�������"+seven+"��,���"+(seven-five)+"��");
	}
	
	static int getFiveHW(){
		int count=0;
		for(int i=10000;i<100000;i++){
			if(isHWS(i))
				count++;
		}
		return count;
	}
	static int getSevenHW(){
		int count=0;
		for(int i=1000000;i<10000000;i++){
			if(isHWS(i))
				count++;
		}
		return count;
	}
	static boolean isHWS(int number){
		int index=0;
//		int [] a = new int[index];
		int a[] = new int[10];//int���������21�� ������10λ��
		while(number>0){
			a[index] = number%10;
			number = number/10;
			index++;
		}
//		for(int i=index-1;i>=0;i--){//��ӡ�������  ����̨������
//			System.out.println(a[i]+"");
//		}
		for(int i=0;i<index/2;i++){
			if(a[i]!=a[index-1-i]){
				return false;
			}
		}
		return true;
	}
	
//	����һ������,��������������ڸ���int�������г��ֵĴ���,���һ��û�г����򷵻�0��
//	��:��������3 ���3������ int[] arr = {3,4,3,5,7,9};�г��ֵĴ��� 
	//1. ���巽�������ָ��Ԫ���������г��ֵĴ���. 
	static void question03(){
		int[] arr = {3,4,3,5,7,9};
		System.out.println(countRepeatedNumber(arr, 3));;
	}

	
//	����һ������������ָ�������������г��ֵ�λ��(�����ֶ�Σ���δ�ӡ)
//	��: ����[1232]Ҫ���ҵ�����2 �򷽷��ڲ����ӡ����ֵ 1 ,3 
//	����[1232] Ҫ���ҵ�����5 �򷽷�ÿ�����ӡ ��������û��������֡�
	static void question04(){
		int[] a = new int[]{1,2,3,2};
	 RepeatedNumberInArray(a,2);
 }

	
//	����һ������,ʵ��ͬʱ������������ļӡ������ˡ����Ľ��,��ͬʱ������ĸ��������(���ĸ������뵽һ�������в�����)
	static void caculate(int a,int b){
		int sum = a+b;
		int minus = a-b;
		int multiple = a*b;
		int devide = a/b;
		int[] arr = new int[4];
		arr[0]=sum;
		arr[1]=minus;
		arr[2]=multiple;
		arr[3]=devide;
		System.out.println("������������ֱ�λ:"+a+","+b+",�Ӽ��˳�����ֱ�Ϊ:");
//		return Arrays.toString(arr);
		System.out.println(Arrays.toString(arr));
	
	}
//	1.����¼��10����������������
//	2.����һ������������������������,ż������������Ҳ�
//	3.����һ��������ӡԭ����ʹ���������
//	4.����һ����������һ��int�������飬������������ֻ����һ�ε����ּ�����
	
	static void qeustionTZ1(){
		Scanner scanner = new Scanner(System.in);
		int[] a = new int[10];
		System.out.println("���̷ֱ�¼��10������:");
		for(int i=0;i<10;i++){
			a[i] = scanner.nextInt();
		}
		int[] b = new int[10];//ż������
		int[] c = new int[10];//��������
		int bIndex=0,cIndex=0;
		for(int i=0;i<a.length;i++){
			if(a[i]%2==0){//ż��
				b[bIndex] = a[i];
				bIndex++;
			}else{
				c[cIndex] = a[i];
				cIndex++;
			}
		}
		System.out.println("ԭ����Ϊ:"+Arrays.toString(a));
		int x = 0;
		for(int i=0;i<a.length;i++){
			if(i<cIndex){
				a[i]=c[i];
			}else{
				a[i] = b[x++];
			}
		}
		System.out.println("������Ϊ:"+Arrays.toString(a));
		
	}
	
	static void questionTZ2(){
		int[] a= {1,2,3,2,2,2,12312,4,5,6,6,5};
		printNoReqeatedNumberInArray(a);
	}
	
	private static void printNoReqeatedNumberInArray(int[] a) {
		int count=0;
		System.out.println("�����г���һ�ε����ֱ�Ϊ:");
		for(int aa:a){
			if(countRepeatedNumber(a,aa)==1){
				System.out.print(aa+" ");
				count++;
			}
		}
		System.out.println("���������ֹ���"+count+"��");
			
		
	}
	
	/**
	 * ����ָ������number��ָ������a�г��ֵĴ���
	 * @param a
	 * @param number
	 * @return
	 */
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
	/**
	 * ָ������number�������е��ظ�������ֵ
	 * @param a
	 * @param number
	 */
	private static void RepeatedNumberInArray(int[] a, int number) {
	// TODO Auto-generated method stub
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


//	static void questionTZ(){
//		int[] a = {1,2,2,2,3,3,4,4,4,4};
////		System.out.println("����Ϊ:"+Arrays.toString(a));
////		for(int i=0;i<a.length;i++){
////			System.out.println("����"+a[i]+"�������г��ֵĴ���Ϊ"+countRepeatedNumber(a,a[i])+"��");
////		}
//		
//	}
	
//	����һ����������һ��int�������飬������������ÿһ�����ּ�����ֵĸ���
//	���� ��������[1,2,2,2,3,3,4,4,4,4]  ��ӡ�����
//								����1������1��
//							����2������3�Ρ�
	static void questionTZ(){
		int[] a = {1,2,2,2,3,3,4,4,4,4};
		System.out.println("����Ϊ:"+Arrays.toString(a));
		int[] b  = new int[a.length];//��¼����a�в��ظ���Ԫ��
		int index=0;//���ظ�Ԫ�ص�ʵ�ʳ���
		int[] c  = new int[a.length];//��¼��Ӧ���ظ�Ԫ�س��ֵĴ���
		for(int i=0;i<a.length;i++){
			int count = countRepeatedNumber(b,a[i]);//����ÿ��Ԫ����b�����г��ֵĴ���
			if(count==0){//���ظ�Ԫ��
				b[index++] = a[i];
			}
		}
		for(int i=0;i<index;i++){
			c[i] = countRepeatedNumber(a, b[i]);//����b������ÿ��Ԫ����a�����г��ֵĴ���
			System.out.println("����"+b[i]+"������"+c[i]+"��");
		}
		
	}
//
//	�����������󣬲��ô���ʵ��
//	1.����¼��6��int���͵����ݴ�������arr��
//	2.��arr�����е����ݷ�ת
//	3.����ת�������Ǳ�Ϊ�����Ļ��ཻ�� 1��3��, 3��5��,�Դ�����
//	4.����������һ���Ǳ�Ϊ������Ԫ�� ������   �е�һ���Ǳ�Ϊ������Ԫ�ؽ���
	static void questionTZ3(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("������6����");
		int[] a = new int[6];
		for(int i=0;i<6;i++){
			a[i] = scanner.nextInt();
		}
		System.out.println(Arrays.toString(a));
		for(int i=0;i<a.length/2;i++){
			int temp = a[i];
			a[i] = a[a.length-1-i];
			a[a.length-1-i] = temp;
		}
		System.out.println(Arrays.toString(a));
		int[] b = new int[a.length];
		int bIndex=0;
		for(int i=0;i<a.length;i++){
			if(i%2!=0){
				b[bIndex++] = a[i];
			}
		}
		System.out.println("b[]:"+Arrays.toString(b));
		//��������н���
		for(int i=1;i<bIndex;i++){
			int temp = b[i-1];
			b[i-1] = b[i];
			b[i] = temp;
		}
		System.out.println("b[]:"+Arrays.toString(b));
		int count=0;
		for(int i =0;i<a.length;i++){//��a������н���
			if(i%2!=0 && count<bIndex){
				a[i]=b[count++];
			}
		}
		System.out.println(Arrays.toString(a));
		int len = a.length;
		int temp1 = 0;
		if(len>2){
			temp1 = a[1];
			if((len-1)%2!=0){//���һλ�±�Ϊ����
				a[1] = a[len-1];
				a[len-1] = temp1;
			}else{
				a[1] = a[len-2];
				a[len-2] = temp1;
			}
		}else{
			System.out.println("���鳤��С��2û�������±�");
		}
		System.out.println(Arrays.toString(a));
		
		
	}
	
	
//	�����������󣬲��ô���ʵ��
//	1.��1-500֮����ͬʱ��2��5��7��������������������5��һ�д�ӡ
//	2.��100�����ܱ�3�������������ܱ�5���������ĺ�

	static void questionTZ4(){
		int count=0,
			index=0;
		for(int i =1;i<=500;i++){
			if(i%2==0 && i%5==0 &&i%7==0){
				System.out.print(i+" ");
				index++;
				count++;
				if(index==5){
					System.out.println();
					index=0;
				}
					
			}
		}
		System.out.println();
		System.out.println("1-500֮����ͬʱ��2��5��7������������������Ϊ"+count);
	}
	
//	�����������󣬲��ô���ʵ��
//	��һ�������У�2/1��3/2��5/3��8/5��13/8��21/13... ����һ���������������е�ǰ20 ��֮�͡�
	static void questionTZ5(){
		float sum =0.0f;
		for(int i=1;i<=20;i++){
			float number = getFengZi(i)/getFengMu(i);
			sum +=number;
			System.out.println(number);
		}
		System.out.println("sum="+sum);
		
	}
	
//	�����������󣬲��ô���ʵ��
//	1.������������Ϊ10�����飬������Ԫ��Ϊ������ɵġ����ظ��� 1-100֮���������
//	2.����һ�������������������飬�����н��������鲻ͬ��Ԫ��ƴ�ӳ�һ���ַ��������ҽ����ַ����Լ��ַ����ĳ������������̨�ϣ�
//		���û�������"�Բ����������������Ԫ�ؾ���ͬ"
	static void questionTZ6(){
		int[] a = new int[10];
		Random random = new Random();
		int index=0;
		while(index<10){
			int temp =  random.nextInt(12)+1;
			int count = countRepeatedNumber(a, temp);
			System.out.println(count);
			if(count==0){
				a[index++]=temp;
			}
		}
		System.out.println(Arrays.toString(a));
		compile(new String[]{"1","2","3"},new String[]{"1","22","33","44"});
		
	}
	static void compile(String[] str1,String[] str2){
		int len1 = str1.length;
		int len2 = str2.length;
		StringBuilder sb = new StringBuilder();
		int minLen = len1<len2?len1:len2;
		for(int i=0;i<minLen;i++){
			if(!str1[i].equals(str2[i])){
				sb.append(str1[i]).append(str2[i]);
			}
		}
		if(minLen==len1){
			for(int i=minLen;i<len2;i++){
				sb.append(str2[i]);
			}
		}else{
			for(int i=minLen;i<len1;i++){
				sb.append(str1[i]);
			}
		}
		System.out.println(sb.toString());
		
	}
		
//	�����������󣬲��ô���ʵ��		
//	1.��ʾ�û�����10�����������뵽int�����У���������Ҫ��ʵ����ع���
//	2.��ʾ�û�����һ��������Ϊ�������������������и�������Ӧ��Ԫ�أ�
//		����Ҫ�ж�����������Ƿ���0-9֮������ٽ�ֵ����������ֲ�����Ҫ�����������һ������Ҫ���������
//	3.��a�еõ���������Ӧ��Ԫ�ص���������Ԫ�ؽ��л���������Ӧ��Ԫ���ǵ�һ�������һ�������κβ���
	static void questionTZ7(){
		
		
	}

private static float getFengMu(int i) {
	if(i==1){
		return 1;
	}else if(i==2){
		return 2;
	}else{
		return getFengMu(i-1)+getFengMu(i-2);
	}
}

private static float getFengZi(int i) {
	if(i==1){
		return 2;
	}else if(i==2){
		return 3;
	}else {
		return getFengZi(i-1)+getFengZi(i-2);
	}
}
	



}
