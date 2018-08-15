package vip.huanghetang.oop;

/**
 * abstract 用来修饰类或方法,拥有抽象方法的类一定是抽象类,
 * 抽象类可以没有抽象方法(不写方法),可以有抽象方法(强制要求子类要做的事情),可以有非抽象方法(有构造方法但是不能实例化,用于子类继承提高代码复用性),可以有静态方法(类名调用)
 * 抽象类用于被子类继承,注意事项 abstract不能和private(私有后不能重写) final(不能被修改) static(不能被重写)一起修饰
 * 抽象类的子类必须重写所有的抽象方法,或者子类为抽象类
 * 抽象类的实例化是具体的子类实现的,是多态的表现
 * @author zhoumo
 *
 */
 abstract class Fu {
	 protected int a = 1;
	 String b = "123";
	 Fu(){
		System.out.println("Fu constract");
	}
	abstract void method();
	
	static void eat(){
		System.out.println("fu static method eat()");
	}
	

	
}
