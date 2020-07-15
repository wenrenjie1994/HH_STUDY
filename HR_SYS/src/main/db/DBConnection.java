package main.db;

import java.sql.*;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 7/9/20 12:33 PM
 */
public class DBConnection {
  static final String url = "jdbc:mysql://127.0.0.1:3306/hr_sys";
  static final String name = "com.mysql.cj.jdbc.Driver";
  static final String user = "hr";
  static final String password = "hr_1234";
  Connection con = null;
  Statement statement = null;

  static {
    try {
      Class.forName(name);
    } catch (ClassNotFoundException cE) {
      System.out.println("Class Not Found Exception:" + cE.toString());
    }
  }

  public static Connection getConnection() {
    try {
      return DriverManager.getConnection(url, user, password);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static void closeConnection(ResultSet rs, Statement statement, Connection con) {
    try {
      if (rs != null) {
        rs.close();
      }
      if (statement != null) {
        statement.close();
      }
      if (con != null) {
        con.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void closeConnection(Statement statement, Connection con) {
    closeConnection(null, statement, con);
  }
}
