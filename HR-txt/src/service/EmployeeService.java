package service;

import java.util.LinkedList;

import java.util.Scanner;
import control.Employee;
import loadandsaveData.DataOperate;

public class EmployeeService {

    //添加员工
    public static void addEmployee(LinkedList<Employee> employeeList)
    {
        System.out.println("欢迎来到添加员工界面");
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要添加员工姓名，年龄，工号");
        String Name=input.nextLine();
        int Age=input.nextInt();
        int Num=input.nextInt();
        Employee employee=new Employee(Name,Age,Num);
        employeeList.add(employee);
        System.out.println("添加成功");
        showEmployee(employeeList);

    }
    //删除员工
    public static void deleteEmployee(LinkedList<Employee> employeeList)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎来到员工删除界面");
        System.out.println("请输入需要删除得员工姓名");
        String Name = input.nextLine();
        int employeeCount = employeeList.size();
        for (int i=0;i<employeeCount;i++)
        {
            if (employeeList.get(i).Name.equals(Name))
            {
                employeeList.remove(i);
                System.out.println("成功删除");
                break;
            }
            else if (i==employeeCount-1)
            {
                System.out.println("没有找到该员工");
            }
        }
        showEmployee(employeeList);

    }
    //修改员工
    public static void updateEmployee(LinkedList<Employee> employeeList)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎来到员工修改界面");
        System.out.println("请输入需要修改的员工姓名");
        String Name = input.nextLine();
        int employeeCount = employeeList.size();
        for (int i=0;i<employeeCount;i++)
        {
            if (employeeList.get(i).Name.equals(Name))
            {
                System.out.println("请依次输入新的员工姓名，年龄，工号");
                String newName = input.nextLine();
                int newAge = input.nextInt();
                int newNum = input.nextInt();
                Employee employee=new Employee(newName,newAge,newNum);
                employeeList.set(i,employee);
                showEmployee(employeeList);

            }else if (i==employeeCount-1||employeeCount==0)
            {
                System.out.println("没有找到该员工");
            }
        }

    }
    //查询员工
    public static void searchEmployee(LinkedList<Employee> employeeList)
    {
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入员工查询界面");
        System.out.println("请输入需要查询的员工姓名");
        String Name=input.nextLine();
        int employeeCount = employeeList.size();
        for(int i=0;i<employeeCount;i++)
        {
            if(employeeList.get(i).Name.equals(Name))
            {
                System.out.println("姓名"+":"+ employeeList.get(i).Name+"\n"+
                        "年龄"+":"+ employeeList.get(i).Age+"\n"
                        +"工号"+":"+ employeeList.get(i).Num+"\n"
                        +"位于第"+(i+1)+"位置");
                break;
            }
            else if(i==employeeCount-1) {
                System.out.println("没有找到该员工，请重新输入");
            }
        }
    }
    //员工遍历
    public static void showEmployee(LinkedList<Employee> employeeList)
    {
        Scanner input=new Scanner(System.in);
        System.out.println("是否需要打印所有员工信息，是请输入Y，不用打印则输入任意");
        String XUANZE=input.nextLine();
        String Y="Y";
        int employeeCount = employeeList.size();
        if(XUANZE.equals(Y))
        {
            System.out.println("本员工系统共有"+employeeCount+"名员工");
            for(int i=0;i<employeeCount;i++) {
                System.out.println("第"+(i+1)+"名"+":"+ employeeList.get(i).Name);
            }
        }
    }
}
