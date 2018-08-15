package cn.itcast.test;


public class MusicPhoneDecorate extends PhoneDecorate {

	public MusicPhoneDecorate(Phone p) {
		super(p);
	}

	@Override
	public void call() {
		System.out.println("我可以听音乐了");
		super.call();
	}
	public static void main(String[] args) {
		Iphone p = new Iphone();
//		p.call();
		SingPhoneDecorate sd = new SingPhoneDecorate(p);
		sd.call();
		System.out.println("-------------");
		MusicPhoneDecorate mp = new MusicPhoneDecorate(p);
		mp.call();
		System.out.println("-------------");
		MusicPhoneDecorate mm = new MusicPhoneDecorate(new SingPhoneDecorate(p));
		mm.call();
	}
	public static void test(String[] args){
		System.out.println("test");
	}
}
