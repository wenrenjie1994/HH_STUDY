package bean;

import java.sql.*;

public class DBConnection
{
    static final String url = "jdbc:mysql:localhost:1521/hrsys";
    static final String name = "com.mysql.jdbc.Driver";
    static final String user = "scott";
    static final String password = "123456";
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