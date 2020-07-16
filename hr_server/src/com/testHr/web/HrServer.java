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
            serverSocket = new ServerSocket(8888);
            System.out.println("-----------服务器启动------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true){
            try {
                tcpSocket = serverSocket.accept();//通道建立
                //写信息

            } catch (IOException e) {
                e.printStackTrace();
            }
            /*
                为增加效率，增加多线程技术
                获取一个客户端，开启一个线程，完成文件上传
             */
            new Thread(new Runnable() {
                @Override
                public void run() {
                    BufferedReader in = null;
                    PrintWriter out = null;
                    String message = null;

                    try {
                        in = new BufferedReader(new InputStreamReader(tcpSocket.getInputStream()));
                        out = new PrintWriter(tcpSocket.getOutputStream());
                        message = in.readLine();//获取信息
                        ResumeService resumeService = new ResumeServiceImpl();
                        ResumeDTO resumeDTO = resumeService.dealWith(message,out);
                        out.println(resumeDTO.getHead()+":"+resumeDTO.isSuccess()+":"+resumeDTO.getBody());
                        if("over".equals(resumeDTO.getHead())){
                            if(in != null){
                                in.close();
                            }
                            if(out != null){
                                out.close();
                            }
                        }
                    } catch (IOException e) {
                            e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        new HrServer();
    }
}
