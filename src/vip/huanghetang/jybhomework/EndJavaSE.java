package vip.huanghetang.jybhomework;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import vip.huanghetang.util.JdbcUtils;

public class EndJavaSE {
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("1.��ѯ����\t 2.���Ӷ���\t 3.�޸Ķ���\t 4.ɾ������\t 5.����ɾ������\t 6.-1�˳�\t 7.��������");
			String s= scanner.nextLine();
			switch(s){
			case "1":
				findAll();
				break;
			case "2":
				addProduct();
				break;
			case "3":
				findAll();
				break;
			case "4":
				findAll();
				break;
			case "5":
				deleteByIds();
				break;
			case "7":
//				addProducts();
				addProducts2();
				break;
			case "-1":
				System.exit(0);
			default:
				System.out.println("�������");
			}
		}
		
	}

	private static void deleteByIds() throws SQLException {
		Connection con = JdbcUtils.getConnection();
		QueryRunner qr = new QueryRunner();
		ArrayList<String> list = new ArrayList<String>();
		con.setAutoCommit(false);
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("��������Ҫɾ����id,0����");
			String s = scanner.nextLine();
			if("0".equals(s)){
				break;
			}
			String sql = "select  * from orders where id = ?";
			Product query = qr.query(con,sql,new BeanHandler<Product>(Product.class),s);
			System.out.println(query);
			if(query==null){
				System.out.println("���������Ʒ������");
			}else{
				list.add(s);
			}
		}	
		System.out.println("ȷ��Ҫɾ����?Y/N");
		String sss = scanner.nextLine();
		if("y".equalsIgnoreCase(sss)){
			for (String s : list) {
				qr.update(con, "delete from orders where id =?", s);
			}
			DbUtils.commitAndCloseQuietly(con);
		}else{
			DbUtils.rollbackAndCloseQuietly(con);
		}
		
	
	}

	//����һ��
	private static void addProduct() throws SQLException {
		Connection con = JdbcUtils.getConnection();
		System.out.println("getConnection:"+con);
		QueryRunner queryRunner = new QueryRunner();
		System.out.println("��������Ʒ���ƺͼ۸� \",\"���");
		Scanner sc= new Scanner(System.in);
		String nextLine = sc.nextLine();
		String sql = " insert into orders values(null,?,?)";
		Object[] params = new Object[2];
		if(nextLine.contains(",")){
			String[] ss = nextLine.split(",");
			params[0] = ss[0];
			params[1] = ss[1];
		}
		
		queryRunner.update(con,sql,params);
		System.out.println("ȷ���ύ��?y/N");
		String sss = sc.nextLine();
		if("y".equalsIgnoreCase(sss)){
			DbUtils.commitAndCloseQuietly(con);
		}else{
			DbUtils.rollbackAndCloseQuietly(con);
		}
		
	}
	/**
	 * ��������
	 * @throws SQLException
	 */
		private static void addProducts() throws SQLException {
			Connection con = JdbcUtils.getConnection();
			QueryRunner queryRunner = new QueryRunner();
			Scanner sc= new Scanner(System.in);
			con.setAutoCommit(false);
			String sql = " insert into orders values(null,?,?)";
			Object[] params = new Object[2];
			while(true){
				System.out.println("��������Ʒ���ƺͼ۸� \",\"���,0����");
				String nextLine = sc.nextLine();
				System.out.println(nextLine);
				if("0".equals(nextLine)){
					break;
				}
				if(nextLine.contains(",")){
					String[] ss = nextLine.split(",");
					if(ss.length==2){
						params[0] = ss[0];
						params[1] = ss[1];
						queryRunner.update(con,sql,params);
					}
				}
			
			}
			System.out.println("ȷ���ύ��?y/N");
			String sss = sc.nextLine();
			if("y".equalsIgnoreCase(sss)){
				DbUtils.commitAndCloseQuietly(con);
			}else{
				DbUtils.rollbackAndCloseQuietly(con);
			}
			
		}
		
		public static void addProducts2() throws SQLException{
			Connection con = JdbcUtils.getConnection();
			QueryRunner r = new QueryRunner();
			Scanner scanner = new Scanner(System.in);
			con.setAutoCommit(false);
			ArrayList<Product> list = new ArrayList<Product>();
			while(true){
				System.out.println("��������Ʒ���ƺͼ۸� \",\"���,0����");
				String nextLine = scanner.nextLine();
				if("0".equals(nextLine)){
					break;
				}
				if(nextLine.contains(",")){
					String[] ss = nextLine.split(",");
					if(ss.length==3){
						Product product = new Product();
						product.setPrice(Integer.valueOf(ss[2]));
						product.setProduct(ss[1]);
						product.setId(Integer.valueOf(ss[0]));
						list.add(product);
					}
				}
			}
			for (Product product : list) {
				String sql = " insert into orders values(?,?,?)";
				r.update(con, sql,product.getId(),product.getProduct(),product.getPrice());
			}
			System.out.println("ȷ���ύ��?y/N");
			String sss = scanner.nextLine();
			if("y".equalsIgnoreCase(sss)){
				DbUtils.commitAndCloseQuietly(con);
			}else{
				DbUtils.rollbackAndCloseQuietly(con);
			}
			
		}
	

	private static void findAll() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());
		String sql = "select * from orders";
		BeanListHandler<Product> rsh = new BeanListHandler<Product>(Product.class);
		List<Product> query = queryRunner.query(sql, rsh);
		if(query!=null && query.size()>0){
			System.out.println();
		}
		for (Product product : query) {
			System.out.println(product.getId()+"\t"+product.getProduct()+"\t"+product.getPrice());
		}
		
	}
	
	
	
}
