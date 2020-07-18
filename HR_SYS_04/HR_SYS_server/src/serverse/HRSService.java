package serverse;

import bean.ActionResult;
import bean.Resume;
import bean.ResumeList;
import database.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HRSService {
    public ActionResult addResume(Resume newResume) {
        ActionResult ar=new ActionResult();
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
        if (line >0 ){
            ar.isSuccess="Success";
        }else
        {
            ar.isSuccess="false";
            ar.failReason="unknow error";
        }

        return  ar;

    }

    public ActionResult deleteResuem(String id) {
        ActionResult ar=new ActionResult();

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
        if (line > 0 ){
            ar.isSuccess="Success";
        }else
        {
            ar.isSuccess="false";
            ar.failReason="unknow error";
        }

        return  ar;
    }

    public ActionResult selectResuemById(String id) {
        ActionResult ar=new ActionResult();
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
        if (rl.size()>0){
            ar.isSuccess="Success";
            ar.resultData = rl;
        }else {
            ar.isSuccess="false";
            ar.failReason="没有此人";
        }
        return  ar;
    }

    public ActionResult selectAllResuem() {
        ActionResult ar=new ActionResult();
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
        if (rl.size()>0){
            ar.isSuccess="Success";
            ar.resultData = rl;
        }else {
            ar.isSuccess="false";
            ar.failReason="简历为空";
        }
        return  ar;
    }

    public ActionResult selectResuemByName(String name) {
        ActionResult ar=new ActionResult();
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
        if (rl.size()>0){
            ar.isSuccess="Success";
            ar.resultData = rl;
        }else {
            ar.isSuccess="false";
            ar.failReason="没有此姓名";
        }
        return  ar;
    }

    public ActionResult selectResuemBySchool(String school) {
        ActionResult ar=new ActionResult();
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
        if (rl.size()>0){
            ar.isSuccess="Success";
            ar.resultData = rl;
        }else {
            ar.isSuccess="false";
            ar.failReason="该学校没人应聘";
        }
        return  ar;
    }

    public ActionResult updateResume(Resume resume, String id) {
        ActionResult ar=new ActionResult();
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
        if (line > 0 ){
            ar.isSuccess="Success";
        }else
        {
            ar.isSuccess="false";
            ar.failReason="unknow error";
        }
        return  ar;
    }
}
