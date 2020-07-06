package hrsysconsole;

import loadandsaveDate.DataOperate;
import model.Employee;
import service.EmployeeService;

import java.util.LinkedList;
import java.util.Scanner;

public class HRSys {
    public static void main(String[] arge)
    {
        LinkedList<Employee> employeeList = new LinkedList<Employee>();
        DataOperate.loadData(employeeList);
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("/**************欢迎来到lowB的员工招聘系统*************/");
            System.out.println("增加员工信息请按1");
            System.out.println("删除员工信息请按2");
            System.out.println("修改员工信息请按3");
            System.out.println("查找员工信息请按4");
            System.out.println("退出系统请按5");
            int choice = input.nextInt();
            if(choice == 1)
            {
                EmployeeService.addEmployee(employeeList);
            }
            else if(choice == 2)
            {
                EmployeeService.deleteEmployee(employeeList);
            }
            else if(choice == 3)
            {
                EmployeeService.updataEmployee(employeeList);
            }
            else if(choice == 4)
            {
                EmployeeService.showEmployee(employeeList);
            }
            else if(choice == 5)
            {
                DataOperate.saveData(employeeList);
                break;
            }
            else
            {
                System.out.println("输入错误,请重新输入");
            }
        }
        System.out.println("成功退出lowB的员工招聘系统");
    }
}
