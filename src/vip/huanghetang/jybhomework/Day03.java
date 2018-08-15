package vip.huanghetang.jybhomework;

/**
 * 请用代码描述 在某个公司每一个员工都有工号,姓名和工资,都要工作.
 * 按照做工作的内容不同分为行政部(AdminStaff),开发部(Developer)和财务部(Treasurer)
 * 所有行政部人员都要工作(采购),但是有的行政部员工会表演(跳舞) 所有的开发部人员都要工作(编程),但有开发部员工会表演(唱歌)
 * 所有的财务部人员都要工作(对账),但是有的财务部员工表演(玩魔术) 35岁的薛之谦老板会安排员工工作和组织员工表演.
 * 
 * @author zhoumo
 *
 */
public class Day03 {
	public static void main(String[] args) {
		Boss boss = new Boss(38, "薛之谦");
		Developer d = new Developer("黑马001", "周杰伦", "10000");
		Employee d2 = new Administration("黑马002", "景甜", "18000");
		Employee d3 = new Finance("黑马003", "柳岩", "13000");
		boss.letWork(d);
		boss.letWork(d2);
		boss.letWork(d3);
		boss.letShow(d);
		boss.letShow((Administration) d2);
		boss.letShow((Finance) d3);
	}

}

abstract class Employee {
	private String employeeId;
	private String name;
	private String salary;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Employee(String employeeId, String name, String salary) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
	}

	public Employee() {
	}

	// 工作
	abstract void work();

}

/**
 * 表演接口
 * 
 * @author zhoumo
 *
 */
interface Actor {
	public abstract void performance();
}

/**
 * 行政部员工会表演的
 *
 */
class Administration extends Employee implements Actor {
	public Administration(String employeeId, String name, String salary) {
		super(employeeId, name, salary);
	}

	@Override
	public void performance() {
		System.out.println(this.getName()+"在dancing");

	}

	@Override
	void work() {
		System.out.println(this.getName()+"在做行政工作");

	}

}

/**
 * 财务部员工会表演的
 * 
 * @author zhoumo
 *
 */
class Finance extends Employee implements Actor {
	public Finance(String employeeId, String name, String salary) {
		super(employeeId, name, salary);
	}

	@Override
	public void performance() {
		System.out.println(this.getName()+"在magic");

	}

	@Override
	void work() {
		System.out.println(this.getName()+"在做财务工作");

	}

}

class Developer extends Employee implements Actor {
	public Developer(String employeeId, String name, String salary) {
		super(employeeId, name, salary);
	}

	@Override
	public void performance() {
		System.out.println(this.getName()+"在sing");
	}

	@Override
	void work() {
		System.out.println(this.getName()+"在show the code");
	}

}

class Boss {
	private int age;
	private String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boss(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	void letWork(Employee e) {
		e.work();
	}

	void letShow(Actor a) {
		a.performance();
	}

}