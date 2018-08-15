package vip.huanghetang.jybhomework;

/**
 * ���ô������� ��ĳ����˾ÿһ��Ա�����й���,�����͹���,��Ҫ����.
 * ���������������ݲ�ͬ��Ϊ������(AdminStaff),������(Developer)�Ͳ���(Treasurer)
 * ������������Ա��Ҫ����(�ɹ�),�����е�������Ա�������(����) ���еĿ�������Ա��Ҫ����(���),���п�����Ա�������(����)
 * ���еĲ�����Ա��Ҫ����(����),�����еĲ���Ա������(��ħ��) 35���Ѧ֮ǫ�ϰ�ᰲ��Ա����������֯Ա������.
 * 
 * @author zhoumo
 *
 */
public class Day03 {
	public static void main(String[] args) {
		Boss boss = new Boss(38, "Ѧ֮ǫ");
		Developer d = new Developer("����001", "�ܽ���", "10000");
		Employee d2 = new Administration("����002", "����", "18000");
		Employee d3 = new Finance("����003", "����", "13000");
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

	// ����
	abstract void work();

}

/**
 * ���ݽӿ�
 * 
 * @author zhoumo
 *
 */
interface Actor {
	public abstract void performance();
}

/**
 * ������Ա������ݵ�
 *
 */
class Administration extends Employee implements Actor {
	public Administration(String employeeId, String name, String salary) {
		super(employeeId, name, salary);
	}

	@Override
	public void performance() {
		System.out.println(this.getName()+"��dancing");

	}

	@Override
	void work() {
		System.out.println(this.getName()+"������������");

	}

}

/**
 * ����Ա������ݵ�
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
		System.out.println(this.getName()+"��magic");

	}

	@Override
	void work() {
		System.out.println(this.getName()+"����������");

	}

}

class Developer extends Employee implements Actor {
	public Developer(String employeeId, String name, String salary) {
		super(employeeId, name, salary);
	}

	@Override
	public void performance() {
		System.out.println(this.getName()+"��sing");
	}

	@Override
	void work() {
		System.out.println(this.getName()+"��show the code");
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