package com.pan.connection;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest {
    //方式一：
    @Test
    public void testConnection1() throws SQLException {
        //获取Driver实现类对象
        Driver driver = new com.mysql.jdbc.Driver();

        //url:http://localhost:8080/gmall/keyboard.jpg
        //jdbc:mysql:协议
        //localhost:ip地址
        //3306:默认mysql的端口号
        //test:test数据库
        String url = "jdbc:mysql://localhost:3306/test";

        //将用户名和密码封装在properties中
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "123456");

        Connection conn = driver.connect(url, info);

        System.out.println(conn);
    }


    //方式二：对方式一的迭代，在如下的程序中不出现第三方的api，使得程序具有更好的可移植性
    @Test
    public void testConnection2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        //1.获取Driver实现类对象：使用反射
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        //2.提供要连接的数据库
        String url = "jdbc:mysql://localhost:3306/test";
        //3.提供连接需要的用户名和密码
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "123456");
        //4.获取连接
        Connection connect = driver.connect(url, info);
        System.out.println(connect);
    }

    //方式三：使用DriverManager替换Driver
    @Test
    public void testConnection3() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        //1.提供另外三个连接的基本信息
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "123456";

        //2.获取Driver的实现类对象
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        //注册驱动
        DriverManager.registerDriver(driver);

        //3.获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    //方式四：可以只是加载驱动，不要显示的注册驱动过了
    @Test
    public void testConnection4() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        //1.提供另外三个连接的基本信息
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "123456";

        //2.加载Driver
        Class.forName("com.mysql.jdbc.Driver");
        //相较于方式三，可省略如下的操作
//        Driver driver = (Driver) clazz.newInstance();
        //注册驱动
//        DriverManager.registerDriver(driver);

        //3.获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    //方式五final：将数据库连接的四个基本信息声明在配置文件中，通过读取配置文件的方式，获取连接
    /*
    此种方式的好处：
    1.实现了数据与代码的分离，实现了解耦
    2.如果需要修改配置文件信息，可以避免程序重新打包。
     */

    @Test
    public void testConnection5() throws IOException, ClassNotFoundException, SQLException {
        //1.读取配置文件中的四个基本信息
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        //2.加载驱动
        Class.forName(driverClass);

        //3.获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);

    }


}
