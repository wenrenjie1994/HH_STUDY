package com.lihang.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: LI
 * Date: 2020/7/10
 */
public class DbUtils {
    private static final String username = "root";
    private static final String password = "1234";
    private static final String url = "jdbc:mysql:///hr?serverTimezone=GMT%2B8";
    private static final String driver = "com.mysql.cj.jdbc.Driver";

    private static List<Connection> dataSource = new ArrayList<>(3);

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void release(Statement st, ResultSet res){
        if (st==null){

        }else {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (res==null){

        }else {
        try {
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }

}
