package net;

/**
 * @Author lee
 * @Date 2020/7/15 7:23 PM
 **/

import control.Operator;
import model.Resume;
import model.ResumeList;
import model.ReturnResult;
import util.Parser;
import util.Protocol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.io.InputStreamReader;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 1.Open a socket.
 * 2.Open an input stream and output stream to the socket.
 * 3.Read from and write to the stream according to the server's protocol.
 * 4.Close the streams.
 * 5.Close the socket.
 */

public class Client {

    BufferedReader in;// 从Server到Client的输入
    PrintWriter out;// 从Client到Server的输出
    Socket tcpConnection;

    public Client() {
        /**
         * writes to and reads from its socket,
         * thereby sending data to and receiving data from the echo server.
         * client 做两件事：1.去读用户输入 2.接受Server返回结的果
         *
         * 建立Socket连接的同时需要打开两个数据传输通道:PrintWriter和BufferedReader
         * PrintWriter:
         *      gets the socket's output stream.
         *      To send data through the socket to the server,
         *      the client needs to write to the PrintWriter
         * BufferedReader:
         *      gets the socket's input stream.
         *      To get the server's response,
         *      client reads from the BufferedReader object stdIn
         */
        try {
            tcpConnection = new Socket("127.0.0.1", 2020);
            System.out.println("连接上服务器了");
            /**
             * Returns an input stream for this socket.
             */
            in = new BufferedReader(new InputStreamReader(tcpConnection.getInputStream()));

            // 向Server传输数据
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(tcpConnection.getOutputStream())), true);


            Scanner sc = new Scanner(System.in);
            while (true) {
                // 提示语句
                System.out.println("************欢迎来到HR系统************");
                System.out.println("填写简历请按----------1");
                System.out.println("删除简历请按----------2");
                System.out.println("查询简历请按----------3");
                System.out.println("退出系统请按----------4");

                int choice = sc.nextInt();
                if (choice == 1) {
                    addResume();
                } else if (choice == 2) {
                    deleteResume();
                } else if (choice == 3) {
                    searchResume();
                } else if (choice == 4) {
                    closeClient("4");
                    break;
                } else {
                    System.out.println("输入有误，请重新输入！");
                }
            }
//            System.out.println("您已经退出了HR系统");


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void addResume() {
        System.out.println("欢迎来到简历添加界面");
        System.out.println("请依次输入姓名，身份证号和学校");

        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        String id = sc.nextLine();
        String school = sc.nextLine();

        Resume resume = new Resume(name, id, school);

        Protocol protocol = new Protocol();
        String message = protocol.addResumeMessage(resume);
        String returnMessage = sendMessage2Sever(message);
        Parser parser = new Parser();
        ReturnResult rrs = parser.parserAdd(returnMessage);
        if (rrs.isSuccess) {
            System.out.println("成功添加简历");
        } else {
            System.out.println("添加失败");
        }

    }


    void deleteResume() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("************欢迎来到删除简历界面************");
            System.out.println("按姓名删除请按----------1");
            System.out.println("按身份证号删除请按-------2");
            System.out.println("按学校删除请按----------3");
            System.out.println("退出请按---------------4");

            int choice = sc.nextInt();
            if (choice == 1) {
                deleteResumeByName();
            } else if (choice == 2) {
                deleteResumeById();
            } else if (choice == 3) {
                deleteResumeBySchool();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("输入有误，请重新输入！");
            }
        }
    }

    void deleteResumeByName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要删除的简历的姓名");
        String resumeName = sc.nextLine();
        Resume resume = new Resume(resumeName, null, null);

        Protocol protocol = new Protocol();
        String message = protocol.deleteResumeByNameMessage(resume);
        String returnMessage = sendMessage2Sever(message);
        Parser parser = new Parser();
        ReturnResult rrs = parser.parserDelete(returnMessage);
        if (rrs.isSuccess) {
            System.out.println("成功删除简历");
        } else {
            System.out.println("未找到姓名对应的简历，删除失败");
        }

    }

    void deleteResumeById() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要删除的简历的身份证号");
        String resumeId = sc.nextLine();
        Resume resume = new Resume(null, resumeId, null);

        Protocol protocol = new Protocol();
        String message = protocol.deleteResumeByIdMessage(resume);
        String returnMessage = sendMessage2Sever(message);
        Parser parser = new Parser();
        ReturnResult rrs = parser.parserDelete(returnMessage);
        if (rrs.isSuccess) {
            System.out.println("成功删除简历");
        } else {
            System.out.println("未找到身份证号对应的简历，删除失败");
        }
    }

    void deleteResumeBySchool() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要删除的简历的学校");
        String resumeSchool = sc.nextLine();
        Resume resume = new Resume(null, null, resumeSchool);

        Protocol protocol = new Protocol();
        String message = protocol.deleteResumeBySchoolMessage(resume);
        String returnMessage = sendMessage2Sever(message);
        Parser parser = new Parser();
        ReturnResult rrs = parser.parserDelete(returnMessage);
        if (rrs.isSuccess) {
            System.out.println("成功删除简历");
        } else {
            System.out.println("未找到学校对应的简历，删除失败");
        }
    }

    // 查询简历
    void searchResume() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("************欢迎来到查询简历界面************");
            System.out.println("按姓名查询请按----------1");
            System.out.println("按身份证号查询请按-------2");
            System.out.println("按学校查询请按----------3");
            System.out.println("退出请按---------------4");

            int choice = sc.nextInt();
            if (choice == 1) {
                searchResumeByName();
            } else if (choice == 2) {
                searchResumeById();
            } else if (choice == 3) {
                searchResumeBySchool();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("输入有误，请重新输入！");
            }
        }
    }

    void searchResumeByName() {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要查询的简历的姓名");
        String resumeName = sc.nextLine();
        Resume resume = new Resume(resumeName, null, null);

        Protocol protocol = new Protocol();
        String message = protocol.searchResumeByNameMessage(resume);
        String returnMessage = sendMessage2Sever(message);
        Parser parser = new Parser();
        ReturnResult rrs = parser.parserSearch(returnMessage);
        if (rrs.isSuccess) {
            System.out.println("成功查询到姓名对应的简历");
            ResumeList resumeList = (ResumeList) rrs.resultData;
            int count = resumeList.size();
            for (int i = 0; i < count; i++) {
                System.out.println("姓名：" + resumeList.get(i).getName() + "  "
                        + "身份证号：" + resumeList.get(i).getId() + "  "
                        + "学校：" + resumeList.get(i).getSchool() + "  ");
            }
        } else {
            System.out.println("未找到姓名对应的简历，查询失败");
        }
    }

    void searchResumeById() {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要查询的简历的身份证号");
        String resumeId = sc.nextLine();
        Resume resume = new Resume(null, resumeId, null);

        Protocol protocol = new Protocol();
        String message = protocol.searchResumeByIdMessage(resume);
        String returnMessage = sendMessage2Sever(message);
        Parser parser = new Parser();
        ReturnResult rrs = parser.parserSearch(returnMessage);
        if (rrs.isSuccess) {
            System.out.println("成功查询到身份证号对应的简历");
            ResumeList resumeList = (ResumeList) rrs.resultData;
            int count = resumeList.size();
            for (int i = 0; i < count; i++) {
                System.out.println("姓名：" + resumeList.get(i).getName() + "  "
                        + "身份证号：" + resumeList.get(i).getId() + "  "
                        + "学校：" + resumeList.get(i).getSchool() + "  ");
            }

        } else {
            System.out.println("未找到身份证号对应的简历，查询失败");
        }
    }

    void searchResumeBySchool() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要查询的简历的学校");
        String resumeSchool = sc.nextLine();
        Resume resume = new Resume(null, null, resumeSchool);

        Protocol protocol = new Protocol();
        String message = protocol.searchResumeBySchoolMessage(resume);
        String returnMessage = sendMessage2Sever(message);
        Parser parser = new Parser();
        ReturnResult rrs = parser.parserSearch(returnMessage);
        if (rrs.isSuccess) {
            System.out.println("成功查询到学校对应的简历");
            ResumeList resumeList = (ResumeList) rrs.resultData;
            int count = resumeList.size();
            for (int i = 0; i < count; i++) {
                System.out.println("姓名：" + resumeList.get(i).getName() + "  "
                        + "身份证号：" + resumeList.get(i).getId() + "  "
                        + "学校：" + resumeList.get(i).getSchool() + "  ");
            }

        } else {
            System.out.println("未找到学校对应的简历，查询失败");
        }
    }


    private static class clientContainer {
        private static Client client = new Client();
    }


    public static Client getClient() {
        return clientContainer.client;
    }

    public String sendMessage2Sever(String message)//发送字符串去客服端
    {
        String str = "";
        try {
            out.println(message);
            System.out.println("向服务器发送：  " + message);

            // 读取server的返回
            str = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public void closeClient(String str)//关闭客户端并关闭连接
    {
        try {
            sendMessage2Sever(str);
            in.close();
            out.close();
            tcpConnection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client();
    }

}

