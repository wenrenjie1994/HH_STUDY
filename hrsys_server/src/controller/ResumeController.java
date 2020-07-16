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

public class ResumeController {
    Operation<Resume> operation;
    Connection connection;

    public ResumeController(Operation<Resume> operation) {
        this.operation = operation;
    }

    public void setOperation(Operation<Resume> operation) {
        this.operation = operation;
    }

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
