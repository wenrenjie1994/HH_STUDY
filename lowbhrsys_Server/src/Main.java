import thread.ServerThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    static ServerSocket ss;
    static Socket socket;
    public Main(){

    }
    public static void main(String[] args) {


        try {
            ss = new ServerSocket(7777);
            System.out.println("服务器已经启动，等到客户端连接中。。。。");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true){
            try {
                socket=ss.accept();
                System.out.println("有客服端连接上了");
                ServerThread t = new ServerThread(socket);
                t.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
