package com.pan.blob;

import com.pan.util.JDBCUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BlobTest {
    //向customers表中插入Blob类型字段
    @Test
    public void testInsert() throws SQLException, IOException, ClassNotFoundException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into customers(name,email,birth,photo)values(?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setObject(1,"林芝");
        preparedStatement.setObject(2,"lin@qq.com");
        preparedStatement.setObject(3,"1992-09-12");
        FileInputStream is = new FileInputStream(new File("bizhi.jpg"));
        preparedStatement.setBlob(4,is);

        preparedStatement.execute();
        JDBCUtils.closeResource(connection,preparedStatement);
    }


}
