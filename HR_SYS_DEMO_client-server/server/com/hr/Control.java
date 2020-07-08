package com.hr;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.Scanner;

public class Control {
    public Control() throws Exception{
        //建立服务连接
        ServerSocket serverSocket = new ServerSocket(88);
        Socket socket = serverSocket.accept();
        OutputStream os = socket.getOutputStream();
        InputStream is = socket.getInputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        ObjectInputStream ois = new ObjectInputStream(is);

        HumanResourceService hr = HumanResourceService.getInstance();

        while(!serverSocket.isClosed()){
            if(socket.isClosed()){
                System.out.println("重新等待连接");
                socket = serverSocket.accept();
                os = socket.getOutputStream();
                is = socket.getInputStream();
                oos = new ObjectOutputStream(os);
                ois = new ObjectInputStream(is);
                continue;
            }
            RequestInfo requestInfo = null;
            try {
                requestInfo = (RequestInfo) ois.readObject();
            }catch (Exception e){
                if(e.toString().equals(new EOFException().toString()));
                socket.close();
                System.out.println("连接关闭");
                continue;
            }
            OpType opCode = requestInfo.getOpType();
            if(opCode == OpType.ADD){
                if(hr.addStudent(requestInfo.getCurResume()) != 1){
                    oos.writeObject(new ResultInfo(0));
                }else {
                    oos.writeObject(new ResultInfo(1));
                }
            }else if(opCode == OpType.DELETE) {
                if(hr.deleteStudent(requestInfo.getCurResume().getName()) != 1){
                    oos.writeObject(new ResultInfo(0));
                }else {
                    oos.writeObject(new ResultInfo(1));
                }
            }else if(opCode == OpType.QUERY) {
                ResultInfo resultInfo = hr.queryStudent(requestInfo.getCurResume().getName());
                if(resultInfo.getFlag() != 1){
                    oos.writeObject(new ResultInfo(0));
                }else{
                    oos.writeObject(resultInfo);
                }
            }else if(opCode == OpType.QUERYALL){
                ResultInfo resultInfo = hr.queryAllResume();
                if(resultInfo.getFlag() != 1){
                    oos.writeObject(new ResultInfo(0));
                }else{
                    oos.writeObject(resultInfo);
                }
            }else if(opCode == OpType.MODIFY) {
                String oldName, newName, newStatus, newSchool;
                oldName = requestInfo.getCurResume().getName();
                newName = requestInfo.getNewResume().getName();
                newStatus = requestInfo.getNewResume().getStatus();
                newSchool = requestInfo.getNewResume().getSchool();
                if(hr.modifyStudent(oldName, newName, newSchool, newStatus) != 1){
                    oos.writeObject(new ResultInfo(0));
                }else {
                    oos.writeObject(new ResultInfo(1));
                }
            }else {
                //TODO
            }
        }
        hr.storeResume();
        oos.close();
        ois.close();
        socket.close();
        serverSocket.close();
    }
    public static void main(String[] args){
        try {
            new Control();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
