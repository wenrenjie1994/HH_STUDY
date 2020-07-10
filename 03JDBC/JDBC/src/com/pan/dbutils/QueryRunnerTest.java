package com.pan.dbutils;

import com.pan.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;

public class QueryRunnerTest {
    //测试插入
    @Test
    public void testInsert() {
        Connection connection = null;
        try {
            QueryRunner runner = new QueryRunner();
            connection = JDBCUtils.getConnection1();
            String sql = "insert into customers(name,email,birth)values(?,?,?)";
            int insertCount = runner.update(connection, sql, "蔡徐坤", "caixukun@126.com", "1998-09-08");
            System.out.println("添加了"+insertCount+"条记录");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,null);
        }
    }

}
