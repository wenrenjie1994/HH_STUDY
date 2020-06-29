package com.spdb.study.design.principle.compositereuse;

/**
 * @author Mr.Longyx
 * @date 2020年06月17日 23:21
 */
public class MySQLConnection extends DBConnection{
    @Override
    public String getConnection() {
        return "获取MySQL连接";
    }
}
