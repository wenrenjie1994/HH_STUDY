package operator;

/**
 * @program: HH_STUDY
 * @description:
 * @author: qiu haoran
 * @create: 2020-07-20 16:08
 */
import work.SocketThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String []args)
    {
        //创建一个服务器，并设置端口号为9090
        Server s=new Server();
        s.setServer(9090);
    }
    /**
     * 实现服务器的初始化
     * @param port 端口号
     */
    public void setServer(int port)
    {
        try {
            ServerSocket s=new ServerSocket(port);
            System.out.println("服务器创建成功,端口号为"+port);
            //等待客户端的连接
            Socket client=s.accept();
            processchat(client);


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * 实现服务器的读与写
     * @param client
     */
    public void processchat(Socket client)
    {

        try {
            InputStream in=client.getInputStream();
            OutputStream out=client.getOutputStream();
            BufferedReader bd=new BufferedReader(new InputStreamReader(in));
            //将服务器连接成功的指令发出给客户端。
            String s1="服务器连接成功"+"\r\n";
            out.write(s1.getBytes());
            out.flush();
            //创建服务器子线程进行服务器的写操作
            SocketThread so=new SocketThread(client);
            so.start();
            while(true)
            {   //服务器读取客户端发出的指令即服务器的读操作
                BufferedReader brd=new BufferedReader(new InputStreamReader(in));
                String s = brd.readLine();
                System.out.println("客户端说"+s);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}