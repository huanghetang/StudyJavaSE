package vip.huanghetang.util;

import java.util.ArrayList;

public class MyArrayListTools {
	public static void main(String[] args) {

	}
	

	
	/**
	 * 反转集合
	 * 对list集合对象中的元素进行反转(第一个和最后一个交换，第二个和倒数第二个交换，第三个和倒数第三个交换...)
	 * @param list
	 */
	public static void reverse(ArrayList<Integer> list){
		if(list==null || list.size()==0)
			System.out.println("集合长度为0或为null");
		for(int i=0;i<list.size()/2;i++){
			Integer temp = list.get(i);
			list.set(i, list.get(list.size()-i-1));
			list.set(list.size()-i-1, temp);
		}
	}
	
	/**
	 * 求出list集合对象中的最小值并返回
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
	 * 求出list集合对象中的最大值并返回
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
	 * 返回元素i在list集合中第一次出现的索引，如果没有返回-1
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
//	参数ArrayList<Integer> list:要进行操作的集合对象
//	参数Integer oldValue:需要被替换掉的原值
//	参数Integer newValue：替换后的新值
//	要求：将list集合中的所有值为oldValue的元素替换为newValue
	public static void replaceAll(ArrayList<Integer> list,Integer oldValue,Integer newValue){
		for(int i=0;i<list.size();i++){
			Integer element = list.get(i);
			if(oldValue.equals(element)){//找到这个索引位置,并替换成新值
				list.set(i, newValue);
			}
		}
	}
}
