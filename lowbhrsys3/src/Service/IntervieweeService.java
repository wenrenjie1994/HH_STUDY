package Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Bean.Interviewee;
import Bean.IntervieweeList;
import DB.DBConnection;

public class IntervieweeService {
    // 添加面试者
    public int addInterviewee(Interviewee interviewee){
        int line = 0;
        try{
            Connection conn = DBConnection.getConnection();
            Statement statement = conn.createStatement();
            String sql = "insert into interviewee (name,age,id,school,position) values('"+interviewee.getName()+"','"+interviewee.getAge()+"','"+interviewee.getID()+"','"+interviewee.getSchool()+"','"+interviewee.getPosition()+"')";
            line = statement.executeUpdate(sql);
            DBConnection.closeConnection(null,statement,conn);
        } catch (SQLException e){
            System.out.println("SQL Exception:"+e.toString());
        }
        return line;
    }

    // 删除面试者
    public int deleteIntervieweeByName(String name){
        int line = 0;
        try{
            Connection conn = DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String sql = "delete from interviewee where name = '"+name+"'";
            line = statement.executeUpdate(sql);
            DBConnection.closeConnection(null,statement,conn);
        } catch (SQLException e){
            System.out.println("SQL Exception:"+e.toString());
        }
        return line;
    }

    public int deleteIntervieweeByID(String ID){
        int line = 0;
        try{
            Connection conn = DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String sql = "delete from interviewee where id = '"+ID+"'";
            line = statement.executeUpdate(sql);
            DBConnection.closeConnection(null,statement,conn);
        } catch (SQLException e){
            System.out.println("SQL Exception:"+e.toString());
        }
        return line;
    }

    // 修改面试者信息
    public int modifyInterviewee(Interviewee interviewee){
        int line = 0;
        try{
            Connection conn = DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String sql = "update interviewee set name = '"+interviewee.getName()+"',age = '"+interviewee.getAge()+"',school = '"+interviewee.getSchool()+"',position = '"+interviewee.getPosition()+"'where id = '"+interviewee.getID()+"'";
            line = statement.executeUpdate(sql);
            DBConnection.closeConnection(null,statement,conn);
        } catch (SQLException e){
            System.out.println("SQL Exception:"+e.toString());
        }
        return line;
    }

    // 查询面试者
    public IntervieweeList findIntervieweeByName(String name){
        IntervieweeList iList = new IntervieweeList();
        try{
            Connection conn =  DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String sql = "select * from interviewee where name='"+name+"'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Interviewee interviewee = new Interviewee(rs.getString("name"),rs.getInt("age"),rs.getString("school"),rs.getString("id"),rs.getString("position"));
                iList.add(interviewee);
            }
            DBConnection.closeConnection(rs,statement,conn);
        } catch (SQLException e){
            System.out.println("SQL Exception:"+e.toString());
        }
        return iList;
    }

    public IntervieweeList findIntervieweeBySchool(String school){
        IntervieweeList iList = new IntervieweeList();
        try{
            Connection conn =  DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String sql = "select * from interviewee where school='"+school+"'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Interviewee interviewee = new Interviewee(rs.getString("name"),rs.getInt("age"),rs.getString("school"),rs.getString("id"),rs.getString("position"));
                iList.add(interviewee);
            }
            DBConnection.closeConnection(rs,statement,conn);
        } catch (SQLException e){
            System.out.println("SQL Exception:"+e.toString());
        }
        return iList;
    }

    public IntervieweeList findIntervieweeByPosition(String position){
        IntervieweeList iList = new IntervieweeList();
        try{
            Connection conn =  DBConnection.getConnection();
            Statement statement =conn.createStatement();
            String sql = "select * from interviewee where position='"+position+"'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Interviewee interviewee = new Interviewee(rs.getString("name"),rs.getInt("age"),rs.getString("school"),rs.getString("id"),rs.getString("position"));
                iList.add(interviewee);
            }
            DBConnection.closeConnection(rs,statement,conn);
        } catch (SQLException e){
            System.out.println("SQL Exception:"+e.toString());
        }
        return iList;
    }
}
