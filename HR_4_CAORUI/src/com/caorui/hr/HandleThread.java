package com.caorui.hr;

import java.io.*;
import java.net.Socket;

import static com.caorui.hr.Server.choice;

public class HandleThread extends Thread{
    Socket socket;
    public HandleThread(Socket socket){
        this.socket=socket;
    }
    public void run(){
        try {
            InputStream is=socket.getInputStream();
            OutputStream os=socket.getOutputStream();
            DataInputStream dis=new DataInputStream(is);
            DataOutputStream dos=new DataOutputStream(os);
            //通过socket对象获取输入流
            //接收客户端传来的url
            String url =dis.readUTF();
            System.out.println("2、"+url);
            //解析输出的第一个数字，判断要进行哪个操作
            String[] strings = url.split("/n");
            String re = choice(strings);//获取操作的返回信息
            dos.writeUTF(re);//将返回信息返回到客户端
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
