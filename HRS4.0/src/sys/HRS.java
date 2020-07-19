/**
 * projectName: HRS4.0
 * fileName: HRS.java
 * packageName: sys
 * date: 2020-07-13 16:26
 * copyright(c) tianyifan
 */
package sys;

import action.FunctionAction;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @version: V4.0
 * @author: tianyifan
 * @className: HRS
 * @packageName: sys
 * @description: HRS类
 * @date: 2020-07-13 16:26
 **/
public class HRS {
    FunctionAction functionAction = new FunctionAction();//实例化系统功能执行类对象，执行各功能
    //标准输入流，System.in 在java中是静态变量，当前类所有的scanner对象共享它，当一个scanner对象执行close()操作后，其他所有的scanner对象都不可用
    Scanner scanner = new Scanner(System.in);
    int choice;//操作选择变量
    private HRS() throws SQLException {
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
                    System.out.println("*****************请输入想要查询的员工姓名************************");
                    String searchName = scanner.next();//查询的姓名
                    functionAction.search(searchName);
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
                    functionAction.add(addId, addName, addDept, addSalary);
                    break;
                case 3:
                    System.out.println("*****************请输入想要修改的员工姓名************************");
                    String oldName = scanner.next();
                    //输入员工信息
                    System.out.println("修改后的姓名:");
                    String newName = scanner.next();
                    System.out.println("修改后的所属部门:");
                    String newDept = scanner.next();
                    System.out.println("修改后的薪资:");
                    Integer newSalary = scanner.nextInt();
                    //添加员工信息
                    functionAction.update(oldName, newName, newDept, newSalary);
                    break;
                case 4:
                    System.out.println("*****************请输入想要删除的员工姓名************************");
                    String deleteName = scanner.next();
                    functionAction.delate(deleteName);
                    break;
                case 5:
                    System.out.println("********************您已成功退出本系统***************************");
                    functionAction.closeStream();
                    break;
                default:
                    System.out.println("******************输入错误！请重新输入！*************************");
                    break;
            }
        }
        scanner.close();
    }


    public static void main(String[] args) throws SQLException {
        new HRS();
    }
}
