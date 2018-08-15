package cn.itcast.test;

public class UserDaoImpl implements UserDao {

	@Override
	public void add(String s) {
		System.out.println("user add "+s);
	}

	@Override
	public void delete() {
		System.out.println("user delete");
	}

	@Override
	public void update() {
		System.out.println("user update");
	}

	@Override
	public String select() {
		System.out.println("user select");
		return "select string";
	}

	@Override
	public String toString() {
		return "UserDaoImpl [select()=" + select() + "]";
	}
	

}
