package vip.huanghetang.jybhomework;

import java.util.HashMap;

/**
 * 编写多线程同步程序，模拟3个人排队 买票，张某、李某和赵某买电影票，售票员只有3张五元的钱，电影票5元一张。a拿20元一张的RMB排在b的前面，
 * b排在c的前面拿一张10元的RMB买票，c拿一张5元的RMB买票。
 *  张 =a 李=b 赵=c
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
//	private HashMap<Integer,Integer> hashMap;//售票元的每种面额纸币和数量
	int flag;//默认0让a买票  1=b,2=c
	synchronized void a(){
		if(flag!=0){
			try {
				this.wait();//不是0就让a等待
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int money = 20;
		while(money>=5){
			money = money -5;
			System.out.println("a买了一张电影票");
		}
		flag = 1;//把执行权给b
		this.notifyAll();
	}
	
	synchronized void b(){
		if(flag!=1){
			try {
				this.wait();//不是1就让b等待
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int money = 10;
		while(money>=5){
			money = money-5;
			System.out.println("b买了一张电影票");
		}
		flag = 2;//把执行权给c
		this.notifyAll();
		
	}
	synchronized void c(){
		if(flag!=2){
			try {
				this.wait();//不是2就让c等待
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int money = 5;
		while(money>=5){
			money = money-5;
			System.out.println("c买了一张电影票");
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