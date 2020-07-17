package com.testHr.web;

import com.testHr.dto.ResumeDTO;
import com.testHr.service.ResumeService;
import com.testHr.service.impl.ResumeServiceImpl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author: zeng
 * @modified By:
 */
public class HrServer {
    static ServerSocket serverSocket;//服务器
    Socket tcpSocket ;//socket通道
    public HrServer(){
        try {
            serverSocket = new ServerSocket(1235);
            System.out.println("-----------服务器启动------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true){
            try {
                if (serverSocket.isClosed()){
                    System.exit(0);
                }
                tcpSocket = serverSocket.accept();//通道建立
            } catch (IOException e) {
                e.printStackTrace();
            }
            /*
                为增加效率，增加多线程技术处理客户端信息
             */
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        BufferedReader in = null;
                        PrintWriter out = null;
                        String message = null;
                        try {
                            in = new BufferedReader(new InputStreamReader(tcpSocket.getInputStream()));
                            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(tcpSocket.getOutputStream())),true);
                            message = in.readLine();
                            ResumeService resumeService = new ResumeServiceImpl();
                            ResumeDTO resumeDTO = resumeService.dealWith(message,out);
                            out.println(resumeDTO.getHead()+"-"+resumeDTO.isSuccess()+"-"+resumeDTO.getBody());
                            //也可以不关闭服务器端
                            if("over".equals(resumeDTO.getHead())){
                                serverSocket.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        new HrServer();
    }
}
