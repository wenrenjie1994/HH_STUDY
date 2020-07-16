package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    static final String url = "jdbc:mysql://localhost:3306/HRDB";
    static final String name = "com.mysql.jdbc.Driver";
    static final String user = "root";
    static final String password = "qwe3208620";
    Connection con = null;
    Statement statement = null;

    public DBConnection() {
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://127.localhost.0.1:3306/HRDB", "root", "qwe3208620");
        } catch (SQLException var1) {
            var1.printStackTrace();
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
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

    }

    public static void closeConnection(Statement statement, Connection con) {
        closeConnection((ResultSet)null, statement, con);
    }

    public static void main(String[] args) {
    }

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException var1) {
            System.out.println("Class Not Found Exception:" + var1.toString());
        }

    }
}
