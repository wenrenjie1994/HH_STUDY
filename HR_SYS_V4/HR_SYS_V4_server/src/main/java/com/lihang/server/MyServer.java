package com.lihang.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
        while (true){
            try {
                socket = serverSocket.accept();
                MyServerThread dealServer = new MyServerThread(socket);
                dealServer.start();
                System.out.println("创建线程:"+dealServer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}
