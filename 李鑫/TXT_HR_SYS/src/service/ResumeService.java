package service;
import model.Resume;

import java.util.LinkedList;
import java.util.Scanner;


public class ResumeService {

    public static void addResume(LinkedList<Resume> resumeList) {
        System.out.println("欢迎来到简历添加界面");
        System.out.println("请依次输入学生名字，学生身份证号，学生学校");

        Scanner input = new Scanner(System.in);
        String name = input.next();
        String id = input.next();
        String school = input.next();

        Resume r = new Resume(name, id, school);
        resumeList.add(r);
        System.out.println("您已成功添加图书");
    }

    // 通过名字删除简历
    public static void delResume(LinkedList<Resume> resumeList) {
        System.out.println("欢迎来到简历删除界面");
        System.out.println("请输入需要删除的简历的学生名字");

        Scanner input = new Scanner(System.in);
        String name = input.next();

        int resumeSize = resumeList.size();
        if(resumeSize == 0) {
            System.out.println("暂无简历数据，请添加:(");
            return;
        }

        for (int i=0; i<resumeSize; i++) {
            Resume r = resumeList.get(i);
            if(r.getName().equals(name)) {
                resumeList.remove(i);
                System.out.println("您已成功删除" + name + "的简历");
                break;
            }
            else if(i == resumeSize-1) {
                System.out.println("没有查找到该简历，无法删除:(");
            }
        }
    }

    // 通过名字修改简历信息
    public static void updateResume(LinkedList<Resume> resumeList) {
        System.out.println("欢迎来到简历信息修改界面");
        System.out.println("请输入需要修改的简历的学生名字");

        Scanner input = new Scanner(System.in);
        String name = input.next();

        System.out.println("请依次输入学生名字，学生身份证号，学生学校");
        String newName = input.next();
        String newId = input.next();
        String newSchool = input.next();

        int resumeSize = resumeList.size();
        if(resumeSize == 0) {
            System.out.println("暂无简历数据，请添加:(");
            return;
        }

        for(int i=0; i<resumeSize; i++) {
            Resume r = resumeList.get(i);
            if(r.getName().equals(name)) {
                r.setName(newName);
                r.setId(newId);
                r.setSchool(newSchool);
                System.out.println("您已成功修改原名为" + name + "的简历信息");
                break;
            }
            else if(i == resumeSize-1) {
                System.out.println("没有找到该简历:(");
            }
        }
    }

    // 通过名字显示简历信息
    public static void showResume(LinkedList<Resume> resumeList) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要显示简历信息的名字");
        String name = input.next();

        int resumeSize = resumeList.size();
        if(resumeSize == 0) {
            System.out.println("暂无简历数据，请添加:(");
            return;
        }

        for(int i=0; i<resumeSize; i++) {
            Resume r = resumeList.get(i);
            if(r.getName().equals(name)) {
                System.out.println(name + "的身份证号是：" + r.getId() + "，学校是：" + r.getSchool());
                break;
            }
            else if(i == resumeSize-1) {
                System.out.println("暂无" + name + "的简历信息:(");
            }
        }
    }
}
