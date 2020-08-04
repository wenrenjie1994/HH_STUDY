package system;

import client.client;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class MainStu {

    public static void main(String[] args) throws Exception {
        // TODO 自动生成的方法存根

        String readline = null;
        String data = null;
        int data1;
        //String outTemp = null;
//        String turnLine = "\n";
        String HOST="192.168.0.102";
        int PORT=50007;

        Socket socket = new Socket(HOST, PORT);


        //创建三个流，系统输入流BufferedReader systemIn，socket输入流BufferedReader socketIn，socket输出流PrintWriter socketOut;
        BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        OutputStream socketOut = socket.getOutputStream();

        while(true){
            System.out.println(111);
            char[] cbuf=new char[1024];
            while((data1=socketIn.read(cbuf, 0, cbuf.length))!=-1)
            {
//                System.out.println(data1);
                System.out.print(new String(cbuf,0,data1));
//                System.out.println(cbuf[0]);
                data= String.valueOf(cbuf[0]);
                System.out.println(data);
                if  (!data.substring(0).equals("-"))
//            # 表示程序结束或出现问题
                {
                    System.out.println(data);
                    readline = systemIn.readLine();
                    //System.out.println(readline);
                    System.out.println(readline);

                    socketOut.write(readline.getBytes(StandardCharsets.UTF_8));
                    socketOut.flush();    //赶快刷新使Server收到，也可以换成socketOut.println(readline, ture)

                }

                else if (data.equals("程序结束！！！感谢使用。")){
//            # -1表示结束本次程序
                    systemIn.close();
                    socketIn.close();
                    socketOut.close();
                    socket.close();
                    break;
                }

            }

            }

    }
}
