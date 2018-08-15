package vip.huanghetang.oop;

/**
 * 接口成员的特点:
 *  成员变量:默认 修饰是 public static final(建议手动写出来)
 *  构造方法:接口没有构造方法(接口主要用来扩展功能的,而没有具体存在)
 *  成员方法:默认修饰符是 public abstract(建议手动写出来)
 * @author zhoumo
 *
 */
public interface Inter {
	int num1 = 1;
	public static final int num2 = 2;
	
//	public Inter(){} 没有构造方法
	void show();
	public abstract int show2();
}
