package com.ram.utils;

import java.util.LinkedList;
import java.util.Scanner;

public class ResumeOperate {
    // 添加简历信息
    public static void addResume(LinkedList<Resume> ResumeList) {
        System.out.println("########## 欢迎来到添加简历界面 ##########");
        Scanner input = new Scanner(System.in);
        System.out.println(">>>> 请依次输入需要添加姓名，年龄，教育情况，性别:");
        String Name = input.nextLine();
        String Age = input.nextLine();
        String Education = input.nextLine();
        String Gender = input.nextLine();
        Resume resume = new Resume(Name, Age, Education, Gender);
        ResumeList.add(resume);
        System.out.println("√√√√ 您已成功添加简历!");
        showCandidate(ResumeList);
    }

    // 删除简历信息
    public static void deleteResume(LinkedList<Resume> ResumeList) {
        Scanner input = new Scanner(System.in);
        System.out.println("########## 欢迎来到删除简历界面 ##########");
        System.out.println(">>>> 请输入需要删除的简历名：");
        String Name = input.nextLine();
        int resumeCount = ResumeList.size();
        for (int i = 0; i < resumeCount; i++) {
            if (ResumeList.get(i).getName().equals(Name)) {
                ResumeList.remove(i);
                System.out.println("√√√√ 您已成功删除简历!");
                break;
            } else if (i == resumeCount - 1) {
                System.out.println("×××× 没有查找到该简历!");
            }
        }
        showCandidate(ResumeList);
    }

    // 修改简历信息
    public static void updateResume(LinkedList<Resume> ResumeList) {
        Scanner input = new Scanner(System.in);
        System.out.println("########## 欢迎来到修改简历信息界面 ##########");
        System.out.println(">>>> 请输入需要修改简历信息的人员姓名：");
        String resumeName = input.nextLine();
        int resumeCount = ResumeList.size();
        for (int i = 0; i < resumeCount; i++) {
            if (ResumeList.get(i).getName().equals(resumeName)) {
                System.out.println(">>>> 请依次输入新的姓名，年龄，教育程度：");
                String newName = input.nextLine();
                String newAge = input.nextLine();
                String newEducation = input.nextLine();
                String newGender = input.nextLine();
                Resume d = new Resume(newName, newAge, newEducation, newGender);
                ResumeList.set(i, d);
                System.out.println("√√√√ 您已成功修改成功!");
                showCandidate(ResumeList);
            } else if (i == resumeCount - 1 || resumeCount == 0) {
                System.out.println("×××× 没有查找到该简历!");
            }
        }
    }

    // 查询简历信息
    public static void searchResume(LinkedList<Resume> ResumeList) {
        Scanner input = new Scanner(System.in);
        System.out.println("########## 欢迎来到查询简历信息界面 ##########");
        System.out.println(">>>> 请输入需要查询简历信息的人员姓名：");
        String resumeName = input.nextLine();
        int resumeCount = ResumeList.size();
//        System.out.println(resumeCount);
        for (int i = 0; i < resumeCount; i ++) {
            System.out.println(i);
            if(ResumeList.get(i).getName().equals(resumeName)) {
                System.out.println(i);
                System.out.println("√√√√ 查询到" + ResumeList.get(i).getName() + "简历信息!\n");
                System.out.println("[Information] 年龄：" + ResumeList.get(i).getAge() + "\n");
                System.out.println("[Information] 学历：" + ResumeList.get(i).getEducation() + "\n");
                System.out.println("[Information] 性别：" + ResumeList.get(i).getGender() + "\n");
                break;
            }
        }
        System.out.println("×××× 未查询到该应聘者信息");
    }

    // 遍历简历信息
    public static void showCandidate(LinkedList<Resume> ResumeList) {
        Scanner input = new Scanner(System.in);
        System.out.println(">>>> 是否需要打印所有简历，是请输入Y/y，不用打印则输入任意：");
        String XUANZE = input.nextLine();
        if (XUANZE.equals("Y")||XUANZE.equals("y")) {
            System.out.println("[Information] 本简历管理系统共有" + ResumeList.size() + "个简历");
            int ResumeCount = ResumeList.size();
            for (int i = 0; i < ResumeCount; i++) {
                System.out.println("[Information] 第" + (i + 1) + "个" + "---------" + "<<" + ResumeList.get(i).getName() + ">>");
            }
        }
    }
}
