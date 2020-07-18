package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2010);
        System.out.println("服务器已创建！等待客户端连接... ...");
        Socket socket = null;
        while (true) {
            socket = serverSocket.accept();
            System.out.println("客户端连接成功！");
            new ServerThread(socket).start();
        }
    }
}
