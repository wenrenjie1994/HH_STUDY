package com.spdb.study.design.pattern.flyweight.pool;
import	java.sql.Connection;

/**
 * @author Mr.Longyx
 * @date 2020年07月06日 0:16
 */
public class Test {
    public static void main(String[] args) {
        ConnectionPool pool = new ConnectionPool();
        Connection connection = pool.getConnection();
        System.out.println(connection);
    }
}
