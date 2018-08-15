package javaABC;

import java.util.HashSet;
import java.util.Vector;

public class Day08 {
	
	public static void main(String[] args) {
		String a = "通话";
		String b = "重地";
		HashSet hs = new HashSet();
		hs.add(a);
		hs.add(b);
		System.out.println(hs);
		
		Object obj = new Object();
		System.out.println(obj.hashCode());
		
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
//		System.out.println("通话".equals("重地"));
		System.out.println(a.equals(b));
		hs.remove(a);
		System.out.println(hs);
	}

	
	class Student{
		
		
	}
}
