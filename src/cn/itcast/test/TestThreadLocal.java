package cn.itcast.test;

import java.util.Random;

/**
 *java.lang.ThreadLocal�̷߳�Χ�ڵĹ�������(ʵ�ַ�ʽΪHashMap<Thread,Data> �����߳�ID���úͻ�ȡ�뵱ǰ�߳���ص�����)
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
	//��װһ���̷߳�Χ�ڵĹ������
	private static ThreadLocal<ThreadScopeData> threadShareData = new ThreadLocal<ThreadScopeData>();
	private ThreadScopeData(){}
	
	//ֱ�ӵõ��뵱ǰ�߳��йص�����
	public static ThreadScopeData getThreadScopeData(){
		ThreadScopeData td = threadShareData.get();//�õ��߳��ڹ������ݶ���
		if(td==null){
			td = new ThreadScopeData();
			threadShareData.set(td);//�����ݷŵ�ThreadLocal�������̹߳���
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

