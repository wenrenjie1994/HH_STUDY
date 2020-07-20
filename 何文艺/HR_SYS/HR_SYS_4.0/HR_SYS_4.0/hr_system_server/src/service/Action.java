package service;

import model.ActionResult;
import model.Resume;
import model.ResumeLinkedList;
import utils.JDBCUtils;

import javax.sql.rowset.JdbcRowSet;
import java.sql.*;

/**
 * @program: HR_SYS_4.0（C/S模式）
 * @className:Action
 * @description:提供招聘系统的增删改查操作（与数据库交互）
 * @author: 何文艺
 * @create: 2020/7/17 11:39
 **/
public class Action {
/*
    1.通过数据库操作结果中受影响的行数line判断数据库操作是否成功
      若line>0，则数据库操作成功,设置actionResult.isSuccess = "success"
      否则操作失败，设置失败原因actionResult.failReason
    2.查询操作设置操作结果actionResult.resultData
*/

    public ActionResult addResume(Resume resume) {//添加简历
        int line = 0;
        ActionResult actionResult = new ActionResult();
        PreparedStatement pst = null;
        Connection conn = null;
        try {
            //定义sql语句
            String sql = "INSERT INTO resume(name, id ,school, process, deleteStatus) VALUES (?, ?, ?, 0, 1)";
            //获取数据库的连接对象
            conn = JDBCUtils.getConnection();
            //获取执行sql语句的对象 PreparedStatement
            pst = conn.prepareStatement(sql);
            //给?赋值
            pst.setString(1, resume.name);
            pst.setString(2, resume.id);
            pst.setString(3, resume.school);
            //执行sql，接收返回结果
            line = pst.executeUpdate();
            if (line > 0) {
                actionResult.isSuccess = true;
            } else {
                actionResult.isSuccess = false;
                actionResult.failReason = "unknown";
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        } finally {
            JDBCUtils.close(pst, conn);
        }
        return actionResult;
    }

    public ActionResult deleteResume(Resume resume) {//删除简历
        int line = 0;
        ActionResult actionResult = new ActionResult();
        PreparedStatement pst = null;
        Connection conn = null;
        try {
            String sql = "UPDATE resume SET deleteStatus = 0 WHERE id = ? AND deleteStatus = 1";
            conn = JDBCUtils.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1,resume.id);
            line = pst.executeUpdate();
            if(line > 0) {
                actionResult.isSuccess = true;
            } else {
                actionResult.isSuccess = false;
                actionResult.failReason = "该简历不存在！";
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception:"+e.toString());
        } finally {
            JDBCUtils.close(pst, conn);
        }
        return actionResult;
    }

    public ActionResult updateResume(Resume newResume, Resume oldResume) {//修改简历
        int line = 0;
        ActionResult actionResult = new ActionResult();
        PreparedStatement pst = null;
        Connection conn = null;
        try {
            String sql = "UPDATE resume SET name = ?, id = ?, school = ? WHERE deleteStatus = 1 AND id = ?";
            conn = JDBCUtils.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1,newResume.name);
            pst.setString(2,newResume.id);
            pst.setString(3,newResume.school);
            pst.setString(4,oldResume.id);
            line = pst.executeUpdate();
            if(line > 0) {
                actionResult.isSuccess = true;
            } else {
                actionResult.isSuccess = false;
                actionResult.failReason = "该简历不存在！";
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception:"+e.toString());
        } finally {
            JDBCUtils.close(pst, conn);
        }
        return actionResult;
    }


    public ActionResult searchByName(Resume resume) {//通过姓名查找
        ResumeLinkedList resumeLinkedList = new ResumeLinkedList();
        ActionResult actionResult = new ActionResult();
        PreparedStatement pst = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM resume WHERE name = ? AND deleteStatus = 1";
            conn = JDBCUtils.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1,resume.name);
            rs = pst.executeQuery();
            while (rs.next()) {
                Resume aResume = new Resume(rs.getString("name"), rs.getString("id"), rs.getString("school"));
                aResume.process = rs.getInt("process");
                aResume.deleteStatus = rs.getInt("deleteStatus");
                resumeLinkedList.add(aResume);
            }
            if(resumeLinkedList.size() > 0) {
                actionResult.isSuccess = true;
                actionResult.resultData = resumeLinkedList;
            } else {
                actionResult.isSuccess = false;
                actionResult.failReason = "该简历不存在！";
            }
        } catch (SQLException e) {
            System.out.println("SQLException:" + e.toString());
        } finally {
            JDBCUtils.close(rs, pst, conn);
        }
        return actionResult;
    }

    public ActionResult searchById(Resume resume) {//通过身份证号查找
        ResumeLinkedList resumeLinkedList = new ResumeLinkedList();
        ActionResult actionResult = new ActionResult();
        PreparedStatement pst = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM resume WHERE id = ? AND deleteStatus = 1";
            conn = JDBCUtils.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1,resume.id);
            rs = pst.executeQuery();
            while (rs.next()) {
                Resume aResume = new Resume(rs.getString("name"), rs.getString("id"), rs.getString("school"));
                aResume.process = rs.getInt("process");
                aResume.deleteStatus = rs.getInt("deleteStatus");
                resumeLinkedList.add(aResume);
            }
            if(resumeLinkedList.size() > 0) {
                actionResult.isSuccess = true;
                actionResult.resultData = resumeLinkedList;
            } else {
                actionResult.isSuccess = false;
                actionResult.failReason = "该简历不存在！";
            }
            JDBCUtils.close(rs, pst, conn);
        } catch (SQLException e) {
            System.out.println("SQLException:" + e.toString());
        } finally {
            JDBCUtils.close(rs, pst, conn);
        }
        return actionResult;
    }

    public ActionResult searchBySchool(Resume resume) {//通过学校查找
        ResumeLinkedList resumeLinkedList = new ResumeLinkedList();
        ActionResult actionResult = new ActionResult();
        PreparedStatement pst = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM resume WHERE school = ? AND deleteStatus = 1";
            conn = JDBCUtils.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1,resume.school);
            rs = pst.executeQuery();
            while (rs.next()) {
                Resume aResume = new Resume(rs.getString("name"), rs.getString("id"), rs.getString("school"));
                aResume.process = rs.getInt("process");
                aResume.deleteStatus = rs.getInt("deleteStatus");
                resumeLinkedList.add(aResume);
            }
            if(resumeLinkedList.size() > 0) {
                actionResult.isSuccess = true;
                actionResult.resultData = resumeLinkedList;
            } else {
                actionResult.isSuccess = false;
                actionResult.failReason = "该简历不存在！";
            }
        } catch (SQLException e) {
            System.out.println("SQLException:" + e.toString());
        } finally {
            JDBCUtils.close(rs, pst, conn);
        }
        return actionResult;
    }

    public ActionResult searchByProcess(Resume resume) {//通过简历状态查找
        ResumeLinkedList resumeLinkedList = new ResumeLinkedList();
        ActionResult actionResult = new ActionResult();
        PreparedStatement pst = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM resume WHERE process = ? AND deleteStatus = 1";
            conn = JDBCUtils.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setInt(1,resume.process);
            rs = pst.executeQuery();
            while (rs.next()) {
                Resume aResume = new Resume(rs.getString("name"), rs.getString("id"), rs.getString("school"));
                aResume.process = rs.getInt("process");
                aResume.deleteStatus = rs.getInt("deleteStatus");
                resumeLinkedList.add(aResume);
            }
            if(resumeLinkedList.size() > 0) {
                actionResult.isSuccess = true;
                actionResult.resultData = resumeLinkedList;
            } else {
                actionResult.isSuccess = false;
                actionResult.failReason = "该简历不存在！";
            }
        } catch (SQLException e) {
            System.out.println("SQLException:" + e.toString());
        } finally {
            JDBCUtils.close(rs, pst, conn);
        }
        return actionResult;
    }

    public ActionResult searchAll() {//查找所有简历
        ResumeLinkedList resumeLinkedList = new ResumeLinkedList();
        ActionResult actionResult = new ActionResult();
        Statement pst = null;
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            String sql = "SELECT * FROM resume WHERE deleteStatus = 1";
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Resume aResume = new Resume(rs.getString("name"), rs.getString("id"), rs.getString("school"));
                aResume.process = rs.getInt("process");
                aResume.deleteStatus = rs.getInt("deleteStatus");
                resumeLinkedList.add(aResume);
            }
            if (resumeLinkedList.size() > 0) {
                actionResult.isSuccess = true;
                actionResult.resultData = resumeLinkedList;
            } else {
                actionResult.isSuccess = false;
                actionResult.failReason = "该简历不存在！";
            }
            JDBCUtils.close(rs, stmt, conn);
        } catch (SQLException e) {
            System.out.println("SQLException:" + e.toString());
        } finally {
            JDBCUtils.close(rs, stmt, conn);
        }
        return actionResult;
    }
}
