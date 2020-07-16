package database;

import bean.Operation;
import bean.Resume;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatementGenerator {
    Connection connection;

    public StatementGenerator(Connection connection) {
        this.connection = connection;
    }


    /**
     * 根据传入的Operation对象获取操作类型及操作对象
     * 封装成为SQL statement 交由Controller执行
     * @param operation
     * @return
     * @throws SQLException
     */
    public PreparedStatement createSqlStatement(Operation<Resume> operation) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "";
        if (operation.getOperation().equals("queryAll")) {
            sql = "SELECT * from tb_resume";
            preparedStatement = connection.prepareStatement(sql);
        }
        if (operation.getOperation().equals("query")) {
            sql = "SELECT * from tb_resume WHERE name=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, operation.getObject().getName());
        }
        if (operation.getOperation().equals("add")) {
            Resume resume = operation.getObject();
            sql = "INSERT INTO tb_resume (name,id,school,process) values(?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, resume.getName());
            preparedStatement.setString(2, resume.getId());
            preparedStatement.setString(3, resume.getSchool());
            preparedStatement.setInt(4, resume.getProcess());
        }
        if (operation.getOperation().equals("update")) {
            Resume resume = operation.getObject();
            sql = "UPDATE tb_resume SET name =?,id=?,school=?,process=?,deleteStatus=? where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(6, resume.getName());
            preparedStatement.setString(1, resume.getName());
            preparedStatement.setString(2, resume.getId());
            preparedStatement.setString(3, resume.getSchool());
            preparedStatement.setInt(4, resume.getProcess());
            preparedStatement.setInt(5, resume.getDeleteStatus());
        }
        if (operation.getOperation().equals("delete")) {
            sql = "UPDATE tb_resume SET deleteStatus = ? WHERE name=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, operation.getObject().getName());
        }

        return preparedStatement;
    }
}
