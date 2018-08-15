package vip.huanghetang.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

import vip.huanghetang.util.MyArrayListTools;

public class Day09 {


	public static void main(String[] args) {
		System.out.println(System.lineSeparator());;
//		question01();
//		StringBuilder sb;
//		questionTZ5();
//		ArrayList list = new ArrayList();
//		System.out.println("list.size"+list.size());
//		list.add(1);
//		System.out.println("list.size"+list.size());
////		list.set(0, "123");//抛出异常
//		list.add(null);
//		list.add(1, null);
////		System.out.println(list.contains(null));;
////		System.out.println("null==null:"+(null==null));
//		list.add("ab1");
//		list.add("123ad");
//		list.add("bca");
//		list.add("dadfadf");
//		list.add("你好啊");
//		list.add("我来啦");
//		list.add("别跑啊");
//		System.out.println(list);
//		Object obj = list.clone();
//		System.out.println("clone"+obj);
//		((ArrayList) obj).clear();
//		System.out.println(list);
//		System.out.println("obj"+obj);
		Object[] a = {1,2,3,4,5,6};
		System.out.println(Arrays.toString(a));
		System.arraycopy(a, 3,a, 2,3);
		System.out.println(Arrays.toString(a));
		a[5]=null;
		System.out.println(Arrays.toString(a));
		
		
		
	}
	
//	public static void main(String[] args) {
//		Scanner scanner=new Scanner(System.in);
//		for(int i=0;i<3;i++){
//			System.out.println("输入第"+(i+1)+"个字符");
//			String name=scanner.nextLine();
//			System.out.println("输入第"+(i+1)+"个值");
//			int age=scanner.nextInt();
//		}
//		
//	}
	
	
//	一、	请按以下要求编写代码：
//	1.	定义一个只能存储字符串的集合对象；
//	2.	向集合内添加以下数据：
//		“孙悟空”
//		“猪八戒”
//		“沙和尚”
//		“铁扇公主”
//	3.	不用遍历，直接打印集合；
//	4.	获取第4个元素（注意，是--第4个元素，它的索引是？）
//	5.	打印一下集合大小；
//	6.	删除元素“铁扇公主”
//	7.	删除第3个元素（注意：是--第3个元素）
//	8.	将元素“猪八戒”改为“猪悟能”
//	9.	再次打印集合；
	@Test
	public  void question01(){
		ArrayList<String> array = new ArrayList<String>();
		array.add("孙悟空");
		array.add("猪八戒");
		array.add(2,"沙和尚");
		System.out.println(array.add("铁杉公主"));
		array.add("猪八戒123");
		System.out.println(array);
		System.out.println(array.get(3)+","+array.size());
		System.out.println("------------------------------");
		for(int i=0;i<array.size();i++){
			String name = array.get(i);
			if(i==2){
				array.remove(i);//删除元素会影响集合的size(),之后的元素会前移
//				continue;
			}
			if("猪八戒".equals(name)){
				array.set(i, "猪悟能");
			}
			System.out.println(name);
		}
//		System.out.println(array.set(1, "猪悟能"));;
		System.out.println(array);
		System.out.println(array.toString());
	}
	
//	一、	请按以下要求编写代码：
//	1.	定义Student类，包含以下属性：
//		学号、姓名、身高
//	2.	定义MainApp类，包含main()方法；
//	3.	在main()方法中，创建一个可以存储Student对象的集合对象；
//	4.	创建以下几个Student对象：
//		学号		姓名		身高	
//		it001	黄渤		1.72
//		it002	孙红雷	1.78
//		it003	章子怡	1.64
//		it004	杨颖		1.68
//	5.	将上面几个对象添加到集合中
//	6.	遍历集合打印每个对象的属性值；
//	7.	获取并打印集合大小；
//	8.	获取第3个学员对象，并打印其属性值；
//	9.	移除掉第4个学员对象；
//	10.	再次获取并打印集合大小；
//	11.	将第一个对象替换为以下对象：
//		it005	撒贝宁	1.67
//	12.	遍历集合，打印出身高在1.70以上的学员信息；
//	13.	遍历集合，打印出“孙”姓的学员信息；
	
	static void question02(){
		
	}
	
//	一、	需求说明：程序启动后可以接收三个学员信息，然后可以打印所有学员信息，并找出身高最高的学员，并打印他们的详细信息
	static void question03(){
		
	}
	
//	分析以下需求，并用代码实现	
//	1.按照以下描述完成类的定义。
//		学生类
//			属性：
//				姓名name
//				年龄age
//				成绩score
//			行为：
//			吃饭eat()
//			stuty(String content)(content:表示学习的内容)
//	2.定义学生工具StudentsTool,有四个方法,描述如下
//		public void listStudents(Student[] arr):遍历打印学生信息
//		public int getMaxScore(Student[] arr):获取学生成绩的最高分
//		public Student getMaxStudent(Student[] arr):获取成绩最高的学员
//		public int getAverageScore(Student[] arr):获取学生成绩的平均值
//		public int getCount(Student[] arr):获取不及格的学员数量
//	3.定义测试类TestStudentTool，在main方法中首先创建长度为5的Student数组并初始化数据,再创建StudentsTool类的对象,并调用以上方法	

	static void test(){
		Scanner scanner = new Scanner(System.in);
		for(int i=0;i<3;i++){
			System.out.println("请输入:");
			String s= scanner.nextLine();
			System.out.println("请输入:");
			String ss= scanner.nextLine();
			System.out.println(s+","+ss);
			
		}
	}
	
	
	
//	分析以下需求，并用代码实现
//	1.定义Student类
//		属性:
//			姓名：String name
//			年龄：int age
//			成绩：int score
//		行为:
//			空参构造方法
//			有参构造方法
//			set和get方法
//			toString方法
//	2.定义测试类,进行测试
//		(1)创建5个学生对象存入ArrayList集合中
//		(2)打印最高分的学员姓名、年龄、成绩  [要求封装1个方法  参数是集合对象   返回值类型为Student]
//		(3)打印5个学生的总成绩和平均分		 [要求封装两个方法完成]
//		(4)打印不及格的学员信息及数量		 [要求封装一个方法完成]
	
	
	
	
	
//	分析以下需求，并用代码实现
//	1.定义ArrayList集合，存入多个字符串
//	   如:"ab1" "123ad"  "bca" "dadfadf"  "dddaaa"  "你好啊"  "我来啦"  "别跑啊"
//	2.遍历集合,删除长度大于5的字符串,打印删除后的集合对象
//	3.基于上一步,删除集合中元素包含0-9数字的字符串(只要字符串中包含0-9中的任意一个数字就需要删除此整个字符串)

	static void questionTZ3(){
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("ab1");
		arr.add("123ad");
		arr.add("bca");
		arr.add("dadfadf");
		arr.add("你好啊");
		arr.add("我来啦");
		arr.add("别跑啊");
		System.out.println(arr);
		for(int i=0;i<arr.size();i++){
			String element = arr.get(i);
			if(element.length()>5){
				arr.remove(i);
			}
		}
		System.out.println(arr);
		for(int i=0;i<arr.size();i++){
			String element = arr.get(i);
			char[] chars = element.toCharArray();//遍历这个字符串 包涵0-9 集合删除这个元素
			for(int j=0;j<chars.length;j++){
				if(chars[j]>='0' && chars[j]<='9'){//有数字
					arr.remove(i);
					i--;//删除这个元素,后面的元素会前移,导致遍历不到
					break;//退出当前循环,集合继续遍历
				}
			}
		}
		System.out.println(arr);
	}

	
//	分析以下需求，并用代码实现
//	定义MyArrays类，该类中有以下方法，方法描述如下：
//	1.public static void reverse(ArrayList<Integer> list);
//		参数ArrayList<Integer> list:要进行操作的集合对象		
//		要求：对list集合对象中的元素进行反转(第一个和最后一个交换，第二个和倒数第二个交换，第三个和倒数第三个交换...)
//	2.public static Integer max(ArrayList<Integer> list);
//		参数ArrayList<Integer> list:要进行操作的集合对象		
//		要求：求出list集合对象中的最大值并返回
//	3.public static Integer min(ArrayList<Integer> list);
//		参数ArrayList<Integer> list:要进行操作的集合对象		
//		要求：求出list集合对象中的最小值并返回
//	4.public static int indexOf(ArrayList<Integer> list,Integer i);
//		参数ArrayList<Integer> list:要进行操作的集合对象
//		参数Integer i:需要在集合中查找的元素
//		要求：求出元素i在list集合中第一次出现的索引，如果没有返回-1
//	5.public static void replaceAll(ArrayList<Integer> list,Integer oldValue,Integer newValue);
//		参数ArrayList<Integer> list:要进行操作的集合对象
//		参数Integer oldValue:需要被替换掉的原值
//		参数Integer newValue：替换后的新值
//		要求：将list集合中的所有值为oldValue的元素替换为newValue

	static void questionTZ4(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		System.out.println(list);
		MyArrayListTools.reverse(list);
		System.out.println(list);
		System.out.println("min"+MyArrayListTools.min(list));
		System.out.println("max"+MyArrayListTools.max(list));
		System.out.println(MyArrayListTools.indexOf(list,3));
		MyArrayListTools.replaceAll(list,1,99);
		System.out.println(list);
	}
	
//	1.定义ArrayList集合，存入多个字符串"abc" "def"  "efg" "def" "def" "qwe" "def" "def" "swd" "wwe" "def" "def"
//	2.使用普通for循环获取集合中索引为3的元素并打印
//	3.定义方法public static int myContains(ArrayList list,String str)
//	4.利用上面定义的mycontains方法统计集合中包含字符串"def"的数量
//	5.删除集合中的所有字符串"def"(循环判断集合中是否包含"def"字符串,包含就删除)
//	6.将集合中每个元素中的小写字母变成大写字母
//	7.在上一步的基础上,将集合转换成String类型的数组,遍历打印数组
	static void questionTZ5(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("def");
		list.add("efg");
		list.add("def");
		list.add("def");
		list.add("qwe");
		list.add("def");
		System.out.println(list);
		System.out.println(myContains(list, "def"));;
		System.out.println(list);
		upcaseArrayElement(list);
		System.out.println(list);
//		MyArrayListTools.indexOf(list, "def");
		String [] str = toArray(list);
		System.out.println(Arrays.toString(str));
		
	}
	
	public static int myContains(ArrayList list,String str){
		int count = 0;
		for(int i=0;i<list.size();i++){
			if(str.equals(list.get(i))){
				count++;
				list.remove(i);
				i--;
			}
		}
		return count;
	}
	static void upcaseArrayElement(ArrayList list){
		for(int i=0;i<list.size();i++){
			list.set(i, ((String) list.get(i)).toUpperCase());
		}
	}
	static String[] toArray(ArrayList<String> list){
		String[] array = new String[list.size()];
		int index =0;
		for(String str:list){
			array[index++] = str;
		}
		return array;
	}
	
}
