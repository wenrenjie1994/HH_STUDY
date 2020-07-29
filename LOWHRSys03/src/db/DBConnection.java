package db;

import sun.awt.geom.AreaOp;

import java.sql.*;

public class DBConnection {
    //数据库地址及相关信息
    private static final String URL = "jdbc:mysql://localhost:3306/lowhrsys?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai";
    private static final String NAME = "root";
    private static final String PASSWORD = "123456";

    //驱动名称
    private static final String JDBCNAME = "com.mysql.cj.jdbc.Driver";

    Connection connection = null;
    Statement statement = null;

    static {
        try {
            //加载驱动程序
            Class.forName(JDBCNAME);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try{
            //连接数据库
            return DriverManager.getConnection(URL,NAME,PASSWORD);
        }catch (SQLException e){
            return null;
        }
    }

    public static void closeConnection(ResultSet rs,Statement statement,Connection connection){
        try{
            if (rs != null){
                rs.close();
            }
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void closeConnection(Statement statement, Connection connection){
        closeConnection(null,statement,connection);
    }
}
