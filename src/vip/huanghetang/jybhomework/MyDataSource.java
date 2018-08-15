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
 * ���ݿ����ӳ�
 * ˼·,ʵ��DataSource�ӿ�,��ҪƵ���Ĵ�������������,��ʼ��һ���̶���С�����ӳ�,ÿ�ε���close()�����ٰѵ�ǰ��conn�Ż�
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
		System.out.println("=====��ʼ�������е�connection������"+pool.size()+"��======");
	}
	
	/**
	 *��ȡ����Connection�Ĵ������ ʵ�ֶ�Connection�������close()����ʱ�����ٵ�ǰ�Ķ�����ǰѵ�ǰ�Ķ�����뵽������
	 */
	@Override
	public Connection getConnection() throws SQLException {
		final Connection conn = pool.removeLast();
		//�����������
		Connection proxyConn = (Connection)Proxy.newProxyInstance(conn.getClass().getClassLoader(), 
				conn.getClass().getInterfaces(), 
				new InvocationHandler(){
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

						if(method.getName()=="close"){
							pool.addFirst(conn);
							System.out.println("close()��,�����е�connection������"+pool.size()+"��");
							return null;
						}
						return method.invoke(conn, args);
					}
			
		});
		System.out.println("�����е�connection������"+pool.size()+"��");
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
