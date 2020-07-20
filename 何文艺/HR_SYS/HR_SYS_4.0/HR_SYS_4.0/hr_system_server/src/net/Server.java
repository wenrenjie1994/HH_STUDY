package net;

import operator.ServerThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: HR_SYS_4.0（C/S模式）
 * @className:Server
 * @description:服务器端
 * @author: 何文艺
 * @create: 2020/7/17 14:50
 **/
public class Server {
    /*
        服务器接收客户端请求步骤：
        1.创建一个ServerSocket实例，监听客户端发来的请求
        2.与客户端获取连接后，创建一个Socket实例，利用I/O流与客户端进行通信，完毕后关闭Socket
    */
    static ServerSocket serverSocket;
    Socket tcpConn;

    public Server() {
        try {
            //服务端打开端口1122
            serverSocket = new ServerSocket(1122);
            System.out.println("服务器启动了，等待客户端连接...");
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            //在1234端口上监听，看是否有连接请求过来
            try {
                tcpConn = serverSocket.accept();
                System.out.println("有客户端连接上了...");
                ServerThread serverThread = new ServerThread(tcpConn);//创建新线程处理这次连接
                new Thread(serverThread).start();//start()开启线程,JVM执行run方法
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
