package vip.huanghetang.jybhomework;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcDay05 {
	

	public static void main(String[] args){
			
		QueryRunner s;
		
	}

	private static void testDbcp() {
		Connection connection = null;
		PreparedStatement ps=null;
			try {
				Properties properties = new Properties();
				properties.load(JdbcDay05.class.getResourceAsStream("db2.properties"));
				DataSource ds = BasicDataSourceFactory.createDataSource(properties);
				connection = ds.getConnection();
				String sql = "update user set uname=?,upassword=? where uname = ?";
				 ps = connection.prepareStatement(sql);
				 ps.setString(1, "π≈¡¶ƒ»‘˙–°Ω„Ω„");
				 ps.setString(2, "223");
				 ps.setString(3, "π≈¡¶ƒ»‘˙¥Û≤®√√");
				 int x = ps.executeUpdate();
				 System.out.println(x);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				JdbcDay04.closeAutoIOS(connection,ps);
			}
	}

	private static void testC3p0() {
		DataSource dataSource = new ComboPooledDataSource();
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			String sql = "insert into user values(null,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, "π≈¡¶ƒ»‘˙¥Û≤®√√");
			ps.setString(2, "222");
			int count = ps.executeUpdate();
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcDay04.closeAutoIOS(con,ps);
		}
	}

	private static void testMyDataSource() {
		Connection con = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try{
			MyDataSource dataSource = new MyDataSource();
			 con = dataSource.getConnection();
			String sql = "select * from emp";
			prepareStatement = con.prepareStatement(sql);
			 resultSet = prepareStatement.executeQuery();
			 while(resultSet.next()){
				 String ename = resultSet.getString("ename");
				 String sal = resultSet.getString("sal");
				 System.out.println(ename+"---"+sal);
			 }
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcDay04.closeAutoIOS(con,prepareStatement,resultSet);
		}
	}
	
	

}
