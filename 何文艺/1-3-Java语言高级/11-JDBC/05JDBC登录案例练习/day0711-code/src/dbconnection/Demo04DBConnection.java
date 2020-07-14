package dbconnection;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
1.通过键盘录入用户名和密码
2.判断用户是否登陆成功
*/
public class Demo04DBConnection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String username, password;
        System.out.println("请分别输入用户名和密码：");
        username = sc.nextLine();
        password = sc.nextLine();
        if (logIn(new User(username, password))) {
            System.out.println("登陆成功！");
        } else {
            System.out.println("登陆失败！");
        }
        sc.close();
    }

    public static boolean logIn(User user){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from user where userName = '" + user.username + "' and password = '" + user.password + "'";
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, stmt, conn);
        }
        return false;
    }
}
