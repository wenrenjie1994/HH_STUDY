package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class conectdemo {
    /**
     * 使用JDBC连接MySQL数据库
     *
     * @author lloyd
     */
    public static void main(String[] args) {
        try {
            // 1.加载数据库驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("数据库驱动加载成功");

            // 2.创建连接
            //格式为jdbc:mysql:
            // 127.0.0.1:3306/数据库名称?useSSL=true&characterEncoding=utf-8&user=账号名&password=密码
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/HRDB?useSSL=true&characterEncoding=utf-8&serverTimezone=GMT&user=root&password=qwe3208620");
            System.out.println("创建连接成功");


        }
        catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
