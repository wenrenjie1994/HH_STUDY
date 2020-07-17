package com.caorui.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.LinkedList;

public class ConnectionPool {
    public static LinkedList<Connection> cs;
    public ConnectionPool() {
        cs=new LinkedList<>();
        for (int i=0;i<10;i++){
            cs.add(JDBCUtils.getConnection());
        }
    }

    public synchronized Connection getConnection(){
        while(cs.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return cs.remove(0);

    }
    public synchronized  void closeConnection(Connection conn){
        cs.add(conn);
        this.notifyAll();
    }




}
