package vip.huanghetang.jybhomework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

public class Day07 {
	public static void main(String[] args) {
//		question03();
//		GenericClass<String> gc = new GenericClass<String>("abc");
//		System.out.println(	gc.getReference().getClass());
//		gc.function(new Date());
//		gc.function(Math.random());
//		question06();
//		String[] a = {"q","w","e","r"};
//		Integer[] b = {1,2,3,4};
//		int[] c = {2,3,4,5};
//		swap(a,-1,3);
//		swap(b,1,3);
////		swap(c,1,3);
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.toString(b));
//		System.out.println(Arrays.toString(c));
//		String[] a = {"q","w","e","r"};
//		Integer[] b = {1,2,3,4};
//		Calendar c = Calendar.getInstance();
//		c.add(Calendar.DAY_OF_MONTH, -1);
//		Date[] data = {c.getTime(),new Date()};
//		printArr(a);
//		printArr(b);
//		printArr(data);
//		question07();
//		printArr(c);
//		System.out.println(getSum(1.0f, 3.53));;
//		playPoker();
		//[♠3, ♠6, ♠J, ♠Q, ♣10, ♣2, ♣6, ♣8, ♣K, ♥10, ♥5, ♥7, ♥K, ♥Q, ♦10, ♦3, ♦7, ♦9, 大🐒, 小🐒]
//		String s1 = "♠3";
//		String n1 = s1.substring(1);
//		System.out.println(n1);
//		int[] arr = new int[]{3,99,1,34,45,36,76};
////		bubbleSort(arr);
//		selectSort(arr);
//		System.out.println(arr);
//		System.out.println(Arrays.toString(arr));
//		int index = binarySearch(arr,11);
//		System.out.println(index);
		ArrayList<String> alist = new ArrayList<String>();
		alist.add("sdfsd");
		alist.add("sdfs");
//		Object[] objs = alist.toArray();
		String[] strs = null;
		String[] obj = alist.toArray(strs);
		System.out.println(alist);
		System.out.println("strs"+Arrays.toString(strs));
		System.out.println("obj"+Arrays.toString(obj));
		HashSet s ;
		
	}
	
	
	
	/**
	 * 相邻两个数比较..所以最后一次是length-2和length-1比较
	 * 第一一次遍历数组把最大值放在最后一位,第二次遍历放在倒数第二位...共需要遍历length-1次
	 * 每一次单独的遍历需要比较里面所有的数-当前有几个排好序的数
	 * @param arr
	 */
	static void bubbleSort(int [] arr){
		for(int x=0;x<arr.length-1;x++){
			for(int y=0;y<arr.length-1-x;y++){
				if(arr[y]>arr[y+1]){
					int temp = arr[y];
					arr[y] = arr[y+1];
					arr[y+1] = temp;
				}
			}
		}
		
	}
	
	/**
	 * 选择排序
	 * 第一次比较把数组中最小值放在最左边,第二次把最小值放在索引第二个位置...共需要遍历length-1次
	 * 每一次比较时用当前索引对应的值和所有值比较,把小的换到当前位置,本次遍历的次数会随着把最小值依此排序,逐渐减少
	 */
	static void selectSort(int[] arr){
		for(int x=0;x<arr.length-1;x++){
			for(int y=x+1;y<arr.length;y++){
				if(arr[x]>arr[y]){
					int temp = arr[x];
					arr[x] = arr[y];
					arr[y] = temp;
				}
				
			}
		}
		
	}
	
	/**
	 * 数组二分法查找
	 * 对已排序的数组, 用二分法找key值多对应数组中元素的下标,没有返回-1
	 */
	static int binarySearch(int[] a,int key){
		int min = 0;
		int max = a.length-1;
		int mid = (min+max)/2;
		while(key!=a[mid]){
			if(key>a[mid]){
				min = mid+1;
			}else if(key<a[mid]){
				max = mid -1;
			}
			if(min>max){
				return -1;
			}
			mid = (min+max)/2;
		}
		return mid;
		
	}
	
//	往ArrayList添加以下元素"abc1", "abc2", "abc3", "abc4".使用迭代器获取ArrayList集合中的元素
	static void question03(){
		Collection<String> c = new ArrayList<String>();
		c.add("abc1");
		c.add("abc2");
		c.add("abc3");
		c.add("abc4");
		ArrayList<String> al = new ArrayList<String>();
		al.add("zhoumo");
		al.add("jigntian");
		al.add("jigntian1");
		al.add("jigntian2");
		c.addAll(al);
		Iterator<String> it = c.iterator();
//		while(it.hasNext()){
//			String str = it.next();
//			System.out.println(str);
//		}
//		System.out.println("--------------------");
//		for(Iterator<String> it1 = c.iterator();it1.hasNext();){
//			System.out.println(it1.next());
//		}
		System.out.println("================");
		for (String string : c) {
			System.out.println(string);
		}
		System.out.println("=============");
		ArrayList<String> cc = (ArrayList<String>)c;
		for(int i=0;i<c.size();i++){
			String str = cc.get(i);
			if("zhoumo".equals(str)){
				cc.remove(str);
				i--;
			}
			System.out.println(str);
		}
		
		System.out.println("======================");
		for (String string : cc) {
			System.out.println(string);
		}
		
		
	}
	/**
	 * 自定义学生类:包含姓名,年龄,成绩属性.私有成员变量,生成无参,有参构造方法,生成get/set方法.
	 * 创建5个学生放到ArrayList中.使用迭代器获取每个学生信息.统计总分,平均分,最高分,最低分并输出
	 */
	void question05(){
		
	}
	
	/**
	 * ArrayList中有如下数据:"a", "b", "c", "c", "a", "b", "b", "b", "a".
	 * 定义名为:frequency(ArrayList arr, String key)的方法.arr是ArrayList集合,
	 * key是要查找的某个元素.使用增强for方式查找key在ArrayList中出现的次数.并将次数作为方法的返回值.在mian方法中调用frequency方法
	 */
	static void question06(){
		ArrayList<String> arrayList = new ArrayList<String>();
		String[] s = {"a", "b", "c", "c", "a", "b", "b", "b", "a"};
		for (String string : s) {
			arrayList.add(string);
		}
		int count = frequency(arrayList,"A");
		System.out.println(count);
		
	}
	static <S>int frequency(ArrayList<S> arr,String key){
		int count = 0;
		for (S str : arr) {
			if(key.equals(str))
				count++;
		}
		return count;
	}
	
	static <T>void swap(T[] array,int firstIndex,int secondIndex){
		if(firstIndex<0 || firstIndex>=array.length)
			throw new IllegalArgumentException();
		if(secondIndex<0 || secondIndex>=array.length)
			throw new IllegalArgumentException();
		
		T element = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = element;
		
	}
	
	/**
	 * 编写一个泛形方法，接收一个任意类型数组，并将数组中的元素按照一定的格式打印.” [3, 6, 7, 1, 2] ”
	 */
	
	 static <T>void printArr(T[] arr){
		 if(arr==null){
			 System.out.println("null");
			 return;
		 }
		 if(arr.length==0){
			 System.out.println("[]");
		 }
		 StringBuilder sb = new StringBuilder("[");
		 for (T t : arr) {
			sb.append(t).append(" ,");
		}
		 sb.delete(sb.length()-2, sb.length()).append("]");
		 System.out.println(sb.toString());
	 }
	 
	 /**
	  * 有一个数组 String arr[]={"abc","bad","abc","aab","bad","cef","jhi"};
	  * 创建一个ArrayList，将arr数组里面的元素添加进ArrayList中去，但ArrayList中元素不能重复 (arr数组不变)
	  */
	 static void question07(){
		 String arr[]={"abc","bad","abc","aab","bad","cef","jhi"};
		 ArrayList<String> arrayList = new ArrayList<String>();
		 for (String string : arr) {
			if(!arrayList.contains(string)){
				arrayList.add(string);
			}
		}
//		Iterator<String> it = arrayList.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
		 System.out.println(arrayList);
	 }

	 
	 /**
	  * 编写一个泛型方法求两个数之和.两个数可以传入int、long、float、double类型.
	  *  提示:泛型不能使用基本数据类型,需要使用引用数据类型.Integer,Long,Float,Double都是Number的子类. Number有doubleValue()方法
	  */
	 
	 static <T extends Number>double getSum(T t1,T t2){
		 System.out.println( t1.doubleValue());
		 System.out.println( t2.doubleValue());
		 return  t1.doubleValue()+ t2.doubleValue();
	 }
	 
	 /**
	  * 统计101-200之间有多少个素数，并输出所有素数。素数又叫质数，就是除了1和它本身之外，再也没有整数能被它整除的数。
	  */
	 
	 static void getSS(){
		 int count = 0;
		 for(int i=101;i<=200;i++){
			 if(isZS(i)){
				 count++;
				 System.out.println(i+"是素数(质数)");
			 }
		
		 }
		 System.out.println(count);
	 }


	private static boolean isZS(int i) {
		for(int x=2;x<i;x++){
			if(i%x==0){
				return false;
			}
		}
		return true;
	}
	
	
	
//	1.完成斗地主案例
//	2.增加需求:哪个玩家拿到大王,就需要拿底牌
	static void  playPoker(){
		String[] colors = {"♠","♥","♦","♣"};
		String[] numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
		ArrayList<String> pokerArr = new ArrayList<String>();
		for (String color : colors) {
			for (String number : numbers) {
				pokerArr.add(color+number);
			}
		}
		pokerArr.add("大🐒");
		pokerArr.add("小🐒");
		System.out.println(pokerArr);
		ArrayList<String> a1 = new ArrayList<String>();//底牌
		int flag = -1;//0是a2拿到大王...1,2
		ArrayList<String> a2 = new ArrayList<String>();
		ArrayList<String> a3 = new ArrayList<String>();
		ArrayList<String> a4 = new ArrayList<String>();
		Collections.shuffle(pokerArr);//洗牌
		for(int i=0;i<pokerArr.size();i++){
			String poker = pokerArr.get(i);
			if(i<3){//3张底牌
				a1.add(poker);
			}else if(i%3==1){
				if("大🐒".equals(poker)){
					flag =0;
				}
				a2.add(poker);
			}else if(i%3==2){
				if("大🐒".equals(poker)){
					flag =1;
				}
				a3.add(poker);
			}else{
				if("大🐒".equals(poker)){
					flag =2;
				}
				a4.add(poker);
			}
		}
//		2.增加需求:哪个玩家拿到大王,就需要拿底牌
		if(flag==-1){
			System.out.println("大🐒在底牌里面");
		}else if(flag==0){
			a2.addAll(a1);
		}else if(flag ==1){
			a3.addAll(a1);
		}else
			a4.addAll(a1);
		myComparator m =new myComparator();
		Collections.sort(a1,m);
		Collections.sort(a2,m);
		Collections.sort(a3,m);
		Collections.sort(a4,m);
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		
		
		
	}
}
class myComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof String && o2 instanceof String){
			String s1 = (String)o1;
			String s2 = (String)o2;
			if((!"🐒".endsWith(s1))&& (!"🐒".endsWith(s2)) ){
//				if(s1.length()==2 || s2.length()==2){
//					return s1.compareTo(s2);
//				}else{
//					int n1 = Integer.parseInt(s1.substring(1));
//					int n2 = Integer.parseInt(s1.substring(1));
//					return n1-n1;
//				}
				return s1.compareTo(s2);
			}
		}
		return 0;
	}
	
}

class GenericClass<E>{
	private E reference;

	
	public E getReference() {
		return reference;
	}


	public void setReference(E reference) {
		this.reference = reference;
	}


	public GenericClass(E reference){
		this.reference = reference;
	}
	public GenericClass(){}
	
	public <T> void function(T t){
		System.out.println("传输的参数类型是"+t.getClass()+",值为:"+t);
	}
}

//自定义一个泛型接口Inter <E>,包含show(E e)抽象方法.
//使用1.定义实现类时确定泛型的类型, 2.定义实现类时不确定泛型的类型2种方式定义实现类.并使用实现类
interface Inter<E>{
	
	public abstract void show(E e);
	
}

class InterImpl<E> implements Inter<E>{

	@Override
	public void show(E e) {
		// TODO Auto-generated method stub
		
	}

	
}























