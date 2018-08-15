package com.itcast.www;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import thinkinjava.PaperMoney;

public class HomeWork02 {
	public static void main(String[] args) {
		// changePoker();
		// System.out.println(" ".equals("\n"));
		// new HomeWork02().printPerson();
		// System.out.println(getab(3,4));
		// int i =5;
		// double d = 3.14;
		// short s =(short) (i+d);
		// System.out.println(s);
		// changePoker();
		// question06();
		// System.out.print("a" + "\t"+"c");
		// question10();
		// int[] intA = {88,96,97,74,90,5,77,90,99,};
		// int[] intB = new int[9];
		// System.out.println(Arrays.toString(intA));
		// System.out.println(Arrays.toString(intB));
		// System.arraycopy(intA, 0, intB, 0, intA.length);
		// System.out.println(Arrays.toString(intB));
//		Random random = new Random();
//		// (random.nextInt(10)+1)*10;
//		int[][] a = new int[2][72];// 二维数组
//		for (int i = 0; i < 2; i++) {
//			for (int j = 0; j < 72; j++) {
//				a[i][j] = i * 10 + j;
//			}
//		}
//		for (int[] aa : a) {
//			System.out.println(Arrays.toString(aa));
//
//		}
//		ClassLoader classLoader = HomeWork02.class.getClassLoader();
//		System.out.println(classLoader.getClass().getName());
//		System.out.println(5.567657%5);
//		if(PaperMoney.sy instanceof PaperMoney){
//			Scanner scanner = new Scanner(System.in);
//			int i = scanner.nextInt();
//			System.out.println(i);
//		}
//		int [] a = new int[]{1,2,3,};
//		String[] ar= {"1","2","3"};
//		int[][] a = {{1,2,3},{2,3},{2}};//二维数组的动态初始化和静态初始化的差距
//		int[][] b = new int[3][4];
//		for(int[] aa:a){
//			for(int aaa:aa){
//				System.out.print(aaa+" ");
//				
//			}
//		}
//		System.out.println();
//		for(int[] bb:b){
//			for(int bbb:bb){
//				System.out.print(bbb+" ");
//				
//			}
//		}

		System.out.println(teacherFbnq(7));;

	}
	static void sum1(){
		
	}
	// 检测键盘录入是奇数还是偶数
	private static void checkJO() {
		System.out.println("请输入一个整数,输入空格\" \"退出：");
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String str = scanner.nextLine();
			if (str.equals(" ")) {
				System.out.println("程序退出");
				break;
			} else {
				try {
					int i = Integer.parseInt(str);
					// System.out.println(i);
					String str1 = i % 2 == 0 ? "偶数" : "奇数";
					System.out.println(str1);
				} catch (Exception e) {
					System.err.println("当前输入为:" + str + ",请输入一个整数或空格");
				}
			}
		}
	}

	private void printPerson() {
		System.out.println("请输入您的姓名:");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		System.out.println("请输入您age:");
		String age = scanner.next();
		System.out.println("请输入您的height:");
		String height = scanner.next();
		System.out.println(name + "," + age + "," + height);

	}

	public static int getab(int a, int b) {
		return a > b ? a + b : a * b;
	}

	public static void changePoker() {
		InputStream is = HomeWork02.class.getResourceAsStream("poker.properties");
		Scanner scanner = new Scanner(is);
		while (scanner.hasNext()) {
			String str = scanner.nextLine();
			System.out.println(str);
		}
		// int a = scanner.nextInt();
	}

	// 1. 循环与判断
	// 求1~100以内(包含1和100)能同时被3，5整除的数的和，并将求出的和打印到控制台上
	static void question01() {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				sum += i;
			}

		}
		System.out.println("answer:" + sum);

	}

	// 2. 获取一个2-500之间(包含2和500)的随机数n，求0-n之间（包含0和n）的偶数和，并打印到控制台上;
	static void question02() {
		Random random = new Random();
		int n = random.nextInt(501);
		while (n == 1) {
			n = random.nextInt(501);
		}
		int sum = 0;
		for (int i = 0; i <= n; i++) {
			if (i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println("n=" + n + ",sum=" + sum);
	}

	// 3. 三元与if判断
	// main方法中定义3个变量：int a = 5, b = 3, c = 8;
	// 并依次完成以下要求：
	// 1. 利用if语句求出a、b、c中最大的数并打印到控制台上；
	// 2. 利用三元运算符求出a、b、c中最小的数并打印到控制台上
	static void question03() {
		int a = 5, b = 3, c = 8;
		int temp;
		if (a > b) {
			temp = a;
			if (temp > c)
				System.out.println("max value=" + temp);
			else
				System.out.println("max value=" + c);
		} else {
			temp = b;
			if (temp > c)
				System.out.println("max value=" + temp);
			else
				System.out.println("max value=" + c);
		}
		// int tempValue = a>b?a:b;
		// int maxValue = tempValue>c?tempValue:c;
		// System.out.println("maxValue="+maxValue);
	}

	// 4. 循环,判断,与输出使用的技巧
	// 获取1~20之间（包含1和20）个位数为3的倍数的“数字”，并在控制台打印输出所有“数字”和“数字的个数”(本试题中0视为3的倍数)。
	//
	// PS：不能用主观判断去实现题目，如【if(num == 0 || num == 3 || num == 6 ……)】这样的代码是不符合题目要求的。
	// 演示格式如下：
	static void question04() {
		String allFigure = "";
		int number = 0;
		for (int i = 1; i <= 20; i++) {
			if (i <= 10) {// 1位数
				if (i % 3 == 0 || i % 10 == 0) {
					number++;
					allFigure = allFigure + i + " ";
				}
			} else {// 2位数
				int temp = i - i / 10 * 10;// 个位数
				if (temp % 3 == 0 || temp == 0) {
					number++;
					allFigure = allFigure + i + " ";
				}
			}
		}
		System.out.println("数字为:" + allFigure);
		System.out.println("数字的个数:" + number);
	}

	// 6. 循环, 判断和技巧输出
	// 输出4位数中能被6整除不能被12整除的数，两个数字一行，三个数字一行交替输出。
	// 演示格式如下：
	// 1,11
	// 323,232,2323
	// 232,3
	// 123,23,232
	static void question06() {
		List<Integer> arrayList = new ArrayList<Integer>();
		for (int i = 1000; i <= 9999; i++) {
			if (i % 6 == 0 && i % 12 != 0) {
				arrayList.add(i);
			}
		}
		// Integer[] arr = new Integer[arrayList.size()-1];
		// arr =(Integer[]) arrayList.toArray();
		System.out.println(Arrays.toString(arrayList.toArray()));
		int[] a = new int[arrayList.size() - 1];
		for (int j = 0; j < arrayList.size() - 1; j++) {
			a[j] = arrayList.get(j);
		}
		//testmind(a);
	}

	// 7. 循环与判断
	// 需求 : 遍历1到100之间（包含1和100）的所有数字，统计能被5整除的偶数的个数，最后将个数打印在控制台
	static void question07() {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 5 == 0 && i % 2 == 0) {
				sum++;
			}
		}
		System.out.println("个数:" + sum);
	}

	/*
	 * 8 依次在main方法中完成以下要求：(自定义数组,并初始化元素,然后按照指定要求完成数组的遍历,并获取最值.) 1. 利用 for 循环求出
	 * 1~100 中（范围包括 1 和 100 ）最大的数并打印到控制台上； 2. 利用 while 循环求出 1~100 中（范围包括 1和 100
	 * ）最小的数并打印到控制台上；
	 */
	static void question08() {
		int[] test = new int[] { 12, 22, 3, 33, 23, 32, 46, 99 };
		int maxValue = test[0], minValue = test[0];
		for (int i = 0; i < test.length; i++) {
			if (maxValue < test[i]) {
				maxValue = test[i];
			}
		}
		int i = 0;
		while (i < test.length) {
			if (minValue > test[i]) {
				minValue = test[i];
			}
			i++;
		}
		System.out.println("数组中maxValue=" + maxValue + ",minValue=" + minValue);
	}

	// 9: 定义2个长度为5的字符串数组arrA和arrB，arrA包含元素{"a","b","c","d","e"};
	// 遍历arrA中的所有元素并按逆序存储在数组arrB中，并按arrB下标增长的顺序在控制台打印输出arrB数组中所有元素
	static void question09() {
		// String[] arrA = {"a","b","c","d","e"};
		String[] arrA = { "a", "e", "b", "d", "c" };
		String[] arrB = new String[5];
		Arrays.sort(arrA);
		System.out.println(Arrays.toString(arrA));
		for (int i = 0; i < arrA.length; i++) {
			arrB[4 - i] = arrA[i];
		}
		System.out.println(Arrays.toString(arrB));

	}

	// 定义类：Test，定义main方法，main方法内按以下要求编写代码：
	// 1. 定义一个int类型的数组，存储以下几个考试分数：
	// 88 96 97 74 90 58 77 90 99
	// 2. 计算这几个考试分数去掉最低分后剩余元素的平均分，并在控制台打印输出；
	static void question10() {
		int[] intA = { 88, 96, 97, 74, 90, 5, 77, 90, 99, };
		System.out.println(Arrays.toString(intA));
		int[] intB = new int[intA.length - 1];
		int minValue = intA[0];
		int i = 0, j = 0;
		for (; i < intA.length; i++) {
			if (minValue > intA[i]) {
				minValue = intA[i];
				j = i;// 记录最小值那个位置的索引
			}
		}
		// 把最小值放到后面,交换一下位置
		int temp = intA[intA.length - 1];
		intA[intA.length - 1] = minValue;
		intA[j] = temp;
		System.out.println(Arrays.toString(intA));
		intB = Arrays.copyOf(intA, intA.length - 1);
		System.out.println(Arrays.toString(intB));
	}
//	4.	字符串数组与集合
//	字符串数组strs中包含字符串{"12","345","6789","1","123","4567"}，
//	创建2个ArrayList集合，遍历strs数组，并判断数组中每一个元素的长度，将长度为偶数和长度为奇数的元素存入到两个集合中，最终将这个两个集合在控制台打印输出：打印格式如下：
	static void question11(){
		String[] strs = {"12","345","6789","1","123","4567"};
		ArrayList list1 = new ArrayList();
		ArrayList list2= new ArrayList();
		for(String str:strs){
			int len = str.length();
			if(len%2==0)
				list1.add(str);
			else
				list2.add(str);
		}
		System.out.println(Arrays.toString(strs));
		System.out.println(Arrays.toString(list1.toArray()));
		System.out.println(Arrays.toString(list2.toArray()));
		
	}
//	随机生成10个1-10之间的数（包括1和10），将生成的数放到数组中，计算数组中索引为奇数的元素平均值，并将结果打印到控制台上.
	static void question12(){
		int[] inta = new int[10];
		Random random = new Random();
		int sum = 0;
		int count=0;
		for(int j=0;j<inta.length;j++){
			inta[j]=(random.nextInt(10)+1);//0--9>> 1--10
			if(j%2==1){
				count++;
				sum+=inta[j];
			}
		}
		System.out.println(Arrays.toString(inta));
		System.out.println("sum="+sum+"count="+count+"结果为"+sum/count);
		
	}
//	依次在main方法中完成以下要求：自定义数组存储元素,元素包含1和100 数值.
//	1.	利用for循环求出1~100中（范围包括1和100）最大的数并打印到控制台上；
//	2.	利用while循环求出1~100中（范围包括1和100）最小的数并打印到控制台上；
	static void question13(){
		int[] a = new int[]{1,2,3,4,5,6,7,8,9,100};
		int maxValue=a[0];
		int minValue=a[0];
		for(int i=0;i<a.length;i++){
			if(maxValue<a[i]){
				maxValue= a[i];
			}
		}
		int j=0;
		while(j<a.length){
			if(minValue>a[j])
				minValue=a[j];
			j++;
		}
		System.out.println(Arrays.toString(a));
		System.out.println(maxValue+","+minValue);
	}
//	定义一个长度为10的int型的数组arr，依次生成10个1-100（范围包括1和100）的随机数并存入arr中,
//	然后将arr中的元素都往前移一个位置，最后一个元素的值是原来第一个元素的值，然后输出arr转换前和转换后的所有元素，演示格式如下：
	static void question14(){
		int a[] = new int[10];
		Random random = new Random();
		for(int i =0;i<a.length;i++){
			a[i]= random.nextInt(100)+1;
		}
		System.out.println(Arrays.toString(a));
		int first = a[0];//第一个值赋值给最后,最后一个值赋值给倒数第二位
		int last = a[a.length-1];
		a[a.length-1] = first;
		for(int i=0;i<a.length-1;i++){
			a[i]=a[i+1];
			if(i==a.length-2){
				a[a.length-2] = last;
			}
		}
		System.out.println(Arrays.toString(a));
			
	}
//	定义一个整数数组，包含元素{1,3,4,7,8}，获取数组中数组角标和对应的元素都为偶数的元素与个数，并在控制台打印输出。
	static void question15(){
		int[] a = {1,3,4,7,8};
		int count = 0;
		for(int i=0;i<a.length;i++){
			if(i%2==0 && a[i]%2==0){
				count++;
			}
		}
		System.out.println(count);
	}
//	一、	定义一个长度为5的int型数组，之后生成5个随机数存入数组，随机数范围为10到100（包含10和100），遍历数组，将数组中小于50的元素替换成0，之后打印修改后的数组
	static void question16(){
		int[] a = new int[5];
		for(int i=0;i<a.length;i++){
			a[i] = (new Random().nextInt(91)+10);
		}
		System.out.println(Arrays.toString(a));
		for(int i=0;i<a.length;i++){
			if(a[i]<50){
				a[i]=0;
			}
		}
		System.out.println(Arrays.toString(a));
		
	}
//	从键盘上输入10个整数，合法值位1、2或3，不是这3个数则为非法数字。试编程统计每个整数和非法数字的个数。
	static void printCount() {
		System.out.println("请输入10个整数:");
		int[] a = new int[10];
		Scanner sc = new Scanner(System.in);
		int count1 = 0, count2 = 0, count3 = 0, illegal = 0;
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
			switch (a[i]) {
			case 1:
				count1++;
				break;
			case 2:
				count2++;
				break;
			case 3:
				count3++;
				break;
			default:
				illegal++;
				break;
			}
		}
		System.out.println(Arrays.toString(a));
		System.out.println("count1=" + count1 + ",count2=" + count2 + ",count3=" + count3 + ",illegal=" + illegal);
	}
//	假设有一个长度为5的数组，数组元素通过键盘录入，如下所示：
//	int[] arr = {1,3,-1,5,-2}
//	要求：
//	创建一个新数组newArr[],新数组中元素的存放顺序与原数组中的元素逆序，并且如果原数组中的元素值小于0，
//	在新数组中按0存储。最后输出原数组和新数组中的内容
	static void day04(){
		System.out.println("录入5个数");
		Scanner sc = new Scanner(System.in);
		int a[] = new int[5];
		int[] b = new int[5];
		for(int i=0;i<a.length;i++){
			a[i]=sc.nextInt();
			if(a[i]<0)
				b[i]=0;
			else
				b[i]=a[i];
		}
		//逆序排序
		for(int i=0;i<b.length/2;i++){
			int temp = b[i];
			b[i] = b[b.length-1-i];
			b[b.length-1-i]=temp;
		}
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		
	}
	
//假设一个简单的在ATM的取款过程如下：首先提示用户输入密码（password），
//	最多只能输入3次，超过3次则提示用户"密码错误，请取卡"交易结束。
//	如果用户密码正确，再提示用户输入金额（amount），ATM只能输出100元的纸币，一次取钱数要求最低0元，最高1000元。
//	如果用户输入的金额符合上述要求，则打印输出用户取的钱数，最后提示用户"交易完成，请取卡"，否则提示用户重新输入金额。假设用户密码是"111111"。
	static void day047(){
		System.out.println("请输入密码");
		Scanner sc = new Scanner(System.in);
			for(int i=1;i<=3;i++){
				String password = sc.nextLine();
				if("111111".equals(password)){
					System.out.println("欢迎进入bank");
						int count=0;
						while(true){//直到取款金额正确,取款成功,才能退出
							if(count>0){//提示输入错误
								System.out.print("取款金额录入错误,");
							}
							System.out.println("请输入取款金额(100的倍数),不能超过21亿:");
							String amount = sc.nextLine();
							try {
								int amountMoney = Integer.parseInt(amount);
								if(amountMoney%100==0){
									System.out.println("交易金额"+amountMoney+"元,请取卡");
									return;
								}
							} catch (NumberFormatException e) {
								System.err.println("当前录入的是\""+amount+"\"系统无法识别");
							}
							count++;
					}	
				}
				System.out.println("密码错误,您还有"+(3-i)+"次机会");
			}
			System.out.println("密码错误,交易结束");
	}

	static void getMoney(){
		
	}
	static void getAmount(Scanner sc) {

	
	}
	//求1个数字的位数
	public static void getWS(int number){
		number = Math.abs(number);
		int index=0;
		while(number>0){
			number = number/10;
			index++;
		}
		System.out.println(index);
	}
//	定义一个方法,去打印指定两个年份之间所有的闰年年份
//	如:将2000和2005传入方法,方法执行完毕会打印出这段之间的所有闰年年份
//	2000和2004
//	提示:
//	计算公历年闰年的算法: 四年一闰，百年不闰，四百年再闰
//	翻译:
//	满足如下任意一条即使如年
//	1)年份是整百数的必须是400的倍数才是闰年(能被100整除并且能被400整除)
//	2)其他年份能被4的是闰年
//	实例: 2000 是整百数,并且是400的倍数所以是闰年; 2004年是4的倍数是闰年
//	2100 是整百的倍数但不是400的倍数,所以不是闰年

	public static void printRN(int startYear,int endYear){
		for(int i=startYear;i<endYear;i++){
			if(i%100==0 && i%400==0){
				System.out.print(i+" ");
				continue;
			}
			if(i%4==0 && i%100!=0 && i%400!=0)
				System.out.print(i+" ");
				
		}
	}
		
//	1.基础班考试要进行分组,键盘录入该班级总共多少组?以及每组的学生数量?
//	2.根据录入的组数及每组学员的数量创建二维数组
//	3.利用随机数产生0-100的成绩(包含0和100)

	static void day0408(){
		System.out.println("請輸入该班级总共多少组?");
		Scanner scanner = new Scanner(System.in);
		int groups = scanner.nextInt();//获取组
		int[] number = new int[groups];//收集每组的学生数量
		for(int i=0;i<groups;i++){
			System.out.println("请输入第"+i+"组的学生数量:");
			number[i]= scanner.nextInt();
		}
		//求各组学生中的最大值
		int maxNumber = number[0];
		for(int i=0;i<number.length;i++){
			if(maxNumber<number[i]){
				maxNumber = number[i];
			}
		}
		//根据录入创建二位数组
		int[][] second = new int[groups][maxNumber];
		Random random = new Random();
		int  ES[]= new int[groups];//各组不及格人数
		double avg[] = new double[groups];//各组的平均分
		for(int i=0;i<second.length;i++){
			int E=0;//每组中的不及格人数
			int sum=0;//每组的总分
			for(int j=0;j<number[i];j++){
				second[i][j] = random.nextInt(101);
				if(second[i][j]<60){
					E++;
				}
				sum+=second[i][j];
			}
			 double thisavg = sum/number[i];
			 avg[i] = thisavg;//记录每组平均分
			 ES[i] = E;//记录每组评分为E的不及格人数
			System.out.println("第"+i+"组的不及格人数为"+E+",平均分为"+thisavg);
		}
		//求最高平均分
		double maxAvg = avg[0];
		for(int i=0;i<avg.length;i++){
			if(maxAvg<avg[i]){
				maxAvg = avg[i];
			}
		}
		System.out.println("各组的最高平均分为"+maxAvg);
		//求班级不及格人数
		int countE = 0;
		for(int i=0;i<ES.length;i++){
			countE += ES[i];
		}
		System.out.println("班级中不及格人数为"+countE);
		
		//求班级平均分
		double sumScore=0;//班级总分
		int sumNumber=0;//班级总人数
		for(int i =0;i<groups;i++){
			double  groupScore = avg[i]*number[i];
			sumScore += groupScore;
			sumNumber +=number[i];
		}
		double gradeAvg = sumScore/sumNumber;
		System.out.println("班级平均分为:"+(int)gradeAvg);
		for(int[] aa:second){
			for(int aaa:aa){
				System.out.print(aaa+" ");
			}
			System.out.println();
		}
	}

	
	//打印一副扑克牌 大小王+52张牌(13张*4种花色)
	static void printPoker(){
		String[] huase = {"♠","♥","♣","♦"};
		String[] paimian = {"A","2","3","4","5","6","7","8","9","10","J","Q","K",};
		for(int i=0;i<huase.length;i++){
			for(int j=0;j<paimian.length;j++){
				//3,4,5,6,7,8,9,10,J,Q,K,A,2
				System.out.print(huase[i]+paimian[j]+" ");
				
			}
			System.out.println();
		}
		System.out.println("大😎");
		System.out.println("小😎");
	}

	//输入一个小于8位的整数,将其加密,规则如下
	//1.逆序;2.对其每一位加5取10的余数;3.首位和末尾互换
	//123456 -- 654321 --109876 --609871
	static String jiaMi(int number){
		int[] arr = new int[8];
		int index=0;
		while(number>0){//求出每个位的位数 个位--十位--百位...
			arr[index] = number%10;//对10取模求个位数
			index++;
			number = number/10;//缩小十倍
		}
		for(int j=0;j<index;j++){
			arr[j] +=5;
			arr[j] %= 10;
		}
		int temp = arr[index-1];
		arr[index-1] = arr[0];
		arr[0] = temp;
		String str = "";
		for(int k=0;k<index;k++){
			str +=arr[k];
		}
		return str;
	}
	
	static void print99(){
		for(int i=0;i<=9;i++){
			for(int j=0;j<=i;j++){
				System.out.print(i+"*"+j+"="+i*j+" ");
			}
			System.out.println();
		}
	}
	static void day0409(){
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 5, 6, 7 };
		int[] temp = arr1;
		System.out.println("通过temp取出arr1中的元素: ");

		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i] + " ");
		}
		temp = arr2;
		System.out.println("通过temp取出arr2中的元素: ");
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i] + " ");
		}
	}
	
//杨辉三角 ,每一行的每一位数字为上一行的对应为数字和上一行前一位数字之和
//	1 
//	1 1 
//	1 2 1 
//	1 3 3 1 
//	1 4 6 4 1 
//	1 5 10 10 5 1 
//	1 6 15 20 15 6 1 
	
	static void printYHSJ(int n){
		n=n+1;
		int[][] yh= new int[n][n];
		if(n<3){
			System.out.println("输入错误");
		}
		hehe:
		for(int i=1;i<n;i++){
			yh[i][0]=1;//始终输入第一行和最后一行的1    //y[1][0]=1
			for(int j=1;j<n;j++){
				yh[i][j]=yh[i-1][j-1]+yh[i-1][j];//计算其他行的数字,并存入数组  //y[1][1]=0;y[1][2] = 0;y[1][3]=0;0,0,0,0
//				System.out.print(yh[i][j]+" ");
//				break hehe;
 			}
		}
		for(int k=0;k<n;k++){
			for(int t=0;t<k;t++){
				System.out.print(yh[k][t]+" ");
			}
			System.out.println();
		}
	}
	
	static void printYH(int n){
		n =n+1;
		int[][] yh = new int[n][n];//n=7
		for(int i=1;i<n;i++){
			for(int j=1;j<n;j++){
				yh[i][0] = 1;
				yh[i][j] = yh[i-1][j-1]+yh[i-1][j];//y[1][0]=1;y[1][1] =0;y[1][2] = 0;y[1][3]=0;y[1][4]=0;y[1][5]=0;y[1][6]=0; 1,0,0,0,0,0,0
													//y[2][0] =1 ;y[2][1] =1;y[2][2] =0;  									   1,1,0,0,0,0,0
													//y[3][0]=1;y[3][1]=2,y[3][2]=1;y[3][3]=                                   1,2,1,0,0,0,0
													//y[4][0]=1;y[4][1]=3,y[4][2]=3,y[4][3]=1,                                 1,3,3,1,0,0,0
													
			}
			
		}
		for(int i=0;i<yh.length;i++){
			for(int j=0;j<i;j++){
				System.out.print(yh[i][j]+" ");
			}
			System.out.println();
		}
	}

	/**
	 * 把一个数组按第一次输出2个,第二次输出3个,第三次出现2个,第四次出现3个...全部打印出来  
	 * --每次输出使用的容器不同,抽象出来2个不同容量的数组,定义一个计数器,每间隔1次换一次容器,容器取水时,每次要把索引后移一位,判断数组越界
	 * 
	 * @author zhoumo
	 */
	static void testmind() {
		 int a[] = new int[]{3,3,2,4,3,4,4,1,3,2,4,3,4,5,6,3,4,5,3};
		int count = 1;
		int[] a2 = new int[2];// 容器
		int[] a3 = new int[3];// 容器
		for (int i = 0; i < a.length;) {
			count++;// 计数器
			if (count % 2 == 0) {//
				a2[0] = a[i++];
				if (i < a.length) {
					a2[1] = a[i++];
				} else {
					System.out.println(a2[0]);
					break;
				}
				System.out.println(a2[0] + " " + a2[1]);
			} else {
				if (i < a.length)
					a3[0] = a[i++];
				else
					System.out.println(a3[0]);
				if (i < a.length)
					a3[1] = a[i++];
				else
					System.out.println(a3[0] + " " + a3[1]);
				if (i < a.length) {
					a3[2] = a[i++];
					System.out.println(a3[0] + " " + a3[1] + " " + a3[2]);
				} else {
					System.out.println(a3[0] + " " + a3[1]);
				}
			}

		}

	}
	

	static void teachermide(){
		int a =0;
		for(int i=1000;i<9999;i++){
			if(i%6==0 && i%12!=0){
				if(a==2){
					System.out.println();
				}
				if(a==5){
					System.out.println();
					a=0;
				}
				System.out.print(i+" ");
				a++;
			}
		}
	}
	static void question17(){
		Random random = new Random();
		int a = random.nextInt(100)+1;
		int b = random.nextInt(100)+1;
		System.out.println("a="+a+",b="+b+",a+b="+(a+b));
	}
	static void question18(){
		int[] arr= {10,255,30,40,50,60};
		int maxValue=arr[0];
		int index=0;
		for(int i=0;i<arr.length;i++){
			if(maxValue<arr[i]){
				maxValue=arr[i];
				index=i;
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("最大值:"+maxValue+",下标为:"+index);
		
	}
	/**
	 * 不死神兔  斐波那契数列 1,1,2,3,5,8,13...
 	 */
	public static int fbnq(int i){
		if(i==1||i==2){
			return 1;
		}else{
			return fbnq(i-1)+fbnq(i-2);
		}
	}
	
	public static int teacherFbnq(int n){
		if(n<0){
			return -1;
		}
		int[] a = new int[n];
		a[0]=1;a[1]=1;
		int x=0;//x对应数组中那个位置的数字
		for(int i=2;i<n;i++){
				a[i] = a[i-1]+a[i-2];
				x = a[i];
		}
		return x;
	}
	/**
	 * 冒泡排序
	 */
	static void bubble() { 
		int a[] = new int[] { 33, 366, 22, 44, 23, 34, 46 };
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[j] > a[i]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(a));

	}

	// 学生管理系统
	static ArrayList<Student> arrayList = new ArrayList<Student>();
	 static void menu(){
		 
		 while(true){
				printn("-----学生管理系统------");
				printn("1.查看所有学生");
				printn("2.添加学生");
				printn("3.删除学生");
				printn("4.修改学生");
				printn("5.退出");
				Scanner scanner = new Scanner(System.in);
				String in = scanner.nextLine();
				switch (in) {
				case "1":
					findAll();
					break;
				case "2":
					addStudent();
					break;
				case "3":
					deleteStudent();
					break;
				case "4":
					updateStudent();
					break;
				case "5":
					System.out.println("系统退出");
					// break;
					System.exit(2);
				default:
					System.err.println("当前输入的是:" + in + ",请输入12345");
				}
		 }

	}


	static void findAll() {
		for (Student stu : arrayList) {
			System.out.println("学号:" + stu.getId() + ",姓名:" + stu.getName());
		}
	}

	@SuppressWarnings("resource")
	static void addStudent(){
		printn("请输入学号:");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.nextLine();
		printn("请输入姓名:");
		String name = scanner.nextLine();
		Student student = new HomeWork02().new Student(id, name);
		arrayList.add(student);
		printn("添加完成,返回主菜单");
	}
	static void deleteStudent(){
		printn("请输入需要删除的学生学号:");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.nextLine();
		for(Student student : arrayList){
			if(student.getId().equals(id)){
				arrayList.remove(student);
				printn("删除完成,返回主菜单");
				menu();
				break;
			}
		}
		printn("输入的学号为"+id+",当前没有这个学生");
	}
	static void updateStudent(){
		printn("请输入需要修改的学生学号:");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.nextLine();
		for(Student student : arrayList){
			if(student.getId().equals(id)){
				print("查询结果为,学号:"+id+",姓名:"+student.getName());
				arrayList.remove(student);
				printn("请输入学号");
				String id1 = scanner.nextLine();
				printn("请输入姓名");
				String name = scanner.nextLine();
				Student stu = new HomeWork02().new Student(id1, name);
				arrayList.add(stu);
				print("修改完成");
			}
		}
		printn(id+"没有该学号学生");
	
	}

	class Student {
		String id;
		String name;

		Student(String id, String name) {
			this.id = id;
			this.name = name;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	public static void print(Object obj) {
		System.out.print(obj);
	}

	public static void printn(Object obj) {
		System.out.println(obj);
	}

}
