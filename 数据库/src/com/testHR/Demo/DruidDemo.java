package com.testHR.Demo;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @description:
 * @author: zeng
 * @modified By:
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //加载配置文件
        Properties properties = new Properties();
        InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(is);
        //获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
