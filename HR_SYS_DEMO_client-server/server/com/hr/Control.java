package com.hr;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.Scanner;

public class Control {
    public Control() throws Exception{
        //建立服务连接
        ServerSocket serverSocket = new ServerSocket(88);
        while (true){
            System.out.println("等待连接...");
            Socket socket = serverSocket.accept();
            System.out.println("收到新连接!");
            Thread resumeTask = new Thread(new ResumeTask(socket));
            System.out.println("Socket 线程：" + socket.toString() + " 开启");
            resumeTask.start();
        }

    }
    public static void main(String[] args){
        try {
            new Control();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
