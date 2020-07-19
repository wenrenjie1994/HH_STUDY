package client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
     BufferedReader in;
     PrintWriter out;
     Socket tcpSocket;
     //建立连接
     public Client(){
         try{
             tcpSocket =new Socket("127.0.0.1",8888);
             System.out.println("与服务器连接成功");
             in= new BufferedReader(new InputStreamReader(tcpSocket.getInputStream()));
             out =new PrintWriter(new BufferedWriter(new OutputStreamWriter(tcpSocket.getOutputStream())),true);
         }catch(UnknownHostException e){
             e.printStackTrace();
         }catch (IOException e){
             e.printStackTrace();
         }
     }
     public String sendMessageToServer(String message){
         String str ="";
         try{
             out.println(message);
             System.out.println("向服务器发送："+message);
             str =in.readLine();//服务器返回的消息；
         }catch(IOException e){
             e.printStackTrace();
         }
         return str;
     }
     //关闭客户端和所有连接
     public void closeClient(){
         try{
             in.close();;
             out.close();
             tcpSocket.close();
         }catch(IOException e){
             e.printStackTrace();
         }
     }

}
