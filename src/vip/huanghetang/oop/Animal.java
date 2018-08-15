package vip.huanghetang.oop;

public class Animal extends Cat {

	public Animal(String name) {
		super(name);
	}
	public Animal(){
		super("12");
	}
	public static void main(String[] args) {
		Animal a = new Animal("111");
		System.out.println(a.getName());
	}
	void method(){
		main(new String[3]);
	}
}

abstract class Cat{
	private String name;

	public Cat(String name) {
		super();
		this.name = name;
	}
	public Cat(){}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}