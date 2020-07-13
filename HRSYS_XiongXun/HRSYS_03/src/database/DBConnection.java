package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection

{
    static final String url = "jdbc:mysql://localhost:3306/hrsys?useUnicode=true&characterEncoding=utf-8";
    static final String name = "com.mysql.jdbc.Driver";
    static final String user = "root";
    static final String password = "123456";

    static
    {
        try
        {
            Class.forName(name);//加载数据库驱动
        }
        catch(ClassNotFoundException cE)
        {
            System.out.println("Class Not Found Exception:"+cE.toString());
        }
    }

    /**
     * 获取连接
     * @return
     */
    public static Connection getConnection()
    {
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 关闭连接
     * @param rs
     * @param statement
     * @param con
     */
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

