package dao;

import bean.Resume;
import database.DBConnection;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ResumeDao {

    private static ResumeDao resumeDao = null;

    private ResumeDao() {
    }

    public static ResumeDao getInstance() {
        if (resumeDao == null) {
            resumeDao = new ResumeDao();
        }
        return resumeDao;
    }

    public int addResume(Resume resume) {
        int status = 0;
        try {
            Connection conn = DBConnection.getConnection();
            String stringSql = "insert into resumes values(?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(stringSql);
            ps.setString(1, resume.getId());
            ps.setString(2, resume.getName());
            ps.setString(3, resume.getSchool());
            ps.setInt(4, resume.getProcess());
            ps.setInt(5, resume.getDeleteStatus());
            status = ps.executeUpdate();
            DBConnection.closeConnection(null, ps, conn);
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
        return status;
    }

    public int deleteResume(String id) {
        int status = 0;
        try {
            Connection conn = DBConnection.getConnection();
            String stringSql = "update resumes set deleteStatus = 1 where id = ?";
            PreparedStatement ps = conn.prepareStatement(stringSql);
            ps.setString(1, id);
            status = ps.executeUpdate();
            DBConnection.closeConnection(null, ps, conn);
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
        return status;
    }

    public List<Resume> selectResumeById(String id) {
        List<Resume> resumes = new LinkedList<>();
        try {
            Connection conn = DBConnection.getConnection();
            String stringSql = "select * from resumes where id=? and deleteStatus=0";
            PreparedStatement ps = conn.prepareStatement(stringSql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Resume resume = new Resume(rs.getString("id"), rs.getString("name")
                        , rs.getString("school"), rs.getInt("process")
                        , rs.getInt("deleteStatus"));
                System.out.println(resume.getName());
                resumes.add(resume);
            }

            DBConnection.closeConnection(null, ps, conn);
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
        return resumes;
    }

    public int updateResume(Resume resume) {
        int status = 0;
        try {
            Connection conn = DBConnection.getConnection();
            String stringSql = "update resumes set name=?,school=?,process=?,deleteStatus=? where id=?";
            PreparedStatement ps = conn.prepareStatement(stringSql);

            ps.setString(1, resume.getName());
            ps.setString(2, resume.getSchool());
            ps.setInt(3, resume.getProcess());
            ps.setInt(4, resume.getDeleteStatus());
            ps.setString(5, resume.getId());
            status = ps.executeUpdate();
            DBConnection.closeConnection(null, ps, conn);
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
        return status;
    }

}
