package dao;

import entity.Resume;
import entity.ReturnResult;
import util.DBUtil;

import java.sql.*;
import java.util.LinkedList;
import java.util.Map;

public class ResumeDao {
    public static ReturnResult addResume(Resume resume){
        int line = 0;  //受影响行数
        ReturnResult rr = new ReturnResult();
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
        if(line>0){
            rr.isSuccess=true;
        }
        else{
            rr.isSuccess=false;
            rr.failReason = "Unknown error ";
        }
        return rr;
    }

    public static ReturnResult deleteByCondition(Map<String,String> map){  //根据条件选择不同的列进行单项条件删除操作
        int line = 0;
        ReturnResult rr = new ReturnResult();
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

            if(line>0){
                rr.isSuccess=true;
            }
            else{
                rr.isSuccess=false;
                rr.failReason = "Can not find the resume ";
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

            if(line>0){
                rr.isSuccess=true;
            }
            else{
                rr.isSuccess=false;
                rr.failReason = "Can not find the resume ";
            }
        }
        else{

        }
        return rr;
    }

    public static ReturnResult updateByCondition(Map<String,String> map,Resume resume) {  //根据条件选择不同的列进行单项条件更新操作
        int line = 0;
        ReturnResult rr = new ReturnResult();
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
            if(line>0){
                rr.isSuccess=true;
            }
            else{
                rr.isSuccess=false;
                rr.failReason = "Can not find the resume ";
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

            if(line>0){
                rr.isSuccess=true;
            }
            else{
                rr.isSuccess=false;
                rr.failReason = "Can not find the resume ";
            }
        } else {

        }
        return rr;
    }

    public static ReturnResult searchAll(){
        ReturnResult rr = new ReturnResult();
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

            DBUtil.closeConnection(rs, statement, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(resumesList.size()>0){
            rr.isSuccess=true;
            rr.resultData=resumesList;
        }
        else{
            rr.isSuccess=false;
            rr.failReason = "No resume ";
        }
        return  rr;
    }

    public static  ReturnResult searchByCondition(Map<String,String>map){
        ReturnResult rr = new ReturnResult();
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

            if(resumesList.size()>0){
                rr.isSuccess=true;
                rr.resultData=resumesList;
            }
            else{
                rr.isSuccess=false;
                rr.failReason = "Can not find the resume ";
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

            if(resumesList.size()>0){
                rr.isSuccess=true;
                rr.resultData=resumesList;
            }
            else{
                rr.isSuccess=false;
                rr.failReason = "Can not find the resume ";
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

            if(resumesList.size()>0){
                rr.isSuccess=true;
                rr.resultData=resumesList;
            }
            else{
                rr.isSuccess=false;
                rr.failReason = "Can not find the resume ";
            }
        }
        return rr;
    }
}
