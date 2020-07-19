/**
 * projectName: HRS4.0
 * fileName: FunctionAction.java
 * packageName: action
 * date: 2020-07-19 11:42
 * copyright(c) tianyifan
 */
package action;

import database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @version: V1.0
 * @author: tianyifan
 * @className: FunctionAction
 * @packageName: action
 * @description: 系统功能执行类
 * @date: 2020-07-19 11:42
 **/
public class FunctionAction {
    private DBConnection dbConnection = new DBConnection();//实例化连接池对象
    private Connection connection = dbConnection.getDBConnection();//从连接池中获取连接
    private PreparedStatement preparedStatement;

    /**
     *@title: FunctionAction
     *@description: 构造函数，用于实例化
     *@author: tianyifan
     *@date: 2020-07-19 12:05
     *@param: 无
     *@return: 无
     *@throws: 无
     */
    public FunctionAction() throws SQLException {}

    /**
     *@title: print
     *@description: 输出结果集信息
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
    public void search(String searchName) throws SQLException {
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

    /**
     *@title: closeStream
     *@description: 关闭各种流
     *@author: tianyifan
     *@date: 2020-07-19 11:58
     *@param: 无
     *@return: void
     *@throws: 无
     */
    public void closeStream() throws SQLException {
        preparedStatement.close();//关闭preparedStatement
        connection.close();//关闭数据库连接
        dbConnection.closeDataSource();//关闭数据库连接池
    }
}
