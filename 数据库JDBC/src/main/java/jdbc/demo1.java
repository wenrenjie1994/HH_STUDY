package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class demo1 {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("ok");
		//连接到数据库
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String uername = "scott";
		String password = "123456";
		Connection conn = DriverManager.getConnection(url,uername,password);
		System.out.println(conn.getClass());
		//创建语句对象
		Statement stm = conn.createStatement();
		String ddl = "create table wei_emp ( id NUMBER(4),name VARCHAR2(20) NOT NULL,"+
                     "gender CHAR(1) DEFAULT 'M', birth DATE, salary NUMBER(6,2), " +
                     "job VARCHAR2(30), deptno NUMBER(2))";
		String d2 = "drop table wei_emp";
		boolean b = stm.execute(ddl);//返回true表示有结果集
		
		//关闭数据库
		conn.close();
		

	}

} 
