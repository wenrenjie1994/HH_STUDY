package service;

import database.DBConnection;
import model.Resume;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @program: HR_SYS_3.0（基于数据库）
 * @className: ResumeService
 * @description: 与数据库交互进行增删改查
 * @author: 何文艺
 * @creat: 2020/7/12 16:34
 **/
public class ResumeService {
    public int addResume(Resume resume) {//添加简历
        String sql = "INSERT INTO resume(name, id, school, process, deleteStatus) VALUES('"
                + resume.name + "', '" + resume.id + "', '" + resume.school + "', 0, 1)";
        return executeCUD(resume, sql);
    }

    public int deleteResume(Resume resume) {//删除简历
        String sql = "UPDATE resume SET deleteStatus = 0 WHERE id = '" + resume.id + "' AND deleteStatus = 1";
        return executeCUD(resume, sql);
    }

    public int updateResume(Resume resume) {//修改简历
        String sql = "UPDATE resume SET name = '" + resume.name + "', id = '" + resume.id +
                "', school = '" + resume.school + "', process = '" + resume.process +
                "', deleteStatus = '" + resume.deleteStatus + "' WHERE id = '" + resume.id + "'";
        return executeCUD(resume, sql);
    }

    public int executeCUD(Resume resume, String sql) {
        int count = 0;
        try {
            //获取数据库的连接对象
            Connection conn = DBConnection.getConnection();
            //获取执行sql语句的对象 Statement
            Statement stmt = conn.createStatement();
            //执行sql，接收返回结果
            count = stmt.executeUpdate(sql);
            //关闭资源
            DBConnection.closeConnection(null, stmt, conn);

        } catch (SQLException e) {
            System.out.println("SQLException:" + e.toString());
        }
        return count;
    }

    public ArrayList<Resume> searchResume(int choice) {//查询简历
        Scanner input = new Scanner(System.in);
        switch (choice) {
            case 1:
                System.out.println("请输入您要查询简历的名字：");
                String name = input.nextLine();
                return searchByName(new Resume(name, null, null));
            case 2:
                System.out.println("请输入您要查询简历的身份证号：");
                String id = input.nextLine();
                return searchById(new Resume(null, id, null));
            case 3:
                System.out.println("请输入您要查询简历的学校：");
                String school = input.nextLine();
                return searchBySchool(new Resume(null, null, school));
            case 4:
                System.out.println("请输入您要查询简历的状态（0-6）：");
                int process = input.nextInt();
                Resume resume = new Resume(null, null, null);
                resume.process = process;
                return searchByProcess(resume);
            case 5:
                return searchAll();
        }
        return null;
    }

    public ArrayList<Resume> searchByName(Resume resume) {//通过姓名查找
        String sql = "SELECT * FROM resume WHERE name = '" + resume.name + "' AND deleteStatus = 1";
        return executeU(sql);
    }

    public ArrayList<Resume> searchById(Resume resume) {//通过身份证号查找
        String sql = "SELECT * FROM resume WHERE id = '" + resume.id + "' AND deleteStatus = 1";
        return executeU(sql);
    }

    public ArrayList<Resume> searchBySchool(Resume resume) {//通过学校查找
        String sql = "SELECT * FROM resume WHERE school = '" + resume.school + "' AND deleteStatus = 1";
        return executeU(sql);
    }

    public ArrayList<Resume> searchByProcess(Resume resume) {//通过简历状态查找
        String sql = "SELECT * FROM resume WHERE process = '" + resume.process + "' AND deleteStatus = 1";
        return executeU(sql);
    }

    public ArrayList<Resume> searchAll() {//查找所有简历
        String sql = "SELECT * FROM resume";
        return executeU(sql);
    }

    public ArrayList<Resume> executeU(String sql) {
        ArrayList<Resume> resumeArrayList = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Resume aResume = new Resume(rs.getString("name"), rs.getString("id"), rs.getString("school"));
                aResume.process = rs.getInt("process");
                aResume.deleteStatus = rs.getInt("deleteStatus");
                resumeArrayList.add(aResume);
            }
            DBConnection.closeConnection(null, stmt, conn);

        } catch (SQLException e) {
            System.out.println("SQLException:" + e.toString());
        }
        return resumeArrayList;
    }
}
