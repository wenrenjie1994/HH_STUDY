package sys;

import net.ServerThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HRS_Server {
    ServerSocket socket;
    public void run(){
        try {
            socket = new ServerSocket(6666);
            System.out.println("--------等待用户连接-------");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        while(true){
            try {
                Socket connection = socket.accept();
                System.out.println("-----欢迎进入GLB的图书管理系统-----");
                new Thread(new ServerThread(connection)).start();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        HRS_Server server = new HRS_Server();
        server.run();
    }
}
