package service;

import model.Employee;
import java.util.LinkedList;
import java.util.Scanner;

public class EmployeeService
{
    public static void addEmployee(LinkedList<Employee> employeeList)
    {
        System.out.println("欢迎来到雇员录入操作界面");
        System.out.println("请按顺序输入，雇员工号、姓名、年龄、性别、电话:");
        Scanner input  = new Scanner(System.in);
        String employeeJobNumber = input.nextLine();
        String employeeName = input.nextLine();
        int employeeAge = input.nextInt();
        String rn = input.nextLine();
        String employeeGenger = input.nextLine();
        String employeePhone = input.nextLine();
        Employee employee = new Employee(employeeJobNumber,employeeName,employeeAge,employeeGenger,employeePhone);
        employeeList.add(employee);
        System.out.println("录入成功");
        showEmployee(employeeList);
    }
    public static void deleteEmployee(LinkedList<Employee> employeeList)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎来到删除雇员界面");
        System.out.println("请输入想要删除雇员的工号、姓名");
        String employeeJobName = input.nextLine();
        String employeeName = input.nextLine();
        int count = employeeList.size();
        for(int i = 0;i < count; i++)
        {
            Employee employee = employeeList.get(i);
            if(employee.employeeJobNumber.equals(employeeJobName)
                    && employee.employeeName.equals(employeeName))
            {
                employeeList.remove(i);
                System.out.println("成功删除该员工");
                break;
            }
            else if(i == count-1)
            {
                System.out.println("未找到该员工，请重新核对信息后重新尝试");
            }
        }
        showEmployee(employeeList);
    }
    public static void updataEmployee(LinkedList<Employee> employeeList)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎来到修改雇员信息界面");
        System.out.println("请输入修改员工的工号:");
        String employeeJobNumber = input.nextLine();
        int count = employeeList.size();
        for(int i = 0;i<count;i++)
        {
            if(employeeList.get(i).employeeJobNumber.equals(employeeJobNumber))
            {
                System.out.println("请依次输入该员工新的工号、姓名、年龄、性别、电话:");
             /*
                employee.get(i).employeeeJobNumber = input.nextLine();
                employee.get(i).employeeName = input.nextLine();
                employee.get(i).employeeAge = input.nextInt();
                String rn = input.nextLine();
                employee.get(i).employeeGender = input.nextLine();
                employee.get(i).employeePhone = input.nextLine();
             */
                String newemployeeJobNumber = input.nextLine();
                String newemployeeName = input.nextLine();
                int newemployeeAge = input.nextInt();
                String rn = input.nextLine();
                String newemployeeGenger = input.nextLine();
                String newemployeePhone = input.nextLine();
                Employee employee = new Employee(newemployeeJobNumber,newemployeeName,newemployeeAge,
                        newemployeeGenger,newemployeePhone);
                employeeList.set(i,employee);
                System.out.println("成功修改员工信息");
                showEmployee(employeeList);
            }
            else if(i == count-1)
            {
                System.out.println("未找到该员工，请重新核对员工工号后重新尝试");
            }
        }
    }
    public static void showEmployee(LinkedList<Employee> employeeList)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("如要打印所有员工，请输入‘Y’");
        String showEmployeeChoice = input.nextLine();
        String Y = "Y";
        int count = employeeList.size();
        if(showEmployeeChoice.equals(Y))
        {
            System.out.println("本系统中共有"+count+"名员工");
            for(int i = 0;i<count;i++)
            {
                System.out.println("工号:"+employeeList.get(i).employeeJobNumber+", 姓名:"
                        +employeeList.get(i).employeeName+", 年龄:"+employeeList.get(i).employeeAge
                        +", 性别:"+employeeList.get(i).employeeGender+", 电话:"+employeeList.get(i).employeePhone);
            }
        }
    }

}
