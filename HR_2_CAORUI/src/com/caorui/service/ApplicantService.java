package com.caorui.service;


import com.caorui.bean.Applicant;
import com.caorui.data.DataControl;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class ApplicantService {
    public static void insert() {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入招聘者姓名");
        String name = sc.nextLine();//获得学生姓名
        System.out.println("输入招聘者身份证号");
        String id = sc.nextLine();//获得学生身份证号

        Applicant ap = new Applicant(name, id);//创建一个学生对象

        //先拿到原有的所有名单list
        try {
            LinkedList<Applicant> apList = DataControl.getApList();

            apList.add(ap);//把该对象放到list里
            DataControl.Write(apList);//把list内容写入到文件中

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("录入成功");
    }

    public  static void delete() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入需要删除的招聘者的身份证号");
        String id = sc.nextLine();//获得学生身份证号


        try {
            //拿到所有的学生信息
            LinkedList<Applicant> apList = DataControl.getApList();

            //遍历list，寻找到需要的那条，并删除
            for (Applicant ap : apList) {
                if (ap.getId().equals(id)) {
                    ap.setDeleteStatus(0); //修改ap的属性
                    break;
                }
            }
            //把list写入文件
            DataControl.Write(apList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void update() {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入需要更改的招聘者的身份证号");
        String id = sc.nextLine();//获得学生身份证号

        //先找到这个学生，把他的信息拿到，并从列表中删除
        try {
            //拿到所有的学生信息
            LinkedList<Applicant> apList = DataControl.getApList();

            //遍历list，寻找到需要的那条，并删除
            for (Applicant ap : apList) {
                if (ap.getId().equals(id)) {
                    apList.remove(ap); //修改ap的属性
                    break;
                }
            }
            //开始重新记录该学生的其他信息
            Applicant student = null;

            System.out.println("请依次输入学生的姓名，学校，状态");
            String name = sc.nextLine();
            String school = sc.nextLine();
            int process = Integer.parseInt(sc.nextLine());

            //创建一个ap对象
            Applicant ap = new Applicant(name, id);
            ap.setSchool(school);
            ap.setProcess(process);
            apList.add(ap);

            //把list写入文件
            DataControl.Write(apList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("修改成功");
    }

    /**
     * 查询
     */
    public static void select() {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入需要查询的招聘者的身份证号");
        String id = sc.nextLine();//获得学生身份证号
        Applicant stu = null;
        try {
            //拿到所有的学生信息
            LinkedList<Applicant> apList = DataControl.getApList();
            //遍历list，寻找到需要的那条，并删除
            for (Applicant ap : apList) {
                if (ap.getId().equals(id)) {
                    stu = ap;
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        if (stu == null||stu.getDeleteStatus()==0) {
            System.out.println("查无此人");
        } else {
            System.out.println("姓名：" + stu.getName() + "  " +
                    "ID：" + stu.getId() + "  " +
                    "学校：" + stu.getSchool() +"  " +
                    "状态：" + stu.getProcess()
            );
        }
    }
}
