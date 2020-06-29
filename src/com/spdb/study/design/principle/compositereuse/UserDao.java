package com.spdb.study.design.principle.compositereuse;

/**
 * @author Mr.Longyx
 * @date 2020年06月17日 23:16
 */
public class UserDao {
    private DBConnection dbConnection;
    public void setConnection(DBConnection connection){
        this.dbConnection = connection;
    }

    public void addUser(){
        dbConnection.getConnection();
        System.out.println("获取到MySQL连接");
    }
}
