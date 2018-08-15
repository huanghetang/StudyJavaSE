package cn.itcast.test;

public class Jjj {
	public static void main(String[] args) {
		final Data data = new Data();
		for(int i=0;i<2;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					data.increment();
				}
			}).start();
			new Thread(new Runnable() {
				@Override
				public void run() {
					data.decrease();
				}
			}).start();
		}
		
	}
	

}
class Data{
	private static int x = 100;
	
	public synchronized void increment(){
		for(int i=0;i<100;i++){
			x++;
			System.out.println(x);	
		}
		
	
	}
	public synchronized void decrease(){
		for(int i=0;i<100;i++){
			x--;
			System.out.println(x);	
		}
	}
	
}
