package ywcl;

import java.sql.*;

public class DBManager {
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("驱动加载成功！");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","123");
			System.out.println("数据库连接成功！");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {
		getConn();

	}

}
