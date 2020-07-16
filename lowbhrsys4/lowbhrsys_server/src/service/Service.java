package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Interviewee;
import model.IntervieweeList;
import model.ServiceResult;
import DB.DBConnection;

public class Service {
    // 添加面试者
    public ServiceResult addInterviewee(Interviewee interviewee){
        int line = 0;
        ServiceResult sr = new ServiceResult();
        try{
            Connection conn = DBConnection.getConnection();
            Statement statement = conn.createStatement();
            String sql = "insert into interviewee (name,age,id,school,position) values('"+interviewee.getName()+"','"+interviewee.getAge()+"','"+interviewee.getID()+"','"+interviewee.getSchool()+"','"+interviewee.getPosition()+"')";
            line = statement.executeUpdate(sql);
            DBConnection.closeConnection(null,statement,conn);
        } catch (SQLException e){
            System.out.println("SQL Exception:"+e.toString());
        }
        if(line > 0){
            sr.isSuccess = "Success";
        }
        else{
            sr.isSuccess="False";
            sr.failReason="Unknown error";
        }
        return sr;
    }

    // 删除面试者
    public ServiceResult deleteIntervieweeByName(String name){
        int line = 0;
        ServiceResult sr = new ServiceResult();
        try{
            Connection conn = DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String sql = "delete from interviewee where name = '"+name+"'";
            line = statement.executeUpdate(sql);
            DBConnection.closeConnection(null,statement,conn);
        } catch (SQLException e){
            System.out.println("SQL Exception:"+e.toString());
        }
        if(line > 0){
            sr.isSuccess = "Success";
        }
        else{
            sr.isSuccess="False";
            sr.failReason="未找到面试者";
        }
        return sr;
    }

    public ServiceResult deleteIntervieweeByID(String ID){
        int line = 0;
        ServiceResult sr = new ServiceResult();
        try{
            Connection conn = DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String sql = "delete from interviewee where id = '"+ID+"'";
            line = statement.executeUpdate(sql);
            DBConnection.closeConnection(null,statement,conn);
        } catch (SQLException e){
            System.out.println("SQL Exception:"+e.toString());
        }
        if(line > 0){
            sr.isSuccess = "Success";
        }
        else{
            sr.isSuccess="False";
            sr.failReason="未找到面试者";
        }
        return sr;
    }

    // 修改面试者信息
    public ServiceResult modifyInterviewee(Interviewee interviewee){
        int line = 0;
        ServiceResult sr = new ServiceResult();
        try{
            Connection conn = DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String sql = "update interviewee set name = '"+interviewee.getName()+"',age = '"+interviewee.getAge()+"',school = '"+interviewee.getSchool()+"',position = '"+interviewee.getPosition()+"'where id = '"+interviewee.getID()+"'";
            line = statement.executeUpdate(sql);
            DBConnection.closeConnection(null,statement,conn);
        } catch (SQLException e){
            System.out.println("SQL Exception:"+e.toString());
        }
        if(line > 0){
            sr.isSuccess = "Success";
        }
        else{
            sr.isSuccess="False";
            sr.failReason="未找到面试者";
        }
        return sr;
    }

    // 查询面试者
    public ServiceResult findIntervieweeByName(String name){
        IntervieweeList iList = new IntervieweeList();
        ServiceResult sr = new ServiceResult();
        try{
            Connection conn =  DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String sql = "select * from interviewee where name='"+name+"'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Interviewee interviewee = new Interviewee(rs.getString("name"),rs.getInt("age"),rs.getString("school"),rs.getString("id"),rs.getString("position"));
                iList.add(interviewee);
            }
            DBConnection.closeConnection(rs,statement,conn);
        } catch (SQLException e){
            System.out.println("SQL Exception:"+e.toString());
        }
        int size = iList.size();
        if(size > 0){
            sr.isSuccess = "Success";
            sr.resultData = iList;
        }
        else{
            sr.isSuccess = "False";
            sr.failReason = "未找到面试者";
        }
        return sr;
    }

    public ServiceResult findIntervieweeBySchool(String school){
        IntervieweeList iList = new IntervieweeList();
        ServiceResult sr = new ServiceResult();
        try{
            Connection conn =  DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String sql = "select * from interviewee where school='"+school+"'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Interviewee interviewee = new Interviewee(rs.getString("name"),rs.getInt("age"),rs.getString("school"),rs.getString("id"),rs.getString("position"));
                iList.add(interviewee);
            }
            DBConnection.closeConnection(rs,statement,conn);
        } catch (SQLException e){
            System.out.println("SQL Exception:"+e.toString());
        }
        int size = iList.size();
        if(size > 0){
            sr.isSuccess = "Success";
            sr.resultData = iList;
        }
        else{
            sr.isSuccess = "False";
            sr.failReason = "未找到面试者";
        }
        return sr;
    }

    public ServiceResult findIntervieweeByPosition(String position){
        IntervieweeList iList = new IntervieweeList();
        ServiceResult sr = new ServiceResult();
        try{
            Connection conn =  DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String sql = "select * from interviewee where position='"+position+"'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Interviewee interviewee = new Interviewee(rs.getString("name"),rs.getInt("age"),rs.getString("school"),rs.getString("id"),rs.getString("position"));
                iList.add(interviewee);
            }
            DBConnection.closeConnection(rs,statement,conn);
        } catch (SQLException e){
            System.out.println("SQL Exception:"+e.toString());
        }
        int size = iList.size();
        if(size > 0){
            sr.isSuccess = "Success";
            sr.resultData = iList;
        }
        else{
            sr.isSuccess = "False";
            sr.failReason = "未找到面试者";
        }
        return sr;
    }
}
