/**
 * projectName: HRS5.0_client
 * fileName: Parser.java
 * packageName: util
 * date: 2020-08-03 15:31
 * copyright(c) tianyifan
 */
package util;

import entity.Employee;

/**
 * @version: V5.0
 * @author: tianyifan
 * @className: Parser
 * @packageName: util
 * @description: 服务器端协议字符串解析类
 * @date: 2020-08-03 15:31
 **/
public class Parser {
    /**
     *@title: parserAdd
     *@description: 添加员工信息操作结果解析方法
     *@author: tianyifan
     *@date: 2020-08-03 15:39
     *@param: [message]
     *@return: util.DealResult
     *@throws: 无
     */
    public DealResult parserAdd(String message){
        DealResult dealResult = new DealResult();
        String[] result = message.split("/");
        if(result[0].equals("Success")){
            dealResult.setSuccess(true);
        }else {
            dealResult.setSuccess(false);
            dealResult.setFailReason(result[1]);
        }
        return dealResult;
    }

    /**
     *@title: parserDelete
     *@description: 删除员工信息操作结果解析方法
     *@author: tianyifan
     *@date: 2020-08-03 15:47
     *@param: [message]
     *@return: util.DealResult
     *@throws: 无
     */
    public DealResult parserDelete(String message){
        DealResult dealResult = new DealResult();
        String[] result = message.split("/");
        if(result[0].equals("Success")){
            dealResult.setSuccess(true);
        }else {
            dealResult.setSuccess(false);
            dealResult.setFailReason(result[1]);
        }
        return dealResult;
    }

    /**
     *@title: parserUpdate
     *@description: 修改员工信息操作结果解析方法
     *@author: tianyifan
     *@date: 2020-08-03 15:47
     *@param: [message]
     *@return: util.DealResult
     *@throws: 无
     */
    public DealResult parserUpdate(String message){
        DealResult dealResult = new DealResult();
        String[] result = message.split("/");
        if(result[0].equals("Success")){
            dealResult.setSuccess(true);
            String[] employeeMsg = result[1].split("&");
            String id = employeeMsg[0];
            String name = employeeMsg[1];
            String dept = employeeMsg[2];
            Integer salary = Integer.parseInt(employeeMsg[3]);
            Employee employee = new Employee(id, name, dept, salary);
            dealResult.setResultData(employee);
        }else {
            dealResult.setSuccess(false);
            dealResult.setFailReason(result[1]);
        }
        return dealResult;
    }

    /**
     *@title: parserSearch
     *@description: 查询员工信息操作结果解析方法
     *@author: tianyifan
     *@date: 2020-08-03 15:47
     *@param: [message]
     *@return: util.DealResult
     *@throws: 无
     */
    public DealResult parserSearch(String message){
        DealResult dealResult = new DealResult();
        String[] result = message.split("/");
        if(result[0].equals("Success")){
            dealResult.setSuccess(true);
            String[] employeeMsg = result[1].split("&");
            String id = employeeMsg[0];
            String name = employeeMsg[1];
            String dept = employeeMsg[2];
            Integer salary = Integer.parseInt(employeeMsg[3]);
            Employee employee = new Employee(id, name, dept, salary);
            dealResult.setResultData(employee);
        }else {
            dealResult.setSuccess(false);
            dealResult.setResultData(null);
            dealResult.setFailReason(result[1]);
        }
        return dealResult;
    }
}
