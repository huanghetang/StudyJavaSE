package cn.itcast.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class BeanUtils {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("name", "景甜");
		map.put("age", "18");
		System.out.println(map);
		TestReflect tr = new TestReflect();
		populate(tr, map);
		System.out.println(tr);
		
	}

	private static void setPrivateFieldBySetMethod()
			throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		TestReflect tr = new TestReflect();
		Class c  = tr.getClass();
		String filedName = "name";
		Field field = c.getDeclaredField(filedName);
		Class fieldType = field.getType();
		String name1 = filedName.substring(1);
		String name2 = filedName.substring(0, 1).toUpperCase();
		String methodName ="set"+name2+name1;
		Method m = c.getMethod(methodName, fieldType);
		Object o = m.invoke(tr, "景甜");
		System.out.println(tr);
		System.out.println(o);
	}
	
	/**
	 * 给javaBean字段赋值 (javaBean private属性 空参构造,set get方法)
	 * @param obj
	 * @param methodName
	 * @param value
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static void setProperty(Object obj,String fieldName,String value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		Class c = obj.getClass();
		Field field = c.getDeclaredField(fieldName);
		field.setAccessible(true);
		field.set(obj, value);
	}

	/**
	 * 获取对象的属性值
	 * @param obj
	 * @param fieldName
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public static Object getProperty(Object obj,String fieldName) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException{
		Class c = obj.getClass();
		Field field = c.getDeclaredField(fieldName);
		field.setAccessible(true);
		Object object = field.get(obj);
		return object;
	}
	
	public static void populate(Object obj,HashMap map) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException{
		Class c = obj.getClass();
		Set<Map.Entry> entry = map.entrySet();
		for (Map.Entry entry2 : entry) {
			Object fieldName = entry2.getKey();//字段名称
			Object fieldValue = entry2.getValue();//字段值
			Field field = c.getDeclaredField((String) fieldName);//等到字段对应对象
			Class fieldType = field.getType();//获取字段对应类型
			String name1 = ((String) fieldName).substring(1);
			String name2 = ((String) fieldName).substring(0, 1).toUpperCase();
			String methodName ="set"+name2+name1;//方法名
			Method m = c.getMethod(methodName,fieldType);//得到方法对象
//			fieldType.
			//TODO fieldValue的类型Object无法向下转型
			if(fieldType == String.class){
				String value = (String)fieldValue; 
				m.invoke(obj, value);//在该对象上调用方法
			}
			if(fieldType == Integer.class){
				String value = (String)fieldValue;//输入的是字符串值
				Integer value1 = Integer.valueOf(value);
				m.invoke(obj, value1);//在该对象上调用方法
			}
		}
	}
}
