package com.spdb.zl.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {

    static final String DriverClassName="com.mysql.jdbc.Driver";
    static final String url="jdbc:mysql://localhost:3306/hrsys?useUnicode=true&characterEncoding=utf8";
    static final String username="root";
    static final String password="mysql*db";

    private JDBCUtil(){}

    private static JDBCUtil instance = null;


    static{
        instance = new JDBCUtil();

        try {
            Class.forName(DriverClassName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JDBCUtil getInstance(){
        return instance;
    }


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public static void release(ResultSet rs, Statement st, Connection con){
        try {
            if(rs != null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(st != null) st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                try {
                    if(con != null) con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void release_new(ResultSet rs,PreparedStatement ps,Connection con){
        try {
            if(rs != null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if(ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                try {
                    if(con != null) con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
