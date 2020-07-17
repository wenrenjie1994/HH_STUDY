package net;

import java.io.*;
import java.net.Socket;

public class Client {

    private DataInputStream in;
    private DataOutputStream out;
    private Socket tcpConnection;

    public Client() {

        try {
            tcpConnection = new Socket("127.0.0.1", 8888);
            System.out.println("连接上服务器了:)");
            in = new DataInputStream(tcpConnection.getInputStream());
            out = new DataOutputStream(tcpConnection.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientContainer {
        private static Client client = new Client();
    }

    public static Client getClient() {
        return ClientContainer.client;
    }

    // 发送字符串到服务器端，并返回服务器的处理结果
    public String sendMessage2Sever(String message) {
        String result = "";

        try {
            out.writeUTF(message);
            System.out.println("向服务器发送：" + message);
            result = in.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void closeClient() {

        try {
            in.close();
            out.close();
            tcpConnection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
