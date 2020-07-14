package TCP;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
* TCP通信的服务器端
* 表示服务器的类 java.net.ServerSocket
* 构造方法：
*       ServerSocket（int port）;
*       服务器端必须明确：哪个客户端请的服务器（所以可以使用accept获取请求的客户端socket对象）
* 成员方法：
*      accept（）监听
* 实现步骤：
*        1.创建ServerSocket 对象
*        2.使用accept方法监听获取客户端socket
*        3.使用socket getInputstream获取网络字节输入流
*        4.使用网络字节输出流InputStream对象中的read方法读取客户端数据
*        5.使用网络字节输出流OutputStream获取输出流
*        6.使用write方法给客户端发送数据
*        7.释放资源（socket，ServerSocket）
* */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket =new ServerSocket(8888);
        Socket socket =serverSocket.accept();
        InputStream is =socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes,0,len));
        OutputStream os =socket.getOutputStream();
        os.write("收到谢谢".getBytes());
        socket.close();
        serverSocket.close();
    }
}
