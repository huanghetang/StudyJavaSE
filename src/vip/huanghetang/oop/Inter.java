package vip.huanghetang.oop;

/**
 * �ӿڳ�Ա���ص�:
 *  ��Ա����:Ĭ�� ������ public static final(�����ֶ�д����)
 *  ���췽��:�ӿ�û�й��췽��(�ӿ���Ҫ������չ���ܵ�,��û�о������)
 *  ��Ա����:Ĭ�����η��� public abstract(�����ֶ�д����)
 * @author zhoumo
 *
 */
public interface Inter {
	int num1 = 1;
	public static final int num2 = 2;
	
//	public Inter(){} û�й��췽��
	void show();
	public abstract int show2();
}
