package com.spdb.zl.sys;

import com.spdb.zl.bean.Employe;
import com.spdb.zl.service.IEmploye;
import com.spdb.zl.service.impl.IEmployeImp;

import java.util.Scanner;

public class Main {

    public static void printMenu() {
        System.out.println("1、添加员工信息");
        System.out.println("2、修改员工信息");
        System.out.println("3、删除员工信息");
        System.out.println("4、查找员工信息");
        System.out.println("5、打印员工信息");
        System.out.println("6、退出");
    }


    public static void main(String[] args) {
        IEmploye emp = new IEmployeImp();
        Scanner scan = new Scanner(System.in);
        int flag = 0;
        System.out.println("欢迎来到HR管理系统！");

        while(true)
        {
            printMenu();
            System.out.println("请选择操作：");

            switch (scan.nextInt()) {
                //插入员工信息
                case 1:
                    emp.addEmploye();
                    System.out.println("数据保存成功！\n");
                    break;
                //修改员工信息
                case 2:
                    System.out.println("请输入需要修改的员工的姓名：");
                    emp.updateEmploye();
                    break;
                //删除员工信息
                case 3:
                    System.out.println("请输入需要删除的员工姓名：");
                    emp.deleteEmploye();
                    break;
                //查询
                case 4:
                    System.out.println("请输入需要查询的员工姓名：");
                    String name = scan.next();
                    emp.findByName(name);
                    break;
                //遍历员工信息
                case 5:
                    emp.printEmploy();
                    break;
                //退出
                case 6:
                    System.out.println("欢迎再次使用本系统，再见！！！");
                    flag=1;
                    break;

                default:
                    break;

            }
            //退出系统
            if (flag==1){
                break;
            }
        }
    }
}
