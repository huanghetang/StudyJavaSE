package vip.huanghetang.oop;

/**
 * 权限修饰符 private 默认 protected public
 * 状态修饰符 static final
 * 抽象修饰符 abstract
 * @author zhoumo
 *
 */
public class Day10 {
//修饰类:public final abstract
//修饰构造方法 :权限修饰符 private 默认 protected public
//修饰成员:权限修饰符和状态修饰符
//修饰方法:权限修饰符,状态修饰符和抽象修饰符
	
	
//package 在每个类的有效代码第一行,只能有一个 javac -d . Hello.java 会自动创建cn.itcast(包)
//然后 java cn.itcast.Hello(类的全路径加包名)>>所以在使用别的包下面的类 需要带上全名,为了简化>>
//import 关键字

//内部类分为成员内部类和局部内部类
//内部类可被权限修饰符和状态修饰符修饰,常用private修饰,对外提供public方法
  private int num1 = 10;
  private static int num2 = 20;
  private  class Inner{//为了数据安全
	  public void method(){
		  System.out.println(num1);
	  }
	  public  void method2(){
		  System.out.println(num2);
	  }
  }
  public static class Inner2{//为了访问数据方便
	  public static void method(){
		  System.out.println("Inner2 num2"+num2);
	  }
  }
  
  public void method(){//局部内部类,局部内部类访问局部变量时,局部变量前面需要加上fianl修饰符.因为 局部变量会随着方法的调用而创建,随着方法的调用完毕而消失.
	  					//但是局部内部类对象是在堆中的,不会立即消失,所以堆内存还是要使用该变量的,但是该变量已经没有了,所以要加final修饰局部变量,这样局部变量就会被当作常量了
	  final int a = 10;
	   class Inner3{//局部内部类只能被abstract和final修饰
		  public void method4(){
			  System.out.println(a);
		  }
	  }
	  Inner3 i3 = new Inner3();
	  i3.method4();
  }
  
  public void method2(){
	  final int a = 0;
	  new Person(){//匿名内部类的实质:继承了该类或实现了该接口的子类的匿名对象
		  public void study(){
			  System.out.println("study");
			  System.out.println(a);
		  }
	  }.study();//匿名内部类,因为栈中没有指向该匿名内部类的引用,所以会随着方法的调用结束立即变成垃圾
	  
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


