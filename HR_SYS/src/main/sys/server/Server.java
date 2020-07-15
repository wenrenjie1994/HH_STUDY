package main.sys.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: hqweay
 * @description: Server
 * Created on 7/15/20 12:43 PM
 */
public class Server {
  static ServerSocket serverSocket;
  Socket tcpConnection;
  private int port = 8309;

  private static ExecutorService threadPoolExecutor = new ThreadPoolExecutor(
          4,
          40,
          0L,
          TimeUnit.MILLISECONDS,
          new LinkedBlockingQueue<>(1024)
  );

  public Server() {
    try {
      serverSocket = new ServerSocket(port);
      System.out.println("start server on port :" + port);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void run() {
    while (true) {
      try {
        tcpConnection = serverSocket.accept();
        System.out.println("info: accpet data from client.");
        //  开启线程
        threadPoolExecutor.execute(new Thread(new ServerThread(tcpConnection)));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    new Server().run();
  }
}
