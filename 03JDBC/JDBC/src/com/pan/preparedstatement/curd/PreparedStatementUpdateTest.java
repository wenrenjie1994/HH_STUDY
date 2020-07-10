package com.pan.preparedstatement.curd;

import com.pan.connection.ConnectionTest;
import com.pan.util.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/*
PreparedStatement实现对数据表的增删改查操作
增删改；
查

 */
public class PreparedStatementUpdateTest {

    @Test
    public void testCommonUpdate() {
//        String sql = "delete from customers where id = ?";
//        update(sql, 3);
        String sql = "update `order` set order_name = ? where order_id = ?";
        update(sql,"cc","2");//不知道哪里出了问题，表不更新

    }


    //通用的增删改操作
    public void update(String sql, Object... args) {
        //SQL中占位符的个数与可变形参的长度相同
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //1.获取数据库的连接
            connection = JDBCUtils.getConnection();
            //2.预编译SQL语句，返回PreparedStatement的实例
            preparedStatement = connection.prepareStatement(sql);
            //3.填充占位符
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[0]);//小新参数声明错误！！
            }
            //4.执行
            preparedStatement.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //5.资源的关闭
            JDBCUtils.closeResource(connection, preparedStatement);
        }

    }

    //修改customers表的一条记录
    @Test
    public void testUpdate() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //1.获取数据库的连接
            connection = JDBCUtils.getConnection();
            //2.预编译SQL语句，返回PreparedStatement的实例
            String sql = "update customers set name = ? where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            //3.填充占位符
            preparedStatement.setString(1, "莫扎特");
            preparedStatement.setInt(2, 18);
            //4.执行
            preparedStatement.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //5.资源的关闭
            JDBCUtils.closeResource(connection, preparedStatement);
        }
    }


    //向customer表中添加一条记录
    @Test
    public void testInsert() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //1.读取配置文件中的四个基本信息
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties pros = new Properties();
            pros.load(is);

            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String url = pros.getProperty("url");
            String driverClass = pros.getProperty("driverClass");

            //2.加载驱动
            Class.forName(driverClass);

            //3.获取连接
            connection = DriverManager.getConnection(url, user, password);
//        System.out.println(connection);

            //4.编译SQL语句，返回PreparedStatement的实例
            String sql = "insert into customers(name,email,birth)values(?,?,?)";//?占位符
            preparedStatement = connection.prepareStatement(sql);
            //5.填充占位符
            preparedStatement.setString(1, "哪吒");
            preparedStatement.setString(2, "nezha@gmail.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse("1000-01-01");
            preparedStatement.setDate(3, new java.sql.Date(date.getTime()));
            //牢记：java.util.Date和java.sql.Date的相互转换

            //6.执行操作
            preparedStatement.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            //7.资源的关闭
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }
}
