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
////		list.set(0, "123");//�׳��쳣
//		list.add(null);
//		list.add(1, null);
////		System.out.println(list.contains(null));;
////		System.out.println("null==null:"+(null==null));
//		list.add("ab1");
//		list.add("123ad");
//		list.add("bca");
//		list.add("dadfadf");
//		list.add("��ð�");
//		list.add("������");
//		list.add("���ܰ�");
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
//			System.out.println("�����"+(i+1)+"���ַ�");
//			String name=scanner.nextLine();
//			System.out.println("�����"+(i+1)+"��ֵ");
//			int age=scanner.nextInt();
//		}
//		
//	}
	
	
//	һ��	�밴����Ҫ���д���룺
//	1.	����һ��ֻ�ܴ洢�ַ����ļ��϶���
//	2.	�򼯺�������������ݣ�
//		������ա�
//		����˽䡱
//		��ɳ���С�
//		�����ȹ�����
//	3.	���ñ�����ֱ�Ӵ�ӡ���ϣ�
//	4.	��ȡ��4��Ԫ�أ�ע�⣬��--��4��Ԫ�أ����������ǣ���
//	5.	��ӡһ�¼��ϴ�С��
//	6.	ɾ��Ԫ�ء����ȹ�����
//	7.	ɾ����3��Ԫ�أ�ע�⣺��--��3��Ԫ�أ�
//	8.	��Ԫ�ء���˽䡱��Ϊ�������ܡ�
//	9.	�ٴδ�ӡ���ϣ�
	@Test
	public  void question01(){
		ArrayList<String> array = new ArrayList<String>();
		array.add("�����");
		array.add("��˽�");
		array.add(2,"ɳ����");
		System.out.println(array.add("��ɼ����"));
		array.add("��˽�123");
		System.out.println(array);
		System.out.println(array.get(3)+","+array.size());
		System.out.println("------------------------------");
		for(int i=0;i<array.size();i++){
			String name = array.get(i);
			if(i==2){
				array.remove(i);//ɾ��Ԫ�ػ�Ӱ�켯�ϵ�size(),֮���Ԫ�ػ�ǰ��
//				continue;
			}
			if("��˽�".equals(name)){
				array.set(i, "������");
			}
			System.out.println(name);
		}
//		System.out.println(array.set(1, "������"));;
		System.out.println(array);
		System.out.println(array.toString());
	}
	
//	һ��	�밴����Ҫ���д���룺
//	1.	����Student�࣬�����������ԣ�
//		ѧ�š����������
//	2.	����MainApp�࣬����main()������
//	3.	��main()�����У�����һ�����Դ洢Student����ļ��϶���
//	4.	�������¼���Student����
//		ѧ��		����		���	
//		it001	�Ʋ�		1.72
//		it002	�����	1.78
//		it003	������	1.64
//		it004	��ӱ		1.68
//	5.	�����漸��������ӵ�������
//	6.	�������ϴ�ӡÿ�����������ֵ��
//	7.	��ȡ����ӡ���ϴ�С��
//	8.	��ȡ��3��ѧԱ���󣬲���ӡ������ֵ��
//	9.	�Ƴ�����4��ѧԱ����
//	10.	�ٴλ�ȡ����ӡ���ϴ�С��
//	11.	����һ�������滻Ϊ���¶���
//		it005	������	1.67
//	12.	�������ϣ���ӡ�������1.70���ϵ�ѧԱ��Ϣ��
//	13.	�������ϣ���ӡ������յ�ѧԱ��Ϣ��
	
	static void question02(){
		
	}
	
//	һ��	����˵����������������Խ�������ѧԱ��Ϣ��Ȼ����Դ�ӡ����ѧԱ��Ϣ�����ҳ������ߵ�ѧԱ������ӡ���ǵ���ϸ��Ϣ
	static void question03(){
		
	}
	
//	�����������󣬲��ô���ʵ��	
//	1.�����������������Ķ��塣
//		ѧ����
//			���ԣ�
//				����name
//				����age
//				�ɼ�score
//			��Ϊ��
//			�Է�eat()
//			stuty(String content)(content:��ʾѧϰ������)
//	2.����ѧ������StudentsTool,���ĸ�����,��������
//		public void listStudents(Student[] arr):������ӡѧ����Ϣ
//		public int getMaxScore(Student[] arr):��ȡѧ���ɼ�����߷�
//		public Student getMaxStudent(Student[] arr):��ȡ�ɼ���ߵ�ѧԱ
//		public int getAverageScore(Student[] arr):��ȡѧ���ɼ���ƽ��ֵ
//		public int getCount(Student[] arr):��ȡ�������ѧԱ����
//	3.���������TestStudentTool����main���������ȴ�������Ϊ5��Student���鲢��ʼ������,�ٴ���StudentsTool��Ķ���,���������Ϸ���	

	static void test(){
		Scanner scanner = new Scanner(System.in);
		for(int i=0;i<3;i++){
			System.out.println("������:");
			String s= scanner.nextLine();
			System.out.println("������:");
			String ss= scanner.nextLine();
			System.out.println(s+","+ss);
			
		}
	}
	
	
	
//	�����������󣬲��ô���ʵ��
//	1.����Student��
//		����:
//			������String name
//			���䣺int age
//			�ɼ���int score
//		��Ϊ:
//			�ղι��췽��
//			�вι��췽��
//			set��get����
//			toString����
//	2.���������,���в���
//		(1)����5��ѧ���������ArrayList������
//		(2)��ӡ��߷ֵ�ѧԱ���������䡢�ɼ�  [Ҫ���װ1������  �����Ǽ��϶���   ����ֵ����ΪStudent]
//		(3)��ӡ5��ѧ�����ܳɼ���ƽ����		 [Ҫ���װ�����������]
//		(4)��ӡ�������ѧԱ��Ϣ������		 [Ҫ���װһ���������]
	
	
	
	
	
//	�����������󣬲��ô���ʵ��
//	1.����ArrayList���ϣ��������ַ���
//	   ��:"ab1" "123ad"  "bca" "dadfadf"  "dddaaa"  "��ð�"  "������"  "���ܰ�"
//	2.��������,ɾ�����ȴ���5���ַ���,��ӡɾ����ļ��϶���
//	3.������һ��,ɾ��������Ԫ�ذ���0-9���ֵ��ַ���(ֻҪ�ַ����а���0-9�е�����һ�����־���Ҫɾ���������ַ���)

	static void questionTZ3(){
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("ab1");
		arr.add("123ad");
		arr.add("bca");
		arr.add("dadfadf");
		arr.add("��ð�");
		arr.add("������");
		arr.add("���ܰ�");
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
			char[] chars = element.toCharArray();//��������ַ��� ����0-9 ����ɾ�����Ԫ��
			for(int j=0;j<chars.length;j++){
				if(chars[j]>='0' && chars[j]<='9'){//������
					arr.remove(i);
					i--;//ɾ�����Ԫ��,�����Ԫ�ػ�ǰ��,���±�������
					break;//�˳���ǰѭ��,���ϼ�������
				}
			}
		}
		System.out.println(arr);
	}

	
//	�����������󣬲��ô���ʵ��
//	����MyArrays�࣬�����������·����������������£�
//	1.public static void reverse(ArrayList<Integer> list);
//		����ArrayList<Integer> list:Ҫ���в����ļ��϶���		
//		Ҫ�󣺶�list���϶����е�Ԫ�ؽ��з�ת(��һ�������һ���������ڶ����͵����ڶ����������������͵�������������...)
//	2.public static Integer max(ArrayList<Integer> list);
//		����ArrayList<Integer> list:Ҫ���в����ļ��϶���		
//		Ҫ�����list���϶����е����ֵ������
//	3.public static Integer min(ArrayList<Integer> list);
//		����ArrayList<Integer> list:Ҫ���в����ļ��϶���		
//		Ҫ�����list���϶����е���Сֵ������
//	4.public static int indexOf(ArrayList<Integer> list,Integer i);
//		����ArrayList<Integer> list:Ҫ���в����ļ��϶���
//		����Integer i:��Ҫ�ڼ����в��ҵ�Ԫ��
//		Ҫ�����Ԫ��i��list�����е�һ�γ��ֵ����������û�з���-1
//	5.public static void replaceAll(ArrayList<Integer> list,Integer oldValue,Integer newValue);
//		����ArrayList<Integer> list:Ҫ���в����ļ��϶���
//		����Integer oldValue:��Ҫ���滻����ԭֵ
//		����Integer newValue���滻�����ֵ
//		Ҫ�󣺽�list�����е�����ֵΪoldValue��Ԫ���滻ΪnewValue

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
	
//	1.����ArrayList���ϣ��������ַ���"abc" "def"  "efg" "def" "def" "qwe" "def" "def" "swd" "wwe" "def" "def"
//	2.ʹ����ͨforѭ����ȡ����������Ϊ3��Ԫ�ز���ӡ
//	3.���巽��public static int myContains(ArrayList list,String str)
//	4.�������涨���mycontains����ͳ�Ƽ����а����ַ���"def"������
//	5.ɾ�������е������ַ���"def"(ѭ���жϼ������Ƿ����"def"�ַ���,������ɾ��)
//	6.��������ÿ��Ԫ���е�Сд��ĸ��ɴ�д��ĸ
//	7.����һ���Ļ�����,������ת����String���͵�����,������ӡ����
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
