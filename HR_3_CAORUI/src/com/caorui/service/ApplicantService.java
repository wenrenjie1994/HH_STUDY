package com.caorui.service;


import com.caorui.bean.Applicant;
import com.caorui.dao.ApplicantDao;

import java.io.*;
import java.util.ArrayList;
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
        System.out.println("根据身份证查询请输入1");
        System.out.println("根据姓名查询请输入2");
        System.out.println("根据学校查询请输入3");
        System.out.println("根据状态查询请输入4");
        int choice=Integer.parseInt(sc.nextLine());
        ApplicantDao dao = new ApplicantDao();
        ArrayList<Applicant> list=null;
        if(choice==1){
            System.out.println("输入需要查询的招聘者的身份证号");
            String id = sc.nextLine();//获得学生身份证号
            list= dao.queryId(id);
        }else if(choice==2){
            System.out.println("输入需要查询的招聘者的姓名");
            String name = sc.nextLine();
            list = dao.queryName(name);
        }else if(choice==3){
            System.out.println("输入需要查询的招聘者的学校");
            String school = sc.nextLine();
            list=dao.querySchool(school);
        }else if(choice==4){
            System.out.println("输入需要查询的招聘者的状态");
            int process=sc.nextInt();
           list=dao.queryProcess(process);
        }



        if (list == null) {
            System.out.println("查无此人");
        }else{
            for(Applicant app:list){
                if (app.getDeleteStatus() != 0) {
                    System.out.println("姓名：" + app.getName() + "  " +
                            "ID：" + app.getId() + "  " +
                            "学校：" + app.getSchool() + "  " +
                            "状态：" + app.getProcess()
                    );
                }
            }

        }


    }
}
