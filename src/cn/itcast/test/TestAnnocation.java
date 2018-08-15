package cn.itcast.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import org.junit.Test;


public class TestAnnocation {
	public static void main(String[] args) throws Exception{
		TestAnnocation ta =new TestAnnocation();
		Class c = ta.getClass();
		Method[] methods = c.getMethods();
		for (Method method : methods) {
			if(method.isAnnotationPresent(org.junit.Test.class)){
				method.invoke(ta);
			}
		}
		
	}
	@Test
	public  void test(){
		System.out.println("test()");
	}
	@Test
	public  void test1(){
		System.out.println("test1()");
	}
	@Test
	public  void test2(){
		System.out.println("test2()");
	}

}
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD})
@interface myAnnotation{
	String[] value();
	int age() default 18;
	
}
enum MyDirection{
	LEFT(""){
		@Override
		void method() {
			// TODO Auto-generated method stub
		}
	},
	RINGTH("") {
		@Override
		void method() {
			// TODO Auto-generated method stub
			
		}
	},
	BEFORE("") {
		@Override
		void method() {
			// TODO Auto-generated method stub
			
		}
	},
	AFTER("") {
		@Override
		void method() {
			// TODO Auto-generated method stub
			
		}
	};
	MyDirection(String name){
		
	}
	abstract void method();
		
}
