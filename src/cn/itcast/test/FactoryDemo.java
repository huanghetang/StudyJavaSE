package cn.itcast.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 工厂模式:方便类的管理,降低系统的耦合性
 * @author zhoumo
 *
 */
public class FactoryDemo {
	static Properties p  = new Properties();
	static{
		try {
			p.load(new FileReader("reflect.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void targetInvoke() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		String className = p.getProperty("className");
		String methodName = p.getProperty("method");
		Class c = Class.forName(className);
		Constructor cc = c.getConstructor(cn.itcast.test.Phone.class);
		MusicPhoneDecorate mp = (MusicPhoneDecorate)cc.newInstance(new Iphone());
		Method mm= c.getMethod("main", String[].class);
//		Method mm= c.getMethod(methodName);
		System.out.println(mm);
		String [] arg = new String[]{"sdf"};
		mm.invoke(null,new String[]{});
		
	}
	public static void main(String[] args) throws Exception {
//		try {
//			targetInvoke();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		String [] arg = {"1","2"};
//		MusicPhoneDecorate.main(arg);
		Class c = Class.forName("cn.itcast.test.MusicPhoneDecorate");
		Method mm= c.getMethod("main", String[].class);
//		Method mm= c.getMethod(methodName);
		System.out.println(mm);
		String [] arg = new String[]{"sdf"};
		mm.invoke(new MusicPhoneDecorate(new Iphone()),(Object)arg);
	}
	
}
