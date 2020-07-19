package com.wtp.service;

import com.wtp.model.Resume;

import java.util.LinkedList;
import java.util.Scanner;

public class ResumeService {

    public static void addResume(LinkedList<Resume> resumeList){
        System.out.println("=========欢迎来到添加简历界面=========");
        Scanner input = new Scanner(System.in);
        System.out.println("请依次输入需要添加简历的编号、姓名、年龄、性别、学校、专业、电话、邮箱、应聘状态");
        int id = input.nextInt();
        String name = input.next();
        int age = input.nextInt();
        int sex = input.nextInt();
        String school = input.next();
        String major = input.next();
        String tel = input.next();
        String email = input.next();
        int status = input.nextInt();

        Resume resume = new Resume(id, name, age, sex, school, major, tel, email, status);
        resumeList.add(resume);
        System.out.println("您已成功添加简历");
        showResume(resumeList);
    }

    public static void deleteResume(LinkedList<Resume> resumeList){
        System.out.println("=========欢迎来到删除简历界面=========");
        System.out.println("请输入需要删除的简历姓名");
        Scanner input = new Scanner(System.in);
        String resumeName  = input.nextLine();
        int resumeCount = resumeList.size();
        for(int i=0; i<resumeCount; i++){
            if(resumeList.get(i).getName().equals(resumeName)){
                resumeList.remove(i);
                System.out.println("您已成功删除该简历");
                break;
            }
            else if(i == resumeCount-1){
                System.out.println("未找到该简历");
            }
        }
        showResume(resumeList);
    }

    public static void updateResume(LinkedList<Resume> resumeList){
        System.out.println("=========欢迎来到修改简历界面=========");
        System.out.println("请输入需要修改的简历姓名");
        Scanner input = new Scanner(System.in);
        String resumeName = input.next();
        int resumeCount = resumeList.size();
        for(int i=0; i<resumeCount; i++){
            if(resumeList.get(i).getName().equals(resumeName)){
                System.out.println("请依次输入需要添加简历的编号、姓名、年龄、性别、学校、专业、电话、邮箱、应聘状态");
                Scanner resumeInput = new Scanner(System.in);
                int id = input.nextInt();
                String name = input.next();
                int age = input.nextInt();
                int sex = input.nextInt();
                String school = input.next();
                String major = input.next();
                String tel = input.next();
                String email = input.next();
                int status = input.nextInt();

                Resume resume = new Resume(id, name, age, sex, school, major, tel, email, status);
                resumeList.set(i, resume);
                System.out.println("您已成功修改该简历");
            }
            else if(i==resumeCount-1||resumeCount==0){
                System.out.println("没有查询到该简历");
            }
        }
    }

    public static void showResume(LinkedList<Resume> resumeList){
        Scanner input = new Scanner(System.in);
        System.out.println("是否需要打印所有简历，是请输入Y，否则输入任意字符");
        String choice = input.nextLine();
        if(choice.equals("Y")){
            System.out.println(String.format("招聘系统中共有%d份简历", resumeList.size()));
            // System.out.println("招聘系统中共有" + resumeList.size() + "份简历");
            int resumeCount = resumeList.size();
            for(int i=0; i<resumeCount; i++){
                System.out.println(String.format("第%d份简历-------<<%s>>", i, resumeList.get(i).getName()));
                System.out.println(String.format("编号：%d 姓名：%s, 年龄：%d, 性别：%d, 学校：%s, 专业：%s, 电话：%s, 邮箱：%s, 状态：%d",
                        resumeList.get(i).getId(), resumeList.get(i).getName(), resumeList.get(i).getAge(),
                        resumeList.get(i).getSex(), resumeList.get(i).getSchool(), resumeList.get(i).getMajor(),
                        resumeList.get(i).getTel(), resumeList.get(i).getEmail(), resumeList.get(i).getStatus()));
            }
        }
    }


}
