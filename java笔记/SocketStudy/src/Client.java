import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
//    public static void main(String[] args) {
//        try {
//            Socket socket = new Socket("127.0.0.1",8888);
//            //System.out.println(socket);
//            //打开输出流
//            OutputStream outputStream = socket.getOutputStream();
//            //发送110到服务器端
//            //outputStream.write(110);
//
//            //发送字符串
//            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
//            //dataOutputStream.writeUTF("Legendary");
//            //使用Scanner从控制台输入
//            Scanner scanner = new Scanner(System.in);
//            String str = scanner.next();
//            dataOutputStream.writeUTF(str);
//
//            dataOutputStream.close();
//
//            //outputStream.close();
//            socket.close();
//        }catch (UnknownHostException e){
//            e.printStackTrace();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }


    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            new SendThread(socket).start();
            new ReceiveThread(socket).start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
