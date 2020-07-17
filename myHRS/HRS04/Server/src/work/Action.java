package work;

/**
 * @Author lee
 * @Date 2020/7/15 7:44 PM
 **/

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.DBConnection;
import model.ActionResult;
import model.Resume;
import model.ResumeList;

public class Action {

    public ActionResult addResume(Resume resume) {
        int rs = 0; // 获取执行结果的状态，0 失败  1 成功
        ActionResult ars = new ActionResult();

        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            String sqlString = "insert into resume values('" + resume.getName() + "','" + resume.getId() + "','" + resume.getSchool() + "','" + resume.getProcess() + "','" + resume.getDeleteStatus() + "')";

            rs = stmt.executeUpdate(sqlString);
            DBConnection.closeConnection(null, stmt, conn);

        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
        if (rs > 0) {
            ars.isSuccess = "Success";
        } else {
            ars.isSuccess = "false";
            ars.failReason = "Unknown error";
        }
        return ars;
    }

    public ActionResult deleteResumeByName(Resume resume) {
        int rs = 0;
        ActionResult ars = new ActionResult();

        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sqlString = "delete from resume where name='" + resume.getName() + "'";
            rs = stmt.executeUpdate(sqlString);
            DBConnection.closeConnection(null, stmt, conn);

        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
        if (rs > 0) {
            ars.isSuccess = "Success";
        } else {
            ars.isSuccess = "false";
            ars.failReason = "未找到该姓名对应的简历";
        }
        return ars;

    }

    public ActionResult deleteResumeById(Resume resume) {
        int rs = 0;
        ActionResult ars = new ActionResult();
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sqlString = "delete from resume where id='" + resume.getId() + "'";
            rs = stmt.executeUpdate(sqlString);
            DBConnection.closeConnection(null, stmt, conn);

        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
        if (rs > 0) {
            ars.isSuccess = "Success";
        } else {
            ars.isSuccess = "false";
            ars.failReason = "未找到该身份证号对应的简历";
        }
        return ars;
    }

    public ActionResult deleteResumeBySchool(Resume resume) {
        int rs = 0;
        ActionResult ars = new ActionResult();

        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            String sqlString = "delete from resume where school='" + resume.getSchool() + "'";
            rs = stmt.executeUpdate(sqlString);
            DBConnection.closeConnection(null, stmt, conn);

        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
        if (rs > 0) {
            ars.isSuccess = "Success";
        } else {
            ars.isSuccess = "false";
            ars.failReason = "未找到该学校对应的简历";
        }
        return ars;
    }

    public ActionResult searchResumeByName(Resume resume) {
        ResumeList resumelist = new ResumeList();
        ActionResult ars = new ActionResult();

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
        int resumeSize = resumelist.size();
        if (resumeSize > 0) {
            ars.isSuccess = "Success";
            ars.resultData = resumelist;
        } else {
            ars.isSuccess = "false";
            ars.failReason = "没有找到相关简历";
        }
        return ars;
    }

    public ActionResult searchResumeById(Resume resume) {
        ResumeList resumelist = new ResumeList();
        ActionResult ars = new ActionResult();

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
        int resumeSize = resumelist.size();
        if (resumeSize > 0) {
            ars.isSuccess = "Success";
            ars.resultData = resumelist;
        } else {
            ars.isSuccess = "false";
            ars.failReason = "没有找到相关简历";
        }
        return ars;
    }

    public ActionResult searchResumeBySchool(Resume resume) {
        ResumeList resumelist = new ResumeList();
        ActionResult ars = new ActionResult();

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
        int resumeSize = resumelist.size();
        if (resumeSize > 0) {
            ars.isSuccess = "Success";
            ars.resultData = resumelist;
        } else {
            ars.isSuccess = "false";
            ars.failReason = "没有找到相关简历";
        }
        return ars;
    }

}
