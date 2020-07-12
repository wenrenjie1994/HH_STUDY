package com.caorui.service;

import com.caorui.bean.Applicant;

import java.sql.*;

public class ApplicantDao {

    public static Connection getConnection() {
        //1、导入驱动jar包  E:\java学习\黑马\08.JDBC(共30集)\code&资料\mysql-connector-java-5.1.7
        // 2、注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 3、获取connection连接
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/applicant", "root", "root");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    public int insert(Applicant applicant) {
        Connection conn = getConnection();
        int count = 0;
        //4、定义sql
        String name = applicant.getName();
        String id = applicant.getId();
        String sql = "insert into app values('" + name + "','" + id + "',null,0,1)";
        // 5、获取执行sql语句的对象 statement
        Statement statement = null;
        try {
            statement = conn.createStatement();
            //6、执行sql。接收返回结果
            count = statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // 释放资源
            try {
                statement.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        // 7、处理结果
        return count;
    }

    public int delete(String id) {
        Connection conn = getConnection();
        int count = 0;
        //4、定义sql
        //String sql = "delete from app where id='" + id + "'";
        String sql = "update  app set "+ "deleteStatus= 0 where id='" + id + "'";
        // 5、获取执行sql语句的对象 statement
        Statement statement = null;
        try {
            statement = conn.createStatement();
            //6、执行sql。接收返回结果
            count = statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // 释放资源
            try {
                statement.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        // 7、处理结果
        return count;
    }

    public int update(Applicant ap) {
        Connection conn = getConnection();
        int count = 0;
        String id = ap.getId();
        String school = ap.getSchool();
        String name = ap.getName();
        int process = ap.getProcess();
        int deleteStatus = ap.getDeleteStatus();
        //4、定义sql
        String sql = "update  app set name='" + name + "'" + "," +
                "school='" + school + "'" + "," +
                "process=" + process + "," +
                "deleteStatus=" + deleteStatus + " " +
                "where id='" + id + "'";
        System.out.println(sql);
        // 5、获取执行sql语句的对象 statement
        Statement statement = null;
        try {
            statement = conn.createStatement();
            //6、执行sql。接收返回结果
            count = statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // 释放资源
            try {
                statement.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        // 7、处理结果
        return count;
    }

    public Applicant queryId(String id) {
        Applicant app=null;
        Connection conn = getConnection();
        int count = 0;
        //4、定义sql
        String sql = "select  * from app where id='" + id + "'";
        System.out.println(sql);
        // 5、获取执行sql语句的对象 statement
        Statement statement = null;
        try {
            statement = conn.createStatement();
            //6、执行sql。接收返回结果
            ResultSet rs= statement.executeQuery(sql);
            if(rs.next()){
                id=rs.getString(2);
                String name=rs.getString(1);
                app=new Applicant(name,id);
                app.setSchool(rs.getString(3));
                app.setProcess(rs.getInt(4));
                app.setDeleteStatus(rs.getInt(5));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // 释放资源
            try {
                statement.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        // 7、处理结果
        return app;
    }

}
