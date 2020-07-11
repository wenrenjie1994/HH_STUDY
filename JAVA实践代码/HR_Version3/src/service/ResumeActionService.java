package service;

import bean.Resume;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 熊彩铃
 * @program
 * @description
 * @date 2020/7/11 15:58
 */
public class ResumeActionService {
    public Integer addResumeAction(Resume resume) {
        Integer result = 0;
        try{
            Connection connection = DBConnectionService.getConnection();
            Statement statement = connection.createStatement();
            String sql = "insert into resume values('"+resume.getName()+"','"+resume.getID_Number()+"','"+resume.getSchool()+"','"+resume.getAge()+"')";
            result = statement.executeUpdate(sql);
            DBConnectionService.closeConnection(null,statement,connection);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public Integer deleteResumeByNameAction(String name) {
        Integer result = 0;
      try{
          Connection connection = DBConnectionService.getConnection();
          Statement statement = connection.createStatement();
          String sql = "delete from resume where name='"+name+"'";
          result = statement.executeUpdate(sql);
          DBConnectionService.closeConnection(null,statement,connection);
      }catch (SQLException e){
          e.printStackTrace();
      }
        return result;
    }

    public Integer deleteResumeByIDAction(String id_number) {
        Integer result = 0;
        try{
            Connection connection = DBConnectionService.getConnection();
            Statement statement = connection.createStatement();
            String sql = "delete from resume where ID_Number='"+id_number+"'";
            result = statement.executeUpdate(sql);
            DBConnectionService.closeConnection(null,statement,connection);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public Integer modifyResumeAction(Resume resume) {
        Integer result = 0;
        try{
            Connection connection = DBConnectionService.getConnection();
            Statement statement = connection.createStatement();
            String sql = "update resume set name='"+resume.getName()+"',"
                    +"ID_Number='"+resume.getID_Number()+"',"+"school='"
                    +resume.getSchool()+"',"+"age='"+resume.getAge()+"'"
                    +"where name='"+resume.getName()+"'";
            result = statement.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public Resume queryResumeByNameAction(String name) {
        Resume resume = null;
        try{
            Connection connection = DBConnectionService.getConnection();
            Statement statement = connection.createStatement();
            String sql = "select * from resume where name='"+name+"'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                resume = new Resume(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
            }
            DBConnectionService.closeConnection(null,statement,connection);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resume;
    }

    public Resume queryResumeByIDAction (String ID_Number) {
        Resume resume = null;
        try{
            Connection connection = DBConnectionService.getConnection();
            Statement statement = connection.createStatement();
            String sql = "select * from resume where ID_Number='"+ID_Number+"'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                resume = new Resume(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
            }
            DBConnectionService.closeConnection(null,statement,connection);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resume;
    }
}
