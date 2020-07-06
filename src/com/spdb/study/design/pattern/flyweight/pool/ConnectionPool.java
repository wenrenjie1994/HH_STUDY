package com.spdb.study.design.pattern.flyweight.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

/**
 * 应用享元模式模拟连接池的实现
 * @author Mr.Longyx
 * @date 2020年07月06日 0:04
 */
public class ConnectionPool {
    private Vector<Connection> pool;

    private String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
    private String username = "joe";
    private String password = "hadoop";

    private String driverClassName = "com.mysql.cj.jdbc.Driver";

    private int poolSize = 100;

    public ConnectionPool() {
        pool = new Vector<Connection> (poolSize);

        try {
            Class.forName(driverClassName);
            for(int i=0; i < poolSize; i++){
                Connection conn = DriverManager.getConnection(url,username, password);
                pool.add(conn);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public synchronized Connection getConnection() {
        if (pool.size() > 0){
            Connection conn = pool.get(0);
            pool.remove(conn);
            return conn;
        }
        return null;
    }

    public synchronized void release(Connection conn){
       pool.add(conn);
    }
}
