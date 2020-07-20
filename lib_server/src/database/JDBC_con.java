package database;

import java.sql.*;


public class JDBC_con {
    static final String databaseURL = "jdbc:mysql://127.0.0.1:3306/lib_sys";
    static final String userName = "root";
    static final String password = "admin";

    public static Connection getCon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("sucess load JDBC");
            Connection c = DriverManager.getConnection(databaseURL, userName, password);
//            System.out.println("sucess load Connection")
            return c;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.getErrorCode();
        }
        return null;
    }
}
