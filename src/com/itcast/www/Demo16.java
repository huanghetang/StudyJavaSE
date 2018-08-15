package com.itcast.www;

public class Demo16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=0;
		for(int i=1000;i<=9999;i++){
			if((i%6==0)&&(i%12!=0)){
				count=count+1;
				System.out.print(i+" ");
				if((count%5==2)||(count%5==0)){
					System.out.println("");
				}
			}
		}
	}

}
