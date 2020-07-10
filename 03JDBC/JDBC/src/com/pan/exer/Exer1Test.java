package com.pan.exer;

import com.pan.util.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//课后练习一：
public class Exer1Test {
    public static void main(String[] args) throws ParseException {

        Exer1Test test = new Exer1Test();
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String name = scanner.next();
        System.out.print("请输入邮箱：");
        String email = scanner.next();
        System.out.print("请输入生日：");
        String birthday = scanner.next();//1992-09-08
        //运行的时候birthday不是row1!!!

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date birthday = sdf.parse("1995-01-01");


        String sql = "insert into customers(name,email,birth)values(?,?,?)";

        int insertCount = test.update(sql, name, email, birthday);
        if (insertCount > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }


    }


    //通用的增删改操作
    public int update(String sql, Object... args) {
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
            /*
            preparedStatement.execute():如果执行的是查询操作，有返回结果，则此方法返回true；
            如果执行的是增删改操作，没有返回结果，则此方法返回false；
             */
//            return preparedStatement.execute();
            return preparedStatement.executeUpdate();//返回受影响的行数

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
        return 0;
    }
}
