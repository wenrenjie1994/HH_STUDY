package net;


import java.io.*;
import java.net.Socket;

/**
 * @program: HR_SYS_4.0（C/S模式）
 * @className:Client
 * @description:客户端
 * @author: 何文艺
 * @create: 2020/7/19 9:36
 **/
public class Client {
    /*
    客户端向服务器发送请求可分为以下步骤：
　　 1.创建一个Socket实例
　　 2.利用I/O流与服务器进行通信
　　 3.关闭socket
    */

    Socket tcpConn;
    BufferedReader in;
    PrintWriter out;

    public Client() {
        try {
            //创建一个流套接字并将其连接到指定主机上的指定端口号
            tcpConn = new Socket("localhost", 1122);
            System.out.println("连上服务器了...");
            //读取服务器端数据
            in = new BufferedReader(new InputStreamReader(tcpConn.getInputStream()));
            //向服务器端发送数据
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(tcpConn.getOutputStream())), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //静态内部类
    private static class clientContainer {
        private static Client client = new Client();
    }

    public static Client getClient() {
        return clientContainer.client;
    }

    //发送协议（字符串）去服务器端
    public String sendMessageToServer(String message) {
        String str = "";
        try {
            out.println(message);
            System.out.println("向服务器发送：" + message);
            str = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    //关闭客户端并关闭连接
    public void closeClient() {
        try {
            in.close();
            out.close();
            tcpConn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}
