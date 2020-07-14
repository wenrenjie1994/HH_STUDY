package service;

import bean.Resume;
import database.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class Action {

    public int addResume(Resume resume){
        int line =0;
        try{
            //创建数据库连接
            Connection con = DBConnection.getConnection();
            //Statement执行sql语句
            Statement statement=con.createStatement();
            //创建SQL语句
            String stringSql ="insert into resume values('"+resume.getName()+"','"+resume.getId()+"','"+resume.getSchool()+"','"+resume.getProcess()+"','"+resume.getDeleteStatus()+"')";
            line =statement.executeUpdate(stringSql);
            DBConnection.closeConnection(null,statement,con);
        }catch (SQLException e){
            System.out.println("SQL Exception:"+e.toString());
        }
        return line;
    }
    public int deleteResumeById(Resume resume){
        int line =0;
        try{
            Connection con =DBConnection.getConnection();
            Statement statement =con.createStatement();
            String stringSql ="delete from resume where id='"+resume.getId()+"'";
            line = statement.executeUpdate(stringSql);
            DBConnection.closeConnection(null,statement,con);
        }catch (SQLException e){
            System.out.println("SQL Exception:"+e.toString());
        }
        return line;
    }
    public int deleteResumeByName(Resume resume){
        int line =0;
        try{
            Connection con =DBConnection.getConnection();
            Statement statement =con.createStatement();
            String stringSql ="delete from resume where name='"+resume.getName()+"'";
            line = statement.executeUpdate(stringSql);
            DBConnection.closeConnection(null,statement,con);
        }catch (SQLException e){
            System.out.println("SQL Exception:"+e.toString());
        }
        return line;
    }
    public int updateResume(Resume resume,Resume oldResume){
        int line =0;
        try{
            Connection con =DBConnection.getConnection();
            Statement statement =con.createStatement();
            String stringSql ="UPDATE resume SET name='"+resume.getName()+"',id='"+resume.getId()+"',school='"+resume.getSchool()+"',process='"+resume.getProcess()+"',deleteStatus='"+resume.getDeleteStatus()+"'WHERE name='"+oldResume.getName()+"'";
            line = statement.executeUpdate(stringSql);
            DBConnection.closeConnection(null,statement,con);
        }catch (SQLException e){
            System.out.println("SQL Exception:"+e.toString());
        }
        return line;
    }
    public LinkedList<Resume> searchResumeById(Resume resume){
        LinkedList<Resume> list =new LinkedList<Resume>();
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
        }catch (SQLException e){
            System.out.println("SQL Exception:"+e.toString());
        }
        return list;
    }
    public LinkedList<Resume> searchResumeByName(Resume resume){
        LinkedList<Resume> list =new LinkedList<Resume>();
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
        }catch (SQLException e){
            System.out.println("SQL Exception:"+e.toString());
        }
        return list;
    }
    public LinkedList<Resume> searchResumeBySchool(Resume resume){
        LinkedList<Resume> list =new LinkedList<Resume>();
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
        }catch (SQLException e){
            System.out.println("SQL Exception:"+e.toString());
        }
        return list;
    }
}
