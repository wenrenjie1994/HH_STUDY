package dao;

import model.Resume;
import util.DBConnection;
import java.sql.*;

/**
 * 简历信息的数据库操作
 * @author 杜波
 * @version 创建时间: 2020/7/13 13:10
 */
public class ResumeDao
{
    /**
     * 向数据库中添加简历信息
     * @param resume
     */
    public void addResume(Resume resume)
    {
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
            System.out.println("添加失败!");
        }else{
            System.out.println("添加成功!");
        }
    }

    /**
     * 根据简历ID从数据库中删除简历
     * @param resumeId
     */
    public void deleteResumeByResumeId(String resumeId)
    {
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
            System.out.println("无数据可删!");
        }else{
            System.out.println("删除成功!");
        }

    }

    /**
     * 根据简历姓名从数据库中删除简历
     * @param name
     */
    public void deleteResumeByName(String name)
    {
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
            System.out.println("无数据可删!");
        }else{
            System.out.println("删除成功!");
        }
    }

    /**
     * 根据简历身份证号码从数据库中删除简历
     * @param id
     */
    public void deleteResumeById(String id)
    {
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
            System.out.println("无数据可删!");
        }else{
            System.out.println("删除成功!");
        }
    }

    /**
     * 根据简历学校名称从数据库中删除简历
     * @param school
     */
    public void deleteResumeBySchool(String school)
    {
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
            System.out.println("无数据可删!");
        }else{
            System.out.println("删除成功!");
        }
    }

    /**
     * 根据简历状态从数据库中删除简历
     * @param process
     */
    public void deleteResumeByProcess(int process)
    {
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
            System.out.println("无数据可删!");
        }else{
            System.out.println("删除成功!");
        }
    }

    /**
     * 根据简历ID修改该简历的姓名
     * @param resume
     */
    public void updateResumeName(Resume resume)
    {
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
                System.out.println("修改失败，无数据可修改!");
            }else{
                System.out.println("修改成功!");
            }
            DBConnection.closeConnection(null,ps,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
    }

    /**
     * 根据简历ID修改该简历的身份证号码
     * @param resume
     */
    public void updateResumeIdCard(Resume resume)
    {
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
                System.out.println("修改失败，无数据可修改!");
            }else{
                System.out.println("修改成功!");
            }
            DBConnection.closeConnection(null,ps,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
    }

    /**
     * 根据简历ID修改该简历的学校名称
     * @param resume
     */
    public void updateResumeSchool(Resume resume)
    {
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
                System.out.println("修改失败，无数据可修改!");
            }else{
                System.out.println("修改成功!");
            }
            DBConnection.closeConnection(null,ps,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
    }

    /**
     * 根据简历ID修改该简历的状态
     * @param resume
     * @return
     */
    public void updateResumeProcess(Resume resume)
    {
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
                System.out.println("修改失败，无数据可修改!");
            }else{
                System.out.println("修改成功!");
            }
            DBConnection.closeConnection(null,ps,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
    }

    /**
     * 根据简历ID修改该简历的姓名、身份证号码、学校名称、简历状态
     * @param resume
     * @return
     */
    public int updateResumeAll(Resume resume)
    {
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
                System.out.println("修改失败，无数据可修改!");
            }else{
                System.out.println("修改成功!");
            }
            DBConnection.closeConnection(null,ps,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return line;
    }

    /**
     * 根据简历姓名从数据库中查询简历信息
     * @param name
     */
    public void queryResumeByName(String name)
    {
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
            System.out.println("查询结果如下:");
            if (rs.next()) {
                System.out.println("简历ID  姓名  身份证号  学校名称  简历状态");
                do{
                    System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getInt(5));
                } while(rs.next());
            }else{
                System.out.println("无数据！");
            }
            DBConnection.closeConnection(rs,ps,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
    }

    /**
     * 根据简历身份证号码从数据库中查询简历信息
     * @param id
     */
    public void queryResumeById(String  id)
    {
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
            System.out.println("查询结果如下:");
            if (rs.next()) {
                System.out.println("简历ID  姓名  身份证号  学校名称  简历状态");
                do{
                    System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getInt(5));
                } while(rs.next());
            }else{
                System.out.println("无数据！");
            }
            DBConnection.closeConnection(rs,ps,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
    }

    /**
     * 根据简历学校名称从数据库中查询简历信息
     * @param school
     */
    public void queryResumeBySchool(String school)
    {
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
            System.out.println("查询结果如下:");
            if (rs.next()) {
                System.out.println("简历ID  姓名  身份证号  学校名称  简历状态");
                do{
                    System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getInt(5));
                } while(rs.next());
            }else{
                System.out.println("无数据！");
            }
            DBConnection.closeConnection(rs,ps,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
    }

    /**
     * 根据简历状态从数据库中查询简历信息
     * @param process
     */
    public void queryResumeByProcess(int process)
    {
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
            System.out.println("查询结果如下:");
            if (rs.next()) {
                System.out.println("简历ID  姓名  身份证号  学校名称  简历状态");
                do{
                    System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getInt(5));
                } while(rs.next());
            }else{
                System.out.println("无数据！");
            }
            DBConnection.closeConnection(rs,ps,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
    }

    /**
     * 从数据库中查询所有简历信息
     */
    public void queryResumeAll()
    {
        try
        {
            Connection conn =  DBConnection.getConnection();
            String sql = "select * from resume";
            // 根据sql语句创建PreparedStatement
            PreparedStatement ps=conn.prepareStatement(sql);
            // 执行
            ResultSet rs = ps.executeQuery();
            System.out.println("查询结果如下:");
            if (rs.next()) {
                System.out.println("简历ID  姓名  身份证号  学校名称  简历状态");
                do{
                    System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getInt(5));
                } while(rs.next());
            }else{
                System.out.println("无数据！");
            }
            DBConnection.closeConnection(rs,ps,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
    }
}
