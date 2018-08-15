package vip.huanghetang.homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Day08 {
	public static void main(String[] args) {
//		question1();
//		String str = "avadsfsdfsdjava";
//		int index = str.indexOf("java");
//		 str = str.substring(index);
//		System.out.println((int)'0');
		questionTZ2();
		
	}

	
//	一、	需求说明：请用户输入一个“QQ号码”，我们来判断这个QQ号码是否正确。
//	要求：使用方法来完成判断功能。
//	2.	在MainApp类中定义方法：checkQQ (String qq)
//	方法内实现验证。验证规则：
//	1)	必须是5—12位数字；
//	2)	首位不能是0；

		static void question1(){
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入一个QQ号");
			String str = scanner.nextLine();
			if(isQQ(str))
				System.out.println("这是一个合法的qq号");
			else
				System.out.println("这不是一个合法的qq号");
		}
	
	static boolean isQQ(String qq){

		if(qq==null || qq.length()<5 || qq.length()>12){
			return false;
		}
		for(int i=0;i<qq.length()-1;i++){
			try{
				int temp = Integer.parseInt(qq.charAt(i)+"");
			if(!(temp>=0 && temp<=9)){
				return false;
			}
			}catch(Exception e){
				return false;
			}
		}
		if("0".equals(qq.charAt(0)+""))
			return false;
		return true;
	}
	
//	一、	需求说明：定义如下字符串：
//	String str = “javajfiewjavajfiowfjavagkljjava”;
//	二、	请分别定义方法统计出：                  
//	1.	字符串中：字符j的数量
//	2.	字符串中：字符串java的数量
	
	static void question2(){
		String str = "javajfiewjavajfiowfjavagkljjava";
		int count = 0;
		int javaCount=0;
		for(int i =0;i<str.length();i++){
			if("j".equals(str.charAt(i)+"")){
				count++;
			}
		}
		String[] a = str.split("java");
		System.out.println("j的数量为"+count);
		int index=0;
		while(index!=-1){
			if(str.length()<4){//StirngIndexOutOfBoundsException
				break;
			}
			index = str.indexOf("java");
			str = str.substring(index+4);//截取掉"java",4个长度
			javaCount++;
			System.out.println(str);
		}
		System.out.println("java出现的次数为"+javaCount);
	}
	
	
//	一、	需求说明：实现用户注册、登陆功能；
//	1.	程序中使用一个长度为3的对象数组，存储用户的登录名和密码：
//	例如如下格式：
//		登录名    密码      生日           爱好
//	zhangsan	1111	1998-03-15	旅游，唱歌
//	lisi	2222	2002-05-20	吃饭，睡觉，打豆豆
//	wangwu	3333	2001-07-28	看书，看电影，旅游
//	注册时，要判断数组是否已满，是：则禁止注册。
//	2.	循环为用户列出菜单：
//	1.注册     2.登陆     3.退出
//	3.	用户选择1，调用：registe()方法，执行注册流程；
//	用户选择2，调用：login()方法，执行登陆流程；
//	用户选择3，结束程序；
//	4.	编写方法：registe()，执行注册流程：
//		要求用户输入以下信息(信息无需校验)：
//				用户名：
//				登录密码：
//				出生日期：
//				爱好：（多个爱好中间用逗号(中英文都可以)隔开）
//	5.	编写方法：login()，执行登陆流程：
//		请用户输入登录名、登陆密码；
//		使用登录名和密码进行验证；
//	通过：打印：这个用户的所有信息；
//	未通过：打印：用户名或密码错误！
	static User[] users = new User[3];
	static int userIndex = 0;//记录用户数组的实际长度
	static void questionTZ2(){
		Scanner scanner = new Scanner(System.in);
		menu(scanner);
		login(scanner);
	}
	//主菜单显示
	private static void menu(Scanner scanner){
		System.out.println("1.注册");
		System.out.println("2.登陆");
		System.out.println("3.退出");
		String in = scanner.nextLine();
		switch(in){
		case "1":
			registe(scanner);
		case "2":
			login(scanner);
		case "3":
			System.exit(0);
		}
		
	}

	//注册
	private static void registe(Scanner scanner){
		if(userIndex==3){
			System.out.println("长度为3禁止注册");
		}
		System.out.println("正在注册,请输入用户名:");
		String name = scanner.nextLine();
		System.out.println("登录密码:");
		String password = scanner.nextLine();
		System.out.println("出生日期");
		String birthday = scanner.nextLine();
		System.out.println("爱好");
		String hobby = scanner.nextLine();
		User user  = new Day08().new User(name,password,birthday,hobby);
		users[userIndex++] = user;
		System.out.println("注册成功");
		menu(scanner);//回到菜单
		
		
	}
	private static void login(Scanner scanner){
		if(userIndex==0){
			System.out.println("没有用户请先注册");
			menu(scanner);
//			System.out.println("sdfsdfsdfsdf-----------");
//			return;
		}
			
		System.out.println("正在登陆,请输入用户名:");
		String name = scanner.nextLine();
		System.out.println("登录密码:");
		String password = scanner.nextLine();
		boolean flag = false;//登陆成功标识
		for(int i=0;i<3;i++){
			if(name.equals(users[i].getName()) && password.equals(users[i].getPassword())  ){
				flag = true;
				break;
			}
		}
		if(flag)
			System.out.println("登陆成功");
		else
			System.out.println("登陆失败,请检查用户名和密码");
		menu(scanner);
	}

	class User{
		private String name;
		private String password;
		private String birthday;
		private String hobby;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getBirthday() {
			return birthday;
		}
		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}
		public String getHobby() {
			return hobby;
		}
		public void setHobby(String hobby) {
			this.hobby = hobby;
		}
		public User(String name, String password, String birthday, String hobby) {
			super();
			this.name = name;
			this.password = password;
			this.birthday = birthday;
			this.hobby = hobby;
		}
		public User(){}
		@Override
		public String toString() {
			return "User [name=" + name + ", password=" + password + ", birthday=" + birthday + ", hobby=" + hobby
					+ "]";
		}
		
		
	}
//	分析以下需求,并用代码实现
//	1.键盘录入一个源字符串由字符串变量scrStr接收
//	2.键盘录入一个要删除的字符串由字符串变量delStr接收
//	3.要求
//		删除该字scrStr符串中的所有delStr字符串（最终的字符串中不能包含delStr），要求打印删除后的结果以及删除了几个delStr字符串
//	4.代码运行打印格式:
//		请输入源字符串:java woaijava,i like jajavava i enjoy java
//	java woaijava, i like javajava i enjoy java
//		请输入要删除的字符串:java
//		控制台输出结果:源字符串中总共包含:5 个 java 删除java后的字符串为: woai,i like  i enjoy


	static void questionTZ3(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入源字符串:");
		String scrStr = scanner.nextLine();
		System.out.println("请输入要删除的字符串:");
		String delStr = scanner.nextLine();
		int count=0,
			index=0;
		int length = delStr.length();
		String[] a = scrStr.split(delStr);
		while(index!=-1){
			if(scrStr.length()<length){//防止抛出异常
				break;
			}
			index  = scrStr.indexOf(delStr);
			scrStr = scrStr.substring(index+length);//截取delStr后重新赋值
			count++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<a.length;i++){
			sb.append(a[i]);
		}
		System.out.println("控制台输出结果:源字符串中总共包含:"+count+"个"+delStr+" 删除"+delStr+"后的字符串为:"+sb.toString());
	}
	
//	分析以下需求,并用代码实现
//	1.键盘录入一个字符串
//	2.将该字符串变成字符数组(不能使用toCharArray()方法)
//	3.将字符数组中的所有大写字母变成小写字母(不能使用toLowerCase()方法)
//	4.如果第一位和最后一位的内容不相同,则交换
//	5.将字符数组中索引为偶数的元素变成'~'
//	6.打印数组元素的内容

	static void questionTZ4(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("录入一个字符串:");
		String str = scanner.nextLine();
		char[] chars = toCharArr(str);
		System.out.println(Arrays.toString(chars));
		toLowCase(chars);
		System.out.println(Arrays.toString(chars));
		String first = chars[0]+"";
		String last = chars[chars.length-1]+"";
		if(!first.equals(last)){
			char temp = chars[0];
			chars[0] = chars[chars.length-1];
			chars[chars.length-1] = temp;
		}
		System.out.println(Arrays.toString(chars));
		for(int i=0;i<chars.length;i++){
			if(i%2==0){
				chars[i]='~';
			}
		}
		System.out.println(Arrays.toString(chars));
		StringBuilder sb = new StringBuilder();
		sb.append("chars [");
		for(int i=0;i<chars.length;i++){
			if(i==chars.length-1){
				sb.append(chars[i]+"]");
			}else{
				sb.append(chars[i]).append(",");
			}
		}
		System.out.println(sb.toString());
		
	}


private static void toLowCase(char[] chars) {
	for(int i=0;i<chars.length;i++){
		if(chars[i]>64 && chars[i]<91){//A=65 Z=65+25
			chars[i] = (char) (chars[i]+32);//a=97,A=65
		}
		
	}
}


private static char[] toCharArr(String str) {
	if(str==null || str.length()==0)
		return new char[0];
	char[] chars = new char[str.length()];
	for(int i=0;i<str.length();i++){
		chars[i] = str.charAt(i);
	}
	return chars;
}
//分析以下需求,并用代码实现
//1.定义String getStr(char[] chs)方法
//	功能描述：获取长度为5的随机字符串，字符串由随机的4个大写英文字母和1个0-9之间（包含0和9）的整数组成
//2.定义main方法，方法内完成：
//	(1)定义长度为26，元素值为26个大写英文字母的数组chs
//	(2)传递数组chs调用getStr(char[] chs)方法，获取返回值,并在控制台打印返回值
	static void questionTZ5(){
		String str = "ABCDEFGHIJKLMNOPQRStuvwxyz123456";
		char[] chs= str.toCharArray();
		System.out.println(Arrays.toString(chs));
		String retStr = getStr(chs);
		System.out.println(retStr);
	}

	/**
	 * 传入一个字符数组 返回字符数组中随机的4个大写字符和一个数字字符组成的字符串,如果字符数组不满足要求返回null
	 * @param chs
	 * @return
	 */
	private static String getStr(char[] chs){
		if(chs==null || chs.length==0){
			return null;
		}
		char[] upcase = new char[chs.length];//存放大写字母的数组
		char[] number= new char[chs.length];
		int index=0,nindex=0;
		
		for(int i=0;i<chs.length;i++){
			if(chs[i]>64 && chs[i]<91){//A=65
				upcase[index++]=chs[i];//把大写字母抽取到数组中
			}
			if(chs[i]>47 && chs[i]<58){// 0==48
				number[nindex++]=chs[i];
			}
		}
		System.out.println("upcase:"+Arrays.toString(upcase));
		System.out.println("nubmer:"+Arrays.toString(number));
		if(index<4 || nindex<1){//原始字符数组中没有4个大写字母或者没有1个数组,返回null
			return null;
		}else{
			StringBuilder sb = new StringBuilder();
			Random random = new Random();
			for(int i=0;i<4;i++){
				sb.append(upcase[random.nextInt(index)]);//从大写字符数组中随机抽取4个字符,可以重复
			}
			sb.append(number[random.nextInt(nindex)]);//从数字数组中随机得到一个数字
			return sb.toString();
		}
		
	}
	
//	根据传入的字符串，获取指定的字符串
	static void quetionTZ6(){
		String property = "name";
		System.out.println(getMethodByName("get",property));
		System.out.println(getMethodByName("set",property));;
		
	}


	/**
	 * 通过set,get标识和属性名字,返回get或set方法
	 * @param getOrSet
	 * @param property
	 * @return
	 */
private static String getMethodByName(String getOrSet,String property) {
	if(property ==null || property.length()==0)
		return null;
	String firstString=property.substring(0,1);//截取第一个字符
	String newFirst = firstString.toUpperCase();//大写
	String afterStr = property.substring(1);//截取后面的字符串
	if("get".equals(getOrSet)){
		return "get"+newFirst+afterStr;
	}else if("set".equals(getOrSet)){
		return "set"+newFirst+afterStr;
	}else{
		return null;
	}
}

}
