package cn.itcast.test;

public class SingPhoneDecorate extends PhoneDecorate {

	SingPhoneDecorate(Phone p) {
		super(p);
	}

	@Override
	public void call() {
		super.call();
		System.out.println("我可以听彩铃了");
	}
}
