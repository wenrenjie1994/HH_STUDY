package operator;

/**
 * @Author lee
 * @Date 2020/7/15 7:42 PM
 **/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import model.ActionResult;
import model.Resume;
import model.ResumeList;
import model.ReturnResult;
import util.Parser;
import util.Protocol;
import work.Action;

public class ServerThread extends Thread {
    // 多线程实现方式之一，继承Thread类，重写run()方法

    // TODO Socket
    Socket connection;
    /**
     * Reader 和 Writer 字符流
     * 字符的形式读取和写入数据
     * <p>
     * InputStream 和 OutputStream 字节流
     * 字节的形式读取和写入数据
     */
    static BufferedReader in;
    static PrintWriter out;
    static String str;

    // 构造函数，初始化
    public ServerThread(Socket connection) {
        this.connection = connection;
    }

    @Override
    // 重写 run()
    public void run() {
        while (true) {
            /*
             * 用Server中的getMessageByClient方法得到协议（字符串）
             * 把协议（字符串）放到parser里解析 返回得到ReturnResult（包含head和数据两个属性）类型结果
             * if语句判断head信息得到用户端想进行什么操作
             * 把ReturnResult的data转换为bookList从而得到Book
             * 把得到的Book传到Action进行连接数据库进行增删改查的操作并返回ActionResult（包含是否成功 ，失败愿意 ，成功结果三个属性）类型结果
             * 把ActionResult交给Protocol中编写协议（字符串）并返回
             * 用Server中的sendMessageToClient方法把协议（字符串）发送到客户端
             * 如果传过来的信息为"bye"关闭服务器跳出while
             * */
            try {
                /**
                 * The getInputStream() method of Java Socket class returns an input stream for the given socket.
                 * If you close the returned InputStream, then it will close the linked socket.
                 * The getInputStream() returns an input stream for reading bytes from this socket.
                 */
                in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(connection.getOutputStream())), true);
                str = in.readLine();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // 断开连接 close-connection
            if (str.equals("4")) {
                try {
                    System.out.println("客户端断开连接");
                    out.println("4");
                    in.close();
                    out.close();
                    connection.close();
                    break;
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                Parser parser = new Parser();
                // 解析客户端发送的消息
                ReturnResult ss = parser.parser(str);

                ActionResult ars = new ActionResult();

                if (ss.head.equals("addResume")) {
                    Action a = new Action();
                    // 强制类型转化
                    ResumeList resumeList = (ResumeList) ss.resultData; // resultData 存放resumeList
                    Resume resume = resumeList.get(0);
                    ars = a.addResume(resume);
                    Protocol protocol = new Protocol();
                    String message = protocol.addResumeMessage(ars);
                    System.out.println("向客户端返回：   " + message);
                    out.println(message);
                } else if (ss.head.equals("deleteResumeByName")) {
                    Action a = new Action();
                    ResumeList resumeList = (ResumeList) ss.resultData;
                    Resume resume = resumeList.get(0);
                    ars = a.deleteResumeByName(resume);
                    Protocol protocol = new Protocol();
                    String message = protocol.deleteResumeMessage(ars);
                    System.out.println("向客户端返回：   " + message);
                    out.println(message);
                } else if (ss.head.equals("deleteResumeById")) {
                    Action a = new Action();
                    ResumeList resumeList = (ResumeList) ss.resultData;
                    Resume resume = resumeList.get(0);
                    ars = a.deleteResumeById(resume);
                    Protocol protocol = new Protocol();
                    String message = protocol.deleteResumeMessage(ars);
                    System.out.println("向客户端返回：   " + message);
                    out.println(message);
                } else if (ss.head.equals("deleteResumeBySchool")) {
                    Action a = new Action();
                    ResumeList resumeList = (ResumeList) ss.resultData;
                    Resume resume = resumeList.get(0);
                    ars = a.deleteResumeBySchool(resume);
                    Protocol protocol = new Protocol();
                    String message = protocol.deleteResumeMessage(ars);
                    System.out.println("向客户端返回：   " + message);
                    out.println(message);
                } else if (ss.head.equals("searchResumeByName")) {
                    Action a = new Action();
                    ResumeList resumeList = (ResumeList) ss.resultData;
                    Resume resume = resumeList.get(0);
                    ars = a.searchResumeByName(resume);
                    Protocol protocol = new Protocol();
                    String message = protocol.deleteResumeMessage(ars);
                    System.out.println("向客户端返回：   " + message);
                    out.println(message);
                } else if (ss.head.equals("searchResumeById")) {
                    Action a = new Action();
                    ResumeList resumeList = (ResumeList) ss.resultData;
                    Resume resume = resumeList.get(0);
                    ars = a.searchResumeById(resume);
                    Protocol protocol = new Protocol();
                    String message = protocol.deleteResumeMessage(ars);
                    System.out.println("向客户端返回：   " + message);
                    out.println(message);
                } else if (ss.head.equals("searchResumeBySchool")) {
                    Action a = new Action();
                    ResumeList resumeList = (ResumeList) ss.resultData;
                    Resume resume = resumeList.get(0);
                    ars = a.searchResumeBySchool(resume);
                    Protocol protocol = new Protocol();
                    String message = protocol.deleteResumeMessage(ars);
                    System.out.println("向客户端返回：   " + message);
                    out.println(message);
                }
            }

        }
    }
}
