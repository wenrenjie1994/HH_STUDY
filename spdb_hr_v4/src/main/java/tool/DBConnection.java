package tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    static final String url = "jdbc:mysql://127.0.0.1:3306/hrmis";
    static final String name = "com.mysql.jdbc.Driver";
    static final String user = "root";
    static final String passwprd = "12345";

    static {
        try {
            Class.forName(name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,passwprd);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void closeConnection(Statement  statement,Connection con){
        try{
            if(statement!=null)
                statement.close();
            if(con!=null)
                con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
