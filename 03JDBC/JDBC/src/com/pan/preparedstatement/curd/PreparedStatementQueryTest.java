package com.pan.preparedstatement.curd;

import com.pan.bean.Customer;
import com.pan.util.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
使用PreparedStatement来实现针对于不同表的通用查询操作
 */
public class PreparedStatementQueryTest {

    @Test
    public void testGetForList(){
        String sql = "select id,name,email,birth from customers where id < ?";
        List<Customer> list = getForList(Customer.class, sql, 12);
        list.forEach(System.out::println);

    }

    public <T> List<T> getForList(Class<T> clazz, String sql, Object... args) {
        Connection connection = null;
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
            JDBCUtils.closeResource(connection, preparedStatement, resultSet);
        }

        return null;


    }


    @Test
    public void testGetInstance() {
        String sql = "select id,name,email,birth from customers where id = ?";
        Customer customer = getInstance(Customer.class, sql, 12);
        System.out.println(customer);
    }


    /**
     * 针对不同的表的通用的查询操作，返回表中的一条数据
     *
     * @param clazz
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> T getInstance(Class<T> clazz, String sql, Object... args) {
        Connection connection = null;
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
            JDBCUtils.closeResource(connection, preparedStatement, resultSet);
        }

        return null;

    }
}
