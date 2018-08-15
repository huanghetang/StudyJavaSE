package vip.huanghetang.oop;

//import com.itheima01.helloworld.HelloWorld;

/**
 * 类与类的关系:单继承,但可以多层继承
 * 类与接口的关系:可已实现一个或多个接口,同时必须重写接口中定义的方法
 * 接口与接口的关系:接口可以单继承也可以多继承
 * @author zhoumo
 *
 */
final class Zi extends Fu {

	protected void method() {
		System.out.println("zi method");

	}

	private Zi() {
		System.out.println("zi constract");
	}

	public static void main(String[] args) {
//		Fu f = new Zi();
//		f.method();
//		System.out.println(f.a);
//		HelloWorld.main(args);
		
	}
}
