/**
 * projectName: HRS5.0_client
 * fileName: Function.java
 * packageName: control
 * date: 2020-08-03 16:25
 * copyright(c) tianyifan
 */
package control;

import entity.Employee;
import net.Client;
import util.DealResult;
import util.Parser;
import util.Protocol;

import java.io.IOException;

/**
 * @version: V5.0
 * @author: tianyifan
 * @className: Function
 * @packageName: control
 * @description: 系统功能执行类
 * @date: 2020-08-03 16:25
 **/
public class Function {
    Client client = Client.getClient();//获取客户端实例对象

    /**
     *@title: addEmployee
     *@description: 添加员工信息功能实现方法
     *@author: tianyifan
     *@date: 2020-08-03 16:31
     *@param: [employee]
     *@return: util.DealResult
     *@throws: 无
     */
    public DealResult addEmployee(Employee employee) throws IOException {
        Protocol protocol = new Protocol();
        String message = protocol.addMessage(employee);
        String returnMsg = client.sendMssageToServer(message);
        Parser parser = new Parser();
        DealResult dealResult = parser.parserAdd(returnMsg);
        return dealResult;
    }

    /**
     *@title: deleteEmployee
     *@description: 删除员工信息功能实现方法
     *@author: tianyifan
     *@date: 2020-08-03 16:32
     *@param: [id]
     *@return: util.DealResult
     *@throws: 无
     */
    public DealResult deleteEmployee(String id) throws IOException {
        Protocol protocol = new Protocol();
        String message = protocol.deleteMessage(id);
        String returnMsg = client.sendMssageToServer(message);
        Parser parser = new Parser();
        DealResult dealResult = parser.parserDelete(returnMsg);
        return dealResult;
    }

    /**
     *@title: updateEmployee
     *@description: 删除员工信息功能实现方法
     *@author: tianyifan
     *@date: 2020-08-03 16:32
     *@param: [employee]
     *@return: util.DealResult
     *@throws: 无
     */
    public DealResult updateEmployee(Employee employee) throws IOException {
        Protocol protocol = new Protocol();
        String message = protocol.updateMessage(employee);
        String returnMsg = client.sendMssageToServer(message);
        Parser parser = new Parser();
        DealResult dealResult = parser.parserUpdate(returnMsg);
        return dealResult;
    }

    /**
     *@title: searchEmployee
     *@description: 删除员工信息功能实现方法
     *@author: tianyifan
     *@date: 2020-08-03 16:33
     *@param: [id]
     *@return: util.DealResult
     *@throws: 无
     */
    public DealResult searchEmployee(String id) throws IOException {
        Protocol protocol = new Protocol();
        String message = protocol.searchMessage(id);
        String returnMsg = client.sendMssageToServer(message);
        Parser parser = new Parser();
        DealResult dealResult = parser.parserSearch(returnMsg);
        return dealResult;
    }

    /**
     *@title: closeClient
     *@description: 关闭客户端功能实现方法
     *@author: tianyifan
     *@date: 2020-08-03 16:37
     *@param: [str]
     *@return: void
     *@throws: 无
     */
    public void closeClient(String str) throws IOException {
        client.sendMssageToServer(str);
        client.closeClient();
    }
}
