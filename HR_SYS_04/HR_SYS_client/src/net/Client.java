package net;

import java.io.*;
import java.net.Socket;

public class Client {

    BufferedReader in;
    PrintWriter out;
    Socket tcpConnection;

    public Client(){

        try {
            tcpConnection = new Socket("127.0.0.1", 1235);
            System.out.println("连接上服务器了");
            in = new BufferedReader(new InputStreamReader(tcpConnection.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(tcpConnection.getOutputStream())), true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static class clientContainer {
        private static Client client = new Client();
    }

    public static Client getClient() {
        return clientContainer.client;
    }

    public String sendMessageToSever(String message)//发送字符串去客服端
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

    public void closeClient()//关闭客户端并关闭连接
    {
        try {
            in.close();
            out.close();
            tcpConnection.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
