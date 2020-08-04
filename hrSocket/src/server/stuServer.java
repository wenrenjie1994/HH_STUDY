package server;

import student.student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import client.client;

public class stuServer {
    public static void main(String[] args) throws IOException {
        int port=50007;
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            //等待客户端的连接
            Socket conn = serverSocket.accept();
            System.out.println("Connected by "+conn.getInetAddress());
            //每当有一个客户端连接进来后，就启动一个单独的线程进行处理
            new  client(conn).start();
        }
    }
}
