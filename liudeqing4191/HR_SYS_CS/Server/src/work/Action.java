package work;


import java.security.interfaces.RSAKey;
import java.sql.*;

import database.DBConnection ;
import model.*;

/**
 * @author liudeqing4191
 * @date 2020/07/16
 * @project HR_SYS_CS
 **/
public class Action {
    /*
     * 根据相应的操作向数据库传送SQL语句
     * 通过数据库返回的受影响行数（line）和（boolean）判断操作是否成功
     * line>0或者boolean=true为成功 令ar.isSuccess="Success
     * 查询图书的话令ActionResult.resultData=bookList;
     *  反之false 并设置ActionResult.failReason
     *
     * */
//template



    public ActionResult addResume(Resume resume){
        int line = 0;
        ActionResult ar=new ActionResult();
        try
        {
            Connection conn =  DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String stringSql = "insert into resume_list values('"+resume.getName()+"','"+resume.getId()+"','"+resume.getSchool()+
                    "',"+resume.getProcess()+","+resume.getDeleteStatus()+")";
            line=statement.executeUpdate(stringSql);
            DBConnection.closeConnection(null,statement,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        if(line>0)
        {
            ar.isSuccess="Success";
        }
        else
        {
            ar.isSuccess="false";
            ar.failReason="unknow error";
        }
        return ar;
    }

    public ActionResult deleteResume(Resume resume){
        int line=0;
        ActionResult ar=new ActionResult();
        try
        {
            Connection conn = DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String stringSql ="delete from resume_list where id = '"+resume.getId()+"'";
            line=statement.executeUpdate(stringSql);
            DBConnection.closeConnection(null,statement,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        if(line>0)
        {
            ar.isSuccess="Success";
        }
        else
        {
            ar.isSuccess="false";
            ar.failReason="没有找到该学生";
        }
        return ar;
    }

    public ActionResult updataResume(Resume resume){

        //偷懒
        String resumeId = resume.getId();
        String newName = resume.getName();
        String newSchool=resume.getSchool();
        int newProcess =resume.getProcess();
        int newDeleteStatus= resume.getDeleteStatus();

        int line=0;
        ActionResult ar=new ActionResult();
        try
        {
            Connection conn =  DBConnection.getConnection();
            String sql="update resume_list set name=?,school=?,process=?, delete_status=? where id=?";//sql语句
            PreparedStatement pstmt=conn.prepareStatement(sql);//创建接口对象
            pstmt.setString(1, newName);
            pstmt.setString(2, newSchool);
            pstmt.setInt(3, newProcess);
            pstmt.setInt(4,newDeleteStatus );
            pstmt.setString(5, resumeId);
            line=pstmt.executeUpdate();
            DBConnection.closeConnection(pstmt,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        if(line>0)
        {
            ar.isSuccess="Success";
        }
        else
        {
            ar.isSuccess="false";
            ar.failReason="没有找到该学生";
        }
        return ar;
    }


    public ActionResult searchResumeById(Resume resume){
        ResumeList resumes=new ResumeList();
        ActionResult ar=new ActionResult();
        try
        {

            Connection conn =  DBConnection.getConnection();
            String sql="select * from resume_list where id = ?";//sql语句
            PreparedStatement pstmt=conn.prepareStatement(sql);//创建接口对象
            pstmt.setString(1, resume.getId());
            ResultSet rs=pstmt.executeQuery();
            while(rs.next())
            {
                Resume aresume=new Resume(rs.getString(1),rs.getString(2));
                aresume.setSchool(rs.getString(3));
                aresume.setProcess(rs.getInt(4));
                aresume.setDeleteStatus(rs.getInt(5));

                resumes.add(aresume);
            }
            DBConnection.closeConnection(rs,pstmt,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        if(resumes.size()>0)
        {
            ar.isSuccess="Success";
            ar.resultData=resumes;
        }
        else
        {
            ar.isSuccess="false";
            ar.failReason="没有找到相关学生";
        }
        return ar;
    }
    public ActionResult searchResumeByName(Resume resume){
        ResumeList resumes=new ResumeList();
        ActionResult ar=new ActionResult();
        try
        {

            Connection conn =  DBConnection.getConnection();
            String sql="select * from resume_list where name = ?";//sql语句
            PreparedStatement pstmt=conn.prepareStatement(sql);//创建接口对象
            pstmt.setString(1, resume.getName());
            ResultSet rs=pstmt.executeQuery();
            while(rs.next())
            {
                Resume aresume=new Resume(rs.getString(1),rs.getString(2));
                aresume.setSchool(rs.getString(3));
                aresume.setProcess(rs.getInt(4));
                aresume.setDeleteStatus(rs.getInt(5));

                resumes.add(aresume);
            }
            DBConnection.closeConnection(rs,pstmt,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        if(resumes.size()>0)
        {
            ar.isSuccess="Success";
            ar.resultData=resumes;
        }
        else
        {
            ar.isSuccess="false";
            ar.failReason="没有找到相关学生";
        }
        return ar;
    }
    public ActionResult searchResumeBySchool(Resume resume){
        ResumeList resumes=new ResumeList();
        ActionResult ar=new ActionResult();
        try
        {

            Connection conn =  DBConnection.getConnection();
            String sql="select * from resume_list where school = ?";//sql语句
            PreparedStatement pstmt=conn.prepareStatement(sql);//创建接口对象
            pstmt.setString(1, resume.getSchool());
            ResultSet rs=pstmt.executeQuery();
            while(rs.next())
            {
                Resume aresume=new Resume(rs.getString(1),rs.getString(2));
                aresume.setSchool(rs.getString(3));
                aresume.setProcess(rs.getInt(4));
                aresume.setDeleteStatus(rs.getInt(5));

                resumes.add(aresume);
            }
            DBConnection.closeConnection(rs,pstmt,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        if(resumes.size()>0)
        {
            ar.isSuccess="Success";
            ar.resultData=resumes;
        }
        else
        {
            ar.isSuccess="false";
            ar.failReason="没有找到相关学生";
        }
        return ar;
    }
    public ActionResult searchResumeByProcess(Resume resume){
        ResumeList resumes=new ResumeList();
        ActionResult ar=new ActionResult();
        try
        {

            Connection conn =  DBConnection.getConnection();
            String sql="select * from resume_list where process = ?";//sql语句
            PreparedStatement pstmt=conn.prepareStatement(sql);//创建接口对象
            pstmt.setInt(1, resume.getProcess());
            ResultSet rs=pstmt.executeQuery();
            while(rs.next())
            {
                Resume aresume=new Resume(rs.getString(1),rs.getString(2));
                aresume.setSchool(rs.getString(3));
                aresume.setProcess(rs.getInt(4));
                aresume.setDeleteStatus(rs.getInt(5));

                resumes.add(aresume);
            }
            DBConnection.closeConnection(rs,pstmt,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        if(resumes.size()>0)
        {
            ar.isSuccess="Success";
            ar.resultData=resumes;
        }
        else
        {
            ar.isSuccess="false";
            ar.failReason="没有找到相关学生";
        }
        return ar;
    }
    public ActionResult searchResumeByKey(Resume resume){
        ResumeList resumes=new ResumeList();
        ActionResult ar=new ActionResult();
        try
        {

            Connection conn =  DBConnection.getConnection();
            String sql="select * from resume_list where name like '%"+resume.getName()+"%'";//sql语句
            PreparedStatement pstmt=conn.prepareStatement(sql);//创建接口对象
            ResultSet rs=pstmt.executeQuery();
            while(rs.next())
            {
                Resume aresume=new Resume(rs.getString(1),rs.getString(2));
                aresume.setSchool(rs.getString(3));
                aresume.setProcess(rs.getInt(4));
                aresume.setDeleteStatus(rs.getInt(5));

                resumes.add(aresume);
            }
            DBConnection.closeConnection(rs,pstmt,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        if(resumes.size()>0)
        {
            ar.isSuccess="Success";
            ar.resultData=resumes;
        }
        else
        {
            ar.isSuccess="false";
            ar.failReason="没有找到相关学生";
        }
        return ar;
    }


}
