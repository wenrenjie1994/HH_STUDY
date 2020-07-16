package Server;
import java.io.*;
import java.net.*;
public class Server {
    public static void main(String[] args) {
        Server manager = new Server();
        manager.doListen();
    }

    public void doListen() {
        ServerSocket server;
        try {
            server = new ServerSocket(9991);
            while (true) {
                Socket client = server.accept();
                new Thread(new SSocket(client)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //服务器进程
    class SSocket implements Runnable {

        Socket client;

        public SSocket(Socket client) {
            this.client = client;
        }

        public void run() {
            DataInputStream input;
            DataOutputStream output;
            while(true) {
                try {
                    input = new DataInputStream(client.getInputStream());
                    output = new DataOutputStream(client.getOutputStream());
                    String listMsg = input.readUTF();
                    Parse pa = new Parse(listMsg);
                    String head = pa.gethead();
                    //System.out.println(head);
                    String content = pa.getcontent();
                    System.out.println(content);
                    if (head.equals("1")) {
                        JDBC.addCandidate(content);
                        output.writeUTF("add success");

                    }
                    if (head.equals("2")) {
                        JDBC.deleteCandidate(content);
                        output.writeUTF("delete success");

                    }
                    if (head.equals("3")) {
                        JDBC.updateCandidate(content);
                        output.writeUTF("update success");

                    }
                    if (head.equals("4")) {
                       String a = JDBC.showCandidate();
                        output.writeUTF(a);

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
