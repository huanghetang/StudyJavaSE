package vip.huanghetang.oop;

/**
 * abstract ����������򷽷�,ӵ�г��󷽷�����һ���ǳ�����,
 * ���������û�г��󷽷�(��д����),�����г��󷽷�(ǿ��Ҫ������Ҫ��������),�����зǳ��󷽷�(�й��췽�����ǲ���ʵ����,��������̳���ߴ��븴����),�����о�̬����(��������)
 * ���������ڱ�����̳�,ע������ abstract���ܺ�private(˽�к�����д) final(���ܱ��޸�) static(���ܱ���д)һ������
 * ����������������д���еĳ��󷽷�,��������Ϊ������
 * �������ʵ�����Ǿ��������ʵ�ֵ�,�Ƕ�̬�ı���
 * @author zhoumo
 *
 */
 abstract class Fu {
	 protected int a = 1;
	 String b = "123";
	 Fu(){
		System.out.println("Fu constract");
	}
	abstract void method();
	
	static void eat(){
		System.out.println("fu static method eat()");
	}
	

	
}
