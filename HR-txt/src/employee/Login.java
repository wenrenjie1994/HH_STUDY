package employee;

import java.util.LinkedList;
import java.util.Scanner;
import loadandsaveData.DataOperate;
import control.Employee;
import service.EmployeeService;

public class Login
{
        public static void main(String[] args)
        {
            LinkedList<Employee> employeeList = new LinkedList<Employee>();
            Scanner input = new Scanner(System.in);
            DataOperate.loadData(employeeList);//下载所有员工到本地文档
            while(true)
            {
                System.out.println("******欢迎来到浦发银行员工管理系统");
                System.out.println("增加员工请按----------1");
                System.out.println("删除员工请按----------2");
                System.out.println("修改员工请按----------3");
                System.out.println("查询员工请按----------4");
                System.out.println("退出请按--------------5");
                int choice = input.nextInt();
                if (choice==1)
                {
                    EmployeeService.addEmployee(employeeList);
                }
                else if (choice==2)
                {
                    EmployeeService.deleteEmployee(employeeList);
                }
                else if (choice==3)
                {
                    EmployeeService.updateEmployee(employeeList);
                }
                else if (choice==4)
                {
                    EmployeeService.searchEmployee(employeeList);
                }
                else if (choice==5)
                {
                    DataOperate.savaData(employeeList);
                    break;
                }
                else
                {
                    System.out.println("输入错误，请重新输入");
                }
            }
            System.out.println("您已退出员工管理系统");
        }

}
