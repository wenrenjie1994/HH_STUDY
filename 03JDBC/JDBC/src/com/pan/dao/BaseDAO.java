package com.pan.dao;

import com.pan.util.JDBCUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//DAO：Data(base) Access Object 数据库连接对象
//封装针对数据表的通用操作
public abstract class BaseDAO {

    //通用的增删改操作----------V2.0（考虑事务）
    public int update(Connection connection,String sql, Object... args) {
        //SQL中占位符的个数与可变形参的长度相同
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
            JDBCUtils.closeResource(null, preparedStatement);
        }
        return 0;
    }

    //通用的查询操作，用于返回数据表中的一条记录（V2.0:考虑事务）
    public <T> T getInstance(Connection connection,Class<T> clazz, String sql, Object... args) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[0]);
            }

            resultSet = preparedStatement.executeQuery();
            //获取结果集的元数据：ResultSetMetaData
            ResultSetMetaData rsmd = resultSet.getMetaData();
            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();

            if (resultSet.next()) {
                T t = clazz.newInstance();
                //处理结果集每一行数据中的每一列数据
                for (int i = 0; i < columnCount; i++) {
                    //获取列值：通过resultSet
                    Object columnValue = resultSet.getObject(i + 1);
//                    //获取每个列的列名：通过ResultSetMetaData--不推荐使用
//                    String columnName = rsmd.getColumnName(i + 1);
                    //获取列的别名：getColumnLabel()
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //给t对象指定的某个属性，赋值为value：通过反射
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, preparedStatement, resultSet);
        }
        return null;
    }


    //通用的查询操作，用于返回数据表中的多条记录返回的集合（V2.0:考虑事务）
    public <T> List<T> getForList(Connection connection,Class<T> clazz, String sql, Object... args) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[0]);
            }

            resultSet = preparedStatement.executeQuery();
            //获取结果集的元数据：ResultSetMetaData
            ResultSetMetaData rsmd = resultSet.getMetaData();
            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();
            //创建集合对象
            ArrayList<T> list = new ArrayList<>();
            while (resultSet.next()) {
                T t = clazz.newInstance();
                //处理结果集每一行数据中的每一列数据:给t对象指定的属性赋值
                for (int i = 0; i < columnCount; i++) {
                    //获取列值：通过resultSet
                    Object columnValue = resultSet.getObject(i + 1);
//                    //获取每个列的列名：通过ResultSetMetaData--不推荐使用
//                    String columnName = rsmd.getColumnName(i + 1);
                    //获取列的别名：getColumnLabel()
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //给t对象指定的某个属性，赋值为value：通过反射
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null, preparedStatement, resultSet);
        }
        return null;
    }

    //用于查询特殊值的通用方法
    public <E>E getValue(Connection connection,String sql,Object...args) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1,args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return (E) resultSet.getObject(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(null,preparedStatement,resultSet);
        }
        return null;
    }
}
