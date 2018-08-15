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
		map.put("name", "����");
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
		Object o = m.invoke(tr, "����");
		System.out.println(tr);
		System.out.println(o);
	}
	
	/**
	 * ��javaBean�ֶθ�ֵ (javaBean private���� �ղι���,set get����)
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
	 * ��ȡ���������ֵ
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
			Object fieldName = entry2.getKey();//�ֶ�����
			Object fieldValue = entry2.getValue();//�ֶ�ֵ
			Field field = c.getDeclaredField((String) fieldName);//�ȵ��ֶζ�Ӧ����
			Class fieldType = field.getType();//��ȡ�ֶζ�Ӧ����
			String name1 = ((String) fieldName).substring(1);
			String name2 = ((String) fieldName).substring(0, 1).toUpperCase();
			String methodName ="set"+name2+name1;//������
			Method m = c.getMethod(methodName,fieldType);//�õ���������
//			fieldType.
			//TODO fieldValue������Object�޷�����ת��
			if(fieldType == String.class){
				String value = (String)fieldValue; 
				m.invoke(obj, value);//�ڸö����ϵ��÷���
			}
			if(fieldType == Integer.class){
				String value = (String)fieldValue;//��������ַ���ֵ
				Integer value1 = Integer.valueOf(value);
				m.invoke(obj, value1);//�ڸö����ϵ��÷���
			}
		}
	}
}
