import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread {

    private Socket socket;

    public SendThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try {
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            while(true){
                Scanner scanner = new Scanner(System.in);
                String str = scanner.next();
                dataOutputStream.writeUTF(str);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
