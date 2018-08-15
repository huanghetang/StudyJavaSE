package vip.huanghetang.oop;

/**
 * Object类介绍
 * 常用方法 1.hashCode() 系统根据对象内存地址转化得到的一个整数
 * 		2.getClass() 得到字节码文件对应的对象
 * 		3.class.getName() 得到类名
 * 		4 toString()  = this.getClass().getName()+'@'+this.hashCode()
 * 		5 equals() Object的equals是  renturn this==object
 * 			String.equals() 比较的是 char[]数组长度和每一个元素必须相同才return true;
 * 			一般成员属性相同的两个对象 
 * 
 * @author zhoumo
 *
 */
public class Day11 {
	private String name;
	private String age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Day11 [name=" + name + ", age=" + age + "]";
	}
	
	/**
	 * 如果此对象与 obj 参数相同，则返回 true；否则返回 false。
	 */
	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}
		if(obj instanceof Day11){
			Day11 otherObj = (Day11)obj;
			return this.name.equals(otherObj.name) && this.age.equals(otherObj.age);
		}
		return false;
		
	}

	public Day11(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}
	public static void main(String[] args) {
//		Day11 d1 = new Day11("柳岩","18");
//		Day11 d2 = new Day11("柳岩","18");
//		System.out.println(d1.equals(d2));
//		Day11.Inner i = new Day11("12", "1").new Inner();
//		System.out.println(i.a);
		String a = "hello";
		String b = "world";
		String c = "helloworld";
		System.out.println(c==a+b);//false--两个变量相加 首先会创建空间
		System.out.println(c=="hello"+"world");//true,两个常量相加首先把常量值加起来然后区字符串常量池当中找,如果找不到才创建
		a +="ooo";
		System.out.println(a);//字符串值不会改变,此处引用地址发生改变
		
	}

	class Inner extends Test{
		
	}
}
