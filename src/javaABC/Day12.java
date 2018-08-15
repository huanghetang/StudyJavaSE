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
 * ѧϰ���߳�
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
	 * ��ʱ����ʹ�� ��ʱɾ��һ���ļ���
	 * @throws ParseException
	 */
	private static void TestDeleteTimerTask() throws ParseException {
		Timer timer = new Timer("�ҵĶ�ʱ��");
		String date = "2018-4-10 08:22:10";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = sdf.parse(date);
		timer.schedule(new DeleteDirectoryTimerTask("delete", timer),d);
	}

/**
 * �̳߳ص�ʹ��
 * @throws InterruptedException
 * @throws ExecutionException
 */
	private static void testThreadPool() throws InterruptedException, ExecutionException {
		//�̳߳�,JVMƵ�����½��߳��˷���Դ,�̳߳ؿ������Ч��,�����е��߳�ʹ����Ϻ󲻻�������,���ǵȴ���һ��ʹ��
		ExecutorService pool = Executors.newFixedThreadPool(2);//�½�һ��ֻ��2���̵߳��̳߳�
		Future<Integer> f1 = pool.submit(new MyCallable(100,pool));
		Future<Integer> f2= pool.submit(new MyCallable(101,pool));
		System.out.println(f1.get());
		System.out.println(f2.get());
	}


	private static void testThreadGroup() {
		ThreadGroup threadGroup = new ThreadGroup("�ҵ��̹߳�����");
		Runnable r = new Runnable(){
			@Override
			public void run() {
				for(int i=0;i<200;i++){
					System.out.println(Thread.currentThread().getName()+":"+i);
				}
				
			}
			
		};
		Thread t1 = new Thread(threadGroup, r, "�߳�1");
		Thread t2 = new Thread(threadGroup, r, "�߳�2");
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
	 * �������ߺ�������ҵ���߼���ȡ��һ���൱��,��ҵ���߼����߳���صĴ������,�����������,���ӵ��������������ı��
	 */
	private static void productAndCustom2() {
		final StudentBusiness sb = new StudentBusiness();
		//��һ���߳���������
		new Thread(new Runnable(){
			@Override
			public void run() {
				sb.setStudent();
			}
		}).start();
		
		System.out.println("===============================over=================");
		//��һ���߳��������
		sb.getStudent();
	}


	/**
	 * ��ͨ�����ߺ�������ͨ��ģʽ
	 */
	private static void ProductAndCustom() {
		Student s = new Student();
		SetStudent setStudent = new SetStudent(s);
		GetStudent getStudent = new GetStudent(s);
		setStudent.start();
		getStudent.start();
	}


	/**
	 * ��������
	 */
	private static void DieLockTest() {
		DieLockThread d1 = new DieLockThread(true);
		DieLockThread d2 = new DieLockThread(false);
		d1.start();
		d2.start();
	}
	
	
	/**
	 * ������ ������ģʽ --�߳�ͨ�� �ȴ�--���ѻ���
	 */
	
	
	
	
	/**
	 * �̳߳��÷���
	 */
	private static void ThreadCommonsMethod() {
		//		InterviewQuestion();
				//cpu�̵߳���ģʽ 1��ʱ���� 2��ռʽ����.javaʹ����ռʽ����
				MyThread myThread1 = new MyThread("�ŷ�");
				MyThread myThread2 = new MyThread("����");
//				MyThread myThread3 = new MyThread("����");
//				Thread.currentThread().setName("���ػ��߳�");
				
		//		myThread1.setPriority(10);//�����߳����ȼ� 10���,1��С.���ִ���ۺ���˵���ȼ�����̻߳���ִ��
		//		myThread2.setPriority(1);//
				myThread1.setDaemon(true);//���ó��ػ��߳�,���������е��̶߳����ػ��̵߳�ʱ��,������˳�(���ػ����߳����������ֹ,������ֹҲ��Ҫʱ��)
				myThread1.start();
		//		try {
		//			myThread1.join();//�����̻߳�ȴ����߳���ֹ�Ż�ִ��
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
//				myThread1.interrupt();//��ϵ�ԭ��ʱ�׳�һ��InterruptedException�쳣 �����ߵ��쳣����
		//		myThread1.stop();//ǿ����ֹ,�̺߳���Ĵ��벻ִ��
				System.out.println("over");
	}

	/**
	 * ���߳�����10��Ȼ�����߳�ִ��100��Ȼ�����߳�����10��Ȼ�����߳�ִ��100��,���ѭ��50��
	 */
	private static void InterviewQuestion() {
		final Business business = new Day12().new Business();
		new Thread(new Runnable(){
			@Override
			public void run() {
				for(int i=1;i<51;i++){//���̴߳���
						business.sub(i);
					}
				}
			
		}).start();
		
	
		for(int i=1;i<51;i++){
			business.main(i);
		}
	}
	
	/**
	 * ���߳�����10��Ȼ�����߳�ִ��100��Ȼ�����߳�����10��Ȼ�����߳�ִ��100��,���ѭ��50��
	 * 
	 * ��Ҫ���߳������е�ҵ���߼������ȡ����,�ڸ�����ʵ��ҵ����Ҫ��Ļ����ͨ��,Ȼ�����߳���֮����øö���ķ������
	 */	
	
class Business{
	boolean operator = true;//���߳��Ƿ����б�ʶ ���̵߳�һ��ִ��  
	public synchronized void main(int i){
		////���ܻ����α����,��while �������Ѻ��ٴ��ж�ִ��Ȩ��ȫ
		while(operator){//����ռ���߳�����ʱ,��������
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			for(int j =1;j<101;j++){
				System.out.println("main:"+Thread.currentThread().getName()+" "+j+" for the loop of"+i);
			}
			operator = true;//��ִ��Ȩ�������߳�
			this.notify();//�������߳�
	}
	
	/**
	 * ���̵߳�һ��ִ��
	 * @param i
	 */
	public synchronized void sub(int i){
		while(!operator){//����ռ���߳�ִ��ʱ,��������
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int j =1;j<11;j++){
			System.out.println("sub:"+Thread.currentThread().getName()+" "+j+" for the loop of"+i);
		}
		operator = false;//��ִ��Ȩ�������߳�
		this.notify();//�������߳�
	}
		
		
	}
	
	/**
	 * �����߳�֮�䲻ͬ������ֵ����̴���
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
		 * java.util.Timer��ʱ��
		 * ��ĸ�� 2��ը..4��ը..2��ը
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
	 * traditionalTread ��ͳ�߳� 
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
 * ������
 * @author zhoumo
 *
 */
class MyLock{
	public static final Object lockA = new Object();
	public static final Object lockB = new Object();
	
}

/**
 * �����������
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
//			Thread.sleep(10000);//�õ�ǰ����ִ�е��߳�����
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//			System.out.println("���߱������");
//		}
//		System.out.println("run()���ִ�еĴ���");
		for(int i =0;i<300;i++){
			System.out.println(getName()+":"+i);
//			Thread.yield(); �߳�����,��һ���߳����к� �ø���һ���߳�ִ��.���Ǿ��Ե�,ֻ����һ���̶����������߳����еĸ��Ӻ�г
		}
	}
}
class Student{
	String name;
	Integer age;
	boolean flag;//Ĭ��false�� ������������
	
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
				s.name="����";
				s.age = 18;
			}else{
				s.name="�����Ȱ�";
				s.age = 20;
			}
			System.out.println("������:"+s.name);
			count++;
			s.flag = true;//��ִ��Ȩ����������
			s.notify();//����������
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
				s.wait();//��һ��������������,�������ִ��Ȩ,�͵ȴ�,Ȼ���ͷ���,�ȵ�������ʱ,ֱ�Ӵ����￪ʼִ��
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
			}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("������������:"+s.name+"---"+s.age);
		 s.flag = false;//��ִ��Ȩ����������
		 s.notify();//����������
		}
	}
		
	}
}

/**
 * �������ߺ������������ȡ��һ������,��ҵ����߳��йصĴ������
 */
class StudentBusiness{
	int count;

	private Student s = new Student();
	boolean makeStudent;//������ӱ�ʾ,Ĭ��false��ʾ�������
	
	/**
	 * ������ ,�������
	 */
	synchronized void setStudent(){
		while(true){
			if(makeStudent){
				try {
					this.wait();//�ȴ�
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
				s.name="����";
				s.age = 18;
			}else{
				s.name="�����Ȱ�";
				s.age = 20;
			}
			count++;
			System.out.println("������������һ������:"+s.name+"---"+s.age);
			makeStudent = true;//��ִ��Ȩ����������
			this.notify();
		}
	
	}
	
	/**
	 * ������ ���Ѱ���
	 */
	
	synchronized void getStudent(){
		while(true){
			if(!makeStudent){
				try {
					this.wait();//��û�����ѱ�ʶʱ���ǿ��ִ��Ȩ�͵ȴ�(�����ͷ���,�´α����Ѿʹ�����������)
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(100);//�����߳԰��ӱ��������ӿ�,���������߻�ȴ�������
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("�����߳��˰���:"+s.name+"---"+s.age);
			makeStudent = false;//����ʶ��Ϊ������ʶ
			this.notify();//����������
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
					System.out.println("ɾ��"+file2.getName()+"�ļ�"+file2.delete());
				}
			}
			System.out.println("ɾ��"+file.getName()+"�ļ���"+file.delete());
		}
	}
	
}



















