/**
 * projectName: TCPCommunication
 * fileName: TCPClient.java
 * packageName: TCPCommunicationSimulation
 * date: 2020-07-13 13:44
 * copyright(c) tianyifan
 */
package TCPCommunicationSimulation;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @version: V1.0
 * @author: tianyifan
 * @className: TCPClient
 * @packageName: TCPCommunicationSimulation
 * @description: TCP客户端，向服务器端发送连接请求，给服务器端发送数据/读取服务器端的数据
 * @date: 2020-07-13 13:44
 **/
public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8888);//创建客户端对象
        OutputStream outputStream = socket.getOutputStream();//获取网络字节输出流OutputStream对象
        outputStream.write("test".getBytes());//使用write方法向服务器发送数据
        InputStream inputStream = socket.getInputStream();//获取网络字节输入流InputStream对象
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);//读取服务器端发送的数据
        System.out.println("服务器端发送的数据:" + new String(bytes,0,len));//输出服务器端发送的数据
        socket.close();//释放资源

    }
}
