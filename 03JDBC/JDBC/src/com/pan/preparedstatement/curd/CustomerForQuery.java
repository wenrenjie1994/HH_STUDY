package com.pan.preparedstatement.curd;

import com.pan.bean.Customer;
import com.pan.util.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;

/**
 * 针对Customers表的操作
 */
public class CustomerForQuery {

    @Test
    public void testQueryForCustomers(){
        String sql = "select id,name,email,birth from customers where id = ?";
        Customer customer = queryForCustomers(sql, 13);
        System.out.println(customer);

        String sql1 = "select name,email from customers where name = ?";
        Customer customer1 = queryForCustomers(sql1, "周杰伦");
        System.out.println(customer1);
    }


    /**
     * 针对customers表的通用查询操作
     */
    public Customer queryForCustomers(String sql,Object ...args){
        /*
        针对表的字段名与类的属性名不相同的情况：
        1.必须声明SQL时，使用类的属性名来命名字段的别名
        2.使用ResultSetMetaData时，需要使用getColumnLabel()来替换getColumnName(),获取列的别名
            说明：如果SQL中没有给字段起别名，getColumnLabel()获取的就是列名
         */

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1,args[0]);
            }

            resultSet = preparedStatement.executeQuery();
            //获取结果集的元数据：ResultSetMetaData
            ResultSetMetaData rsmd = resultSet.getMetaData();
            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();

            if(resultSet.next()){
                Customer customer = new Customer();
                //处理结果集每一行数据中的每一列数据
                for (int i = 0; i < columnCount; i++) {
                    //获取列值：通过resultSet
                    Object columnValue = resultSet.getObject(i + 1);
//                    //获取每个列的列名：通过ResultSetMetaData--不推荐使用
//                    String columnName = rsmd.getColumnName(i + 1);
                    //获取列的别名：getColumnLabel()
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //给customer对象指定的某个属性，赋值为value：通过反射
                    Field field = Customer.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(customer,columnValue);
                }
                return customer;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,preparedStatement,resultSet);
        }

        return null;

    }




    @Test
    public void testQuery1(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            //1.获取数据库的连接
            connection = JDBCUtils.getConnection();
            //2.预编译SQL语句，返回PreparedStatement的实例
            String sql = "select id,name,email,birth from customers where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            //3.填充占位符
            preparedStatement.setObject(1,1);

            //4.执行并返回结果集
            resultSet = preparedStatement.executeQuery();
            //5.处理结果集
            if (resultSet.next()) {//next()：判断结果集的下一条是否有数据，如果有数据返回true并指针下移，如果返回false，指针不会下移
                //获取当前这条数据各个字段值
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);

                //方式一：
                System.out.println("id=" + id);
                //方式二：
                Object[] data = new Object[]{id, name, email, birth};
                //方式三：将数据封装为一个对象（推荐）
                Customer customer = new Customer(id, name, email, birth);
                System.out.println(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //6.关闭资源
            JDBCUtils.closeResource(connection, preparedStatement, resultSet);
        }



    }

}
