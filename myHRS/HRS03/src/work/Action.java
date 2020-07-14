package work;

import bean.Resume;
import bean.ResumeList;
import database.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author lee
 * @Date 2020/7/14 10:43 AM
 **/


public class Action {

    public int addResume(Resume resume) {
        int rs = 0; // 获取执行结果的状态，0 失败  1 成功
        // TODO 使用ResultSet

        try {
            // 建立连接
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            // TODO 修改,这里引号太冗杂
            String sqlString = "insert into resume values('" + resume.getName() + "','" + resume.getId() + "','" + resume.getSchool() + "','" + resume.getProcess() + "','" + resume.getDeleteStatus() + "')";

            // Executes the given SQL statement, which may be an INSERT, UPDATE, or DELETE
            // statement or an SQL statement that returns nothing, such as an SQL DDL statement.

            // (1) the row count for SQL Data Manipulation Language (DML) statements or
            // (2) 0 for SQL statements that return nothing
            rs = stmt.executeUpdate(sqlString);
            DBConnection.closeConnection(null, stmt, conn);

            //TODO
            // 1.添加成功后，修改process的状态
            // 2.添加前应该在数据库中查找是否存在对应记录
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
        return rs;
    }

    public int deleteResumeByName(Resume resume) {
        int rs = 0;
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sqlString = "delete from resume where name='" + resume.getName() + "'";
            rs = stmt.executeUpdate(sqlString);
            DBConnection.closeConnection(null, stmt, conn);

        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
        return rs;
    }

    public int deleteResumeById(Resume resume) {
        int rs = 0;
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sqlString = "delete from resume where id='" + resume.getId() + "'";
            rs = stmt.executeUpdate(sqlString);
            DBConnection.closeConnection(null, stmt, conn);

        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
        return rs;
    }

    public int deleteResumeBySchool(Resume resume) {
        int rs = 0;
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sqlString = "delete from resume where school='" + resume.getSchool() + "'";
            rs = stmt.executeUpdate(sqlString);
            DBConnection.closeConnection(null, stmt, conn);

        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
        return rs;
    }

    public ResumeList searchResumeByName(Resume resume) {
        ResumeList resumelist = new ResumeList();
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sqlString = " select * from resume where name='" + resume.getName() + "'";
            ResultSet rs = stmt.executeQuery(sqlString);
            while (rs.next()) {
                Resume rsResume = new Resume(rs.getString("name"), rs.getString("id"),
                        rs.getString("school"));
                resumelist.add(rsResume);
            }
            DBConnection.closeConnection(rs, stmt, conn);

        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
        return resumelist;
    }

    public ResumeList searchResumeById(Resume resume) {
        ResumeList resumelist = new ResumeList();
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sqlString = " select * from resume where id='" + resume.getId() + "'";
            ResultSet rs = stmt.executeQuery(sqlString);
            while (rs.next()) {
                Resume rsResume = new Resume(rs.getString("name"), rs.getString("id"),
                        rs.getString("school"));
                resumelist.add(rsResume);
            }
            DBConnection.closeConnection(rs, stmt, conn);

        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
        return resumelist;
    }

    public ResumeList searchResumeBySchool(Resume resume) {
        ResumeList resumelist = new ResumeList();
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sqlString = " select * from resume where school='" + resume.getSchool() + "'";
            ResultSet rs = stmt.executeQuery(sqlString);
            while (rs.next()) {
                Resume rsResume = new Resume(rs.getString("name"), rs.getString("id"),
                        rs.getString("school"));
                resumelist.add(rsResume);
            }
            DBConnection.closeConnection(rs, stmt, conn);

        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
        return resumelist;
    }


}


