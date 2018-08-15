package javaABC;

public class TestThread {
	public static void main(String[] args) {
		MyRunnable runnable = new MyRunnable();
		Thread t = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		Thread t3 = new Thread(runnable);
		t.start();
		t2.start();
		t3.start();
	}
	
	

}

class MyRunnable implements Runnable{
	int count=10;
	@Override
	public void run() {
		while(true){
			if(count>0){
				System.out.println(count);
				count--;
			}
		}
		
		
	}
	
	
	
}
