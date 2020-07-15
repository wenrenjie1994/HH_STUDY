package Client;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class HRsys {

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 9991);
            //向服务器端第一次发送字符串
            OutputStream netOut = socket.getOutputStream();
            DataOutputStream doc = new DataOutputStream(netOut);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            Scanner input = new Scanner(System.in);
            //   DataOperate.loadData(candidateList);
            while (true) {
                System.out.println("************张某人基于数据库的HR管理系统************");
                System.out.println("增加应聘者请按----------1");
                System.out.println("删除应聘者请按----------2");
                System.out.println("修改应聘者请按----------3");
                System.out.println("查询应聘者请按----------4");
                System.out.println("退出请按--------------5");
                //if语句指令判断
                int choice = input.nextInt();

                if (choice == 5) {
                    //  DataOperate.saveCandidate(candidateList);
                    System.out.println("您已退出简历管理系统");
                    break;
                }
                else

                //向服务器端第二次发送字符串
                doc.writeUTF("list");
                String res = in.readUTF();
                System.out.println(res);
                doc.writeUTF("bye");
                res = in.readUTF();
                System.out.println(res);
                doc.close();
                in.close();
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }
    }

