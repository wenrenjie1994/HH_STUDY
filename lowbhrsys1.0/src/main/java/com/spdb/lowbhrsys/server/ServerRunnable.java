package com.spdb.lowbhrsys.server;

import com.spdb.lowbhrsys.bean.ResumeBean;
import com.spdb.lowbhrsys.service.IResumeService;
import com.spdb.lowbhrsys.service.impl.ResumeDBServiceImpl;
import com.spdb.lowbhrsys.utils.Parser;
import com.spdb.lowbhrsys.utils.Protocol;
import com.spdb.lowbhrsys.utils.ResponseData;

import java.io.*;
import java.net.Socket;

/**
 * @author: libobo
 * @create: 2020-07-14 19:43
 * @description:
 **/
public class ServerRunnable implements Runnable {
    private Socket connection;
    private IResumeService resumeService=new ResumeDBServiceImpl();
    private BufferedReader in=null;
    private PrintWriter out=null;
    private String str=null;

    public ServerRunnable(Socket connection){
        this.connection=connection;
    }

    /**
     * 重写run方法
     * 用于处理客户端发送的请求
     */
    @Override
    public void run() {
        while (true){
            try {
                in =new BufferedReader(new InputStreamReader(connection.getInputStream()));
                out =new PrintWriter(new BufferedWriter(new OutputStreamWriter(connection.getOutputStream())),true);
                str = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if("bye".equals(str))
            {
                try {
                    out.println("bye");
                    if (in!=null){
                        in.close();
                    }
                    if (out!=null){
                        out.close();
                    }
                    connection.close();
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                Protocol protocol=new Protocol();
                Parser parser=new Parser();
                ResponseData<String[]> data = parser.parserClient(str);
                if ("addResume".equals(data.getMsg())){
                    String[] dataArr=  data.getData();
                    ResumeBean resume=new ResumeBean(dataArr[0],dataArr[1],dataArr[2],dataArr[3],dataArr[4],dataArr[5]);
                    ResponseData responseData = resumeService.addResume(resume);
                    String resultStr = protocol.protocolServer(responseData);
                    out.println(resultStr);
                }else if ("updateResume".equals(data.getMsg())){
                    String[] dataArr=  data.getData();
                    ResponseData responseData = resumeService.updateResume(Integer.parseInt(dataArr[0]), dataArr[1], dataArr[2], dataArr[3]);
                    String resultStr = protocol.protocolServer(responseData);
                    out.println(resultStr);
                }else if ("delResume".equals(data.getMsg())){
                    String[] dataArr=  data.getData();
                    ResponseData responseData = resumeService.deleteResume(Integer.parseInt(dataArr[0]));
                    String resultStr = protocol.protocolServer(responseData);
                    out.println(resultStr);
                }else if ("findResume".equals(data.getMsg())){
                    String[] dataArr=  data.getData();
                    ResponseData responseData = resumeService.findResumeByResumeId(Integer.parseInt(dataArr[0]));
                    String resultStr = protocol.protocolServer(responseData);
                    out.println(resultStr);
                }else if ("showAllResume".equals(data.getMsg())){
                    ResponseData responseData = resumeService.findAllResume();
                    String resultStr = protocol.protocolServer(responseData);
                    out.println(resultStr);
                }
            }
        }


    }
}
