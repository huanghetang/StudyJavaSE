package vip.huanghetang.jybhomework;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * 本类测试DBUtils的方法原理
 * @author zhoumo
 *
 */
public class JdbcDay06 {
	private DataSource ds;//注入数据库连接池
	
	public DataSource getDs() {
		return ds;
	}
	public void setDs(DataSource ds) {
		this.ds = ds;
	}
	
	public JdbcDay06(DataSource ds){
		this.ds = ds;
	}

	
	/**
	 * DBUtils的查询方法原理,懒,直接使用了DBUtils的ResutlSetHandler接口
	 * 只是包装了java.sql.Connection的方法
	 */
	public <T extends Object> T query(String sql,MyResultSetHandler<T> rsh,Object...obj) throws Exception{
		Connection con = ds.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ParameterMetaData metaData = ps.getParameterMetaData();//得到入参(占位符参数)元数据
		int count = metaData.getParameterCount();//得到占位符个数
//		System.out.println("count="+count+",obj.length="+obj.length);
		//安全检查
		if(count != obj.length){
			throw new IllegalArgumentException("非法参数");
		}
		//注入sql参数
		for (int i=0;i<obj.length;i++) {
			ps.setObject(i+1, obj[i]);
		}
		ResultSet rs = ps.executeQuery();
		T t = rsh.myHandle(rs);
		return t;
	}
	/**
	 * 算了,自己写
	 */
	interface MyResultSetHandler<T>{
		T myHandle(ResultSet rs) throws SQLException;
	}
	

	/**
	 * 	/**
	 * DBUtils删除
	 * @throws SQLException
	 */
	private static void delete1() throws SQLException {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		QueryRunner queryRunner = new QueryRunner(ds);
		Connection conn = ds.getConnection();
		conn.setAutoCommit(false);//开启事务
		int update = queryRunner.update(conn, "delete from user where uname=?", "景甜");
//		conn.rollback();
		conn.commit();
		System.out.println(update);
	}
	private static void update2() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());
		int update = queryRunner.update("update user set uname=?,upassword=? where uname=?", "热巴大宝贝","9527","热巴");
		System.out.println(update);
	}
	/**
	 * DBUtils增加
	 * @throws SQLException
	 */
	private static void update3() throws SQLException {
		DataSource cpds = new ComboPooledDataSource();
		QueryRunner queryRunner = new QueryRunner(cpds);
		String sql = "insert into user values(null,?,?)";
		int update = queryRunner.update(sql, "景甜大宝贝",9527);
		System.out.println(update);
	}
	
	//测试Query方法返回List ResultSetHandler的实现类BeanListhandler 
	private static void testDBUtilsQuery() throws SQLException {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		QueryRunner queryRunner = new QueryRunner(ds);
		BeanListHandler<User> rsh = new BeanListHandler<User>(User.class);//反射创建实例注入属性封装到list
		String sql = "select * from User";
		List<User> query = queryRunner.query(sql, rsh);
		for (User user : query) {
			System.out.println(user);
		}
	}
	/**
	 *测试了自己实现的DBUtils的查询方法
	 */
	private static void testMyDbUtil() throws Exception {
		DataSource dataSource = new ComboPooledDataSource();
		JdbcDay06 d6 =new JdbcDay06(dataSource);
//		String sql = "select * from User";
		String sql = "select * from User where uname=?";
		MyResultSetHandler<List<User>> rsh = new MyResultSetHandler<List<User>>(){
			@Override
			public List<User> myHandle(ResultSet rs) throws SQLException {
				ArrayList<User> list = new ArrayList<User>();
				while(rs.next()){
					int id = rs.getInt("uid");
					String uname = rs.getString("uname");
					String upassword = rs.getString("upassword");
					User user = new User(id,uname,upassword);
					list.add(user);
				}
				return list;
				
			}
			
		};
		List<User> userList = d6.query(sql, rsh,"古力娜扎小姐姐");
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	
/**
 * 测试线程局部对象的使用,这样能够解决银行转账Dao层Connection对象传参问题,使用这种线程单例模式降低了类之间的耦合性
 */
	static class CurrentThreadConnection{
		private static ThreadLocal<Connection> threadLocalConn = new ThreadLocal<Connection>();//线程局部变量
		private static final DataSource ds = new ComboPooledDataSource();
		public static Connection getCurrentThreadConnection() throws SQLException{
			Connection conn = threadLocalConn.get();
			if(conn==null){
					conn = ds.getConnection();
					threadLocalConn.set(conn);
			}
			return conn;
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		transfer();
		
	}
	
	/**
	 * 模拟银行转账
	 * @throws SQLException 
	 */
	static void transfer() throws SQLException{
		Connection connection = CurrentThreadConnection.getCurrentThreadConnection();
		System.out.println(connection);
		try {
			connection.setAutoCommit(false);
			A("7","100");
			int i=1/0;
			B("6","100");
		} catch (SQLException e) {
			e.printStackTrace();
			connection.rollback();
		}
			connection.commit();
	
		
	}
	static void A(String from,String money) throws SQLException{
		String sql = "update user set account= account-? where uid=? ";
		QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());
		Connection connection = CurrentThreadConnection.getCurrentThreadConnection();
		int update = queryRunner.update(connection,sql,money,from);
		System.out.println(update);
	}
	static void B(String to,String money) throws SQLException{
		String sql = "update user set account= account+? where uid=? ";
		QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());
		Connection connection = CurrentThreadConnection.getCurrentThreadConnection();
		int update = queryRunner.update(connection,sql,money,to);
		System.out.println(update);
	}

}

