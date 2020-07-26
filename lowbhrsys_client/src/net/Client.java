package net;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    BufferedReader in;
    PrintWriter out;
    Socket socket;

    public Client(){
        try{
            socket = new Socket("127.0.0.1",7777);
            System.out.print("连接上服务器了");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    public static Client getClient(){
        return new Client();
    }
    public String sendMsgToServer(String message){
        String str=null;
        out.println(message);
        System.out.println("向服务器发送："+message);

        try {
            str = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
    public void closeClient(){

        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
