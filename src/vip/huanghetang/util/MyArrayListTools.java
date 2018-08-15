package vip.huanghetang.util;

import java.util.ArrayList;

public class MyArrayListTools {
	public static void main(String[] args) {

	}
	

	
	/**
	 * ��ת����
	 * ��list���϶����е�Ԫ�ؽ��з�ת(��һ�������һ���������ڶ����͵����ڶ����������������͵�������������...)
	 * @param list
	 */
	public static void reverse(ArrayList<Integer> list){
		if(list==null || list.size()==0)
			System.out.println("���ϳ���Ϊ0��Ϊnull");
		for(int i=0;i<list.size()/2;i++){
			Integer temp = list.get(i);
			list.set(i, list.get(list.size()-i-1));
			list.set(list.size()-i-1, temp);
		}
	}
	
	/**
	 * ���list���϶����е���Сֵ������
	 * @param list
	 * @return
	 */
	public static Integer min(ArrayList<Integer> list){
		Integer min = list.get(0);
		for(Integer i:list){
			min=min<i?min:i;
		}
		return min;
	}

	/**
	 * ���list���϶����е����ֵ������
	 * @param list
	 * @return
	 */
	public static Integer max(ArrayList<Integer> list){
		Integer max = list.get(0);
		for(Integer i:list){
			max=max<i?i:max;
		}
		return max;
	}
	
	/**
	 * ����Ԫ��i��list�����е�һ�γ��ֵ����������û�з���-1
	 * @param list
	 * @param i
	 * @return
	 */
	public static int indexOf(ArrayList<Integer> list,Integer i){
		int index=-1;
		for(int j=0;j<list.size();j++){
			Integer element = list.get(j);
			if(element.equals(i)){
				index = j;
			}
		}
		return index;
	}
	
//	5.public static void replaceAll(ArrayList<Integer> list,Integer oldValue,Integer newValue);
//	����ArrayList<Integer> list:Ҫ���в����ļ��϶���
//	����Integer oldValue:��Ҫ���滻����ԭֵ
//	����Integer newValue���滻�����ֵ
//	Ҫ�󣺽�list�����е�����ֵΪoldValue��Ԫ���滻ΪnewValue
	public static void replaceAll(ArrayList<Integer> list,Integer oldValue,Integer newValue){
		for(int i=0;i<list.size();i++){
			Integer element = list.get(i);
			if(oldValue.equals(element)){//�ҵ��������λ��,���滻����ֵ
				list.set(i, newValue);
			}
		}
	}
}
