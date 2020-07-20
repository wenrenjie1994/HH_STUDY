package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class LibClient {
    public static void main(String[] args) {
        start();
    }

    public static void start0() {
        String host = "127.0.0.1";
        int port = 45789;
        while (true) {
            try {
                Socket socket = new Socket(host, port);
                OutputStream outputStream = socket.getOutputStream();
                Scanner sc = new Scanner(System.in);
                String wrt = sc.nextLine();
                outputStream.write(wrt.getBytes());
                socket.shutdownOutput();
                InputStream inputStream=socket.getInputStream();
                int len = 0;
                byte[] bt = new byte[1024];
                StringBuffer sb = new StringBuffer();
                while ((len = inputStream.read(bt)) != -1) {
                    sb.append(new String(bt, 0, len));
                }
                System.out.println("response:"+sb);
                inputStream.close();
                outputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void start() {
        String host = "127.0.0.1";
        int port = 45789;
        try {
            while (true) {
                System.out.println("Welcom to my lib");
                System.out.println("press 1 to search book");
                System.out.println("press 2 to add book");
                System.out.println("press 3 to update book");
                System.out.println("press 4 to delete book");
                System.out.println("press 5 to show ALL book");
                System.out.println("press 0 to exit");
                System.out.println("------------------------------");
                Scanner input = new Scanner(System.in);
                int chose = input.nextInt();
                if (chose == 0) {
                    break;
                } else if (chose == 5) {
                    Socket socket = new Socket(host, port);
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write("showAllBook".getBytes());
                    socket.shutdownOutput();
                    InputStream inputStream=socket.getInputStream();
                    int len = 0;
                    byte[] bt = new byte[1024];
                    StringBuffer sb = new StringBuffer();
                    while ((len = inputStream.read(bt)) != -1) {
                        sb.append(new String(bt, 0, len));
                    }
                    System.out.println(sb);
                    inputStream.close();
                    outputStream.close();
                    socket.close();
                } else if (chose == 1) {
                    while (true) {
                        System.out.println("press 1 to search book by bookName");
                        System.out.println("press 2 to search book by bookWriter");
                        System.out.println("press 3 to search book by bookPrice");
                        System.out.println("press 4 to search book by keyWord");
                        System.out.println("press 5 to show ALL book");
                        System.out.println("press 0 to return last step");
                        System.out.println("------------------------------");
                        int chose1 = input.nextInt();
                        if (chose1 == 0) {
                            break;
                        } else if (chose1 == 5) {
                            Socket socket = new Socket(host, port);
                            OutputStream outputStream = socket.getOutputStream();
                            outputStream.write("showAllBook".getBytes());
                            socket.shutdownOutput();
                            InputStream inputStream=socket.getInputStream();
                            int len = 0;
                            byte[] bt = new byte[1024];
                            StringBuffer sb = new StringBuffer();
                            while ((len = inputStream.read(bt)) != -1) {
                                sb.append(new String(bt, 0, len));
                            }
                            System.out.println(sb);
                            inputStream.close();
                            outputStream.close();
                            socket.close();
                        } else if (chose1 == 1) {
                            System.out.println("input bookName");
                            Scanner in = new Scanner(System.in);
                            String bookName = in.nextLine();
                            Socket socket = new Socket(host, port);
                            OutputStream outputStream = socket.getOutputStream();
                            String trans="serchFromBookName/"+bookName;
                            outputStream.write(trans.getBytes());
                            socket.shutdownOutput();
                            InputStream inputStream=socket.getInputStream();
                            int len = 0;
                            byte[] bt = new byte[1024];
                            StringBuffer sb = new StringBuffer();
                            while ((len = inputStream.read(bt)) != -1) {
                                sb.append(new String(bt, 0, len));
                            }
                            System.out.println(sb);
                            inputStream.close();
                            outputStream.close();
                            socket.close();
                            System.out.println("------------------------------");
                        } else if (chose1 == 2) {
                            System.out.println("input bookWriter");
                            Scanner in = new Scanner(System.in);
                            String bookWriter = in.nextLine();
                            Socket socket = new Socket(host, port);
                            OutputStream outputStream = socket.getOutputStream();
                            String trans="serchFromBookWriter/"+bookWriter;
                            outputStream.write(trans.getBytes());
                            socket.shutdownOutput();
                            InputStream inputStream=socket.getInputStream();
                            int len = 0;
                            byte[] bt = new byte[1024];
                            StringBuffer sb = new StringBuffer();
                            while ((len = inputStream.read(bt)) != -1) {
                                sb.append(new String(bt, 0, len));
                            }
                            System.out.println(sb);
                            inputStream.close();
                            outputStream.close();
                            socket.close();
                            System.out.println("------------------------------");
                        } else if (chose1 == 3) {
                            System.out.println("input bookPrice");
                            Scanner in = new Scanner(System.in);
                            String bookPrice = in.nextLine();
                            Socket socket = new Socket(host, port);
                            OutputStream outputStream = socket.getOutputStream();
                            String trans="serchFromBookPrice/"+bookPrice;
                            outputStream.write(trans.getBytes());
                            socket.shutdownOutput();
                            InputStream inputStream=socket.getInputStream();
                            int len = 0;
                            byte[] bt = new byte[1024];
                            StringBuffer sb = new StringBuffer();
                            while ((len = inputStream.read(bt)) != -1) {
                                sb.append(new String(bt, 0, len));
                            }
                            System.out.println(sb);
                            inputStream.close();
                            outputStream.close();
                            socket.close();
                            System.out.println("------------------------------");
                        } else if (chose1 == 4) {
                            System.out.println("input keyWord");
                            Scanner in = new Scanner(System.in);
                            String keyWord = in.nextLine();
                            System.out.println("----------to do list");
                            System.out.println("------------------------------");
                        } else {
                            System.out.println("input err,please try it again");
                        }
                    }
                }
                else if (chose == 2) {
                    System.out.println("input bookName bookWriter and bookPrice(使用“/”隔开)");
                    Scanner in = new Scanner(System.in);
                    String inAll = in.nextLine();
                    Socket socket = new Socket(host, port);
                    OutputStream outputStream = socket.getOutputStream();
                    String trans="addBook/"+inAll;
                    outputStream.write(trans.getBytes());
                    socket.shutdownOutput();
                    InputStream inputStream=socket.getInputStream();
                    int len = 0;
                    byte[] bt = new byte[1024];
                    StringBuffer sb = new StringBuffer();
                    while ((len = inputStream.read(bt)) != -1) {
                        sb.append(new String(bt, 0, len));
                    }
                   if(sb.toString().equals("sucess")){
                       System.out.println("add sucess");
                   }
                    inputStream.close();
                    outputStream.close();
                    socket.close();
                    System.out.println("------------------------------");
                } else if (chose == 3) {
                    System.out.println("input oldBookName newBookName newbookWriter and newbookPrice(使用“/”隔开)");
                    Scanner in = new Scanner(System.in);
                    String inAll = in.nextLine();
                    Socket socket = new Socket(host, port);
                    OutputStream outputStream = socket.getOutputStream();
                    String trans="updateBook/"+inAll;
                    outputStream.write(trans.getBytes());
                    socket.shutdownOutput();
                    InputStream inputStream=socket.getInputStream();
                    int len = 0;
                    byte[] bt = new byte[1024];
                    StringBuffer sb = new StringBuffer();
                    while ((len = inputStream.read(bt)) != -1) {
                        sb.append(new String(bt, 0, len));
                    }
                    if(sb.toString().equals("sucess")){
                        System.out.println("update sucess");
                    }
                    inputStream.close();
                    outputStream.close();
                    socket.close();
                    System.out.println("------------------------------");
                } else if (chose == 4) {
                    System.out.println("input 1/bookName to delete by bookName");
                    System.out.println("input 2/bookWriter to delete by bookWriter");
                    Scanner sc = new Scanner(System.in);
                    String in = sc.nextLine();
                    Socket socket = new Socket(host, port);
                    OutputStream outputStream = socket.getOutputStream();
                    String trans="deleteBook/"+in;
                    outputStream.write(trans.getBytes());
                    socket.shutdownOutput();
                    InputStream inputStream=socket.getInputStream();
                    int len = 0;
                    byte[] bt = new byte[1024];
                    StringBuffer sb = new StringBuffer();
                    while ((len = inputStream.read(bt)) != -1) {
                        sb.append(new String(bt, 0, len));
                    }
                    if(sb.toString().equals("sucess")){
                        System.out.println("delete sucess");
                    }
                    inputStream.close();
                    outputStream.close();
                    socket.close();
                    System.out.println("------------------------------");
                } else {
                    System.out.println("input err,please try it again");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
