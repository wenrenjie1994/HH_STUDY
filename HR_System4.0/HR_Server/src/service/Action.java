package service;

import database.DBConnection;
import model.OperatorResult;
import model.Resume;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class Action {
    public OperatorResult addResume(Resume resume){
        int line=0;
        OperatorResult operatorResult=new OperatorResult();
        try{
            Connection connection = new DBConnection().getConnection();
            Statement statement =connection.createStatement();
            String stringSql ="insert into resume values('"+resume.getName()+"','"+resume.getId()+"','"+resume.getSchool()+"','"+resume.getProcess()+"','"+resume.getDeleteStatus()+"')";
            line =statement.executeUpdate(stringSql);
            DBConnection.closeConnection(null,statement,connection);
        }catch (SQLException s){
            System.out.println("SQL Exception:"+ s.toString());
        }
        if(line>0){
            operatorResult.isSuccess="添加成功";
        }else{
            operatorResult.isSuccess="添加失败";
            operatorResult.failReason="未知错误";
        }
        return  operatorResult;
    }
    public OperatorResult deleteResumeById(Resume resume){
        int line =0;
        OperatorResult operatorResult =new OperatorResult();
        try{
            Connection con =DBConnection.getConnection();
            Statement statement =con.createStatement();
            String stringSql ="delete from resume where id='"+resume.getId()+"'";
            line = statement.executeUpdate(stringSql);
            DBConnection.closeConnection(null,statement,con);
        }catch (SQLException e){
            System.out.println("SQL Exception:"+e.toString());
        }
        if(line>0){
            operatorResult.isSuccess="通过身份证号码删除成功";
        }else{
            operatorResult.isSuccess="删除失败";
            operatorResult.failReason="没有找到该简历";
        }
        return operatorResult;
    }
    public OperatorResult deleteResumeByName(Resume resume){
        int line =0;
        OperatorResult operatorResult =new OperatorResult();
        try{
            Connection con =DBConnection.getConnection();
            Statement statement =con.createStatement();
            String stringSql ="delete from resume where name='"+resume.getName()+"'";
            line = statement.executeUpdate(stringSql);
            DBConnection.closeConnection(null,statement,con);
        }catch (SQLException e){
            System.out.println("SQL Exception:"+e.toString());
        }
        if(line>0){
            operatorResult.isSuccess="通过姓名删除成功";
        }else{
            operatorResult.isSuccess="删除失败";
            operatorResult.failReason="没有找到该简历";
        }
        return operatorResult;
    }
    public OperatorResult deleteResumeBySchool(Resume resume){
        int line =0;
        OperatorResult operatorResult =new OperatorResult();
        try{
            Connection con =DBConnection.getConnection();
            Statement statement =con.createStatement();
            String stringSql ="delete from resume where school='"+resume.getSchool()+"'";
            line = statement.executeUpdate(stringSql);
            DBConnection.closeConnection(null,statement,con);
        }catch (SQLException e){
            System.out.println("SQL Exception:"+e.toString());
        }
        if(line>0){
            operatorResult.isSuccess="通过学校删除成功";
        }else{
            operatorResult.isSuccess="删除失败";
            operatorResult.failReason="没有找到该简历";
        }
        return operatorResult;
    }
    //
    public OperatorResult updateResume(Resume resume,Resume oldResume){
        int line =0;
        OperatorResult operatorResult =new OperatorResult();
        try{
            Connection con =DBConnection.getConnection();
            Statement statement =con.createStatement();
            String stringSql ="UPDATE resume SET name='"+resume.getName()+"',id='"+resume.getId()+"',school='"+resume.getSchool()+"',process='"+resume.getProcess()+"',deleteStatus='"+resume.getDeleteStatus()+"'WHERE name='"+oldResume.getName()+"'";
            line = statement.executeUpdate(stringSql);
            DBConnection.closeConnection(null,statement,con);
        }catch (SQLException e){
            System.out.println("SQL Exception:"+e.toString());
        }
        if(line>0){
            operatorResult.isSuccess="更新成功";
        }else{
            operatorResult.isSuccess="更新失败";
            operatorResult.failReason="没有找到该简历";
        }
        return operatorResult;
    }
    public OperatorResult searchResumeById(Resume resume){
        LinkedList<Resume> list =new LinkedList<Resume>();
        OperatorResult operatorResult =new OperatorResult();
        try{
            Connection con =DBConnection.getConnection();
            Statement statement =con.createStatement();
            String stringSql ="select * from resume where id='"+resume.getId()+"'";
            ResultSet rs =statement.executeQuery(stringSql);
            while(rs.next())
            {
                Resume resume1=new Resume(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
                list.add(resume1);
            }
            DBConnection.closeConnection(rs,statement,con);
            if(list.size()>0){
                operatorResult.isSuccess="按照身份证号码查询成功";
                operatorResult.returnData=list;
            }else{
                operatorResult.isSuccess="查询失败";
                operatorResult.failReason="没有找到该简历";
            }
        }catch (SQLException e){
            System.out.println("SQL Exception:"+e.toString());
        }
        return operatorResult;
    }
    public OperatorResult searchResumeByName(Resume resume){
        LinkedList<Resume> list =new LinkedList<Resume>();
        OperatorResult operatorResult =new OperatorResult();
        try{
            Connection con =DBConnection.getConnection();
            Statement statement =con.createStatement();
            String stringSql ="select * from resume where name='"+resume.getName()+"'";
            ResultSet rs =statement.executeQuery(stringSql);
            while(rs.next())
            {
                Resume resume1=new Resume(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
                list.add(resume1);
            }
            DBConnection.closeConnection(rs,statement,con);
            if(list.size()>0){
                operatorResult.isSuccess="按照姓名查询成功";
                operatorResult.returnData=list;
            }else{
                operatorResult.isSuccess="查询失败";
                operatorResult.failReason="没有找到该简历";
            }
        }catch (SQLException e){
            System.out.println("SQL Exception:"+e.toString());
        }
        return operatorResult;
    }
    public OperatorResult searchResumeBySchool(Resume resume){
        LinkedList<Resume> list =new LinkedList<Resume>();
        OperatorResult operatorResult =new OperatorResult();
        try{
            Connection con =DBConnection.getConnection();
            Statement statement =con.createStatement();
            String stringSql ="select * from resume where school='"+resume.getSchool()+"'";
            ResultSet rs =statement.executeQuery(stringSql);
            while(rs.next())
            {
                Resume resume1=new Resume(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
                list.add(resume1);
            }
            DBConnection.closeConnection(rs,statement,con);
            if(list.size()>0){
                operatorResult.isSuccess="按照学校查询成功";
                operatorResult.returnData=list;
            }else{
                operatorResult.isSuccess="查询失败";
                operatorResult.failReason="没有找到该简历";
            }
        }catch (SQLException e){
            System.out.println("SQL Exception:"+e.toString());
        }
        return operatorResult;
    }


}
