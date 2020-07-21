package operator;

import model.ActionResult;
import model.Resume;
import util.Protocol;
import work.ResumeWork;

import java.io.*;
import java.net.Socket;

/**
 * @author 杜波
 * @version 创建时间: 2020/7/20 10:22
 */
public class ServerThread extends Thread{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String str;
    
    public ServerThread(Socket socket)
    {
        this.socket=socket;
    }
    @Override
    public void run() {
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
                in =new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out =new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
                str = in.readLine();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                out.println("bye");
                try {
                    in.close();
                    out.close();
                    socket.close();
                    System.out.println("客户端连接异常，服务器端断开连接!");
                    break;
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            if("bye".equals(str)) {
                try {
                    out.println("bye");
                    in.close();
                    out.close();
                    socket.close();
                    System.out.println("客户端关闭连接");
                    break;
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    System.out.println("异常");
                    e.printStackTrace();
                }
            } else {
                String[] strs=str.split("/n");
                ActionResult ar=null;
                ResumeWork  resumeWork=new ResumeWork();
                if("addResume".equals(strs[0])) {
                    Resume resume=new Resume();
                    resume.setResumeId(strs[1]);
                    resume.setName(strs[2]);
                    resume.setId(strs[3]);
                    resume.setSchool(strs[4]);
                    resume.setProcess(Integer.parseInt(strs[5]));
                    ar=resumeWork.addResume(resume);
                    String message=Protocol.assembleMessage(ar);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);
                } else if("deleteResumeByResumeId".equals(strs[0])) {
                    ar=resumeWork.deleteResumeByResumeId(strs[1]);
                    String message=Protocol.assembleMessage(ar);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);
                } else if("deleteResumeByName".equals(strs[0])){
                    ar=resumeWork.deleteResumeByName(strs[1]);
                    String message=Protocol.assembleMessage(ar);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);
                }else if("deleteResumeById".equals(strs[0])) {
                    ar=resumeWork.deleteResumeById(strs[1]);
                    String message=Protocol.assembleMessage(ar);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);
                } else if("deleteResumeBySchool".equals(strs[0])) {
                    ar=resumeWork.deleteResumeBySchool(strs[1]);
                    String message=Protocol.assembleMessage(ar);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);
                } else if("deleteResumeByProcess".equals(strs[0])) {
                    ar=resumeWork.deleteResumeByProcess(Integer.parseInt(strs[1]));
                    String message=Protocol.assembleMessage(ar);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);
                } else if("updateResumeName".equals(strs[0])) {
                    Resume resume=new Resume();
                    resume.setResumeId(strs[1]);
                    resume.setName(strs[2]);
                    ar=resumeWork.updateResumeName(resume);
                    String message=Protocol.assembleMessage(ar);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);
                } else if("updateResumeIdCard".equals(strs[0])) {
                    Resume resume=new Resume();
                    resume.setResumeId(strs[1]);
                    resume.setId(strs[2]);
                    ar=resumeWork.updateResumeIdCard(resume);
                    String message=Protocol.assembleMessage(ar);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);
                }else if("updateResumeSchool".equals(strs[0])) {
                    Resume resume=new Resume();
                    resume.setResumeId(strs[1]);
                    resume.setSchool(strs[2]);
                    ar=resumeWork.updateResumeSchool(resume);
                    String message=Protocol.assembleMessage(ar);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);
                }else if("updateResumeProcess".equals(strs[0])) {
                    Resume resume=new Resume();
                    resume.setResumeId(strs[1]);
                    resume.setProcess(Integer.parseInt(strs[2]));
                    ar=resumeWork.updateResumeProcess(resume);
                    String message=Protocol.assembleMessage(ar);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);
                }else if("updateResumeAll".equals(strs[0])) {
                    Resume resume=new Resume();
                    resume.setResumeId(strs[1]);
                    resume.setName(strs[2]);
                    resume.setId(strs[3]);
                    resume.setSchool(strs[4]);
                    resume.setProcess(Integer.parseInt(strs[5]));
                    ar=resumeWork.updateResumeAll(resume);
                    String message=Protocol.assembleMessage(ar);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);
                }else if("queryResumeByName".equals(strs[0])) {
                    ar=resumeWork.queryResumeByName(strs[1]);
                    String message=Protocol.assembleMessage(ar);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);
                }else if("queryResumeById".equals(strs[0])) {
                    ar=resumeWork.queryResumeById(strs[1]);
                    String message=Protocol.assembleMessage(ar);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);
                }else if("queryResumeBySchool".equals(strs[0])) {
                    ar=resumeWork.queryResumeBySchool(strs[1]);
                    String message=Protocol.assembleMessage(ar);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);
                }else if("queryResumeByProcess".equals(strs[0])) {
                    ar=resumeWork.queryResumeByProcess(Integer.parseInt(strs[1]));
                    String message=Protocol.assembleMessage(ar);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);
                }else if("queryResumeAll".equals(strs[0])) {
                    ar=resumeWork.queryResumeAll();
                    String message=Protocol.assembleMessage(ar);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);
                }
            }

        }
    }
}
