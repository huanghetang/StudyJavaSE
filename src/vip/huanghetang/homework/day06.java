package vip.huanghetang.homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class day06 {

	public static void main(String[] args) {
			
//		question02();
		questionTZ6();
		
	}
	
//	随机产生5个范围是[1,100]的整数,把这些数字中所有个位或十位为3的数字打印出来
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
		System.out.println("数组为:"+Arrays.toString(a));
		if(index>0)
			System.out.println("其中个位数或者十位数有3的为:"+print3(b,index));
		else
			System.out.println("其中个位数或者十位数有3的为NULL,无");
		
	}
	
	
	private static String print3(int[] b,int length){
		StringBuilder str = new StringBuilder();
		for(int i=0;i<length;i++){
			str.append(b[i]).append("\t");
		}
		return str.toString();
	}
//	计算出5位数的回文数和7位数的回文数相差了多少个?
//	回文数是一种数字如：98789倒读也为98789正读倒读都一样这种数字就叫回文数
	static void question02(){
		int five = getFiveHW();
		int seven = getSevenHW();
		if(five>seven)
			System.out.println("5位数的回文数有:"+five+"个,7位数的回文数有"+seven+"个,相差"+(five-seven)+"个");
		else
			System.out.println("5位数的回文数有:"+five+"个,7位数的回文数有"+seven+"个,相差"+(seven-five)+"个");
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
		int a[] = new int[10];//int型整数最大21亿 不超过10位数
		while(number>0){
			a[index] = number%10;
			number = number/10;
			index++;
		}
//		for(int i=index-1;i>=0;i--){//打印这个数字  控制台出问题
//			System.out.println(a[i]+"");
//		}
		for(int i=0;i<index/2;i++){
			if(a[i]!=a[index-1-i]){
				return false;
			}
		}
		return true;
	}
	
//	定义一个方法,求出给定的数字在给定int型数组中出现的次数,如果一次没有出现则返回0。
//	如:给定数字3 求出3在数组 int[] arr = {3,4,3,5,7,9};中出现的次数 
	//1. 定义方法，求出指定元素在数组中出现的次数. 
	static void question03(){
		int[] arr = {3,4,3,5,7,9};
		System.out.println(countRepeatedNumber(arr, 3));;
	}

	
//	定义一个方法，查找指定数字在数组中出现的位置(若出现多次，多次打印)
//	如: 数组[1232]要查找的数是2 则方法内部会打印索引值 1 ,3 
//	数组[1232] 要查找的数是5 则方法每部会打印 “数组中没有这个数字”
	static void question04(){
		int[] a = new int[]{1,2,3,2};
	 RepeatedNumberInArray(a,2);
 }

	
//	定义一个方法,实现同时求出两个整数的加、减、乘、除的结果,并同时把这个四个结果返回(把四个数放入到一个数组中并返回)
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
		System.out.println("输入的两个数分别位:"+a+","+b+",加减乘除结果分别为:");
//		return Arrays.toString(arr);
		System.out.println(Arrays.toString(arr));
	
	}
//	1.键盘录入10个整数存入数组中
//	2.定义一个方法将奇数放在数组的左侧,偶数放在数组的右侧
//	3.定义一个方法打印原数组和处理后的数组
//	4.定义一个方法传入一个int类型数组，输出这个数组中只出现一次的数字及个数
	
	static void qeustionTZ1(){
		Scanner scanner = new Scanner(System.in);
		int[] a = new int[10];
		System.out.println("键盘分别录入10个数字:");
		for(int i=0;i<10;i++){
			a[i] = scanner.nextInt();
		}
		int[] b = new int[10];//偶数集合
		int[] c = new int[10];//奇数集合
		int bIndex=0,cIndex=0;
		for(int i=0;i<a.length;i++){
			if(a[i]%2==0){//偶数
				b[bIndex] = a[i];
				bIndex++;
			}else{
				c[cIndex] = a[i];
				cIndex++;
			}
		}
		System.out.println("原数组为:"+Arrays.toString(a));
		int x = 0;
		for(int i=0;i<a.length;i++){
			if(i<cIndex){
				a[i]=c[i];
			}else{
				a[i] = b[x++];
			}
		}
		System.out.println("现数组为:"+Arrays.toString(a));
		
	}
	
	static void questionTZ2(){
		int[] a= {1,2,3,2,2,2,12312,4,5,6,6,5};
		printNoReqeatedNumberInArray(a);
	}
	
	private static void printNoReqeatedNumberInArray(int[] a) {
		int count=0;
		System.out.println("数组中出现一次的数分别为:");
		for(int aa:a){
			if(countRepeatedNumber(a,aa)==1){
				System.out.print(aa+" ");
				count++;
			}
		}
		System.out.println("这样的数字共有"+count+"个");
			
		
	}
	
	/**
	 * 计算指定数字number在指定数组a中出现的次数
	 * @param a
	 * @param number
	 * @return
	 */
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
	/**
	 * 指定数字number在数组中的重复的索引值
	 * @param a
	 * @param number
	 */
	private static void RepeatedNumberInArray(int[] a, int number) {
	// TODO Auto-generated method stub
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


//	static void questionTZ(){
//		int[] a = {1,2,2,2,3,3,4,4,4,4};
////		System.out.println("数组为:"+Arrays.toString(a));
////		for(int i=0;i<a.length;i++){
////			System.out.println("数字"+a[i]+"在数组中出现的次数为"+countRepeatedNumber(a,a[i])+"次");
////		}
//		
//	}
	
//	定义一个方法传入一个int类型数组，输出这个数组中每一个数字及其出现的个数
//	例如 传入数组[1,2,2,2,3,3,4,4,4,4]  打印结果：
//								数字1出现了1次
//							数字2出现了3次…
	static void questionTZ(){
		int[] a = {1,2,2,2,3,3,4,4,4,4};
		System.out.println("数组为:"+Arrays.toString(a));
		int[] b  = new int[a.length];//记录数组a中不重复的元素
		int index=0;//不重复元素的实际长度
		int[] c  = new int[a.length];//记录对应不重复元素出现的次数
		for(int i=0;i<a.length;i++){
			int count = countRepeatedNumber(b,a[i]);//遍历每个元素在b数组中出现的次数
			if(count==0){//无重复元素
				b[index++] = a[i];
			}
		}
		for(int i=0;i<index;i++){
			c[i] = countRepeatedNumber(a, b[i]);//遍历b数组中每个元素在a数组中出现的次数
			System.out.println("数字"+b[i]+"出现了"+c[i]+"次");
		}
		
	}
//
//	分析以下需求，并用代码实现
//	1.键盘录入6个int类型的数据存数数组arr中
//	2.将arr数组中的内容反转
//	3.将翻转后的数组角标为奇数的互相交换 1和3换, 3和5换,以此类推
//	4.最后将数组最后一个角标为奇数的元素 和数组   中第一个角标为奇数的元素交换
	static void questionTZ3(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入6个数");
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
		//对数组进行交换
		for(int i=1;i<bIndex;i++){
			int temp = b[i-1];
			b[i-1] = b[i];
			b[i] = temp;
		}
		System.out.println("b[]:"+Arrays.toString(b));
		int count=0;
		for(int i =0;i<a.length;i++){//对a数组进行交换
			if(i%2!=0 && count<bIndex){
				a[i]=b[count++];
			}
		}
		System.out.println(Arrays.toString(a));
		int len = a.length;
		int temp1 = 0;
		if(len>2){
			temp1 = a[1];
			if((len-1)%2!=0){//最后一位下标为奇数
				a[1] = a[len-1];
				a[len-1] = temp1;
			}else{
				a[1] = a[len-2];
				a[len-2] = temp1;
			}
		}else{
			System.out.println("数组长度小于2没有奇数下标");
		}
		System.out.println(Arrays.toString(a));
		
		
	}
	
	
//	分析以下需求，并用代码实现
//	1.求1-500之内能同时被2，5，7整除的所有数及个数并5个一行打印
//	2.求100以内能被3整除的数加上能被5整除的数的和

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
		System.out.println("1-500之内能同时被2，5，7整除的所有数及个数为"+count);
	}
	
//	分析以下需求，并用代码实现
//	有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13... 定义一个方法求出这个数列的前20 项之和。
	static void questionTZ5(){
		float sum =0.0f;
		for(int i=1;i<=20;i++){
			float number = getFengZi(i)/getFengMu(i);
			sum +=number;
			System.out.println(number);
		}
		System.out.println("sum="+sum);
		
	}
	
//	分析以下需求，并用代码实现
//	1.创建两个长度为10的数组，数组内元素为随机生成的、不重复的 1-100之间的整数。
//	2.定义一个方法，传入两个数组，方法中将两个数组不同的元素拼接成一个字符串，并且将该字符串以及字符串的长度输出到控制台上；
//		如果没有则输出"对不起两个数组的所有元素均相同"
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
		
//	分析以下需求，并用代码实现		
//	1.提示用户输入10个整数，存入到int数组中；根据以下要求实现相关功能
//	2.提示用户输入一个数字作为数组索引，查找数组中该索引对应的元素，
//		（需要判断输入的数字是否在0-9之间包含临界值，如果该数字不符合要求则随机生成一个符合要求的索引）
//	3.将a中得到的索引对应的元素的左右两边元素进行互换，若对应的元素是第一个或最后一个则不做任何操作
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
