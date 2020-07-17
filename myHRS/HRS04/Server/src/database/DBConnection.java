package database;

import java.sql.*;

/**
 * @Author lee
 * @Date 2020/7/15 7:36 PM
 **/

public class DBConnection {

    static final String url = "jdbc:mysql://127.0.0.1:3306/myhrs03";
    static final String user = "root";
    static final String password = "~1qaz2wsx";

    static final String name = "com.mysql.cj.jdbc.Driver";

    // This will load the MySQL driver, each DB has its own driver
    static {
        try {
            Class.forName(name);
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception:" + cE.toString());
        }
    }

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
