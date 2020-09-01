package com.sp.lowbhrsys.server.net;


import com.sp.lowbhrsys.server.ServerRunnable;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: libobo
 * @create: 2020-07-14 19:49
 * @description:
 **/
public class Server {
    /**
     * 线程池
     */
    private static ThreadPoolExecutor threadPool=new ThreadPoolExecutor(5,20, 60,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
    private static ServerSocket ss;
    private Socket connection ;
    public Server()
    {
        try {
            ss = new ServerSocket(8888);
            System.out.println("服务器启动了，等待客户端连接...");
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true)
        {
            try {
                connection = ss.accept();//有Client连接
                System.out.println("有客服端连接上了");
                threadPool.execute(new ServerRunnable(connection));//将该任务放入线程池中
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Server();
    }

}
