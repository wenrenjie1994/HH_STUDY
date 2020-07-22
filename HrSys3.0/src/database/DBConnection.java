package database;

/**
 * Created by IntelliJ IDEA
 * @Author LC
 * @create 2020/7/12
 */

import java.sql.*;

public class DBConnection {

    static final String url = "jdbc:mysql://127.0.0.1:3306/resumemis";
    static final String user = "root";
    static final String password = "lc1178268702";
    Connection connection = null;
    Statement statement =null;

    static {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException cE)
        {
            System.out.println("Class Not Found Exception:"+cE.toString());
        }
    }
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void closeConnection(ResultSet rs, Statement statement, Connection con) {
        try {
            if(rs!=null) {
                rs.close();
            }
            if(statement!=null) {
                statement.close();
            }
            if(con!=null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
