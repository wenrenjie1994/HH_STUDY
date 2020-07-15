package com.lihang.server;

import com.lihang.pojo.Response;
import com.lihang.util.Parse;

import java.io.*;
import java.net.Socket;


/**
 * Created by IntelliJ IDEA.
 *
 * @author: LI
 * Date: 2020/7/14
 */
public class MyServerThread extends Thread{
    private Socket socket;
    private BufferedReader reader = null;
    private PrintWriter writer = null;
    private String message = null;
    private Operation operation = new Operation();
    private OutputStreamWriter ow = null;

    @Override
    public void run() {
        while (true){
            try {
                if (socket.isClosed()){
                    break;
                }
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                this.message = reader.readLine();
                if ("exit".equalsIgnoreCase(message)){
                    System.out.println("客户端请求断开连接");
                    sayBy();
                    socket.close();
                    break;
                }else {
                    Response response = operation.oprate(message);
                    String reback = Parse.responseToString(response);
                    ow = new OutputStreamWriter(socket.getOutputStream());
                    writer = new PrintWriter(ow);
                    writer.println(reback+"\n");
                    writer.flush();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    ow.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                writer.close();
            }
        }

    }

    public MyServerThread(Socket socket) {
        this.socket = socket;
    }

    public void sayBy(){
        try {
            ow = new OutputStreamWriter(socket.getOutputStream());
            writer = new PrintWriter(ow);
            writer.println("accept exit\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                ow.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            writer.close();
        }
    }

}
