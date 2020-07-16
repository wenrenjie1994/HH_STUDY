package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import operator.ServerThread;

public class Server {
    static ServerSocket ss;
    Socket tcpConnection;
    public Server(){
        try{
            ss = new ServerSocket(10086);
            System.out.println("服务器启动了，等待客户端连接...");
        } catch (IOException e){
            e.printStackTrace();
        }
        while(true){
            try{
                tcpConnection = ss.accept();
                System.out.println("有客户端成功连接!");
                // 创建新线程
                ServerThread st = new ServerThread(tcpConnection);
                st.start();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        new Server();
    }
}
