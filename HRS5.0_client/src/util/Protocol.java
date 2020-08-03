/**
 * projectName: HRS5.0_client
 * fileName: Protocol.java
 * packageName: util
 * date: 2020-08-03 15:18
 * copyright(c) tianyifan
 */
package util;

import entity.Employee;

/**
 * @version: V5.0
 * @author: tianyifan
 * @className: Protocol
 * @packageName: util
 * @description: 客户端协议字符串组装类
 * @date: 2020-08-03 15:18
 **/
public class Protocol {
    /**
     *@title: addMessage
     *@description: 添加员工信息协议字符串生成方法
     *@author: tianyifan
     *@date: 2020-08-03 15:23
     *@param: [employee]
     *@return: java.lang.String
     *@throws: 无
     */
    public String addMessage(Employee employee){
        return "add/"+employee.getId()+"&"+employee.getName()+"&"+employee.getDept()+"&"+employee.getSalary();
    }

    /**
     *@title: deleteMessage
     *@description: 删除员工信息协议字符串生成方法
     *@author: tianyifan
     *@date: 2020-08-03 15:24
     *@param: [employee]
     *@return: java.lang.String
     *@throws:无
     */
    public String deleteMessage(String id){
        return "delete/"+id;
    }

    /**
     *@title: updateMessage
     *@description: 修改员工信息协议字符串生成方法
     *@author: tianyifan
     *@date: 2020-08-03 15:26
     *@param: [employee]
     *@return: java.lang.String
     *@throws: 无
     */
    public String updateMessage(Employee employee){
        return "update/"+employee.getId()+"&"+employee.getName()+"&"+employee.getDept()+"&"+employee.getSalary();
    }

    /**
     *@title: searchMessage
     *@description: 查询员工信息协议字符串生成方法
     *@author: tianyifan
     *@date: 2020-08-03 15:28
     *@param: [id]
     *@return: java.lang.String
     *@throws: 无
     */
    public String searchMessage(String id){
        return "search/"+id;
    }
}
