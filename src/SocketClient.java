import bean.Resume;
import sys.HRS;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
    public static void main(String[] args) throws IOException {
        int port = 8888;
        String ip = "127.0.0.1";
        Scanner sc = new Scanner(System.in);
        BufferedReader br = null;
        PrintWriter pw = null;
        String buf = null;

        try {
            //1.创建一个客户端对象Socket,构造方法绑定服务器的IP地址和端口号
            Socket socket = new Socket(ip, port);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("try to connect server " + ip + ": " + port);
            System.out.println("ready");

            while (true) {
                System.out.println("-----欢迎进入lowB简历管理系统-----");
                System.out.println("添加简历请按----1");
                System.out.println("删除简历请按----2");
                System.out.println("修改简历请按----3");
                System.out.println("查询简历请按----4");
                System.out.println("退出请按--------5");
                int operate = Integer.parseInt(sc.nextLine());
                switch (operate){
                    case 1:
                        System.out.println("欢迎进入添加简历界面");
                        System.out.println("请依次输入简历需要添加的信息，格式: '姓名 身份证 学校'");
                        //通过socket发送到服务端
                        buf = "1 " + sc.nextLine();
                        pw.println(buf);
                        pw.flush();
                        //操作完成后，打印服务器给的反馈信息
                        System.out.println("server: " + br.readLine());
                        break;
                    case 2:
                        System.out.println("欢迎进入删除简历界面");
                        System.out.println("请输入需要删除简历的身份证");
                        //通过socket发送到服务端
                        buf = "2 " + sc.nextLine();
                        pw.println(buf);
                        pw.flush();
                        //操作完成后，打印服务器给的反馈信息
                        System.out.println("server: " + br.readLine());
                        break;
                    case 3:
                        System.out.println("欢迎进入修改简历界面");
                        System.out.println("请输入需要修改简历的身份证");
                        buf = "3 " + sc.nextLine();
                        pw.println(buf);
                        pw.flush();
                        //提示没有该用户或者输入修改的内容
                        System.out.println("server: " + br.readLine());
                        buf = sc.nextLine();
                        pw.println(buf);
                        pw.flush();

                        //操作完成后，打印服务器给的反馈信息
                        System.out.println("server: " + br.readLine());
                        break;
                    case 4:
                        System.out.println("欢迎进入查询简历界面");

                        System.out.println("身份证查询请按------1");
                        System.out.println("姓名查询请按------2");
                        System.out.println("学校查询请按------3");
                        System.out.println("查询全部请按------4");
                        System.out.println(" 退  出 请按------5");
                        buf = sc.nextLine();
                        int choose = Integer.parseInt(buf);
                        if (choose==1){
                            System.out.println("请输入需要查询简历的身份证");
                            buf = "4 1 " + sc.nextLine();
                            pw.println(buf);
                            pw.flush();
                        }else if (choose==2){
                            System.out.println("请输入需要查询简历的姓名");
                            buf = "4 2 " + sc.nextLine();
                            pw.println(buf);
                            pw.flush();
                        }else if (choose==3){
                            System.out.println("请输入需要查询简历的学校");
                            buf = "4 3 " + sc.nextLine();
                            pw.println(buf);
                            pw.flush();
                        }else if(choose==4){
                            System.out.println("请输入需要查询简历的全部信息");
                            buf = "4 4 " + sc.nextLine();
                            pw.println(buf);
                            pw.flush();
                        }else if (choose==5){
                            return;
                        }else {
                            System.out.println("输入错误");
                        }

                        //操作完成后，打印服务器给的反馈信息
                        System.out.println("server: " + br.readLine());
                        break;
                    case 5:
                        System.out.println("欢迎下次使用");
                        sc.close();
                        return;

                    default:
                        System.out.println("输入错误请重新输入");
                }


            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        //close
        br.close();
        pw.close();
        sc.close();
    }
}
