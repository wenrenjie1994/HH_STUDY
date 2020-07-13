package com.spdb.zl.service.impl;

import com.spdb.zl.bean.Employe;
import com.spdb.zl.dao.EmployeDao;
import com.spdb.zl.service.IEmploye;

import java.util.List;
import java.util.Scanner;

public class IEmployeImp implements IEmploye {

    EmployeDao employeDao = new EmployeDao();

    @Override
    public void printEmploy() {
        List<Employe> employes = employeDao.parseTxt();
        for (Employe e : employes) {
            System.out.println(e);
        }
    }

    @Override
    public List<Employe> readAllEmploye() {
        return employeDao.parseTxt();
    }

    @Override
    public void addEmploye() {
        System.out.println("欢迎进入添加简历界面！");
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

        employeDao.addEmploye(emp);

    }

    @Override
    public void deleteEmploye() {

        Scanner scan = new Scanner(System.in);
        String name = scan.next();

        List<Employe> emps = readAllEmploye();
        for (int index = 0; index < emps.size(); index++) {
            if (emps.get(index).getName().equals(name)) {
                emps.remove(index);
                System.out.println("删除成功!\n");
            }
        }
        employeDao.saveEmploye(emps);
    }

    @Override
    public void updateEmploye() {
        List<Employe> emps = readAllEmploye();
        Employe employees = new Employe();
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        if (!findByName(name)){
            System.out.println("输入的名字有误，请重新开始!\n");
            return;
        }
        for (int index = 0; index < emps.size(); index++) {

            if (emps.get(index).getName().equals(name)) {
                emps.remove(index);
                System.out.print("请输入修改后的姓名：  ");
                employees.setName(scan.next());

                System.out.print("请输入修改后的年龄：  ");
                employees.setAge(scan.next());

                while (true) {
                    System.out.print("请输入修改后的性别：  ");
                    String sex = scan.next();
                    if ("男".equals(sex) || "女".equals(sex)) {
                        employees.setSex(sex);
                        break;
                    } else {
                        System.out.println("输入性别格式错误，只能输入男或女");
                    }
                }

                System.out.print("请输入修改后的毕业院校：  ");
                employees.setUniversity(scan.next());
                emps.add(index, employees);
                employeDao.saveEmploye(emps);
                System.out.println("修改成功！");
                break;
            }
        }
    }

    @Override
    public boolean findByName(String name) {
        List<Employe> emps = readAllEmploye();
        for (int index = 0; index < emps.size(); index++) {
            if (emps.get(index).getName().equals(name)) {
                System.out.println("查询到："+emps.get(index).toString());
                return true;
            }
        }
        System.out.println("输入的名字有误，请重新开始!\n");
        return false;
    }
}
