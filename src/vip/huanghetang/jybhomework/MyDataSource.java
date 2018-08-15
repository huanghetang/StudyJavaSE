package vip.huanghetang.jybhomework;

import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

/**
 * 数据库连接池
 * 思路,实现DataSource接口,不要频繁的创建和销毁连接,初始化一个固定大小的连接池,每次调用close()方法再把当前的conn放回
 * @author zhoumo
 *
 */
public class MyDataSource implements DataSource  {
	private LinkedList<Connection> pool = new LinkedList<Connection>();
	
	public MyDataSource(){
		for (int i=0;i<5;i++) {
			Connection conn = JdbcDay04.getConnection();
			pool.addFirst(conn);
		}
		System.out.println("=====初始化池子中的connection对象有"+pool.size()+"个======");
	}
	
	/**
	 *获取的是Connection的代理对象 实现对Connection对象调用close()方法时不销毁当前的对象而是把当前的对象加入到池子中
	 */
	@Override
	public Connection getConnection() throws SQLException {
		final Connection conn = pool.removeLast();
		//创建代理对象
		Connection proxyConn = (Connection)Proxy.newProxyInstance(conn.getClass().getClassLoader(), 
				conn.getClass().getInterfaces(), 
				new InvocationHandler(){
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

						if(method.getName()=="close"){
							pool.addFirst(conn);
							System.out.println("close()后,池子中的connection对象还有"+pool.size()+"个");
							return null;
						}
						return method.invoke(conn, args);
					}
			
		});
		System.out.println("池子中的connection对象还有"+pool.size()+"个");
		return proxyConn;
	}
	
	
	
	
	
	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return null;
	}
	
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}





}
