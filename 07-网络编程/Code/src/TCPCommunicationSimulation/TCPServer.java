/**
 * projectName: TCPCommunication
 * fileName: TCPServer.java
 * packageName: TCPCommunicationSimulation
 * date: 2020-07-13 14:13
 * copyright(c) tianyifan
 */
package TCPCommunicationSimulation;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version: V1.0
 * @author: tianyifan
 * @className: TCPServer
 * @packageName: TCPCommunicationSimulation
 * @description: TCP服务器端，接收客户端请求，读取客户端发送的数据，向客户端回写数据
 * @date: 2020-07-13 14:13
 **/
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);//创建服务器和系统指定的端口号
        Socket socket = serverSocket.accept();//获取到请求的客户端对象Socket
        InputStream inputStream = socket.getInputStream();//获取网络字节输入流InputStream对象
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);//读取客户端发送的数据
        System.out.println("客户端发送的数据:" + new String(bytes,0,len));//输出客户端发送的数据
        OutputStream outputStream = socket.getOutputStream();//获取网络字节输出流OutputStream对象
        outputStream.write("successful".getBytes());//给客户端回写数据
        socket.close();//释放资源
        serverSocket.close();//释放资源
    }
}
