package net;

/**
 * @Author lee
 * @Date 2020/7/15 7:24 PM
 **/


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import operator.ServerThread;

public class Server {


    static ServerSocket ss;
    Socket tcpConnection;

    public Server() {
        try {
            ss = new ServerSocket(2020);
            System.out.println("服务器启动了，等待客户端连接...");

        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {

            try {
                tcpConnection = ss.accept();//有新的Client连接
                System.out.println("有客服端连接上了");
                ServerThread r = new ServerThread(tcpConnection);//创建新的线程
                r.start();//运行线程
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Server();
    }

}

