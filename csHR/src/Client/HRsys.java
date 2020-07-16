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

                if (choice == 1) {
                    //  DataOperate.saveCandidate(candidateList);
                    System.out.println("请用逗号隔开，分别输入姓名，年龄，学历");
                 String add =  input.next();
                 String newadd = choice+"#"+add;
                    doc.writeUTF(newadd);
                    String res = in.readUTF();
                    System.out.println(res);
                }
                if (choice == 2) {
                    //  DataOperate.saveCandidate(candidateList);
                    System.out.println("请输入要删除的简历的姓名");
                    String add =  input.next();
                    String delename = choice+"#"+add;
                    doc.writeUTF(delename);
                    String res = in.readUTF();
                    System.out.println(res);
                }
                if (choice == 3) {
                    //  DataOperate.saveCandidate(candidateList);
                    System.out.println("请用逗号隔开，输入要更新的人的姓名，年龄，学历");
                    String add =  input.next();
                    String change = choice+"#"+add;
                    doc.writeUTF(change);
                    String res = in.readUTF();
                    System.out.println(res);
                }
                if (choice == 4) {
                    //  DataOperate.saveCandidate(candidateList);

                    String show = ""+choice+"#"+"123";
                    doc.writeUTF(show);
                    String res = in.readUTF();
                    System.out.println(res);
                }
                if(choice==5){
                    doc.close();
                    in.close();
                    break;
                }
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

