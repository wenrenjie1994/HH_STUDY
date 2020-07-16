package demo;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: TODO
 * @className:Demo01JDBCTransaction
 * @description:银行转账
 * @author: 何文艺
 * creat: 2020/7/15 14:33
 **/
public class Demo01JDBCTransaction {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        ResultSet rs = null;

        try {
            String sql1 = "update account set balance = balance - ? where id = ?";
            String sql2 = "update account set balance = balance + ? where id = ?";
            conn = JDBCUtils.getConnnection();

            //在执行sql之前开启事务
            conn.setAutoCommit(false);

            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            //id=1的账户-500
            pstmt1.setDouble(1, 500);
            pstmt1.setInt(2, 1);
            //id=2的账户+500；即完成了1-->2的转账
            pstmt2.setDouble(1, 500);
            pstmt2.setInt(2, 2);
            pstmt1.executeUpdate();

            //手动制造异常：会造成id=1的账户加上了500，但是id=2的账户并没有减去500
            int i = 3 / 0;

            pstmt2.executeUpdate();

            //当所有sql都执行完毕提交事务
            conn.commit();
        } catch (Exception e) {//出现任何异常都应该回滚，而不仅仅只是SQLException，因此此处应该抓Exception

            //在catch中回滚事务
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(pstmt1, conn);
            JDBCUtils.closeConnection(pstmt2, null);//在释放pstmt1的时候就已经释放了conn
        }
    }
}
