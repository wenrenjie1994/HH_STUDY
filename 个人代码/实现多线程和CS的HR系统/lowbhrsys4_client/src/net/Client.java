package net;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author 杜波
 * @version 创建时间: 2020/7/19 14:51
 */
public class Client {
    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;

    public Client() {
        try {
            socket = new Socket("127.0.0.1", 8088);
            System.out.print("连接上服务器了");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);


        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static class clientContainer {
        private static Client client = new Client();
    }

    public static Client getClient() {
        return clientContainer.client;
    }

    /**
     * 发送字符串去客服端
     * @param message
     * @return
     */
    public String sendMessageToSever(String message)//
    {
        String str = "";
        try {
            out.println(message);
            System.out.println("向服务器发送：  "+message);
            str = in.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
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
            socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
