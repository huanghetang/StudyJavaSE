package vip.huanghetang.jybhomework;

public class Day4 {
	static {
		System.out.println("Test 静态代码块");
	}
	public Day4(){
		System.out.println("Test 构造方法");
	}

	public static final String name="123";
	
	public static void main(String[] args) {
//		Student s1 = new Student("景甜",22);
//		Student s2 = new Student("林思意",18);
//		System.out.println(s1.school);
//		s1.school = " 传智播客";
//		System.out.println(s2.school);
//		System.out.println("Test main方法");
//		Day4 t = new Day4();
//		Club.sports("景甜",new Swimmer(){
//			@Override
//			public void swimming(){
//				System.out.println("在游泳");
//			}
//		});
		final String age = "22";
		class A{
			void method(){
				System.out.println(name+","+ age);
				
			}
		}
		new A().method();

	}
}

class Student {
//	学校
	public static String school  = "清华大学";
//	姓名
	private String name;
//	年龄
	private int age;

//	构造方法
	public Student() {
		super();
	}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
}
/**
 * 请使用代码描述
某公司成立一个游泳俱乐部,只要是会游泳的都可以加入;
    要求: 使用到接口,接口作为参数,匿名内部类.
    提示: 把游泳功能抽取到接口中 ,在测试类中提供参加运动会的静态方法

 */
class Club{
	
	public static void sports(String name,Swimmer swim){
		System.out.print(name);
		swim.swimming();
	}
}
interface Swimmer{
	public abstract void swimming();
}


