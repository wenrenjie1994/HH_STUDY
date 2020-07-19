package sever;

import thread.ServerThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket serverSocket;
    Socket socket;
    public Server()
    {
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("服务器已经成功启动");
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true)
        {

            try {
                socket = serverSocket.accept();//监听新的客户端连接
                System.out.println("有客户端连接上了");
                ServerThread thread=new ServerThread(socket);//创建新的线程
                thread.start();//运行线程
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Server();
    }

}
