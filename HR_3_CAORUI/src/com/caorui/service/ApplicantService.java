package com.caorui.service;


import com.caorui.bean.Applicant;
import com.caorui.dao.ApplicantDao;

import java.io.*;
import java.util.Scanner;

public class ApplicantService {
    public static void insert() {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入招聘者姓名");
        String name = sc.nextLine();//获得学生姓名
        System.out.println("输入招聘者身份证号");
        String id = sc.nextLine();//获得学生身份证号
        System.out.println("输入招聘者学校");
        String school = sc.nextLine();

        Applicant ap = new Applicant(name, id,school);//创建一个学生对象

        ApplicantDao dao = new ApplicantDao();
        int i = dao.insert(ap);
        if (i == 1) {
            System.out.println("录入成功");
        } else {
            System.out.println("录入失败");

        }

    }

    public static void delete() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入需要删除的招聘者的身份证号");
        String id = sc.nextLine();//获得学生身份证号
        ApplicantDao dao = new ApplicantDao();
        dao.delete(id);
    }

    public static void update() {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入需要更改的招聘者的身份证号");
        String id = sc.nextLine();//获得学生身份证号
        System.out.println("请依次输入学生的姓名，学校，状态");
        String name = sc.nextLine();
        String school = sc.nextLine();
        int process = Integer.parseInt(sc.nextLine());

        //创建一个ap对象
        Applicant ap = new Applicant(name, id,school);
        ap.setProcess(process);
        ApplicantDao dao = new ApplicantDao();
        if (dao.update(ap) == 1) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    /**
     * 查询
     */
    public static void select() {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入需要查询的招聘者的身份证号");
        String id = sc.nextLine();//获得学生身份证号
        ApplicantDao dao = new ApplicantDao();
        Applicant stu = dao.queryId(id);
        if (stu == null) {
            System.out.println("查无此人");
        }else{
            if (stu.getDeleteStatus() == 0) {
                System.out.println("查无此人");
            } else {
                System.out.println("姓名：" + stu.getName() + "  " +
                        "ID：" + stu.getId() + "  " +
                        "学校：" + stu.getSchool() + "  " +
                        "状态：" + stu.getProcess()
                );
            }
        }


    }
}
