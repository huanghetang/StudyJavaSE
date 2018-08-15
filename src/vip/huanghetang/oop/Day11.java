package vip.huanghetang.oop;

/**
 * Object�����
 * ���÷��� 1.hashCode() ϵͳ���ݶ����ڴ��ַת���õ���һ������
 * 		2.getClass() �õ��ֽ����ļ���Ӧ�Ķ���
 * 		3.class.getName() �õ�����
 * 		4 toString()  = this.getClass().getName()+'@'+this.hashCode()
 * 		5 equals() Object��equals��  renturn this==object
 * 			String.equals() �Ƚϵ��� char[]���鳤�Ⱥ�ÿһ��Ԫ�ر�����ͬ��return true;
 * 			һ���Ա������ͬ���������� 
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
	 * ����˶����� obj ������ͬ���򷵻� true�����򷵻� false��
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
//		Day11 d1 = new Day11("����","18");
//		Day11 d2 = new Day11("����","18");
//		System.out.println(d1.equals(d2));
//		Day11.Inner i = new Day11("12", "1").new Inner();
//		System.out.println(i.a);
		String a = "hello";
		String b = "world";
		String c = "helloworld";
		System.out.println(c==a+b);//false--����������� ���Ȼᴴ���ռ�
		System.out.println(c=="hello"+"world");//true,��������������Ȱѳ���ֵ������Ȼ�����ַ��������ص�����,����Ҳ����Ŵ���
		a +="ooo";
		System.out.println(a);//�ַ���ֵ����ı�,�˴����õ�ַ�����ı�
		
	}

	class Inner extends Test{
		
	}
}
