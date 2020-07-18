package serverse;

import bean.ActionResult;
import bean.ResumeList;
import bean.ReturnResult;
import utils.Parser;
import utils.Protocol;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {

    Socket connection;
    static BufferedReader in;
    static PrintWriter out;
    static String str;

    public ServerThread(Socket tcpConnection) {
        connection = tcpConnection;
    }

    @Override
    public void run(){

        while (true){

            try {
                in =new BufferedReader(new InputStreamReader(connection.getInputStream()));
                out =new PrintWriter(new BufferedWriter(new OutputStreamWriter(connection.getOutputStream())),true);
                str = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (str == "本次完成使用"){
                try {
                    out.println("bye");
                    in.close();
                    out.close();
                    connection.close();
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {

                Parser parser = new Parser();
                ReturnResult returnResult= parser.parser(str);
                HRSService hrsService = new HRSService();
                ActionResult ar = new ActionResult();
                if (returnResult.head.equals("add")){
                    ResumeList list = (ResumeList) returnResult.resultData;
                    ar = hrsService.addResume(list.get(0));
                    Protocol protocol = new Protocol();
                    String message = protocol.AddResumeMessage(ar);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);
                }else if (returnResult.head.equals("deletebyid")){
                    String id = (String) returnResult.resultData;
                    ar = hrsService.deleteResuem(id);
                    Protocol protocol = new Protocol();
                    String message = protocol.DeleteResumeMessage(ar);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);
                }else if (returnResult.head.equals("update")){
                    ResumeList list = (ResumeList) returnResult.resultData;
                    ar = hrsService.updateResume(list.get(0),list.get(0).getId());
                    Protocol protocol = new Protocol();
                    String message = protocol.UpdateResumeMessage(ar);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);

                }else if (returnResult.head.equals("searchbyid")){
                    String id = (String) returnResult.resultData;
                    ar = hrsService.selectResuemById(id);
                    Protocol protocol = new Protocol();
                    String message = protocol.SearchByIdMessage(ar);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);
                }else if (returnResult.head.equals("searchbyname")){
                    String name = (String) returnResult.resultData;
                    ar = hrsService.selectResuemByName(name);
                    Protocol protocol = new Protocol();
                    String message = protocol.SearchByNameMessage(ar);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);
                }else if (returnResult.head.equals("searchbyschool")){
                    String school = (String) returnResult.resultData;
                    ar = hrsService.selectResuemBySchool(school);
                    Protocol protocol = new Protocol();
                    String message = protocol.SearchBySchoolMessage(ar);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);
                }else if (returnResult.head.equals("searchall")){

                    ar = hrsService.selectAllResuem();
                    Protocol protocol = new Protocol();
                    String message = protocol.SearchAllMessage(ar);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);
                }

            }

        }

    }
}
