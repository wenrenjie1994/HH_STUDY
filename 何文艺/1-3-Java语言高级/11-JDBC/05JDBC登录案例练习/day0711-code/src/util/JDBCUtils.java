package util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/*
JDBC工具类
 */
public class JDBCUtils {
    private static String url;
    private static String userName;
    private static String password;
    private static String driver;
    //文件的读取，只需要读取一次即可拿到这些值--->使用静态代码块
    static {
        //读取资源文件，获取值

        try {
            //1.创建Properties集合类对象
            Properties pro = new Properties();
            //获取src路径下的文件的方式--->ClassLoader类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL res = ClassLoader.getSystemResource("jdbc.properties");
            String path = res.getPath();
            //2.加载文件
            //pro.load(new FileReader("E:\IdeaProjects\basic-code\day0711-code\src\jdbc.properties"));
            pro.load(new FileReader(path));
            //3.获取属性，赋值
            url = pro.getProperty("url");
            userName = pro.getProperty("userName");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            //4.注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //获取连接：返回连接对象
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //释放资源
    public static void close(Statement stmt, Connection conn) {
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
