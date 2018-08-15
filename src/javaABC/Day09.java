package javaABC;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Day09 {

	public static void main(String[] args) {
//		Map<String,String> map = new HashMap<String,String>();
//		map.put("12", "qwe");
//		map.put("123", "qwer");
//		map.put("1", "q");
//		map.put("3", "d");
//		map.put(null, null);
//		
//		Map<String,String> map2 = new HashMap<String,String>();
//		map2.put("12", "qwe");
//		map2.put("123", "qwer");
//		map2.put("1", "q");
//		map2.put("3", "d");
//		map2.put("", null);
//		System.out.println(map2.containsKey(null));
//		System.out.println(map2.get(null));
//		System.out.println(map.equals(map2));;
//		map.put(null, null);
//		System.out.println(map.get(null));;
//		Set<Map.Entry<String,String>> set = map.entrySet();
//		try{
//			int i=1/0;
//			System.out.println(1);
//		}catch(Exception e){
//			e.printStackTrace();
//			System.out.println("异常了");
//		}finally{
//			System.out.println(11);
//		}
//		System.out.println(2);
//		System.out.println(1+2);
//		playPoker();
		question7();
		
			
	}
	static void method(String...a){
		
	}
	
	
	
	 static void question1(){
//		 ArrayList<Integer> a = new ArrayList<Integer>();
//		 a.add(11);
//		 a.add(33);
//		 a.add(44);
//		 a.add(55);
//		 a.add(77);
		 ArrayList<Double> a = new ArrayList<Double>();
		 a.add(1.1);
		 a.add(2.2);
		 a.add(3.33);
		 a.add((double) 44);
		 a.add((double) 77);
		 System.out.println(a);
		 int index =  SearchIndexFromArrarList(a,44);
		 System.out.println(index);
	 }
	 
	/**
	 * 有四种水果(苹果，香蕉，西瓜，橘子) 1、给每种水果设定一个商品号，商品号是8个0-9的随机数，商品号码不能重复,最小值 "00000001",
	 * 最大值 "99999999" 2、根据商品号查询对应的商品。 如果查不到输出：“查无此商品”
	 * 如果能查到打印：”根据商品号：12345678，查询到对应的商品为：西瓜”
	 * 
	 */
	 static void question3(){
		 HashMap<String,String> hashMap = new HashMap<String,String>();//水果
		 String[] fruit = {"苹果","香蕉","西瓜","橘子"};
//		 hashMap.put("12345678","苹果");
		 Random r = new Random();
		 int count=10;
		 while(count>0){//加十个水果
			 int randomIndex = r.nextInt(4);
			 String randomNumber = getRandomNumber();
			 if(!hashMap.containsKey(randomNumber)){
				 hashMap.put(randomNumber,fruit[randomIndex]);
				 count--;
			 }
		 }
		 System.out.println(hashMap);
		 String id = "12345678";
		if(hashMap.containsKey(id)){
			System.out.println(id+"对应的商品是"+hashMap.get(id));
		}else{
			System.out.println("查无此商品"+id);
		}
	
	 }
	 

	 	static String getRandomNumber(){
	 		Random random = new Random();
	 		StringBuilder sb = new StringBuilder();
	 		for(int i=0;i<8;i++){
	 			int x = random.nextInt(10);
	 			sb.append(x);
	 		}
	 		
	 		return sb.toString();
	 	}
	/**
	 * ArrayList集合中有如下内容: {11,33,55,77},使用Collections.binarySearch ()查询33元素在ArrayList集合中的索引是多少
	 * 思路  二分法
	 */
	static int SearchIndexFromArrarList(ArrayList<? extends Number> a, Number key){
		int min = 0;
		int max = a.size()-1;
		int mid = (min+max)/2;
		Number value = a.get(mid);
		while(key.doubleValue()!=value.doubleValue()){
			if(key.doubleValue()>value.doubleValue()){
				min = mid+1;
			}else if(key.doubleValue()<value.doubleValue()){
				max = mid-1;
			}
			if(min>max){
				return -1;
			}
			mid = (min+max)/2;
			value = a.get(mid);
		}
		return mid;
		
	}
	/**
	 * 利用键盘录入，输入一个字符串,统计该字符串中各个字符的数量
		如用户输入字符串:"hello world java",程序输出结果：h(1)e(1)l(3)o(2)(2)w(1)r(1)d(1)j(1)a(2)v(1)
		注：输出结果不要求顺序一致

	 */
	static void question2(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入:");
		String str = scanner.nextLine();
		char[] charArray = str.toCharArray();
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for(char c : charArray){
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}else{
				map.put(c,1);
			}
		}
		System.out.println(map);
		Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
		for (Entry<Character, Integer> entry : entrySet) {
			Character key = entry.getKey();
			Integer value = entry.getValue();
			System.out.print(key+"("+value+")");
		}
	}
	
	 /**
	  * ArrayList集合中有如下内容: {11,33,55,77}.使用2种方式将集合中的数据转成数组
	  */
	 static void question4(){
		 ArrayList<Integer> arrayList = new ArrayList<Integer>();
		 arrayList.add(11);
		 arrayList.add(33);
		 arrayList.add(44);
		 arrayList.add(77);
		 Object[] array = arrayList.toArray();
		 System.out.println(Arrays.toString(array));
		 Integer[] a = new Integer[4];
		 arrayList.toArray(arrayList.toArray(a));
		 System.out.println(Arrays.toString(a));
		 int index =  Collections.binarySearch(arrayList, 444);
		 System.out.println(index);
		 
	 }
	 /**
	  * 键盘录入一个字符串,分别统计出其中英文字母、空格、数字和其它字符的数量,输出结果:”其他=1, 空格=2, 字母=12, 数字=6”
	  * @return
	  */
	 static void question5(){
		 Scanner scanner =new Scanner(System.in);
		 System.out.println("please write a String:");
		 String str = scanner.nextLine();
		 char[] chars = str.toCharArray();
		 int qt=0,space=0,letter=0,number=0;
		 for (char c : chars) {
			if(c==' '){
				space++;
			}else if(c>'A' &&c <'z'){
				letter++;
			}else if(c>'0' && c<'9'){
				number++;
			}else{
				qt++;
			}
		}
		 System.out.println("其他="+qt+" 空格="+space+" 字母="+letter+" 数字="+number);
		 
	 }
	 /**
	  * 定义一个List集合,泛型为String类型。统计整个集合中所有字符（注意，不是字符串）的个数。
	  * 例如:集合中有”abc”、”bcd”两个元素,程序最终输出结果为:“a = 1,b = 2,c = 2,d = 1”
	  */
	 static void question6(){
		 ArrayList<String> arrayList = new ArrayList<String>();
		 arrayList.add("abc");
		 arrayList.add("bcd");
		 HashMap<Character, Integer> hashMap = new LinkedHashMap<Character,Integer>();
		 for (String string : arrayList) {//遍历list
			char[] chars = string.toCharArray();
			for (char c : chars) {//遍历每一个str
				Integer  value = hashMap.get(c);
				if(value==null){//第一次
					hashMap.put(c, 1);
				}else{//多次
					hashMap.put(c,value+1);
				}
				
			}
		}
		printHashMap(hashMap);
		 
	 }
	 
	/**
	 * 键盘录入语句英语,统计每个单词出现的次数,有如下字符串
	 * "If you want to change your fate I think you must come to the dark horse to learn java"
	 * (用空格间隔) 打印格式： to=3 think=1 you=2
	 * 
	 */
	 static void question7(){
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入:");
			String str = scanner.nextLine();
			String[] words = str.split(" ");
			HashMap<String, Integer> hashMap = new HashMap<String,Integer>();
			for (String string : words) {
				Integer value = hashMap.get(string);
				if(value==null){
					hashMap.put(string, 1);
				}else{
					hashMap.put(string,value+1);
				}
			}
			System.out.println(hashMap);
	 }
	static void studyHashMap(){
		HashMap<Integer, String> hashMap = new HashMap<Integer,String>();
		hashMap.put(1, "柳岩");
		hashMap.put(2, "景甜");
		hashMap.put(3, "景甜");
		hashMap.put(4, "古力娜扎");
		hashMap.put(5, "欧阳娜娜");
		hashMap.put(6, "杨颖");
		String val = hashMap.put(1, "迪丽热巴");
		hashMap.remove(6);
		
		Collection<String> values = hashMap.values();
		for (String value : values) {
			System.out.println(value);
		}
//		System.out.println(val);
		printHashMap(hashMap);
		System.out.println();
		printHashMap2(hashMap);
		System.out.println();
		printHashMap3(hashMap);
	}
	
	/**
	 * 打印Map集合
	 * @param map
	 */
	static <K,V> void printHashMap(Map<K,V> map){
		Set<K> set =  map.keySet();
		for (K key : set) {
			V value = map.get(key);
			System.out.print(key+"---"+value+" ");
		}
	}
	/**
	 * 打印HashMap
	 * @param map
	 */
	static <K,V>void printHashMap2(HashMap<K,V> map){
		Set<Map.Entry<K, V>> entrySet  = map.entrySet();
		Iterator<Map.Entry<K, V>> it = entrySet.iterator();
		while(it.hasNext()){
			 Map.Entry<K, V>  entry = it.next();
			 K key = entry.getKey();
			 V value = entry.getValue();
			 System.out.println(key+"---"+value);
		}
	}
	/**
	 * 打印HashMap
	 * @param map
	 */
	static <K,V>void printHashMap3(HashMap<K,V> map){
		Set<Map.Entry<K, V>> entrySet = map.entrySet();
		for (Entry<K, V> entry : entrySet) {
			K key = entry.getKey();
			V value = entry.getValue();
			System.out.println(key+"---"+value);
		}
	}
	/**
	 * 关流
	 * @param ios
	 */
	static void CloseIO(Closeable...ios){
		for(Closeable io:ios){
			try{
				io.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 1.创建一副扑克扑克 建立与poker大小对应的索引,并把索引拿出来.对索引打乱顺序,发索引,遍历索引对应的poker
	 */
	
	@SuppressWarnings("unchecked")
	static void playPoker(){
		String[] colors = {"♠","♥","♦","♣"};
		String[] numbers = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
		HashMap<Integer,String> pokers = new HashMap<Integer,String>();//一副牌
		ArrayList<Integer> pokerIndex = new ArrayList<Integer>();//牌面对应的索引值
		int i=0;
		for (String number : numbers) {//52张
			for (String color : colors) {
				pokers.put(i, color+number);
				pokerIndex.add(i);
				i++;
			}
		}
		pokers.put(52, "大王");
		pokers.put(53, "小王");
		pokerIndex.add(52);
		pokerIndex.add(53);
		Collections.shuffle(pokerIndex);//洗牌
		ArrayList<Integer> a1= new ArrayList<Integer>();
		ArrayList<Integer> a2= new ArrayList<Integer>();
		ArrayList<Integer> a3= new ArrayList<Integer>();
		ArrayList<Integer> dp= new ArrayList<Integer>();
		for(int j=0;j<pokerIndex.size();j++){
			Integer ip = pokerIndex.get(j);
			if(j<3){
				dp.add(ip);//发3张底牌
			}else if(j%3==1){
				a1.add(ip);
			}else if(j%3==2){
				a2.add(ip);
			}else{
				a3.add(ip);
			}
		}//发牌结束
		
		sortPoker(a1,a2,a3,dp);
		printPoker(pokers,a1,a2,a3,dp);
		
		
	}
	@SuppressWarnings("unchecked")
	private static void printPoker( HashMap<Integer, String> pokers,ArrayList<Integer>...pokerIndexs) {
		for(ArrayList<Integer> thisIndexs : pokerIndexs){//遍历所有人手牌索引集合
			for (Integer pi : thisIndexs) {//根据牌面索引打印牌面
				 System.out.print(pokers.get(pi)+" ");
			}
			System.out.println();
		}
		
	
	}
	
	@SuppressWarnings("unchecked")
	private static void sortPoker(ArrayList<Integer>...lists){
		for (ArrayList<Integer> arrayList : lists) {
			Collections.sort(arrayList);
		}
	}
	

}
