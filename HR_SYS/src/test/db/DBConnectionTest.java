package test.db;

import main.db.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 7/9/20 2:33 PM
 */
public class DBConnectionTest {
  public static void main(String[] args) {
    Connection conn = DBConnection.getConnection();
    Statement statement = null;
    try {
      statement = conn.createStatement();

      String sql = "select * from resume";

      ResultSet rs = statement.executeQuery(sql);
      while (rs.next()) {
        System.out.println(rs.getString("name"));
      }
      DBConnection.closeConnection(rs, statement, conn);

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {

    }

  }
}
