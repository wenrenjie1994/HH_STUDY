package Work;

import bean.DBConnection;
import bean.Resume;
import bean.ResumeList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Action
{
    //添加简历的方法。
    public int addResume(Resume resume)
    {
        int line = 0;

        try
        {
            Connection conn =  DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String stringSql = "insert into hrsys values('"+resume.getName()+"','"+resume.getGender()+"','"+resume.getAge()+"','"+resume.getEducation()+"')";
            line=statement.executeUpdate(stringSql);
            DBConnection.closeConnection(null,statement,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return line;
    }
    //删除简历的方法。
    public int deleteResumeByName(Resume resume)
    {
        int line=0;
        try
        {
            Connection conn = DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String stringSql ="delete from hrsys where ResumeName = '"+resume.getName()+"'";
            line=statement.executeUpdate(stringSql);
            DBConnection.closeConnection(null,statement,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return line;
    }

    //修改简历的方法。
    public int changeResume(Resume resume, Resume Oldresume)
    {
        int line=0;
        try
        {
            Connection conn = DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String stringSql ="UPDATE hrsys SET ResumeName = '"+resume.getName()+"', " +
                    "ResumeGender='"+resume.getGender()+"'" +
                    ",ResumeAge='"+resume.getAge()+"',ResumeEdu='"+resume.getEducation()+"' " +
                    "WHERE  ResumeName= '"+Oldresume.getName()+"'";
            line=statement.executeUpdate(stringSql);
            DBConnection.closeConnection(null,statement,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return line;
    }

    //按照姓名查询简历的方法。
    public ResumeList searchResumeByName(Resume resume)
    {
        ResumeList resumeList = new ResumeList();
        try
        {
            Connection conn =  DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String sql = "select * from hrsys where ResumeName='"+resume.getName()+"'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next())
            {
                Resume aresume=new Resume(rs.getString("ResumeName"),rs.getString(2),rs.getString(3),rs.getString(4));
                resumeList.add(aresume);
            }
            DBConnection.closeConnection(rs,statement,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return resumeList;

    }

}
