package work;

import bean.Resume;
import bean.ResumeList;
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

    // 添加Resume，返回受影响的行数
    public int addResume(String... strings) {
        int line = 0;

        try {
            String sqlExpr = String.format("insert into resume_tbl (name, id, school) values (\"%s\", \"%s\", \"%s\")",
                    strings[0], strings[1], strings[2]);
            Statement statement = con.createStatement();
            line = statement.executeUpdate(sqlExpr);
            closeStatement(statement);
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        }

        return line;
    }

    // 通过名字删除简历
    public int deleteResume(String name) {
        int line = 0;

        try {
            String sqlExpr = String.format("delete from resume_tbl where name = \"%s\"", name);
            Statement statement = con.createStatement();
            line = statement.executeUpdate(sqlExpr);
            closeStatement(statement);
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        }

        return line;
    }

    // 通过名字修改简历信息
    public int updateResume(String... strings) {
        int line = 0;

        try {
            String sqlExpr = String.format("update resume_tbl set name=\"%s\", id=\"%s\", school=\"%s\" where name=\"%s\"",
                    strings[0], strings[1], strings[2], strings[3]);
            Statement statement = con.createStatement();
            line = statement.executeUpdate(sqlExpr);
            closeStatement(statement);
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        }

        return line;
    }

    // 通过名字查询简历信息
    public ResumeList searchResume(String name) {
        ResumeList resumeList = new ResumeList();

        try {
            String sqlExpr = String.format("select * from resume_tbl where name=\"%s\"", name);
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

        return resumeList;
    }

}
