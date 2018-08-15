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
				arrayList.remove(str);//java.util.ConcurrentModificationException �����޸��쳣,����ʱ�������޸�
				
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
//		System.out.println(linkedList.poll());//������һ��
//		 push ��Ԫ��������б�����ʾ�Ķ�ջ��Ԫ�ش洢�����϶���,addFirst�� 
		linkedList.push("jingtian");
		System.out.println(linkedList.pop());  //8. pop �Ӵ��б�����ʾ�Ķ�ջ������һ��Ԫ�أ����Ԫ�ص���,removeFirstt��
		
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
	 * ��дһ�����򣬻�ȡ10��1��20���������Ҫ������������ظ���ʹ�õ����������յĽ�����������̨��
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
		 * ����¼��һ���ַ���.ȥ�������ظ��ַ�, ��ӡ����ͬ����Щ�ַ�.���뱣֤˳��.��������:aaaabbbcccddd,��ӡ���Ϊ:abcd
		 */
		static void question3(){
			Scanner scanner =  new Scanner(System.in);
			System.out.println("����һ���ַ�:");
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
			System.out.println("���Ϊ"+sb.toString());
			
		}
		
		/**
		 * ����һ������filterChars(ArrayList<String> list)�������ArrayList<String>�����е�ÿ��Ԫ���е���ĸ���˵�,
		 * ����list��2��Ԫ��{"hello123java", "11world555java"}�����ؽ��{"123", "11555"}
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
				String str1 = str.replaceAll("[a-zA-Z]", "");//�滻��������ĸ
				list.set(i, str1);
			}
		}
		
		/**
		 * ˫ɫ�����:˫ɫ��ÿעͶע������6����ɫ������1����ɫ�������ɡ�
		 * ��ɫ������1��33��ѡ����ɫ������1��16��ѡ��.���������һע˫ɫ�����
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
		 * ��һ���������������1000��,���4�����һ�����ʣ��2��,���7�����һ�����ʣ��3��,���9�����һ�����ʣ��5��,����������������м��ֿ���
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
		 * ��50Ԫ�һ���5Ԫ,2Ԫ��1Ԫ.ÿ������Ǯ����Ϊ0��.���м��ֶһ�����.ÿ�ֶһ�������Ǯ����ô����?
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
	 * ����һ��Student��,��������,����,�Ա�(����,����,�Ա���ȫ��ͬ��Ϊͬһѧ��)
		����10��Student����,����������ѧ������,����,�Ա���ȫ��ͬ.
 		����10��ѧ����ӵ�Set������,�������ظ�,����Set���ϴ�ӡѧ����Ϣ,ʹ�����ַ�ʽ
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
