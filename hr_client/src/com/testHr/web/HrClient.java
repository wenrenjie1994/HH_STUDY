package com.testHr.web;

import com.testHr.service.ResumeService;
import com.testHr.service.impl.ResumeServiceImpl;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @description:
 * @author: zeng
 * @modified By:
 */
public class HrClient {
    BufferedReader in;
    PrintWriter out;
    Socket tcpSocket;

    public HrClient(){
        try {
            tcpSocket = new Socket("127.0.0.1",1235);
            System.out.println("----------客户端启动----------");
            //通道已经建立，根据菜单选择结构发送message
            Scanner input = new Scanner(System.in);
            while (true){
                System.out.println("********欢迎来到HR系统 3.0**********");
                System.out.println("---------添加简历请输入1----------");
                System.out.println("---------删除简历请输入2----------");
                System.out.println("---------修改简历请输入3----------");
                System.out.println("---------查找简历请输入4----------");
                System.out.println("---------退出系统请输入5----------");
                ResumeService resumeService = new ResumeServiceImpl();
                in = new BufferedReader(new InputStreamReader(tcpSocket.getInputStream()));
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(tcpSocket.getOutputStream())),true);//输出向服务器端
                int choice = Integer.parseInt(input.nextLine());
                switch (choice){
                    case 1:
                        resumeService.addResume(in,out);
                        break;//直接跳出switch
                    case 2:
                        resumeService.deleteResume(in,out);
                        break;
                    case 3:
                        resumeService.updateResume(in,out);
                        break;
                    case 4:
                        resumeService.queryResume(in,out);
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("您的输入有误，请重新输入！");
                }
                if(choice == 5){
                    resumeService.over(in,out);//同时关闭服务器
                    out.close();
                    in.close();
                    break;//跳出while循环
                }
            }
            input.close();//关闭输入流
            System.out.println("您已经退出招聘系统！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new HrClient();
    }
}
