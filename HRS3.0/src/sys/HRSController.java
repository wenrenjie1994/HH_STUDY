/**
 * projectName: HRS1.0
 * fileName: HRSController.java
 * packageName: sys
 * date: 2020-07-13 16:26
 * copyright(c) tianyifan
 */
package sys;

import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @version: V1.0
 * @author: tianyifan
 * @className: HRSController
 * @packageName: sys
 * @description: HRS控制类
 * @date: 2020-07-13 16:26
 **/
public class HRSController {
    private DBConnection dbConnection = new DBConnection();
    private Connection connection = dbConnection.getDBConnection();//从连接池中获取连接
    private PreparedStatement preparedStatement;
    //标准输入流，System.in 在java中是静态变量，当前类所有的scanner对象共享它，当一个scanner对象执行close()操作后，其他所有的scanner对象都不可用
    Scanner scanner = new Scanner(System.in);
    int choice;
    private HRSController() throws SQLException {

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
                    search(searchName);
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
                    add(addId, addName, addDept, addSalary);
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
                    update(oldName, newName, newDept, newSalary);
                    break;
                case 4:
                    System.out.println("*****************请输入想要删除的员工姓名************************");
                    String deleteName = scanner.next();
                    delate(deleteName);
                    break;
                case 5:
                    System.out.println("********************您已成功退出本系统***************************");
                    break;
                default:
                    System.out.println("******************输入错误！请重新输入！*************************");
                    break;
            }
        }
        scanner.close();
        preparedStatement.close();
    }

    /**
     *@title: print
     *@description: 输入结果集信息
     *@author: tianyifan
     *@date: 2020-07-16 11:56
     *@param: [resultSet]
     *@return: void
     *@throws: 无
     */
    private void print(ResultSet resultSet) throws SQLException {
        System.out.println("ID" + "   " + "姓名" + "   " + "所属部门" + "   " + "薪资");
        while (resultSet.next()){
            System.out.print(resultSet.getString(1)+"    ");
            System.out.print(resultSet.getString(2)+"    ");
            System.out.print(resultSet.getString(3)+"    ");
            System.out.println(resultSet.getInt(4));
        }
    }

    /**
     *@title: search
     *@description: 查询员工信息
     *@author: tianyifan
     *@date: 2020-07-15 11:58
     *@param: [searchName]
     *@return: void
     *@throws: 无
     */
    private void search(String searchName) throws SQLException {
        String sql = "select * from employee where name = '" + searchName + "'";
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        //员工信息不为空
        if(resultSet.next()){
            System.out.println("查询成功！该员工信息如下：");
            //循环遍历查询指定姓名的员工信息
            resultSet.previous();//在调用next()、first()等方法后，它就会指向第二条，因此在做完if判断后需要将指针前移一位
            print(resultSet);
        }else {
            System.out.println("查询失败！未查询到该员工信息！");
        }

    }

    /**
     *@title: add
     *@description: 添加员工信息
     *@author: tianyifan
     *@date: 2020-07-15 12:15
     *@param: [addId, addName, addDept, addSalary]
     *@return: void
     *@throws: 无
     */
    public void add(String addId, String addName, String addDept, Integer addSalary) throws SQLException {
        String sql = "insert into employee(id, name, dept, salary) values (?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, addId);
        preparedStatement.setString(2, addName);
        preparedStatement.setString(3, addDept);
        preparedStatement.setInt(4, addSalary);
        int result =  preparedStatement.executeUpdate();
        if (result == 1){
            System.out.println("添加员工信息成功！全部员工信息如下：");
            sql = "select * from employee";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            print(resultSet);
        }else {
            System.out.println("添加员工信息失败！");
        }
    }

    /**
     *@title: update
     *@description: 修改员工信息
     *@author: tianyifan
     *@date: 2020-07-16 13:09
     *@param: [oldName, newName, newDept, newSalary]
     *@return: void
     *@throws: 无
     */
    public void update(String oldName, String newName, String newDept, Integer newSalary) throws SQLException {
        //根据姓名查询该员工ID
        String id = "";
        String sql = "select id from employee where name = '" + oldName + "'";
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){
            id = resultSet.getString(1);
        }

        //修改指定ID的员工信息
        sql = "update employee set name = ?, dept = ?, salary = ? where id = '" + id +"'";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, newName);
        preparedStatement.setString(2, newDept);
        preparedStatement.setInt(3, newSalary);
        int result =  preparedStatement.executeUpdate();
        if (result == 1){
            System.out.println("修改员工信息成功！该员工最新信息如下：");
            sql = "select * from employee where id = '" + id + "'";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet2 = preparedStatement.executeQuery();
            print(resultSet2);
        }else {
            System.out.println("修改员工信息失败！");
        }
    }

    /**
     *@title: delate
     *@description: 删除员工信息
     *@author: tianyifan
     *@date: 2020-07-16 13:40
     *@param: [deleteName]
     *@return: void
     *@throws: 无
     */
    public void delate(String deleteName) throws SQLException {
        String sql = "delete from employee where name = '" + deleteName + "'";
        preparedStatement = connection.prepareStatement(sql);
        int result =  preparedStatement.executeUpdate();
        if (result == 1){
            System.out.println("删除员工信息成功！全部员工信息如下：");
            sql = "select * from employee";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            print(resultSet);
        }else {
            System.out.println("删除员工信息失败！");
        }
    }

    public static void main(String[] args) throws SQLException {
        new HRSController();
    }
}
