package cn.itcast.test;

/**
 * 、题目：编写程序，从两个关联表中查询数据，并显示查询结果；
请按以下步骤制作程序：

1）.建表：详见素材中的SQL建表语句.txt
       a).创建数据库:Test1（复制SQL语句执行）
       b).创建表：dept(部门表)，有如下结构及数据：（复制SQL语句执行）
       c).创建表：employee(员工表) （复制SQL语句执行）
2). 启动Eclipse，搭建环境
       a).建立项目：Test1_Pro
       b).将所需第三方jar包复制到项目的lib目录下：
        C3P0包； DBUtils包；  MySQL连接驱动包；
      c).在src下放置C3P0连接池的配置文件：c3p0-confi1g.xml。
        提示：修改xml中：自己数据库名 ；  用户名和密码

3).创建包和类，然后写代码
     a).创建包：cn.itcast.tools;在此包下创建类：JDBCUtils工具类，用于封装C3P0连接池，   
      成员：
     ①.私有的静态成员变量：ComboPooledDataSource 并创建对象；加载配置文件的默认配置。
     ②.公有的静态成员方法：DataSource getDataSource()，此方法返回C3P0连接池对象；
     ③.公有的静态成员方法： Connection getConnection()，此方法返回Connection对象；

     b). 创建包：cn.itcast.domain,此包下创建两个JavaBean类： 
        a). Dept      
        b). Employee（包含成员属性Dept）
        私有化所有成员属性；公有无参、全参构造方法；所有属性的get/set方法：
        提示：参照数据库两个表格中字段和类型  
    
    c). 创建包：cn.itcast.app。在此包下创建类：MainApp，并且包含main()方法

4）在main()方法中按如下要求编写代码：
①使用连接池创建QueryRunner对象；
②定义SQL语句：查询所有的员工信息 (不包含没有部门的员工)

③调用QueryRunner的查询方法，将每个员工信息封装到一个Employee对象中。
④遍历所有员工信息，查询每个员工的部门信息，并将对象的部门信息封装到Employee内部的Dept对象中；
遍历所有员工信息，打印每个员工的：员工姓名、性别、年龄、所属部门名称。
 * @author zhoumo
 *
 */
public class Test3 {
	public static void main(String[] args) {
		
	}

}
