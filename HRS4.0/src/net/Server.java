/**
 * projectName: HRS4.0
 * fileName: Server.java
 * packageName: net
 * date: 2020-07-17 11:50
 * copyright(c) tianyifan
 */
package net;

import thread.ServerThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @version: V4.0
 * @author: tianyifan
 * @className: Server
 * @packageName: net
 * @description: 客户端类
 * @date: 2020-07-17 11:50
 **/
public class Server {
    private static ServerSocket serverSocket;//服务器端对象
    private static ExecutorService executorService;//线程池工程
    private Socket tcpConnection;//TCP连接

    /**
     *@title: Server
     *@description: 构造方法
     *@author: tianyifan
     *@date: 2020-07-19 11:05
     *@param: 无
     *@return: 无
     *@throws: 无
     */
    public Server() throws IOException {
        serverSocket = new ServerSocket(8888);//创建服务器和系统指定的端口号
        executorService = Executors.newFixedThreadPool(5);//生产一个有5个线程的线程池
        System.out.println("服务器启动，线程池创建成功，等待客户端连接。。。");

        while(true){
            tcpConnection = serverSocket.accept();//获取到请求的客户端对象连接
            System.out.println("客户端连接成功");
            executorService.submit(new ServerThread());//调用submit()方法，传递线程任务（实现类），开启线程，执行run()方法
        }
    }

    public static void main(String[] args){
        try {
            new Server();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
