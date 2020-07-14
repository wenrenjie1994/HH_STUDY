package database;

import java.sql.*;

public class DBManager {



    public static final String URL = "jdbc:mysql://127.0.0.1:3306/hr";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";


    /*
            * 1. 加载驱动

              2. 创建数据库连接

              3， 创建执行sql的语句

              4. 执行语句

              5. 处理执行结果

              6. 释放资源
            * */
    //1. 加载驱动
    static {
        try {

            Class.forName("com.mysql.jdbc.Driver");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() {
        //2. 创建数据库连接
        try {
            return  DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    //6. 释放资源
    //连接、执行、结果
    public static void closeConnection(Connection conn, Statement st, ResultSet rs){
        try {

            conn.close();
            st.close();
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void closeConnection(Connection conn, Statement st){
        closeConnection(conn,st,null);
    }


}
