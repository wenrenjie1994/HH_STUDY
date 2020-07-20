package operator;

/**
 * @program: HH_STUDY
 * @description:
 * @author: qiu haoran
 * @create: 2020-07-20 17:10
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import util.ServerProtocol;
import util.ServerParser;
import work.Action;
import medol.ReturnResult;
import medol.ActionResult;
import medol.Resume;
import medol.ResumeList;
public class ServerThread extends Thread {
    Socket connection;
    static BufferedReader in;
    static PrintWriter out;
    static String str;

    public ServerThread(Socket connection) {
        this.connection = connection;
    }
    //重写run方法
    public void run() {
        while(true) {
            try {
                in = new BufferedReader(new InputStreamReader(this.connection.getInputStream()));
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.connection.getOutputStream())), true);
                str = in.readLine();//获取客户端信息
            } catch (IOException var11) {
                var11.printStackTrace();
            }

            if (str.equals("bye")) {
                try {
                    out.println("bye");
                    in.close();
                    out.close();
                    this.connection.close();
                } catch (IOException var10) {
                    var10.printStackTrace();
                    continue;
                }
            } else {
                //解析信息
                ServerParser serverParser = new ServerParser();
                ReturnResult ss = serverParser.parser(str);
                new ActionResult();
                ActionResult ar;
                Action a;
                ResumeList resumeList;
                Resume resume;
                ServerProtocol serverProtocol;
                String message;
                if (ss.head.equals("add")) {
                    a = new Action();
                    resumeList = (ResumeList)ss.resultData;
                    resume = (Resume)resumeList.get(0);
                    ar = a.addResume(resume);
                    serverProtocol = new ServerProtocol();
                    message = serverProtocol.AddResumeMessage(ar);
                    System.out.println("向客户端返回：   " + message);
                    out.println(message);
                    continue;
                }

//                if (ss.head.equals("deletebyid")) {
//                    a = new Action();
//                    resumeList = (ResumeList)ss.resultData;
//                    resume = (Resume)resumeList.get(0);
//                    ar = a.deleteResumeById(resume);
//                    serverProtocol = new ServerProtocol();
//                    message = serverProtocol.deleteBookByIdMessage(ar);
//                    System.out.println("向客户端返回：   " + message);
//                    out.println(message);
//                    continue;
//                }
//
//                if (ss.head.equals("deletebyauthor")) {
//                    a = new ClientAction();
//                    resumeList = (ResumeList)ss.resultData;
//                    resume = (Resume)resumeList.get(0);
//                    ar = a.deleteResumeByAuthor(resume);
//                    serverprotocol = new Serverprotocol();
//                    message = serverprotocol.deleteResumeByAuthorMessage(ar);
//                    System.out.println("向客户端返回：   " + message);
//                    out.println(message);
//                    continue;
//                }
//
//                if (!ss.head.equals("change")) {
//                    if (ss.head.equals("searchbyname")) {
//                        a = new ClientAction();
//                        resumeList = (ResumeList)ss.resultData;
//                        resume = (Resume)resumeList.get(0);
//                        ar = a.searchResumeByName(resume);
//                        serverprotocol = new Serverprotocol();
//                        message = serverprotocol.searchResumeByNameMessage(ar);
//                        System.out.println("向客户端返回：   " + message);
//                        out.println(message);
//                        continue;
//                    }
//
//                    if (ss.head.equals("searchbyauthor")) {
//                        a = new ClientAction();
//                        resumeList = (ResumeList)ss.resultData;
//                        resume = (Resume)resumeList.get(0);
//                        ar = a.searchResumeByAuthor(resume);
//                        serverprotocol = new Serverprotocol();
//                        message = serverprotocol.searchResumeByAuthorMessage(ar);
//                        System.out.println("向客户端返回：   " + message);
//                        out.println(message);
//                        continue;
//                    }
//
//                    if (ss.head.equals("searchbyprice")) {
//                        a = new ClientAction();
//                        resumeList = (ResumeList)ss.resultData;
//                        resume = (Resume)resumeList.get(0);
//                        ar = a.searchResumeByPrice(resume);
//                        serverprotocol = new Serverprotocol();
//                        message = serverprotocol.searchResumeByPriceMessage(ar);
//                        System.out.println("向客户端返回：   " + message);
//                        out.println(message);
//                        continue;
//                    }
//
//                    if (ss.head.equals("searchbykeyword")) {
//                        a = new ClientAction();
//                        resumeList = (ResumeList)ss.resultData;
//                        resume = (Resume)resumeList.get(0);
//                        ar = a.searchResumeByPointword(resume);
//                        serverprotocol = new Serverprotocol();
//                        message = serverprotocol.searchResumeByKeyWordMessage(ar);
//                        System.out.println("向客户端返回：   " + message);
//                        out.println(message);
//                    }
//                    continue;
//                }

//                a = new Action();
//                resumeList = (ResumeList)ss.resultData;
//                resume = (Resume)resumeList.get(0);
//                Resume oldresume = (Resume)resumeList.get(1);
//                ar = a.changeResume(resume, oldresume);
//                Serverprotocol serverprotocol = new Serverprotocol();
//                String message = serverprotocol.changeResumeMessage(ar);
//                System.out.println("向客户端返回：   " + message);
//                out.println(message);
            }

            return;
        }
    }
}
