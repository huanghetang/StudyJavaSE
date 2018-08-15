package com.itcast.www;

/**
 * 
 * @author zhoumo
 * 
 */
public class TypeChangeDemo {
	public static void main(String [] args){
		char cc ='A';
		for(int i=0;i<=26;i++){
			System.out.print((char)(cc+i)+" ");
		}
		char c = 'A';
		int d = c;
		System.out.println(d);
	}
}
