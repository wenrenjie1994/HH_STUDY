package work;

import model.ActionResult;
import model.Resume;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 简历信息的数据库操作
 * @author 杜波
 * @version 创建时间: 2020/7/19 18:03
 */
public class ResumeWork
{
    /**
     * 向数据库中添加简历信息
     * @param resume
     */
    public ActionResult addResume(Resume resume)
    {
        ActionResult actionResult=new ActionResult();
        int line = 0;
        try
        {
            Connection conn =  DBConnection.getConnection();
            String sql = "insert into resume values(?,?,?,?,?)";
            // 根据sql语句创建PreparedStatement
            PreparedStatement ps=conn.prepareStatement(sql);
            // 设置参数
            ps.setString(1, resume.getResumeId());
            ps.setString(2, resume.getName());
            ps.setString(3, resume.getId());
            ps.setString(4, resume.getSchool());
            ps.setInt(5,resume.getProcess());
            // 执行
            line=ps.executeUpdate();
            DBConnection.closeConnection(null,ps,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        if (line!=1){
            actionResult.setIsSuccess(false);
            actionResult.setFailReason("unknow error");
        }else{
            actionResult.setIsSuccess(true);
        }
        return actionResult;
    }

    /**
     * 根据简历ID从数据库中删除简历
     * @param resumeId
     */
    public ActionResult deleteResumeByResumeId(String resumeId)
    {
        ActionResult actionResult=new ActionResult();
        int line=0;
        try
        {
            Connection conn =  DBConnection.getConnection();
            String sql = "delete from resume where resume_id=?";
            // 根据sql语句创建PreparedStatement
            PreparedStatement ps=conn.prepareStatement(sql);
            // 设置参数
            ps.setString(1, resumeId);
            // 执行
            line=ps.executeUpdate();
            DBConnection.closeConnection(null,ps,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        if (line==0){
            actionResult.setIsSuccess(false);
            actionResult.setFailReason("无数据可删!");
        }else{
            actionResult.setIsSuccess(true);
        }
        return actionResult;
    }

    /**
     * 根据简历姓名从数据库中删除简历
     * @param name
     */
    public ActionResult deleteResumeByName(String name)
    {
        ActionResult actionResult=new ActionResult();
        int line=0;
        try
        {
            Connection conn =  DBConnection.getConnection();
            String sql = "delete from resume where name=?";
            // 根据sql语句创建PreparedStatement
            PreparedStatement ps=conn.prepareStatement(sql);
            // 设置参数
            ps.setString(1, name);
            // 执行
            line=ps.executeUpdate();
            DBConnection.closeConnection(null,ps,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        if (line==0){
            actionResult.setIsSuccess(false);
            actionResult.setFailReason("无数据可删!");
        }else{
            actionResult.setIsSuccess(true);
        }
        return actionResult;
    }

    /**
     * 根据简历身份证号码从数据库中删除简历
     * @param id
     */
    public ActionResult deleteResumeById(String id)
    {
        ActionResult actionResult=new ActionResult();
        int line=0;
        try
        {
            Connection conn =  DBConnection.getConnection();
            String sql = "delete from resume where IDCard=?";
            // 根据sql语句创建PreparedStatement
            PreparedStatement ps=conn.prepareStatement(sql);
            // 设置参数
            ps.setString(1, id);
            // 执行
            line=ps.executeUpdate();
            DBConnection.closeConnection(null,ps,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        if (line==0){
            actionResult.setIsSuccess(false);
            actionResult.setFailReason("无数据可删!");
        }else{
            actionResult.setIsSuccess(true);
        }
        return actionResult;
    }

    /**
     * 根据简历学校名称从数据库中删除简历
     * @param school
     */
    public ActionResult deleteResumeBySchool(String school)
    {
        ActionResult actionResult=new ActionResult();
        int line=0;
        try
        {
            Connection conn =  DBConnection.getConnection();
            String sql = "delete from resume where school=?";
            // 根据sql语句创建PreparedStatement
            PreparedStatement ps=conn.prepareStatement(sql);
            // 设置参数
            ps.setString(1, school);
            // 执行
            line=ps.executeUpdate();
            DBConnection.closeConnection(null,ps,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        if (line==0){
            actionResult.setIsSuccess(false);
            actionResult.setFailReason("无数据可删!");
        }else{
            actionResult.setIsSuccess(true);
        }
        return actionResult;
    }

    /**
     * 根据简历状态从数据库中删除简历
     * @param process
     */
    public ActionResult deleteResumeByProcess(int process)
    {
        ActionResult actionResult=new ActionResult();
        int line=0;
        try
        {
            Connection conn =  DBConnection.getConnection();
            String sql = "delete from resume where process=?";
            // 根据sql语句创建PreparedStatement
            PreparedStatement ps=conn.prepareStatement(sql);
            // 设置参数
            ps.setInt(1, process);
            // 执行
            line=ps.executeUpdate();
            DBConnection.closeConnection(null,ps,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        System.out.println("6");
        if (line==0){
            actionResult.setIsSuccess(false);
            actionResult.setFailReason("无数据可删!");
        }else{
            actionResult.setIsSuccess(true);
        }
        return actionResult;
    }

    /**
     * 根据简历ID修改该简历的姓名
     * @param resume
     */
    public ActionResult updateResumeName(Resume resume)
    {
        ActionResult actionResult=new ActionResult();
        int line=0;
        try
        {
            Connection conn =  DBConnection.getConnection();
            String sql = "update resume set name=? where resume_id=?";
            // 根据sql语句创建PreparedStatement
            PreparedStatement ps=conn.prepareStatement(sql);
            // 设置参数
            ps.setString(1, resume.getName());
            ps.setString(2, resume.getResumeId());
            // 执行
            line=ps.executeUpdate();
            if (line==0){
                actionResult.setIsSuccess(false);
                actionResult.setFailReason("修改失败，无数据可修改!");
            }else{
                actionResult.setIsSuccess(true);
            }
            DBConnection.closeConnection(null,ps,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return actionResult;
    }

    /**
     * 根据简历ID修改该简历的身份证号码
     * @param resume
     */
    public ActionResult updateResumeIdCard(Resume resume)
    {
        ActionResult actionResult=new ActionResult();
        int line=0;
        try
        {
            Connection conn =  DBConnection.getConnection();
            String sql = "update resume set IDCard=? where resume_id=?";
            // 根据sql语句创建PreparedStatement
            PreparedStatement ps=conn.prepareStatement(sql);
            // 设置参数
            ps.setString(1, resume.getId());
            ps.setString(2, resume.getResumeId());
            // 执行
            line=ps.executeUpdate();
            if (line==0){
                actionResult.setIsSuccess(false);
                actionResult.setFailReason("修改失败，无数据可修改!");
            }else{
                actionResult.setIsSuccess(true);
            }
            DBConnection.closeConnection(null,ps,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return actionResult;
    }

    /**
     * 根据简历ID修改该简历的学校名称
     * @param resume
     */
    public ActionResult updateResumeSchool(Resume resume)
    {
        ActionResult actionResult=new ActionResult();
        int line=0;
        try
        {
            Connection conn =  DBConnection.getConnection();
            String sql = "update resume set school=? where resume_id=?";
            // 根据sql语句创建PreparedStatement
            PreparedStatement ps=conn.prepareStatement(sql);
            // 设置参数
            ps.setString(1, resume.getSchool());
            ps.setString(2, resume.getResumeId());
            // 执行
            line=ps.executeUpdate();
            if (line==0){
                actionResult.setIsSuccess(false);
                actionResult.setFailReason("修改失败，无数据可修改!");
            }else{
                actionResult.setIsSuccess(true);
            }
            DBConnection.closeConnection(null,ps,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return actionResult;
    }

    /**
     * 根据简历ID修改该简历的状态
     * @param resume
     * @return
     */
    public ActionResult updateResumeProcess(Resume resume)
    {
        ActionResult actionResult=new ActionResult();
        int line=0;
        try
        {
            Connection conn =  DBConnection.getConnection();
            String sql = "update resume set process=? where resume_id=?";
            // 根据sql语句创建PreparedStatement
            PreparedStatement ps=conn.prepareStatement(sql);
            // 设置参数
            ps.setInt(1, resume.getProcess());
            ps.setString(2, resume.getResumeId());
            // 执行
            line=ps.executeUpdate();
            if (line==0){
                actionResult.setIsSuccess(false);
                actionResult.setFailReason("修改失败，无数据可修改!");
            }else{
                actionResult.setIsSuccess(true);
            }
            DBConnection.closeConnection(null,ps,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return actionResult;
    }

    /**
     * 根据简历ID修改该简历的姓名、身份证号码、学校名称、简历状态
     * @param resume
     * @return
     */
    public ActionResult updateResumeAll(Resume resume)
    {
        ActionResult actionResult=new ActionResult();
        int line=0;
        try
        {
            Connection conn =  DBConnection.getConnection();
            String sql = "update resume set name=?,IDCard=?,school=?,process=? where resume_id=?";
            // 根据sql语句创建PreparedStatement
            PreparedStatement ps=conn.prepareStatement(sql);
            // 设置参数
            ps.setString(1, resume.getName());
            ps.setString(2, resume.getId());
            ps.setString(3, resume.getSchool());
            ps.setInt(4, resume.getProcess());
            ps.setString(5, resume.getResumeId());
            // 执行
            line=ps.executeUpdate();
            if (line==0){
                actionResult.setIsSuccess(false);
                actionResult.setFailReason("修改失败，无数据可修改!");
            }else{
                actionResult.setIsSuccess(true);
            }
            DBConnection.closeConnection(null,ps,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return actionResult;
    }

    /**
     * 根据简历姓名从数据库中查询简历信息
     * @param name
     */
    public ActionResult queryResumeByName(String name)
    {
        ActionResult actionResult=new ActionResult();
        try
        {
            Connection conn =  DBConnection.getConnection();
            String sql = "select * from resume where name=?";
            // 根据sql语句创建PreparedStatement
            PreparedStatement ps=conn.prepareStatement(sql);
            // 设置参数
            ps.setString(1, name);
            // 执行
            ResultSet rs = ps.executeQuery();
            ArrayList<Resume> list=new ArrayList<>();
            if(rs.next()){
                do{
                    Resume resume=new Resume(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
                    list.add(resume);
                }while (rs.next());
                actionResult.setIsSuccess(true);
                actionResult.setResultData(list);
            }else {
                actionResult.setIsSuccess(false);
                actionResult.setFailReason("暂无相关简历数据!");
            }
            DBConnection.closeConnection(rs,ps,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return actionResult;
    }

    /**
     * 根据简历身份证号码从数据库中查询简历信息
     * @param id
     */
    public ActionResult queryResumeById(String  id)
    {
        ActionResult actionResult=new ActionResult();
        try
        {
            Connection conn =  DBConnection.getConnection();
            String sql = "select * from resume where IDCard=?";
            // 根据sql语句创建PreparedStatement
            PreparedStatement ps=conn.prepareStatement(sql);
            // 设置参数
            ps.setString(1, id);
            // 执行
            ResultSet rs = ps.executeQuery();
            ArrayList<Resume> list=new ArrayList<>();
            if(rs.next()){
                do{
                    Resume resume=new Resume(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
                    list.add(resume);
                }while (rs.next());
                actionResult.setIsSuccess(true);
                actionResult.setResultData(list);
            }else {
                actionResult.setIsSuccess(false);
                actionResult.setFailReason("暂无相关简历数据!");
            }
            DBConnection.closeConnection(rs,ps,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return actionResult;
    }

    /**
     * 根据简历学校名称从数据库中查询简历信息
     * @param school
     */
    public ActionResult queryResumeBySchool(String school)
    {
        ActionResult actionResult=new ActionResult();
        try
        {
            Connection conn =  DBConnection.getConnection();
            String sql = "select * from resume where school=?";
            // 根据sql语句创建PreparedStatement
            PreparedStatement ps=conn.prepareStatement(sql);
            // 设置参数
            ps.setString(1, school);
            // 执行
            ResultSet rs = ps.executeQuery();
            ArrayList<Resume> list=new ArrayList<>();
            if(rs.next()){
                do{
                    Resume resume=new Resume(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
                    list.add(resume);
                }while (rs.next());
                actionResult.setIsSuccess(true);
                actionResult.setResultData(list);
            }else {
                actionResult.setIsSuccess(false);
                actionResult.setFailReason("暂无相关简历数据!");
            }
            DBConnection.closeConnection(rs,ps,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return actionResult;
    }

    /**
     * 根据简历状态从数据库中查询简历信息
     * @param process
     */
    public ActionResult queryResumeByProcess(int process)
    {
        ActionResult actionResult=new ActionResult();
        try
        {
            Connection conn =  DBConnection.getConnection();
            String sql = "select * from resume where process=?";
            // 根据sql语句创建PreparedStatement
            PreparedStatement ps=conn.prepareStatement(sql);
            // 设置参数
            ps.setInt(1, process);
            // 执行
            ResultSet rs = ps.executeQuery();
            ArrayList<Resume> list=new ArrayList<>();
            if(rs.next()){
                do{
                    Resume resume=new Resume(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
                    list.add(resume);
                }while (rs.next());
                actionResult.setIsSuccess(true);
                actionResult.setResultData(list);
            }else {
                actionResult.setIsSuccess(false);
                actionResult.setFailReason("暂无相关简历数据!");
            }
            DBConnection.closeConnection(rs,ps,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return actionResult;
    }

    /**
     * 从数据库中查询所有简历信息
     */
    public ActionResult queryResumeAll()
    {
        ActionResult actionResult=new ActionResult();
        try
        {
            Connection conn =  DBConnection.getConnection();
            String sql = "select * from resume";
            // 根据sql语句创建PreparedStatement
            PreparedStatement ps=conn.prepareStatement(sql);
            // 执行
            ResultSet rs = ps.executeQuery();
            ArrayList<Resume> list=new ArrayList<>();
            if(rs.next()){
                do{
                    Resume resume=new Resume(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
                    list.add(resume);
                }while (rs.next());
                actionResult.setIsSuccess(true);
                actionResult.setResultData(list);
            }else {
                actionResult.setIsSuccess(false);
                actionResult.setFailReason("暂无相关简历数据!");
            }
            DBConnection.closeConnection(rs,ps,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return actionResult;
    }
}
