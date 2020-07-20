package hr_sys;

import Handler.HrHandler;
import tool.HandlerExecutorPool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by guyaren
 */
public class HRS_Service {
    final static int Port = 6666;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(Port);
        System.out.println("服务端启动");
        Socket socket = null;
        HandlerExecutorPool executorPool = new HandlerExecutorPool(50,1000);
        while (true){
            socket = serverSocket.accept();
            System.out.println("客户端地址："+socket.getInputStream()+" 连接服务器");
            executorPool.execute(new HrHandler(socket));

        }
    }
}
