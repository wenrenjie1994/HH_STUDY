/**
 * projectName: HRS5.0_sever
 * fileName: Parser.java
 * packageName: util
 * date: 2020-07-24 22:02
 * copyright(c) tianyifan
 */
package util;

import entity.Employee;

/**
 * @version: V5.0
 * @author: tianyifan
 * @className: Parser
 * @packageName: util
 * @description: 客户端协议字符串解析类
 * @date: 2020-07-24 22:02
 **/
public class Parser {
    private static String[] protocolMessage;//协议信息的保存数组
    private static String head;//协议头部信息
    private static ReturnData returnData;//返回信息
    private static String message;//协议中的员工信息

    /**
     *@title: parser
     *@description: 解析收到的字符串
     *@author: tianyifan
     *@date: 2020-08-02 13:45
     *@param: [str]
     *@return: util.ReturnData
     *@throws: 无
     */
    public ReturnData parser(String str){
        protocolMessage = str.split("/");//按“/”切开字符串
        head = protocolMessage[0];//操作类型
        message = protocolMessage[1];//数据
        returnData = new ReturnData();
        returnData.setHead(head);//保存操作类型信息
        Employee employee;

        switch (head){
            case "add":
                employee = parserAdd(message);
                returnData.setResult(employee);
                break;
            case "delete":
                String deleteId = parserDelete(message);
                returnData.setResult(deleteId);
                break;
            case "update":
                employee = parserUpdate(message);
                returnData.setResult(employee);
                break;
            case "search":
                String searchId = parserSearch(message);
                returnData.setResult(searchId);
                break;
            default:
                System.out.println("信息错误！无法解析！");
        }
        return returnData;
    }


    /**
     *@title: paserAdd
     *@description: 添加员工信息的解析方法
     *@author: tianyifan
     *@date: 2020-08-02 13:58
     *@param: [message]
     *@return: entity.Employee
     *@throws: 无
     */
    private Employee parserAdd(String message) {
        String[] employeeMsg = message.split("&");
        String id = employeeMsg[0];
        String name = employeeMsg[1];
        String dept = employeeMsg[2];
        Integer salary = Integer.parseInt(employeeMsg[3]);
        Employee employee = new Employee(id,name,dept,salary);
        return employee;
    }

    /**
     *@title: paserDelete
     *@description: 删除员工信息的解析方法
     *@author: tianyifan
     *@date: 2020-08-02 14:05
     *@param: [message]
     *@return: java.lang.String
     *@throws: 无
     */
    private String parserDelete(String message) {
        return message;
    }

    /**
     *@title: paserUpdate
     *@description: 修改员工信息的解析方法
     *@author: tianyifan
     *@date: 2020-08-02 14:05
     *@param: [message]
     *@return: entity.Employee
     *@throws: 无
     */
    private Employee parserUpdate(String message) {
        String[] employeeMsg = message.split("&");
        String id = employeeMsg[0];
        String newName = employeeMsg[1];
        String newDept = employeeMsg[2];
        Integer newSalary = Integer.parseInt(employeeMsg[3]);
        Employee employee = new Employee(id,newName,newDept,newSalary);
        return employee;
    }

    /**
     *@title: paserSearch
     *@description: 查询员工信息的解析方法
     *@author: tianyifan
     *@date: 2020-08-02 14:06
     *@param: [message]
     *@return: java.lang.String
     *@throws: 无
     */
    private String parserSearch(String message) {
        return message;
    }
}
