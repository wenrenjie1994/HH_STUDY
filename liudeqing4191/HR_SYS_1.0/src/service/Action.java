package service;

import java.sql.*;

import dataBase.DBConnection;
import model.Resume;
import model.ResumeList;

/**
 * @author liudeqing4191
 * @date 2020/07/10
 * @project HR_SYS_1.0
 **/
public class Action {
    //添加简历
    public int addResume(Resume resume)
    {
        int line = 0;

        try
        {
            Connection conn =  DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String stringSql = "insert into resume_list values('"+resume.getName()+"','"+resume.getId()+"','"+resume.getSchool()+
                    "',"+resume.getProcess()+","+resume.getDeleteStatus()+")";
            System.out.println(stringSql);
            line=statement.executeUpdate(stringSql);
            DBConnection.closeConnection(null,statement,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return line;
    }

    //删除学生信息
    public int deleteResume(String resumeId) {
        int line=0;
        try
        {
            System.out.println("1");
            Connection conn = DBConnection.getConnection();
            System.out.println("2");
            Statement statement =conn.createStatement();
            System.out.println("3");
            String stringSql ="delete from resume_list where id = '"+resumeId+"'";
            System.out.println("4");
            line=statement.executeUpdate(stringSql);
            System.out.println("5");
            DBConnection.closeConnection(null,statement,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        System.out.println("6");
        return line;
    }

    public ResumeList searchResume(String choice,String arg) {
        ResumeList resumes=new ResumeList();
        try
        {

            Connection conn =  DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String sql = "select * from resume_list where "+choice+"'"+arg+"'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next())
            {
                Resume aResume=new Resume(rs.getString(1),rs.getString(2));
                aResume.setSchool(rs.getString(3));
                aResume.setProcess(rs.getInt(4));
                aResume.setDeleteStatus(rs.getInt(5));

                resumes.add(aResume);
            }
            DBConnection.closeConnection(rs,statement,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return resumes;
    }

    public int updataResume(String resumeId,String newName, String newSchool, int newProcess, int newDeleteStatus) {
        int line=0;
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
        return line;
    }
}
