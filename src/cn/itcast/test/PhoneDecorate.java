package cn.itcast.test;

/**
 * װ��ģʽ:����һ��������ʵ�ֱ�װ����Ľӿ�,��������ӿ����͵��������ڹ��췽�������ʼ��,��д�������,�ڷ���������ó�Ա���Ե��������
 * 		װ����ֻ��Ҫ�̳������,��д�������.�ⷽ������ʹ�ø���ķ���,������.
 *       
 * @author zhoumo
 *
 */
abstract class PhoneDecorate implements Phone {
	private Phone p;
	
	PhoneDecorate(Phone p){
		this.p = p;
		
	}
	@Override
	public void call() {
		p.call();
	}

}
