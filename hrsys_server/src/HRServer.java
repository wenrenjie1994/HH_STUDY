import concurrent.SocketThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HRServer {

    private int port;

    public HRServer(int port) {
        this.port = port;
    }

    private void run() {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server has started at " + port);
            while (true) {
                Socket socket = server.accept();
                SocketThread socketThread = new SocketThread(socket);
                socketThread.start();
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
