package test;
import java.sql.*;
import java.util.Arrays;

public class testJDBC {
    public static void main(String[] args) {
        System.out.println(getConnection());
    }
    //连接数据库，返回一个Connection对象
    public static Connection getConnection() {
        Connection connection = null;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取Connection对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrsv3?serverTimezone=UTC", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    //关闭数据库连接，释放资源
    public static void closeConnection(Connection conn ,Statement stmt){
        //避免空指针异常
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static void closeConnection(ResultSet rs, Connection conn , Statement stmt){
        //避免空指针异常
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
