package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static final String url = "jdbc:mysql://localhost:3306/zhongsz";
    public static final String username = "root";
    public static final String password = "mysql123456";
    public static final String driver = "com.mysql.jdbc.Driver";

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Cannot find the driver class: " + driver);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            return null;
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
