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
    public Statement statement = null;

    public Action() {
        try {
            con = DBConnection.getConnection();
            assert con != null;
            statement = con.createStatement();
            System.out.println("系统已连接数据库:)");
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        }
    }

    // 添加Resume，返回受影响的行数
    public int addResume(String... strings) {
        int line = 0;

        try {
            String sqlExpr = String.format("insert into resume_tbl (name, id, school) values (\"%s\", \"%s\", \"%s\")",
                    strings[0], strings[1], strings[2]);
            line = statement.executeUpdate(sqlExpr);
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
            line = statement.executeUpdate(sqlExpr);
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
            line = statement.executeUpdate(sqlExpr);
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
            ResultSet rs = statement.executeQuery(sqlExpr);
            while (rs.next()) {
                Resume r = new Resume(rs.getString(1), rs.getString(2), rs.getString(3));
                resumeList.add(r);
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        }

        return resumeList;
    }

}
