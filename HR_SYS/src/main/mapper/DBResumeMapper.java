package main.mapper;

import main.db.DBConnection;
import main.dto.Result;
import main.dto.ResumeList;
import main.entity.AbstractResume;
import main.entity.Resume;
import main.enums.ProcessEnum;
import main.utils.Validator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 7/9/20 2:51 PM
 */
public class DBResumeMapper extends AbstractResumeMapper {
  public DBResumeMapper() {
  }

  @Override
  public Result saveResume(AbstractResume resume) {
    if (!Validator.validResumeAllFields(resume)) {
      return Result.errorParamValidResult();
    }
    String sql = "insert into resume(name, id, school, process, deleteStatus) "
            + "values('"
            + resume.getName()
            + "', '"
            + resume.getId()
            + "', '"
            + resume.getSchool()
            + "', '"
            + resume.getProcess().getCode()
            + "', '"
            + '0'
            + "');";
    Connection conn = DBConnection.getConnection();
    int rs = 0;
    Statement statement = null;
    Resume validResume = getResumeByIDUtil(resume);
    // 如果已存在逻辑删除数据，直接物理删除先
    if (validResume != null && validResume.getDeleteStatus() == true) {
      removeResume(resume);
    }
    // 已存在
    if (validResume != null && validResume.getDeleteStatus() == false) {
      return Result.errorIsExistResult();
    }
    try {
      statement = conn.createStatement();
      rs = statement.executeUpdate(sql);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      return Result.errorResult();
    } finally {
      DBConnection.closeConnection(null, statement, conn);
    }
    return Result.successResult();
  }

  @Override
  public Result removeResume(AbstractResume resume) {
    String sql = "update resume set deleteStatus = true where id = '" + resume.getId() + "';";
    Connection conn = DBConnection.getConnection();
    int rs = 0;
    Statement statement = null;
    try {
      statement = conn.createStatement();
      rs = statement.executeUpdate(sql);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      return Result.errorResult();
    } finally {
      DBConnection.closeConnection(null, statement, conn);
    }
    return Result.successResult();
  }

  @Override
  public Result updateResume(AbstractResume oldResume, AbstractResume newResume) {
    String sql = "update resume set name = '"
            + newResume.getName() + "', id = '"
            + newResume.getId() + "', school = '"
            + newResume.getSchool() + "', process = '"
            + newResume.getProcess().getCode() + "' where id = '"
            + oldResume.getId() + "';";
    Connection conn = DBConnection.getConnection();
    int rs = 0;
    Statement statement = null;
    Resume resume = null;
    // 如果修改前的 resume ID 与修改后一致，就不存在 更改后的简历与已有简历重复了
    if (!oldResume.getId().equals(newResume.getId())) {
      // 更改后的简历与已有简历重复了（id 重复）
      Resume validResume = getResumeByIDUtil(newResume);
      if (validResume != null && validResume.getDeleteStatus() == false) {
        return Result.errorIsExistResult();
      }
      // 更改后的简历在数据库里标记为删除状态
      // 直接把 它 删除
      if (validResume != null && validResume.getDeleteStatus() == true) {
        removeResume(newResume);
      }
    }

    try {
      statement = conn.createStatement();
      rs = statement.executeUpdate(sql);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
      return Result.errorResult();
    } finally {
      DBConnection.closeConnection(null, statement, conn);
    }
    return Result.successResult();
  }

  @Override
  public Result getResumeByID(AbstractResume oldResume) {
    String sql = "select * from resume where deleteStatus != 1 and id = '" + oldResume.getId() + "';";
    Connection conn = DBConnection.getConnection();
    ResultSet rs = null;
    Statement statement = null;
    Resume resume = null;

    try {
      statement = conn.createStatement();
      rs = statement.executeQuery(sql);
      while (rs.next()) {
        ProcessEnum processEnum = ProcessEnum.PASS_APPLICATION;
        processEnum.setCode(Integer.parseInt(rs.getString("process")));

        resume = new Resume(rs.getString("name"), rs.getString("id"),
                rs.getString("school"), processEnum, rs.getBoolean("deleteStatus"));
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
      return Result.errorResult();
    } finally {
      DBConnection.closeConnection(rs, statement, conn);
    }

    return Result.successResult(resume);
  }


  @Override
  public Result listResume() {
    String sql = "select * from resume where deleteStatus != 1;";
    Connection conn = DBConnection.getConnection();
    ResultSet rs = null;
    Statement statement = null;
    ResumeList resumes = new ResumeList();

    try {
      statement = conn.createStatement();
      rs = statement.executeQuery(sql);
      while (rs.next()) {
        ProcessEnum processEnum = ProcessEnum.PASS_APPLICATION;
        processEnum.setCode(Integer.parseInt(rs.getString("process")));

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

  private Resume getResumeByIDUtil(AbstractResume oldResume) {
    String sql = "select * from resume where id = '" + oldResume.getId() + "';";
    Connection conn = DBConnection.getConnection();
    ResultSet rs = null;
    Statement statement = null;
    Resume resume = null;

    try {
      statement = conn.createStatement();
      rs = statement.executeQuery(sql);
      while (rs.next()) {
        ProcessEnum processEnum = ProcessEnum.PASS_APPLICATION;
        processEnum.setCode(Integer.parseInt(rs.getString("process")));

        resume = new Resume(rs.getString("name"), rs.getString("id"),
                rs.getString("school"), processEnum, rs.getBoolean("deleteStatus"));
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
      // return Result.errorResult();
    } finally {
      DBConnection.closeConnection(rs, statement, conn);
    }

    return resume;
  }

  private ResumeList listResumeUtil() {
    String sql = "select * from resume where deleteStatus;";
    Connection conn = DBConnection.getConnection();
    ResultSet rs = null;
    Statement statement = null;
    ResumeList resumes = new ResumeList();

    try {
      statement = conn.createStatement();
      rs = statement.executeQuery(sql);
      while (rs.next()) {
        ProcessEnum processEnum = ProcessEnum.PASS_APPLICATION;
        processEnum.setCode(Integer.parseInt(rs.getString("process")));

        Resume resume = new Resume(rs.getString("name"), rs.getString("id"),
                rs.getString("school"), processEnum, rs.getBoolean("deleteStatus"));
        resumes.add(resume);
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      DBConnection.closeConnection(rs, statement, conn);
    }
    return resumes;
  }

}
