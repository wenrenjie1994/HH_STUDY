package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @program: TODO
 * @className: Demo01DBConnection
 * @description: TODO
 * @author: 何文艺
 * @creat: 2020/7/11 10:58
 **/
public class Demo01DBConnection{
    public static void main(String[] args) throws Exception{
        //1.导入驱动jar包
        //2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3.获取数据库的连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
        //4.定义sql语句
        String sql = "insert into student values(8, 'tomi', 18, '男', '四川', 80, 99)";
        //5.获取执行sql语句的对象 Statement
        Statement stmt = conn.createStatement();
        //6.执行sql，接收返回结果
        int count = stmt.executeUpdate(sql);
        //7.处理结果
        System.out.println(count);
        //8.释放资源
        stmt.close();
        conn.close();
    }
}
