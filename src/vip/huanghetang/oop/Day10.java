package vip.huanghetang.oop;

/**
 * Ȩ�����η� private Ĭ�� protected public
 * ״̬���η� static final
 * �������η� abstract
 * @author zhoumo
 *
 */
public class Day10 {
//������:public final abstract
//���ι��췽�� :Ȩ�����η� private Ĭ�� protected public
//���γ�Ա:Ȩ�����η���״̬���η�
//���η���:Ȩ�����η�,״̬���η��ͳ������η�
	
	
//package ��ÿ�������Ч�����һ��,ֻ����һ�� javac -d . Hello.java ���Զ�����cn.itcast(��)
//Ȼ�� java cn.itcast.Hello(���ȫ·���Ӱ���)>>������ʹ�ñ�İ�������� ��Ҫ����ȫ��,Ϊ�˼�>>
//import �ؼ���

//�ڲ����Ϊ��Ա�ڲ���;ֲ��ڲ���
//�ڲ���ɱ�Ȩ�����η���״̬���η�����,����private����,�����ṩpublic����
  private int num1 = 10;
  private static int num2 = 20;
  private  class Inner{//Ϊ�����ݰ�ȫ
	  public void method(){
		  System.out.println(num1);
	  }
	  public  void method2(){
		  System.out.println(num2);
	  }
  }
  public static class Inner2{//Ϊ�˷������ݷ���
	  public static void method(){
		  System.out.println("Inner2 num2"+num2);
	  }
  }
  
  public void method(){//�ֲ��ڲ���,�ֲ��ڲ�����ʾֲ�����ʱ,�ֲ�����ǰ����Ҫ����fianl���η�.��Ϊ �ֲ����������ŷ����ĵ��ö�����,���ŷ����ĵ�����϶���ʧ.
	  					//���Ǿֲ��ڲ���������ڶ��е�,����������ʧ,���Զ��ڴ滹��Ҫʹ�øñ�����,���Ǹñ����Ѿ�û����,����Ҫ��final���ξֲ�����,�����ֲ������ͻᱻ����������
	  final int a = 10;
	   class Inner3{//�ֲ��ڲ���ֻ�ܱ�abstract��final����
		  public void method4(){
			  System.out.println(a);
		  }
	  }
	  Inner3 i3 = new Inner3();
	  i3.method4();
  }
  
  public void method2(){
	  final int a = 0;
	  new Person(){//�����ڲ����ʵ��:�̳��˸����ʵ���˸ýӿڵ��������������
		  public void study(){
			  System.out.println("study");
			  System.out.println(a);
		  }
	  }.study();//�����ڲ���,��Ϊջ��û��ָ��������ڲ��������,���Ի����ŷ����ĵ��ý��������������
	  
  }
  public static void main(String[] args) {
	Day10.Inner di = new Day10().new Inner();
	di.method();di.method2();
	Day10.Inner2 di2 = new Day10.Inner2();
	di2.method();
	Day10.Inner2.method();
	System.out.println("---------------");
	Day10 d10 = new Day10();
	d10.method();
	System.out.println("---------------");
	d10.method2();
	
}
  interface Person{
		public abstract void study();
	}
}


