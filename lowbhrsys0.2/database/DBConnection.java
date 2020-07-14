package database;

import java.sql.*;

/**
 * 数据库连接相关类
 * @author Administrator
 */
public class DBConnection {
    static final String url = "jdbc:mysql://127.0.0.1:3306/bookmis";
    static final String name = "com.mysql.jdbc.Driver";
    static final String user = "root";
    static final String password = "admin";
    static {
        try {
			// 指定连接类型
            Class.forName(name);
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception:" + cE.toString());
        }
    }

    Connection con = null;
    Statement statement = null;

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(ResultSet rs, Statement statement, Connection con) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(Statement statement, Connection con) {
        closeConnection(null, statement, con);
    }
}
