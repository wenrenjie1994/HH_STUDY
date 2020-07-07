package com.hr;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import java.io.*;
import java.net.Authenticator;
import java.net.CookieHandler;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.ResultSet;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class UserInterface {
    public UserInterface() throws Exception{
        //建立网络连接
        Socket socket = new Socket("127.0.0.1", 88);
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        ObjectInputStream ois = new ObjectInputStream(is);

        Scanner userInput = new Scanner(System.in);
        System.out.println("输入 1 添加简历\n输入 2 删除简历\n输入 3 查询简历\n输入 4 修改学生信息\n输入 5 退出\n输入 ？ 查询指令");
        String opCode = userInput.next();
        ResultInfo resultInfo = null;
        List<Resume> resultList = null;

        while(!(opCode.charAt(0) == OpType.EXIT.getValue())){
            if(opCode.charAt(0) == OpType.ADD.getValue()){
                System.out.println("当前操作为：添加简历");
                String stdName, stdStatus, stdSchool;
                System.out.println("请输入简历姓名");
                stdName = userInput.next();
                System.out.println("请输入所属学校");
                stdSchool = userInput.next();
                System.out.println("请输入简历状态");
                stdStatus = userInput.next();
                RequestInfo requestInfo = new RequestInfo(OpType.ADD, new Resume(stdName, stdSchool, stdStatus));
                oos.writeObject(requestInfo);
                resultInfo = (ResultInfo) ois.readObject();
                if(resultInfo.getFlag() != 1){
                    System.out.println("操作失败");
                }
                //hr.addStudent(new Resume(stdName, stdSchool, stdStatus));
            }else if(opCode.charAt(0) == OpType.DELETE.getValue()) {
                System.out.println("当前操作为：删除简历");
                System.out.println("请输入简历姓名");
                RequestInfo requestInfo = new RequestInfo(OpType.DELETE, new Resume(userInput.next(), null, null));
                oos.writeObject(requestInfo);
                resultInfo = (ResultInfo) ois.readObject();
                if(resultInfo.getFlag() != 1){
                    System.out.println("操作失败");
                }
            }else if(opCode.charAt(0) == OpType.QUERY.getValue()) {
                System.out.println("当前操作为：查询简历");
                System.out.println("是否列出所有简历信息？ y/n");
                if(userInput.next().equals("n")){
                    System.out.println("请输入简历姓名");
                    RequestInfo requestInfo = new RequestInfo(OpType.QUERY, new Resume(userInput.next(), null, null));
                    oos.writeObject(requestInfo);
                    resultInfo = (ResultInfo) ois.readObject();
                    if(resultInfo.getFlag() != 1){
                        System.out.println("操作失败");
                    }else{
                        resultList = resultInfo.getResultList();
                        if(resultList != null && !resultList.isEmpty() && !resultList.get(0).getStatus().equals("7")){
                            Resume curResume = resultList.get(0);
                            System.out.println("-----------------------------------");
                            System.out.println("简历编号： " + curResume.getId());
                            System.out.println("姓名：" + curResume.getName());
                            System.out.println("所属学校： " + curResume.getSchool());
                            System.out.println("简历状态： " + curResume.getStatus());
                            System.out.println("-----------------------------------");
                            resultList.remove(0);
                        }else{
                            System.out.println("系统中查无此人");
                        }
                    }
                }else{
                    RequestInfo requestInfo = new RequestInfo(OpType.QUERYALL, new Resume(null, null, null));
                    oos.writeObject(requestInfo);
                    resultInfo = (ResultInfo) ois.readObject();
                    if(resultInfo.getFlag() != 1){
                        System.out.println("操作失败");
                    }else{
                        resultList = resultInfo.getResultList();
                        while(!resultList.isEmpty()){
                            if(resultList.get(0).getStatus().equals("7")){
                                continue;
                            }
                            Resume curResume = resultList.get(0);
                            System.out.println("-----------------------------------");
                            System.out.println("简历编号： " + curResume.getId());
                            System.out.println("姓名：" + curResume.getName());
                            System.out.println("所属学校： " + curResume.getSchool());
                            System.out.println("简历状态： " + curResume.getStatus());
                            System.out.println("-----------------------------------");
                            resultList.remove(0);
                        }
                    }
                }
            }else if(opCode.charAt(0) == OpType.MODIFY.getValue()) {
                System.out.println("当前操作为：修改简历");
                String oldName, newName, newStatus, newSchool;
                System.out.println("请输入简历姓名");
                oldName = userInput.next();
                System.out.println("请输入修改后的简历姓名");
                newName = userInput.next();
                System.out.println("请输入修改后的所属学校");
                newSchool = userInput.next();
                System.out.println("请输入修改后的简历状态");
                newStatus = userInput.next();
                RequestInfo requestInfo = new RequestInfo(OpType.MODIFY, new Resume(oldName, null, null), new Resume(newName, newSchool, newStatus));
                oos.writeObject(requestInfo);
                resultInfo = (ResultInfo) ois.readObject();
                if(resultInfo.getFlag() != 1){
                    System.out.println("操作失败");
                }
            }else if(opCode.charAt(0) == OpType.HELP.getValue()) {
                System.out.println("输入 1 添加简历\n输入 2 删除简历\n输入 3 查询简历\n输入 4 修改简历信息\n输入 5 退出\n输入 ？ 查询指令");
            }else {
                System.out.println("无效的指令");
            }
            System.out.println("请输入下一步操作指令");
            opCode = userInput.next();
        }
        oos.close();
        ois.close();
        socket.close();
        System.out.println("再见");
    }
    public static void main(String[] args){
        try{
            new UserInterface();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
