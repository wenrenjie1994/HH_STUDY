package test;

import bean.Book;
import database.action;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Test1 {
//    public static void main(String[] args){
//        action1();
//        serv();
//    }

    public static void serv(){
        int port=45789;
        try{
            ServerSocket serverSocket=new ServerSocket(port);
            System.out.println("服务器已开启，等待命令传输");
            Socket socket=serverSocket.accept();
            InputStream inputStream=socket.getInputStream();
            int len=0;
            byte[] bt=new byte[1024];
            StringBuffer sb=new StringBuffer();
            while((len=inputStream.read(bt))!=-1){
                sb.append(new String(bt,0,len));
            }
            System.out.println("命令:"+sb);
            inputStream.close();
            socket.close();
            serverSocket.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void action1(){
        action.serchFromBookName("how to get away with murder");
        action.serchFromBookWriter("mozz");
        action.serchFromBookPrice(999);
    }

    public static void action2(){
        Book book1=new Book("red and white","siyant",699);
        Book book2=new Book("soul","lee",567);
        action.addBook(book1);
        action.addBook(book2);
    }

    public static void action3(){
        action.updateBook("sword","sword4","ashmore",888);
        action.showBookAll();
    }
    public static void action4(){
        action.deleteBook(1,"sword4");
        action.deleteBook(2,"lee");
        action.showBookAll();
    }
}
