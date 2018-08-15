package thinkinjava;

import java.util.Arrays;
import java.util.Random;

public class Initialization {
	public static void main(String[] args) {
//		int [] arr = new int[]{1,2,3,};
//		String[] arr2 = new String[new Random(20).nextInt(19)];
//		System.out.println(arr2[3]);
		for(String s : args){
			System.out.println("arg:"+s);
		}
	}

}
