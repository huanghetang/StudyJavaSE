package com.itcast.www;

import java.util.Arrays;

/**
 * int[] instanceof Object
 * Integer[] instanceof Object[]
 */
import thinkinjava.Initialization;

public class MainTest {
	private int marker;
	MainTest(int marker){
		this.marker = marker;
		System.out.println(marker);
	}
	@Override
	public String toString() {
		return  "MainTest("+marker+")";
	};
	public static void main(String... args) {
//		MainTest[] mainTestArr = new MainTest[10];
//		for(MainTest thisTest:mainTestArr){
//			System.out.println(thisTest.toString());
//		}
//		for(int i=0,j=1;i<10;i++,j++){
//			mainTestArr[i] = new MainTest(i*j);
//		}
//		System.out.println(Arrays.toString(mainTestArr));
//		printArray();
//		printArray((new int[]{1,2,3}));
//		printArray((Object[])(new Integer[]{1,2,3}));
//		int[] inta = new int[]{1};
//		Integer[] integera = new Integer[]{1};
//		System.out.println(inta instanceof Object);
//		System.out.println(integera instanceof Object[]);
//		g(1l);
//		ff();
		fg("ddd",new Integer[]{1,2,3});
		fg("sdfs",1);
	}
	//可变参数列表 JavaSE5
	public static void printArray(Object ...objects ){
		for(Object obj:objects){
			System.out.println(obj);
		}
		
	}
	public static void fg(String s,Integer ...integers ){
		System.out.println("fg(0)");
		System.out.println(integers.getClass());
	}
	public static void fg(Integer ...integers ){
		System.out.println("fg(1)");
		System.out.println(integers.getClass());
	}
	public static void g(Long...longs){
		System.out.println("second");
		for(Long lon:longs){
			System.out.println(lon);
		}
	}
	public static void ff(){
		int sum =0;
		double start = 0.0002;
		double end = 7000;
		while(true){
			if(start<end){
				start=start*2;
			}else{
				break;
			}
			sum++;
		}
		System.out.println(sum);
	}

}
