package vip.huanghetang.jybhomework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Day05 {
	public static void main(String[] args) {
//		homework1();
//		homeWork2();
		Day05 outer = new Day05();
		DebitCard debitCard = outer.new DebitCard("�������޶�ȿ�001",1000);
		debitCard.setMoney(-1);
	}
	
	
//	��֪����ArrayList����, �������ᡱ,������,����˼�⡱,��¹�ϡ�; 
//	�Ѽ���������д�뵱ǰ��Ŀ�ĸ�Ŀ¼�µ�names.txt��,ÿһ������ռһ��;
//	Ҫ��: ʹ��try...catch...finally���쳣���д���
	static void homework1(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("������");
		list.add("����");
		list.add("��˼��");
		list.add("¹��");
		BufferedWriter bw = null;
		try {
			  bw = new BufferedWriter(new FileWriter("names.txt"));
			  for(int i=0;i<list.size();i++){
				  bw.write(list.get(i));
				  bw.newLine();
			  }
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(bw!=null){
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

//	��ʹ�ô�������
//    ��names.txt�е�����,��ȡ��������,�洢��ArrayList������;ÿһ������ΪArrayList������һ��Ԫ��;
//Ҫ��:ʹ��try...catch...finally���쳣���д���  

	static void homeWork2(){
		BufferedReader br = null;
		ArrayList<String> list = new ArrayList<String>();
		try{
			br = new BufferedReader(new FileReader("names.txt"));
			String str = null;
			while((str=br.readLine())!=null){
				list.add(str);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(list.toString());
		
	}
	
	
	//��ʹ�ô�������: 
//	ÿһ�Ž�ǿ�(DebitCard)�����˺�(accountNumber):�����(money); �����Զ����Ϊ����
//	Ҫ��:����ǿ������Ϊ������ʱ����Ҫ�׳��Զ����쳣

	private class DebitCard{
		private String accountNumber;
		private int money;
		public String getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}
		public int getMoney() {
			return money;
		}
		public void setMoney(int money) {
			if(money<0){
				throw new LessMoney("Ǯ������");
			}
			this.money = money;
		}
		public DebitCard(String accountNumber, int money) {
			super();
			this.accountNumber = accountNumber;
			this.money = money;
		}
		@Override
		public String toString() {
			return "DebitCard [accountNumber=" + accountNumber + ", money=" + money + "]";
		}
		
		
	}
	
	private class LessMoney extends RuntimeException{
		public LessMoney(String message){
			super(message);
		}
	}
	
	

}
class A{
	void method(){
		
	}
}
class B extends A{
	@Override
	void method()  {
		
	}
}