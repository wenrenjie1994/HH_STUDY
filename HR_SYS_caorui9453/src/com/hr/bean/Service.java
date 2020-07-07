package com.hr.bean;

import java.util.LinkedList;
import java.util.Scanner;

public class Service {
    public void insert() {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入招聘者姓名");
        String name = sc.nextLine();//获得学生姓名
        System.out.println("输入招聘者身份证号");
        String id = sc.nextLine();//获得学生身份证号
        Applicant ap = new Applicant(name, id);//创建一个学生对象
        ApplicantList list = new ApplicantList();
        list.getApList().add(ap);//把该对象放到list里
        System.out.println("录入成功");
        sc.close();
    }

    public void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入需要删除的招聘者的身份证号");
        String id = sc.nextLine();//获得学生身份证号
        ApplicantList list = new ApplicantList();
        LinkedList<Applicant> apList = list.getApList();
        //遍历list
        for (Applicant ap : apList) {
            if (ap.getId().equals(id)) {
                ap.setDeleteStatus(0); //修改ap的属性
                break;
            }
        }
        sc.close();

    }

    public void update() {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入需要更改的招聘者的身份证号");
        String id = sc.nextLine();//获得学生身份证号
        //先找到这个学生，把他的信息拿到，并从列表中删除
        ApplicantList list = new ApplicantList();
        LinkedList<Applicant> apList = list.getApList();
        Applicant student = null;
        //遍历list
        for (Applicant ap : apList) {
            if (ap.getId().equals(id)) {
                student = ap;
                apList.remove(ap);
                break;
            }
        }
        System.out.print("姓名：" + student.getName() + "  " +
                "学校：" + student.getSchool() + "  " +
                "状态：" + student.getProcess() + "  " +
                "删除状态：" + student.getDeleteStatus());//输出学生的信息
        System.out.println();
        int choice;
        String name;
        System.out.println("是否修改该学生的姓名：如需修改请输入1");
        choice = sc.nextInt();
        if (choice == 1) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("请输入姓名");
            name = sc1.nextLine();
            student.setName(name);
            sc1.close();

        }


        System.out.println("是否修改该学生的学校：如需修改请输入1");
        choice = sc.nextInt();
        if (choice == 1) {
            Scanner sc1 = new Scanner(System.in);
            System.out.println("请输入学校");
            String school = sc1.nextLine();
            student.setSchool(school);
            sc1.close();
        }


        System.out.println("是否修改该学生的状态：如需修改请输入1");
        choice = sc.nextInt();
        if (choice == 1) {
            System.out.println("请输入状态：" +
                    "     0：已申请\n" +
                    "     1：简历通过\n" +
                    "     2：笔试通过\n" +
                    "     3：体检通过\n" +
                    "     4：背调通过\n" +
                    "     5：已签约\n" +
                    "     6：已入职");
            Scanner sc1 = new Scanner(System.in);
            int process = sc1.nextInt();
            student.setProcess(process);
            sc1.close();
        }


        apList.add(student);
        System.out.println("修改成功");
        sc.close();
    }

    /**
     * 查询
     */
    public void select() {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入需要查询的招聘者的身份证号");
        String id = sc.nextLine();//获得学生身份证号
        ApplicantList list = new ApplicantList();
        LinkedList<Applicant> apList = list.getApList();
        Applicant stu = null;
        //遍历list
        for (Applicant ap : apList) {
            if (ap.getId().equals(id) && ap.getDeleteStatus() == 1) {

                stu = ap;
                System.out.print("姓名：" + stu.getName() + "  ");
                System.out.print("ID：" + stu.getId() + "  ");
                System.out.println("状态：" + stu.getProcess());
                break;
            }
        }
        if (stu == null) {
            System.out.println("查无此人");
        }
        sc.close();
    }

}
