package day05.demo;

/*
  （一）网络编程：
   B/S:浏览器/服务器
   C/S:客户端/服务器
   网络通信协议：位于同一网络的计算机之间在进行连接和通信需要遵守的规则。
   它对传输格式，传输速率、传输步骤等做了统一规定，双方必须同时遵守才能完成数据交换。

   TCP/IP:传输控制协议/因特网互联协议
   链路层：用于定义物理传输通道，通常是对某些网络连接设备的驱动协议，例如对光纤、网线提供驱动。
   网络层：网络层是整个TCP/IP协议的核心，它主要用于传输的数据进行分组，将分组数据发送到目标计算机或网络
   运输层：主要使网络程序进行通信，在进行网络通信时，可采用TCP或者UDP协议。
   应用层：主要负责应用程序的协议，例如HTTP、FTP等

   协议分类：
   UDP:用户协议数据报（面向无连接通信协议：在数据传输前，在发送端和接收端不建立逻辑连接）
   特点：一次被限制在64kb以内。（数据报是网络传输的基本单位）
   TCP:传输控制协议（面向连接的通信协议：在数据传输时前，在发送端和接收端建立逻辑连接）
   三次握手协议：
   第一次握手：客户端向服务器端发出连接请求，等待服务器确认。
   第二次握手：服务器端向客户端回送一个响应，通知客户端收到连接请求
   第三次握手：客户端再次向服务器端发送确认信息，确认连接。
   特点：安全

   网络编程的三要素：
   1.协议
   2.IP地址
   IPV4:32位2进制（4个字节）
   IPV6：128位2进制（8个字节）
   常用命令：
   1）ipconfig（查看本机IP地址）
   2）ping（检查网络是否连通）
   127.0.0.1：表示本机的ip地址，一定能ping通
   localhost：表示本机的ip地址。
   3.端口号（由两个字节组成，取值范围在0-65535之间）：
   注：1.1024之前的端口号不能使用，已经被系统分配到已知的网络软件。
      2.网络软件端口号不能重复
      3.常用端口号：
      80端口：网络端口
      8080：Tomcat
      mysql：3306
      oracle:1521
   */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
TCP通信程序
注：通信两端要严格区分客户端与服务器端。
步骤：
1.服务端程序，需要事先启动，等待客户端的连接。
2.客户端主动连接服务器端，连接成功才能通信。服务端不可以主动连接客户端。
3.客户端与服务器端建立的连接中包含IO对象，通信的数据不仅仅是字符，所以IO对象是字节流对象。
*/
public class TCPClient {
    /*
    TCP通信的客户端：向服务器发送请求，给服务器发送数据，读取服务器回写数据
    一、表示客户端的类：
    java.net.Socket:此类实现客户端套接字（包括IP地址加端口号的网络单位），套接字是两台机器间通信的端点。
    构造方法：
    Socket(String host,int port)
    参数：
    1.host：服务器的名称/ip地址
    2.port：服务器端口号
    成员方法：
    OutputStream getOutputStream()返回此套接字的输出流
    InputStream getInputStream() 返回此套接字的输入流
    close()关闭此套接字
    实现步骤：
    1.创建客户端对象Socket，构造方法绑定服务器的IP地址和端口号
    2.使用Socket对象中的方法getOutputStream()获取网络字节输出流OutputStream
    3.使用网络字节输出流OutputStream对象中的法write，给服务器发送数据
    4.使用Socket对象中的方法getInputStream()获取网络字节输入流InputStream
    5.使用网络字节输入流InputStream对象中的方法read，读取服务器回写的数据
    6.释放资源
    注意：
    1.客户端和服务器端进行交互，必须使用Socket中提供的网络流，不能使用自己创建的流对象
    2.当我们创建客户端对象Socket的时候，就会去请求服务器和服务器经过三次握手的连接通路
    这时，如果服务器已经启动，则可以进行交互，否则将会抛出异常
    */

    public static void main(String[] args) throws IOException {
        //1.创建一个客户端对象Socket
        Socket socket=new Socket("127.0.0.1",8888);
        //2.获取网络字节输出流OutputStream
        OutputStream os=socket.getOutputStream();
        //3.使用网络字节输出流OutputStream对象中的法write，给服务器发送数据
        os.write("你好，服务器".getBytes());
        //4.使用Socket对象中的方法getInputStream()获取网络字节输入流InputStream
        InputStream is=socket.getInputStream();
        //5.使用网络字节输入流InputStream对象中的方法read，读取服务器回写的数据
        byte[] bytes=new byte[1024];
        int len=is.read(bytes);
        System.out.println(new String(bytes,0,len));
        //6.释放资源
        socket.close();

    }
}
