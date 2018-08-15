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
		DebitCard debitCard = outer.new DebitCard("黑马无限额度卡001",1000);
		debitCard.setMoney(-1);
	}
	
	
//	已知集合ArrayList中有, ”张三丰”,”景甜”,”林思意”,”鹿晗”; 
//	把集合中人名写入当前项目的根目录下的names.txt中,每一个人名占一行;
//	要求: 使用try...catch...finally对异常进行处理
	static void homework1(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("张三丰");
		list.add("景甜");
		list.add("林思意");
		list.add("鹿晗");
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

//	请使用代码描述
//    把names.txt中的人名,读取到程序中,存储到ArrayList集合中;每一个人名为ArrayList集合中一个元素;
//要求:使用try...catch...finally对异常进行处理  

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
	
	
	//请使用代码描述: 
//	每一张借记卡(DebitCard)都有账号(accountNumber):和余额(money); 余额永远不能为负数
//	要求:当借记卡的余额为负数的时候需要抛出自定的异常

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
				throw new LessMoney("钱用完了");
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