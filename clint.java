package com.zzu;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class clint {
    public static void main(String[] args) {
        //各种准备工作
        String addr = "127.0.0.1";
        int port = 8088;
        Socket socket = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;

        Scanner scan = new Scanner(System.in);

        while(true){
            try{
                //建立一个新的连接，目标地址为本机，端口号为8088
                socket = new Socket(addr,port);
                outputStream = socket.getOutputStream();
                //在控制台输入将要发送的信息
                System.out.println("请输入信息：");
                String data = scan.nextLine();
                //将信息转化为byte数组
                outputStream.write(data.getBytes());
                //将输出流中的缓存输出，防止因数据滞留在缓存中导致输出的数据丢失
                outputStream.flush();
                //输出将要发送的信息
                System.out.println("Send: " + data);
                //从socket中得到服务器端返回的数据
                inputStream = socket.getInputStream();
                //创建byte数组接受数据并处理
                byte[] bytes = new byte[10240];
                inputStream.read(bytes);
                String readcv = new String(bytes).trim();

                System.out.println("Recv:" + readcv);
                //如果服务器返回的是server-quit跳出循环本次会话结束
                if("server-quit".equalsIgnoreCase(readcv)){
                    break;
                }

            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
