package vip.huanghetang.jybhomework;

public class Day4 {
	static {
		System.out.println("Test ��̬�����");
	}
	public Day4(){
		System.out.println("Test ���췽��");
	}

	public static final String name="123";
	
	public static void main(String[] args) {
//		Student s1 = new Student("����",22);
//		Student s2 = new Student("��˼��",18);
//		System.out.println(s1.school);
//		s1.school = " ���ǲ���";
//		System.out.println(s2.school);
//		System.out.println("Test main����");
//		Day4 t = new Day4();
//		Club.sports("����",new Swimmer(){
//			@Override
//			public void swimming(){
//				System.out.println("����Ӿ");
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
//	ѧУ
	public static String school  = "�廪��ѧ";
//	����
	private String name;
//	����
	private int age;

//	���췽��
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
 * ��ʹ�ô�������
ĳ��˾����һ����Ӿ���ֲ�,ֻҪ�ǻ���Ӿ�Ķ����Լ���;
    Ҫ��: ʹ�õ��ӿ�,�ӿ���Ϊ����,�����ڲ���.
    ��ʾ: ����Ӿ���ܳ�ȡ���ӿ��� ,�ڲ��������ṩ�μ��˶���ľ�̬����

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


