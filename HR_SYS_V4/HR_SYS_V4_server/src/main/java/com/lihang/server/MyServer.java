package com.lihang.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: LI
 * Date: 2020/7/14
 */
public class MyServer {
    private ServerSocket serverSocket;
    Socket socket = null;

    public void run() {
        try {
            serverSocket = new ServerSocket(8088);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BlockingQueue<Runnable> bq = new ArrayBlockingQueue<>(10);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,5,50,TimeUnit.MICROSECONDS,bq);
        while (true){
            try {
                socket = serverSocket.accept();
                MyServerThread dealServer = new MyServerThread(socket);
                executor.execute(dealServer);
                System.out.println("创建线程:"+dealServer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}
