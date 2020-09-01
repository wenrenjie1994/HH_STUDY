package com.sp.lowbhrsys.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.util.Properties;

/**
 * @author: libobo
 * @create: 2020-07-06 21:19
 * @description: 用于连接数据库，创建连接
 **/
public class C3P0Mysql {
    private ComboPooledDataSource cpds;
    private static C3P0Mysql c3P0Properties;
    static{
        c3P0Properties = new C3P0Mysql();
    }
    public C3P0Mysql() {
        try {
            cpds = new ComboPooledDataSource();
            //加载配置文件
            Properties props = new Properties();
            props.load(C3P0Mysql.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            cpds.setDriverClass(props.getProperty("DriverClass"));
            cpds.setJdbcUrl(props.getProperty("JdbcUrl"));
            cpds.setUser(props.getProperty("User"));
            cpds.setPassword(props.getProperty("Password"));
            //连接池中保留的最大连接数。Default: 15
            cpds.setMaxPoolSize(Integer.parseInt(props.getProperty("MaxPoolSize")));
            //连接池保持的最小连接数,default : 3
            cpds.setMinPoolSize(Integer.parseInt(props.getProperty("MinPoolSize")));
            //连接池初始化连接数量
            cpds.setInitialPoolSize(Integer.parseInt(props.getProperty("InitialPoolSize")));
            //连接池最大连接数
            cpds.setMaxStatements(Integer.parseInt(props.getProperty("MaxStatements")));
            //最大空闲时间,60秒内未使用则连接被丢弃。若为0则永不丢弃。Default: 0
            cpds.setMaxIdleTime(Integer.parseInt(props.getProperty("MaxIdleTime")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static C3P0Mysql getInstance(){
        return c3P0Properties;
    }

    public Connection getConnection(){
        Connection conn = null;
        try {
            conn = cpds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
