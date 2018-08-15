package com.itcast.www;
public class HomeworkDemo5 {
	public static void main(String[] args) {
		
		// 输出4位数中能被6整除不能被12整除的数，两个数字一行，三个数字一行交替输出。
		
		// 定义一个变量, 用于换行的判断
		int count = 0;
		boolean flag = true;
		
		// 1. 遍历 1000 ~ 9999 中的每一个整型数值
		for (int i = 1000; i <= 9999; i++) {
			
			// 2. 判断 	被6整除不能被12整除的数
			if (i % 6 == 0 && i % 12 != 0) {
				
				// 输出 
				System.out.print(i + "\t");
				
				// 判断换行'
				count++;
				if (count % 2 == 0 && flag == true) {
					System.out.println();
					
					count = 0;
					flag = false;
				}
				
				if (count != 0 && count % 3 == 0 && flag == false) {
					System.out.println();
					
					count = 0;
					flag = true;
				}
			}
		}
		
	}
}