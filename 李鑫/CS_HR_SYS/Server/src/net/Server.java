package net;

import operator.ServerThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        new Server();
    }

    public Server() {

        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("服务器已启动，等待客户端连接...");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                Socket tcpConnection = serverSocket.accept();  // 有新的client连接
                System.out.println("客户端：" + tcpConnection.getInetAddress().getHostName() + "已连接到服务器");
                ServerThread r = new ServerThread(tcpConnection);  // 创建新的线程
                r.start();  // 运行线程

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
