package com.itcast.www;
public class HomeworkDemo5 {
	public static void main(String[] args) {
		
		// ���4λ�����ܱ�6�������ܱ�12������������������һ�У���������һ�н��������
		
		// ����һ������, ���ڻ��е��ж�
		int count = 0;
		boolean flag = true;
		
		// 1. ���� 1000 ~ 9999 �е�ÿһ��������ֵ
		for (int i = 1000; i <= 9999; i++) {
			
			// 2. �ж� 	��6�������ܱ�12��������
			if (i % 6 == 0 && i % 12 != 0) {
				
				// ��� 
				System.out.print(i + "\t");
				
				// �жϻ���'
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