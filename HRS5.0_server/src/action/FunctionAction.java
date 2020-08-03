/**
 * projectName: HRS5.0_sever
 * fileName: FunctionAction.java
 * packageName: action
 * date: 2020-07-19 11:42
 * copyright(c) tianyifan
 */
package action;

import database.DBConnection;
import entity.Employee;
import util.ActionResult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @version: V5.0
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
     *@param: [searchId]
     *@return: util.ActionResult
     *@throws: 无
     */
    public ActionResult search(String searchId) throws SQLException {
        ActionResult actionResult = new ActionResult();
        String sql = "select * from employee where id = " + searchId;
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        //员工信息不为空
        if(resultSet.next()){
            System.out.println("查询成功！");
            actionResult.setIsSuccess("Success");
            Employee employee = new Employee(resultSet.getString(1),resultSet.getString(2),
                    resultSet.getString(3),Integer.parseInt(resultSet.getString(4)));
            actionResult.setResultData(employee);
        }else {
            actionResult.setIsSuccess("False");
            actionResult.setFailReason("Error");
            System.out.println("查询失败！未查询到该员工信息！");
        }
        return actionResult;
    }

    /**
     *@title: add
     *@description: 添加员工信息
     *@author: tianyifan
     *@date: 2020-07-15 12:15
     *@param: [addId, addName, addDept, addSalary]
     *@return: util.ActionResult
     *@throws: 无
     */
    public ActionResult add(String addId, String addName, String addDept, Integer addSalary) throws SQLException {
        ActionResult actionResult = new ActionResult();
        String sql = "insert into employee(id, name, dept, salary) values (?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, addId);
        preparedStatement.setString(2, addName);
        preparedStatement.setString(3, addDept);
        preparedStatement.setInt(4, addSalary);
        int result =  preparedStatement.executeUpdate();
        if (result == 1){
            actionResult.setIsSuccess("Success");
            System.out.println("添加员工信息成功！");
        }else {
            actionResult.setIsSuccess("False");
            actionResult.setFailReason("Error");
            System.out.println("添加员工信息失败！");
        }
        return actionResult;
    }

    /**
     *@title: update
     *@description: 修改员工信息
     *@author: tianyifan
     *@date: 2020-07-16 13:09
     *@param: [id, newName, newDept, newSalary]
     *@return: util.ActionResult
     *@throws: 无
     */
    public ActionResult update(String id, String newName, String newDept, Integer newSalary) throws SQLException {
        ActionResult actionResult = new ActionResult();
        String sql;
        //修改指定ID的员工信息
        sql = "update employee set name = ?, dept = ?, salary = ? where id = " + id;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, newName);
        preparedStatement.setString(2, newDept);
        preparedStatement.setInt(3, newSalary);
        int result =  preparedStatement.executeUpdate();
        if (result == 1){
            actionResult.setIsSuccess("Success");
            System.out.println("修改员工信息成功！");
            sql = "select * from employee where id = " + id;
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet2 = preparedStatement.executeQuery();
            if(resultSet2.next()){
                Employee employee = new Employee(resultSet2.getString(1),resultSet2.getString(2),
                        resultSet2.getString(3),Integer.parseInt(resultSet2.getString(4)));
                actionResult.setResultData(employee);
            }
        }else {
            actionResult.setIsSuccess("False");
            actionResult.setFailReason("Error");
            System.out.println("修改员工信息失败！");
        }
        return  actionResult;
    }

    /**
     *@title: delete
     *@description: 删除员工信息
     *@author: tianyifan
     *@date: 2020-07-16 13:40
     *@param: [deleteId]
     *@return: util.ActionResult
     *@throws: 无
     */
    public ActionResult delete(String deleteId) throws SQLException {
        ActionResult actionResult = new ActionResult();
        String sql = "delete from employee where id = " + deleteId;
        preparedStatement = connection.prepareStatement(sql);
        int result =  preparedStatement.executeUpdate();
        if (result == 1){
            actionResult.setIsSuccess("Success");
            System.out.println("删除员工信息成功！");
        }else {
            actionResult.setIsSuccess("False");
            actionResult.setFailReason("Error");
            System.out.println("删除员工信息失败！");
        }
        return actionResult;
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
