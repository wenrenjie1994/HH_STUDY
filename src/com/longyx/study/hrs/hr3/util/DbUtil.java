package com.longyx.study.hrs.hr3.util;

import java.sql.*;

/**
 * 封装对数据库相关操作(引入配置文件)
 * @author Mr.Longyx
 * @date 2020年07月20日 22:42
 */
public class DbUtil {
    /**
     * 未引入配置文件
     * @author Mr.Longyx
     * @date 2020/7/24 17:47
     *
     * private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
     * private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/orcl";
     * private static final String USERNAME = "komi";
     * private static final String PASSWORD = "hadoop";
     */

    private static final String DRIVER = ConfigReader.getInstance().getProperty("driver-name");
    private static final String DB_URL = ConfigReader.getInstance().getProperty("url");
    private static final String USERNAME = ConfigReader.getInstance().getProperty("username");
    private static final String PASSWORD = ConfigReader.getInstance().getProperty("password");

    public static Connection getConnection() {
        Connection conn = null;
        try {
            /**
             * 加载驱动
             * @author Mr.Longyx
             * @date 2020/7/20 22:47
             * @return java.sql.Connection
             */
            Class.forName(DRIVER);
            /**
             * 连接数据库
             * @author Mr.Longyx
             * @date 2020/7/20 22:47
             * @return java.sql.Connection
             */
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭语句集
     * @author Mr.Longyx
     * @date 2020/7/20 22:57
     * @param ps
     */
    public static void close(PreparedStatement ps) {
        if (null != ps){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭连接
     * @author Mr.Longyx
     * @date 2020/7/20 22:57
     * @param conn
     */
    public static void close(Connection conn){
        if (null != conn){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭结果集
     * @author Mr.Longyx
     * @date 2020/7/21 21:20
     * @param rs
     */
    public static void close(ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setAutoCommit(Connection conn, boolean autoCommit) {
        try {
            if (null != conn) {
                if (conn.getAutoCommit() != autoCommit) {
                    conn.setAutoCommit(autoCommit);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void commit(Connection conn) {
        try {
            if (null != conn) {
                /**
                 * true->false false -> true
                 * @author Mr.Longyx
                 * @date 2020/7/22 14:26
                 * @param conn
                 */
                if (!conn.getAutoCommit()) {
                    conn.commit();
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void rollback(Connection conn) {
        try {
            if (null != conn) {
                if (!conn.getAutoCommit()) {
                    conn.rollback();
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = getConnection();
            DatabaseMetaData metaData = connection.getMetaData();
            /**
             * 获取驱动程序
             * @author Mr.Longyx
             * @date 2020/7/21 14:51
             */
            String driverName = metaData.getDriverName();
            System.out.println(driverName);
            /**
             * 获取数据库产品名称
             * @author Mr.Longyx
             * @date 2020/7/21 14:52
             */
            String databaseProductName = metaData.getDatabaseProductName();
            System.out.println(databaseProductName);
            /**
             * 获取数据库主版本号
             * @author Mr.Longyx
             * @date 2020/7/21 14:48
             */
            int databaseMajorVersion = metaData.getDatabaseMajorVersion();
            System.out.println("主版本号： "+databaseMajorVersion);

            /**
             * 获取连接数据库的用户名
             * @author Mr.Longyx
             * @date 2020/7/21 14:49
             */
            String userName = metaData.getUserName();
            System.out.println(userName);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(connection);
        }

    }
}
