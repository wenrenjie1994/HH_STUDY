package operator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import model.*;
import util.*;
import service.Service;

public class ServerThread extends Thread {
    Socket connection;
    static BufferedReader in;
    static PrintWriter out;
    static String str;
    public ServerThread(Socket connection)
    {
        this.connection=connection;
    }

    @Override
    public void run() {
        while(true){
            /*
             * 用Server中的getMessageByClient方法得到协议（字符串）
             * 把协议（字符串）放到parser里解析 返回得到ReturnResult（包含head和数据两个属性）类型结果
             * if语句判断head信息得到用户端想进行什么操作
             * 把ReturnMessage的data转换为IntervieweeList从而得到Interviewee
             * 把得到的Interviewee传到Service进行连接数据库进行增删改查的操作并返回ServiceResult（包含是否成功 ，失败愿意 ，成功结果三个属性）类型结果
             * 把ServiceResult交给Protocol中编写协议（字符串）并返回
             * 用Server中的sendMessageToClient方法把协议（字符串）发送到客户端
             * 如果传过来的信息为"bye"关闭服务器跳出while
             * */
            try{
                in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(connection.getOutputStream())), true);
                str = in.readLine();
            } catch (IOException e){
                e.printStackTrace();
            }

            if(str.equals("bye")){
                try{
                    out.println("bye");
                    in.close();
                    out.close();
                    connection.close();
                    break;
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            else{
                Parser parser = new Parser();
                ReturnMessage rm = parser.parser(str);
                ServiceResult sr = new ServiceResult();
                if(rm.head.equals("add")){
                    Service service = new Service();
                    // 获取解析的数据
                    IntervieweeList iList = (IntervieweeList) rm.data;
                    Interviewee interviewee = iList.get(0);
                    sr = service.addInterviewee(interviewee);
                    Protocol protocol = new Protocol();
                    String message = protocol.getReturnMessage(sr);
                    System.out.println("向客户端返回："+message);
                    out.println(message);
                }
                else if(rm.head.equals("deleteByName")){
                    Service service = new Service();
                    // 获取解析的数据
                    IntervieweeList iList = (IntervieweeList) rm.data;
                    Interviewee interviewee = iList.get(0);
                    sr = service.deleteIntervieweeByName(interviewee.getName());
                    Protocol protocol = new Protocol();
                    String message = protocol.getReturnMessage(sr);
                    System.out.println("向客户端返回："+message);
                    out.println(message);
                }
                else if(rm.head.equals("deleteByID")){
                    Service service = new Service();
                    // 获取解析的数据
                    IntervieweeList iList = (IntervieweeList) rm.data;
                    Interviewee interviewee = iList.get(0);
                    sr = service.deleteIntervieweeByID(interviewee.getID());
                    Protocol protocol = new Protocol();
                    String message = protocol.getReturnMessage(sr);
                    System.out.println("向客户端返回："+message);
                    out.println(message);
                }
                else if(rm.head.equals("modify")){
                    Service service = new Service();
                    // 获取解析的数据
                    IntervieweeList iList = (IntervieweeList) rm.data;
                    Interviewee interviewee = iList.get(0);
                    sr = service.modifyInterviewee(interviewee);
                    Protocol protocol = new Protocol();
                    String message = protocol.getReturnMessage(sr);
                    System.out.println("向客户端返回："+message);
                    out.println(message);
                }
                else if(rm.head.equals("searchByName")){
                    Service service = new Service();
                    // 获取解析的数据
                    IntervieweeList iList = (IntervieweeList) rm.data;
                    Interviewee interviewee = iList.get(0);
                    sr = service.findIntervieweeByName(interviewee.getName());
                    Protocol protocol = new Protocol();
                    String message = protocol.getSearchMessage(sr);
                    System.out.println("向客户端返回："+message);
                    out.println(message);
                }
                else if(rm.head.equals("searchBySchool")){
                    Service service = new Service();
                    // 获取解析的数据
                    IntervieweeList iList = (IntervieweeList) rm.data;
                    Interviewee interviewee = iList.get(0);
                    sr = service.findIntervieweeBySchool(interviewee.getSchool());
                    Protocol protocol = new Protocol();
                    String message = protocol.getSearchMessage(sr);
                    System.out.println("向客户端返回："+message);
                    out.println(message);
                }
                else if(rm.head.equals("searchByPosition")){
                    Service service = new Service();
                    // 获取解析的数据
                    IntervieweeList iList = (IntervieweeList) rm.data;
                    Interviewee interviewee = iList.get(0);
                    sr = service.findIntervieweeByPosition(interviewee.getPosition());
                    Protocol protocol = new Protocol();
                    String message = protocol.getSearchMessage(sr);
                    System.out.println("向客户端返回："+message);
                    out.println(message);
                }
            }
            str = "";
        }
    }
}
