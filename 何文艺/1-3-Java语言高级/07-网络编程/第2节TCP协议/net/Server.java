package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        Socket client = null;
        ServerSocket server = null;
        try {
            //1.创建服务器ServerSocket对象，和系统要指定的端口号
            server = new ServerSocket(8888);
            //2.使用ServerSocket对象中的方法accept获取到请求的客户端对象Socket
            client = server.accept();
            //3.使用Socket对象中的方法getInputStream()获取网络字节输入流InputStream对象
            InputStream is = client.getInputStream();
            //4.使用网络字节输入流InputStream对象中的方法read读取客户端发送的数据
            byte[] bytes = new byte[1024];
            int len = is.read(bytes);
            System.out.println(new String(bytes, 0, len));
            //5.使用Socket对象中的方法getOutputStream()获取网络字节输出流OutputStream对象
            OutputStream os = client.getOutputStream();
            //6.使用网络字节输出流OutputStream对象中的方法write给客户端回写数据
            os.write("谢谢".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //7.释放资源（关闭Socket、ServerSocket就可以了）
            try {
                if (client != null) {
                    client.close();
                }
                if (server != null) {
                    server.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
