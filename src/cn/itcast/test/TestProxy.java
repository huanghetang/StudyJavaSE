package cn.itcast.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  InvocationHandler handler = new MyInvocationHandler(...);
     Class proxyClass = Proxy.getProxyClass(
         Foo.class.getClassLoader(), new Class[] { Foo.class });
     Foo f = (Foo) proxyClass.
         getConstructor(new Class[] { InvocationHandler.class }).
         newInstance(new Object[] { handler });
 * @author zhoumo
 *
 */
public class TestProxy {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		UserDao ud = new UserDaoImpl();
		MyInvocationHandler handler = 	new MyInvocationHandler(ud);
		Class clazz = Proxy.getProxyClass(ud.getClass().getClassLoader(), ud.getClass().getInterfaces());
		Constructor constructor = clazz.getConstructor(InvocationHandler.class);
//		Constructor constructor = clazz.getConstructor(new Class[]{InvocationHandler.class});
		UserDao proxy = (UserDao)constructor.newInstance(handler);
//		UserDao proxy = (UserDao)constructor.newInstance(new Object[]{handler});
		System.out.println(proxy);
		
//		newProxyInstance();
		
	}

	private static void newProxyInstance() {
		UserDao ud = new UserDaoImpl();
		MyInvocationHandler handler1 = new MyInvocationHandler(ud);
		UserDao proxy = (UserDao)Proxy.newProxyInstance(ud.getClass().getClassLoader(), 
													ud.getClass().getInterfaces(),handler1);
		proxy.add("123");
		proxy.delete();
		proxy.update();
		String s = proxy.select();
		System.out.println(s);
	}

}

class MyInvocationHandler implements InvocationHandler{
	private UserDao ud;
	MyInvocationHandler(UserDao ud){
		this.ud = ud;
		
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("检查权限");
		Object o = method.invoke(ud, args);
		//Exception in thread "main" java.lang.StackOverflowError,为什么不能使用proxy?
//		System.out.println("method="+method+",proxy="+proxy.getClass()+",args="+args);
//		System.out.println("method="+method+",ud="+ud+",args="+args);
		System.out.println("操作记录");
		return o;
	}
	
	
}
