package servece;

import bean.Book;
import bean.BookList;
import database.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;

public class Server {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        int port = 45789;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("服务器已开启，等待命令传输");
            while(true){
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                int len = 0;
                byte[] bt = new byte[1024];
                StringBuffer sb = new StringBuffer();
                while ((len = inputStream.read(bt)) != -1) {
                    sb.append(new String(bt, 0, len));
                }
                System.out.println("接收到指令:" + sb);
                if(sb.toString().equals("showAllBook")){
                    OutputStream outputStream=socket.getOutputStream();
                    BookList bl = action.showBookAll();
                    Iterator<Book> it = bl.iterator();
                    StringBuffer allBook=new StringBuffer();
                    while (it.hasNext()) {
                        allBook.append(it.next().toString()+"\n");
                    }
                    outputStream.write(allBook.toString().getBytes());
                    outputStream.close();
                    inputStream.close();
                    socket.close();
                    System.out.println(allBook);
                    System.out.println("---------------------------------");
                }else if(sb.toString().contains("serchFrom")){
                    String[] bookDetail=sb.toString().split("/");
                    OutputStream outputStream=socket.getOutputStream();
                    BookList bl=new BookList();
                    if(sb.toString().contains("BookName")){
                        bl = action.serchFromBookName(bookDetail[1]);
                    }else if(sb.toString().contains("BookWriter")){
                        bl = action.serchFromBookWriter(bookDetail[1]);
                    }else if(sb.toString().contains("BookPrice")){
                        bl = action.serchFromBookPrice(Double.parseDouble(bookDetail[1]));
                    }else{
                        System.out.println("err input");
                    }
                    Iterator<Book> it = bl.iterator();
                    StringBuffer allBook=new StringBuffer();
                    while (it.hasNext()) {
                        allBook.append(it.next().toString()+"\n");
                    }
                    outputStream.write(allBook.toString().getBytes());
                    outputStream.close();
                    inputStream.close();
                    socket.close();
                    System.out.println(allBook);
                    System.out.println("---------------------------------");
                }else if(sb.toString().contains("addBook")){
                    String[] bookDetail=sb.toString().split("/");
                    Book addbook = new Book(bookDetail[1], bookDetail[2], Double.parseDouble(bookDetail[3]));
                    if(action.addBook(addbook)){
                        OutputStream outputStream=socket.getOutputStream();
                        outputStream.write("sucess".getBytes());
                        outputStream.close();
                    };
                    inputStream.close();
                    socket.close();
                    System.out.println("---------------------------------");
                }else if(sb.toString().contains("updateBook")){
                    String[] bookDetail=sb.toString().split("/");
                    if(action.updateBook(bookDetail[1], bookDetail[2], bookDetail[3], Double.parseDouble(bookDetail[4]))){
                        OutputStream outputStream=socket.getOutputStream();
                        outputStream.write("sucess".getBytes());
                        outputStream.close();
                    };
                    inputStream.close();
                    socket.close();
                    System.out.println("---------------------------------");
                }else if(sb.toString().contains("delete")){
                    String[] bookDetail=sb.toString().split("/");
                    if(action.deleteBook(Integer.parseInt(bookDetail[1]),bookDetail[2])){
                        OutputStream outputStream=socket.getOutputStream();
                        outputStream.write("sucess".getBytes());
                        outputStream.close();
                    };
                    inputStream.close();
                    socket.close();
                    System.out.println("---------------------------------");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
