package thinkinjava;

public class C extends B{
	public C(){
		System.out.println("C()");
	}
	C(int i){
		System.out.println("C("+i+")");
	}
	public static void main(String[] args) {
		new C(3);
	}
}
