package net;

import bean.Book;
import service.BookDBServiceImpl;
import util.Parser;
import util.Protocol;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ServerThread implements Runnable{
    private Socket socket;
    private static BufferedReader in;
    private static PrintWriter out;
    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while(true){
            String string = null;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                string = in.readLine();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            if(string.equals("bye")){
                out.println("bye");
                try {
                    in.close();
                    out.close();
                    socket.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                break;
            }else {
                Parser parser = new Parser(new BookDBServiceImpl());
                List<Book> bookList = parser.parse(string);
                String sendString = new Protocol().encoding(bookList);
                out.println(sendString);
            }
        }
    }
}
