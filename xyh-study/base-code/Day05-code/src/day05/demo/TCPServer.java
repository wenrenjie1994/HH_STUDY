package day05.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    /*
    TCP通信的服务器端：接收客户端发送的数据，给客户端回写数据
    一、表示服务器端的类：
    java.net.ServerSocket:此类实现服务器端套接字
    构造方法：
    ServerSocket(int port)创建绑定到特定端口的服务器套接字
    参数：port：端口号
    服务器必须知道是哪个客户端的请求
    所以可以使用accept方法获取到请求的客户端对象Socket
    成员方法：
    Socket accept():倾听并接收到套接字的连接
    实现步骤：
    1.创建服务器ServerSocket对象和系统要指定的端口
    2.使用ServerSocket对象方法中的accept，获取到请求的客户端对象Socket
    3.使用Socket对象中的方法getInputStream()获取网络字节输入流InputStream
    4.使用网络字节输入流InputStream对象中的方法read，读取客户端发送的数据
    5.使用Socket对象中的方法getOutputStream()获取网络字节输出流InputStream
    6.使用网络字节输出流OutputStream对象的方法write，给客户端写回数据
    7.释放资源
    */
    public static void main(String[] args) throws IOException {
        // 1.创建服务器ServerSocket对象和系统要指定的端口
        ServerSocket server=new ServerSocket(8888);
        // 2.使用ServerSocket对象方法中的accept，获取到请求的客户端对象Socket
        Socket socket=server.accept();
        //3.使用Socket对象中的方法getInputStream()获取网络字节输入流InputStream
        InputStream is=socket.getInputStream();
        //4.使用网络字节输入流InputStream对象中的方法read，读取客户端发送的数据
        byte[] bytes=new byte[1024];
        int len=is.read(bytes);
        System.out.println(new String(bytes,0,len));
        //5.使用Socket对象中的方法getOutputStream()获取网络字节输出流InputStream
        OutputStream os=socket.getOutputStream();
        //6.使用网络字节输出流OutputStream对象的方法write，给客户端写回数据
        os.write("收到，谢谢".getBytes());
        //7.释放资源
        socket.close();
        server.close();



    }
}
