package utils;

import bean.Response;
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
     * @throws SQLException
     */
    public Response addResume(Resume resume) throws SQLException {
        int line = 0;
        Response response = new Response();
        Connection con = DBConnection.getConnection();
        Statement statement = con.createStatement();
        String sql = "insert into resumes values('" + resume.getName() + "','" + resume.getId() +
                "','" + resume.getSchool() + "','" + resume.getProcess() + "','" + resume.getDeleteStatus() + "')";
        line = statement.executeUpdate(sql);
        DBConnection.closeConnection(statement, con);
        if (line > 0) {
            response.setIsSuccess("Succeed");
        } else {
            response.setIsSuccess("Failed");
            response.setFailReason("Unknown Error!");
        }
        return response;
    }

    /**
     * 删除简历
     *
     * @param resume
     * @return
     * @throws SQLException
     */
    public Response deleteResume(Resume resume) throws SQLException {
        int line = 0;
        Response response = new Response();
        Connection con = DBConnection.getConnection();
        Statement statement = con.createStatement();
        String sql = "delete from resumes where id = '" + resume.getId() + "'";
        line = statement.executeUpdate(sql);
        DBConnection.closeConnection(statement, con);
        if (line > 0) {
            response.setIsSuccess("Succeed");
        } else {
            response.setIsSuccess("Failed");
            response.setFailReason("The resume you want to delete was not found!");
        }
        return response;
    }

    /**
     * 更新简历
     *
     * @param newResume
     * @param oldResume
     * @return
     * @throws SQLException
     */
    public Response updateResume(Resume newResume, Resume oldResume) throws SQLException {
        int line = 0;
        Response response = new Response();
        Connection con = DBConnection.getConnection();
        Statement statement = con.createStatement();
        String sql = "update resumes set name = '" + newResume.getName() + "',id = '" + newResume.getId()
                + "',school='" + newResume.getSchool() + "',process='" + newResume.getProcess()
                + "',deleteStatus='" + newResume.getDeleteStatus() + "' where id = '" + oldResume.getId() + "'";
        line = statement.executeUpdate(sql);
        DBConnection.closeConnection(statement, con);
        if (line > 0) {
            response.setIsSuccess("Succeed");
        } else {
            response.setIsSuccess("Failed");
            response.setFailReason("The resume you want to update was not found!");
        }
        return response;
    }

    /**
     * 查找简历（通过姓名）
     *
     * @param resume
     * @return
     * @throws SQLException
     */
    public Response searchResumeByName(Resume resume) throws SQLException {
        LinkedList<Resume> resumes = new LinkedList<>();
        Response response = new Response();
        Connection con = DBConnection.getConnection();
        Statement statement = con.createStatement();
        String sql = "select * from resumes where name = '" + resume.getName() + "'";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            Resume r = new Resume(rs.getString("name"), rs.getString("id"), rs.getString("school"));
            resumes.add(r);
        }
        DBConnection.closeConnection(rs, statement, con);
        duplicateCodeDealing(resumes, response);
        return response;
    }

    /**
     * 查找简历（通过身份证号）
     *
     * @param resume
     * @return
     * @throws SQLException
     */
    public Response searchResumeById(Resume resume) throws SQLException {
        LinkedList<Resume> resumes = new LinkedList<>();
        Response response = new Response();
        Connection con = DBConnection.getConnection();
        Statement statement = con.createStatement();
        String sql = "select * from resumes where id = '" + resume.getId() + "'";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            Resume r = new Resume(rs.getString("name"), rs.getString("id"), rs.getString("school"));
            resumes.add(r);
        }
        DBConnection.closeConnection(rs, statement, con);
        duplicateCodeDealing(resumes, response);
        return response;
    }

    //重复代码处理
    private void duplicateCodeDealing(LinkedList<Resume> resumes, Response response) {
        if (resumes.size() > 0) {
            response.setIsSuccess("Succeed");
            response.setData(resumes);
        } else {
            response.setIsSuccess("Failed");
            response.setFailReason("The resume you want to search was not found!");
        }
    }

}
