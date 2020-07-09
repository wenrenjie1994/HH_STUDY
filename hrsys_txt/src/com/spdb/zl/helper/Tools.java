package com.spdb.zl.helper;

import com.spdb.zl.bean.Employe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tools {
    private static List<Employe> emps = new ArrayList<Employe>();

    public void printMenu() {
        System.out.println("1、添加员工信息");
        System.out.println("2、修改员工信息");
        System.out.println("3、删除员工信息");
        System.out.println("4、查找员工信息");
        System.out.println("5、打印员工信息");
        System.out.println("6、退出");
    }

    //输入员工数据
    public Employe EmployeeSet() {
        Scanner scan = new Scanner(System.in);
        Employe emp = new Employe();
        String empName = emp.getName();
        System.out.print("请输入姓名：  ");
        empName = scan.next();
        emp.setName(empName);


        String age = emp.getAge();
        System.out.print("请输入年龄：  ");
        age = scan.next();
        emp.setAge(age);

        while (true) {
            String sex = emp.getSex();
            System.out.print("请输入性别（男或者女）：  ");
            sex = scan.next();
            if ("男".equals(sex) || "女".equals(sex)) {
                emp.setSex(sex);
                break;
            } else {
                System.out.println("输入性别格式错误，只能输入男或女");
            }
        }
        String school = emp.getUniversity();
        System.out.print("请输入毕业院校：  ");
        school = scan.next();
        emp.setUniversity(school);

        return emp;
    }
}
