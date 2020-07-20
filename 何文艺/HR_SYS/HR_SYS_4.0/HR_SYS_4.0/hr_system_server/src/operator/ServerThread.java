package operator;

import model.ActionResult;
import model.Resume;
import model.ResumeLinkedList;
import model.ReturnResult;
import service.Action;
import utils.Parser;
import utils.Protocol;

import java.io.*;
import java.net.Socket;

/**
 * @program: HR_SYS_4.0（C/S模式）
 * @className:ServerThread
 * @description:处理客户端连接
 * @author: 何文艺
 * @create: 2020/7/17 15:09
 **/
//1.创建一个Runnable接口的实现类
public class ServerThread implements Runnable {
    private Socket connection;
    static BufferedReader in;
    static PrintWriter out;
    static String str;

    public ServerThread(Socket connection) {
        this.connection = connection;
    }

    //2.在实现类中重写Runnable接口的run方法，设置线程任务
    @Override
    public void run() {
/*
        1.用server中的getMessageByClient方法得到客户端发过来的协议（字符串）
        2.把协议放到Parser.java里面解析，返回得到ReturnResult类型的结果（包含操作head和操作数据resultData两个属性）
        3.根据操作head信息得到用户要进行的操作类型
        4.把操作数据resultData转换为ResumeLinkedList从而得到Resume
        5.把得到的Resume传到Action.java里进行数据库的连接和增删改查操作，并返回ActionResult类型的结果
        （包含数据库操作是否成功、数据库操作失败原因、数据库查询操作返回的结果数据三个属性）
        6.把ActionResult对象交给Protocol.java编写服务器端要发送给客户端的协议（字符串）并返回
        7.用Server中的sendMessageToClient方法把协议发送到客户端
        8.如果传过来的是"bye"则关闭服务器跳出while
*/
        while (true) {
            //读取客户端数据
            try {
                in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(connection.getOutputStream())), true);
                str = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //处理客户端数据
            if (str.equals("bye")) {
                try {
                    out.println("bye!");
                    in.close();
                    out.close();
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                //创建一个解析器
                Parser parser = new Parser();
                //把协议放到解析器里面解析，返回得到ReturnResult类型的结果
                ReturnResult returnResult = parser.parser(str);
                //把操作数据resultData转换为ResumeLinkedList
                ResumeLinkedList resumeLinkedList = (ResumeLinkedList) returnResult.resultData;
                //得到Resume
                Resume resume;
                Action action = new Action();
                Protocol protocol = new Protocol();
                ActionResult actionResult;
                String message;
                //根据操作head信息得到用户要进行的操作类型
                switch (returnResult.head) {
                    case "add":
                        resume = resumeLinkedList.get(0);
                        //把得到的Resume传到Action.java里进行数据库的连接和增删改查操作，并返回ActionResult类型的结果
                        actionResult = action.addResume(resume);
                        //把ActionResult对象交给Protocol.java编写服务器端要发送给客户端的协议（字符串）并返回
                        message = protocol.addResumeMessage(actionResult);
                        System.out.println("向客户端返回：" + message);
                        out.println(message);
                        break;
                    case "delete":
                        resume = resumeLinkedList.get(0);
                        actionResult = action.deleteResume(resume);
                        message = protocol.deleteResumeMessage(actionResult);
                        System.out.println("向客户端返回：" + message);
                        out.println(message);
                        break;
                    case "update":
                        Resume newResume = resumeLinkedList.get(0);
                        Resume oldResume = resumeLinkedList.get(1);
                        actionResult = action.updateResume(newResume, oldResume);
                        message = protocol.updateResumeMessage(actionResult);
                        System.out.println("向客户端返回：" + message);
                        out.println(message);
                        break;
                    case "searchByName":
                        resume = resumeLinkedList.get(0);
                        actionResult = action.searchByName(resume);
                        message = protocol.searchByNameMessage(actionResult);
                        System.out.println("向客户端返回：" + message);
                        out.println(message);
                        break;
                    case "searchById":
                        resume = resumeLinkedList.get(0);
                        actionResult = action.searchById(resume);
                        message = protocol.searchByIdMessage(actionResult);
                        System.out.println("向客户端返回：" + message);
                        out.println(message);
                        break;
                    case "searchBySchool":
                        resume = resumeLinkedList.get(0);
                        actionResult = action.searchBySchool(resume);
                        message = protocol.searchBySchoolMessage(actionResult);
                        System.out.println("向客户端返回：" + message);
                        out.println(message);
                        break;
                    case "searchByProcess":
                        resume = resumeLinkedList.get(0);
                        actionResult = action.searchByProcess(resume);
                        message = protocol.searchByProcessMessage(actionResult);
                        System.out.println("向客户端返回：" + message);
                        out.println(message);
                        break;
                    case "searchAll":
                        actionResult = action.searchAll();
                        message = protocol.searchAllMessage(actionResult);
                        System.out.println("向客户端返回：" + message);
                        out.println(message);
                        break;
                }
            }
        }
    }
}
