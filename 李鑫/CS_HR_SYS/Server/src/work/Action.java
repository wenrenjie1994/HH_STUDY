package work;

import model.ActionResult;
import model.Resume;
import model.ResumeList;
import database.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Action {

    public Connection con = null;

    public void closeStatement(Statement statement) {
        DBConnection.closeConnection(null, statement, null);
    }

    public void closeStatementAndRs(Statement statement, ResultSet rs) {
        DBConnection.closeConnection(null, statement, rs);
    }

    public void closeConnection() {
        DBConnection.closeConnection(con, null, null);
    }

    public Action() {
        con = DBConnection.getConnection();
        assert con != null;
        System.out.println("系统已连接数据库:)");
    }

    // 添加Resume
    public ActionResult addResume(Resume resume) {
        int line = 0;
        ActionResult actionResult = new ActionResult();

        try {
            String sqlExpr = String.format("insert into resume_tbl (name, id, school) values (\"%s\", \"%s\", \"%s\")",
                    resume.getName(), resume.getId(), resume.getSchool());
            Statement statement = con.createStatement();
            line = statement.executeUpdate(sqlExpr);
            closeStatement(statement);
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        }

        if (line > 0) {
            actionResult.isSuccess = "Success";
        }
        else {
            actionResult.isSuccess = "Failed";
            actionResult.failReason = "unknown error";
        }

        return actionResult;
    }

    // 通过名字删除简历
    public ActionResult deleteResume(Resume resume) {
        int line = 0;
        ActionResult actionResult = new ActionResult();

        try {
            String sqlExpr = String.format("delete from resume_tbl where name = \"%s\"", resume.getName());
            Statement statement = con.createStatement();
            line = statement.executeUpdate(sqlExpr);
            closeStatement(statement);
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        }

        if (line > 0) {
            actionResult.isSuccess = "Success";
        }
        else {
            actionResult.isSuccess = "Failed";
            actionResult.failReason = "没有找到该简历";
        }

        return actionResult;
    }

    // 通过名字修改简历信息
    public ActionResult updateResume(ResumeList resumeList) {
        int line = 0;
        ActionResult actionResult = new ActionResult();

        try {
            String sqlExpr = String.format("update resume_tbl set name=\"%s\", id=\"%s\", school=\"%s\" where name=\"%s\"",
                    resumeList.get(0).getName(), resumeList.get(1).getName(),
                    resumeList.get(1).getId(), resumeList.get(1).getSchool());
            Statement statement = con.createStatement();
            line = statement.executeUpdate(sqlExpr);
            closeStatement(statement);
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        }

        if (line > 0) {
            actionResult.isSuccess = "Success";
        }
        else {
            actionResult.isSuccess = "Failed";
            actionResult.failReason = "没有找到该简历，修改失败";
        }

        return actionResult;
    }

    // 通过名字查询简历信息
    public ActionResult searchResume(Resume resume) {
        ResumeList resumeList = new ResumeList();
        ActionResult actionResult = new ActionResult();

        try {
            String sqlExpr = String.format("select * from resume_tbl where name=\"%s\"", resume.getName());
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sqlExpr);
            while (rs.next()) {
                Resume r = new Resume(rs.getString("name"), rs.getString("id"), rs.getString("school"));
                resumeList.add(r);
            }
            closeStatementAndRs(statement, rs);
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        }

        if (resumeList.size() > 0) {
            actionResult.isSuccess = "Success";
            actionResult.resultData = resumeList;
        }
        else {
            actionResult.isSuccess = "Failed";
            actionResult.failReason = "没有找到相关的简历";
        }

        return actionResult;
    }

}
