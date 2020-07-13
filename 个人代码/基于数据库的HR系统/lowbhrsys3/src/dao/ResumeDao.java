package dao;

import model.Resume;
import util.DBConnection;
import java.sql.*;

public class ResumeDao
{
    //****************************简历添加方法**************************
    //添加简历信息方法。
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
    //****************************简历删除方法**************************
    //1.通过简历ID删除
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
    //2.通过姓名删除
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
    //3.通过身份证号删除
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
    //4.通过学校名称删除
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
    //5.通过简历状态删除
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
    //****************************简历修改方法**************************
    //1.修改简历姓名。
    public int updateResumeName(Resume resume)
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
        return line;
    }
    //2.修改简历身份证
    public int updateResumeIDCard(Resume resume)
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
        return line;
    }
    //3.修改简历学校
    public int updateResumeSchool(Resume resume)
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
        return line;
    }
    //4.修改简历状态
    public int updateResumeProcess(Resume resume)
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
        return line;
    }
    //5.修改简历所有信息
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
    //****************************简历查询方法**************************
    //1.通过姓名查询
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
    //2.通过身份证号查询
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
    //3.通过学校名称查询
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
    //4.通过简历状态查询
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
    //5.查询所有
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
