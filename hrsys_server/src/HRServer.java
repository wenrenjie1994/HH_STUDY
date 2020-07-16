import concurrent.SocketThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 服务器启动类
 */
public class HRServer {

    private int port;

    ThreadPoolExecutor executor;

    public HRServer(int port) {
        this.port = port;
    }

    /**
     * 创建并初始化了线程池，核心线程数为5，最大线程数为10，任务队列长度为5
     * Todo 后期根据实际需求重新确立线程池大小，可通过配置文件与解析器来完成
     *
     * 不断检查是否有新的tcp连接，
     * 由{源ip，源端口，目的ip，目的端口}确定是否为新的tcp连接
     * 为新的socket连接分配线程池资源
     */
    private void run() {
        executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server has started at " + port);
            while (true) {
                Socket socket = server.accept();
                SocketThread socketThread = new SocketThread(socket);
                executor.execute(socketThread);
                System.out.println("New thread has been created, thread id is " + socketThread.getId());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        HRServer server = new HRServer(9001);
        server.run();
    }
}
