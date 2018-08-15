package cn.itcast.test;

/**
 * 装饰模式:定义一个抽象类实现被装饰类的接口,并把这个接口类型当成属性在构造方法里面初始化,重写这个方法,在方法里面调用成员属性的这个方法
 * 		装饰类只需要继承这个类,重写这个方法.这方法里面使用父类的方法,并升级.
 *       
 * @author zhoumo
 *
 */
abstract class PhoneDecorate implements Phone {
	private Phone p;
	
	PhoneDecorate(Phone p){
		this.p = p;
		
	}
	@Override
	public void call() {
		p.call();
	}

}
