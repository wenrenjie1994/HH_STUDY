package thread;

import model.OperatorResult;
import model.Resume;
import model.ReturnResult;
import service.Action;
import tcp.Parser;
import tcp.Protocol;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

public class ServerThread extends Thread{
    Socket connection;
    BufferedReader in;
    PrintWriter out;
    String str;
    public ServerThread(Socket connection)
    {

        this.connection=connection;
    }
    @Override
    public void run(){
        while(true)
        {
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
                in =new BufferedReader(new InputStreamReader(connection.getInputStream()));//输入流读取来自客户端信息
                out =new PrintWriter(new BufferedWriter(new OutputStreamWriter(connection.getOutputStream())),true);//输出流想客户端传递信息
                str = in.readLine();

            } catch (IOException e) {
                e.printStackTrace();
            }

            if(str.equals("exit"))
            {
                try {
                    out.println("exit");
                    in.close();
                    out.close();
                    connection.close();
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else
            {
                Parser parser=new Parser();
                ReturnResult returnResult=parser.parser(str);//解析信息
                OperatorResult operatorResult=new OperatorResult();
                if(returnResult.head.equals("添加简历"))
                {
                    Action action =new Action();
                    LinkedList<Resume> resumeList=(LinkedList<Resume>)returnResult.resultData;
                    Resume resume =resumeList.get(0);
                    operatorResult=action.addResume(resume);
                    Protocol protocol=new Protocol();
                    String message=protocol.addResumeMessage(operatorResult);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);

                }
                else if(returnResult.head.equals("通过姓名删除简历"))
                {
                    Action action=new Action();
                    LinkedList<Resume> resumeList=(LinkedList<Resume>)returnResult.resultData;
                    Resume resume =resumeList.get(0);
                    operatorResult=action.deleteResumeByName(resume);
                    Protocol protocol=new Protocol();
                    String message=protocol.deleteResumeByNameMessage(operatorResult);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);
                }
                else if(returnResult.head.equals("通过身份证号码删除简历"))
                {
                    Action action=new Action();
                    LinkedList<Resume> resumeList=(LinkedList<Resume>)returnResult.resultData;
                    Resume resume =resumeList.get(0);
                    operatorResult=action.deleteResumeById(resume);
                    Protocol protocol=new Protocol();
                    String message=protocol.deleteResumeByIdMessage(operatorResult);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);
                }
                else if(returnResult.head.equals("通过学校删除简历"))
                {
                    Action action=new Action();
                    LinkedList<Resume> resumeList=(LinkedList<Resume>)returnResult.resultData;
                    Resume resume =resumeList.get(0);
                    operatorResult=action.deleteResumeBySchool(resume);
                    Protocol protocol=new Protocol();
                    String message=protocol.deleteResumeByNameMessage(operatorResult);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);
                }
                else if(returnResult.head.equals("更新简历信息"))
                {
                    Action action=new Action();
                    LinkedList<Resume> resumeList=(LinkedList<Resume>)returnResult.resultData;
                    Resume resume =resumeList.get(0);
                    Resume oldResume =resumeList.get(1);
                    operatorResult=action.updateResume(resume,oldResume);
                    Protocol protocol=new Protocol();
                    String message=protocol.updateResumeMessage(operatorResult);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);
                }
                else if(returnResult.head.equals("按照姓名查询"))
                {
                    Action action=new Action();
                    LinkedList<Resume> resumeList=(LinkedList<Resume>)returnResult.resultData;
                    Resume resume =resumeList.get(0);
                    operatorResult=action.searchResumeByName(resume);
                    Protocol protocol=new Protocol();
                    String message=protocol.searchResumeByNameMessage(operatorResult);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);

                }
                else if(returnResult.head.equals("按照身份证号码查询"))
                {
                    Action action=new Action();
                    LinkedList<Resume> resumeList=(LinkedList<Resume>)returnResult.resultData;
                    Resume resume =resumeList.get(0);
                    operatorResult=action.searchResumeById(resume);
                    Protocol protocol=new Protocol();
                    String message=protocol.searchResumeByIdMessage(operatorResult);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);
                }
                else if(returnResult.head.equals("按照学校查询"))
                {
                    Action action=new Action();
                    LinkedList<Resume> resumeList=(LinkedList<Resume>)returnResult.resultData;
                    Resume resume =resumeList.get(0);
                    operatorResult=action.searchResumeBySchool(resume);
                    Protocol protocol=new Protocol();
                    String message=protocol.searchResumeBySchoolMessage(operatorResult);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);
                }
            }

        }

    }
}
