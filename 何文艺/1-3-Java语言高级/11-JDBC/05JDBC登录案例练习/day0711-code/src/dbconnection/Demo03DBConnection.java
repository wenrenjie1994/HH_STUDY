package dbconnection;


import util.JDBCUtils;
import java.sql.*;
import java.util.ArrayList;

/*
查询student表的数据将其封装为对象，然后打印
 */
public class Demo03DBConnection {
    public static void main(String[] args) {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "select * from student";
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                studentArrayList.add(new Student(rs.getInt("id"), rs.getString("name"),
                        rs.getInt("age"), rs.getString("sex"),
                        rs.getString("address"), rs.getInt("math"),
                        rs.getInt("english")));
            }
            for (int i = 0; i < studentArrayList.size(); i++) {
                Student s = studentArrayList.get(i);
                System.out.println("id：" + s.getId() + " 姓名：" + s.getName() + " 年龄：" + s.getAge() + " 性别：" +
                        s.getSex() + " 地址：" + s.getAddress() + " 数学：" + s.getMath() + " 英语：" + s.getEnglish());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, stmt, conn);
        }
    }
}
