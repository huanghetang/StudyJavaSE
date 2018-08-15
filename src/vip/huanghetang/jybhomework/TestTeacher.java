package vip.huanghetang.jybhomework;

public class TestTeacher {
	
	public static void main(String[] args) {
		Zi zi = new Zi();
		zi.show2();
	}

}
class Fu{
	int a = 10;
	void show(){
		System.out.println("a:"+a);
	}
	
}
class Zi extends Fu{
	int a = 20;

	void show2(){
		int a = 30;
		System.out.println("a:"+a);
		System.out.println("this.a:"+this.a);
		System.out.println("super.a:"+super.a);
		show();//此时堆内存在2个a 一个a在子类对象中属于super区域,一个在zi类区域
	}
}
