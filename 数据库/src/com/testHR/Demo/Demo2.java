package com.testHR.Demo;

import com.testHR.utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @description:
 * @author: zeng
 * @modified By:
 */
public class Demo2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = DruidUtils.getConnection();
            String sql = "insert into resume(name,id,school,process,delete_status) values(?,?,?,?,?)";
            //获取执行者对象
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,"二狗");
            preparedStatement.setInt(2,2);
            preparedStatement.setString(3,"农大");
            preparedStatement.setInt(4, 1);
            preparedStatement.setInt(5, 1);
            //执行
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.close(preparedStatement, conn);
        }
    }
}
