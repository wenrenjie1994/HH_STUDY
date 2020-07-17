import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 代表客户端
 */
public class TCPClient {

    public static void main(String[] args) {


        Socket socket;

        try {
            socket = new Socket("127.0.0.1", 8888);
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            while (true) {
                String url = getUrl();
                System.out.println("1、" + url);
                //获取用户想要进行的操作。传输到服务器端
                dos.writeUTF(url);
                //获取了服务器返回的输出，把输入剥一下，如果有多个字符串就分行打印
                String[] strings = dis.readUTF().split("/n");
                for (String s1 : strings) {

                    System.out.println(s1);
                }

                System.out.println("jieshu--------------");


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getUrl() {
        System.out.println("输入1录入招聘者");
        System.out.println("输入2查询招聘者");
        System.out.println("输入3删除招聘者");
        System.out.println("输入4更改招聘者");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if (choice == 1) {
            return getInsertUrl();
        } else if (choice == 2) {
            return getSelectUrl();
        } else if (choice == 3) {
            return getDeleteUrl();
        } else if (choice == 4) {
            return getUpdateUrl();
        } else {
            return getInsertUrl();
        }

    }

    public static String getInsertUrl() {


        String url = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("输入招聘者姓名");
        String name = sc.nextLine();//获得学生姓名
        System.out.println("输入招聘者身份证号");
        String id = sc.nextLine();//获得学生身份证号
        System.out.println("输入招聘者学校");
        String school = sc.nextLine();
        url = "1" + "/n" + name + "/n" + id + "/n" + school;

        return url;
    }

    public static String getDeleteUrl() {
        String url = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("输入招聘者身份证号");
        String id = sc.nextLine();//获得学生身份证号
        url = "3" + "/n" + id;

        return url;
    }

    public static String getSelectUrl() {
        String url = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("根据身份证查询请输入1");
        System.out.println("根据姓名查询请输入2");
        System.out.println("根据学校查询请输入3");
        System.out.println("根据状态查询请输入4");
        int choice = Integer.parseInt(sc.nextLine());
        if (choice == 1) {
            System.out.println("输入需要查询的招聘者的身份证号");
            String id = sc.nextLine();//获得学生身份证号
            url = "2" + "/n" + choice + "/n" + id;
        } else if (choice == 2) {
            System.out.println("输入需要查询的招聘者的姓名");
            String name = sc.nextLine();
            url = "2" + "/n" + choice + "/n" + name;
        } else if (choice == 3) {
            System.out.println("输入需要查询的招聘者的学校");
            String school = sc.nextLine();
            url = "2" + "/n" + choice + "/n" + school;
        } else if (choice == 4) {
            System.out.println("输入需要查询的招聘者的状态");
            int process = sc.nextInt();
            url = "2" + "/n" + choice + "/n" + process;
        }

        return url;
    }

    public static String getUpdateUrl() {
        String url = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("输入需要更改的招聘者的身份证号");
        String id = sc.nextLine();//获得学生身份证号
        System.out.println("请依次输入学生的姓名，学校，状态");
        String name = sc.nextLine();
        String school = sc.nextLine();
        int process = Integer.parseInt(sc.nextLine());
        url = "3" + "/n" + id + "/n" + name + "/n" + school + "/n" + process;

        return url;
    }
}
