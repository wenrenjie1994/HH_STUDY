/**
 * projectName: HRS5.0_sever
 * fileName: Protocol.java
 * packageName: util
 * date: 2020-07-24 21:36
 * copyright(c) tianyifan
 */
package util;

import entity.Employee;

import java.util.ArrayList;

/**
 * @version: V5.0
 * @author: tianyifan
 * @className: Protocol
 * @packageName: util
 * @description: 服务器端协议字符串组装类
 * @date: 2020-07-24 21:36
 **/
public class Protocol {
    /**
     *@title: addMessage
     *@description: 生成添加员工操作的返回信息
     *@author: tianyifan
     *@date: 2020-07-24 21:38
     *@param: [actionResult]
     *@return: java.lang.String
     *@throws: 无
     */
    public String addMessage(ActionResult actionResult){
        String msg;
        String isSuccess = actionResult.getIsSuccess();//获取操作处理结果

        if(isSuccess.equals("Success")){
            msg = isSuccess + "/";
        }else {
            msg = isSuccess + "/" +actionResult.getFailReason();
        }
        return msg;
    }

    /**
     *@title: deleteMessage
     *@description: 生成删除员工操作的返回信息
     *@author: tianyifan
     *@date: 2020-07-24 21:46
     *@param: [actionResult]
     *@return: java.lang.String
     *@throws: 无
     */
    public String deleteMessage(ActionResult actionResult){
        String msg;
        String isSuccess = actionResult.getIsSuccess();//获取操作处理结果

        if(isSuccess.equals("Success")){
            msg = isSuccess + "/";
        }else {
            msg = isSuccess + "/" +actionResult.getFailReason();
        }
        return msg;
    }

    /**
     *@title: updateMessage
     *@description: 生成修改员工操作的返回信息
     *@author: tianyifan
     *@date: 2020-07-24 21:48
     *@param: [actionResult]
     *@return: java.lang.String
     *@throws: 无
     */
    public String updateMessage(ActionResult actionResult){
        String msg;
        String isSuccess = actionResult.getIsSuccess();//获取操作处理结果

        if(isSuccess.equals("Success")){
            msg = isSuccess + "/";
            Employee newEmployee = (Employee) actionResult.getResultData();
            //得到查询结果字符串
            msg += newEmployee.getId() + "&" + newEmployee.getName() + "&" + newEmployee.getDept() + "&" + newEmployee.getSalary();
        }else {
            msg = isSuccess + "/" +actionResult.getFailReason();
        }
        return msg;
    }

    /**
     *@title: searchMessage
     *@description: 生成查询员工操作的返回信息
     *@author: tianyifan
     *@date: 2020-07-24 21:49
     *@param: [actionResult]
     *@return: java.lang.String
     *@throws: 无
     */
    public String searchMessage(ActionResult actionResult){
        String msg;
        String isSuccess = actionResult.getIsSuccess();//获取操作处理结果

        if(isSuccess.equals("Success")){
            msg = isSuccess + "/";
            Employee employee = (Employee) actionResult.getResultData();
            //得到查询结果字符串
            msg += employee.getId() + "&" + employee.getName() + "&" + employee.getDept() + "&" + employee.getSalary();
        }else {
            msg = isSuccess + "/" +actionResult.getFailReason();
        }
        return msg;
    }
}
