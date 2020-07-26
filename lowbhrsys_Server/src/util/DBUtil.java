package util;

import java.sql.*;


public class DBUtil {
    static final String diver = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/hrsys?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
    static  final String user = "root";
    static final String password = "123456";
    Connection con = null;
    Statement statement= null;

    static {
        try {
            Class.forName(diver);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConn(){
        try{
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void closeConnection(ResultSet rs,Statement statement,Connection con) {
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

    public static void closeConnection(Statement statement,Connection con) {
        closeConnection(null,statement,con);
    }
}
