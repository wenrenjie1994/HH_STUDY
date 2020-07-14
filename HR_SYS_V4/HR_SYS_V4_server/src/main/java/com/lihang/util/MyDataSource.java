package com.lihang.util;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: LI
 * Date: 2020/7/10
 */
public class MyDataSource implements DataSource {
    private static final Integer connSize = 10;
    private static List<Connection> conns = new ArrayList<>(10);
    public MyDataSource(){
       for (int i = 0;i<connSize;i++){
           Connection conn = DbUtils.getConnection();
           conns.add(conn);
       }
    }
    @Override
    public Connection getConnection() throws SQLException {
        if (conns.size()==0){
            for (int i = 0;i<connSize;i++){
                Connection conn = DbUtils.getConnection();
                conns.add(conn);
            }
        }
        Connection conn = conns.remove(0);
        return conn;
    }
    public void reBack(Connection conn){
        conns.add(conn);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
