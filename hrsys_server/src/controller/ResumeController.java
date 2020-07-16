package controller;

import bean.Operation;
import bean.ResponseTemplate;
import bean.Resume;
import bean.SQLResult;
import database.DBConnection;
import database.StatementGenerator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * MVC中的C层，负责向数据库获取数据并回传给客户端
 */
public class ResumeController {
    Operation<Resume> operation;
    Connection connection;

    public ResumeController(Operation<Resume> operation) {
        this.operation = operation;
    }

    public void setOperation(Operation<Resume> operation) {
        this.operation = operation;
    }

    /**
     * 获取数据库连接，并生成要执行的statement
     * @param operation 将被解析的operation对象
     * @return
     * @throws SQLException
     */
    private PreparedStatement createSqlStatement(Operation<Resume> operation) throws SQLException {
        connection = DBConnection.getConnection();
        StatementGenerator generator = new StatementGenerator(connection);
        return generator.createSqlStatement(operation);
    }

    private SQLResult executeSql(PreparedStatement statement) {
        try {
            SQLResult SQLResult;
            if (operation.getOperation().contains("query")) {
                ResultSet resultSet = statement.executeQuery();
                SQLResult = new SQLResult(-1, resultSet);
            } else {
                int rows = statement.executeUpdate();
                SQLResult = new SQLResult(rows, null);
            }

            return SQLResult;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * 执行sql语句，根据操作不同生成不同的返回对象
     * @return responseTemplate模板，包含返回数据的条目和数据体
     * 如果客户端请求执行query,queryAll，返回数据体
     * 如果客户端请求执行add,delete,update，仅返回数据条目，大于等于1为执行成功，0则执行失败
     * @throws SQLException
     */
    public ResponseTemplate<Resume> executeOperation() throws SQLException {
        ResponseTemplate<Resume> resumeResponse = new ResponseTemplate<>();

        List<Resume> resumeList = new ArrayList<>();
        PreparedStatement preparedStatement = createSqlStatement(operation);
        SQLResult SQLResult = executeSql(preparedStatement);
        if (SQLResult != null) {
            ResultSet resultSet = SQLResult.getResultSet();
            if (resultSet != null) {
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String id = resultSet.getString("id");
                    String school = resultSet.getString("school");
                    int process = resultSet.getInt("process");
                    int deleteStatus = resultSet.getInt("deleteStatus");
                    Resume resume = new Resume();
                    resume.setName(name);
                    resume.setId(id);
                    resume.setSchool(school);
                    resume.setProcess(process);
                    resume.setDeleteStatus(deleteStatus);
                    resumeList.add(resume);
                }
                resumeResponse.setRows(resumeList.size());
                resumeResponse.setList(resumeList);
                return resumeResponse;
            }
            if (SQLResult.getRows() != -1) {
                resumeResponse.setRows(SQLResult.getRows());
                return resumeResponse;
            }

        }
        return resumeResponse;
    }

}
