package dao;

import entity.Resume;
import util.DBUtil;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ResumeDao {
    public static int addResume(Resume resume){
        int line = 0;  //受影响行数
        try{
            Connection conn =  DBUtil.getConn();
            Statement statement =conn.createStatement();
            String stringSql = "insert into resume(name,school,position ) values('"+resume.getName()+"','"+resume.getSchool()+"','"+resume.getPosition()+"')";
            line=statement.executeUpdate(stringSql);
            DBUtil.closeConnection(null,statement,conn);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return line;
    }

    public static int deleteByCondition(Map<String,String> map){  //根据条件选择不同的列进行单项条件删除操作
        int line = 0;
        if(map.get("id")!=null){    //根据ID
            try{
                Connection conn =  DBUtil.getConn();
                Statement statement =conn.createStatement();
                String stringSql = "delete from resume where id = '"+map.get("id")+"'";
                line=statement.executeUpdate(stringSql);
                DBUtil.closeConnection(null,statement,conn);
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        else if(map.get("name")!=null){   //根据名字
            try{
                Connection conn =  DBUtil.getConn();
                Statement statement =conn.createStatement();
                String stringSql = "delete from resume where name = '"+map.get("name")+"'";
                line=statement.executeUpdate(stringSql);
                DBUtil.closeConnection(null,statement,conn);
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
        else{

        }
        return line;
    }

    public static int updateByCondition(Map<String,String> map,Resume resume) {  //根据条件选择不同的列进行单项条件更新操作
        int line = 0;
        if (map.get("id")!=null) {    //根据ID
            try {
                Connection conn = DBUtil.getConn();
                Statement statement = conn.createStatement();
                String stringSql = "UPDATE resume SET name = '" + resume.getName() + "', school='" + resume.getSchool() + "',position='" + resume.getPosition() + "' WHERE  id= '" + map.get("id") + "'";
                line = statement.executeUpdate(stringSql);
                DBUtil.closeConnection(null, statement, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (map.get("name")!=null) {   //根据名字
            try {
                Connection conn = DBUtil.getConn();
                Statement statement = conn.createStatement();
                String stringSql = "UPDATE resume SET name = '" + resume.getName() + "', school='" + resume.getSchool() + "',position='" + resume.getPosition() + "' WHERE  name= '" + map.get("name") + "'";
                line = statement.executeUpdate(stringSql);
                DBUtil.closeConnection(null, statement, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {

        }
        return line;
    }

    public static void searchAll(){
        LinkedList<Resume> resumesList = new LinkedList<>();
        try {
            Connection conn = DBUtil.getConn();
            Statement statement = conn.createStatement();
            String sql = "select * from resume ";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Resume resume = new Resume(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
                resumesList.add(resume);
            }
            System.out.println("该招聘岗位下共有"+resumesList.size()+"份简历");
            for(int i=1;i<=resumesList.size();i++) {
                System.out.println("第"+i+"份简历"+"---------"+"简历编号:"+resumesList.get(i-1).getId()+" 学生姓名："+resumesList.get(i-1).getName()+" 来自 "+resumesList.get(i-1).getSchool()+" 应聘职位是： "+resumesList.get(i-1).getPosition());
            }
            DBUtil.closeConnection(rs, statement, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static  LinkedList<Resume> searchByCondition(Map<String,String>map){
        LinkedList<Resume> resumesList = new LinkedList<>();
        if(map.get("id")!=null){
            try {
                Connection conn = DBUtil.getConn();
                Statement statement = conn.createStatement();
                String sql = "select * from resume where id='"+map.get("id")+"'";
                ResultSet rs = statement.executeQuery(sql);
                while(rs.next()){
                    Resume resume = new Resume(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
                    resumesList.add(resume);
                }
                DBUtil.closeConnection(rs, statement, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if(map.get("name")!=null){
            try {
                Connection conn = DBUtil.getConn();
                Statement statement = conn.createStatement();
                String sql = "select * from resume where name='"+map.get("name")+"'";
                ResultSet rs = statement.executeQuery(sql);
                while(rs.next()){
                    Resume resume = new Resume(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
                    resumesList.add(resume);
                }
                DBUtil.closeConnection(rs, statement, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if(map.get("school")!=null){
            try {
                Connection conn = DBUtil.getConn();
                Statement statement = conn.createStatement();
                String sql = "select * from resume where school='"+map.get("school")+"'";
                ResultSet rs = statement.executeQuery(sql);
                while(rs.next()){
                    Resume resume = new Resume(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
                    resumesList.add(resume);
                }
                DBUtil.closeConnection(rs, statement, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if(map.get("position")!=null){
            try {
                Connection conn = DBUtil.getConn();
                Statement statement = conn.createStatement();
                String sql = "select * from resume where position='"+map.get("position")+"'";
                ResultSet rs = statement.executeQuery(sql);
                while(rs.next()){
                    Resume resume = new Resume(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
                    resumesList.add(resume);
                }
                DBUtil.closeConnection(rs, statement, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resumesList;
    }
}
