package database;

import java.sql.*;

public class DBconnection
{
        static final String url="jdbc:mysql://localhost:3306/candidates";
        static final String name="com.mysql.jdbc.Driver";
        static final String username="root";
        static final String password="123";
        Connection con=null;
        Statement statement=null;

            static
            {
                try
                {
                    Class.forName(name);
                }
                catch (ClassNotFoundException cE)
                {
                    System.out.println("Class Not Found Exception:"+cE.toString());
                }
            }

            public static Connection getConnection()
            {
                try
                {
                   return DriverManager.getConnection(url,username,password);
                }catch (SQLException e){
                    e.printStackTrace();
                    return null;
                }
            }

            public static void closeConnection(ResultSet rs,Statement statement,Connection con)
            {
                try
                {
                    if(rs!=null){
                        rs.close();
                    }
                    if(statement!=null){
                        statement.close();
                    }
                    if(con!=null){
                        con.close();
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            public static void closeConnection(Statement statement,Connection con)
            {
                closeConnection(null,statement,con);
            }






}
