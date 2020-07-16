package util;

import com.sun.deploy.panel.IProperty;

import java.io.FileReader;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @program: TODO
 * @className:JDBCUtils
 * @description:JDBC工具类
 * @author: 何文艺
 * creat: 2020/7/15 13:51
 **/
public class JDBCUtils {
    private static String url;
    private static String userName;
    private static String password;
    private static String driver;

    //文件的读取，只需要读取一次即可拿到这些值--->使用静态代码块
    static {
        try {
            //读取资源文件，获取值
            //1.创建Properties集合类对象
            Properties pro = new Properties();
            //获取src路径下的文件的方式--->ClassLoader类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL res = ClassLoader.getSystemResource("jdbc.properties");
            String path = res.getPath();
            //2.加载文件
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
    public static Connection getConnnection() {
        try {
            return DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //释放资源：针对于有结果集的DQL操作
    public static void closeConnection(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //释放资源：针对于没有结果集的DDL、DML操作
    public static void closeConnection(PreparedStatement pstmt, Connection conn) {
        closeConnection(null, pstmt, conn);
    }
}
