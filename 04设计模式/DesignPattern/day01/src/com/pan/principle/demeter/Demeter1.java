package com.pan.principle.demeter;

import java.util.ArrayList;
import java.util.List;

//客户端
public class Demeter1 {
    public static void main(String[] args) {
        //创建schoolManager对象
        SchoolManager schoolManager = new SchoolManager();
        //输出学院的员工ID和学校总部的员工信息
        schoolManager.printAllEmployee(new CollegeManager());
    }
}

//学校总部员工
class Employee {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

//学院员工
class CollegeEmployee {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

//学院管理类
class CollegeManager {
    //返回学院的所有员工
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<CollegeEmployee>();
        for (int i = 0; i < 10; i++) {
            CollegeEmployee emp = new CollegeEmployee();
            emp.setId("学院员工id= " + i);
            list.add(emp);
        }
        return list;
    }
}

//学校管理类
//schoolManager的直接朋友：Employee、CollegeManager
//CollegeEmployee不是直接朋友，违背了迪米特法则
class SchoolManager {
    //    返回学校总部的员工
    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<Employee>();

        for (int i = 0; i < 5; i++) {
            Employee emp = new Employee();
            emp.setId("学校总部员工id= " + i);
            list.add(emp);
        }
        return list;
    }

    //该方法完成输出学校总部和学院员工滋滋（id）
    void printAllEmployee(CollegeManager sub) {

        //违反了迪米特法则
        //获取到学院员工
        List<CollegeEmployee> list1 = sub.getAllEmployee();
        System.out.println("------------学院员工------------");
        for (CollegeEmployee e : list1) {
            System.out.println(e.getId());
        }
        //获取到学校员工
        List<Employee> list2 = this.getAllEmployee();
        System.out.println("------------学校总部员工------------");
        for (Employee e : list2) {
            System.out.println(e.getId());
        }
    }
}
