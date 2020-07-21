package net;

import operator.ServerThread;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author 杜波
 * @version 创建时间: 2020/7/19 14:50
 */
public class Server {
    /**
     * 服务端端口
     */
    private ServerSocket serverSocket;
    private Socket socket;

    public Server() {
        try {
            serverSocket = new ServerSocket(8088);
            System.out.println("服务器启动了，等待客户端连接...");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //FixedThreadPool最多开启3（参数）个线程，多余的线程会存储在队列中，等线程处理完了
        Executor executor = Executors.newFixedThreadPool(3);
        while (true) {

            try {
                //有新的Client连接
                socket = serverSocket.accept();
                System.out.println("有客服端连接上了");
                //创建新的线程
                ServerThread r = new ServerThread(socket);
                //运行线程
                r.start();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        new Server();

    }
}

