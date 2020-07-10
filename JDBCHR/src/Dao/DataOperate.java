package Dao;

import java.sql.*;
import java.util.LinkedList;

public class DataOperate {
    public static void loadData(LinkedList<Candidate> bookList) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection c = DriverManager
                    .getConnection(
                            "jdbc:mysql://127.0.0.1:3306/hr?characterEncoding=UTF-8",
                            "root", "admin");

            Statement s = c.createStatement();

            // 准备sql语句
            // 注意： 字符串要用单引号'
            // String sql = "insert into candidate01 values(null,"+"'张三'"+","+"'14岁'"+","+"'研究生'"+")";
            String sql = "select * from candidate";
            s.execute(sql);


            // 执行查询语句，并把结果集返回给ResultSet
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString(2);// 也可以使用字段的顺序
                String age = rs.getString(3);
                String education = rs.getString(4);
                Candidate ren = new Candidate(name, age, education);
                bookList.add(ren);
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void saveCandidate(LinkedList<Candidate> bookList) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try

        {
            for (int i = 0; i < bookList.size(); i++) {
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hr?characterEncoding=UTF-8",
                        "root", "admin");
                Statement s = c.createStatement();
                String sql = "insert into candidate values(null," + "'" + bookList.get(i).Name + "'" + "," + "'" + bookList.get(i).age + "'" + "," + "'" + bookList.get(i).Education + "'" + ")";
                s.execute(sql);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
