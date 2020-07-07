package com.ram.utils;
import sun.awt.windows.WPrinterJob;

import java.util.LinkedList;
import java.util.Scanner;

public class CandidateOperate {
    // 添加简历信息
    public static void addCandidate(LinkedList<Candidate> CandidateList) {
        System.out.println("########## 欢迎来到添加简历界面 ##########");
        Scanner input = new Scanner(System.in);
        System.out.println(">>>> 请依次输入需要添加姓名，年龄，教育情况，性别:");
        String Name = input.nextLine();
        String Age = input.nextLine();
        String Education = input.nextLine();
        String Gender = input.nextLine();
        Candidate candi = new Candidate(Name, Age, Education, Gender);
        CandidateList.add(candi);
        System.out.println("√√√√ 您已成功添加简历!");
        showCandidate(CandidateList);
    }

    // 删除简历信息
    public static void deleteCandidate(LinkedList<Candidate> CandidateList) {
        Scanner input = new Scanner(System.in);
        System.out.println("########## 欢迎来到删除简历界面 ##########");
        System.out.println(">>>> 请输入需要删除的简历名：");
        String Name = input.nextLine();
        int resumeCount = CandidateList.size();
        for (int i = 0; i < resumeCount; i++) {
            if (CandidateList.get(i).getName().equals(Name)) {
                CandidateList.remove(i);
                System.out.println("√√√√ 您已成功删除简历!");
                break;
            } else if (i == resumeCount - 1) {
                System.out.println("×××× 没有查找到该简历!");
            }
        }
        showCandidate(CandidateList);
    }

    // 修改简历信息
    public static void updateCandidate(LinkedList<Candidate> CandidateList) {
        Scanner input = new Scanner(System.in);
        System.out.println("########## 欢迎来到修改简历信息界面 ##########");
        System.out.println(">>>> 请输入需要修改简历信息的人员姓名：");
        String resumeName = input.nextLine();
        int resumeCount = CandidateList.size();
        for (int i = 0; i < resumeCount; i++) {
            if (CandidateList.get(i).getName().equals(resumeName)) {
                System.out.println(">>>> 请依次输入新的姓名，年龄，教育程度：");
                String newName = input.nextLine();
                String newAge = input.nextLine();
                String newEducation = input.nextLine();
                String newGender = input.nextLine();
                Candidate d = new Candidate(newName, newAge, newEducation, newGender);
                CandidateList.set(i, d);
                System.out.println("√√√√ 您已成功修改成功!");
                showCandidate(CandidateList);
            } else if (i == resumeCount - 1 || resumeCount == 0) {
                System.out.println("×××× 没有查找到该简历!");
            }
        }
    }

    // 查询简历信息
    public static void searchCandidate(LinkedList<Candidate> CandidateList) {
        Scanner input = new Scanner(System.in);
        System.out.println("########## 欢迎来到查询简历信息界面 ##########");
        System.out.println(">>>> 请输入需要查询简历信息的人员姓名：");
        String resumeName = input.nextLine();
        int resumeCount = CandidateList.size();
//        System.out.println(resumeCount);
        for (int i = 0; i < resumeCount; i ++) {
            System.out.println(i);
            if(CandidateList.get(i).getName().equals(resumeName)) {
                System.out.println(i);
                System.out.println("√√√√ 查询到" + CandidateList.get(i).getName() + "简历信息!\n");
                System.out.println("[Information] 年龄：" + CandidateList.get(i).getAge() + "\n");
                System.out.println("[Information] 学历：" + CandidateList.get(i).getEducation() + "\n");
                System.out.println("[Information] 性别：" + CandidateList.get(i).getGender() + "\n");
                break;
            }
        }
        System.out.println("×××× 未查询到该应聘者信息");
    }

    // 遍历简历信息
    public static void showCandidate(LinkedList<Candidate> CandidateList) {
        Scanner input = new Scanner(System.in);
        System.out.println(">>>> 是否需要打印所有简历，是请输入Y/y，不用打印则输入任意：");
        String XUANZE = input.nextLine();
        if (XUANZE.equals("Y")||XUANZE.equals("y")) {
            System.out.println("[Information] 本简历管理系统共有" + CandidateList.size() + "个简历");
            int CandidateCount = CandidateList.size();
            for (int i = 0; i < CandidateCount; i++) {
                System.out.println("[Information] 第" + (i + 1) + "个" + "---------" + "<<" + CandidateList.get(i).getName() + ">>");
            }
        }
    }
}
