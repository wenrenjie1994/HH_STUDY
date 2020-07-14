package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
*TCP通信的客户端：向服务器发送数据，并读写服务器端发送回的数据
* java.net.Socket套接字
* 构造方法：
*       Socket（String host，int port）
*       String host 服务器主机的名称/服务器的ip地址
*       int port 端口号
* 成员方法：
*      getOutputStream
*      getIutputStream
*      close
* 实现：
*    1.创建客户端对象Socket，绑定服务器IP和端口号
*    2.使用socket getoutputstream获取网络字节输出流
*    3.使用网络字节输出流OutputStream对象中的write方法给服务器发送数据
*    4.使用socket getInputstream获取网络字节输入流
* 5.使用网络字节输出流InputStream对象中的read方法读取服务器数据
* 6. 释放资源 close socket
* 注意：1.必须使用socket中的网络流
* 2.当我们创建客户端对象socket，客户端就会和服务器经过三次握手建立通路
*   这时候如果服务器没有启动，那么就会抛出异常，如果服务器已经启动，就可以进行交互
* */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket =new Socket("127.0.0.1",8888);
        OutputStream outputStream= socket.getOutputStream();
        outputStream.write("你好服务器".getBytes());
        InputStream is =socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes,0,len));
        socket.close();

    }
}
