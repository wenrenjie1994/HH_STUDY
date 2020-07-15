package com.spdb.lowbhrsys.client.net;

import java.io.*;
import java.net.Socket;

/**
 * @author: libobo
 * @create: 2020-07-15 19:00
 * @description:
 **/
public class Client {
    private BufferedReader in;
    private PrintWriter out;
    private Socket connection;
    public Client() {
        try {
            connection = new Socket("127.0.0.1", 8888);
            System.out.print("连接上服务器了");
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(connection.getOutputStream())), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送字符串去服务端
     * @param message
     * @return
     */
    public String sendMessageToSever(String message)
    {
        String str = "";
        try {
            out.println(message);
            System.out.println("向服务器发送：  "+message);
            str = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 关闭客户端并关闭连接
     */
    public void closeClient()
    {
        try {
            in.close();
            out.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
