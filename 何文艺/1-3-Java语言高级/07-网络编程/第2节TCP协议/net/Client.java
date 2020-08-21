package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Socket client = null;
        try {
            //1.创建一个客户端对象Socket，构造方法中绑定服务器的IP地址和端口号
            client = new Socket("localhost", 8888);
            //2.使用Socket对象中的方法getOutputStream()获取网络字节输出流OutputStream对象
            OutputStream os = client.getOutputStream();
            //3.使用网络字节输出流OutputStream对象中的方法write给服务器发送数据
            os.write("你好服务器".getBytes());
            //4.使用Socket对象中的方法getInputStream()获取网络字节输入流InputStream对象
            InputStream is = client.getInputStream();
            //5.使用网络字节输入流InputStream对象中的方法read读取服务器返回的数据
            byte[] bytes = new byte[1024];
            int len = is.read(bytes);
            System.out.println(new String(bytes, 0, len));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.释放资源（关闭Socket就可以了）
            try {
                if (client != null){
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
