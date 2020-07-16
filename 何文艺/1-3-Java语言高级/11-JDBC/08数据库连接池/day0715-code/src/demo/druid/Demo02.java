package demo.druid;

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @program: TODO
 * @className:Demo02
 * @description:druid工具类测试
 * @author: 何文艺
 * creat: 2020/7/16 10:06
 **/
public class Demo02 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            //1.获取数据库连接
            conn = JDBCUtils.getConnection();
            //2.创建sql语句
            String sql = "insert into account values(5,?,?)";
            //获取执行sql语句的对象
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"大海");
            pstmt.setDouble(2,3600);
            //执行sql语句
            int count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt,conn);
        }
    }
}
