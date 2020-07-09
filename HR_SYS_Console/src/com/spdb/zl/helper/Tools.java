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

    //添加数据
    public void insertEmp(Employe emp) {
        // TODO 自动生成的方法存根
        emps.add(emp);

    }

    //输入姓名
    public Employe findByName() {
        Scanner scan = new Scanner(System.in);
        Employe emp = new Employe();
        String empName = emp.getName();
        empName = scan.next();
        emp.setName(empName);
        return emp;
    }

    //查找
    public void findEmp(Employe emp1) {
        for (int index = 0; index < emps.size(); index++) {
            if (emps.get(index).getName().equals(emp1.getName())) {
                System.out.println(emps.get(index));
                System.out.println("查询成功");
            }
        }
        System.out.println("输入的名字有误，请重新开始");

    }


    //更改员工数据
    public void changeEmp(Employe emp) {

        Employe employees = new Employe();
        for (int index = 0; index < emps.size(); index++) {

            if (emps.get(index).getName().equals(emp.getName())) {
                emps.remove(index);

                Scanner scan = new Scanner(System.in);
                String empName = employees.getName();
                System.out.print("请输入修改后的姓名：  ");
                empName = scan.next();
                employees.setName(empName);


                String age = employees.getAge();
                System.out.print("请输入修改后的年龄：  ");
                age = scan.next();
                employees.setAge(age);

                while (true) {
                    String sex = employees.getSex();
                    System.out.print("请输入修改后的性别：  ");
                    sex = scan.next();
                    if ("男".equals(sex) || "女".equals(sex)) {
                        employees.setSex(sex);
                        break;
                    } else {
                        System.out.println("输入性别格式错误，只能输入男或女");
                    }
                }

                String school = employees.getUniversity();
                System.out.print("请输入修改后的毕业院校：  ");
                school = scan.next();
                employees.setUniversity(school);
                emps.add(index, employees);
                System.out.println("修改成功！");
                break;
            }
        }

    }

    //删除学生
    public void deleteEmp(Employe emp2) {
        for (int index = 0; index < emps.size(); index++) {
            if (emps.get(index).getName().equals(emp2.getName())) {
                emps.remove(index);
                System.out.println("删除成功");
            }
        }
        System.out.println("输入的名字有误，请重新开始");
    }

    //打印员工信息
    public void printEmpMenus() {

        for (Employe s : emps) {
            System.out.println(s.toString());

        }
    }

}