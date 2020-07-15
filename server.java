package com.zzu;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket socket;

        try {
            //创建一个目标端口为8088的socket
            serverSocket = new  ServerSocket(8088);

            while (true){
                //监听客户端的请求
                socket = serverSocket.accept();

                InputStream inputStream = null;
                OutputStream outputStream = null;
                try{
                    //从socket接收来自客户端的消息
                    inputStream = socket.getInputStream();
                    //建立byte数组，将消息放入数组
                    byte[] bytes = new byte[10240];
                    inputStream.read(bytes);
                    //对数组进行处理。并在控制台打印信息
                    String readvc = new String(bytes).trim();
                    System.out.println("readvc:" + new String(bytes));
                    //获取服务器的响应信息并输出至控制台
                    outputStream = socket.getOutputStream();
                    outputStream.write(("server-" + new String(bytes)).getBytes());
                    //如果从客户端传来的信息是quit则跳出while循环，此次会话结束
                    if ("quit".equalsIgnoreCase(readvc)){
                        break;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
