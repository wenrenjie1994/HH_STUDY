package sys;

import bean.Resume;
import utils.DBConnection;
import utils.ResumeOperate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Scanner;

public class HRS {
    public static void main(String[] args) {
        boolean isExitRequested = false;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("***** 欢迎进入简历管理系统 *****");
            System.out.println("展示简历：0");
            System.out.println("添加简历：1");
            System.out.println("删除简历：2");
            System.out.println("修改简历：3");
            System.out.println("查询简历：4");
            System.out.println("退出请按：5");
            switch (sc.nextInt()) {
                case 0:
                    showResume();
                    break;
                case 1:
                    addResume();
                    break;
                case 2:
                    deleteResume();
                    break;
                case 3:
                    updateResume();
                    break;
                case 4:
                    searchResume();
                    break;
                case 5:
                    isExitRequested = true;
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
            }
            if (isExitRequested) {
                break;
            }
        }
        sc.close();
        System.out.println("已退出！");
    }

    /**
     * 展示简历
     */
    private static void showResume() {
        LinkedList<Resume> resumes = new LinkedList<>();
        try {
            Connection con = DBConnection.getConnection();
            Statement statement = con.createStatement();
            String sql = "select * from resumes";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Resume r = new Resume(rs.getString("name"), rs.getString("id"), rs.getString("school"));
                r.setProcess(rs.getInt("process"));
                r.setDeleteStatus(rs.getInt("deleteStatus"));
                resumes.add(r);
            }
            DBConnection.closeConnection(rs, statement, con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("本简历管理系统共有" + resumes.size() + "份简历！");
        for (Resume resume : resumes) {
            System.out.println(resume);
        }
    }

    /**
     * 添加简历
     */
    private static void addResume() {
        Scanner input = new Scanner(System.in);
        System.out.println("***** 添加简历(请依次输入姓名、身份证号、学校) *****");
        String name = input.nextLine();
        String id = input.nextLine();
        String school = input.nextLine();
        Resume resume = new Resume(name, id, school);
        int line = new ResumeOperate().addResume(resume);
        if (line > 0) System.out.println("已添加！");
        else System.out.println("添加失败！");
    }

    /**
     * 删除简历
     */
    private static void deleteResume() {
        Scanner input = new Scanner(System.in);
        System.out.println("***** 删除简历(请输入身份证号) *****");
        String id = input.nextLine();
        Resume resume = new Resume(null, id, null);
        int line = new ResumeOperate().deleteResumeById(resume);
        if (line > 0) System.out.println("已删除！");
        else System.out.println("没有找到您想要删除的简历！");
    }

    /**
     * 更新简历
     */
    private static void updateResume() {
        Scanner input = new Scanner(System.in);
        System.out.println("***** 修改简历(请输入身份证号) *****");
        String id = input.nextLine();
        Resume oldResume = new Resume(null, id, null);
        if (new ResumeOperate().searchResumeById(oldResume).size() > 0) {
            System.out.println("找到原简历（请依次输入新的姓名、身份证号、学校、简历状态）");
            String newName = input.nextLine();
            String newID = input.nextLine();
            String newSchool = input.nextLine();
            int newProcess = input.nextInt();
            Resume newResume = new Resume(newName, newID, newSchool);
            newResume.setProcess(newProcess);
            new ResumeOperate().updateResumeById(newResume, oldResume);
        } else System.out.println("没有找到您想要修改的简历！");
    }

    /**
     * 查找简历
     */
    private static void searchResume() {
        Scanner sc = new Scanner(System.in);
        boolean isExitRequested = false;
        while (true) {
            System.out.println("***** 查找简历(按姓名查找：0；按身份证号查找：1；退出：2) *****");
            switch (sc.nextInt()) {
                case 0:
                    searchResumeByName();
                    break;
                case 1:
                    searchResumeById();
                    break;
                case 2:
                    isExitRequested = true;
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
            }
            if (isExitRequested) {
                break;
            }
        }
        System.out.println("已退出简历查找系统！");
    }

    private static void searchResumeByName() {
        Scanner input = new Scanner(System.in);
        System.out.println("***** 查找简历(请输入姓名) *****");
        String name = input.nextLine();
        Resume resume = new Resume(name, null, null);
        LinkedList<Resume> resumes = new ResumeOperate().searchResumeByName(resume);
        if (resumes.size() > 0) {
            System.out.println("通过姓名共查到" + resumes.size() + "份简历！");
            for (Resume r : resumes) {
                System.out.println(r);
            }
        } else System.out.println("没有查找到相应简历！");
    }

    private static void searchResumeById() {
        Scanner input = new Scanner(System.in);
        System.out.println("***** 查找简历(请输入身份证号) *****");
        String id = input.nextLine();
        Resume resume = new Resume(null, id, null);
        LinkedList<Resume> resumes = new ResumeOperate().searchResumeById(resume);
        if (resumes.size() > 0) {
            System.out.println("通过身份证号共查到" + resumes.size() + "份简历！");
            for (Resume r : resumes) {
                System.out.println(r);
            }
        } else System.out.println("没有查找到相应简历！");
    }
}
