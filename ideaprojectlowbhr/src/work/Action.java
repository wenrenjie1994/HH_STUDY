package work;

import bean.People;
import database.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Action {

    private static Connection conn = null;
    private static PreparedStatement ppst =null;
    private static ResultSet rst = null;

    //录入简历方法
    public static int addResume(People pp){
        int line = 0;
        String sql = "insert into resume values(?,?,?,?,?)";
        conn = ConnectionUtil.getConnection();
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setString(1,pp.getName());
            ppst.setString(2,pp.getId());
            ppst.setString(3,pp.getSchool());
            ppst.setInt(4,pp.getProcess());
            ppst.setInt(5,pp.getDeleteStatus());
            line = ppst.executeUpdate();
            ConnectionUtil.close(ppst,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return line;
    }

    //删除简历方法
    public static int deleteResume(String id){
        int line = 0;
        conn = ConnectionUtil.getConnection();
        String sql = "delete from resume where id = ?";
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setString(1,id);
            line = ppst.executeUpdate();
            ConnectionUtil.close(ppst,conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return line;
    }

    //查找数据库中所有简历方法
    public static List<People> searchAllResume(){
        List<People> list = new ArrayList<People>();
        conn = ConnectionUtil.getConnection();
        String sql = "select * from resume";
        try {
            ppst = conn.prepareStatement(sql);
            rst = ppst.executeQuery();
//            System.out.println(rst);
            while (rst.next()){
                People p = new People(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getInt(5));
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //根据学生姓名查找对应简历信息
    public static List<People> searchByName(String name){
        List<People> list = new ArrayList<People>();
        conn = ConnectionUtil.getConnection();
        String sql = "select * from resume where name = ?";
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setString(1,name);
            rst = ppst.executeQuery();
            while(rst.next()){
                People p = new People(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getInt(5));
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //根据学生身份证号查找对应简历信息
    public static List<People> searchById(String id){
        List<People> list = new ArrayList<People>();
        conn = ConnectionUtil.getConnection();
        String sql = "select * from resume where id= ?";
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setString(1,id);
            rst = ppst.executeQuery();
            while(rst.next()){
                People p = new People(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getInt(5));
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<People> searchByLikeName(String key) {
        List<People> list = new ArrayList<People>();
        conn = ConnectionUtil.getConnection();
        String sql = "select * from resume where name like ?";
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setString(1,"%"+key+"%");
            rst = ppst.executeQuery();
            while(rst.next()){
                People p = new People(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getInt(5));
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<People> searchByProcess(int process) {
        List<People> list = new ArrayList<People>();
        conn = ConnectionUtil.getConnection();
        String sql = "select * from resume where process= ?";
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setInt(1,process);
            rst = ppst.executeQuery();
            while(rst.next()){
                People p = new People(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getInt(5));
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<People> searchBySchool(String school) {
        List<People> list = new ArrayList<People>();
        conn = ConnectionUtil.getConnection();
        String sql = "select * from resume where school= ?";
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setString(1,school);
            rst = ppst.executeQuery();
            while(rst.next()){
                People p = new People(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getInt(5));
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int updateResume(People pp,String id) {
        int line = 0;
        conn = ConnectionUtil.getConnection();
        String sql = "update resume set name = ?,id = ?,school = ?,process = ?,deleteStatus = ? where id = ?";
        try {
            ppst = conn.prepareStatement(sql);
            ppst.setString(1,pp.getName());
            ppst.setString(2,pp.getId());
            ppst.setString(3,pp.getSchool());
            ppst.setInt(4,pp.getProcess());
            ppst.setInt(5,pp.getDeleteStatus());
            ppst.setString(6,id);
            line = ppst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return line;
    }
}
