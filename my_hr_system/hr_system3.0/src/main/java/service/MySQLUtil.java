package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author: chenlei
 * @Date: 2020/7/15 14:37
 */
public class MySQLUtil {
    private static Connection connection;
    private static String classDriver = "com.mysql.cj.jdbc.Driver";
    private static String url = "url";
    private static String name = "root";
    private static String password = "root";

    /**
     * 此处使用一个static的代码块是为了
     * 让这段代码在类加载的时候就直接运行
     * 不需要new就能够获取connection
     */
    static {
        try {
            System.out.println("创建数据库连接");
            Class.forName(classDriver);
            connection = DriverManager.getConnection(url,name,password);
        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     * @return
     */
    public static Connection getConnection() {
        return connection;
    }

    /**
     * 关闭数据库连接
     */
    public static void closeConnection() {
        try {
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
