package com.caorui.dao;

import com.caorui.bean.Applicant;
import com.caorui.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;

public class ApplicantDao {
    public int insert(Applicant applicant) {

        int count = 0;
        //4、定义sql
        String name = applicant.getName();
        String id = applicant.getId();
        String sql = "insert into app values('" + name + "','" + id + "','" + applicant.getSchool() + "',0,1)";
        // 5、获取执行sql语句的对象 statement

        try (Connection conn = JDBCUtils.getConnection(); Statement statement = conn.createStatement();) {
            //6、执行sql。接收返回结果
            count = statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        // 7、处理结果
        return count;
    }

    public int delete(String id) {
        int count = 0;
        //4、定义sql
        //String sql = "delete from app where id='" + id + "'";
        String sql = "update  app set " + "deleteStatus= 0 where id='" + id + "'";
        // 5、获取执行sql语句的对象 statement
        try (Connection conn = JDBCUtils.getConnection(); Statement statement = conn.createStatement();) {
            //6、执行sql。接收返回结果
            count = statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        // 7、处理结果
        return count;
    }

    public int update(Applicant ap) {
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
        try (Connection conn = JDBCUtils.getConnection(); Statement statement = conn.createStatement();) {
            //6、执行sql。接收返回结果
            count = statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        // 7、处理结果
        return count;
    }

    public ArrayList<Applicant> queryId(String id) {
        ArrayList<Applicant> list=new ArrayList<>();
        Applicant app = null;
        int count = 0;
        //4、定义sql
        String sql = "select  * from app where id='" + id + "'";
        System.out.println(sql);
        // 5、获取执行sql语句的对象 statement
        try (Connection conn = JDBCUtils.getConnection();Statement statement = conn.createStatement();) {
            //6、执行sql。接收返回结果
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                app = new Applicant(rs.getString(1), rs.getString(2), rs.getString(3));
                app.setProcess(rs.getInt(4));
                app.setDeleteStatus(rs.getInt(5));
                list.add(app);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // 7、处理结果
        return list;
    }

    public ArrayList<Applicant> queryName(String name) {
        ArrayList<Applicant> list=new ArrayList<>();
        Applicant app = null;
        int count = 0;
        //4、定义sql
        String sql = "select  * from app where name='" + name + "'";
        System.out.println(sql);
        // 5、获取执行sql语句的对象 statement
        try (Connection conn = JDBCUtils.getConnection();Statement statement = conn.createStatement();) {
            //6、执行sql。接收返回结果
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                app = new Applicant(rs.getString(1), rs.getString(2), rs.getString(3));
                app.setProcess(rs.getInt(4));
                app.setDeleteStatus(rs.getInt(5));
                list.add(app);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // 7、处理结果
        return list;
    }

    public ArrayList<Applicant> querySchool(String school) {
        ArrayList<Applicant> list=new ArrayList<>();
        Applicant app = null;
        int count = 0;
        //4、定义sql
        String sql = "select  * from app where school='" + school + "'";
        System.out.println(sql);
        // 5、获取执行sql语句的对象 statement
        try (Connection conn = JDBCUtils.getConnection();Statement statement = conn.createStatement();) {
            //6、执行sql。接收返回结果
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                app = new Applicant(rs.getString(1), rs.getString(2), rs.getString(3));
                app.setProcess(rs.getInt(4));
                app.setDeleteStatus(rs.getInt(5));
                list.add(app);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // 7、处理结果
        return list;
    }

    public ArrayList<Applicant> queryProcess(int process) {
        ArrayList<Applicant> list=new ArrayList<>();
        Applicant app = null;
        int count = 0;
        //4、定义sql
        String sql = "select  * from app where process=" + process ;
        System.out.println(sql);
        // 5、获取执行sql语句的对象 statement
        try (Connection conn = JDBCUtils.getConnection();Statement statement = conn.createStatement();) {
            //6、执行sql。接收返回结果
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                app = new Applicant(rs.getString(1), rs.getString(2), rs.getString(3));
                app.setProcess(rs.getInt(4));
                app.setDeleteStatus(rs.getInt(5));
                list.add(app);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // 7、处理结果
        return list;
    }
}
