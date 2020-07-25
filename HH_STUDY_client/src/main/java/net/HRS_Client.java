package net;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class HRS_Client {
    Socket connection;
    BufferedReader in;
    PrintWriter out;
    public void run(){
        try {
            connection = new Socket("127.0.0.1", 6666);
            System.out.println("-----欢迎进入GLB的图书管理系统-----");
            System.out.println("-----请输入操作指令-----");
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(connection.getOutputStream())),true);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        while(true){
            Scanner input = new Scanner(System.in);
            String sendString = input.nextLine();
            out.println(sendString);
            try {
                String str = in.readLine();
                if(str.equals("bye"))
                    break;
                else
                    System.out.println(str);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        try {
            in.close();
            out.close();
            connection.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HRS_Client client = new HRS_Client();
        client.run();
    }
}
