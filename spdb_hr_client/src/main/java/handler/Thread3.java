package handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by guyaren
 */
public class Thread3 extends Thread {
    public void run(){
        String Address = "127.0.0.1";
        int Port = 6666;
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try{
            socket = new Socket(Address,Port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            String response = in.readLine();
            System.out.println(response);
            out.println("3&0&06,abc,cqu_07,asd,cqu");
            response = in.readLine();
            System.out.println(response);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
