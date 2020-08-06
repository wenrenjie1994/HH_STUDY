package database;

import java.sql.*;

public class ConnectionUtil {
    static final String url = "jdbc:mysql://127.0.0.1:3306/lowbhr";
    static final String driverName = "com.mysql.jdbc.Driver";
    static final String userName = "root";
    static final String password = "root";
    private static Connection conn = null;

    /**
     *
     * jdbc连接访问数据库一般步骤：
     * (1)加载驱动程序
     * Class.forName()
     * (2)建立连接对象
     * DriverManager.getConnection()
     * (3)创建语句对象
     * conn.createStatement()
     * (4)获得SQL语句的执行结果
     * stmt.executeQuery(sql))
     * (5)关闭建立的对象，释放资源
     * close()
     */

    static {

        //加载mysql数据库驱动
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //返回连接对象
    public  static Connection getConnection(){
        try{
            conn = DriverManager.getConnection(url,userName,password);
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(ResultSet rs, Statement statement, Connection con){
        try{
            if(rs != null){
                rs.close();
            }
            if(statement != null){
                statement.close();
            }
            if(con != null){
                con.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void close(Statement statement, Connection con){
        try{
            if(statement != null){
                statement.close();
            }
            if(con != null){
                con.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
