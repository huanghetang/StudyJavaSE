package thinkinjava;

public class B  extends A {
	int print(){
		System.out.println("B.print()");
		return 2;
	}
	public static void main(String[] args) {
		B b = new B();
		b.print();
	}
}
