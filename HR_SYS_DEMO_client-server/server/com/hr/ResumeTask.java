package com.hr;

import java.io.*;
import java.net.Socket;

public class ResumeTask implements Runnable{
    private Socket socket = null;
    OutputStream os = null;
    InputStream is = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;

    RequestInfo requestInfo = null;
    private HumanResourceService hr = HumanResourceService.getInstance();

    public ResumeTask(Socket socket){
        this.socket = socket;
        try {
            os = socket.getOutputStream();
            is = socket.getInputStream();
            oos = new ObjectOutputStream(os);
            ois = new ObjectInputStream(is);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while (true){
            if(socket == null || socket.isClosed()){
                System.out.println("连接已关闭");
                break;
            }

            try {
                requestInfo = (RequestInfo) ois.readObject();
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
                }
            }catch (Exception e){
                if(e.toString().equals(new EOFException().toString()));
                try {
                    socket.close();
                }catch (Exception e1){
                    e1.printStackTrace();
                }
                System.out.println("连接关闭");
                break;
            }
        }
        System.out.println("Socket 线程：" + socket.toString() + " 已关闭");
    }
}
