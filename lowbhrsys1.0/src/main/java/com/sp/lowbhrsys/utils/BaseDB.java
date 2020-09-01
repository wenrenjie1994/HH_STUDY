package com.sp.lowbhrsys.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: libobo
 * @create: 2020-07-06 22:05
 * @description:
 **/
public class BaseDB {
    protected Connection con;
    protected PreparedStatement ps;
    protected ResultSet re;

    public void setConnection(){
        con = C3P0Mysql.getInstance().getConnection();
    }
    public void rollback(){
        try {
            con.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void closeDB() {
        try {
            if (re != null) {
                re.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
