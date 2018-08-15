package javaABC;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 学习多线程
 * @author zhoumo
 *
 */
public class Day12 {
	static int count=0;

	public static void main(String[] args) throws FileNotFoundException, InterruptedException, ExecutionException, ParseException {
//		TestDeleteTimerTask();
//		new Thread(
//				//what will be run
//				new Runnable(){
//					@Override
//					public void run() {
//						while(true){
//							try {
//								Thread.sleep(1000);
//							} catch (InterruptedException e) {
//								e.printStackTrace();
//							}
//							System.out.println("runnable:"+Thread.currentThread().getName());
//						}
//					}		
//				}){
//			@Override
//			public void run() {
//				super.run();
//				while(true){
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					System.out.println("thread:"+Thread.currentThread().getName());
//				}
//			}
//		}.start();
		
		testThreadPool();
		
		
	}

	/**
	 * 定时器的使用 定时删除一个文件夹
	 * @throws ParseException
	 */
	private static void TestDeleteTimerTask() throws ParseException {
		Timer timer = new Timer("我的定时器");
		String date = "2018-4-10 08:22:10";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = sdf.parse(date);
		timer.schedule(new DeleteDirectoryTimerTask("delete", timer),d);
	}

/**
 * 线程池的使用
 * @throws InterruptedException
 * @throws ExecutionException
 */
	private static void testThreadPool() throws InterruptedException, ExecutionException {
		//线程池,JVM频繁的新建线程浪费资源,线程池可已提高效率,池子中的线程使用完毕后不会变成垃圾,而是等待下一次使用
		ExecutorService pool = Executors.newFixedThreadPool(2);//新建一个只有2个线程的线程池
		Future<Integer> f1 = pool.submit(new MyCallable(100,pool));
		Future<Integer> f2= pool.submit(new MyCallable(101,pool));
		System.out.println(f1.get());
		System.out.println(f2.get());
	}


	private static void testThreadGroup() {
		ThreadGroup threadGroup = new ThreadGroup("我的线程工作组");
		Runnable r = new Runnable(){
			@Override
			public void run() {
				for(int i=0;i<200;i++){
					System.out.println(Thread.currentThread().getName()+":"+i);
				}
				
			}
			
		};
		Thread t1 = new Thread(threadGroup, r, "线程1");
		Thread t2 = new Thread(threadGroup, r, "线程2");
		System.out.println(threadGroup.isDaemon());
		
		threadGroup.setDaemon(true);
		System.out.println(threadGroup.isDaemon());
		t1.start();
		t2.start();
		for(int i=0;i<3;i++){
			System.out.println(i);
		}
//		ThreadCommonsMethod();
	}


	/**
	 * 将生产者和消费者业务逻辑抽取到一个类当中,让业务逻辑和线程相关的代码分离,降低了耦合性,更加的体现了面向对象的编程
	 */
	private static void productAndCustom2() {
		final StudentBusiness sb = new StudentBusiness();
		//让一个线程生产包子
		new Thread(new Runnable(){
			@Override
			public void run() {
				sb.setStudent();
			}
		}).start();
		
		System.out.println("===============================over=================");
		//让一个线程制造包子
		sb.getStudent();
	}


	/**
	 * 普通生成者和消费者通信模式
	 */
	private static void ProductAndCustom() {
		Student s = new Student();
		SetStudent setStudent = new SetStudent(s);
		GetStudent getStudent = new GetStudent(s);
		setStudent.start();
		getStudent.start();
	}


	/**
	 * 测试死锁
	 */
	private static void DieLockTest() {
		DieLockThread d1 = new DieLockThread(true);
		DieLockThread d2 = new DieLockThread(false);
		d1.start();
		d2.start();
	}
	
	
	/**
	 * 生产者 消费者模式 --线程通信 等待--唤醒机制
	 */
	
	
	
	
	/**
	 * 线程常用方法
	 */
	private static void ThreadCommonsMethod() {
		//		InterviewQuestion();
				//cpu线程调度模式 1分时调度 2抢占式调度.java使用抢占式调用
				MyThread myThread1 = new MyThread("张飞");
				MyThread myThread2 = new MyThread("关羽");
//				MyThread myThread3 = new MyThread("刘备");
//				Thread.currentThread().setName("被守护线程");
				
		//		myThread1.setPriority(10);//设置线程优先级 10最大,1最小.多次执行综合来说优先级大的线程会先执行
		//		myThread2.setPriority(1);//
				myThread1.setDaemon(true);//设置成守护线程,当正在运行的线程都是守护线程的时候,虚拟机退出(被守护的线程死亡后就终止,但是终止也需要时间)
				myThread1.start();
		//		try {
		//			myThread1.join();//其他线程会等待该线程终止才会执行
		//		} catch (InterruptedException e) {
		//			e.printStackTrace();
		//		}
				
				myThread2.setDaemon(true);
				myThread2.start();
//				myThread3.start();
				for(int i=0;i<4;i++){
					System.out.println(Thread.currentThread().getName()+":"+i);
				}
//				try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				myThread1.interrupt();//打断的原理时抛出一个InterruptedException异常 让休眠的异常捕获
		//		myThread1.stop();//强行终止,线程后面的代码不执行
				System.out.println("over");
	}

	/**
	 * 子线程运行10次然后主线程执行100次然后子线程运行10次然后主线程执行100次,如此循环50次
	 */
	private static void InterviewQuestion() {
		final Business business = new Day12().new Business();
		new Thread(new Runnable(){
			@Override
			public void run() {
				for(int i=1;i<51;i++){//子线程代码
						business.sub(i);
					}
				}
			
		}).start();
		
	
		for(int i=1;i<51;i++){
			business.main(i);
		}
	}
	
	/**
	 * 子线程运行10次然后主线程执行100次然后子线程运行10次然后主线程执行100次,如此循环50次
	 * 
	 * 把要在线程中运行的业务逻辑代码抽取出来,在该类中实现业务中要求的互斥和通信,然后在线程中之间调用该对象的方法完成
	 */	
	
class Business{
	boolean operator = true;//子线程是否运行标识 子线程第一次执行  
	public synchronized void main(int i){
		////可能会出现伪唤醒,用while 当被唤醒后再次判断执行权安全
		while(operator){//当抢占子线程运行时,让其阻塞
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			for(int j =1;j<101;j++){
				System.out.println("main:"+Thread.currentThread().getName()+" "+j+" for the loop of"+i);
			}
			operator = true;//把执行权交给子线程
			this.notify();//唤醒子线程
	}
	
	/**
	 * 子线程第一次执行
	 * @param i
	 */
	public synchronized void sub(int i){
		while(!operator){//当抢占主线程执行时,让其阻塞
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int j =1;j<11;j++){
			System.out.println("sub:"+Thread.currentThread().getName()+" "+j+" for the loop of"+i);
		}
		operator = false;//把执行权交给主线程
		this.notify();//唤醒主线程
	}
		
		
	}
	
	/**
	 * 两个线程之间不同步会出现的流程错误
	 */
	void testSynchronized(){
	  final Outer outer = new Outer();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outer.print("wangjiang");
				}
				
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outer.print("zhoumo");
				}
				
			}
		}).start();
	}
	class Outer{
		void print(String str){
			for(int i=0;i<str.length();i++){
				System.out.print(str.charAt(i));
			}
			System.out.println();
		}
	}
	
		/**
		 * java.util.Timer定时器
		 * 子母弹 2秒炸..4秒炸..2秒炸
		 * @author zhoumo
		 */
	   static void testTimer(){
		class MyTimerTask extends TimerTask{
			@Override
			public void run() {
				count = (count+1)%2;
				System.out.println("bombling");
				new Timer().schedule(new MyTimerTask(), 2000+2000*count);
			}
		}
		new Timer().schedule(new MyTimerTask(), 2000);
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(new Date().getSeconds());
		}
	}
	
	/**
	 * traditionalTread 传统线程 
	 */
	private static void testTherad() {
		new Thread(
				new Runnable(){
					@Override
					public void run() {
						while(true){
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							System.out.println("runnable:"+Thread.currentThread().getName());
						}
					}		
				}){
			@Override
			public void run() {
				super.run();
				while(true){
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("thread:"+Thread.currentThread().getName());
				}
			}
		}.start();
		
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("bombing...");
				
			}
		},4000,2000);
	}
	

	
	
	
	
	

}

/**
 * 锁对象
 * @author zhoumo
 *
 */
class MyLock{
	public static final Object lockA = new Object();
	public static final Object lockB = new Object();
	
}

/**
 * 死锁问题代码
 * @author zhoumo
 *
 */
class DieLockThread extends Thread{
	private boolean  operator ;
	public DieLockThread(boolean operator){
		this.operator = operator;
	}
	
	@Override
	public void run() {
		if(operator){
			synchronized(MyLock.lockA){
				System.out.println("if lockA");
				synchronized(MyLock.lockB){
					System.out.println("if lockB");
				}
			}
		}else{
			synchronized(MyLock.lockB){
				System.out.println("else lockB");
				synchronized(MyLock.lockA){
					System.out.println("else lockA");
				}
			}
		}
	}
}

class MyThread extends Thread{
	public MyThread(){
		
	}
	public MyThread(String name){
		super(name);
	}
	
	@Override
	public void run() {
//		try {
//			Thread.sleep(10000);//让当前正在执行的线程休眠
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//			System.out.println("休眠被打断了");
//		}
//		System.out.println("run()最后执行的代码");
		for(int i =0;i<300;i++){
			System.out.println(getName()+":"+i);
//			Thread.yield(); 线程礼让,当一个线程运行后 让给另一个线程执行.不是绝对的,只是在一定程度上让两个线程运行的更加和谐
		}
	}
}
class Student{
	String name;
	Integer age;
	boolean flag;//默认false让 生产者先生产
	
}

class SetStudent extends Thread{
	int count=0;
	private Student s;
	 SetStudent(Student s){
		this.s =s;
	}
	@Override
	public void run() {
		while(true){
		synchronized(s) {
			if(s.flag){
				try {
					s.wait();
				} catch (InterruptedException e) {
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(count%2==0){
				s.name="景甜";
				s.age = 18;
			}else{
				s.name="迪丽热巴";
				s.age = 20;
			}
			System.out.println("生产了:"+s.name);
			count++;
			s.flag = true;//把执行权交给消费者
			s.notify();//唤醒消费者
		}
		}
		
	}
	
}
class GetStudent extends Thread{
	
	private Student s;
	GetStudent(Student s){
		this.s = s;
	}
	@Override
	public void run() {
	while(true){
	synchronized(s){
		if(!s.flag){
			try {
				s.wait();//第一次让生产者生产,如果抢到执行权,就等待,然后释放锁,等到被唤醒时,直接从这里开始执行
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
			}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("消费者消费了:"+s.name+"---"+s.age);
		 s.flag = false;//把执行权交给生产者
		 s.notify();//唤醒生产者
		}
	}
		
	}
}

/**
 * 把生产者和消费者问题抽取到一个类中,让业务和线程有关的代码分离
 */
class StudentBusiness{
	int count;

	private Student s = new Student();
	boolean makeStudent;//制造包子表示,默认false表示制造包子
	
	/**
	 * 生产者 ,制造包子
	 */
	synchronized void setStudent(){
		while(true){
			if(makeStudent){
				try {
					this.wait();//等待
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(count%2==0){
				s.name="景甜";
				s.age = 18;
			}else{
				s.name="迪丽热巴";
				s.age = 20;
			}
			count++;
			System.out.println("生产者制造了一个包子:"+s.name+"---"+s.age);
			makeStudent = true;//把执行权交给消费者
			this.notify();
		}
	
	}
	
	/**
	 * 消费者 消费包子
	 */
	
	synchronized void getStudent(){
		while(true){
			if(!makeStudent){
				try {
					this.wait();//在没有消费标识时如果强带执行权就等待(立即释放锁,下次被唤醒就从这里爬起来)
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(100);//消费者吃包子比生产包子快,但是消费者会等待生产者
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("消费者吃了包子:"+s.name+"---"+s.age);
			makeStudent = false;//将标识改为生产标识
			this.notify();//唤醒生产者
		}
		}
}
class MyCallable implements Callable<Integer>{
	private Integer x;
	private ExecutorService es;
	MyCallable(Integer x,ExecutorService es){
		this.x = x;
		this.es = es;
	}
	@Override
	public Integer call() throws Exception {
		int sum=0;
		for(int i=0;i<=x;i++){
			sum +=i;
		}
		es.shutdown();
		return sum;
	}
	
}


class DeleteDirectoryTimerTask extends TimerTask{
	private String path;
	private Timer timer;
	protected DeleteDirectoryTimerTask(String path,Timer timer){
		this.path = path;
		this.timer = timer;
	}
	@Override
	public void run() {
		File file = new File(path);
		deleteDirectory(file);
		timer.cancel();
		
	}
	private void deleteDirectory(File file) {
		File[] files = file.listFiles();
		if(files!=null){
			for (File file2 : files) {
				if(file2.isDirectory()){
					deleteDirectory(file2);
				}else{
					System.out.println("删除"+file2.getName()+"文件"+file2.delete());
				}
			}
			System.out.println("删除"+file.getName()+"文件夹"+file.delete());
		}
	}
	
}



















