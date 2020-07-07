package com.hr.console;

import com.hr.bean.Applicant;
import com.hr.bean.ApplicantList;
import com.hr.bean.Service;

import java.util.LinkedList;
import java.util.Scanner;

public class Console {

    public static void main(String[] args) {
        ApplicantList list = new ApplicantList();
        LinkedList<Applicant> apList = list.getApList();
        boolean exit = true;
        Service service = new Service();
        Scanner sc = new Scanner(System.in);
        while (exit) {
            System.out.println("输入1录入招聘者");
            System.out.println("输入2查询招聘者");
            System.out.println("输入3删除招聘者");
            System.out.println("输入4更改招聘者");
            System.out.println("输入5查看所有招聘者");
            int choice = sc.nextInt();
            if (choice == 1) {
                service.insert();
            } else if (choice == 2) {
                service.select();
            } else if (choice == 3) {
                service.delete();
            } else if (choice == 4) {
                service.update();
            } else if (choice == 5) {
                System.out.println("共有" + apList.size() + "位招聘者");
                for (Applicant ap : apList) {
                    if(ap.getDeleteStatus()==1){
                        System.out.print("姓名：" + ap.getName() + "  ");
                        System.out.print("学校：" + ap.getSchool() + "  ");
                        System.out.print("ID：" + ap.getId() + "  ");
                        System.out.print("状态：" + ap.getProcess()+ "  ");
                        System.out.println("删除状态：" + ap.getDeleteStatus());
                    }

                }

            } else {
                System.out.println("输入有误，请重新输入");
            }
        }


    }
}
