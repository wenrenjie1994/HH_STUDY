package Dao;

import java.sql.*;
import java.util.LinkedList;
import java.util.Scanner;

public class CandidateService {
    public static void addCandidate(LinkedList<Candidate> CandidateList) {
        System.out.println("欢迎来到添加简历界面");
        Scanner input = new Scanner(System.in);
        System.out.println("请依次输入需要添加姓名，年龄，教育情况");
        String Name = input.nextLine();
        String age = input.nextLine();
        String Education = input.nextLine();
        Candidate book = new Candidate(Name, age, Education);
        CandidateList.add(book);
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
        showCandidate(CandidateList);
    }

    public static void deleteCandidate(LinkedList<Candidate> CandidateList) {
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎来到删除简历界面");
        System.out.println("请输入需要删除的简历名");
        String Name = input.nextLine();


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
            String sql = "delete from candidate where name = " + "'" + Name + "'";
            s.execute(sql);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("您已成功删除简历");


        showCandidate(CandidateList);
    }


    public static void updateCandidate(LinkedList<Candidate> CandidateList) {
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎来到修改简历界面");
        System.out.println("请输入需要修改的简历名");
        String jianliName = input.nextLine();
        System.out.println("请依次输入新的姓名，年龄，教育程度");
        String newName = input.nextLine();
        String newage = input.nextLine();
        String newEducation = input.nextLine();
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
            String sql = "update candidate set age = " + "'" + newage + "'," + "education =" + "'" + newEducation + "'" + "where name = " + "'" + jianliName + "'";
            s.execute(sql);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("您已成功修改成功");
        showCandidate(CandidateList);
    }


    public static void showCandidate(LinkedList<Candidate> CandidateList) {
        Scanner input = new Scanner(System.in);
        System.out.println("是否需要打印所有简历，是请输入Y，不用打印则输入任意");
        String XUANZE = input.nextLine();
        String Y = "Y";
        if (XUANZE.equals(Y)) {
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
                    System.out.printf("%s\t%s\t%s\n", name, hp, damage);
                }
                s.execute(sql);

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
