import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
//    public static void main(String[] args) {
//        try {
//            //服务端打开端口8888
//            ServerSocket serverSocket = new ServerSocket(8888);
//            //System.out.println("监听在端口号：8888");
//            Socket socket = serverSocket.accept();
//            //System.out.println("有连接过来"+socket);
//
//            //打开输入流
//            InputStream inputStream = socket.getInputStream();
//
////            int msg = inputStream.read();
////            System.out.println(msg);
////            inputStream.close();
//
//            //接收字符串
//            DataInputStream dataInputStream = new DataInputStream(inputStream);
//            String msg = dataInputStream.readUTF();
//            System.out.println(msg);
//            dataInputStream.close();
//
//
//            socket.close();
//            serverSocket.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();

            //启动发送消息线程
            new SendThread(socket).start();
            //启动接收消息线程
            new ReceiveThread(socket).start();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
