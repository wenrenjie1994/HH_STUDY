package database;

import java.sql.*;

public class DBConnection {

    static final String url = "jdbc:mysql://127.0.0.1:3306/resumedata";
    static final String name = "com.mysql.jdbc.Driver";
    static final String user = "root";
    static final String passwords = "root";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, passwords);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
    * Statement: 用于执行SQL语句的工具接口
    * ResultSet: 结果集对象
    * */

    public static void closeConnection(Connection con, Statement state, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (state != null) state.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
