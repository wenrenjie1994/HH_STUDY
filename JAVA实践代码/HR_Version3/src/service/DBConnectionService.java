package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 熊彩铃
 * @program HR_Version3数据库版招聘系统
 * @description 数据库连接操作
 * @date 2020/7/11 12:34
 */
public class DBConnectionService {
    static final String URL = "jdbc:mysql://127.0.0.1:3306/resumes?serverTimezone=UTC";
    static final String NAME = "com.mysql.cj.jdbc.Driver";
    static final String USER = "root";
    static final String PASSWORD = "root";
    Connection connection = null;
    Statement statement = null;

    static {
        try {
            Class.forName(NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(ResultSet resultSet, Statement statement, Connection connection)
    {
        try {
            if(resultSet!=null) {
                resultSet.close();
            }
            if(statement!=null) {
                statement.close();
            }
            if(resultSet!=null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(Statement statement,Connection connection){
        closeConnection(null,statement,connection);
    }
}
