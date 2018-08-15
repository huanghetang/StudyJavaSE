package mianshi;

import java.util.ArrayList;
import java.util.Arrays;

public class Mianshi1 {
	public static void main(String[] args) {
		short i=1;
		i=(short) (i+1);
		i+=1;//ø…“‘±‡“Î
//		String s;
//		StringBuilder stringBuilder ;
//		Object c;
		String s = "abc";
		String sss = s.intern();
//		String ss = s.concat("def");
//		System.out.println(s.valueOf(false));
		ArrayList<String> list = new ArrayList<String>();
//		list.add('a');
//		list.add(true);
//		list.add(123);
//		list.add(1.2f);
		System.out.println(Arrays.toString(list.toArray()));
	}

}
