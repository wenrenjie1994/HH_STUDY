package main.mapper;

import main.db.DBConnection;
import main.dto.Result;
import main.dto.ResumeList;
import main.entity.AbstractResume;
import main.entity.Resume;
import main.enums.ProcessEnum;
import main.mapper.interfaces.ResumeMapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 7/9/20 2:51 PM
 */
public class DBResumeMapper implements ResumeMapper {
  @Override
  public Result saveResume(AbstractResume resume) {
    return null;
  }

  @Override
  public Result removeResume(AbstractResume resume) {
    return null;
  }

  @Override
  public Result updateResume(AbstractResume oldResume, AbstractResume newResume) {
    return null;
  }

  @Override
  public Result getResumeByID(AbstractResume resume) {
    String sql = "select * from resume where deleteStatus != 1 and id = " + resume.getId();
    Connection conn = DBConnection.getConnection();
    ResultSet rs = null;
    Statement statement = null;
    ResumeList resumes = new ResumeList();

    try {
      statement = conn.createStatement();
      rs = statement.executeQuery(sql);
      while (rs.next()) {
        ProcessEnum processEnum = ProcessEnum.PASS_APPLICATION;
        processEnum.setProcess(Integer.parseInt(rs.getString("process")));

        Resume resume = new Resume(rs.getString("name"), rs.getString("id"),
                rs.getString("school"), processEnum, rs.getBoolean("deleteStatus"));
        resumes.add(resume);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      return Result.errorResult();
    } finally {
      DBConnection.closeConnection(rs, statement, conn);
    }
    return Result.successResult(resumes);
  }

}

  @Override
  public Result listResume() {
    String sql = "select * from resume where deleteStatus != 1";
    Connection conn = DBConnection.getConnection();
    ResultSet rs = null;
    Statement statement = null;
    ResumeList resumes = new ResumeList();

    try {
      statement = conn.createStatement();
      rs = statement.executeQuery(sql);
      while (rs.next()) {
        ProcessEnum processEnum = ProcessEnum.PASS_APPLICATION;
        processEnum.setProcess(Integer.parseInt(rs.getString("process")));

        Resume resume = new Resume(rs.getString("name"), rs.getString("id"),
                rs.getString("school"), processEnum, rs.getBoolean("deleteStatus"));
        resumes.add(resume);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      return Result.errorResult();
    } finally {
      DBConnection.closeConnection(rs, statement, conn);
    }
    return Result.successResult(resumes);
  }

}
