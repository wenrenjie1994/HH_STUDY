package utils;

import bean.Resume;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class ResumeOperate {
    /**
     * 添加简历
     *
     * @param resume
     * @return
     */
    public int addResume(Resume resume) {
        int line = 0;
        try {
            Connection con = DBConnection.getConnection();
            Statement statement = con.createStatement();
            String sql = "insert into resumes values('" + resume.getName() + "','" + resume.getId() +
                    "','" + resume.getSchool() + "','" + resume.getProcess() + "','" + resume.getDeleteStatus() + "')";
            line = statement.executeUpdate(sql);
            DBConnection.closeConnection(statement, con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return line;
    }

    /**
     * 删除简历
     *
     * @param resume
     * @return
     */
    public int deleteResumeById(Resume resume) {
        int line = 0;
        try {
            Connection con = DBConnection.getConnection();
            Statement statement = con.createStatement();
            String sql = "delete from resumes where id = '" + resume.getId() + "'";
            line = statement.executeUpdate(sql);
            DBConnection.closeConnection(statement, con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return line;
    }

    /**
     * 更新简历
     *
     * @param newResume
     * @param oldResume
     * @return
     */
    public int updateResumeById(Resume newResume, Resume oldResume) {
        int line = 0;
        try {
            Connection con = DBConnection.getConnection();
            Statement statement = con.createStatement();
            String sql = "update resumes set name = '" + newResume.getName() + "',id = '" + newResume.getId()
                    + "',school='" + newResume.getSchool() + "',process='" + newResume.getProcess()
                    + "',deleteStatus='" + newResume.getDeleteStatus() + "' where id = '" + oldResume.getId() + "'";
            line = statement.executeUpdate(sql);
            DBConnection.closeConnection(statement, con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return line;
    }

    /**
     * 查找简历（通过姓名）
     *
     * @param resume
     * @return
     */
    public LinkedList<Resume> searchResumeByName(Resume resume) {
        LinkedList<Resume> resumes = new LinkedList<>();
        try {
            Connection con = DBConnection.getConnection();
            Statement statement = con.createStatement();
            String sql = "select * from resumes where name = '" + resume.getName() + "'";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Resume r = new Resume(rs.getString("name"), rs.getString("id"), rs.getString("school"));
                resumes.add(r);
            }
            DBConnection.closeConnection(rs, statement, con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resumes;
    }

    /**
     * 查找简历（通过身份证号）
     *
     * @param resume
     * @return
     */
    public LinkedList<Resume> searchResumeById(Resume resume) {
        LinkedList<Resume> resumes = new LinkedList<>();
        try {
            Connection con = DBConnection.getConnection();
            Statement statement = con.createStatement();
            String sql = "select * from resumes where id = '" + resume.getId() + "'";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Resume r = new Resume(rs.getString("name"), rs.getString("id"), rs.getString("school"));
                resumes.add(r);
            }
            DBConnection.closeConnection(rs, statement, con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resumes;
    }
}
