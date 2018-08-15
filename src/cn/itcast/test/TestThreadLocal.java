package cn.itcast.test;

import java.util.Random;

/**
 *java.lang.ThreadLocal线程范围内的共享数据(实现方式为HashMap<Thread,Data> 根据线程ID设置和获取与当前线程相关的数据)
 * @author zhoumo
 *
 */
public class TestThreadLocal {
	public static void main(String[] args) {
		final Random r = new Random();
		for(int i=0;i<2;i++){
			new Thread(new Runnable(){
				@Override
				public void run() {
					int a = r.nextInt();
					ThreadScopeData.getThreadScopeData().setAge(a);
					System.out.println(Thread.currentThread().getName()+" put data="+a);
					a();
					b();
				}
			}).start();
		}
	}
	
	@Deprecated
	static void  a(){
		int age = ThreadScopeData.getThreadScopeData().getAge();
		System.out.println(Thread.currentThread().getName()+" a() get age="+age);
	}
	static void  b(){
		int age = ThreadScopeData.getThreadScopeData().getAge();
		System.out.println(Thread.currentThread().getName()+" b() get age="+age);
	}

}

class ThreadScopeData{
	private String name;
	private int age;
	//封装一个线程范围内的共享变量
	private static ThreadLocal<ThreadScopeData> threadShareData = new ThreadLocal<ThreadScopeData>();
	private ThreadScopeData(){}
	
	//直接得到与当前线程有关的数据
	public static ThreadScopeData getThreadScopeData(){
		ThreadScopeData td = threadShareData.get();//得到线程内共享数据对象
		if(td==null){
			td = new ThreadScopeData();
			threadShareData.set(td);//把数据放到ThreadLocal里面变成线程共享
			return td;
		}else{
			return td;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

