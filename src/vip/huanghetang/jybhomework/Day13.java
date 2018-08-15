package vip.huanghetang.jybhomework;

import java.util.HashMap;

/**
 * ��д���߳�ͬ������ģ��3�����Ŷ� ��Ʊ����ĳ����ĳ����ĳ���ӰƱ����ƱԱֻ��3����Ԫ��Ǯ����ӰƱ5Ԫһ�š�a��20Ԫһ�ŵ�RMB����b��ǰ�棬
 * b����c��ǰ����һ��10Ԫ��RMB��Ʊ��c��һ��5Ԫ��RMB��Ʊ��
 *  �� =a ��=b ��=c
 * @author zhoumo
 *
 */

public class Day13 {
	public static void main(String[] args) {
		final Business business = new Business();
		
		 new Thread(new Runnable(){
			@Override
			public void run() {
				business.a();
			}
		}).start();
		 new Thread(new Runnable(){
			@Override
			public void run() {
				business.b();
			}
		}).start();
		
		 new Thread(new Runnable(){
			@Override
			public void run() {
				business.c();
			}
		}).start();
	}

	
	


}

class Business{
//	private HashMap<Integer,Integer> hashMap;//��ƱԪ��ÿ�����ֽ�Һ�����
	int flag;//Ĭ��0��a��Ʊ  1=b,2=c
	synchronized void a(){
		if(flag!=0){
			try {
				this.wait();//����0����a�ȴ�
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int money = 20;
		while(money>=5){
			money = money -5;
			System.out.println("a����һ�ŵ�ӰƱ");
		}
		flag = 1;//��ִ��Ȩ��b
		this.notifyAll();
	}
	
	synchronized void b(){
		if(flag!=1){
			try {
				this.wait();//����1����b�ȴ�
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int money = 10;
		while(money>=5){
			money = money-5;
			System.out.println("b����һ�ŵ�ӰƱ");
		}
		flag = 2;//��ִ��Ȩ��c
		this.notifyAll();
		
	}
	synchronized void c(){
		if(flag!=2){
			try {
				this.wait();//����2����c�ȴ�
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int money = 5;
		while(money>=5){
			money = money-5;
			System.out.println("c����һ�ŵ�ӰƱ");
			}
			this.notifyAll();
		}
	
}

//class Man{
//	private Integer money;
//	public Man(Integer money){
//		this.money= money;
//	}
//	public Integer getMoney() {
//		return money;
//	}
//	public void setMoney(Integer money) {
//		this.money = money;
//	}
//	
//}