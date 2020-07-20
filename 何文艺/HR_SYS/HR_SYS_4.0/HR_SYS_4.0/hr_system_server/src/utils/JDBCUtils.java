package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @program: HR_SYS_4.0（C/S模式）
 * @className:JDBCUtils
 * @description:JDBC工具类简化数据库操作
 * @author: 何文艺
 * @create: 2020/7/17 11:03
 **/
public class JDBCUtils {
    private static DataSource dataSource;

    //配置文件的读取，只需要读取一次即可拿到这些值，不需要每一次都读取--->使用静态代码块
    static {
        try {
            //读取配置文件，获取值
            //创建Properties集合类对象
            Properties properties = new Properties();
            //获取src路径下的文件的方式--->ClassLoader类加载器
            //避免使用绝对路径时在文件位置发生改变时也必须改变程序代码的问题
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            //加载文件
            properties.load(classLoader.getResourceAsStream("druid.properties"));
            //获取DataSource
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //释放资源
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement stmt, Connection conn) {
        close(null, stmt, conn);
    }

}
