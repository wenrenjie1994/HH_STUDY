**JDBC事务管理笔记**  


----------


**一、JDBC事务管理_概述**  
1.事务：事务就是一个包含多个步骤的业务操作；如果这个业务操作被事务管理，则这多个步骤要么同时成功，要么同时失败
2.操作：
&nbsp;&nbsp;&nbsp;a.开启事务
&nbsp;&nbsp;&nbsp;b.提交事务
&nbsp;&nbsp;&nbsp;c.回滚事务
3.使用【Connection对象】来管理事务
&nbsp;&nbsp;&nbsp;a.开启事务：setAutoCommit(boolean autoCommit)；调用该方法设置参数为false，即开启事务
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在执行sql之前开启事务
&nbsp;&nbsp;&nbsp;b.提交事务：commit()
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当所有sql都执行完毕提交事务
&nbsp;&nbsp;&nbsp;c.回滚事务：rollback()
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在catch中回滚事务
  
**二、JDBC事务管理_实现转账案例（相关代码见day0715-code）**  
1.使用PreparedStatement防止sql注入问题：修改JDBC工具类JDBCUtils.java如下  
  
    package util;
    
    import com.sun.deploy.panel.IProperty;
    
    import java.io.FileReader;
    import java.io.IOException;
    import java.net.ConnectException;
    import java.net.URL;
    import java.sql.*;
    import java.util.Properties;

    /**
     * @program: TODO
     * @className:JDBCUtils
     * @description:JDBC工具类
     * @author: 何文艺
     * creat: 2020/7/15 13:51
     **/
    public class JDBCUtils {
        private static String url;
        private static String userName;
        private static String password;
        private static String driver;
    
        //文件的读取，只需要读取一次即可拿到这些值--->使用静态代码块
        static {
            try {
                //读取资源文件，获取值
                //1.创建Properties集合类对象
                Properties pro = new Properties();
                //获取src路径下的文件的方式--->ClassLoader类加载器
                ClassLoader classLoader = JDBCUtils.class.getClassLoader();
                URL res = ClassLoader.getSystemResource("jdbc.properties");
                String path = res.getPath();
                //2.加载文件
                pro.load(new FileReader(path));
                //3.获取属性，赋值
                url = pro.getProperty("url");
                userName = pro.getProperty("userName");
                password = pro.getProperty("password");
                driver = pro.getProperty("driver");
                //4.注册驱动
            Class.forName(driver);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    
        //获取连接：返回连接对象
        public static Connection getConnnection() {
            try {
                return DriverManager.getConnection(url, userName, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    
        //释放资源：针对于有结果集的DQL操作
        public static void closeConnection(ResultSet rs, PreparedStatement pstmt, Connection conn) {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //释放资源：针对于没有结果集的DDL、DML操作
        public static void closeConnection(PreparedStatement pstmt, Connection conn) {
            closeConnection(null, pstmt, conn);
        }
    }
  
2.JDBC事务管理Demo01JDBCTransaction.java  
  
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



