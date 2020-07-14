package com.testHR.utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @description:
 * @author: zeng
 * @modified By:
 */
public class TransctionUtils {
    //定义线程局部类存放线程与连接对象
    private static final ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    //获取连接
    public static Connection getConnection() throws SQLException {
        //先从局部类中获取对象
        Connection conn = tl.get();
        //因为不一定是第一次获取，先判断有无Connection对象
        if(conn==null){
            //第一次获取时
            conn = DruidUtils.getConnection();
            tl.set(conn);
        }
        return conn;
    }
    public static void startTransction() throws SQLException {
        TransctionUtils.getConnection().setAutoCommit(false);
    }
    public static void commit() throws SQLException {
        TransctionUtils.getConnection().commit();
    }
    public static void rollback() throws SQLException {
        TransctionUtils.getConnection().rollback();
    }
}
