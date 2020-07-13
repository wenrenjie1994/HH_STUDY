package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DBConnection {
    static final String url = "jdbc:mysql://127.0.0.1:3306/hrsysdatabase?useSSL=false";
    static final String name = "com.mysql.jdbc.Driver";
    static final String user = "root";
    static final String password = "root";
    Connection con = null;
    Statement statement= null;

    static
    {
        try
        {
            Class.forName(name);//指定连接类型
        }
        catch(ClassNotFoundException cE)
        {
            System.out.println("Class Not Found Exception:"+cE.toString());
        }
    }
    public static Connection getConnection()
    {
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    //关闭数据库连接
    public static void closeConnection(ResultSet rs,Statement statement,Connection con)
    {
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
    public static void closeConnection(Statement statement,Connection con)
    {
        closeConnection(null,statement,con);
    }
}
