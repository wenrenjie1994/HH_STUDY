package sys;

import bean.Resume;
import bean.ResumeList;
import database.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HRSService {
    public int addResume(Resume newResume) {
        int line = 0 ;
        String sql = "insert into resume values ('"+newResume.getName()+"','"+newResume.getId()+"','"+newResume.getSchool()+"','"+newResume.getProcess()+"','"+newResume.getDeleteStatus()+"')";

        try {
            Connection conn = DBManager.getConnection();
            Statement statement = null;
            statement = conn.createStatement();
            line = statement.executeUpdate(sql);
            DBManager.closeConnection(conn,statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  line;

    }

    public int deleteResuem(String id) {

        ResumeList resumeList = selectResuemById(id);
        if (resumeList.size()==0){
            System.out.println("没有该用户");
            return 0;
        }
        int line = 0 ;
        String sql = "delete from resume where id = '"+id+"'";

        try {
            Connection conn = DBManager.getConnection();
            Statement statement = null;
            statement = conn.createStatement();
            line = statement.executeUpdate(sql);
            DBManager.closeConnection(conn,statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  line;
    }

    public ResumeList selectResuemById(String id) {

        String sql = "select * from resume where id = '"+id+"'";
        ResumeList rl = new ResumeList();
        try {
            Connection conn = DBManager.getConnection();
            Statement statement = null;
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                Resume resume = new Resume(rs.getString("name"),rs.getString("id"),rs.getString("school"));
                rl.add(resume);
            }
            DBManager.closeConnection(conn,statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rl;
    }

    public ResumeList selectAllResuem() {
        String sql = "select *  from resume";
        ResumeList rl = new ResumeList();
        try {
            Connection conn = DBManager.getConnection();
            Statement statement = null;
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                Resume resume = new Resume(rs.getString("name"),rs.getString("id"),rs.getString("school"));
                rl.add(resume);
            }
            DBManager.closeConnection(conn,statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rl;
    }

    public ResumeList selectResuemByName(String name) {
        String sql = "select *  from resume where name = '"+name+"'";
        ResumeList rl = new ResumeList();
        try {
            Connection conn = DBManager.getConnection();
            Statement statement = null;
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                Resume resume = new Resume(rs.getString("name"),rs.getString("id"),rs.getString("school"));
                rl.add(resume);
            }
            DBManager.closeConnection(conn,statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rl;
    }

    public ResumeList selectResuemBySchool(String school) {
        String sql = "select * from resume where school = '"+school+"'";
        ResumeList rl = new ResumeList();
        try {
            Connection conn = DBManager.getConnection();
            Statement statement = null;
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                Resume resume = new Resume(rs.getString("name"),rs.getString("id"),rs.getString("school"));
                rl.add(resume);
            }
            DBManager.closeConnection(conn,statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rl;
    }

    public int updataResuem(Resume resume,String id) {
        int line = 0 ;
        String sql = "update resume SET name ='"+resume.getName()+"',id ='"+
                resume.getId()+"',school='"+resume.getSchool()+"' where id = '"+id+"'";

        try {
            Connection conn = DBManager.getConnection();
            Statement statement = null;
            statement = conn.createStatement();
            line = statement.executeUpdate(sql);
            DBManager.closeConnection(conn,statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  line;
    }
}
