package com.spdb.zl.sys;

import com.spdb.zl.bean.Employe;
import com.spdb.zl.helper.Tools;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int flag = 0;
        System.out.println("欢迎来到HR管理系统！");
        Tools tool = new Tools();

        while(true)
        {
            tool.printMenu();
            System.out.println("请选择操作：");

            switch (scan.nextInt()) {
                case 1://插入员工信息
                    Employe emp = tool.EmployeeSet();
                    tool.insertEmp(emp);
                    System.out.println("数据保存成功\n");
                    break;
                case 2://修改员工信息
                    System.out.println("请输入需要修改的员工的姓名：");
                    Employe emp1 = tool.findByName();
                    tool.changeEmp(emp1);
                    break;

                case 3://删除员工信息
                    System.out.println("请输入需要删除的员工姓名：");
                    Employe emp2 = tool.findByName();
                    tool.deleteEmp(emp2);
                    break;

                case 4://查询
                    System.out.println("请输入需要查询的员工姓名：");
                    Employe emp3 = tool.findByName();
                    tool.findEmp(emp3);
                    break;

                case 5://遍历员工信息
                    tool.printEmpMenus();
                    break;

                case 6://退出
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
