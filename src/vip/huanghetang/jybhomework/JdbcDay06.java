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
 * �������DBUtils�ķ���ԭ��
 * @author zhoumo
 *
 */
public class JdbcDay06 {
	private DataSource ds;//ע�����ݿ����ӳ�
	
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
	 * DBUtils�Ĳ�ѯ����ԭ��,��,ֱ��ʹ����DBUtils��ResutlSetHandler�ӿ�
	 * ֻ�ǰ�װ��java.sql.Connection�ķ���
	 */
	public <T extends Object> T query(String sql,MyResultSetHandler<T> rsh,Object...obj) throws Exception{
		Connection con = ds.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ParameterMetaData metaData = ps.getParameterMetaData();//�õ����(ռλ������)Ԫ����
		int count = metaData.getParameterCount();//�õ�ռλ������
//		System.out.println("count="+count+",obj.length="+obj.length);
		//��ȫ���
		if(count != obj.length){
			throw new IllegalArgumentException("�Ƿ�����");
		}
		//ע��sql����
		for (int i=0;i<obj.length;i++) {
			ps.setObject(i+1, obj[i]);
		}
		ResultSet rs = ps.executeQuery();
		T t = rsh.myHandle(rs);
		return t;
	}
	/**
	 * ����,�Լ�д
	 */
	interface MyResultSetHandler<T>{
		T myHandle(ResultSet rs) throws SQLException;
	}
	

	/**
	 * 	/**
	 * DBUtilsɾ��
	 * @throws SQLException
	 */
	private static void delete1() throws SQLException {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		QueryRunner queryRunner = new QueryRunner(ds);
		Connection conn = ds.getConnection();
		conn.setAutoCommit(false);//��������
		int update = queryRunner.update(conn, "delete from user where uname=?", "����");
//		conn.rollback();
		conn.commit();
		System.out.println(update);
	}
	private static void update2() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());
		int update = queryRunner.update("update user set uname=?,upassword=? where uname=?", "�Ȱʹ󱦱�","9527","�Ȱ�");
		System.out.println(update);
	}
	/**
	 * DBUtils����
	 * @throws SQLException
	 */
	private static void update3() throws SQLException {
		DataSource cpds = new ComboPooledDataSource();
		QueryRunner queryRunner = new QueryRunner(cpds);
		String sql = "insert into user values(null,?,?)";
		int update = queryRunner.update(sql, "����󱦱�",9527);
		System.out.println(update);
	}
	
	//����Query��������List ResultSetHandler��ʵ����BeanListhandler 
	private static void testDBUtilsQuery() throws SQLException {
		ComboPooledDataSource ds = new ComboPooledDataSource();
		QueryRunner queryRunner = new QueryRunner(ds);
		BeanListHandler<User> rsh = new BeanListHandler<User>(User.class);//���䴴��ʵ��ע�����Է�װ��list
		String sql = "select * from User";
		List<User> query = queryRunner.query(sql, rsh);
		for (User user : query) {
			System.out.println(user);
		}
	}
	/**
	 *�������Լ�ʵ�ֵ�DBUtils�Ĳ�ѯ����
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
		List<User> userList = d6.query(sql, rsh,"��������С���");
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	
/**
 * �����ֲ߳̾������ʹ��,�����ܹ��������ת��Dao��Connection���󴫲�����,ʹ�������̵߳���ģʽ��������֮��������
 */
	static class CurrentThreadConnection{
		private static ThreadLocal<Connection> threadLocalConn = new ThreadLocal<Connection>();//�ֲ߳̾�����
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
	 * ģ������ת��
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

