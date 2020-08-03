/**
 * projectName: HRS5.0_client
 * fileName: HRS.java
 * packageName: sys
 * date: 2020-08-03 16:40
 * copyright(c) tianyifan
 */
package sys;

import control.Function;
import entity.Employee;
import util.DealResult;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @version: V5.0
 * @author: tianyifan
 * @className: HRS
 * @packageName: sys
 * @description: 客户端交互类
 * @date: 2020-08-03 16:40
 **/
public class HRS {
    Function function = new Function();//实例化系统功能执行类对象，执行各功能
    //标准输入流，System.in 在java中是静态变量，当前类所有的scanner对象共享它，当一个scanner对象执行close()操作后，其他所有的scanner对象都不可用
    Scanner scanner = new Scanner(System.in);
    int choice;//操作选择变量

    private HRS() throws SQLException, IOException {
        while (true && choice != 5) {
            System.out.println("**************************************************************");
            System.out.println("*                                                            *");
            System.out.println("*          欢迎进入HR系统                                      *");
            System.out.println("*          请选择您想进行的操作：                               *");
            System.out.println("*          按1 查询员工信息                                    *");
            System.out.println("*          按2 添加员工信息                                    *");
            System.out.println("*          按3 修改员工信息                                    *");
            System.out.println("*          按4 删除员工信息                                    *");
            System.out.println("*          按5 退出系统                                       *");
            System.out.println("*                                                            *");
            System.out.println("**************************************************************");
            choice = scanner.nextInt();//操作选择

            switch (choice) {
                case 1:
                    System.out.println("*****************请输入想要查询的员工ID************************");
                    String searchId = scanner.next();//查询的ID
                    DealResult searchResult = function.searchEmployee(searchId);
                    if(searchResult.isSuccess() == true){
                        Employee searchEmployee = (Employee) searchResult.getResultData();
                        System.out.println("收到服务器端返回的信息：");
                        System.out.println("ID" + "   " + "姓名" + "   " + "所属部门" + "   " + "薪资");
                        System.out.print(searchEmployee.getId()+"    ");
                        System.out.print(searchEmployee.getName()+"    ");
                        System.out.print(searchEmployee.getDept()+"    ");
                        System.out.println(searchEmployee.getSalary());
                    }else {
                        System.out.println("收到服务器端返回的信息：");
                        System.out.println(searchResult.getFailReason());
                    }
                    break;
                case 2:
                    System.out.println("*****************请输入想要添加的员工信息************************");
                    //输入员工信息
                    System.out.println("ID:");
                    String addId = scanner.next();
                    System.out.println("姓名:");
                    String addName = scanner.next();
                    System.out.println("所属部门:");
                    String addDept = scanner.next();
                    System.out.println("薪资:");
                    Integer addSalary = scanner.nextInt();
                    //添加员工信息
                    Employee addEmployee = new Employee(addId, addName, addDept, addSalary);
                    DealResult addResult = function.addEmployee(addEmployee);
                    if(addResult.isSuccess() == true){
                        System.out.println("收到服务器端返回的信息：");
                        System.out.println("Success");
                    }else {
                        System.out.println("收到服务器端返回的信息：");
                        System.out.println(addResult.getFailReason());
                    }
                    break;
                case 3:
                    System.out.println("*****************请输入想要修改的员工ID************************");
                    String id = scanner.next();
                    //输入员工信息
                    System.out.println("修改后的姓名:");
                    String newName = scanner.next();
                    System.out.println("修改后的所属部门:");
                    String newDept = scanner.next();
                    System.out.println("修改后的薪资:");
                    Integer newSalary = scanner.nextInt();
                    //添加员工信息
                    Employee updateEmployee = new Employee(id, newName, newDept, newSalary);
                    DealResult updateResult = function.updateEmployee(updateEmployee);
                    if(updateResult.isSuccess() == true){
                        Employee updatedEmployee = (Employee) updateResult.getResultData();
                        System.out.println("收到服务器端返回的信息：");
                        System.out.println("ID" + "   " + "姓名" + "   " + "所属部门" + "   " + "薪资");
                        System.out.print(updatedEmployee.getId()+"    ");
                        System.out.print(updatedEmployee.getName()+"    ");
                        System.out.print(updatedEmployee.getDept()+"    ");
                        System.out.println(updatedEmployee.getSalary());
                    }else {
                        System.out.println("收到服务器端返回的信息：");
                        System.out.println(updateResult.getFailReason());
                    }
                    break;
                case 4:
                    System.out.println("*****************请输入想要删除的员工ID************************");
                    String deleteId = scanner.next();
                    DealResult deleteResult = function.deleteEmployee(deleteId);
                    if(deleteResult.isSuccess() == true){
                        System.out.println("收到服务器端返回的信息：");
                        System.out.println("Success");
                    }else {
                        System.out.println("收到服务器端返回的信息：");
                        System.out.println(deleteResult.getFailReason());
                    }
                    break;
                case 5:
                    System.out.println("********************您已成功退出本系统***************************");
                    function.closeClient("quit");
                    break;
                default:
                    System.out.println("******************输入错误！请重新输入！*************************");
                    break;
            }
        }
        scanner.close();
    }


    public static void main(String[] args) throws SQLException, IOException {
        new HRS();
    }
}
