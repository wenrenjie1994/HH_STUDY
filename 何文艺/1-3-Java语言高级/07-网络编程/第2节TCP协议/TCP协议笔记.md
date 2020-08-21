**TCP 协议笔记**  

----------


**一、TCP 通信的概述（上）**  
1.两端通信时的步骤：  
a.服务器端程序需要事先启动等待客户端的连接  
b.客户端主动连接服务器端，连接成功才能通信，服务器端不可以主动连接客户端  
2.TCP 通信：面向连接的通信，客户端和服务器端必须经过 3 次握手建立逻辑连接，才能进行通信（安全）  

**二、TCP 通信的概述（下）**  
服务器必须明确两件事情：  
1.多个客户端（Socket 类）同时和服务器（ServerSocket 类）进行交互，服务器就必须明确和哪个客户端进行的交互  
在服务器端有一个方法 accept，用来获取发送请求的客户端对象     2.多个客户端同时和服务器进行交互，就需要使用多个 IO 流对象  
服务器是没有 IO 流的，它使用每个客户端中提供的 IO 流和客户端进行交互；  

**三、TCP 通信的客户端代码实现**  
TCP 通信的客户端：向服务器发送连接请求，给服务器发送数据，读取服务器回写的数据  
java.net.Socket：此类实现客户端套接字（套接字是两台机器间通信的端点）  
套接字：包含了 IP 地址和端口号的网络单位  

构造方法：  

    Socket(String host, int port)：创建一个流套接字并将其连接到指定主机上的指定端口号
    参数：
        String host：服务器主机的名称/服务器的IP地址
        int port：服务器的端口号

成员方法：  

    1.OutputStream getOutputStream()：返回此套接字的输出流
    2.InputStream getInputStream()：返回此套接字的输入流
    3.void close()：关闭此套接字

客户端实现步骤：  
1.创建一个客户端对象Socket，构造方法中绑定服务器的IP地址和端口号  
2.使用Socket对象中的方法getOutputStream()获取网络字节输出流OutputStream对象  
3.使用网络字节输出流OutputStream对象中的方法write给服务器发送数据  
4.使用Socket对象中的方法getInputStream()获取网络字节输入流InputStream对象  
5.使用网络字节输入流InputStream对象中的方法read读取服务器返回的数据  
6.释放资源（关闭Socket就可以了）  

注意事项：  
1.客户端和服务器端进行交互必须使用Socket中提供的网络流，不能使用自己创建的流对象  
2.当我们创建客户端对象Socket的时候，就会去请求服务器和服务器经过三次握手建立连接通路；这时如果服务器没有启动，就会抛出异常，如果服务器已经启动，就可以进行交互了  

**四、TCP 通信的服务器端代码实现**  
TCP 通信的服务器端：接收客户端的请求，读取客户端发送的数据，给客户端回写数据  
java.net.ServerSocket：此类实现服务器端套接字  

构造方法：  

    ServerSocket(int port)：创建绑定到指定端口号的服务器套接字

服务器端必须明确一件事情：必须知道是哪个客户端请求的服务器，所以使用accept获取到请求的客户端对象Socket  

成员方法：  

    Socket accept()：侦听并接受到此套接字的连接

服务器的实现步骤：  
1.创建服务器ServerSocket对象，和系统要指定的端口号  
2.使用ServerSocket对象中的方法accept获取到请求的客户端对象Socket  
3.使用Socket对象中的方法getInputStream()获取网络字节输入流InputStream对象  
4.使用网络字节输入流InputStream对象中的方法read读取客户端发送的数据  
5.使用Socket对象中的方法getOutputStream()获取网络字节输出流OutputStream对象  
6.使用网络字节输出流OutputStream对象中的方法write给客户端回写数据  
7.释放资源（关闭Socket、ServerSocket就可以了）  

客户端：Client.java  

```java
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
```

服务器端：Server.java  

```java
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
```