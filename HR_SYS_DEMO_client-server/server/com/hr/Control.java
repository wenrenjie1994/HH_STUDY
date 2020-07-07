package com.hr;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
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

        while(socket.isConnected()){
            RequestInfo requestInfo = (RequestInfo) ois.readObject();
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
