package vip.huanghetang.jybhomework;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

public class Day08 {
	
	public static void main(String[] args) {
//		testLinkedList();
//		question9();
		question9();
		
	}


	static void testArrayList(){
		ArrayList arrayList = new ArrayList();
		arrayList.add("qwe");
		arrayList.add("qwe");
		arrayList.add("asdf");
//		System.out.println(arrayList);
////		Iterator iterator = linkedList.iterator();
		Iterator iterator1 = arrayList.iterator();
//		LinkedList linkedList = new LinkedList();
		while(iterator1.hasNext()){
			String str = (String) iterator1.next();
			if("qwe".equals(str)){
				iterator1.remove();
				arrayList.remove(str);//java.util.ConcurrentModificationException 并发修改异常,迭代时不允许修改
				
			}
			}
//		}
//		ListIterator listIterator = linkedList.listIterator();
//		while(listIterator.hasNext()){
//			String str = (String) listIterator.next();
//			if("qwe".equals(str)){
//				listIterator.remove();
//			}
//		}
//		System.out.println(arrayList);
	}

	private static void testLinkedList() {
		LinkedList<String> linkedList = new LinkedList();
		
		linkedList.add("qwesdfsf");
		linkedList.add("qwe");
		linkedList.add("qwe");
		linkedList.add("asdf");
		linkedList.addFirst("liuyan");
		linkedList.addLast("gaoyuanyuan");
		System.out.println(linkedList);
//		System.out.println(linkedList.getFirst());;
//		System.out.println(linkedList.getLast());
//		System.out.println(linkedList.removeFirst());
//		System.out.println(linkedList.removeLast());
//		System.out.println(linkedList.poll());//弹出第一个
//		 push 将元素推入此列表所表示的堆栈（元素存储到集合顶部,addFirst） 
		linkedList.push("jingtian");
		System.out.println(linkedList.pop());  //8. pop 从此列表所表示的堆栈处弹出一个元素（最顶部元素弹出,removeFirstt）
		
		System.out.println(linkedList);
	}
	
	
	
	static void testHashSet(){
		
		HashSet hashSet = new HashSet();
		hashSet.add("123");
		hashSet.add("123");
		hashSet.add("asd");
//		hashSet.add(new Date());
		Iterator it = hashSet.iterator();
		System.out.println(hashSet);
		while(it.hasNext()){
			Object obj = it.next();
			System.out.println(obj);
			if("123".equals(obj)){
				it.remove();
			}
			
		}
		System.out.println(hashSet);
	}
	
	static void question1(){
		HashSet<Student1> hashSet = new HashSet<Student1>();
		Student1 stu = null;
		String name = null;
		for(int i=0;i<10;i++){
			 name = "a"+i;
			stu =  new Student1(18, name, "man");
			hashSet.add(stu);
		}
		System.out.println(hashSet.size());
		stu =  new Student1(18, "a0", "man");
		System.out.println(stu);
		boolean b = hashSet.add(stu);
		System.out.println(b);
		System.out.println(hashSet.size());
		for (Student1 student1 : hashSet) {
			System.out.println(student1.getName());
		}
	}
	
	/**
	 * 编写一个程序，获取10个1至20的随机数，要求随机数不能重复。使用迭代器把最终的结果输出到控制台。
	 */
		static void question2(){
			Random random = new Random();
			HashSet hashSet = new HashSet();
			int count = 0;
			while(true){
				if(count==10){
					break;
				}
				int number = random.nextInt(20)+1;
				if(hashSet.add(number)){
					count++;
				}
				
			}
			Iterator iterator = hashSet.iterator();
			while(iterator.hasNext()){
				Object o = iterator.next();
				System.out.println(o);
			}
		}
		/**
		 * 键盘录入一个字符串.去掉其中重复字符, 打印出不同的那些字符.必须保证顺序.例如输入:aaaabbbcccddd,打印结果为:abcd
		 */
		static void question3(){
			Scanner scanner =  new Scanner(System.in);
			System.out.println("输入一行字符:");
			String s = scanner.nextLine();
			char[] chars = s.toCharArray();
			System.out.println(s);
			LinkedHashSet set = new LinkedHashSet();
			for (char thischar : chars) {
				set.add(thischar);
			}
			StringBuilder sb = new StringBuilder();
			Iterator iterator = set.iterator();
			while(iterator.hasNext()){
				Object next = iterator.next();
				sb.append(next);
			}
			System.out.println("结果为"+sb.toString());
			
		}
		
		/**
		 * 定义一个方法filterChars(ArrayList<String> list)将传入的ArrayList<String>集合中的每个元素中的字母过滤掉,
		 * 比如list有2个元素{"hello123java", "11world555java"}，返回结果{"123", "11555"}
		 */
		
		static void question5(){
			ArrayList<String> arrayList = new ArrayList<String>();
			arrayList.add("hello123java");
			arrayList.add("11world555java");
			arrayList.add("123abc");
			
			fileterChars(arrayList);
			System.out.println(arrayList);
			
		}
		private static  void fileterChars(ArrayList<String> list){
			for(int i=0;i<list.size();i++){
				String str = list.get(i);
				String str1 = str.replaceAll("[a-zA-Z]", "");//替换掉所有字母
				list.set(i, str1);
			}
		}
		
		/**
		 * 双色球规则:双色球每注投注号码由6个红色球号码和1个蓝色球号码组成。
		 * 红色球号码从1—33中选择；蓝色球号码从1—16中选择.请随机生成一注双色球号码
		 */
		
		static void question7(){
			Random random = new Random();
			int blueNumber = random.nextInt(16)+1;
			HashSet<Integer> hashSet = new HashSet<Integer>();
			int count = 0;
			int redNumber = -1;
			while(true){
				redNumber = random.nextInt(33)+1;
				if(!hashSet.contains(redNumber)){
					hashSet.add(redNumber);
					count++;
				}
				if(count==6){
					break;
				}
			}
			hashSet.add(blueNumber);
			System.out.println(hashSet);
			
			
		}
		/**
		 * 有一堆零件数量不超过1000个,如果4个零件一组最后剩余2个,如果7个零件一组最后剩余3个,如果9个零件一组最后剩余5个,请计算这堆零件个数有几种可能
		 */
		static void question8(){
			 int count = 0;
			for(int i=1;i<=1000;i++){
				if(i%4==2 && i%7==3 && i%9==5){
					count++;
					System.out.println(i);
				}
			}
			System.out.println(count);
		}
		
		/**
		 * 将50元兑换成5元,2元和1元.每种面额的钱不能为0张.共有几种兑换方法.每种兑换方法的钱是怎么样的?
		 */
		static void question9(){
			int count=0;
			for(int x = 1;x<10;x++){
				for(int y=1;y<=22;y++){
					for(int z=1;z<=47;z++){
						if(5*x+2*y+z ==50){
							count++;
							System.out.println("5*"+x+"+2*"+y+"+"+z+"=50");
							
						}
						
					}
				}
			}
			System.out.println(count);
			
		}
	/**
	 * 定义一个Student类,包含名称,年龄,性别(姓名,年龄,性别完全相同视为同一学生)
		创建10个Student对象,至少有两个学生姓名,年龄,性别完全相同.
 		把这10个学生添加到Set集合中,不可以重复,遍历Set集合打印学生信息,使用两种方式
	 * @author zhoumo
	 *
	 */
	
	

}
 class Student1{
	private Integer age;
	private String name;
	private String gender;
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public Student1(Integer age, String name, String gender) {
		super();
		this.age = age;
		this.name = name;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student1 [age=" + age + ", name=" + name + ", gender=" + gender + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student1 other = (Student1) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
	
	
	
}
