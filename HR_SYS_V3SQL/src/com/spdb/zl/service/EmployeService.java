package com.spdb.zl.service;

import com.spdb.zl.bean.Employe;
import com.spdb.zl.dao.EmployeDao;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployeService {
    public static void main(String[] args) throws SQLException {
        EmployeService em = new EmployeService();
        em.insertEmploye();
    }
    EmployeDao employeDao = new EmployeDao();
    public void insertEmploye() throws SQLException {
        System.out.println("欢迎进入添加简历界面！");
        Scanner scan = new Scanner(System.in);
        Employe emp = new Employe();
        System.out.print("请输入姓名：  ");
        String empName = scan.next();
        emp.setName(empName);

        System.out.print("请输入年龄：  ");
        String age = scan.next();
        emp.setAge(age);

        while (true) {
            System.out.print("请输入性别（男或者女）：  ");
            String sex = scan.next();
            if ("男".equals(sex) || "女".equals(sex)) {
                emp.setSex(sex);
                break;
            } else {
                System.out.println("输入性别格式错误，只能输入男或女");
            }
        }

        System.out.print("请输入毕业院校：  ");
        String school = scan.next();
        emp.setUniversity(school);

        employeDao.addEmploye(emp);
    }
}
