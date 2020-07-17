package service;

import en.OperationEnum;
import en.StatusEnum;
import model.Request;
import model.Response;
import model.Resume;

import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @Author: chenlei
 * @Date: 2020/7/16 17:20
 */
public class ClientService {
    private static String ip;
    private static int port;
    public void run() {
        System.out.println("欢迎使用HR系统");
        Scanner scanner = new Scanner(System.in);
//        System.out.println("请选择服务端ip地址\n 1:本机ip\n2:自定义ip");
//        int type = scanner.nextInt();
//        if(type == 1) {
//            ip = "127.0.0.1";
//        }else {
//            System.out.println("请输入ip");
//            ip = scanner.nextLine();
//        }
//        System.out.println("请输入服务器端口\n 1:8081\n2:输入端口");
//        type = scanner.nextInt();
//        if(type == 1) {
//            port = 8081;
//        }else {
//            port = scanner.nextInt();
//        }
        ip = "127.0.0.1";
        port = 8081;

        Boolean flag = true;
        while (flag) {
            System.out.println("增加简历请按----1");
            System.out.println("删除简历请按----2");
            System.out.println("修改简历请按----3");
            System.out.println("查询简历请按----4");
            System.out.println("查询所有简历请按--5");
            System.out.println("退出请按--------0");
            int choice = scanner.nextInt();
            Request request = null;
            if(choice == 0) {
                System.out.println("bye");
                flag = false;
            } else if(choice == OperationEnum.ADD.getCode()) {
                Resume resume = buildResume();
                request = new Request(OperationEnum.ADD.getCode(),resume);
            }else if(choice == OperationEnum.DELETE.getCode()){
                System.out.println("请输入删除的简历的名称");
                String name;
                name = scanner.next();
                request = new Request(OperationEnum.DELETE.getCode(),name);
            }else if(choice == OperationEnum.UPDATE.getCode()) {
                System.out.println("请输入修改后的用户信息");
                Resume resume = buildResume();
                request = new Request(OperationEnum.UPDATE.getCode(),resume);
            }else if(choice == OperationEnum.SELECT.getCode()){
                System.out.println("请输入查询的简历的名称");
                String name;
                name = scanner.next();
                request = new Request(OperationEnum.SELECT.getCode(),name);
            }else if(choice == OperationEnum.SELECT_ALL.getCode()){
                request = new Request(choice,null);
            }else {
                System.out.println("请输入正确的选项");
            }
            sendRequest(request);
        }
        scanner.close();
    }

    private void sendRequest(Request request) {
        Socket socket;
        try {
            System.out.println("客户端在" + ip + ":" + port + "发起请求");
            socket = new Socket(ip,port);
            socket.setSoTimeout(10000);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(request);
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            Object response = inputStream.readObject();
            outputStream.close();
            inputStream.close();
            if(response instanceof Response) {
                print((Response)response);
            }else{
                System.out.println("系统错误");
            }
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private void print(Response response) {
        if(response == null) {
            System.out.println("系统开小差啦");
            return;
        }
        if(response.getStatus().getCode() == StatusEnum.SUCCESS.getCode()) {
            switch (response.getOperation().getCode()) {
                case 1: case 2 : case 3:
                    System.out.println(response.getOperation().getOperation() + "成功");
                    break;
                case 4:
                    Object o = response.getData();
                    Resume r = (Resume) o;
                    System.out.println(response.getOperation().getOperation() + "成功");
                    System.out.println(r.toString());
                    break;
                case 5:
                    List<Resume> resumeList = (List<Resume>) response.getData();
                    System.out.println(response.getOperation().getOperation() + "成功");
                    for(Resume resume : resumeList) {
                        System.out.println(resume.toString());
                    }
                    break;
                default:
                    System.out.println("返回值错误");
            }
        }else{
            System.out.println(response.getStatus().getMessage());
        }
    }

        private Resume buildResume() {
        System.out.println("请依次输入姓名、职业、年龄");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String job = scanner.nextLine();
        Integer year = scanner.nextInt();
        return new Resume(name,year,job);
    }
}
