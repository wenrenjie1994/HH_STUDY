package com.spdb.study.design.principle.compositereuse;

/**
 * @author Mr.Longyx
 * @date 2020年06月17日 23:23
 */
public class OracleConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "获取Oracle连接";
    }
}
