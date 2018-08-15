package vip.huanghetang.jybhomework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class JdbcDay04 {
	private  static Properties properties;
	private static String driverClass="";
	private static String url = "";
	private static String user = "";
	private static String password = "";
	static{
		properties = new Properties();
		try {
//			properties.load(new FileInputStream("db.properties"));
//			properties.load(new FileInputStream("src/vip/huanghetang/jybhomework/db.properties"));
//			InputStream is = JdbcDay04.class.getResourceAsStream("db.properties");
			InputStream is = JdbcDay04.class.getClassLoader().getResourceAsStream("vip/huanghetang/jybhomework/db.properties");
			properties.load(is);
			driverClass = properties.getProperty("driverClass");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			Class.forName(driverClass);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		Connection con;
		try {
			con = DriverManager.getConnection(url,user,password);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		Connection con = getConnection();
//		Statement statement = con.createStatement();//������ѯ���
//		String sql = "select * from emp";
		String sql = "insert into user values(null,?,?)";
		PreparedStatement prepareStatement = con.prepareStatement(sql);
		prepareStatement.setString(1, "�������󱦱�");
		prepareStatement.setString(2, "123");
//		ResultSet resultSet = statement.executeQuery(sql);
		int count = prepareStatement.executeUpdate();
		System.out.println(count);
		closeAutoIOS(prepareStatement,con);
	}
	//����
	public static void closeAutoIOS(AutoCloseable...aios){
		for (AutoCloseable autoCloseable : aios) {
			if(autoCloseable!=null){
				try {
					autoCloseable.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

	private static void m1() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");//����������,��mysql�������ص�����������
		String url = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, user, password);//��ȡ����
		Statement statement = con.createStatement();//������ѯ���
		String sql = "select * from emp";
		ResultSet resultSet = statement.executeQuery(sql);
		while(resultSet.next()){
			String name=resultSet.getString("ename");
			String sal=resultSet.getString("sal");
			System.out.println(name+"---"+sal);
		}
		statement.close();
		resultSet.close();
		con.close();
	}

}
