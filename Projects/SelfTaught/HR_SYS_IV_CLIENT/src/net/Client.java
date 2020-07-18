package net;

import java.io.*;
import java.net.Socket;

public class Client {
    BufferedReader in;
    PrintWriter out;
    Socket sc;

    public Client() {
        try {
            sc = new Socket("127.0.0.1", 2010);
            System.out.println("已连接到服务器！");
            in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sc.getOutputStream())), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String sendMessageToServer(String message) throws IOException {
        String str = "";
        out.println(message);
        System.out.println("向服务器发送：" + message);
        str = in.readLine();
        return str;
    }

    public void closeClient() throws IOException {
        in.close();
        out.close();
        sc.close();
    }
}
