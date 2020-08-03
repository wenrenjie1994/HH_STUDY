/**
 * projectName: HRS5.0_sever
 * fileName: ServerThread.java
 * packageName: thread
 * date: 2020-07-19 11:04
 * copyright(c) tianyifan
 */
package thread;


import action.FunctionAction;
import entity.Employee;
import util.ActionResult;
import util.Parser;
import util.Protocol;
import util.ReturnData;

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;

/**
 * @version: V5.0
 * @author: tianyifan
 * @className: ServerThread
 * @packageName: thread
 * @description: 服务器端线程类
 * @date: 2020-07-19 11:04
 **/
public class ServerThread implements Runnable{
    private Socket socket;//客户端套接字
    private static BufferedReader in;//输入流
    private static PrintWriter out;//输出流
    private static String str;
    private static FunctionAction functionAction;

    static {
        try {
            functionAction = new FunctionAction();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *@title: ServerThread
     *@description: 构造方法，传递保持socket连接
     *@author: tianyifan
     *@date: 2020-08-03 17:13
     *@param: [tcpConnection]
     *@return: 无
     *@throws: 无
     */
    public ServerThread(Socket tcpConnection){
        this.socket = tcpConnection;
    }

    /**
     *@title: run
     *@description: 实现Runnable接口的run()方法
     *@author: tianyifan
     *@date: 2020-07-19 11:28
     *@param: 无
     *@return: void
     *@throws: 无
     */
    @Override
    public void run() {
        while(true){
            //初始化输入输出流，获取协议字符串
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
                str = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //处理协议字符串，完成相应操作
            if(str.equals("quit")){
                out.println("bye");
                try {
                    in.close();
                    out.close();
                    socket.close();
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                Parser parser = new Parser();
                ReturnData returnData = parser.parser(str);
                ActionResult actionResult;

                if(returnData.getHead().equals("add")){
                    Employee employee = (Employee) returnData.getResult();
                    try {
                        //添加员工信息
                        actionResult = functionAction.add(employee.getId(),employee.getName(),employee.getDept(),employee.getSalary());
                        Protocol protocol = new Protocol();
                        String message = protocol.addMessage(actionResult);//生成返回客户端的协议信息
                        System.out.println("向客户端返回信息："+message);
                        out.println(message);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }else if(returnData.getHead().equals("delete")){
                    String id = (String) returnData.getResult();
                    try {
                        //删除员工信息(指定id)
                        actionResult = functionAction.delete(id);
                        Protocol protocol = new Protocol();
                        String message = protocol.deleteMessage(actionResult);//生成返回客户端的协议信息
                        System.out.println("向客户端返回信息："+message);
                        out.println(message);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }else if(returnData.getHead().equals("update")){
                    Employee employee = (Employee) returnData.getResult();
                    try {
                        //修改员工信息
                        actionResult = functionAction.update(employee.getId(),employee.getName(),employee.getDept(),employee.getSalary());
                        Protocol protocol = new Protocol();
                        String message = protocol.updateMessage(actionResult);//生成返回客户端的协议信息
                        System.out.println("向客户端返回信息："+message);
                        out.println(message);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }else if(returnData.getHead().equals("search")){
                    String id = (String) returnData.getResult();

                    try {
                        //查询员工信息
                        actionResult = functionAction.search(id);
                        Protocol protocol = new Protocol();
                        String message = protocol.searchMessage(actionResult);//生成返回客户端的协议信息
                        System.out.println("向客户端返回信息："+message);
                        out.println(message);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    }
}
