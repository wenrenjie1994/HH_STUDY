package Server;

import java.sql.*;
import java.util.LinkedList;
import java.util.Scanner;

public class JDBC {
    public static void addCandidate(String content) {
        String[] input = content.split(",");

        String Name = input[0];
        String age = input[1];
        String Education = input[2];
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try

        {

            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hr?characterEncoding=UTF-8",
                    "root", "admin");
            Statement s = c.createStatement();
            String sql = "insert into candidate values(null," + "'" + Name + "'" + "," + "'" + age + "'" + "," + "'" + Education + "'" + ")";
            s.execute(sql);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("您已成功添加简历");
        //showCandidate();
    }

    public static void deleteCandidate(String content) {



        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try

        {

            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hr?characterEncoding=UTF-8",
                    "root", "admin");
            Statement s = c.createStatement();
            String sql = "delete from candidate where name = " + "'" + content + "'";
            s.execute(sql);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("您已成功删除简历");


       //showCandidate();
    }


    public static void updateCandidate(String content) {

        String newName = content.split(",")[0];
        String newage = content.split(",")[1];
        String newEducation = content.split(",")[2];
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try

        {

            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hr?characterEncoding=UTF-8",
                    "root", "admin");
            Statement s = c.createStatement();
            String sql = "update candidate set age = " + "'" + newage + "'," + "education =" + "'" + newEducation + "'" + "where name = " + "'" + newName + "'";
            s.execute(sql);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("您已成功修改成功");
      // return showCandidate();
    }


    public static String showCandidate() {
        String fanhui="";
            //  System.out.println("本简历管理系统共有" + CandidateList.size() + "个简历");
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


            try

            {

                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hr?characterEncoding=UTF-8",
                        "root", "admin");
                Statement s = c.createStatement();
                String sql = "select * from candidate";

                // 执行查询语句，并把结果集返回给ResultSet
                ResultSet rs = s.executeQuery(sql);

                while (rs.next()) {
                    // int id = rs.getInt("id");// 可以使用字段名
                    String name = rs.getString(2);// 也可以使用字段的顺序
                    String hp = rs.getString(3);
                    String damage = rs.getString(4);
                   fanhui=fanhui+ name+","+hp+","+damage+"\n";
                }
               // s.execute(sql);

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
           // System.out.print(fanhui);
            return  fanhui;

        }
    }


