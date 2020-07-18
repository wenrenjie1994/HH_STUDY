package utils;

import java.sql.*;

public class DBConnection {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/resumes_db";
    private static final String name = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "123";

    static {
        try {
            Class.forName(name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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

    public static void closeConnection(ResultSet rs, Statement statement, Connection con) throws SQLException {
            if (rs != null) rs.close();
            if (statement != null) statement.close();
            if (con != null) con.close();
    }

    public static void closeConnection(Statement statement, Connection con) throws SQLException {
        closeConnection(null, statement, con);
    }
}
