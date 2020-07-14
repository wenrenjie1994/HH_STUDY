package com.lihang;

import java.io.*;
import java.net.Socket;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: LI
 * Date: 2020/7/14
 */
public class MyClient {
    private final String host = "127.0.0.1";
    private final Integer port = 8088;
    private Socket socket;
    private BufferedReader br = null;
    private PrintWriter pw = null;
    private InputStreamReader in = null;
    public MyClient()  {

            try {
                socket = new Socket(host,port);
                System.out.println("服务器连接成功：请输入操作，格式（add/name,id,school）");
                in = new InputStreamReader(System.in);
                br = new BufferedReader(in);
                String message = br.readLine();
                pw = new PrintWriter(socket.getOutputStream());
                pw.println(message);
                pw.flush();

                in = new InputStreamReader(socket.getInputStream());
                br = new BufferedReader(in);
                String info = null;
                while((info = br.readLine())!= null){
                    System.out.println("Server reback:"+info);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                pw.close();
                try {
                    br.close();
                    in.close();
                    pw.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }


        }

    }
}
