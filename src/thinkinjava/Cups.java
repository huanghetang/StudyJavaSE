package thinkinjava;
import static thinkinjava.Util.*;

public class Cups {
	static String variable1 = "222";
	
	static {
		printn("123");
		Character c = '0';
		printn(c.toString());
	}
	static Cup cup1;
	static Cup cup2;
	static{
		cup1=new Cup(1);
		cup2=new Cup(2);
	}
	Cups(){
		printn("Cups()");
	}
	public static void main(String[] args){
		printn("Inside main()");
//		Cups.cup1.f(99);
		System.out.println(cups1.variable1);
	}
	static Cups cups1 = new Cups();
//	static Cups cups2 = new Cups();

}
