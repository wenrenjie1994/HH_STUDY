package database;

import java.sql.*;

/**
 * @program: HR_SYS_3.0（基于数据库）
 * @className: DBConnection
 * @description: 实现数据库相关操作
 * @author: 何文艺
 * @creat: 2020/7/12 14:51
 **/
public class DBConnection {
    //1.导入驱动jar包：将mysql-connector-java-5.1.49-bin.jar包加入libs目录下 --> add as library

    static final String name = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/db";
    static final String username = "root";
    static final String password = "root";
    Connection conn = null;
    Statement stmt = null;

    //2.注册驱动
    static {
        try {
            Class.forName(name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //3.获取数据库的连接对象
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }



    //关闭资源
    public static void closeConnection(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void closeConnection(Statement stmt, Connection conn) {
        closeConnection(null, stmt, conn);
    }
}
