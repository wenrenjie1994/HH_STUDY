package database;

import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/hr_sys";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection connection;

    static {
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (ClassNotFoundException e){
            System.out.println("Class not found Exception:"+e.toString());
        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    /**
     * 根据驱动获得连接
     * @return
     */
    public static Connection getConnection(){
        return connection;
    }

    /**
     * 关闭链接
     */
    public static void closeConnection(){
            try {
                if(connection != null)
                    connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
    }
}
