package cn.itcast.test;

import java.util.concurrent.atomic.AtomicInteger;

public class UniqueThreadIdGenerator {

     private static final AtomicInteger uniqueId = new AtomicInteger(0);

     private static final ThreadLocal < Integer > uniqueNum = 
         new ThreadLocal < Integer > () {
             @Override protected Integer initialValue() {
                 return uniqueId.getAndIncrement();
         }
     };
 
//     public static int getCurrentThreadId() {
//         return uniqueId.get();
//     }
     
     
     public static void main(String[] args) {
		for(int i=0;i<15;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName()+","+UniqueThreadIdGenerator.uniqueNum.get()+","+
							UniqueThreadIdGenerator.uniqueNum.get());
				}
			}).start();
		}
	}
     
     
     
 } // UniqueThreadIdGenerator
