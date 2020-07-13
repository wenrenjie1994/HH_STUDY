package com.caorui.utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    /*
    使用静态代码块儿，来完成只读取一次资源文件
     */
    static {

        try {
            //创建集合类的对象
            Properties properties=new Properties();
            //获取src下文件的方式--->ClassLoader 类加载器
            ClassLoader classLoader=JDBCUtils.class.getClassLoader();
            URL res=classLoader.getResource("jdbc.properties");
            //加载文件
            properties.load(new FileReader(res.getPath())) ;
            url=properties.getProperty("url");
            user=properties.getProperty("user");
            password=properties.getProperty("password");
            driver=properties.getProperty("driver");
            //注册驱动
            Class.forName(driver);

        } catch (IOException | ClassNotFoundException e) {

        }
    }

    /**
     *
     * @return
     */
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * 因为把资源创建到try（）里面了，所以没有用到这个方法
     * @param conn
     * @param sm
     */
    public static void closeConnection(Connection conn, Statement sm){
        if (sm!=null) {
            try {
                sm.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn!=null) {
            try {
                sm.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
