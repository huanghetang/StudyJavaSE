package javaABC;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
public class Test {

	/**
	 *��50Ԫ�һ���5Ԫ,2Ԫ��1Ԫ.ÿ������Ǯ����Ϊ0��.
	 *���м��ֶһ�����.ÿ�ֶһ�������Ǯ����ô����?
	 *
	 */
		public static void main(String[] args){
//			
//			HashSet<Change> hs = new HashSet<Change>();
			HashSet<Change> hs = new HashSet<Change>();
			
//			HashSet<Change> hs = new HashSet<Change>();<Change>();
//			Change c= new Change();//
////			int count = 0;
//			for(int i=1;i<10;i++){
//				for(int j=1;j<22;j++){
//					for(int k=1;k<44;k++){
//						if(5*i+2*j+k==50){
////							Change c= new Change();
//							c.setFive(i+"");
//							c.setTwo(j+"");
//							c.setOne(k+"");
//							System.out.println(c);
//							System.out.println(c.hashCode());
//							System.out.println(hs.add(c));//ÿ�����ӵ�c��ַ��һ����hashset�ܹ��ӽ�ȥ
////							count++;
//						}
//					}
//				}
//			}
//			System.out.println(hs.size());
//			System.out.println(hs);
			
			Change c1= new Change();
			
			HashSet hh = new HashSet();
			System.out.println(hh.add(c1));;
			c1.setFive(4+"");
			System.out.println(hh.add(c1));;//����ȱȽϵ�ַ����false
		}



}

 class Change {
	private String five;
	private String two;
	private String one;
	public Change() {
		super();
	}
	public Change(String five, String two, String one) {
		super();
		this.five = five;
		this.two = two;
		this.one = one;
	}
	public String getFive() {
		return five;
	}
	public void setFive(String five) {
		this.five = five;
	}
	public String getTwo() {
		return two;
	}
	public void setTwo(String two) {
		this.two = two;
	}
	public String getOne() {
		return one;
	}
	public void setOne(String one) {
		this.one = one;
	}
	
	@Override
	public boolean equals(Object obj) {
			return true;
	}
	

}
