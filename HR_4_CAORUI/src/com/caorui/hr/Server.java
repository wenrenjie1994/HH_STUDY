package com.caorui.hr;


import com.caorui.service.ApplicantService;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static String choice(String[] strings) {
        int ch = Integer.parseInt(strings[0]);
        if (ch == 1) {
            return ApplicantService.insert(strings);
        } else if (ch == 2) {
            return ApplicantService.select(strings);
        } else if (ch == 3) {
            return ApplicantService.delete(strings);
        } else if (ch == 4) {
            return ApplicantService.update(strings);
        } else {
            return "输入有误，请重新输入";
        }
    }

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket1 = serverSocket.accept();
            InputStream is = socket1.getInputStream();
            OutputStream os = socket1.getOutputStream();
            DataOutputStream dos=new DataOutputStream(os);
            DataInputStream dis=new DataInputStream(is);

            while (true) {
                System.out.println("新一轮的server开始工作啦");
                //通过socket对象获取输入流
                //接收客户端传来的url
                String url =dis.readUTF();

                System.out.println("2、"+url);

                //解析输出的第一个数字，判断要进行哪个操作
                String[] strings = url.split("/n");
                String re = choice(strings);//获取操作的返回信息

                dos.writeUTF(re);//将返回信息返回到客户端
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
